package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import io.appium.java_client.AppiumBy;

public class UserPageScreen extends BaseScreen {

    public UserPageScreen() {
        super(new TextField(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/custom_action_bar_title\")"),"User page screen"));
    }

    public String getPostText() {
        return getIFactory().getTextField(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().resourceId(\"com.vkontakte.android:id/post_view\"))"),"created post").getText();
    }
}