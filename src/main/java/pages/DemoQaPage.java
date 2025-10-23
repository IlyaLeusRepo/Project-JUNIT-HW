package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQaPage extends BasePage {

    @Getter
    @FindBy(xpath = "//h5[text()= 'Elements']")
    private WebElement elementsTab;

    @Getter
    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement formsTab;

    @Getter
    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement practicePage;

    @Getter
    @FindBy(xpath = "//h5[text()= 'Widgets']")
    private WebElement widgetsTab;

    @Getter
    @FindBy(xpath = "//h5[text()= 'Alerts, Frame & Windows']")
    private WebElement AlertsFrameWindowsTab;



    public DemoQaPage() {
        PageFactory.initElements(driver, this);
    }

    public ElementsPage openElementsPage() {
        clickElement(elementsTab);
        return new ElementsPage();
    }

    public FormsPage openFormsPage() {
        clickElement(formsTab);
        clickElement(practicePage);
        return new FormsPage();
    }

    public WidgetsPage openWidgetsPage() {
        clickElement(widgetsTab);
        return new WidgetsPage();
    }

    public AlertsFrameWindowsPage openAlertsFrameWindowsPage() {
        clickElement(AlertsFrameWindowsTab);
        return new AlertsFrameWindowsPage();
    }


}
