package com.ecommerce.pages.repo;

import org.openqa.selenium.By;

public class AccountRepo {

    protected final By txtAccountCreated = By.xpath("//h2/b[contains(text(),'Account Created!')]");
    protected final By btnContinue=By.xpath("//a[@data-qa='continue-button']");

    protected final By txtLoggedInUserName=By.xpath("//li[a[contains(text(),'Logged in as')]]//b");
    protected final By btnLogOut = By.xpath("//a[contains(text(),' Logout')]");
    protected final By linkDeleteAccount=By.xpath("//a[normalize-space(text())='Delete Account']");
    protected final By txtAcountDeleted = By.xpath("//b[contains(text(),'Account Deleted!')]");

}
