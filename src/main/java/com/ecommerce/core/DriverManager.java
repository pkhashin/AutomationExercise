package com.ecommerce.core;

import com.ecommerce.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j

public class DriverManager {
    private static final Logger log = LoggerFactory.getLogger(DriverManager.class);
    private static final ThreadLocal<WebDriver> tl = new ThreadLocal<>();

    @Step("The application url is launched")
    public WebDriver launchApplication() {

        String browser = ConfigReader.get("browser", "CHROME").toUpperCase();
        log.info("Launching browser: {}", browser);
        switch (browser) {

            case "CHROME":
                WebDriverManager.chromedriver().setup();
                tl.set(new ChromeDriver());
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                tl.set(new FirefoxDriver());
                break;
            default:
                throw new RuntimeException("Invalid browser: " + browser);
        }
        WebDriver driver = getDriver();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(ConfigReader.get("url"));
        return driver;
    }

    public static WebDriver getDriver() {
        return tl.get();
    }

}





