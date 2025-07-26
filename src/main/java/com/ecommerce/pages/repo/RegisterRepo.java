package com.ecommerce.pages.repo;

import org.openqa.selenium.By;

public class RegisterRepo extends LoginSignUpRepo {


    protected final By passwordSignUp = By.id("password");
    protected final By ddDay=By.xpath("//select[@id='days']");
    protected final By ddMonth=By.xpath("//select[@id='months']");
    protected final By ddYear=By.xpath("//select[@id='years']");
    protected final By txtFirstName=By.id("first_name");
    protected final By txtLastName=By.id("last_name");
    protected final By txtAddress=By.xpath("//input[@id='address1']");

    protected  final By txtState=By.xpath("//input[@id='state']");
    protected  final By txtCity=By.xpath("//input[@id='city']");
    protected final By txtZipCode=By.xpath("//input[@id='zipcode']");
    protected final By txtMobileNumber=By.xpath("//input[@id='mobile_number']");
    protected final By btnSubmit=By.xpath("//button[@data-qa='create-account']");
    protected final By hdrEnterAccountInformation = By.xpath("//b[contains(text(),'Enter Account Information')]");
    protected final By chkSignupNewsletter = By.xpath("//input[@type='checkbox' and @id='newsletter']");
    protected final By chkReceiveOffers = By.xpath("//input[@type='checkbox' and @id='optin']");




}
