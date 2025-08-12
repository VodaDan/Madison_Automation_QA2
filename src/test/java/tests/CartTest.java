package tests;

import models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.ShoppingCart;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CartTest extends BaseTest{
    private ProductPage productPage;
    private ShoppingCart shoppingCart;

    @Override
    @BeforeEach
    public void startSession(){
        super.startSession();
        productPage = new ProductPage(page);
        shoppingCart = new ShoppingCart(page);
    }

    @Test
    public void addRandomProductToCart() {
        navigation.navigateToJewelry();
        String quantity = "1";
        productPage.addRandomProductToCart(quantity);

        assertThat(page).hasURL(Pattern.compile("cart"));

        assertEquals(productPage.getProductTitle(), shoppingCart.getProductTitle());
        assertEquals(productPage.getProductPrice(), shoppingCart.getPrice());
        assertEquals(quantity, shoppingCart.getQuantity());

        if (productPage.getSelectedColor() != null) {
            assertEquals(productPage.getSelectedColor(), shoppingCart.getLastProductColor());
        } else {
            assertNull(shoppingCart.getLastProductColor());
        }

        if (productPage.getSelectedSize() != null) {
            assertEquals(productPage.getSelectedSize(), shoppingCart.getLastProductSize());
        } else {
            assertNull(shoppingCart.getLastProductSize());
        }
    }
}
