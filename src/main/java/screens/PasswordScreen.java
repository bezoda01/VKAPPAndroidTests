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

public class PasswordScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/title")));
    private final TextField passwordField = getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/vk_password"))), "password field", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);
    private final Button logIn = getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/continue_btn"))), "log in button", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);

    public PasswordScreen() {
        super(new TextField(UNIQUE_ELEMENT, "Password screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    @Step("Input password: {0} and go to news screen")
    public void inputPasswordAndLogIn(String password) {
        passwordField.sendText(password);
        logIn.click();
    }
}