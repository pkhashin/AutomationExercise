package com.ecommerce.pages;


import com.ecommerce.driverManager.ElementActions;
import com.ecommerce.pages.repo.RegisterRepo;
import com.ecommerce.utils.JsonReader;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class RegisterUserPage extends RegisterRepo {
    private static final Logger log = LoggerFactory.getLogger(LoginSignupPage.class);
    Map<String, String> register = JsonReader.readJsonFile("registerUser.json");
    private final ElementActions eleUtil;
    private WebDriver driver;

    public RegisterUserPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementActions(driver);
    }

    @Step("Enter the password:******")
    public void enterSignUpEmail(String email) {
        log.info("Entering the password : {}", email);
        eleUtil.sendKeys(textSignUpEmail, email);
    }
    public RegisterUserPage clickSignUpButton() {
        log.info("Clicking SignUp button");
        eleUtil.click(btnSignUp);
        return new RegisterUserPage(driver);
    }

    public boolean EnterAccountInfoTextIsDisplayed(){
        return eleUtil.getText(hdrEnterAccountInformation).equalsIgnoreCase("ENTER ACCOUNT INFORMATION");
    }
    public void enterDetails() {

        Faker faker = new Faker();
        String userName = faker.name().username();
        String email = String.format("%s@fakemail.com", userName).toLowerCase();

//        eleUtil.sendKeys(txtSignUpUsername, userName);
//        eleUtil.sendKeys(textSignUpEmail, email);
//        eleUtil.click(btnSignUp);
        eleUtil.sendKeys(passwordSignUp, "Test@1234");

        //Enter the DoB
        eleUtil.selectByValue(ddDay, register.get("day"));
        eleUtil.selectByValue(ddMonth, register.get("month"));
        eleUtil.selectByValue(ddYear, register.get("year"));

        //Enter the personal details
        eleUtil.sendKeys(txtFirstName, register.get("firstName"));
        eleUtil.sendKeys(txtLastName, register.get("lastName"));
        eleUtil.sendKeys(txtAddress, register.get("address1"));;
        eleUtil.sendKeys(txtState, register.get("state"));
        eleUtil.sendKeys(txtCity, register.get("city"));
        eleUtil.sendKeys(txtZipCode, register.get("zipcode"));
        eleUtil.sendKeys(txtMobileNumber, register.get("mobileNumber"));

        //select the checkbox
        eleUtil.click(chkSignupNewsletter);
        eleUtil.click(chkReceiveOffers);



    }
      public UserAccountPage clickSubmitButton() {
          log.info("Clicking Submit button");
          eleUtil.click(btnSubmit);
          return new UserAccountPage(driver);
      }




}
