package models;

import java.util.List;




public class UserDetails {

    /**
     * Class containing User Details
     *
     */
    private String name;
    private String screenName;
    private String userBio;
    private int followersCount;
    private List<String> tweetHistory;


    /**
     * Setter method for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     *Setter method for screenName
     * @param screenName
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }


    /**
     *Setter method for User Bio
     * @param userBio
     */
    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    /**
     *Setter method for number of follower count
     * @param followersCount
     */

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }


    /**
     * Setter method for tweet history
     * @param tweetHistory
     */
    public void setTweetHistory(List<String> tweetHistory) {
        this.tweetHistory = tweetHistory;
    }

    /**
     *Getter Method
     * @return user name
     */

    public String getName() {
        return name;
    }


    /**
     * Getter method
     * @return user screen name
     */
    public String getScreenName() {
        return screenName;
    }


    /**
     * Getter method
     * @return user Bio
     */
    public String getUserBio() {
        return userBio;
    }


    /**
     * Getter method users follower count
     * @return users follower count
     */
    public int getFollowersCount() {
        return followersCount;
    }


    /**
     *Getter method for last ten tweets
     * @return list of last ten tweets
     */
    public List<String> getLastTenTweets() {
        return tweetHistory;
    }

}
