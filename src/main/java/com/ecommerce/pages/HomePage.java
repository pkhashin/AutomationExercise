package com.ecommerce.pages;

import com.ecommerce.common.ElementActions;
import com.ecommerce.repo.HomeRepo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends HomeRepo {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    //private final WebDriver driver;
    private final ElementActions eleUtil;

    public HomePage(WebDriver driver) {
        //this.driver = driver;
        eleUtil = new ElementActions(driver);
    }

    public String getLoggedInUsername(){
        String actualUsername =eleUtil.waitForVisibilityOfElement(txtLoggedInUserName).getText();
        log.info("Logged in username displayed :{}",actualUsername);
        return actualUsername;
    }

}
