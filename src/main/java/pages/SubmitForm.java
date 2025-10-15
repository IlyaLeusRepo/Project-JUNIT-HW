package pages;

import driver.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.time.Duration;

@Getter
public class SubmitForm extends BasePage {

    public SubmitForm() {
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

    @FindBy(xpath = "//td[text()='Student Name']/following-sibling::td")
    private WebElement studentNameValue;

    @FindBy(xpath = "//td[text()='Student Email']/following-sibling::td")
    private WebElement studentEmailValue;

    @FindBy(xpath = "//td[text()='Mobile']/following-sibling::td")
    private WebElement studentMobileValue;

    @FindBy(xpath = "//td[text()='Date of Birth']/following-sibling::td")
    private WebElement studentDateOfBirthValue;

    @FindBy(xpath = "//td[text()='Gender']/following-sibling::td")
    private WebElement studentGenderValue;

    @FindBy(xpath = "//td[text()='Subjects']/following-sibling::td")
    private WebElement studentSubjectsValue;

    @FindBy(xpath = "//td[text()='Hobbies']/following-sibling::td")
    private WebElement studentHobbiesValue;

    @FindBy(xpath = "//td[text()='Address']/following-sibling::td")
    private WebElement studentCurrentAddressValue;

    @FindBy(xpath = "//button[@id='closeLargeModal']")
    private WebElement buttonClose;

    private void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(element));
    }
}
