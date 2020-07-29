package com.client.modules;

import com.client.helpers.AppHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsedCarsPage extends TradeMePage {

    @FindBy(css = "#usedCars_Td #makes tbody tr")
    public WebElement tblUsedCars;

    @FindBy(id = "ListViewList")
    public WebElement lnkListing;

    public UsedCarsPage(WebDriver driver){
        super(driver);
        waitForPage();
    }

    public int getRowCount(){
        return tblUsedCars.findElements(By.tagName("td")).size();
    }

    public void waitForPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(tblUsedCars));
        assertThat("UsedCars page is not loaded",driver.getTitle(),
                equalTo("Car auctions | Used Cars for sale in New Zealand | Trade Me")
        );
    }
}
