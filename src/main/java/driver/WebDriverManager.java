package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static WebDriver driver;

    private static WebDriver initWebDriver() {
        try {
            //System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            //System.setProperty("webdriver.gecko.driver", "/Users/ilyaleus/Documents/Project-HW/src/test/resources/geckodriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (Exception e) {
            e.printStackTrace();
            driver.quit();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            return initWebDriver();
        } else {
            return driver;
        }
    }
}

