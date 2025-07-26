package com.ecommerce.base;

import com.ecommerce.driverManager.DriverManager;
import com.ecommerce.driverManager.PageManager;
import com.ecommerce.pages.UserAccountPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginSignupPage;
import com.ecommerce.pages.RegisterUserPage;
import com.ecommerce.utils.AllureListener;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


@Slf4j
public class BaseTest {

    protected LoginSignupPage loginSignupPage;
    protected HomePage homepage;
    protected UserAccountPage userAccountPage;
    protected RegisterUserPage registerPage;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected DriverManager driverManager;
    protected WebDriver driver;
    protected PageManager pageManager;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver=DriverManager.launchApplication();
        homepage= new HomePage(driver);


    }

   @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
        AllureListener.attachScreenshot(result);
            DriverManager.quitDriver();
    }
}
