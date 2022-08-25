import api.ApiApplication;
import base.Appium;
import base.forms.LoginScreen;
import base.forms.NewsScreen;
import base.forms.PasswordScreen;
import base.forms.UserPageScreen;
import models.PostPhotoModel;
import models.PostSendModel;
import models.UploadUrlModel;
import models.requestPhotoModel.RequestPhotoModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.StringUtils;

import static api.ApiApplication.*;
import static settings.Settings.*;

public class VKAPINativeTest extends BaseClass {

    @Test
    public void test() {
        LoginScreen entireForm = new LoginScreen();
        entireForm.enterAndLogin(config.get("login").toString());
        PasswordScreen passwordScreen = new PasswordScreen();
        passwordScreen.inputPasswordAndLogIn(config.get("password").toString());
        NewsScreen newsScreen = new NewsScreen();
        newsScreen.goToUserPage();
        String firstText = StringUtils.randomText();
        String userId = config.get("userId").toString();
        PostSendModel postSendModel = publishPost(config.get("userId").toString(), firstText);
        UserPageScreen userPageScreen = new UserPageScreen();
        Assert.assertEquals(userPageScreen.getPostText(), firstText, "Users post do not contains correct message");
        UploadUrlModel uploadUrlModel = getUploadUrl(userId);
        PostPhotoModel postPhotoModel = getPhotoAttribute(uploadUrlModel.getUpload_url());
        RequestPhotoModel requestPhotoModel = savePhotoInAlbum(userId, postPhotoModel);
        String textSecond = StringUtils.randomText();
        ApiApplication.editPostMessage(userId, postSendModel.getResponse(), requestPhotoModel.getResponse().get(0).getId(), textSecond);
        String textThird = StringUtils.randomText();
        ApiApplication.addCommentOnPost(userId, postSendModel.getResponse(), textThird);

    }
}