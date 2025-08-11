package tests;

import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HeaderPage;
import pages.LoginPage;
import pages.ProductPage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPageTest extends BaseTest{
    private HeaderPage headerPage;
    private ProductPage productPage;
    private LoginPage loginPage;

    @Override
    @BeforeEach
    public void startSession(){
        super.startSession();
        headerPage = new HeaderPage(page);
        productPage = new ProductPage(page);
        loginPage = new LoginPage(page);
    }

    @Test
    public void addRandomProductToCart(){
        navigation.navigateToWomenDressesAndSkirts();
        productPage.clickRandomProductFromList();
        productPage.selectColorAvailable();
        productPage.selectSizeRandom();
        productPage.setAddToCartButton();
        assertThat(page).hasURL(Pattern.compile("cart"));
    }

    @Test
    public void addRandomProductToCart2(){
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addRandomProductToCart();
        assertThat(page).hasURL(Pattern.compile("cart"));
    }

    @Test
    public void addRandomProductToWishlist(){
        User testUser = new User("Jon","Jon","Jon@email.com","user1234");
        navigation.navigateToLoginPage();
        loginPage.login(testUser);
        navigation.navigateToWomenDressesAndSkirts();
        productPage.clickRandomProductFromList();
        productPage.addToWishlist();
        assertThat(page).hasURL(Pattern.compile("wishlist"));
    }
}
