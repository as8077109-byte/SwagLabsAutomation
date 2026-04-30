package com.eyouth.tests;

import com.eyouth.base.BaseTest;
import eyouth.eyouth.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test
    public void emptyUsername() {
        SignupPage signup = new SignupPage(driver);

        signup.openSignup();
        signup.submitEmpty();

        Assert.assertTrue(driver.getPageSource().contains("اسم المستخدم مطلوب"));
    }
}