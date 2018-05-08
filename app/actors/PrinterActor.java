package actors;


import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.Logger;
import play.libs.Json;

public final class PrinterActor extends AbstractActor {

    private final ActorRef actorRefWebSocket;

    /**
     *Printer Actor constructor
     *
     * @param actorRef
     */
    public PrinterActor(final ActorRef actorRef) {
        actorRefWebSocket = actorRef;
    }

    /**
     * Protocol class, which hold tweet data that is recieved from TwitterStreamerActor.
     */
    static public class TweetMessage {
        public final String tweetData;

        public TweetMessage(String tweetData) {
            this.tweetData = tweetData;
        }
    }

    /**
     * Optional Method that executes at intialization. It is registering PrinterActor to the Twitter Streamer Actor.
     */
    @Override
    public void preStart() {
        context().actorSelection("/user/TwitterStreamerActor/").tell(new TwitterStreamerActor.RegisterActor(), self());
    }

    /**
     * Props method creates an actor Reference
     * here: websocket actor reference.
     * @param wsout
     * @return
     */
    public static Props props(final ActorRef wsout) {
        return Props.create(PrinterActor.class, wsout);
    }


    /**
     * Recieves the message sent by Twitter Streamer actor that accepts a TweetMessage protocol class type.
     * @return
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder().match(TweetMessage.class, this::printTweet).build();
    }

    /**
     *Parses and sends the tweet message to UI
     * @param message
     */
    private void printTweet(TweetMessage message) {
        final ObjectNode response = Json.newObject();

        String tweet = message.tweetData;

        if(tweet.contains("Fetching tweets for keyword:")){
            response.put("tweetData", tweet);
            actorRefWebSocket.tell(response, self());
            return;
        }



        if (tweet.contains("#->")) {
            if (tweet.contains("text")) {

                String[] tweetArray = tweet.split("\"text\":");

                String screenName = "screen_name";

                if (tweetArray.length > 1) {
                    tweet = tweetArray[1];

                }
                if (tweet.contains("\"source\":")) {
                    String[] tweetArray2 = tweet.split("\"source\":");
                    if (tweetArray2.length > 0) {

                        tweet = tweetArray2[0];

                        if (tweetArray.length > 1) {
                            screenName = getScreenName(tweetArray2[1]);
                        }

                        if (!tweet.contains("u300c")) {
                            Logger.info(tweet + "\n");
                            response.put("tweetData", tweet);
                            response.put("screenName", screenName);
                            actorRefWebSocket.tell(response, self());
                        }
                    }
                }
            }
        }
    }

    /**
     *Parses screen name
     * @param tweetData
     * @return
     */
    private String getScreenName(String tweetData) {
        String screenName = "";

        if (tweetData.contains("\"screen_name\":\"")) {
            String[] tweetArray = tweetData.split("\"screen_name\":\"");

            if (tweetArray.length > 1) {
                screenName = tweetArray[1];

                if (screenName.contains("\",\"location\"")) {

                    String[] tweetArray2 = screenName.split("\",\"location\"");

                    if (tweetArray2.length > 1) {
                        screenName = tweetArray2[0];

                    }
                }

            }
        }

        return screenName;
    }
}
