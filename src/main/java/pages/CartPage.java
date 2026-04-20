package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartItems = By.className("cart_item");
    private By continueShopping = By.id("continue-shopping");

    private By itemByName(String name) {
        return By.xpath("//div[@class='inventory_item_name' and text()='" + name + "']");
    }

    private By removeBtnByName(String name) {
        return By.xpath("//div[text()='" + name + "']/ancestor::div[@class='cart_item']//button");
    }

    public int getItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public boolean isItemDisplayed(String name) {
        return driver.findElements(itemByName(name)).size() > 0;
    }

    public void removeItem(String name) {
        driver.findElement(removeBtnByName(name)).click();
    }

    public void continueShopping() {
        driver.findElement(continueShopping).click();
    }
}