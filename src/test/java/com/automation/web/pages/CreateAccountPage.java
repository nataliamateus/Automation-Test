package com.automation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    @FindBy(css = "div.form-group input#email_create")
    private WebElement emailTextBox;

    @FindBy(className = "icon-user")
    private WebElement createAccountButton;

    @FindBy(css = "div.account_creation h3.page-subheading")
    private WebElement signInPage;


    /////////////////////////////////////////////////////////////////////////////
    @FindBy(css = "div.radio-inline:nth-of-type(2) label.top")
    private WebElement titleCheckbox;

    @FindBy(css = "input#customer_firstname")
    private WebElement firstNameTextBox;

    @FindBy(css = "input#customer_lastname")
    private WebElement lastNameTextBox;

    @FindBy(css = "input#passwd")
    private WebElement passwordTextBox;

    /////////////////////////////////////////////////////////////////////////////

    @FindBy(css = "input#firstname")
    private WebElement firstNameAddress;

    @FindBy(css = "input#lastname")
    private WebElement lastNameAddress;

    @FindBy(css = "input#address1")
    private WebElement addressTextBox;

    @FindBy(css = "input#city")
    private WebElement cityTextBox;

    @FindBy(css = "input#postcode")
    private WebElement postcodeTextBox;

    @FindBy(css = "input#phone_mobile")
    private WebElement phoneMobileTextBox;

    @FindBy(css = "input#alias")
    private WebElement aliasTextBox;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;


    @FindBy(css = "tr.cart_total_price span#total_price")
    private WebElement totalPriceLabel;

    @FindBy(css = "td.cart_avail span.label")
    private WebElement inStockLabel;

    @FindBy(id = "total_price_without_tax")
    private WebElement totalPriceWithTax;

    @FindBy(css = "p.cart_navigation a>* :first-child")
    private WebElement proceedCheckoutButton;

    /**
     * Constructor.
     *
     * @param pDriver WebDriver
     */
    public CreateAccountPage(WebDriver pDriver) {
        super(pDriver);
    }

    public void createAccount(String email){
        scrollDownToElement(emailTextBox);
        clickElement(emailTextBox);
        write(emailTextBox,email);
        clickElement(createAccountButton);
    }

    public AddressPage registerUserData(String firstName, String lastName, String email, String password, String address, String city, String state, String postcode, String phoneMobile, String alias){
        waitElementVisibility(signInPage);
        scrollDownToElement(titleCheckbox);
        clickElement(titleCheckbox);
        clickElement(firstNameTextBox);
        write(firstNameTextBox,firstName);
        clickElement(lastNameTextBox);
        write(lastNameTextBox, lastName);
        clickElement(passwordTextBox);
        write(passwordTextBox, password);
        scrollDownToElement(firstNameAddress);
        clickElement(firstNameAddress);
        firstNameAddress.clear();
        write(firstNameAddress, firstName);
        clickElement(lastNameAddress);
        lastNameAddress.clear();
        write(lastNameAddress,lastName);
        clickElement(addressTextBox);
        write(addressTextBox,address);
        clickElement(cityTextBox);
        write(cityTextBox, city);
        Select stateDropDown = new Select(getDriver().findElement(By.id("id_state")));
        stateDropDown.selectByValue("3");
        clickElement(postcodeTextBox);
        write(postcodeTextBox, postcode);
        scrollDownToElement(phoneMobileTextBox);
        clickElement(phoneMobileTextBox);
        write(phoneMobileTextBox, phoneMobile);
        clickElement(aliasTextBox);
        aliasTextBox.clear();
        write(aliasTextBox,alias);
        clickElement(registerButton);
        return new AddressPage(getDriver());
    }

}
