package tests;

import models.Product;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;

import javax.swing.*;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductTest extends BaseTest{
    private ProductPage productPage;
    private LoginPage loginPage;

    @Override
    @BeforeEach
    public void startSession(){
        super.startSession();
        productPage = new ProductPage(page);
        loginPage = new LoginPage(page);
    }

    @Test
    public void addRandomProductToWishlist(){
        User testUser = new User("Jon","Jon","Jon@email.com","user1234");
        navigation.navigateToLoginPage();
        loginPage.login(testUser);
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addToWishlist();
        assertThat(page).hasURL(Pattern.compile("wishlist"));
    }
}
