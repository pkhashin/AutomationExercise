package com.ecommerce.base;

import com.ecommerce.core.DriverManager;
import com.ecommerce.core.PageManager;
import com.ecommerce.utils.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    protected DriverManager driverManager;
    protected WebDriver driver;
    protected PageManager pageManager;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driverManager = new DriverManager();
        driver = driverManager.launchApplication();
        pageManager=new PageManager(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {

            driver.quit();
        }
    }
}
