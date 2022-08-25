package base.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static base.driver.Driver.getDriver;

public class IActions {
    private Actions actions;
    private WebElement element;

    public IActions(WebElement element) {
        actions = new Actions(getDriver());
        this.element = element;
    }
    public void moveToElement() {
        actions.moveToElement(element).build().perform();
    }

    public void contextClick() {
        actions.contextClick(element).build().perform();
    }

    public void dragAndDrop(WebElement toThisElement) {
        actions.dragAndDrop(element, toThisElement).build().perform();
    }

    public void scrollToElement() {
        actions.scrollToElement(element).build().perform();
    }
}