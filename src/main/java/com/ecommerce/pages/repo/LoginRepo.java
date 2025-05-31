package com.ecommerce.pages.repo;

import org.openqa.selenium.By;

public abstract class LoginRepo {

    protected final By btnSignUp = By.xpath("//li[a[contains(text(),'Signup / Login')]]");
    protected final By txtUsername= By.xpath("//input[@name='email']");
    protected final By txtPassword=By.xpath("//input[@name='password']");
    protected final By btnSignIn=By.xpath("//button[@type='submit']");

    protected final By hdrLoginToyourAccount=By.xpath("//h2[contains(text(),'Login to your account')]");





}
