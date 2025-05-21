package com.ecommerce.common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ElementActions {

    private static final Logger log = LoggerFactory.getLogger(ElementActions.class);
    private final WebDriver driver;


    public ElementActions(WebDriver driver) {
        this.driver = driver;
    }


    public void click(By locator) {
        log.debug("Clicking on element: {}", locator);
        waitForVisibilityOfElement(locator).click();

    }

    public WebElement waitForVisibilityOfElement(By locator) {
        log.debug("element {}", locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }


    public void sendKeys(By locator, String value) {
        log.debug("Sending keys '{}' to element: {}",value, locator);
        WebElement element = waitForVisibilityOfElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    public WebElement getElement(By locator) {

        WebElement element = driver.findElement(locator);
        return element;
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
