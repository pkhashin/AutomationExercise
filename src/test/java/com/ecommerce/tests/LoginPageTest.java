package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.utils.JsonReader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Slf4j
public class LoginPageTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    Map<String, String> login = JsonReader.readJsonFile("loginCredentials.json");

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginWithValidCredentials() {
        loginSignupPage=homepage.clickLoginSignupLink();
        userAccountPage=loginSignupPage.login(login.get("email"), login.get("password"));
        String actualUser=userAccountPage.getLoggedInUsername();
        Assert.assertEquals(actualUser,AppConstants.LOGIN_USERNAME,"Logged in username does not match");
        log.info("Login successful. Verified username: {}", actualUser);

    }
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginWithInvalidCredentials(){

        loginSignupPage=homepage.clickLoginSignupLink();
        loginSignupPage.enterUsername(login.get("invalid"));
        loginSignupPage.enterPassword(login.get("password"));
        loginSignupPage.clickLoginButton();
        String actualText=loginSignupPage.getLoginErrorText();
        Assert.assertEquals(actualText,AppConstants.LOGIN_ERROR_TEXT,"Error text is not displayed");
        log.info("Login failed with invalid credentials. Verified error text: {}", actualText);
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyLogout(){
        loginSignupPage=homepage.clickLoginSignupLink();
        userAccountPage=loginSignupPage.login(login.get("email"), login.get("password"));
        userAccountPage.clicklogOut();
        log.info("Logout Successfully");
    }
}
