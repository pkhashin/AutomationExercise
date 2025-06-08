package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.config.ConfigReader;
import com.ecommerce.constants.AppConstants;
import io.qameta.allure.Severity;
import jdk.jfr.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Slf4j
public class LoginPageTest extends BaseTest {

    @Test
    @Severity(CRITICAL)
    public void verifyLoginWithValidCredentials() {

        String actualTitle = pageManager.getLoginPage().getPageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE,"Login page title is not matching");

        pageManager.getLoginPage().clickSignUpButton();
        Assert.assertTrue(pageManager.getLoginPage().headerTextIsDisplayed(),"Header not displayed on login page ");

        pageManager.getLoginPage().login(ConfigReader.get("username"), ConfigReader.get("password"));
        pageManager.getLoginPage().clickLoginButton();

        String actualUser=pageManager.getHomePage().getLoggedInUsername();
        Assert.assertEquals(actualUser,AppConstants.LOGIN_USERNAME,"Logged in username does not match");
    }

    @Test
    @Severity(CRITICAL)
    public void verifyLoginWithInvalidCredentials(){
        pageManager.getLoginPage().clickSignUpButton();
        Assert.assertTrue(pageManager.getLoginPage().headerTextIsDisplayed(),"Header not displayed on login page ");

        pageManager.getLoginPage().login(ConfigReader.get("invalidusername"), ConfigReader.get("password"));
        pageManager.getLoginPage().clickLoginButton();

        String actualText=pageManager.getLoginPage().getLoginErrorText();
        Assert.assertEquals(actualText,AppConstants.LOGIN_ERROR_TEXT,"Error text is not displayed");


    }






}
