package com.ecommerce.base;

import com.ecommerce.common.DriverManager;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    DriverManager driverManager;
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;


    @BeforeTest
    public void setUp() {
        driverManager = new DriverManager();
        driver = driverManager.launchApplication();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


}
