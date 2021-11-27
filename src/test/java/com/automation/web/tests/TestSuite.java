package com.automation.web.tests;

import com.automation.web.pages.*;
import com.automation.web.dataProvider.Data;
import com.automation.web.dataProvider.UserData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.automation.web.tests.listeners.Listener.class)

public class TestSuite extends BaseTest {

    @Test(description = "Suite Test", dataProviderClass = Data.class, dataProvider = "UserData")
    public void testAutomationPractice(UserData data) {
        log.info("1. Search for an item");
        HomePage homePage = getHomePage();
        homePage.searchItem();

        log.info("2. Sort the results by price (lowest).");
        homePage.selectProductSortBy();

        log.info("3. Add the item to the shopping cart");
        ShoppingCart shoppingCart = homePage.addTheItemToBuy();

        log.info("4. Go to the shopping cart and proceed with the purchase.");
        Assert.assertEquals(shoppingCart.getSuccessfullyMessage(), "Product successfully added to your shopping cart");
        String productQuantity = shoppingCart.getProductQuantity();
        Assert.assertEquals(productQuantity, "1", "The Product Quantity is incorrect");

        String totalPriceProducts = shoppingCart.getTotalPriceProducts();
        PurchasePage purchasePage = shoppingCart.clickOnCheckoutButton();

        log.info("4.1 Proceed with the purchase.");
        String totalShippingValue = purchasePage.getTotalShippingValue();
        CreateAccountPage createAccountPage = purchasePage.goToProceedCheckout();
        createAccountPage.createAccount(data.getEmail());

        log.info("5. Create an account, so, complete this flow");
        AddressPage addressPage= createAccountPage.registerUserData(data.getFirstName(), data.getLastName(), data.getEmail(), data.getPassword(), data.getAddress(),
                data.getCity(), data.getState(), data.getPostcode(), data.getPhoneMobile(), data.getAlias());
        String nameAddressDelivery =  addressPage.getNameAddressDelivery();
        String phoneAddressDelivery = addressPage.getPhoneAddressDelivery();
        String nameAddressInvoice = addressPage.getNameAddressInvoice();
        String phoneAddressInvoice = addressPage.getPhoneAddressInvoice();
        Assert.assertEquals(nameAddressDelivery,nameAddressInvoice);
        Assert.assertEquals(phoneAddressDelivery,phoneAddressInvoice);

        log.info("6. Make the purchase and confirm all the information.");
        ShippingPage shippingPage = addressPage.confirmDeliveryAddress();
        String deliveryPrice = shippingPage.getDeliveryPrice();
        Assert.assertEquals(deliveryPrice,totalShippingValue,"The total delivery price is different");

        PaymentPage paymentPage = shippingPage.proceedCheckout();
        String totalPricePayment = paymentPage.getTotalPricePayment();
        Assert.assertEquals(totalPriceProducts,totalPricePayment,"The total price does not match");
        OrderSummaryPage orderSummaryPage = paymentPage.getPayByBankWireOption();
        String currencyViaBanWire = orderSummaryPage.getCurrencyViaBanWire();
        Assert.assertEquals(currencyViaBanWire, "Dollar", "The currency is incorrect");
    }
}
