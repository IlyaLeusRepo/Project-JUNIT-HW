package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PracticeFormPage extends BasePage{

    @Getter
    private WebElement firstName = getWebElement(By.xpath("//input[@placeholder='First Name']"));

    @Getter
    private WebElement lastName = getWebElement(By.xpath("//input[@placeholder='Last Name']"));

    @Getter
    private WebElement email = getWebElement(By.xpath("//input[@placeholder='name@example.com']"));

    @Getter
    private WebElement male = getWebElement(By.xpath("//div[@class='custom-control custom-radio custom-control-inline']"));

    @Getter
    private WebElement female = getWebElement(By.xpath("//input[@value='Female']"));

    @Getter
    private WebElement other = getWebElement(By.xpath("//input[@value='Other']"));

    @Getter
    private WebElement mobileNumber = getWebElement(By.xpath("//input[@placeholder='Mobile Number']"));

    @Getter
    private WebElement dateOfBirth = getWebElement(By.xpath("//input[@id='dateOfBirthInput']"));

    @Getter
    private WebElement subjects = getWebElement(By.xpath("//*[@id='subjectsInput']"));

    @Getter
    private WebElement sports = getWebElement(By.xpath("//*[text()='Sports']"));

    @Getter
    private WebElement reading = getWebElement(By.xpath("//*[text()='Reading']"));

    @Getter
    private WebElement music = getWebElement(By.xpath("//*[text()='Music']"));

    @Getter
    private WebElement picture = getWebElement(By.xpath("//*[@id='uploadPicture']"));

    @Getter
    private WebElement currentAddress = getWebElement(By.xpath("//textarea[@placeholder='Current Address']"));

    @Getter
    private WebElement state = getWebElement(By.xpath("//div[text()='Select State']"));

    @Getter
    private WebElement city = getWebElement(By.xpath("//div[text()='Select City']"));

    @Getter
    private WebElement submit = getWebElement(By.xpath("//*[@id='submit']"));
}
