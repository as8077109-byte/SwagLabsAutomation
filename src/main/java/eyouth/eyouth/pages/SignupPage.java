package eyouth.eyouth.pages;

import eyouth.eyouth.utils.Waits;
import org.openqa.selenium.*;

public class SignupPage {

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signupBtn = By.linkText("انضم لنا");
    private By submitBtn = By.xpath("//button[contains(text(),'انشاء')]");

    public void openSignup() {
        Waits.waitForElement(driver, signupBtn).click();
    }

    public void submitEmpty() {
        Waits.waitForElement(driver, submitBtn).click();
    }
}