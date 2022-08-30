package base.elements;

import base.waits.TypeWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button (By locator, String name) {
        super(locator, name);
    }

    public Button (WebElement element, String name) {
        super(element, name);
    }

    public Button(By locator, String message, TypeWait typeWait) {
        super(locator, message, typeWait);
    }
}