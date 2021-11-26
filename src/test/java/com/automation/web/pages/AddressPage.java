package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

    @FindBy(css = "select#id_address_delivery")
    private WebElement deliveryAddress;

    @FindBy(css = "input#addressesAreEquals")
    private WebElement checkBox;

    @FindBy(css = "li.address_title h3.page-subheading")
    private WebElement labelsAddress;

    @FindBy(css = "ul#address_delivery li.address_firstname")
    private WebElement nameAddressDelivery;

    @FindBy(css = "ul#address_delivery li.address_phone_mobile")
    private WebElement mobileAddressDelivery;

    @FindBy(css = "ul#address_invoice li.address_firstname")
    private WebElement nameAddressInvoice;

    @FindBy(css = "ul#address_invoice li.address_phone_mobile")
    private WebElement mobileAddressInvoice;

    @FindBy(className = "form-control")
    private WebElement commentTextArea;

    @FindBy(name = "processAddress")
    private WebElement proceedCheckOutButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public AddressPage(WebDriver pDriver) {
        super(pDriver);
    }

    public String getNameAddressDelivery(){
        return nameAddressDelivery.getText();
    }

    public String getPhoneAddressDelivery(){
        return mobileAddressDelivery.getText();
    }

    public String getNameAddressInvoice(){
        return nameAddressInvoice.getText();
    }

    public String getPhoneAddressInvoice(){
        return mobileAddressInvoice.getText();
    }

    public ShippingPage confirmDeliveryAddress(){
        scrollUpToElement(labelsAddress);
        waitElementVisibility(commentTextArea);
        write(commentTextArea, "Go ahead with the purchase");
        clickElement(proceedCheckOutButton);
        return new ShippingPage(getDriver());
    }

}



