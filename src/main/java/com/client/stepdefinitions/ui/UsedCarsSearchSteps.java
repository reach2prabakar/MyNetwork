package com.client.stepdefinitions.ui;

import com.client.helpers.AppHelpers;
import com.client.helpers.Validator;
import com.client.modules.*;
import com.client.processor.TradeMeTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class UsedCarsSearchSteps extends TradeMeTest {

    LandingPage landingPage = new LandingPage(driver);

    @Given("^user opens TradeMe application$")
    public void loadApplication(){
        landingPage.loadUrl();
    }

    @When("^user navigated to the (.*) menu option$")
    public void navigateToMainMenu(String tabName){
        String test = landingPage.selectMainMenu(tabName).getText();
        landingPage.selectMainMenu(tabName).click();
    }

    @And("^she navigates to the (.*) options$")
    public void navigateToSubMenu(String subMenu){
        MotorsPage motorsPage = new MotorsPage(driver);
        motorsPage.selectSubMenu(subMenu).click();
    }

    @Then("^she finds atleast one listing in the submenu options$")
    public void getTotalAvailableListing(){
        UsedCarsPage usedCarsPage = new UsedCarsPage(driver);
        int listingCount = usedCarsPage.getRowCount();
        assertThat("Used cars does not have minimum of 1 listing",listingCount,greaterThanOrEqualTo(1));
    }

    @Then("^she checks for the used car with brand (.*) exist$")
    public void searchForCarBrand(String brandName){
        UsedCarsPage usedCarsPage = new UsedCarsPage(driver);
        String usedCarBrandName = usedCarsPage.checkUsedCarsBrand(brandName).getText();
        assertThat("brand - "+brandName+" - does not exist in the used car list" ,usedCarBrandName,equalTo(brandName));
    }

    @And("^users navigates to the used cars details page$")
    public void selectUsedCarsDetails(){
        UsedCarsPage usedCarsPage = new UsedCarsPage(driver);
        usedCarsPage.getUsedCarsList("Jeep").click();
        new UsedCarsDetailsPage(driver);
    }

    @Then("^User can view the following details of the car")
    public void viewUsedCarsDetails(DataTable dataTable) {
        List<String> detailsList = dataTable.asList();
        UsedCarsDetailsPage usedCarsDetailsPage = new UsedCarsDetailsPage(driver);
        List<String> detailsListUI = usedCarsDetailsPage.getUsedCarDetailsList();
        List<List<String>> resultList = Validator.listDiffer(detailsList, detailsListUI);
        assertThat("VehicleDetails list in the application is/are mismatched with the Testdata. \n" +
                        "Mismatched Testdata vs Application data  : \n -->>"+resultList.get(0).toString()+" | " +
                    resultList.get(1).toString(),
                resultList.size()==0);
    }
}
