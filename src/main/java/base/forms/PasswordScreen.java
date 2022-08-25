package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import io.appium.java_client.AppiumBy;

public class PasswordScreen extends BaseScreen {

    private final TextField passwordField = getIFactory().getTextField(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/vk_password\")"), "password field");
    private final Button logIn = getIFactory().getButton(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/continue_btn\")"), "log in button");

    public PasswordScreen() {
        super(new TextField(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/title\")"), "Password screen"));
    }

    public void inputPasswordAndLogIn(String password) {
        passwordField.sendText(password);
        logIn.click();
    }
}
