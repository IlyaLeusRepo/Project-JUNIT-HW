package com.example.tests.web.selenide.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.tests.web.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SelenideTests extends BaseTest {

    @Test
    void checkFrameInAlertsPageTest() {

        $x("//h5[text()= 'Alerts, Frame & Windows']").click();
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();

        Assertions.assertTrue(alertsFrameWindowsPage.getBrowserWindow().isDisplayed(), "Карточка с название Browser Windows присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getAlerts().isDisplayed(), "Карточка с название Alerts присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getFrames().isDisplayed(), "Карточка с название Frames присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getNestedFrames().isDisplayed(), "Карточка с название Nested Frames присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getModalDialogs().isDisplayed(), "Карточка с название Modal Dialogs присутствует");

        alertsFrameWindowsPage.getNestedFrames().click();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        nestedFramesPage.getNestedFrame().shouldHave(text("Sample Nested Iframe page"));
        switchTo().frame(nestedFramesPage.getParentFrame());
        switchTo().frame(nestedFramesPage.getChildFrame());
        assertEquals("Child Iframe", $("body").text());
        switchTo().parentFrame();
        assertEquals("Parent frame", $("body").text());
        switchTo().defaultContent();
        nestedFramesPage.getNestedFrame().shouldHave(text("Sample Nested Iframe page"));

    }

    @Test
    void checkProgressBarInWidgetPageTest() {

        $x("//h5[text()= 'Widgets']").click();
        WidgetsPage widgetsPage = new WidgetsPage();

        widgetsPage.getProgressBarButtonInMenu().click();
        widgetsPage.getStartButton().shouldHave(text("Start"));
        widgetsPage.getStartButton().click();
        widgetsPage.getStartButton().shouldHave(text("Stop"));

        SelenideElement progressBar = widgetsPage.getElementProgressBar();

        try {
            progressBar.shouldHave(Condition.match("Progress at least 30%",
                    element -> {
                        String value = element.getAttribute("aria-valuenow");
                        return value != null && Integer.parseInt(value) >= 30;
                    }), Duration.ofSeconds(10));
            widgetsPage.getStartButton().click();

        } catch (Exception e) {
            String currentValue = progressBar.getAttribute("aria-valuenow");
            System.out.println("Прогресс бар не достиг 30%. Текущее значение: " + currentValue + "%");
            widgetsPage.getStartButton().click();
            throw e;
        }

    }

    @Test
    void checkDropDownInWidgetPageTest() {

        $x("//h5[text()= 'Widgets']").click();
        WidgetsPage widgetsPage = new WidgetsPage();

        widgetsPage.getElementSelectMenu().click();
        widgetsPage.getElementOldSelectMenu().click();
        widgetsPage.getElementOldSelectMenu().selectOptionByValue("1");
        Assertions.assertEquals("Blue", widgetsPage.getElementOldSelectMenu().getSelectedOptionText(), "Имя не соответствует");

        widgetsPage.getElementMultiSelect().click();
        widgetsPage.getElementMultiGreen().click();
        widgetsPage.getElementMultiBlue().click();

        ElementsCollection selectedValues = widgetsPage.getElementsMultiDropDown();
        selectedValues.shouldHave(CollectionCondition.size(2));

        String firstText = selectedValues.get(0).getText();
        String secondText = selectedValues.get(1).getText();
        Assertions.assertEquals("Green", firstText, "Имя не соответствует");
        Assertions.assertEquals("Blue", secondText, "Имя не соответствует");

    }

}
