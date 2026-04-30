package eyouth.eyouth.pages;

import eyouth.eyouth.utils.Waits;
import org.openqa.selenium.*;

public class CoursesPage {

    WebDriver driver;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By allCourses = By.linkText("جميع الدورات");
    private By courseCard = By.className("course-card");

    public void openCourses() {
        Waits.waitForElement(driver, allCourses).click();
    }

    public void openFirstCourse() {
        Waits.waitForElement(driver, courseCard).click();
    }
}