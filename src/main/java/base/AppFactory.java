package base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

    public class AppFactory {
        public static AppiumDriver<MobileElement> driver;
        public static DesiredCapabilities caps;
        public static Properties properties;
        public static TouchActions touchActions;
        public static Actions actions;
        public static AndroidTouchAction androidTouchAction;
//        public static TouchAction touchAction;


//    public WebDriverWait                wait;

        public static void setupAndroidDevice() throws MalformedURLException {
            caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "55cae658");
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UIAutomator2");
            caps.setCapability("platformVersion", "6.0.1");
//        caps.setCapability("skipUnlock", "true");
            caps.setCapability("appPackage", "io.appium.android.apis");
            caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
//        caps.setCapability("noReset", "false");
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

//        wait = new WebDriverWait(driver, 10);
        }

        public void setupiOSDevice() throws MalformedURLException {
            caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "iPhone 8 Plus");
            caps.setCapability("platformName", "iOS");
            caps.setCapability("automationName", "XCUITest");
            caps.setCapability("platformVersion", "15.2");
//        caps.setCapability("skipUnlock", "true");
            caps.setCapability("appPackage", "com.bogo.android");
            caps.setCapability("appActivity", "com.bogo.android.MainActivity");
//        caps.setCapability("noReset", "false");
            driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
        @Test
        public void basicTest() throws InterruptedException {
            System.out.println("hello");
        }

        public void teardown() {
            driver.quit();
        }

        public void setup() throws IOException {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
            properties.load(inputStream);
        }



}
