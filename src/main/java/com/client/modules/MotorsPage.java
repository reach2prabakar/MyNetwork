package com.client.modules;

import com.client.helpers.AppHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MotorsPage extends TradeMePage {

    public MotorsPage(WebDriver driver){
        super(driver);
        waitForPage();
    }

    public void waitForPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(lstSubMenuItem.get(0)));
        assertThat("UsedCars page is not loaded",driver.getTitle(),equalTo("Selling a car or browse Utes, Caravans and more |Trade Me Motors"));
    }
}
