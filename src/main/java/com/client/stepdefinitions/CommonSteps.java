package com.client.stepdefinitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonSteps {
    private static final Logger logger = LogManager.getLogger(CommonSteps.class);

    @Given("^Automation for (.*)$")
    public void captureTestId(String testId){
       logger.info("Test started for id:"+testId);
    }
}
