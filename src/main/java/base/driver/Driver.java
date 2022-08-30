package base.driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

import static settings.Settings.caps;
import static settings.Settings.timeouts;
import static utils.JsonUtils.convertCapsToMap;

public class Driver {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            driver = getInstance();
            if((Long) timeouts.get("timeoutImplicit") > 0) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((Long) timeouts.get("timeoutImplicit")));
            }
        }
        return driver;
    }

    private static AndroidDriver getInstance() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        Map<String, String> cap = convertCapsToMap();
        for(String st: cap.keySet()) {
            desiredCapabilities.setCapability(st, cap.get(st));
        }
        AndroidDriver driver = null;
        try {
            driver = new AndroidDriver(new URL(caps.get("urlAppium").toString()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}