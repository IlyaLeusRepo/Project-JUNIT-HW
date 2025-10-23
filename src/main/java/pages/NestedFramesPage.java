package pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class NestedFramesPage {
    @Getter
    private SelenideElement nestedFrame = $x("//div[text()='Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.']");

    @Getter
    private SelenideElement childFrame = $x("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]");

    @Getter
    private SelenideElement parentFrame = $x("//iframe[@id='frame1']");
}
