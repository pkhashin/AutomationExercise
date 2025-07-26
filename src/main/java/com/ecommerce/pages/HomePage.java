package com.ecommerce.pages;

import com.ecommerce.driverManager.ElementActions;
import com.ecommerce.pages.repo.HomeRepo;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends HomeRepo {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);
    private final ElementActions eleUtil;
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementActions(driver);
    }






    public boolean verifyHomePageIsDisplayed() {

        eleUtil.isDisplayed(linkHome);
        eleUtil.isDisplayed(linkProducts);
        eleUtil.isDisplayed(linkCart);
        eleUtil.isDisplayed(linkSignupLogin);
        log.info("Home page is displayed with all the links");
        return true;
    }

    public LoginSignupPage clickLoginSignupLink() {
        log.info("Clicking on the Signup/Login link");
        eleUtil.click(linkSignupLogin);
        return new LoginSignupPage(driver);
    }



}
