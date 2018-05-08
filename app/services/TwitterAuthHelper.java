package services;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuthHelper {


    /**
     * This class contains Twitter Authorization keys
     *
     */
    public static String consumerKey =       "EnYRL5SlG0nTLAHjjof5X1PHj";
    public static String consumerSecretKey = "6DpYTHRAayrHq0YQ5Ug1voCEB2M4ZuI0EBZ7aXUTnu3WbDNnU4";
    public static String accessToken =       "976176080850751489-gepbYt1TFQQGd1Jdd3kpZU9N0cOFS4f";
    public static String accessTokenSecret = "rwlr0OZXSsloYFdN7WR9vpTOWJfdRIii4Bkhr9SuoRmcd";


    /**
     *   Builds a twitter configuration to communicate with Twitter API
     * @return
     */
    public ConfigurationBuilder twitterConfigBuilder() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        return configurationBuilder;
    }


    /**
     *  getter method
     * @return twitter object
     */
    public static Twitter getTwitterObject() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = twitterFactory.getInstance();
        return twitter;
    }

}
