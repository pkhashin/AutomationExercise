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
    @Description("Verify the user is able to login")
    public void verifyLoginUserWithCorrectEmailAndPassword() {

        String actualTitle = pageManager.getLoginPage().getPageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);
        pageManager.getLoginPage().clickSignUpButton();
        Assert.assertTrue(pageManager.getLoginPage().headerTextIsDisplayed(),"Header not displayed ");
        pageManager.getLoginPage().login(ConfigReader.get("username"), ConfigReader.get("password"));
        Assert.assertEquals(pageManager.getHomePage().getLoggedInUsername(),"Muhammed Hashin PK","Logged in username does not match");
    }




}
