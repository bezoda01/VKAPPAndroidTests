package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import io.appium.java_client.AppiumBy;

public class LoginScreen extends BaseScreen {

    private final TextField usernameField = getIFactory().getTextField(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/email_or_phone\")"), "Username field");
    private final Button signIn = getIFactory().getButton(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/login_button\")"), "");

    public LoginScreen() {
        super(new TextField(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/vk_fragment_container\")"),"Entire screen"));
    }

    public void enterAndLogin(String username) {
        usernameField.sendText(username);
        signIn.click();
    }
}