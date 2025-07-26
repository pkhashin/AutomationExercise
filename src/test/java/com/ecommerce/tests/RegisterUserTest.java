package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.utils.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegisterUserTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserTest.class);
    Map<String, String> register = JsonReader.readJsonFile("registerUser.json");


    @Test
    public void verifyUserRegister() {

        log.info("Starting user registration test...");

        // Verify Home Page and navigate to signup page
        verifyHomePageIsDisplayed();
        verifyLoginPageIsDisplayed();

        // Verify Account Creation and deletion
        verifyAccountCreation();
        verifyDeleteAccount();

        log.info("User registration test completed successfully.");
    }

    public void verifyHomePageIsDisplayed() {
        boolean homePageVisible = homepage.verifyHomePageIsDisplayed();
        Assert.assertTrue(homePageVisible, "Home page links are not displayed");
        log.info("Home page is displayed successfully.");
    }

    public void verifyLoginPageIsDisplayed() {
        loginSignupPage = homepage.clickLoginSignupLink();
        Assert.assertTrue(loginSignupPage.NewUserSignupTextIsDisplayed(), "New User Signup! is not displayed");
    }

    public void verifyAccountCreation() {
        registerPage = loginSignupPage.fillSignup(register.get("username"), register.get("email"));
        Assert.assertTrue(registerPage.EnterAccountInfoTextIsDisplayed(), "Enter Account Information text is not displayed");

        registerPage.enterDetails();
        userAccountPage = registerPage.clickSubmitButton();
        assertTrue(userAccountPage.verifyTextAccountCreated(), "ACCOUNT CREATED! text is not displayed");
        log.info("User registration completed successfully.");
    }

    public void verifyDeleteAccount() {

        userAccountPage.clickContinueButton();
        String actualUser = userAccountPage.getLoggedInUsername();
        assertEquals(actualUser, register.get("username"), "Logged in username does not match");

        userAccountPage.clickDeleteAccount();
        assertTrue(userAccountPage.AccountDeletedTextIsDisplayed(), "Account deleted text is not displayed");
    }
}
