package com.automation.web.tests;

import com.automation.practice.Driver;
import com.automation.web.pages.HomePage;
import com.beust.jcommander.converters.PathConverter;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * Unit test for simple App.
 */
public class BaseTest {

    Driver driver;
    protected HomePage Home;

    public Logger log = Logger.getLogger(BaseTest.class);
    @BeforeTest(alwaysRun=true)
    @Parameters({"browser", "url"})
    public void beforeTest(String browser, String url) {
        switch (browser)
        {
            case "chrome":
                driver = new Driver(browser);
                driver.getDriver().manage().window().maximize();
                break;

            case "mobile":
                driver = new Driver(browser);
                break;

            case "chromeMobile":
                driver = new Driver(browser);
                driver.getDriver().manage().window().maximize();
                driver.getDriver().manage().window().setSize(new Dimension(120,1000));
                break;

            default:
                break;
        }
        Home = new HomePage(driver.getDriver(), url);
    }


    @AfterMethod(alwaysRun=true)
    public void catchExceptions(ITestResult result){{
            if(!result.isSuccess()){
               Home.TakeScreenShot(result.getName());
            }
        }
    }

    @AfterTest(alwaysRun=true)
    public void afterTest() {
        Home.dispose();
    }

   /**
     * Get the home page.
     * @return {@link HomePage}
     */
    public HomePage getHomePage() {
        return Home;
    }
}
