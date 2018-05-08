package actors;

import akka.actor.AbstractActorWithTimers;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.stream.Materializer;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import akka.util.ByteString;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.oauth.OAuth;
import play.libs.oauth.OAuth.OAuthCalculator;
import play.libs.ws.WSClient;
import play.libs.ws.WSResponse;
import play.mvc.Http;
import services.TwitterAuthHelper;
import services.TwitterProfileService;
import java.nio.charset.Charset;
import java.util.concurrent.CompletionStage;

import static org.apache.commons.codec.CharEncoding.UTF_8;

public class TwitterStreamerActor extends AbstractActorWithTimers {

    private String SEARCH_KEYWORD = "india";

    private WSClient wsClient;
    private HttpExecutionContext httpExecutionContext;
    private ActorRef printerActor;
    private Materializer materializer;
    private OAuth.ConsumerKey consumerKey = new OAuth.ConsumerKey(TwitterAuthHelper.consumerKey, TwitterAuthHelper.consumerSecretKey);
    private OAuth.RequestToken requestToken = new OAuth.RequestToken(TwitterAuthHelper.accessToken, TwitterAuthHelper.accessTokenSecret);

    /**
     *
     */
    static public class RegisterActor {

    }

    /**
     * Twitter Streamer Actor class constructor
     * @param wsClient
     * @param httpExecutionContext
     * @param materializer
     */
    public TwitterStreamerActor(WSClient wsClient, HttpExecutionContext httpExecutionContext, Materializer materializer) {
        this.wsClient = wsClient;
        this.httpExecutionContext = httpExecutionContext;
        this.materializer = materializer;
    }

    /**
     * Props to create actor ref for TwitterStreamer class
     * @param wsClient webSocket client instance
     * @param httpExecutionContext execution context for http
     * @param materializer materializer instance for sink/fold usage
     * @return returns creation of TwitterStreamer actor
     */
    public static Props props(WSClient wsClient, HttpExecutionContext httpExecutionContext, Materializer materializer) {
        return Props.create(TwitterStreamerActor.class, wsClient, httpExecutionContext, materializer);
    }


    /**
     * Listens for incoming messages and registers the
     * sender in this class
     * @return
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(RegisterActor.class, msg -> registerActor(sender())).build();
    }

    /**
     * Registers the printer actor to send messages
     * @param actor
     */
    private void registerActor(ActorRef actor) {
        printerActor = actor;
        Logger.info("Actor initialized...");
        Logger.info("Connecting...");
        connect();
    }




    /**
     * Makes the connection to the Twitter using the Authorization credentials
     */
    private void connect() {

        OAuthCalculator oAuthCalculator = new OAuthCalculator(consumerKey, requestToken);

        if (oAuthCalculator == null) {
            Logger.info("oAuthCalculator is null");
        }

        if (printerActor == null) {
            Logger.info("Actor is null");
        }

        if (wsClient == null) {
            Logger.error("wsClient is null");
        }

        fetchTweets(SEARCH_KEYWORD, oAuthCalculator);
    }


    /**
     *  Makes a connection to the Twitter Streaming API and accepts tweet response asynchronously.
     *  If the connection is successful, it sends the response to the PrinterActor's TweetMessage protocol class
     *  else it logs a failed request response.
     * @param searchKeyword keyword used to filter tweets
     * @param oAuthCalculator OAuth object
     */
    private void fetchTweets(String searchKeyword, OAuthCalculator oAuthCalculator) {

        sendToActor("Fetching tweets for keyword: " + SEARCH_KEYWORD);

        final CompletionStage<WSResponse> futureResponse = wsClient.url(TwitterProfileService.streamingUrl)
                .sign(oAuthCalculator)
                .setMethod(TwitterProfileService.methodType)
                .addQueryParameter("track", searchKeyword)
                .stream();

        futureResponse.thenApplyAsync(response -> {
            if (response.getStatus() == Http.Status.OK) {

                Logger.info("onResponse... SUCCESS " + response.getStatus());

                Source<ByteString, ?> responseBody = response.getBodyAsSource();

                responseBody.runWith(Sink.foreach(byteStringTweetRecord -> {
                    sendToActor("#-> " + byteStringTweetRecord.decodeString(Charset.forName(UTF_8)));
                }), materializer);

                return response;
            } else {
                Logger.error("onResponse... FAILED " + response.getStatus());
                Logger.error("onResponse... FAILED " + response.getBody());
                return null;
            }
        }, httpExecutionContext.current());

    }


    /**
     * A Wrapper method that sends the message to the Printer Actor.
     * @param message tweet response recieved.
     */
    private void sendToActor(String message) {
        PrinterActor.TweetMessage tweetMessage = new PrinterActor.TweetMessage(message);
        printerActor.tell(tweetMessage, self());
    }

}