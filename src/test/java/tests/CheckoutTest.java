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
        productPage.addRandomProductToCart("2");
        shoppingCartPage.checkoutBottomButton();
        checkoutPage.checkoutClickOnePageContinueButton();
        checkoutPage.fillCheckoutFormBilling(address);
        checkoutPage.fillRegion(); // default is "Alaska"
        checkoutPage.clickContinueBilling();
        assertThat(page.locator("li#opc-shipping")).containsClass("active");
    }

    @Test
    public void checkoutDifferentShippingAndBillingAddressTest() {
        DeliveryAddress address = new DeliveryAddress();
        ProductPage productPage = new ProductPage(page);
        ShoppingCart shoppingCartPage = new ShoppingCart(page);
        navigation.navigateToHomepage();
        productPage.addRandomProductToCart("2");
        shoppingCartPage.checkoutTopButton();
        checkoutPage.checkoutClickOnePageContinueButton();

        // Billing form
        checkoutPage.fillCheckoutFormBilling(address);
        page.locator("label[for='billing:use_for_shipping_no']").click();
        checkoutPage.fillRegion(); // default is "Alaska"
        checkoutPage.clickContinueBilling();

        // Shipping form
        assertThat(page.locator("li#opc-shipping")).containsClass("active");
        checkoutPage.fillCheckoutFormShipping(address);
        checkoutPage.clickContinueShipping();
        page.setDefaultTimeout(60000);

        // Select Shipping method
        checkoutPage.selectRate("free");
        checkoutPage.clickContinueShippingPrice();

        // Select Payment
        checkoutPage.clickContinuePayment();

        // Place Order
        checkoutPage.clickPlaceOrder();

        assertThat(page).hasTitle("Magento Commerce");
        assertThat(page.locator("div.page-title h1")).hasText("Your order has been received.");


    }


}
