package com.ecommerce.pages;

import com.ecommerce.core.ElementActions;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.pages.repo.LoginRepo;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class LoginPage extends LoginRepo {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);
 //   private final WebDriver driver;
    private final ElementActions eleUtil;


    public LoginPage(WebDriver driver) {
      //  this.driver = driver;
        eleUtil = new ElementActions(driver);
    }

    public void clickSignUpButton(){
        log.info("Clicking SignUp button");
        eleUtil.waitForVisibilityOfElement(btnSignUp);
        eleUtil.click(btnSignUp);
    }

    public boolean headerTextIsDisplayed(){
        boolean isDisplayed =eleUtil.waitForVisibilityOfElement(hdrLoginToyourAccount).isDisplayed();
        log.info("Header 'Login to your account' text is displayed :{}",isDisplayed);
        return  isDisplayed;
    }
    public void login(String username, String password) {

        eleUtil.waitForVisibilityOfElement(txtUsername);
        eleUtil.clear(txtUsername);
        log.info("Entering the username : {}", username);
        eleUtil.sendKeys(txtUsername, username);

        eleUtil.waitForVisibilityOfElement(txtPassword);
        eleUtil.clear(txtPassword);
        log.info("Entering the password : {}", password);
        eleUtil.sendKeys(txtPassword, password);

        eleUtil.waitForVisibilityOfElement(btnSignIn);
        eleUtil.click(btnSignIn);
        log.info("Clicked on the login button");
    }

    public String getPageTitle() {
        return eleUtil.waitForTitle(AppConstants.LOGIN_PAGE_TITLE, 8);

    }


}


