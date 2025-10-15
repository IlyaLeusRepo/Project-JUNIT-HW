package com.example.tests.web.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoqaPage extends BasePage{

    @Getter
    @FindBy(xpath = "//h5[text()= 'Elements']")
    private WebElement elementsTab;

    @Getter
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsTab;

    @Getter
    @FindBy(xpath = "//h5[text()= 'Widgets']")
    private WebElement widgetsTab;

    public DemoqaPage() {
        PageFactory.initElements(driver, this);
    }

    public ElementsPage openElementsPage() {
        openTab(elementsTab);
        return new ElementsPage();
    }

    public FormsPage openFormsPage() {
        openTab(formsTab);
        return  new FormsPage();
    }

    public WidgetsPage openWidgetsPage() {
        openTab(widgetsTab);
        return new WidgetsPage();
    }



}
