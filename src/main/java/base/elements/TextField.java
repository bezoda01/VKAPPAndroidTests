package base.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static utils.Loggerr.log;

public class TextField extends BaseElement {

    public TextField(By locator, String name) {
        super(locator, name);
    }

    public TextField(WebElement element) {
        super(element);
    }

    public void sendText(String text) {
        log("Отправляем текст - " + text);
        getElement().sendKeys(text);
    }

    public void sendKeys(Keys keys) {
        getElement().sendKeys(keys);
    }
}