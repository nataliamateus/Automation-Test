package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends BasePage {

    @FindBy(css = "h1.page-heading")
    private WebElement orderSummaryTitle;

    @FindBy(css = "div.box h3.page-subheading")
    private WebElement paymentTitle;

    @FindBy(css = "div.box p.cheque-indent strong.dark")
    private WebElement paymentResumeTitle;

    @FindBy(css = "div.box p:nth-of-type(3) b")
    private WebElement currencyType;

    @FindBy(css = "div.box p:nth-of-type(4)")
    private WebElement bankWireAccountInfo;
    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public OrderSummaryPage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getCurrencyViaBanWire(){
        waitElementVisibility(orderSummaryTitle);
        scrollDownToElement(paymentTitle);
        waitElementVisibility(paymentResumeTitle);
        log.info("Payment Resume Title");
        log.info(paymentResumeTitle.getText());
        log.info("Currency to be sent via bank wire");
        waitElementVisibility(currencyType);
        return currencyType.getText();
    }
}
