package com.ecommerce.pages;

import com.ecommerce.core.ElementActions;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.pages.repo.LoginRepo;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class LoginPage extends LoginRepo {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final ElementActions eleUtil;


    public LoginPage(WebDriver driver) {
        eleUtil = new ElementActions(driver);
    }

    @Step("Click on SignUp button")
    public void clickSignUpButton() {
        log.info("Clicking SignUp button");
        eleUtil.click(btnSignUp);
    }

    public boolean headerTextIsDisplayed() {
        boolean isDisplayed = eleUtil.isDisplayed(hdrLoginToyourAccount);
        log.info("Header 'Login to your account' text is displayed :{}", isDisplayed);
        return isDisplayed;
    }

    @Step("Enter the username : {username} and password : ******")
    public void login(String username, String password) {

        log.info("Entering the username : {}", username);
        eleUtil.sendKeys(txtUsername, username);
        log.info("Entering the password : {}", password);
        eleUtil.sendKeys(txtPassword, password);

    }

    @Step("Click on Login button")
    public void clickLoginButton() {
        log.info("Clicked on the login button");
        eleUtil.click(btnSignIn);

    }

    @Step("Verify the page title")
    public String getPageTitle() {
        return eleUtil.waitForPageTitle(AppConstants.LOGIN_PAGE_TITLE, 8);

    }

    @Step("Verify the login error text")
    public String getLoginErrorText() {
       return eleUtil.getText(errortxtLogin);

    }

}


