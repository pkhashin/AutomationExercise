package com.ecommerce.base;

import com.ecommerce.common.DriverManager;
import com.ecommerce.config.PropertiesManager;
import com.ecommerce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    DriverManager driverManager;
    protected WebDriver driver;
    protected LoginPage loginPage;


    @BeforeTest
    public void setUp() {
        driverManager = new DriverManager();
        driver = driverManager.launchApplication();
        loginPage = new LoginPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
