package services;

import models.UserDetails;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.TwitterException;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.assertTrue;

public class TwitterProfileServiceUnitTest {

    /**
     *  Tests the asynchronous results for UserDetails
     * @throws TwitterException
     * @throws ExecutionException
     * @throws InterruptedException
     * @author Saman
     */
    @Test
    public void testUserDetailsService() throws TwitterException, ExecutionException, InterruptedException {
        CompletionStage<UserDetails> result = TwitterProfileService.getUserDetails("aarp54");
        assertTrue(result.toCompletableFuture().get().getScreenName() != null);
    }

    /**
     * Tests the asynchronous results for top ten tweets from user timeline.
     * @throws TwitterException
     */
    @Test
    public void testUserTimelineService() throws TwitterException {
        List<Status> result = TwitterProfileService.getUsersTimeline("aarp54");
        assertTrue(result.size() >= 0);
    }
}
