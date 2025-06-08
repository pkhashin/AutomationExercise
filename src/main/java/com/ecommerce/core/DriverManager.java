package com.ecommerce.core;

import com.ecommerce.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j

public class DriverManager {
    private static final Logger log = LoggerFactory.getLogger(DriverManager.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public DriverManager() {

    }

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been initialized for the current thread.");
        }
        return driver;
    }

    @Step("Launch application URL")
    public static WebDriver launchApplication() {

        if (driverThreadLocal.get() != null) {
            log.warn("WebDriver already initialized for current thread. Re-using existing instance");
            return driverThreadLocal.get();
        }
        String browser = ConfigReader.get("browser", "CHROME").toUpperCase();
        // Check if a driver is already set for the current thread to prevent re-initialization
        log.info("Launching browser: {}", browser);
        WebDriver driver;
        switch (browser) {

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (Boolean.parseBoolean((ConfigReader.get("headless", "false")))) {
                    chromeOptions.addArguments("--headless=new", "--disable-gpu");
                }
                driver = new ChromeDriver(chromeOptions);
                log.info("ChromeDriver instance created successfully.");
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (Boolean.parseBoolean((ConfigReader.get("headless", "false")))) {
                    firefoxOptions.addArguments("--headless", "--disable-gpu");
                }
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("url"));
        driverThreadLocal.set(driver);
        log.info("Application URL launched : {}",ConfigReader.get("url"));
        return driver;

    }
  public static void quitDriver(){
        WebDriver driver=driverThreadLocal.get();
      if(driver!=null){
          log.info("Quitting webdriver for current thread...");
          driver.quit();
          driverThreadLocal.remove();  // remove the driver from threadlocal
          } else {
          log.warn("No webdriver found for current thread to quit...");
      }
  }
}





