package com.example.tests.web.selenium.pages;

import com.example.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver = WebDriverManager.initWebDriver();
    private String basePageUrl = "https://demoqa.com";

    public DemoqaPage openDemoqaPage() {
        driver.get(basePageUrl);
        return new DemoqaPage();
    }

    public void openTab(WebElement webElement) {
        webElement.click();
    }

    public void fillField(WebElement element, String text) {
        element.sendKeys(text);
    }

    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public void close() {
        driver.quit();
    }
}
