package com.example.tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.BasePage;

public class BaseTest {

    @BeforeAll
    static void setUpAll() {
        // Настройка один раз перед всеми тестами
        Configuration.browserSize = "2560x1440";
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }

    @BeforeEach
    void setUpEach() {
        // Открытие главной страницы перед каждым тестом
        System.out.println(">>> [BeforeEach] Открыта главная страница DemoQA.");
    }

    @AfterEach
    public void cleanUp(){
        BasePage.driver.quit();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }

    @AfterAll
    static void tearDownAll() {
        // Опционально: можно очистить кэш, отчеты и т.д.
        System.out.println(">>> [AfterAll] Все тесты завершены. Глобальная очистка.");
    }
}
