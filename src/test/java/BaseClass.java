import base.driver.Driver;
import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.JsonUtils;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static base.Appium.appnav;
import static utils.AllureUtils.addAttachment;

public class BaseClass implements IHookable {

    @BeforeClass
    public void beforeClass() {
        Driver.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() {
        appnav().quit();
        addAttachment(Paths.get("log.log"), "Log");
        AllureEnvironmentWriter.allureEnvironmentWriter(
                ImmutableMap.copyOf(JsonUtils.convertCapsToMap()),"allure-results/");
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() != null) {
            appnav().makeScreenShotByByte(testResult.getMethod().getMethodName());
        }
    }
}