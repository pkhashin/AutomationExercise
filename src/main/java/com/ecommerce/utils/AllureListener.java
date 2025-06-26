package com.ecommerce.utils;

import com.ecommerce.core.DriverManager;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

@Slf4j
public class AllureListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(AllureListener.class);
    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test failed: {}", result.getMethod().getMethodName());
//        attachScreenshot("Failure Screenshot"+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test passed: " + result.getMethod().getMethodName());
//        attachScreenshot("Success Screenshot"+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.warn("Test skipped: {}", result.getMethod().getMethodName());
//        attachScreenshot("Skipped Screenshot");
    }

    @Override
    public void onTestStart(ITestResult result) {

        log.info("Test started: {}", result.getMethod().getMethodName());
    }

    public static void attachScreenshot(ITestResult result) {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                String methodName = result.getMethod().getMethodName();
                byte[] screenshot = ScreenshotUtil.captureScreenshot(driver);
                Allure.addAttachment("Screenshot - " + methodName, new ByteArrayInputStream(screenshot));
                log.debug("Attached screenshot '{}' to Allure report.", methodName);
            } else {
                log.warn("WebDriver is null. Screenshot not captured.");
            }
        }  catch(Exception e) {
            log.error("Error attaching screenshot: {}", e.getMessage(), e);
        }
    }
}
