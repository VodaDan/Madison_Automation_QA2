package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HeaderPage;
import pages.ProductPage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPageTest extends BaseTest{
    private HeaderPage headerPage;
    private ProductPage productPage;

    @Override
    @BeforeEach
    public void startSession(){
        super.startSession();
        headerPage = new HeaderPage(page);
        productPage = new ProductPage(page);
    }

    @Test
    public void addRandomProduct(){
        navigation.navigateToHomepage();
        navigation.navigateToWomenDressesAndSkirts();
        productPage.clickRandomProductFromList();
        productPage.selectColorAvailable();
        productPage.selectSizeRandom();
        productPage.setAddToCartButton();
        assertThat(page).hasURL(Pattern.compile("cart"));
    }
}
