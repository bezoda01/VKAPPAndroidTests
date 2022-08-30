package screens;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.elements.TextField;
import base.uiauto.SelectorObject;
import base.uiauto.UiSelectors;
import base.waits.TypeWait;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.uiauto.AndroidUIAuto.createAUISelector;

public class LoginScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID,"com.vkontakte.android:id/vk_fragment_container")));
    private final TextField usernameField = getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/email_or_phone"))), "Username field", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);
    private final Button signIn = getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID,"com.vkontakte.android:id/login_button"))), "Sign in button", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);

    public LoginScreen() {
        super(new TextField(UNIQUE_ELEMENT,"Entire screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    @Step("Input login: {0}")
    public void enterAndLogin(String username) {
        usernameField.sendText(username);
        signIn.click();
    }
}