package tests;

import org.junit.jupiter.api.BeforeEach;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    private CheckoutPage checkoutPage;

    @Override
    @BeforeEach
    public void startSession () {
        super.startSession();
        checkoutPage = new CheckoutPage(page);
    }

}
