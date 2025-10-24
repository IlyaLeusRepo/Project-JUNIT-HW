package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class AlertsFrameWindowsPage {

    @Getter
    private SelenideElement browserWindow = $x("//span[text()='Browser Windows']");

    @Getter
    private SelenideElement alerts = $x("//span[text()='Alerts']");

    @Getter
    private SelenideElement frames = $x("//span[text()='Frames']");

    @Getter
    private SelenideElement nestedFrames = $x("//span[text()='Nested Frames']");

    @Getter
    private SelenideElement modalDialogs = $x("//span[text()='Modal Dialogs']");
}
