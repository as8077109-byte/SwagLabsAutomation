package tests;

import base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataDriven;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() throws Exception {

        JSONObject data = DataDriven.jsonReader();
        JSONObject valid = (JSONObject) data.get("validUser");

        LoginPage login = new LoginPage(driver);
        login.login((String) valid.get("username"),
                (String) valid.get("password"));

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    public void invalidLoginTest() throws Exception {

        JSONObject data = DataDriven.jsonReader();
        JSONObject invalid = (JSONObject) data.get("invalidUser");

        LoginPage login = new LoginPage(driver);
        login.login((String) invalid.get("username"),
                (String) invalid.get("password"));

        Assert.assertTrue(login.getErrorMessage()
                .contains("Username and password do not match"));
    }

    @Test
    public void loginWithoutPassword() throws Exception {

        JSONObject data = DataDriven.jsonReader();
        JSONObject valid = (JSONObject) data.get("validUser");

        LoginPage login = new LoginPage(driver);
        login.login((String) valid.get("username"), "");

        Assert.assertTrue(login.getErrorMessage()
                .contains("Password is required"));
    }
}