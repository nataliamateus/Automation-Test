package com.automation.web.pages;

import com.automation.web.pages.BasePage;
import com.automation.web.pages.PurchasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage {

    @FindBy(css = "div.layer_cart_product h2")
    private WebElement successMessage;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement amountItems;

    @FindBy(id = "layer_cart_product_price")
    private WebElement totalPriceWithoutTaxProducts;

    @FindBy(className = "ajax_block_products_total")
    private WebElement totalPriceProducts;

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

    public String getSuccessfullyMessage(){
        waitElementVisibility(successMessage);
        log.info(successMessage);
        return successMessage.getText();
    }

    public String getProductQuantity(){
        waitElementVisibility(amountItems);
        log.info("Product quantity");
        return amountItems.getText();
    }

    public String getTotalWithoutTaxProducts(){
        log.info("Total Products without shipping");
        waitElementVisibility(totalPriceWithoutTaxProducts);
        return totalPriceWithoutTaxProducts.getText();
    }

    public String getTotalPriceProducts(){
        log.info("Total Price Products");
        waitElementVisibility(totalPriceProducts);
        return totalPriceProducts.getText();
    }

    public PurchasePage clickOnCheckoutButton(){
        clickElement(checkoutButton);
        return new PurchasePage(getDriver());
    }

}
