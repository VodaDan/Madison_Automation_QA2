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
        productPage.addRandomProductToCart();//adding a product to be able to set the quantity to 2

        shoppingCartPage.setQuantity("2");
        shoppingCartPage.setUpdateQuantityButton();

        String actualQty = page.locator(shoppingCartPage.getQuantitySelector()).inputValue();
        assertEquals("2", actualQty, "Quantity in the cart should be updated to 2");
    }

    @Test
    void testEmptyCartFunctionality() {
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addRandomProductToCart();
        assertTrue(page.locator(shoppingCartPage.getQuantitySelector()).isVisible(),
                "Cart should have at least one item before emptying");

        shoppingCartPage.emptyCart();

        boolean isCartEmpty = page.locator("div.cart-empty").isVisible() //
                || page.locator("p:has-text('You have no items in your shopping cart.')").isVisible();
        assertTrue(isCartEmpty, "Cart should be empty after clicking the empty cart button");
    }

}