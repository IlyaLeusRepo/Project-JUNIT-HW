package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class WidgetsPage {

    @Getter
    private SelenideElement progressBarButtonInMenu = $x("//span[text()='Progress Bar']");

    @Getter
    private SelenideElement startButton = $x("//*[@id='startStopButton']");

    @Getter
    private SelenideElement elementProgressBar = $x("//*[@role='progressbar']");

    @Getter
    private SelenideElement elementSelectMenu = $x("//span[text()='Select Menu']");

    @Getter
    private SelenideElement elementOldSelectMenu = $x("//*[@id='oldSelectMenu']");

    @Getter
    private SelenideElement elementMultiSelect = $x("//p[b[text()='Multiselect drop down']]/following-sibling::div");

    @Getter
    private SelenideElement elementMultiGreen = $x("//*[@id='react-select-4-option-0']");

    @Getter
    private SelenideElement elementMultiBlue = $x("//*[@id='react-select-4-option-1']");

    @Getter
    private ElementsCollection elementsMultiDropDown = $$("div.css-1rhbuit-multiValue div.css-12jo7m5");





}
