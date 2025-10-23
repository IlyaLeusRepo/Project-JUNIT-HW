package com.example.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BaseTest {

    @BeforeAll
    static void setUpAll() {
        // Настройка один раз перед всеми тестами
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

    @BeforeEach
    void setUpEach() {
        // Открытие главной страницы перед каждым тестом
        Selenide.open("https://demoqa.com/");
        System.out.println(">>> [BeforeEach] Открыта главная страница DemoQA.");
    }

    @AfterEach
    void tearDownEach() {
        // Закрытие браузера после каждого теста
        Selenide.closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }

    @AfterAll
    static void tearDownAll() {
        // Опционально: можно очистить кэш, отчеты и т.д.
        System.out.println(">>> [AfterAll] Все тесты завершены. Глобальная очистка.");
    }
}