package eyouth.eyouth.pages;

import eyouth.eyouth.utils.Waits;
import org.openqa.selenium.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginLink = By.linkText("تسجيل الدخول");
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[contains(text(),'Login')]");

    public void openLogin() {
        Waits.waitForElement(driver, loginLink).click();
    }

    public void login(String user, String pass) {
        Waits.waitForElement(driver, username).sendKeys(user);
        Waits.waitForElement(driver, password).sendKeys(pass);
        Waits.waitForElement(driver, loginBtn).click();
    }
}