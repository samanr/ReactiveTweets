package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.TwitterProfileService;
import twitter4j.TwitterException;
import views.html.userprofile;

import java.util.concurrent.CompletionStage;


public class UserDetailsController extends Controller {
    /**
     * Controller class for User Details page.
     *
     */
    public CompletionStage<Result> userProfile(String screenName) throws TwitterException {
        return TwitterProfileService.getUserDetails(screenName).thenApplyAsync((details -> ok(userprofile.render(details))));
    }
}
