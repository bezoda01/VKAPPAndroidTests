package base.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    public Button (By locator, String name) {
        super(locator, name);
    }

    public Button (WebElement element) {
        super(element);
    }
}