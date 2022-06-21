package com.qa.android.pages;

import base.AppFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AppiumPage extends AppFactory {

    public By viewButton(){ return By.xpath("//android.widget.TextView[@content-desc='Views']");}
    public By dragAndDropButton(){ return By.xpath("//android.widget.TextView[@content-desc='Drag and Drop']");}
    public By draggable(){return By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']");}
    public By droppable(){return By.xpath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']");}
    public By imageSwitcherButton(){return By.xpath("//android.widget.TextView[@content-desc='ImageSwitcher']");}
    public By imageSlider(){return By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Gallery/android.widget.ImageView[1]");}
    public By accessibilityButton(){return By.xpath("//android.widget.TextView[@content-desc='Accessibility']");}
    public By accessibilityNodeQueringButton(){return By.xpath("//android.widget.TextView[@content-desc='Accessibility Node Querying']");}
    public By conquerWorldCheckbox(){return By.xpath("//android.widget.TextView[@text='Conquer World']//following-sibling::android.widget.CheckBox[@class='android.widget.CheckBox']");}

    public AppiumPage() throws IOException {
        PageFactory.initElements(driver, this);
    }
}
