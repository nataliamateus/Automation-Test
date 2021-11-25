package com.automation.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressPage extends BasePage {

    @FindBy(css = "select#id_address_delivery")
    private WebElement deliveryAddress;

    @FindBy(css = "input#addressesAreEquals")
    private WebElement checkBox;

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

    public void confirmDeliveryAddress(){
        waitElementVisibility(deliveryAddress);
        waitElementVisibility(checkBox);
        scrollUpToElement(proceedCheckOutButton);
        clickElement(proceedCheckOutButton);

    }






}



