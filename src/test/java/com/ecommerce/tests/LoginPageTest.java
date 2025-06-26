package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.config.ConfigReader;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.pages.LoginPage;
import com.ecommerce.utils.AllureListener;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Slf4j
@Listeners({AllureListener.class})
public class LoginPageTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);

    @Step("Login with username: {username} and password: ******")
    public void performLogin(String username,String password){

        pageManager.getLoginPage().clickSignUpButton();
        Assert.assertTrue(pageManager.getLoginPage().headerTextIsDisplayed(),"Header not displayed on login page ");
        pageManager.getLoginPage().login(username,password);
        pageManager.getLoginPage().clickLoginButton();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginWithValidCredentials() {

        String actualTitle = pageManager.getLoginPage().getPageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE,"Login page title is not matching");


        performLogin(ConfigReader.get("username"), ConfigReader.get("password"));

        String actualUser=pageManager.getHomePage().getLoggedInUsername();
        Assert.assertEquals(actualUser,AppConstants.LOGIN_USERNAME,"Logged in username does not match");

        log.info("Login successful. Verified username: {}", actualUser);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void verifyLoginWithInvalidCredentials(){

        performLogin(ConfigReader.get("invalidusername"), ConfigReader.get("password"));

        String actualText=pageManager.getLoginPage().getLoginErrorText();
        Assert.assertEquals(actualText,AppConstants.LOGIN_ERROR_TEXT,"Error text is not displayed");


    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void verifyLogout(){

        performLogin(ConfigReader.get("username"), ConfigReader.get("password"));
        String actualUser=pageManager.getHomePage().getLoggedInUsername();
        Assert.assertEquals(actualUser,AppConstants.LOGIN_USERNAME,"Logged in username does not match");
        pageManager.getLoginPage().clicklogOut();
        log.info("Logout Successfully");
    }









}
