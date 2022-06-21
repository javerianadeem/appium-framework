package com.qa.android.pages;

import org.openqa.selenium.By;

public class CityScreen {
    public By cities(String cityName) { return By.xpath("//android.widget.TextView[@resource-id='cityName' and @text='" + cityName + "']");}
}
