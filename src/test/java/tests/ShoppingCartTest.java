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
        navigation.navigateToManShirts();
        productPage.addRandomProductToCart("2");//adding a product to be able to set the quantity to 2

        shoppingCartPage.setQuantity("2");
        shoppingCartPage.setUpdateQuantityButton();

        String actualQty = page.locator(shoppingCartPage.getQuantitySelector()).inputValue();
        assertEquals("2", actualQty, "Quantity in the cart should be updated to 2");
    }

    @Test
    void testEmptyCartFunctionality() {
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addRandomProductToCart("2");
        assertTrue(page.locator(shoppingCartPage.getQuantitySelector()).isVisible(),
                "Cart should have at least one item before emptying");

        shoppingCartPage.emptyCart();

        boolean isCartEmpty = page.locator("div.cart-empty").isVisible() //
                || page.locator("p:has-text('You have no items in your shopping cart.')").isVisible();
        assertTrue(isCartEmpty, "Cart should be empty after clicking the empty cart button");
    }

    @Test
    void testRemoveItemFromCart() {
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addRandomProductToCart("1");

        assertTrue(page.locator(shoppingCartPage.getRemoveItemButtonSelector()).isVisible(),
                "Remove button should be visible when an item is in the cart");

        shoppingCartPage.removeItemFromCart();

        boolean isCartEmpty = page.locator("div.cart-empty").isVisible() ||
                page.locator("p:has-text('You have no items in your shopping cart.')").isVisible();
        assertTrue(isCartEmpty, "Cart should be empty after removing the only item");
    }

    @Test
    void testContinueShoppingFromCart() {
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addRandomProductToCart("1");

        shoppingCartPage.continueShoppingButton();

        String currentUrl = page.url();
        assertFalse(currentUrl.contains("checkout/cart"),
                "User should be navigated away from the cart after clicking continue shopping");
    }

    @Test
    void testApplyDiscountCode() {
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addRandomProductToCart("1");

        shoppingCartPage.discountCodesField("INVALIDCODE");
        shoppingCartPage.updateCartButton();

        assertTrue(page.locator("li.error-msg").isVisible(),
                "Error message should appear for invalid discount code");
    }

}