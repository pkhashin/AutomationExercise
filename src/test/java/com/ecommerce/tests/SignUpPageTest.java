package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SignUpPageTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);

    @Test
    public void verifySignUpPage() {

        pageManager.getSignUpPage().enterSignUpUser();
        pageManager.getLoginPage().clickSignUpButton();


    }
}
