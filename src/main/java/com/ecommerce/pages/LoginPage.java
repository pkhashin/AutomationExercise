package com.ecommerce.pages;

import com.ecommerce.common.ElementActions;
import com.ecommerce.constants.AppConstants;
import com.ecommerce.repo.LoginRepo;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Slf4j
public class LoginPage extends LoginRepo {
    private static final Logger log = LoggerFactory.getLogger(ElementActions.class);
    private final WebDriver driver;
    private final ElementActions eleUtil;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementActions(this.driver);
    }

        public void login (String username, String password){

            eleUtil.waitForVisibilityOfElement(txtUsername);
            eleUtil.clear(txtUsername);
            log.info("Entering the username : {}",username);
            eleUtil.sendKeys(txtUsername, username);

            eleUtil.waitForVisibilityOfElement(txtPassword);
            eleUtil.clear(txtPassword);
            log.info("Entering the password : {}",password);
            eleUtil.sendKeys(txtPassword, password);

            eleUtil.waitForVisibilityOfElement(btnSignIn);
            eleUtil.click(btnSignIn);
            log.info("Clicked on the login button");
        }

        public String getPageTitle ()
        {
            String title = eleUtil.waitForTitle(AppConstants.LOGIN_PAGE_TITLE, 8);
            return title;
        }


    }


