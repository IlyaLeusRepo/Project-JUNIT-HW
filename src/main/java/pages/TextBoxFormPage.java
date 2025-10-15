package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxFormPage extends BasePage {

    @FindBy(css = "input[id='userName']")
    public WebElement fullNameInput;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submitBtn;

    @FindBy(id = "name")
    public WebElement output;

    public TextBoxFormPage() {
        PageFactory.initElements(driver, this);
    }


}
