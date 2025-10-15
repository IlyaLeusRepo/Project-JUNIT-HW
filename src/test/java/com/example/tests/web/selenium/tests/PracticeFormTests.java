package com.example.tests.web.selenium.tests;


import com.example.tests.web.selenium.pages.BasePage;
import com.example.tests.web.selenium.pages.DemoqaPage;
import com.example.tests.web.selenium.pages.FormsPage;
import com.example.tests.web.selenium.pages.PracticeFormPage;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class PracticeFormTests {
    @Test
    void checkSendPracticeFormTest() {
        DemoqaPage demoqaPage = new BasePage().openDemoqaPage();
        Assertions.assertTrue(demoqaPage.getFormsTab().isDisplayed(), "Карточка с название Forms присутствует");

        FormsPage formsPage = demoqaPage.openFormsPage();

        PracticeFormPage practiceFormPage = new PracticeFormPage();

        practiceFormPage.openTab(practiceFormPage.getFirstName());
        practiceFormPage.fillField(practiceFormPage.getFirstName(), "Jack");

        practiceFormPage.openTab(practiceFormPage.getLastName());
        practiceFormPage.fillField(practiceFormPage.getLastName(), "Doe");

        practiceFormPage.openTab(practiceFormPage.getEmail());
        practiceFormPage.fillField(practiceFormPage.getEmail(), "xxx@gmail.com");

        practiceFormPage.openTab(practiceFormPage.getMale());

        practiceFormPage.openTab(practiceFormPage.getMobileNumber());
        practiceFormPage.fillField(practiceFormPage.getMobileNumber(), "5646456456");

        practiceFormPage.openTab(practiceFormPage.getSports());

        practiceFormPage.openTab(practiceFormPage.getCurrentAddress());
        practiceFormPage.fillField(practiceFormPage.getCurrentAddress(), "Nsk");

        practiceFormPage.openTab(practiceFormPage.getSubmit());


        //Проверка соответствия информации в полях формы
        Assertions.assertEquals("Jack Doe", practiceFormPage.getStudentNameValue().getText(), "Имя не соответствует");
        Assertions.assertEquals("xxx@gmail.com", practiceFormPage.getStudentEmailValue().getText(), "Email не соответствует");
        Assertions.assertEquals("Male", practiceFormPage.getStudentGenderValue().getText(), "Пол не соответствует");
        Assertions.assertEquals("+5646456456", practiceFormPage.getStudentMobileValue().getText(),"Номер телефона не соответствует");

        practiceFormPage.openTab(practiceFormPage.getButtonClose());

        //Проверка после закрытия, что все поля очистились и чекбоксы доступны для нажатия
        Assert.isTrue(practiceFormPage.getFirstName().getAttribute("value").isEmpty(),"Поле не пустое");
        Assert.isTrue(practiceFormPage.getLastName().getAttribute("value").isEmpty(),"Поле не пустое");
        Assert.isTrue(practiceFormPage.getEmail().getAttribute("value").isEmpty(),"Поле не пустое");
        Assert.isTrue(practiceFormPage.getFirstName().isSelected(),"Поле не пустое");
        Assert.isTrue(practiceFormPage.getMobileNumber().getAttribute("value").isEmpty(),"Поле не пустое");

        demoqaPage.close();

    }
}
