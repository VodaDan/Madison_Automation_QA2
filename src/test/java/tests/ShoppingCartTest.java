package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import pages.ShoppingCartPage;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest extends BaseTest {

    private ShoppingCartPage shoppingCartPage;

    @BeforeEach
    public void ShoppingCart(){
        super.startSession();
        shoppingCartPage = new ShoppingCartPage(page);
        productPage = new ProductPage(page);
    }

    @Test
    void testSetQuantityAndUpdate() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");//adding a product to be able to set the quantity to 4

        shoppingCartPage.setQuantity("4");
        shoppingCartPage.setUpdateQuantityButton();

        String actualQty = page.locator(shoppingCartPage.getQuantitySelector()).inputValue();
        assertEquals("4", actualQty, "Quantity in the cart should be updated to 2");
    }

    @Test
    void testEmptyCartFunctionality() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");
        assertTrue(page.locator(shoppingCartPage.getQuantitySelector()).isVisible(),
                "Cart should have at least one item before emptying");

        shoppingCartPage.emptyCart();

        boolean isCartEmpty = page.locator("div.cart-empty").isVisible() //
                || page.locator("p:has-text('You have no items in your shopping cart.')").isVisible();
        assertTrue(isCartEmpty, "Cart should be empty after clicking the empty cart button");
    }

    @Test
    void testRemoveItemFromCart() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");

        assertTrue(page.locator(shoppingCartPage.getRemoveItemButtonSelector()).isVisible(),
                "Remove button should be visible when an item is in the cart");

        shoppingCartPage.removeItemFromCart();

        boolean isCartEmpty = page.locator("div.cart-empty").isVisible() ||
                page.locator("p:has-text('You have no items in your shopping cart.')").isVisible();
        assertTrue(isCartEmpty, "Cart should be empty after removing the only item");
    }

    @Test
    void testContinueShoppingFromCart() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");

        shoppingCartPage.continueShoppingButton();

        String currentUrl = page.url();
        assertFalse(currentUrl.contains("checkout/cart"),
                "User should be navigated away from the cart after clicking continue shopping");
    }

    @Test
    void testApplyDiscountCode() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");

        shoppingCartPage.discountCodesField("PROMO10");
        shoppingCartPage.updateCartButton();

        assertTrue(page.locator("li.error-msg").isVisible(),
                "Error message should appear for expired discount code");
    }

    @Test
    void testProceedToCheckoutFromBottom() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");

        shoppingCartPage.checkoutBottomButton();

        assertTrue(page.url().contains("/checkout/onepage/"),
                "User should be redirected to the checkout page from bottom checkout button");
    }

    @Test
    void testProceedToCheckoutFromTop() {
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addRandomProductToCart("1");

        shoppingCartPage.checkoutTopButton();

        assertTrue(page.url().contains("checkout/onepage"),
                "User should be redirected to the checkout page from top checkout button");
    }
    @Test
    void testEstimateShipping() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");

        shoppingCartPage.fillCountry("US");
        shoppingCartPage.fillState_DropDown("California");
        shoppingCartPage.fillCity("Los Angeles");
        shoppingCartPage.fillZip("90001");
        shoppingCartPage.estimateButtonSelector();

        assertTrue(page.locator("#co-shipping-method-form").isVisible(),
                "Shipping methods should be displayed after estimating shipping");
    }

    @Test
    void testSelectFreeShipping() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");

        shoppingCartPage.fillCountry("US");
        shoppingCartPage.fillState_DropDown("California");
        shoppingCartPage.fillCity("Los Angeles");
        shoppingCartPage.fillZip("90001");
        shoppingCartPage.estimateButtonSelector();

        shoppingCartPage.freeShippingButtonSelector();

        assertTrue(page.locator("#s_method_freeshipping_freeshipping").isChecked(),
                "Free shipping option should be selected");
    }

    @Test
    void testSelectFlatRateShipping() {
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts/slim-fit-dobby-oxford-shirt-478.html");
        productPage.addSelectedProduct("2");

        shoppingCartPage.fillCountry("US");
        shoppingCartPage.fillState_DropDown("California");
        shoppingCartPage.fillCity("Los Angeles");
        shoppingCartPage.fillZip("90001");
        shoppingCartPage.estimateButtonSelector();

        shoppingCartPage.flatRateButtonSelector();

        assertTrue(page.locator("#s_method_flatrate_flatrate").isChecked(),
                "Free shipping option should be selected");
    }

}