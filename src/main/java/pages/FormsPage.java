package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage {

    @FindBy(xpath = "//span[@class='text' and text()='Practice Form']")
    private WebElement practiceForm;

    public PracticeFormPage openPracticeFormPage() {
        clickElement(practiceForm);
        return new PracticeFormPage();
    }


}
