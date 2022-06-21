package com.qa.android.test;

import base.AppFactory;
import com.google.errorprone.annotations.RestrictedApi;
import com.qa.android.pages.AppiumPage;
import com.qa.android.util.TestUtil;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.TreeSet;

public class AppiumPageTest extends AppFactory {
    TestUtil testUtil;
    AppiumPage appiumPage;

    public AppiumPageTest() throws IOException {
        super();
    }

    @BeforeTest
    public void launchBrowser() throws IOException {
        AppFactory.setupAndroidDevice();
        appiumPage = new AppiumPage();
    }
//
//    @Test(priority = 0)
//    public void verifyingCheckbox() throws InterruptedException {
//        TestUtil.clickOnElement(driver.findElement(appiumPage.accessibilityButton()));
//        TestUtil.clickOnElement(driver.findElement(appiumPage.accessibilityNodeQueringButton()));
//        boolean result = TestUtil.isSelected(driver.findElement(appiumPage.conquerWorldCheckbox()));
//        System.out.println("Resulttttttt"+ result);
//        if(!result){
//            TestUtil.clickOnElement(driver.findElement(appiumPage.conquerWorldCheckbox()));
//        };
//    }

    @Test(priority = 1)
    public void fingerDown() throws InterruptedException {
//        TestUtil.goBack();
//        TestUtil.goBack();
        TestUtil.scrollToEnd();
        TestUtil.clickOnElement(driver.findElement(appiumPage.viewButton()));
        TestUtil.scrollByDimension();
//        TestUtil.fingerUpOnScreen();
        
    }

//    @Test(priority = 1)
//    public void testClickable() throws InterruptedException {
//        TestUtil.scrollToEnd();
//        TestUtil.clickOnElement(driver.findElement(appiumPage.viewButton()));
//        Dimension dimension = TestUtil.getWindowSize();
//        System.out.println("Screen Size" + dimension);
//    }
//
//    @Test(priority = 2)
//    public void testDragAndDrop() throws InterruptedException {
//        TestUtil.clickOnElement(driver.findElement(appiumPage.dragAndDropButton()));
//        TestUtil.dragAndDrop(driver.findElement(appiumPage.draggable()),driver.findElement(appiumPage.droppable()));
//    }
//
//    @Test(priority = 3)
//    public void imageSwipe() throws InterruptedException {
//        TestUtil.goBack();
//        TestUtil.verticalScroll("ImageSwitcher");
//        TestUtil.clickOnElement(driver.findElement(appiumPage.imageSwitcherButton()));
//        TestUtil.swipeToElement(driver.findElement(appiumPage.imageSlider()));
//    }


}
