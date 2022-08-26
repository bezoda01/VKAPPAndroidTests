package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import base.uiauto.SelectorObject;
import base.uiauto.UiSelectors;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static base.uiauto.AndroidUIAuto.createAUISelector;

public class NewsScreen extends BaseScreen {

    private final Button userView = getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/avatar_container_view"))), "Button user menu");

    public NewsScreen() {
        super(new Button(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "android:id/text1"))), "News screen"));
    }

    @Step("Go to the user page")
    public void goToUserPage() {
        userView.click();
        getIFactory().getButton(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject( UiSelectors.RESOURCEID,"com.vkontakte.android:id/menu_profile"))), "Button user page").click();
    }
}