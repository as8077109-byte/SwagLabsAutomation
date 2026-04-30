package com.eyouth.tests;

import com.eyouth.base.BaseTest;
import org.testng.annotations.Test;
import com.eyouth.pages.HomePage;

public class SearchTest extends BaseTest {

    @Test
    public void validSearch() {
        HomePage home = new HomePage(driver);

        home.search("test");
    }
}