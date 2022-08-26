package base.forms;

import base.baseScreen.BaseScreen;
import base.elements.TextField;
import base.uiauto.SelectorObject;
import base.uiauto.UiSelectors;
import io.appium.java_client.AppiumBy;

import static base.uiauto.AndroidUIAuto.createAUIScrollable;
import static base.uiauto.AndroidUIAuto.createAUISelector;

public class UserPageScreen extends BaseScreen {

    public UserPageScreen() {
        super(new TextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/custom_action_bar_title"))),"User page screen"));
    }

    public String getPostText() {
        return getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/post_view")))),"created post").getText();
    }

    public void openComment() {
        getIFactory().getButton(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/comments")))), "button comment").click();
    }

    public String getCommentText() {
        return getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/text"))), "comment text").getText();
    }

    public void setLike() {
        getIFactory().getButton(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/iv_likes")))), "button like").click();
    }

    public String getLike() {
        return getIFactory().getTextField(AppiumBy.androidUIAutomator(createAUISelector(new SelectorObject(UiSelectors.RESOURCEID, "com.vkontakte.android:id/reactions_preview_text"))), "likes amount").getText();
    }

    public String checkPostIsNotExist() {
        return getIFactory().getButton(AppiumBy.androidUIAutomator(createAUIScrollable(createAUISelector(
                                new SelectorObject(UiSelectors.CLASSNAME, "android.widget.LinearLayout"),
                                new SelectorObject(UiSelectors.CHILDSELECTOR, createAUISelector(
                                        new SelectorObject(UiSelectors.TEXT, "Write your first post")))))),
                "description about the page is not contains any post").getText();
    }
}