package base.appnav;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import java.io.File;

import static base.driver.Driver.getDriver;
import static settings.Settings.config;
import static utils.FilesUtils.copy;
import static utils.Loggerr.log;

public class AppNavigate {

    public void quit() {
        getDriver().quit();
        log("driver was killed");
    }

    public void close() {
        getDriver().close();
        log("current window was close");
    }

    public String getPageSource() {
        log("return current page source");
        return getDriver().getPageSource();
    }

    public boolean makeScreenShot(String name) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File pathToSS = new File(config.get("pathToScreenFolder") + name + ".png");
        copy(scrFile, pathToSS.getAbsolutePath());
        return pathToSS.exists();
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] makeScreenShotByByte(String name) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void back() {
        getDriver().pressKey(new KeyEvent(AndroidKey.BACK));;
    }
}