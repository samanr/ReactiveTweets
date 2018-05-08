package controllers;

import org.junit.Test;
import play.mvc.Result;
import twitter4j.TwitterException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

/**
 * Test class for UserDeatils Controller, tests functioning of teh User Profile Method
 * @see UserDetailsController
 * @author Saman
 */

public class UserDetailsControllerTest {

    /**
	 *  Test wheather userDetailsController computes the userProfile
     * @author Saman
	 */
    @Test
    public void testUserProfileDetails() throws TwitterException, ExecutionException, InterruptedException {
        CompletionStage<Result> result = new UserDetailsController().userProfile("aarp54");
        CompletableFuture<Result> r = result.toCompletableFuture();
        assertTrue(r.get().toString().length() > 0);
    }
}
