package com.qa.android.pages;

import base.AppFactory;
//import com.qa.android.test.AppFactory;
import com.qa.android.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ExploreCityCategories extends AppFactory {

    TestUtil testUtil = new TestUtil();

    public ExploreCityCategories() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public By categories(String categoryName) {
        return By.xpath("//android.widget.TextView[@resource-id='categoryName' and @text='" + categoryName + "']");
    }

    public By listingCategories(String categoryName) {
        return By.xpath("//android.widget.TextView[@resource-id='listingCategoryName' and @text='" + categoryName + "']");
    }

    public By entityName(String entityName) {
        return By.xpath("//android.widget.TextView[@resource-id='entityName' and @text='" + entityName + "']");
    }

    public By deal(String index) {
        return By.xpath("//android.widget.TextView[@resource-id='dealTitle'][" + index + "]");
    }

    public void clickOnListedCategory(String listedCategoryName) {
        try {
            if (driver.findElement(listingCategories(listedCategoryName)).isDisplayed()) {
                System.out.println("Element not visible");
            } else {
                testUtil.verticalScroll(listedCategoryName);
                driver.findElement(listingCategories(listedCategoryName)).click();
            }
        } catch (Exception e) {
            testUtil.horizontalScroll(listedCategoryName);
            driver.findElement(listingCategories(listedCategoryName)).click();
        }
    }

    public void clickOnEntity(String entityName) {
        try {
            if (driver.findElement(entityName(entityName)).isDisplayed()) {
                System.out.println("Element not visible");
            } else {
                testUtil.verticalScroll(entityName);
                driver.findElement(entityName(entityName)).click();
            }
        } catch (Exception e) {
            testUtil.verticalScroll(entityName);
            driver.findElement(entityName(entityName)).click();
        }

    }

    public void clickOnDeal(String index) {
        try {
//            System.out.println(deal(index));
            if (driver.findElement(deal(index)).isDisplayed()) {
                driver.findElement(deal(index)).click();

            } else {
                System.out.println("Element not visible");
            }
        } catch (Exception e) {
//            testUtil.verticalScroll(entityName);
            driver.findElement(deal(index)).click();
        }

    }
}
