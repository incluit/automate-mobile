import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class UiBaseTest {

    public AndroidDriver driver = driver();
//
//
//    @Before
//    public AppiumDriver start() throws Exception {
//        return driver;
//    }
//    @AfterClass
//    public void stop() throws Exception {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
    public AndroidDriver driver()  {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.VERSION, "7.1.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "BLL-23");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setCapability("appPackage", "com.amazonaws.devicefarm.android.referenceapp");
            capabilities.setCapability("appActivity", "com.amazonaws.devicefarm.android.referenceapp.Activities.MainActivity");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.setLogLevel(Level.INFO);
        return driver;
    }


    @Test
    public void testUntitled() throws Exception {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("ReferenceApp");
        el1.click();
        Thread.sleep(5000);
        MobileElement el2 = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Row Category Name\"])[4]");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Text Input Control");
        el3.sendKeys("Hola Naranja!");
        Thread.sleep(5000);
        MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.view.ViewPager/android.view.ViewGroup/android.widget.TextView[2]");
        el4.click();
        Thread.sleep(5000);
        MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Checkbox Control");
        el5.click();

    }


}
