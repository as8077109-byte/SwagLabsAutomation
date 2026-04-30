package com.eyouth.tests;

import com.eyouth.base.BaseTest;
import eyouth.eyouth.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void invalidLogin() {
        LoginPage login = new LoginPage(driver);

        login.openLogin();
        login.login("wrong", "wrong");

        Assert.assertTrue(driver.getPageSource().contains("خطأ"));
    }
}