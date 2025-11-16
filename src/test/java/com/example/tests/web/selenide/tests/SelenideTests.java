package com.example.tests.web.selenide.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.example.tests.web.BaseTest;
import io.qameta.allure.*;
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

@Epic("Тестирование тренажера DemoQA")
@Feature("Проверки элементов форм")
public class SelenideTests extends BaseTest {

    @Test
    @Story("Проверка раздела Alerts, Frame & Windows")
    void checkFrameInAlertsPageTest() {

        $x("//h5[text()='Alerts, Frame & Windows']").click();

        AlertsFrameWindowsPage alerts = new AlertsFrameWindowsPage();
        NestedFramesPage nested = new NestedFramesPage();

        alerts.verifyAllCardsVisible();
        alerts.clickNestedFrames();

        nested.verifyNestedFrameHeader();
        nested.switchToParentFrame();
        nested.switchToChildFrame();
        nested.verifyBodyText("Child Iframe");
        nested.switchToParent();
        nested.verifyBodyText("Parent frame");
        nested.switchToDefault();
        nested.verifyNestedFrameHeader();
    }

    @Test
    @Story("Проверка раздела Widgets")
    void checkProgressBarInWidgetPageTest() {

        $x("//h5[text()='Widgets']").click();
        WidgetsPage widgets = new WidgetsPage();

        widgets.openProgressBarMenu();
        widgets.startProgressBar();
        widgets.waitProgressBarAtLeast(30);
        widgets.stopProgressBar();
    }

    @Test
    @Story("Проверка Select и MultiSelect")
    void checkDropDownInWidgetPageTest() {

        $x("//h5[text()='Widgets']").click();
        WidgetsPage widgets = new WidgetsPage();

        widgets.openSelectMenu();
        widgets.openOldSelectMenu();
        widgets.chooseOldSelectMenuValue("1");
        widgets.verifyOldSelectMenuValue("Blue");

        widgets.openMultiSelect();
        widgets.chooseGreen();
        widgets.chooseBlue();
        widgets.verifyMultiselectValues("Green", "Blue");
    }

}
