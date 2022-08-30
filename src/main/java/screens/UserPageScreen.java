package screens;

import base.baseScreen.BaseScreen;
import base.elements.TextField;
import base.uiauto.SelectorObject;
import base.uiauto.UiSelectors;
import base.waits.TypeWait;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static base.uiauto.AndroidUIAuto.createAUIScrollable;
import static base.uiauto.AndroidUIAuto.createAUISelector;

public class UserPageScreen extends BaseScreen {

    private static final By UNIQUE_ELEMENT = AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/custom_action_bar_title")));

    public UserPageScreen() {
        super(new TextField(UNIQUE_ELEMENT,"User page screen", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }


    public String getPostText() {
        return getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/post_view")))),"created post", TypeWait.PRESENCE_OF_ELEMENT_LOCATED).getText();
    }

    public void openComment() {
        getIFactory().getButton(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/comments")))), "button comment", TypeWait.PRESENCE_OF_ELEMENT_LOCATED).click();
    }

    public String getCommentText() {
        return getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/text"))), "comment text", TypeWait.PRESENCE_OF_ELEMENT_LOCATED).getText();
    }

    public void setLike() {
        getIFactory().getButton(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/iv_likes")))), "button like", TypeWait.PRESENCE_OF_ELEMENT_LOCATED).click();
    }


    public String checkPostIsNotExist() {
        return getIFactory().getButton(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                                new SelectorObject(UiSelectors.CLASSNAME, "android.widget.LinearLayout"),
                                new SelectorObject(UiSelectors.CHILDSELECTOR, createAUISelector(
                                        new SelectorObject(UiSelectors.TEXT, "Write your first post")))))),
                "description about the page is not contains any post", TypeWait.PRESENCE_OF_ELEMENT_LOCATED).getText();
    }
}