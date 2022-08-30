package screens;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.uiauto.SelectorObject;
import base.uiauto.UiSelectors;
import base.waits.TypeWait;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static base.uiauto.AndroidUIAuto.createAUISelector;

public class NewsScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "android:id/text1")));
    private final Button userView = getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/avatar_container_view"))), "Button user menu", TypeWait.PRESENCE_OF_ELEMENT_LOCATED);

    public NewsScreen() {
        super(new Button(UNIQUE_ELEMENT, "News screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    @Step("Go to the user page")
    public void goToUserPage() {
        userView.click();
        getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/menu_profile"))), "Button user page", TypeWait.PRESENCE_OF_ELEMENT_LOCATED).click();
    }
}