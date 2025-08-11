package tests;

import models.DeliveryAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CheckoutPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @Override
    @BeforeEach
    public void startSession () {
        super.startSession();
        checkoutPage = new CheckoutPage(page);
    }

    @Test
    public void checkoutFinishOrder() {
        DeliveryAddress address = new DeliveryAddress();
        ProductPage productPage = new ProductPage(page);
        navigation.navigateToHomepage();
        checkoutPage.fillCheckoutForm(address);
        checkoutPage.fillRegion(); // default is "Alaska"
        checkoutPage.continueCheckout();
    }

}
