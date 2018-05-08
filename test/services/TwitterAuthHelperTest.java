package services;

import org.junit.Before;
import org.junit.Test;
import twitter4j.Twitter;
import twitter4j.conf.ConfigurationBuilder;

import static org.junit.Assert.assertNotNull;


public class TwitterAuthHelperTest {
    /**
     * Test class for TwitterAuth Helper
     * Test if all authorization keys are not null.
     *
     */

    TwitterAuthHelper twitterAuthHelper;

    ConfigurationBuilder twitterConfigBuilder;

    Twitter getTwitterObject;


    @Before
    public void setup() {
        twitterAuthHelper = new TwitterAuthHelper();
        getTwitterObject = TwitterAuthHelper.getTwitterObject();
        twitterConfigBuilder = twitterAuthHelper.twitterConfigBuilder();
    }

    @Test
    public void testTwitterInstance() {
        assertNotNull(twitterConfigBuilder);
    }

    @Test
    public void testConfigurationBuilder() {
        assertNotNull(twitterAuthHelper);
    }

    @Test
    public void testTwitterObject() {
        assertNotNull(getTwitterObject);
    }
}
