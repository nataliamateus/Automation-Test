package com.automation.web.tests;

import com.automation.practice.Driver;
import com.automation.web.pages.HomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


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
            Home.takeScreenShot(result.getName());
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
