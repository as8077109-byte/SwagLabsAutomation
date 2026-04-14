package tests;

import base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DataDriven;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryPage() throws Exception {

        JSONObject data = DataDriven.jsonReader();
        JSONObject valid = (JSONObject) data.get("validUser");

        LoginPage login = new LoginPage(driver);
        login.login((String) valid.get("username"),
                (String) valid.get("password"));

        InventoryPage inventory = new InventoryPage(driver);

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
        Assert.assertTrue(inventory.isCartDisplayed());
        Assert.assertEquals(inventory.getProductsCount(), 6);
    }
}