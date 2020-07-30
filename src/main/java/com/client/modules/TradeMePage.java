package com.client.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TradeMePage {

    public WebDriver driver;

    @FindAll(
            @FindBy(xpath = "//li[contains(@id,'SearchTabs1')]/a")
    )
    public List<WebElement> lstLstMainMenuItem;

    @FindAll(
            @FindBy(css = "#SiteNavigation .sub-nav li")
    )
    public List<WebElement> lstSubMenuItem;

    @FindAll(
            @FindBy(css = "#makes tr td a")
    )
    public List<WebElement> lstUsedCarsMakes;

    @FindAll(
        @FindBy(xpath = "//ul[@id='ListViewList']/li[1]//div/a")
    )
    public List<WebElement> lstUsedCarsList;

    @FindAll(
            @FindBy(xpath = "//div[@id='AttributesDisplay_attributesSection']//li/div[1]")
    )
    public List<WebElement> lstUsedCarsDetails;

    public TradeMePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement selectSubMenu(String subMenuName){
        return lstSubMenuItem
                .stream()
                .filter(items -> items.getText().toLowerCase().equals(subMenuName.toLowerCase()))
                .findFirst().get();
    }

    public WebElement selectMainMenu(String mainMenuName){
        return lstLstMainMenuItem
                .stream()
                .filter(items -> items.getText().toLowerCase().equals(mainMenuName.toLowerCase()))
                .findFirst().get();
    }

    public WebElement checkUsedCarsBrand(String brandName){
        return lstUsedCarsMakes
                .stream()
                .filter(items -> items.getText().toLowerCase().contains(brandName.toLowerCase()))
                .findFirst().get();
    }

    public WebElement getUsedCarsList(String brandName){
        return lstUsedCarsList
                .stream()
                .filter(items -> items.getText().toLowerCase().contains(brandName.toLowerCase()))
                .findFirst().get();
    }

    public List<String> getUsedCarDetailsList(){
       return lstUsedCarsDetails.stream()
                .filter(items -> !(items.getText().isEmpty()))
                .map(items -> items.getText())
                .collect(Collectors.toList());
    }
}
