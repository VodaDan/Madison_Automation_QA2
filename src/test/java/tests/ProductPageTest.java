package tests;

import org.junit.jupiter.api.Test;

public class ProductPageTest extends BaseTest{
    @Test
    public void goToRandomProductPage(){
        homepage.navigate();
        headerPage.navigateToDressesAndSkirts();
        productPage.clickRandomProductFromList();
    }
}
