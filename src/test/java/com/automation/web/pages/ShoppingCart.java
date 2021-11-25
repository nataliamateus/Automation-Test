package com.automation.web.pages;

import com.automation.web.pages.BasePage;
import com.automation.web.pages.PurchasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage {

    @FindBy(css = "div.layer_cart_product h2")
    private WebElement successMessage;

    @FindBy(css = "div.layer_cart_cart span.ajax_cart_quantity")
    private WebElement amountItems;

    @FindBy(css = "div.layer_cart_cart div.button-container a.btn-default")
    private WebElement checkoutButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public ShoppingCart(WebDriver pDriver) {
        super(pDriver);
    }


    public String getSuccessfullyMessage (){
        waitElementVisibility(successMessage);
        log.info(successMessage);
        return successMessage.getText();
    }

    public String getAmountItems (){
        waitElementVisibility(amountItems);
        return amountItems.getText();
    }

    public PurchasePage clickOnCheckoutButton (){
        clickElement(checkoutButton);
        return new PurchasePage(getDriver());
    }

}
