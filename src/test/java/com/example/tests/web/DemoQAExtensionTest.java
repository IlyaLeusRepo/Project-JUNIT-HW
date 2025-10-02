package com.example.tests.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.example.extensions.SetUpBrowserExtension;
import com.example.extensions.anno.SetUpBrowser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@ExtendWith(SetUpBrowserExtension.class)
public class DemoQAExtensionTest {

    @Test
    @SetUpBrowser(url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Минимальное заполнение формы Practice Form")
    void shouldSubmitMinimalPracticeForm() {
        // Заполняем обязательные поля
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $x("//*[@value='Male']/..").click();
        $("#userNumber").setValue("1234567890");

        // Отправляем форму
        $("#submit").click();

        // Проверяем, что появилось модальное окно с подтверждением
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));

        // Дополнительно: проверим, что имя отображается в результатах
        $(".table").shouldHave(Condition.text("John Doe"));
        $(".table").shouldHave(Condition.text("John Doe"));
    }
}
