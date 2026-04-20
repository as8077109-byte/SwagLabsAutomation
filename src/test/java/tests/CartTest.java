package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CartTest extends BaseTest {

    @Test
    public void verifyCartEmpty() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);

        login.login("standard_user", "secret_sauce");
        inventory.openCart();

        Assert.assertEquals(cart.getItemsCount(), 0);
    }

    @Test
    public void addProducts() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);

        login.login("standard_user", "secret_sauce");

        inventory.addItem("Sauce Labs Backpack");
        inventory.addItem("Sauce Labs Bolt T-Shirt");
        inventory.addItem("Sauce Labs Onesie");

        inventory.openCart();

        Assert.assertTrue(cart.isItemDisplayed("Sauce Labs Backpack"));
        Assert.assertTrue(cart.isItemDisplayed("Sauce Labs Bolt T-Shirt"));
        Assert.assertTrue(cart.isItemDisplayed("Sauce Labs Onesie"));
    }

    @Test
    public void removeProduct() {
        LoginPage login = new LoginPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        CartPage cart = new CartPage(driver);

        login.login("standard_user", "secret_sauce");

        inventory.addItem("Sauce Labs Backpack");
        inventory.addItem("Sauce Labs Bolt T-Shirt");
        inventory.addItem("Sauce Labs Onesie");

        inventory.openCart();

        cart.removeItem("Sauce Labs Bolt T-Shirt");
        cart.continueShopping();

        Assert.assertTrue(driver.getPageSource().contains("Add to cart"));
    }
}