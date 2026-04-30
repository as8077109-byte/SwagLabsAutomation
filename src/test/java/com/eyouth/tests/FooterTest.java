package com.eyouth.tests;

import com.eyouth.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTest extends BaseTest {

    @Test
    public void facebookLink() {
        driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();

        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        Assert.assertTrue(driver.getCurrentUrl().contains("facebook.com"));
    }
}