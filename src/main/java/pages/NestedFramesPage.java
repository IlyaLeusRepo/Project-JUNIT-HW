package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class NestedFramesPage {

    @Getter private final SelenideElement nestedFrame =
            $x("//div[contains(text(), 'Sample Nested Iframe page')]");

    @Getter private final SelenideElement parentFrame =
            $x("//iframe[@id='frame1']");

    @Getter private final SelenideElement childFrame =
            $x("//iframe[@srcdoc='<p>Child Iframe</p>']");

    @Step("Проверяем заголовок Nested Frame")
    public void verifyNestedFrameHeader() {
        nestedFrame.shouldHave(text("Sample Nested Iframe page"));
        AllureUtils.screenshot();
    }

    @Step("Переходим в parent frame")
    public void switchToParentFrame() {
        switchTo().frame(parentFrame);
        AllureUtils.screenshot();
    }

    @Step("Переходим в child frame")
    public void switchToChildFrame() {
        switchTo().frame(childFrame);
        AllureUtils.screenshot();
    }

    @Step("Возвращаемся в parentFrame")
    public void switchToParent() {
        switchTo().parentFrame();
        AllureUtils.screenshot();
    }

    @Step("Возвращаемся в defaultContent")
    public void switchToDefault() {
        switchTo().defaultContent();
        AllureUtils.screenshot();
    }

    @Step("Проверяем текст в body должен быть '{expected}'")
    public void verifyBodyText(String expected) {
        $("body").shouldHave(text(expected));
        AllureUtils.screenshot();
    }
}
