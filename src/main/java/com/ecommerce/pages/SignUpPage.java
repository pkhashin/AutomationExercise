package com.ecommerce.pages;


import com.ecommerce.driverManager.ElementActions;
import com.ecommerce.pages.repo.SignUpRepo;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignUpPage extends SignUpRepo {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    private final ElementActions eleUtil;

    public SignUpPage(WebDriver driver) {
        eleUtil = new ElementActions(driver);
    }


    public void enterSignUpUser() {
        Faker faker = new Faker();
        String userName = faker.name().username();
        String email = String.format("%s@fakemail.com", userName).toLowerCase();
        log.info("Entering the username : {}", userName);
        eleUtil.sendKeys(txtSignUpUsername, userName);
        log.info("Entering the email : {}", email);
        eleUtil.sendKeys(textSignUpEmail, email);

        //entering the details




    }



}
