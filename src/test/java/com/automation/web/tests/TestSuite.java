package com.automation.web.tests;

import com.automation.web.pages.HomePage;
import com.automation.web.pages.PurchasePage;
import com.automation.web.dataProvider.Data;
import com.automation.web.dataProvider.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.automation.web.pages.ShoppingCart;

public class TestSuite extends BaseTest {

    @Test(description = "Search Item", dataProviderClass = Data.class, dataProvider = "UserData")
    public void testSearchItem(UserData data) {
        log.info("Assertions");
        HomePage homePage = getHomePage();
        homePage.searchItem();
        homePage.selectProductSortBy();
        ShoppingCart shoppingCart = homePage.addTheItemToBuy();
        Assert.assertEquals(shoppingCart.getSuccessfullyMessage(), "Product successfully added to your shopping cart");
        //Assert.assertEquals(shoppingCart.getAmountItems(), "1");
        PurchasePage purchasePage = shoppingCart.clickOnCheckoutButton();
        purchasePage.proceedCheckout();
        purchasePage.createAccount(data.getEmail());
        purchasePage.registerUserData(data.getFirstName(), data.getLastName(), data.getEmail(), data.getPassword(), data.getAddress(),
                data.getCity(), data.getState(), data.getPostcode(), data.getPhoneMobile(), data.getAlias());
    }
}
