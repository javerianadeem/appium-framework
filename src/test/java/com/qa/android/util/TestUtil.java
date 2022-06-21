package com.qa.android.util;

import base.AppFactory;
//import com.qa.android.test.AppFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TestUtil extends AppFactory {
    static int PAGE_LOAD_TIMEOUT = 20;
    static int IMPLICIT_WAIT = 20;

    public TestUtil() throws IOException {
        super();
        androidTouchAction = new AndroidTouchAction(driver);
        actions = new Actions(driver);
    }

    public static WebElement waitForElementClickable(WebElement element) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementVisible(WebElement element) {
        return new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
    }

    //
    public static void verticalScroll(String visibleText) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().text(\"" + visibleText + "\"))"));
    }

    public static void horizontalScroll(String visibleText) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
                        ".scrollIntoView(" + "new UiSelector().text(\"" + visibleText + "\"))"));
    }

    public static void scrollToEnd() {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
    }

    public static void dragAndDrop(MobileElement drag, MobileElement drop) {
        androidTouchAction = new AndroidTouchAction(driver);
        androidTouchAction.longPress(ElementOption.element(drag))
                .waitAction().moveTo(ElementOption.element(drop))
                .release()
                .perform();


    }

    public static void swipeToElement(MobileElement element) {
//        AndroidElement element = (AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);
        waitForElementClickable(element);
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(PointOption.point(100,100))
//                .moveTo(PointOption.point(200,200)
//                .;
        TouchAction touchAction = new TouchAction(driver);

        touchAction
                .press(PointOption.point(530, 1200))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(250, 1200))
                .release()
                .perform();
    }

    public static void goBack() {
        driver.navigate().back();
    }

    public static void clickOnElement(MobileElement element) throws InterruptedException {
//      touchActions = new TouchActions(driver);
        waitForElementClickable(element);
        element.click();
//        touchActions.singleTap(element).release().perform();
//        androidTouchAction.tap(ElementOption.element(element));
//        androidTouchAction.perform();
    }

    public static String getElementText(MobileElement element) {
        waitForElementVisible(element);
        return element.getText();
    }



    public static boolean isEnabled(MobileElement element) {
        return element.isEnabled();
    }

    public static boolean isDisplayed(MobileElement element) {
        return element.isDisplayed();
    }

    public static boolean isSelected(MobileElement element) {
        return element.isSelected();
    }

    //    WEBBBBBB
    public static Dimension getWindowSize() {
        return driver.manage().window().getSize();
    }
//    public void sendSMS(){
//
//    }

    public String getScreenshot(String methodName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + methodName + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }

    public void visitUrl(String url) {
        driver.get(url);
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public WebElement waitForElementVisibleAndClickable(WebElement element) {
        waitForElementVisible(element);
        return waitForElementClickable(element);
    }


    public static void scrollByDimension() {
        androidTouchAction = new AndroidTouchAction(driver);
        Dimension dimension = driver.manage().window().getSize();
        //starting point of scroll
        int scrollStart = (int) (dimension.getHeight() * 0.8);
        int scrollEnd = (int) (dimension.getHeight() * 0.1);

        androidTouchAction.press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release()
                .perform();
    }

    public void sendPhoto() {
//        driver.pullFile()
    }

    public void clipboardText() {
        String text = "Hello TAU";
    }

    public String getSessionId() {
        String sessionId = driver.getSessionId().toString();
        return sessionId;
    }

    public String getPageSource() {
        String pageSource = driver.getPageSource();
        return pageSource;
    }

    public String getScreenSize() {
        ScreenOrientation orientation = driver.getOrientation();
        return orientation.toString();
    }

    public void rotateToLandscape() {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotateToPortait() {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public String getDeviceTime() {
        String time = driver.getDeviceTime();
        return time;
    }

    public void sendKeys(MobileElement element, String text) {
        waitForElementClickable(element);
        element.sendKeys(text);
    }

    public void clearText(MobileElement element) {
        element.clear();
    }

    public String getAttribute(MobileElement element, String attributeName) {
        waitForElementVisible(element);
        return element.getAttribute(attributeName);
    }

    public void switchToActiveElement() {
        WebElement currentElement = driver.switchTo().activeElement();
    }

    public void checkIfElementsAreEqual(MobileElement element1, MobileElement element2) {
        boolean isEqual = element1.equals(element2);
    }

    public void moveMouseTo(MobileElement element) {
        androidTouchAction.moveTo(PointOption.point(0, 10));
        androidTouchAction.tap(ElementOption.element(element));
        androidTouchAction.perform();
    }

    public void doubleClick(MobileElement element) {
        actions.moveToElement(element);
        actions.doubleClick();
        actions.perform();
    }

    //    Click and hold the left mouse button at the current mouse coordinates
    public void hoverAndHold(MobileElement element) {
        actions.moveToElement(element);
        actions.clickAndHold();
        actions.perform();
    }

    //    Click and hold the left mouse button at the current mouse coordinates
    public void hoverAndRelease(MobileElement element) {
        actions.moveToElement(element);
        actions.clickAndHold();
        actions.moveByOffset(10, 10);
        actions.release();
        actions.perform();
    }

    public void doubleTap(MobileElement element) {
        touchActions.doubleTap(element);
        touchActions.perform();
    }

    public void moveFinger() {
        touchActions = new TouchActions(driver);
        touchActions
                .down(10, 10)
                .moveByOffset(50, 50)
                .perform();
    }

    public void longPressElement(MobileElement element) {
        touchActions.longPress(element);
        touchActions.perform();
    }

    public void setWindowSize(Integer d1, Integer d2) {
        driver.manage().window().setSize(new Dimension(d1, d2));
    }

    public Point getWindowPosition() {
        return driver.manage().window().getPosition();
    }

    public void setWindowPosition(Integer d1, Integer d2) {
        driver.manage().window().setPosition(new Point(d1, d2));
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void multiAction(MobileElement el1, MobileElement el2) {
//        AndroidTouchAction action0 = androidTouchAction.tap(ElementOption.element(el1));
//        AndroidTouchAction action1 = androidTouchAction.tap(ElementOption.element(el2));
//        MultiAction().add(action0).add(action1).perform();
    }


//    List<MobileElement> elementsOne = (List<MobileElement>) driver.findElementsByAccessibilityId("SomeAccessibilityID");

// UNUSED FUNCTIONS

    public void tapOnScreen() {
        AndroidElement tapElement = (AndroidElement) driver.findElementsByAccessibilityId("Views");

        androidTouchAction.tap(ElementOption.element(tapElement)).perform();
        scrollByDimension();
    }

    public static void fingerDownOnScreen() {
        touchActions = new TouchActions(driver);
        touchActions
                .down(10, 10)
                .move(50, 50)
                .perform();
    }

    public static void fingerUpOnScreen() {
        touchActions = new TouchActions(driver);
        touchActions.down(10, 10)
                .up(50, 50).perform();
    }

    public String function(Integer number, Function<Integer, String> lambda){
        return lambda.apply(number);
    }

    public void trash(){

        List<String> numbers = new ArrayList<String>();
        int total = 0;

        String a = "bikini";
        String n = new String("bikini");
        double text = 3.75;
        Scanner input = new Scanner(System.in);
        text = input.nextDouble();
            
        System.out.println(text);

    }



}