package com.automation.web.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    public Logger log = Logger.getLogger(BasePage.class);

    /**
     * Constructor.
     * @param pDriver WebDriver
     */
    public BasePage (WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait = new WebDriverWait(pDriver, 40);
        driver = pDriver;
    }

    /**
     * Get the web driver wait.
     * @return {@link WebDriverWait}
     */
    protected WebDriverWait getWait() {
        return wait;
    }

    /**
     * Get the  web driver.
     * @return {@link WebDriver}
     */
    protected WebDriver getDriver() {
        return driver;
    }

    /**
     * Wait element to be visible.
     * @param element WebElement
     */
    public void waitElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Wait List element to be visible.
     * @param list WebElement
     */
    public void waitListWebElementVisibility(List<WebElement> list) {
        getWait().until(ExpectedConditions.visibilityOfAllElements(list));
    }

    /**
     * Wait List Element to be refresh.
     * @param list WebElement
     */
    public void waitListWebElementRefresh(List<WebElement> list){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(list)));

    }

    /**
     * Wait Element to refresh.
     * @param element WebElement
     */

    public void waitWebElementRefresh(WebElement element){
        getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    /**
     * Wait element to be clickable.
     * @param element WebElement
     */
    public void waitElementToBeClickable (WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Click on webElement.
     * @param element WebElement
     */
    public void clickElement (WebElement element){
        waitElementToBeClickable(element);
        element.click();
    }

    /**
     * Write text in a WebElement.
     * @param element WebElement
     * @param text String
     */
    protected void write(WebElement element, String text){
        element.sendKeys(text);
    }

    /**
     * Wait element is invisible.
     * @param element WebElement
     */
    protected void waitElementInvisibility(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Hover on webElement.
     * @param element WebElement
     */
    public void hoverElement (WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }


    /**
     * Scroll down to element.
     * @param element WebElement
     */
    protected void scrollDownToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
        waitElementVisibility(element);
    }

    /**
     * Scroll up to element.
     * @param element WebElement
     */
    protected void scrollUpToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(-250);", element);
        waitElementVisibility(element);
    }

    /**
     * Close the web driver.
     */
    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }

}