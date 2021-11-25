package com.automation.web.tests;

import com.automation.practice.Driver;
import com.automation.web.pages.HomePage;
import org.apache.log4j.Logger;
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
        driver = new Driver(browser);
        driver.getDriver().manage().window().maximize();
        Home = new HomePage(driver.getDriver(), url);
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
