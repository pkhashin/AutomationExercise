package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.config.PropertiesManager;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import jdk.jfr.Description;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
@Slf4j
public class LoginPageTest extends BaseTest {

    @Test
    @Description("Verify the login page title...")
    public void verifyLoginPageTitleTest() {

        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE);

 }

    @Test
    @Description("verifying user is able to login with correct credentials...")
    public void verifyUserLoginTest(){
              loginPage.login(PropertiesManager.get("username"),PropertiesManager.get("password"));

    }



}
