package controllers;


import actors.TwitterStreamerActor;
import actors.PrinterActor;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.streams.ActorFlow;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import javax.inject.Inject;
import play.libs.ws.WSClient;
import views.html.index;


public class HomeController extends Controller {
    /**
     * Main controller class
     *
     */
    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public HomeController(Materializer materializer, WSClient ws, HttpExecutionContext ec) {
        this.actorSystem = ActorSystem.create("helloakka");
        this.actorSystem.actorOf(TwitterStreamerActor.props(ws, ec, materializer), "TwitterStreamerActor");
        this.materializer = materializer;
    }

    /**
     * This is the entry point of the application that renders the main index page
     *
     * @return
     */
    public Result index() {
        return ok(views.html.index.render());
    }

    /**
     * This is the websocket method that creates the Printer Actor with a websocket associated with it.
     *
     * @return
     */
    public WebSocket ws() {
        return WebSocket.Json.accept(request -> ActorFlow.actorRef(PrinterActor::props, actorSystem, materializer));
    }

}

