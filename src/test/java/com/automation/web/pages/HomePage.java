package com.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class HomePage extends BasePage {

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(id = "uniform-selectProductSort")
    private WebElement selectorSortBy;

    Select selector = new Select(getDriver().findElement(By.id("selectProductSort")));

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
     * Get the Hotel Name selected
     */
    public String searchItem(){
        clickElement(searchInput);
        write(searchInput, "dresses");
        log.info(searchInput.getText());
        clickElement(searchButton);
        return searchInput.getText();
    }

    public void selectProductSortBy(){
        clickElement(selectorSortBy);
        selector.selectByValue("price:asc");
    }

    public ShoppingCart addTheItemToBuy(){
        scrollDownToElement(productResults);
        hoverElement(productResults);
        clickElement(addCartButton);
        return new ShoppingCart(getDriver());
    }

}
