package com.qa.android.test;

import base.AppFactory;

import com.qa.android.pages.*;
import com.qa.android.util.TestUtil;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BogoTest extends AppFactory {

    Bogo bogo;
    CityScreen cityScreen;
    TestUtil obj;
    ExploreCityCategories exploreCityCategories;
    Modals modals;
    Header header;

    public BogoTest() throws IOException {
        super();
//        obj=new TestUtil();
    }

    @BeforeTest
    public void initializingDriver() throws IOException {
        AppFactory.setupAndroidDevice();
        bogo = new Bogo();
//        testUtil = new TestUtil();
        cityScreen = new CityScreen();
        exploreCityCategories = new ExploreCityCategories();
        modals = new Modals();
        header = new Header();
    }

    @Test(priority = 1)
    public void selectCity() throws InterruptedException {
        if(new WebDriverWait(driver,Integer.parseInt(properties.getProperty("explicitWait")))
                .until(ExpectedConditions.visibilityOfElementLocated(cityScreen.cities(properties.getProperty("city")))).isDisplayed())
        {
            driver.findElement(cityScreen.cities("Karachi")).click();
        }
    }

    @Test(priority = 2)
    public void closeDealOfTheDay() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        modals.closeModal();
    }

    @Test(priority = 3)
    public void selectCategory(){
        WebElement category = TestUtil.waitForElementClickable(driver.findElement(exploreCityCategories.categories(properties.getProperty("categoryName"))));
        category.click();
        exploreCityCategories.clickOnListedCategory("Entertainment");
    }

    @Test(priority = 4)
    public void selectEntity(){
        exploreCityCategories.clickOnEntity(properties.getProperty("entityName"));
        exploreCityCategories.clickOnDeal("1");
        header.clickOnBackButton();
        exploreCityCategories.clickOnDeal("2");
        header.clickOnBackButton();
    }



}
