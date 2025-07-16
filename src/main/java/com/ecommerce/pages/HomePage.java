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

    public HomePage(WebDriver driver) {
        //this.driver = driver;
        eleUtil = new ElementActions(driver);
    }

    @Step("Verify the homepage is displayed having logged in user name displayed")
    public String getLoggedInUsername(){
        return eleUtil.waitForVisibilityOfElement(txtLoggedInUserName).getText();
    }

}
