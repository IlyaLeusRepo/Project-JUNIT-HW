package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class AlertsFrameWindowsPage {

    @Getter private final SelenideElement browserWindow = $x("//span[text()='Browser Windows']");
    @Getter private final SelenideElement alerts = $x("//span[text()='Alerts']");
    @Getter private final SelenideElement frames = $x("//span[text()='Frames']");
    @Getter private final SelenideElement nestedFrames = $x("//span[text()='Nested Frames']");
    @Getter private final SelenideElement modalDialogs = $x("//span[text()='Modal Dialogs']");

    @Step("Проверяем видимость всех карточек раздела Alerts / Frames")
    public void verifyAllCardsVisible() {
        browserWindow.shouldBe().isDisplayed();
        alerts.shouldBe().isDisplayed();
        frames.shouldBe().isDisplayed();
        nestedFrames.shouldBe().isDisplayed();
        modalDialogs.shouldBe().isDisplayed();
        AllureUtils.screenshot();
    }

    @Step("Кликаем по карточке 'Nested Frames'")
    public void clickNestedFrames() {
        nestedFrames.click();
        AllureUtils.screenshot();
    }
}
