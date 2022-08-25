package base.elements;

import base.actions.IActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

import static base.driver.Driver.getDriver;
import static utils.Loggerr.log;

public class BaseElement {

    private By locator;
    private WebElement element;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
        element = findElement();
    }

    public BaseElement(WebElement element) {
        this.element = element;
    }

    private WebElement findElement() {
        log("Search element - " + name);
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findElements() {
        return getDriver().findElements(locator);
    }

    protected <T> List<T> getElements(Class<T> tClass) {
        log("Search elements - " + name);
        List<T> listElements = new ArrayList<>();
        for (WebElement element : findElements()) {
            if (tClass.equals(TextField.class)) {
                listElements.add((T) new TextField(element));
            } else if (tClass.equals(Button.class)) {
                listElements.add((T) new Button(element));
            }
        }
        return listElements;
    }

    public void click() {
        log("Click on - " + name);
        element.click();
    }

    public String getText() {
        log("Return field " + name + " text - " + element.getText());
        return element.getText();
    }

    public String getTextAttribute(String attribute) {
        log("Return attribute value - " + name);
        return element.getAttribute(attribute);
    }


    public By getLocator() {
        return locator;
    }

    public String getName() {
        return name;
    }

    public WebElement getElement() {
        return element;
    }

    public boolean isDisplayed() {
        if (element == null) {
            return findElement().isDisplayed();
        } else {
            return element.isDisplayed();
        }
    }

    public boolean isEnabled() {
        if (element == null) {
            return findElement().isEnabled();
        } else {
            return element.isEnabled();
        }
    }

    public IActions actions() {
        return new IActions(findElement());
    }
}