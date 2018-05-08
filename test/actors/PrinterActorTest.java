package actors;

import akka.actor.*;
import akka.testkit.JavaTestKit;
import akka.testkit.TestActorRef;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import scala.concurrent.duration.Duration;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class PrinterActorTest {

    /**
     * This is a test class for printer Actor
     *
     */
    static ActorSystem actorSystem;

    @BeforeClass
    public static void setup() {
        actorSystem = ActorSystem.create("helloakka");;
    }

    /**
     * Checks the tell method of an actor class.
     *
     */

    @Test
    public void durationTest(){

        new JavaTestKit(actorSystem) {{
            getRef().tell(42, null);
            new Within(Duration.Zero(), Duration.create(1, "second")) {
                // do not put code outside this method, will run afterwards
                public void run() {
                    assertEquals((Integer) 42, expectMsgClass(Integer.class));
                }
            };
        }};
    }
}
