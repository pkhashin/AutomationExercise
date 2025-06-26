package com.ecommerce.core;

import com.ecommerce.utils.AllureListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ElementActions {

    private static final Logger log = LoggerFactory.getLogger(ElementActions.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    static final int MAX_RETRIES = 3;


    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }


    public void click(By locator) {

        log.debug("Clicking on element: {}", locator);
        Exception lastException = null;
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                WebElement elementToClick = waitForVisibilityOfElement(locator);
                elementToClick.click();
                log.info("Sucessfully clicked element: {}", locator);
                return;
            } catch (StaleElementReferenceException ex) {
                lastException = ex;
                log.warn("StaleElementReferenceException encountered for {}. Retrying click (attempt {}/{})", locator, i + 1, MAX_RETRIES);
            } catch (Exception e) {
                lastException = e;
                log.error("An unexpected error occurred during click on {}. Retrying (attempt {}/{}): {}", locator, i + 1, MAX_RETRIES, e.getMessage());
            }
        }
        throw new RuntimeException("Failed to perform click after retries:" + MAX_RETRIES + " retries: " + locator, lastException);


    }

    public WebElement waitForVisibilityOfElement(By locator) {
        log.debug("Waiting for presence of element : {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void sendKeys(By locator, CharSequence... keysToSend) {

        log.debug("Sending keys '{}' to element: {}", keysToSend, locator);
        Exception lastException = null;
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                WebElement elementSendKeys = waitForVisibilityOfElement(locator);
                elementSendKeys.clear();
                elementSendKeys.sendKeys(keysToSend);
                log.info("Sucessfully send keys '{}'to element: {}", keysToSend, locator);
                return;
            } catch (StaleElementReferenceException ex) {
                lastException = ex;
                log.warn("StaleElementReferenceException encountered for {}. Retrying sendKeys (attempt {}/{})", locator, i + 1, MAX_RETRIES);
            } catch (Exception e) {
                lastException = e;
                log.error("An unexpected error occurred during click on {}. Retrying (attempt {}/{}): {}", locator, i + 1, MAX_RETRIES, e.getMessage());

            }
        }
        throw new RuntimeException("Failed to perform sendKeys to element after " + MAX_RETRIES + " retries: " + locator, lastException);
    }

    public void clear(By locator) {
        try {
            WebElement elementToClear = waitForVisibilityOfElement(locator);
            elementToClear.clear();
            log.info("Successfully cleared text from element: {}", locator);
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear text from element " + locator + ": " + e.getMessage(), e);
        }
    }

    public String waitForPageTitle(String title, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            wait.until(ExpectedConditions.titleContains(title));
            String actualTitle = driver.getTitle();
            log.info("Page title matched: {}", actualTitle);
            return actualTitle;
        } catch (TimeoutException e) {
            log.warn("Page title did not contain expected text '{}' within {} seconds", title, timeOut, driver.getTitle());
            return null;
        }
    }

    public boolean isDisplayed(By locator) {
        log.debug("Checking if element is displayed: {}", locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return true;
    }

    public String getText(By locator) {
        String elementText = null;
        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                WebElement element = waitForVisibilityOfElement(locator);
                elementText = element.getText();
                return elementText;
            } catch (StaleElementReferenceException e) {
                log.warn("StaleElementReferenceException caught while getting text from {}. Retrying... (Attempt {}/{})", locator, i + 1, MAX_RETRIES);
            }
        }
        return null;
    }
}

