package com.ecommerce.core;

import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageManager {

    private final WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public PageManager(WebDriver driver){
        this.driver=driver;

    }

    public LoginPage getLoginPage(){
        if(loginPage==null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public HomePage getHomePage(){
        if(homePage==null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}
