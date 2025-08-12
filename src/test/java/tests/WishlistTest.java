package tests;


import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.WishlistPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WishlistTest extends BaseTest{
    private ProductPage productPage;
    private WishlistPage wishlistPage;
    private LoginPage loginPage;

     @Override
    @BeforeEach
    public void startSession(){
         super.startSession();
         productPage = new ProductPage(page);
         wishlistPage = new WishlistPage(page);
         loginPage = new LoginPage(page);
     }

     @Test
    public void addRandomProductToWishlist() throws InterruptedException {
        User testUser = new User("Jon","Jon","Jon@email.com","user1234");
        navigation.navigateToLoginPage();
        loginPage.login(testUser);
        navigation.navigateToWomenDressesAndSkirts();
        productPage.addToWishlist();
        assertEquals(wishlistPage.getSuccessMessageWishlist(), productPage.getProductTitle() + " has been added to your wishlist. Click here to continue shopping.");
     }

}
