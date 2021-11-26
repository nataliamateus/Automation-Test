package com.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class HomePage extends BasePage {

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(id = "uniform-selectProductSort")
    private WebElement selectorSortBy;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @FindBy(css = "ul.product_list li.ajax_block_product>*:first-child")
    private WebElement productResults;

    @FindBy(css = "ul.product_list li.ajax_block_product div.product-container div.button-container >*:first-child")
    private WebElement addCartButton;

    /**
     * Constructor.
     * @param driver WebDriver
     * @param url String
     */
    public HomePage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    /**
     * Search the item
     */
    public String searchItem(){
        clickElement(searchInput);
        write(searchInput, "dresses");
        clickElement(searchButton);
        return searchInput.getText();
    }

    public void selectProductSortBy(){
        Select selector = new Select(getDriver().findElement(By.id("selectProductSort")));
    }

    public ShoppingCart addTheItemToBuy(){
        scrollDownToElement(productResults);
        hoverElement(productResults);
        clickElement(addCartButton);
        return new ShoppingCart(getDriver());
    }

}
