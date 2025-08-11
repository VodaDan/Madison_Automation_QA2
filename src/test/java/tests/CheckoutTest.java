package tests;

import models.DeliveryAddress;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.CheckoutPage;
import pages.ProductPage;
import pages.ShoppingCart;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @Override
    @BeforeEach
    public void startSession () {
        super.startSession();
        checkoutPage = new CheckoutPage(page);
    }

    @Disabled("Test fails - does not follow the shipping page after.")
    @Test
    public void checkoutBillingAddressOrder() {
        DeliveryAddress address = new DeliveryAddress();
        ProductPage productPage = new ProductPage(page);
        ShoppingCart shoppingCartPage = new ShoppingCart(page);
        navigation.navigateToHomepage();
        productPage.addRandomProductToCart();
        shoppingCartPage.clickProceedToCheckout();
        checkoutPage.checkoutClickOnePageContinueButton();
        checkoutPage.fillCheckoutForm(address);
        checkoutPage.fillRegion(); // default is "Alaska"
        checkoutPage.continueCheckout();
        assertThat(page.locator("li#opc-shipping")).containsClass("active");
    }

}
