package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.Button;
import io.appium.java_client.AppiumBy;

public class NewsScreen extends BaseScreen {

    private final Button userView = getIFactory().getButton(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/avatar_container_view\")"), "Button user menu");

    public NewsScreen() {
        super(new Button(AppiumBy.androidUIAutomator("resourceId(\"android:id/text1\")"), "News screen"));
    }

    public void goToUserPage() {
        userView.click();
        getIFactory().getButton(AppiumBy.androidUIAutomator("resourceId(\"com.vkontakte.android:id/menu_profile\")"), "Button user page").click();
    }
}