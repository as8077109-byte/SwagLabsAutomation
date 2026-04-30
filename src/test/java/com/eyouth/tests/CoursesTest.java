package com.eyouth.tests;

import com.eyouth.base.BaseTest;
import eyouth.eyouth.pages.CoursesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoursesTest extends BaseTest {

    @Test
    public void openCourseDetails() {
        CoursesPage courses = new CoursesPage(driver);

        courses.openCourses();
        courses.openFirstCourse();

        Assert.assertTrue(driver.getPageSource().contains("حول الدورة التدريبية"));
    }
}