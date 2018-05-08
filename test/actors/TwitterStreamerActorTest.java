
package actors;

import akka.actor.*;
import akka.stream.Materializer;
import akka.testkit.JavaTestKit;
import org.junit.BeforeClass;
import org.junit.Test;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSClient;
import javax.inject.Inject;
import static org.junit.Assert.assertArrayEquals;


public class TwitterStreamerActorTest {
    /**
     * This is a test class for Twitter Streamer Actor
     *
     */

    @Inject
    Materializer materializer;

    @Inject
    WSClient ws;

    @Inject
    HttpExecutionContext ec;


    static ActorRef twitterStreamerActor;

    static ActorSystem actorSystem;

    @BeforeClass
    public static void setup() {
        actorSystem = ActorSystem.create("helloakka");
    }

    /**
     * checks the duration of message communication by twitter streamer actor class.
     *
     */

    @Test
    public void durationTest() {

        twitterStreamerActor = actorSystem.actorOf(TwitterStreamerActor.props(ws, ec, materializer), "TwitterStreamerActor");

        new JavaTestKit(actorSystem) {{
            getRef().tell(42, null);
            getRef().tell(43, null);
            getRef().tell("hello", null);
            final String[] out =
                    new ReceiveWhile<String>(String.class, duration("1 second")) {
                        // do not put code outside this method, will run afterwards
                        protected String match(Object in) {
                            if (in instanceof Integer) {
                                return in.toString();
                            } else {
                                throw noMatch();
                            }
                        }
                    }.get(); // this extracts the received messages
            assertArrayEquals(new String[]{"42", "43"}, out);
            expectMsgEquals("hello");
        }};
    }


}
