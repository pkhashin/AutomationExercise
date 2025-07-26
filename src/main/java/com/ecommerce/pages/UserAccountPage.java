package com.ecommerce.pages;

import com.ecommerce.driverManager.ElementActions;
import com.ecommerce.pages.repo.AccountRepo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAccountPage extends AccountRepo {
    private static final Logger log = LoggerFactory.getLogger(LoginSignupPage.class);
    private final ElementActions eleUtil;
    private final WebDriver driver;
    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementActions(driver);
    }
    public boolean verifyTextAccountCreated() {
        boolean isDisplayed = eleUtil.isDisplayed(txtAccountCreated);
        log.info("Header 'Account Created!' text is displayed :{}", isDisplayed);
        if (!isDisplayed) {
            throw new AssertionError("Header 'Account Created!' is not displayed");
        }

        return true;
    }

    public void clickContinueButton() {
        log.info("Clicking Continue button");
        eleUtil.click(btnContinue);
    }

    public String getLoggedInUsername(){

        return eleUtil.getText(txtLoggedInUserName);
    }

    public void clicklogOut() {
        log.info("Clicked on the logout button");
        eleUtil.click(btnLogOut);
    }

    public void clickDeleteAccount() {
        log.info("Clicked on the delete account link");
        eleUtil.click(linkDeleteAccount);
    }
    public boolean AccountDeletedTextIsDisplayed() {
        return eleUtil.getText(txtAcountDeleted).equalsIgnoreCase("ACCOUNT DELETED!");
    }

}
