package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    By cartIcon = By.className("shopping_cart_link");
    By products = By.className("inventory_item");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCartDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }

    public int getProductsCount() {
        return driver.findElements(products).size();
    }
}