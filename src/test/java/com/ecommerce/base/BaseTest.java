package com.ecommerce.base;

import com.ecommerce.core.DriverManager;
import com.ecommerce.core.PageManager;
import com.ecommerce.utils.AllureListener;
import com.ecommerce.utils.ScreenshotUtil;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

import static com.ecommerce.utils.AllureListener.attachScreenshot;


@Slf4j
public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected DriverManager driverManager;
    protected WebDriver driver;
    protected PageManager pageManager;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver=DriverManager.launchApplication();
        pageManager=new PageManager(driver);

    }

   @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
        AllureListener.attachScreenshot(result);
            DriverManager.quitDriver();
    }
}
