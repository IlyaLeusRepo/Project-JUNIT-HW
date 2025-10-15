package com.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    public static WebDriver initWebDriver() {
        WebDriver driver = null;

        try {
            System.setProperty("webdriver.gecko.driver", "/Users/ilyaleus/Downloads/geckodriver");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
        return driver;
    }
}

