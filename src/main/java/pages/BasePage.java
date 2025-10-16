package pages;

import driver.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.time.Duration;

public class BasePage {
    public static WebDriver driver = WebDriverManager.getDriver();
    private String basePageUrl = "https://demoqa.com";

    public DemoQaPage openDemoqaPage() {
        driver.get(basePageUrl);
        return new DemoQaPage();
    }

    public void clickElement(WebElement webElement) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(webElement))
                    .click();
        } catch (ElementClickInterceptedException exception) {
            JavascriptExecutor jsExec = (JavascriptExecutor) driver;
            jsExec.executeScript("arguments[0].click();", webElement);
        }
    }

    public void fillField(WebElement element, String text) {
        element.sendKeys(text);
    }

    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public static void waitForAllVisibleElements(Object page, WebDriver driver, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        for (Field field : page.getClass().getDeclaredFields()) {
            if (WebElement.class.isAssignableFrom(field.getType())) {
                field.setAccessible(true);
                try {
                    WebElement element = (WebElement) field.get(page);
                    wait.until(ExpectedConditions.visibilityOf(element));
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка ожидания элемента: " + field.getName(), e);
                }
            }
        }
    }
}
