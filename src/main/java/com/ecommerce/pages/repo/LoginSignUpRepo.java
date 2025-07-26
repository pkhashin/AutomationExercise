package com.ecommerce.pages.repo;

import org.openqa.selenium.By;

public abstract class LoginSignUpRepo {

    // protected final By btnSignUp = By.xpath("//li[a[contains(text(),'Signup / Login')]]");
    protected final By txtUsername = By.xpath("//input[@name='email']");
    protected final By txtPassword = By.xpath("//input[@name='password']");
    protected final By btnSignIn = By.xpath("//button[text()='Login']");



    protected final By hdrLoginToyourAccount = By.xpath("//h2[contains(text(),'Login to your account')]");
    protected final By errortxtLogin = By.xpath("//form[@action='/login']//p");

    protected final By txtSignUpUsername = By.xpath("//input[@name='name']");
    protected final By textSignUpEmail = By.xpath("//input[@data-qa='signup-email']");

    protected final By txtNewUserSignup = By.xpath("//div[@class='signup-form']//h2");

    protected final By btnSignUp = By.xpath("//button[text()='Signup']");


}
