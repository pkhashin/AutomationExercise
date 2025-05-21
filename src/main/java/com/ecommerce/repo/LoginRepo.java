package com.ecommerce.repo;

import org.openqa.selenium.By;

public abstract class LoginRepo {


    protected final By txtUsername= By.xpath("//input[@name='email']");
    protected final By txtPassword=By.xpath("//input[@name='password']");
    protected final By btnSignIn=By.xpath("//button[@type='submit']");



}
