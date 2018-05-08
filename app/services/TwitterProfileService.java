package services;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.UserDetails;
import play.libs.Json;
import twitter4j.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;


public class TwitterProfileService {

    /**
     * This class gets User profile information
     *
     */
    public static String streamingUrl = "https://stream.twitter.com/1.1/statuses/filter.json";
    public static String methodType = "GET";

    /**
     *  Gets user specific details
     * @param username
     * @return
     * @throws TwitterException
     */
    public static CompletionStage<UserDetails> getUserDetails(String username) throws TwitterException {
        CompletableFuture<UserDetails> future = new CompletableFuture<>();
        Twitter twitter = TwitterAuthHelper.getTwitterObject();
        User twitterUser = twitter.showUser(username);
        List<Status> tweetsHistory = getUsersTimeline(username);
        List<String> history = new ArrayList<String>();
        tweetsHistory.forEach((data) -> {
            history.add(data.getText());
        });

        UserDetails userDetails = new UserDetails();
        userDetails.setName(twitterUser.getName());
        userDetails.setScreenName(twitterUser.getScreenName());
        userDetails.setUserBio(twitterUser.getDescription());
        userDetails.setFollowersCount(twitterUser.getFollowersCount());
        userDetails.setTweetHistory(history);
        future.complete(userDetails);
        return future;
    }

    /**
     *  gets Last ten tweets of specified user from his Twitter Timeline.
     * @param username
     * @return
     * @throws TwitterException
     */
    public static List<Status> getUsersTimeline(String username) throws TwitterException {
        Twitter twitterObject = TwitterAuthHelper.getTwitterObject();
        User user = twitterObject.showUser(username);
        Paging paging = new Paging();
        paging.setCount(10);
        List<Status> userTimeline = twitterObject.getUserTimeline(user.getId(), paging);
        return userTimeline;
    }

    public static TwitterProfileService getObject(){
        return new TwitterProfileService();
    }
}
