package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import base.uiauto.SelectorObject;
import base.uiauto.UiSelectors;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static base.uiauto.AndroidUIAuto.createAUISelector;

public class LoginScreen extends BaseScreen {

    private final TextField usernameField = getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/email_or_phone"))), "Username field");
    private final Button signIn = getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID,"com.vkontakte.android:id/login_button"))), "Sign in button");

    public LoginScreen() {
        super(new TextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID,"com.vkontakte.android:id/vk_fragment_container"))),"Entire screen"));
    }

    @Step("Input login: {0}")
    public void enterAndLogin(String username) {
        usernameField.sendText(username);
        signIn.click();
    }
}