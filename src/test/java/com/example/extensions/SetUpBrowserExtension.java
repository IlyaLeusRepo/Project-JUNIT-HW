package com.example.extensions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.extension.*;

public class SetUpBrowserExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback, AfterAllCallback {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(SetUpBrowserExtension.class);

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        Configuration.browser = "chrome";
        Configuration.browserSize = "2560x1440";
        Configuration.pageLoadTimeout = 20000;
        System.out.println(">>> [BeforeAll] Браузер настроен глобально.");
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        // Открытие главной страницы перед каждым тестом
        Selenide.open("https://demoqa.com/");
        System.out.println(">>> [BeforeEach] Открыта главная страница DemoQA.");
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        // Закрытие браузера после каждого теста
        Selenide.closeWebDriver();
        System.out.println(">>> [AfterEach] Браузер закрыт.");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception  {
        // Опционально: можно очистить кэш, отчеты и т.д.
        System.out.println(">>> [AfterAll] Все тесты завершены. Глобальная очистка.");
    }
}
