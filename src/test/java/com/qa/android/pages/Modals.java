package com.qa.android.pages;

import base.AppFactory;
//import com.qa.android.test.AppFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Modals extends AppFactory {

    public By closeIcon() { return By.xpath("//android.widget.Button[@resource-id='com.bogo.android:id/collapse_button']");}

//    @FindBy(id="com.bogo.android:id/collapse_button")
//    WebElement closeModalIcon;


    public Modals() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void closeModal() {
        try {
            System.out.println("hello");
            if (driver.findElement(closeIcon()).isDisplayed()) {
                driver.findElement(closeIcon()).click();
            }
            else {
                System.out.println("inside else");
//                closeModalIcon.click();
            }

        } catch (Exception e) {
            System.out.println("Exception" + e);
//            closeModalIcon.click();
            //System.out.println(e);
//            return false;
        }
    }
}
