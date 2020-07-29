package com.client.processor;

import com.client.library.DriverManager;
import com.client.library.PropertyReader;
import org.openqa.selenium.WebDriver;

public class TradeMeTest {

    public WebDriver driver;
    public PropertyReader propertyReader;

    public TradeMeTest(){
        driver = DriverManager.getDriver();
        propertyReader = new PropertyReader();
    }

}
