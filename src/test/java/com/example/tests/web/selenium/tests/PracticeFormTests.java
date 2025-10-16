package com.example.tests.web.selenium.tests;


import com.example.tests.web.BaseTest;
import driver.WebDriverManager;
import pages.BasePage;
import pages.DemoQaPage;
import pages.FormsPage;
import pages.PracticeFormPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.SubmitForm;

import java.time.Duration;


class PracticeFormTests extends BaseTest {

    @Test
    void checkSendPracticeFormTest() {
        DemoQaPage demoqaPage = new BasePage().openDemoqaPage();
        Assertions.assertTrue(demoqaPage.getFormsTab().isDisplayed(), "Карточка с название Forms присутствует");

        FormsPage formsPage = demoqaPage.openFormsPage();

        PracticeFormPage practiceFormPage = new PracticeFormPage();

        practiceFormPage.clickElement(practiceFormPage.getFirstName());
        practiceFormPage.fillField(practiceFormPage.getFirstName(), "Jack");

        practiceFormPage.clickElement(practiceFormPage.getLastName());
        practiceFormPage.fillField(practiceFormPage.getLastName(), "Doe");

        practiceFormPage.clickElement(practiceFormPage.getEmail());
        practiceFormPage.fillField(practiceFormPage.getEmail(), "xxx@gmail.com");

        practiceFormPage.clickElement(practiceFormPage.getMale());

        practiceFormPage.clickElement(practiceFormPage.getMobileNumber());
        practiceFormPage.fillField(practiceFormPage.getMobileNumber(), "5646456456");

        practiceFormPage.clickElement(practiceFormPage.getSports());

        practiceFormPage.clickElement(practiceFormPage.getCurrentAddress());
        practiceFormPage.fillField(practiceFormPage.getCurrentAddress(), "Nsk");

        practiceFormPage.clickElement(practiceFormPage.getSubmit());


        //Проверка соответствия информации в полях формы
        SubmitForm submitForm = new SubmitForm();
        BasePage.waitForAllVisibleElements(submitForm, WebDriverManager.getDriver(), Duration.ofSeconds(5));
        Assertions.assertEquals("Jack Doe", submitForm.getStudentNameValue().getText(), "Имя не соответствует");
        Assertions.assertEquals("xxx@gmail.com", submitForm.getStudentEmailValue().getText(), "Email не соответствует");
        Assertions.assertEquals("Male", submitForm.getStudentGenderValue().getText(), "Пол не соответствует");
        Assertions.assertEquals("5646456456", submitForm.getStudentMobileValue().getText(),"Номер телефона не соответствует");

        submitForm.clickElement(submitForm.getButtonClose());

        //Проверка после закрытия, что все поля очистились и чекбоксы доступны для нажатия
        Assert.isTrue(practiceFormPage.getFirstName().getAttribute("value").isEmpty(),"Поле не пустое");
        Assert.isTrue(practiceFormPage.getLastName().getAttribute("value").isEmpty(),"Поле не пустое");
        Assert.isTrue(practiceFormPage.getEmail().getAttribute("value").isEmpty(),"Поле не пустое");
        Assert.isTrue(!practiceFormPage.getMale().isSelected(),"Поле не пустое");
        Assert.isTrue(practiceFormPage.getMobileNumber().getAttribute("value").isEmpty(),"Поле не пустое");

    }
}
