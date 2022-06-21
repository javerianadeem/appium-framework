package com.qa.android.pages;

//import com.qa.android.test.AppFactory;
import base.AppFactory;
//import com.qa.android.test.AppFactory;
import org.openqa.selenium.By;

public class Header extends AppFactory {
    public By backButton(){return By.xpath("//android.widget.TextView[@resource-id='backButton']");}

    public void clickOnBackButton(){
        driver.findElement(backButton()).click();
    }
}
