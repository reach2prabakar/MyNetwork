package com.client.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppHelpers {

    private static WebDriverWait webDriverWait;
    private static JavascriptExecutor jsExec;
    private WebDriver driver;

    public AppHelpers(WebDriver driver){
        this.driver = driver;
    }

    public void waitForJsReady(){
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").toString().equals("complete");
            boolean jsReady = true;
            jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");
            if (!jsReady) {
                webDriverWait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }catch(NullPointerException e){
        }
    }
}
