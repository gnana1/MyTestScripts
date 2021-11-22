package test.java;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class GeminiInterviewTest {

    public static final String URL = "http://127.0.0.1:4723/wd/hub";
    private static AndroidDriver driver = null;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.emogi.test");
        capabilities.setCapability("appActivity", ".setup.TestSetupActivity");
        capabilities.setCapability("automationName", "uiautomator2");

        driver = new AndroidDriver(new URL(URL), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /* */
    private void launchApp() throws InterruptedException
    {
        driver.findElementById("").click();
        sleep(500);
        driver.findElementById("").clear();
        sleep(500);

    }
    @DisplayName("")
    @Test //
    @Description(" ")
    private void share_appbit() throws InterruptedException {

    }
}
