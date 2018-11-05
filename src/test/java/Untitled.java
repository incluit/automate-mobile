import com.configuration.UiBaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.annotations.*;


public class Untitled extends UiBaseTest{
    @Test
    public void testUntitled() throws Exception {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("ReferenceApp");
        el1.click();
        Thread.sleep(5000);
        MobileElement el2 = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Row Category Name\"])[4]");
        el2.click();
        Thread.sleep(5000);
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Text Input Control");
        el3.sendKeys("Hola mundo");
    }
}