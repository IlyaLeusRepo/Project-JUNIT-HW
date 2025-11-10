package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 40000;
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1366,768");
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities = options;
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");

    }

    @After
    public void browserClosed() {
        closeWebDriver();
    }
}
