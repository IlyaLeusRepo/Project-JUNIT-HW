package com.example.tests.web.selenium.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementsPage extends BasePage {

    @Getter
    private WebElement textBoxTab = getWebElement(By.xpath("//span[text()='Text Box']"));

    @Getter
    private WebElement checkBoxTab = getWebElement(By.xpath("//span[contains(text(),'Check')]"));

    @Getter
    private WebElement radioBtnTab = getWebElement(By.xpath("//span[starts-with( . ,'Radio')]"));

    public TextBoxFormPage openTextBoxPage() {
        openTab(textBoxTab);
        return new TextBoxFormPage();
    }

}
