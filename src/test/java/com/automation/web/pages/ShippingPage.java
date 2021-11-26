package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePage {

    @FindBy(css = "h1.page-heading")
    private WebElement shippingTitle;

    @FindBy(id = "uniform-cgv")
    private WebElement checkboxField;

    @FindBy(css = "td.delivery_option_price")
    private WebElement deliveryPriceLabel;

    @FindBy(name = "processCarrier")
    private WebElement proceedToCheckoutButton;


    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ShippingPage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getDeliveryPrice (){
        waitElementVisibility(shippingTitle);
        scrollDownToElement(deliveryPriceLabel);
        return deliveryPriceLabel.getText();
    }

    public PaymentPage proceedCheckout(){
        clickElement(checkboxField);
        clickElement(proceedToCheckoutButton);
        return new PaymentPage(getDriver());
    }
}
