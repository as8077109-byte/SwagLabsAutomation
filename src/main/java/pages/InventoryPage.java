package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    // 🔹 Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

     private By cartIcon = By.className("shopping_cart_link");

    private By linkedinIcon = By.cssSelector("a[href*='linkedin']");
    private By facebookIcon = By.cssSelector("a[href*='facebook']");
    private By twitterIcon = By.cssSelector("a[href*='twitter']");

     private By products = By.className("inventory_item");

    public int getProductsCount() {
        return driver.findElements(products).size();
    }


    private By addToCartByName(String name) {
        return By.xpath("//div[text()='" + name + "']/ancestor::div[@class='inventory_item']//button");
    }

    private By removeBtnByName(String name) {
        return By.xpath("//div[text()='" + name + "']/ancestor::div[@class='inventory_item']//button[text()='Remove']");
    }


     public void openCart() {
        driver.findElement(cartIcon).click();
    }

     public boolean isCartDisplayed() {
        return driver.findElements(cartIcon).size() > 0;
    }

     public void addItem(String itemName) {
        driver.findElement(addToCartByName(itemName)).click();
    }

     public void removeItem(String itemName) {
        driver.findElement(removeBtnByName(itemName)).click();
    }

     public void clickLinkedIn() {
        driver.findElement(linkedinIcon).click();
    }

     public void clickFacebook() {
        driver.findElement(facebookIcon).click();
    }

     public void clickTwitter() {
        driver.findElement(twitterIcon).click();
    }
}