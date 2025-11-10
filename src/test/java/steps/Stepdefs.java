package steps;

import com.codeborne.selenide.*;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.cucumber.java.uk.Дано;
import org.junit.jupiter.api.Assertions;
import pages.AlertsFrameWindowsPage;
import pages.NestedFramesPage;
import pages.WidgetsPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stepdefs {

    @Дано("открыт сайт {string}")
    public void openDemo(String url) {
        Selenide.open(url);

    }

    @Когда("сделан клик по кнопке {string}")
    public void clickAlertsButton(String str) {
        $(byText(str)).click();
    }

    @Тогда("в меню отображаются шесть подпунктов")
    public void elementsMenuCount() {
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        Assertions.assertTrue(alertsFrameWindowsPage.getBrowserWindow().isDisplayed(), "Карточка с название Browser Windows присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getAlerts().isDisplayed(), "Карточка с название Alerts присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getFrames().isDisplayed(), "Карточка с название Frames присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getNestedFrames().isDisplayed(), "Карточка с название Nested Frames присутствует");
        Assertions.assertTrue(alertsFrameWindowsPage.getModalDialogs().isDisplayed(), "Карточка с название Modal Dialogs присутствует");
    }

    @Когда("нажимаем на пункт Nested Frames")
    public void openNestedFrames() {
        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.getNestedFrames().click();
    }

    @Тогда("форма содержит текст Sample Nested Iframe page")
    public void checkNestedFrames() {
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        nestedFramesPage.getNestedFrame().shouldHave(text("Sample Nested Iframe page"));
    }

    @Когда("переходим во вложенный фрейм")
    public void openChildFrame() {
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        switchTo().frame(nestedFramesPage.getParentFrame());
        switchTo().frame(nestedFramesPage.getChildFrame());
    }

    @Тогда("фрейм содержит текст Child frame")
    public void checkTextChildFrame() {
        assertEquals("Child Iframe", $("body").text());
    }

    @Когда("переходим в родительский фрейм")
    public void openParentFrame() {
        switchTo().parentFrame();
    }

    @Затем("переходим в основной документ")
    public void openMainDoc() {
        switchTo().defaultContent();
    }

    @Тогда("фрейм содержит текст Parent frame")
    public void checkTextParentframe() {
        assertEquals("Parent frame", $("body").text());
    }

    @Когда("^сделан клик по \"(.*?)\"$")
    public void clickWidgetsButton(String str) {
        $(byText(str)).click();
    }

    @И("в меню Widgets сделан клик по пункту Progress Bar")
    public void openProgressbar() {
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getProgressBarButtonInMenu().click();
    }

    @Тогда("на форме имеется кнопка с текстом Start")
    public void checkButtonStart() {
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getStartButton().shouldHave(text("Start"));
    }

    @Когда("сделан клик по кнопке Start")
    public void clickButtonStart() {
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getStartButton().click();
    }

    @Тогда("на форме имеется кнопка с текстом Stop")
    public void chechTextStop() {
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getStartButton().shouldHave(text("Stop"));
    }

    @Когда("прогресс бар достиг отметки 30%")
    public void chechProgressbar() {
        WidgetsPage widgetsPage = new WidgetsPage();
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

    @И("после сделан клик по пункту Select menu")
    public void clickSelectmenu() {
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getElementSelectMenu().click();
    }

    @Затем("в выпадающем списке Old Select Menu выбрать значение")
    public void clickSelectOldMenu() {
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getElementOldSelectMenu().click();
        widgetsPage.getElementOldSelectMenu().selectOptionByValue("1");
    }

    @Тогда("в списке выбрано требуемое значение")
    public void checkSelectOldMenu() {
        WidgetsPage widgetsPage = new WidgetsPage();
        Assertions.assertEquals("Blue", widgetsPage.getElementOldSelectMenu().getSelectedOptionText(), "Имя не соответствует");
    }

    @Когда("в выпадающем списке Multi select drop down выбрано несколько значений {string}")
    public void clickMultiSelect(String color) {
        WidgetsPage widgetsPage = new WidgetsPage();
        widgetsPage.getElementMultiSelect().click();
        if (color == "greenBlue") {
            widgetsPage.getElementMultiGreen().click();
            widgetsPage.getElementMultiBlue().click();
        } else {
            widgetsPage.getElementMultiBlue().click();
            widgetsPage.getElementMultiBlack().click();
        }

    }

    @Тогда("в списке выбраны несколько значений {string}")
    public void checkMultiSelect(String color) {
        WidgetsPage widgetsPage = new WidgetsPage();
        ElementsCollection selectedValues = widgetsPage.getElementsMultiDropDown();
        selectedValues.shouldHave(CollectionCondition.size(2));
        String firstText = selectedValues.get(0).getText();
        String secondText = selectedValues.get(1).getText();

        if (color == "greenBlue") {
            Assertions.assertEquals("Green", firstText, "Имя не соответствует");
            Assertions.assertEquals("Blue", secondText, "Имя не соответствует");
        } else {
            Assertions.assertEquals("Blue", firstText, "Имя не соответствует");
            Assertions.assertEquals("Black", secondText, "Имя не соответствует");
        }
    }


}
