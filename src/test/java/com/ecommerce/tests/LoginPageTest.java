package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.config.ConfigReader;
import com.ecommerce.constants.AppConstants;
import jdk.jfr.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
@Slf4j
public class LoginPageTest extends BaseTest {

    @Test
    @Description("Verify the login page title...")
    public void verifyLoginUserWithCorrectEmailAndPassword() {

        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
        loginPage.clickSignUpButton();
        Assert.assertTrue(loginPage.headerTextIsDisplayed(),"Header not displayed ");
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertEquals(homePage.getLoggedInUsername(),"Muhammed Hashin PK","Logged in username does not match");



    }




}
