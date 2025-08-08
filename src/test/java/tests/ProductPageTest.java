package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HeaderPage;
import pages.ProductPage;

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
    public void goToRandomProductPage(){
        navigation.navigateToHomepage();
        headerPage.navigateToDressesAndSkirts();
        productPage.clickRandomProductFromList();
    }
}
