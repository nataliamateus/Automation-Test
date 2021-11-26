package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(css = "h1.page-heading")
    private WebElement paymentTitleLabel;

    @FindBy(css = "td.cart_avail span.label")
    private WebElement inStockLabel;

    @FindBy(css = "p.payment_module a.bankwire")
    private WebElement payByBankWireButton;

    @FindBy(css = "tr.cart_total_price td.price")
    private WebElement totalPriceLabel;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public PaymentPage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getTotalPricePayment(){
        waitElementVisibility(paymentTitleLabel);
        waitElementVisibility(totalPriceLabel);
        scrollDownToElement(totalPriceLabel);
        log.info(totalPriceLabel.getText());
        return totalPriceLabel.getText();
    }

    public OrderSummaryPage getPayByBankWireOption(){
        clickElement(payByBankWireButton);
        return new OrderSummaryPage(getDriver());
    }
}
