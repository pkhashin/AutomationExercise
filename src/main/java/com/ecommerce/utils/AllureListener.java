package com.ecommerce.utils;

import com.ecommerce.core.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;


public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
            attachScreenshot("Failure Screenshot");
        }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        attachScreenshot("Skipped Screenshot");
    }


    public static void attachScreenshot(String name) {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
            }
        }
            catch(Exception e){
                System.err.println("Could not attach screenshot to Allure: " + e.getMessage());

        }
    }
}
