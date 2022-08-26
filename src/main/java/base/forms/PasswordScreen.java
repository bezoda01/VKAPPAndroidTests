package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import base.uiauto.SelectorObject;
import base.uiauto.UiSelectors;
import io.appium.java_client.AppiumBy;

import static base.uiauto.AndroidUIAuto.createAUISelector;

public class PasswordScreen extends BaseScreen {

    private final TextField passwordField = getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/vk_password"))), "password field");
    private final Button logIn = getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/continue_btn"))), "log in button");

    public PasswordScreen() {
        super(new TextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/title"))), "Password screen"));
    }

    public void inputPasswordAndLogIn(String password) {
        passwordField.sendText(password);
        logIn.click();
    }
}
