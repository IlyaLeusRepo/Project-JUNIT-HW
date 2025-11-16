package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class WidgetsPage {

    @Getter
    private final SelenideElement progressBarMenu = $x("//span[text()='Progress Bar']");
    @Getter
    private final SelenideElement startButton = $x("//*[@id='startStopButton']");
    @Getter
    private final SelenideElement progressBar = $x("//*[@role='progressbar']");
    @Getter
    private final SelenideElement selectMenu = $x("//span[text()='Select Menu']");
    @Getter
    private final SelenideElement oldSelectMenu = $x("//*[@id='oldSelectMenu']");
    @Getter
    private final SelenideElement multiSelect = $x("//p[b[text()='Multiselect drop down']]/following-sibling::div");
    @Getter
    private final SelenideElement greenOption = $x("//*[@id='react-select-4-option-0']");
    @Getter
    private final SelenideElement blueOption = $x("//*[@id='react-select-4-option-1']");
    @Getter
    private final ElementsCollection selectedMultiValues =
            $$("div.css-1rhbuit-multiValue div.css-12jo7m5");

    @Step("Открываем Progress Bar в меню")
    public void openProgressBarMenu() {
        progressBarMenu.click();
        AllureUtils.screenshot();
    }

    @Step("Запускаем progress bar")
    public void startProgressBar() {
        startButton.click();
        AllureUtils.screenshot();
    }

    @Step("Останавливаем progress bar")
    public void stopProgressBar() {
        startButton.click();
        AllureUtils.screenshot();
    }

    @Step("Ждём значение progress bar ≥ {minValue}%")
    public void waitProgressBarAtLeast(int minValue) {
        progressBar.shouldHave(
                Condition.match(
                        "Progress at least " + minValue + "%",
                        element -> {
                            String value = element.getAttribute("aria-valuenow");
                            return value != null && Integer.parseInt(value) >= minValue;
                        }
                ),
                Duration.ofSeconds(10)
        );
        AllureUtils.screenshot();
    }

    @Step("Открываем Select Menu")
    public void openSelectMenu() {
        selectMenu.click();
        AllureUtils.screenshot();
    }

    @Step("Открываем Old Select Menu")
    public void openOldSelectMenu() {
        oldSelectMenu.click();
    }

    @Step("Выбираем значение {value} в Old Select Menu")
    public void chooseOldSelectMenuValue(String value) {
        oldSelectMenu.selectOptionByValue(value);
    }

    @Step("Проверяем выбранное значение Old Select Menu: {expected}")
    public void verifyOldSelectMenuValue(String expected) {
        String actual = oldSelectMenu.getSelectedOptionText();
        Assertions.assertEquals(expected, actual, "Имя не соответствует");
    }

    @Step("Открываем Multi Select")
    public void openMultiSelect() {
        multiSelect.click();
        AllureUtils.screenshot();
    }

    @Step("Добавляем Green в мультиселект")
    public void chooseGreen() {
        greenOption.click();
        AllureUtils.screenshot();
    }

    @Step("Добавляем Blue в мультиселект")
    public void chooseBlue() {
        blueOption.click();
        AllureUtils.screenshot();
    }

    @Step("Проверяем, что выбраны значения {expected1} и {expected2}")
    public void verifyMultiselectValues(String expected1, String expected2) {

        selectedMultiValues.shouldHave(CollectionCondition.size(2));

        selectedMultiValues.get(0).shouldHave(Condition.text(expected1));
        selectedMultiValues.get(1).shouldHave(Condition.text(expected2));

        AllureUtils.screenshot();
    }
}
