package com.ecommerce.common;

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
    static final int MAX_RETRIES=3;
    private WebElement element;


    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(8));
    }


    public void click(By locator) {
        log.debug("Clicking on element: {}", locator);
        int i=0;
        Exception outer = null;
        while(i<MAX_RETRIES) {
            try {
                element = waitForVisibilityOfElement(locator);
                element.click();
                return;
            }
            catch(StaleElementReferenceException ex){
                element = waitForVisibilityOfElement(locator);
                element.click();
                return;
            }
            catch(Exception e){
                outer=e;
                ++i;
            }
        }
        throw new RuntimeException("Failed to perform click after retries:" +locator,outer);

    }

    public WebElement waitForVisibilityOfElement(By locator) {
        log.debug("element {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


//    public void sendKeys(By locator, String value) {
//        log.debug("Sending keys '{}' to element: {}",value, locator);
//        WebElement element = waitForVisibilityOfElement(locator);
//        element.clear();
//        element.sendKeys(value);
//    }


        public void sendKeys(By locator, CharSequence... keysToSend) {
        log.debug("Sending keys '{}' to element: {}",keysToSend, locator);
        int i=0;
        Exception outer = null;
        while(i<MAX_RETRIES) {
            try {
                element = waitForVisibilityOfElement(locator);
                element.clear();
                element.sendKeys(keysToSend);
                return;
            }
            catch(StaleElementReferenceException ex){
                element.sendKeys(keysToSend);
                return;
            }
            catch(Exception e){
                outer=e;
                ++i;
            }
        }
            throw new RuntimeException("Failed to perform sendKeys after retries:" +locator,outer);
    }

    public WebElement getElement(By locator) {

        return driver.findElement(locator);
    }

    public void clear(By locator) {

        getElement(locator).clear();

    }

    public String waitForTitle(String title, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            wait.until(ExpectedConditions.titleContains(title));
            String actualTitle = driver.getTitle();
            log.info("Page title matched: {}", actualTitle);
            return actualTitle;
        } catch (TimeoutException e) {
            log.warn("Page title did not contain expected text '{}' within {} seconds", title, timeOut);
            return null;
        }
    }


}
