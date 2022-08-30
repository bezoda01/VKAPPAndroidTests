package base.elements;

import base.waits.TypeWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.Loggerr.log;

public class TextField extends BaseElement {

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public TextField(WebElement element, String name) {
        super(element, name);
    }

    public TextField(By locator, String message, TypeWait typeWait) {
        super(locator, message, typeWait);
    }

    public void sendText(String text) {
        log("send text - " + text);
        findElement().sendKeys(text);
    }
}