package com.eyouth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    By searchInput = By.cssSelector("input.bg-primary-base-section");

    // Action
    public void search(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(searchInput)
        );

        input.click();
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
    }
}