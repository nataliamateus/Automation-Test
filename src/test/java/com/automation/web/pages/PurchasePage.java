package com.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class PurchasePage extends BasePage {

    @FindBy(css = "tr.cart_total_price span#total_price")
    private WebElement totalPriceLabel;

    @FindBy(css = "td.cart_avail span.label")
    private WebElement inStockLabel;

    @FindBy(id = "total_price_without_tax")
    private WebElement totalPriceWithTax;

    @FindBy(id = "total_shipping")
    private WebElement totalShippingValue;

    @FindBy(css = "p.cart_navigation a>* :first-child")
    private WebElement proceedCheckoutButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public PurchasePage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getTotalShippingValue(){
        waitElementVisibility(inStockLabel);
        scrollDownToElement(inStockLabel);
        return totalShippingValue.getText();
    }

    public String getTotalPriceWithTax(){
        return totalPriceWithTax.getText();
    }

    public CreateAccountPage goToProceedCheckout(){
        clickElement(proceedCheckoutButton);
        return new CreateAccountPage(getDriver());
    }
}
