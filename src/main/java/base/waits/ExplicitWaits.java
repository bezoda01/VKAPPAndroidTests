package base.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static base.driver.Driver.getDriver;
import static settings.Settings.*;

public class ExplicitWaits {

    private By locator;
    private WebElement element;

    public ExplicitWaits(By locator, WebElement element) {
        this.locator = locator;
        this.element = element;
    }

    private final WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds((Long) timeouts.get("timeoutCondition")));

    public WebElement presenceOfElementLocated() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement elementToBeClickable() {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public List<WebElement> listPresenceOfElementLocated() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void ofElementLocated() {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void ToBeClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void visibilityOfElementLocated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean attributeContains(String attribute, String value) {
        return wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
    }
}