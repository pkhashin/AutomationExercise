package com.ecommerce.pages;

import com.ecommerce.driverManager.ElementActions;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.pages.repo.LoginSignUpRepo;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class LoginSignupPage extends LoginSignUpRepo {
    private static final Logger log = LoggerFactory.getLogger(LoginSignupPage.class);
    private final ElementActions eleUtil;
    private WebDriver driver;

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementActions(driver);

    }

    @Step("Click on SignUp button")
    public void clickSignUpButton() {
        log.info("Clicking SignUp button");
        eleUtil.click(btnSignUp);
    }


    @Step("Enter the username:{username}")
    public void enterUsername(String userName) {
        log.info("Entering the username : {}", userName);
        eleUtil.sendKeys(txtUsername, userName);
    }

    @Step("Enter the password:******")
    public void enterPassword(String password) {
        log.info("Entering the password : {}", password);
        eleUtil.sendKeys(txtPassword, password);
    }

    public boolean headerTextIsDisplayed() {
        boolean isDisplayed = eleUtil.isDisplayed(hdrLoginToyourAccount);
        log.info("Header 'Login to your account' text is displayed :{}", isDisplayed);
        return isDisplayed;
    }

    public UserAccountPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
       return new UserAccountPage(driver);
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

    @Step("Enter the username:{username}")
    public RegisterUserPage fillSignup(String username, String email) {

        eleUtil.sendKeys(txtSignUpUsername,username);
        eleUtil.sendKeys(textSignUpEmail, email);
        eleUtil.click(btnSignUp);
        return new RegisterUserPage(driver);
    }

    public boolean NewUserSignupTextIsDisplayed() {
        return eleUtil.getText(txtNewUserSignup).equalsIgnoreCase("New User Signup!");
    }



}


