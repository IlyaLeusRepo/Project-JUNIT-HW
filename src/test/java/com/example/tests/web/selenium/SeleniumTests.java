package com.example.tests.web.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;


public class SeleniumTests {

    @Test
    void checkElementsAndTextBoxTab() {
        System.setProperty("webdriver.gecko.driver", "/Users/ilyaleus/Downloads/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");

        WebElement elementsTab = driver.findElement(By.xpath("//h5[text()= 'Elements']"));
        elementsTab.click();

        WebElement textBoxTab = driver.findElement(By.xpath("//span[text()= 'Text Box']"));
        textBoxTab.click();

        WebElement fullNameInput = driver.findElement(By.cssSelector("input[id='userName']"));
        fullNameInput.click();
        fullNameInput.sendKeys("Jack Doe");

        WebElement emailInput = driver.findElement(By.cssSelector("input[id='userEmail']"));
        emailInput.click();
        emailInput.sendKeys("mail@mail.com");

        WebElement currentAddressInput = driver.findElement(By.cssSelector("textarea[id='currentAddress']"));
        currentAddressInput.click();
        currentAddressInput.sendKeys("Nsk");

        WebElement permanentAddressInput = driver.findElement(By.cssSelector("textarea[id='permanentAddress']"));
        permanentAddressInput.click();
        permanentAddressInput.sendKeys("Msk");

        WebElement submitInput = driver.findElement(By.xpath("//*[@id='submit']"));
        submitInput.click();

        WebElement resultName = driver.findElement(By.xpath("//*[@id='name']"));
        Assertions.assertEquals("Name:Jack Doe", resultName.getText(), "Имя не соответствует");

        WebElement resultEmail = driver.findElement(By.xpath("//*[@id='email']"));
        Assertions.assertEquals("Email:mail@mail.com", resultEmail.getText(), "Email не соответствует");

        WebElement resultCurrentAddress = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        Assertions.assertEquals("Current Address :Nsk", resultCurrentAddress.getText(), "CurrentAddress не соответствует");

        WebElement resultPermanentAddress = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        Assertions.assertEquals("Permananet Address :Msk", resultPermanentAddress.getText(), "PermanentAddress не соответствует");


        driver.quit();


    }

}
