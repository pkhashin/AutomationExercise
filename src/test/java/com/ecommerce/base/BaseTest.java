package com.ecommerce.base;

import com.ecommerce.core.DriverManager;
import com.ecommerce.core.PageManager;
import com.ecommerce.utils.ScreenshotUtil;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {
    DriverManager driverManager;
    protected WebDriver driver;
    protected PageManager pageManager;


    @BeforeTest
    public void setUp() {
        driverManager = new DriverManager();
        driver = driverManager.launchApplication();
        pageManager=new PageManager(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            Allure.getLifecycle().addAttachment(
                    "Screenshot",
                    "image/png",
                    "png",
                    ScreenshotUtil.captureScreenshot(driver)
            );
        }
        driver.quit();
    }

}
