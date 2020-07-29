package com.client.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsedCarsDetailsPage extends TradeMePage {



    @FindAll(
            @FindBy(xpath = "//div[@id='AttributesDisplay_attributesSection']//li/div[1]")
    )
    public List<WebElement> lstUsedCarsDetails;

    public UsedCarsDetailsPage(WebDriver driver){
        super(driver);
        waitForPage();
    }

    public void waitForPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(lstUsedCarsDetails.get(0)));
        assertThat("UsedCars page is not loaded",driver.getTitle(), containsString(" | Trade Me"));
    }
}
