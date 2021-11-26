package com.automation.practice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Driver class
 * @author natalia.mateus
 */
public class Driver {

    public WebDriver driver;

    /**
     * Constructor.
     * @param browser String
     */
    public Driver (String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
;               break;

            case "chromeMobile":
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "mobile":
                // Created object of DesiredCapabilities class.
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "11");
                capabilities.setCapability("deviceName", "emulator-5554");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("browserName", "Chrome");
                try {
                    driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }
    }

    /**
     * Get the driver.
     * @return {@link WebDriver}
     */
    public WebDriver getDriver() {
        return this.driver;
    }
}
