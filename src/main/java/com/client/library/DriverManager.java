package com.client.library;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private WebDriver driver;
    protected static ThreadLocal<WebDriver> driverthread = new ThreadLocal<>();

    public DriverManager(){}

    public static WebDriver getDriver(){
        if (driverthread == null) {
            throw new RuntimeException("Driver object is not instantiated, createWebdriver() in Driverclass should be called");
        }
        return driverthread.get();
    }

    public static void setDriver(WebDriver driver){driverthread.set(driver);}

    public WebDriver createDriver(Driver driver){
      this.driver =  driver.createDriver();
      setDriver(this.driver);
      return driverthread.get();
    }

    public void cleanDriver(){
       if(driverthread.get() != null){
           (driverthread.get()).quit();
       }
    }
}
