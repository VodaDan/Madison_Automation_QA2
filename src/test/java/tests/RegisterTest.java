package tests;

import org.junit.jupiter.api.BeforeEach;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;

    @Override
    @BeforeEach
    public void startSession () {
        super.startSession();
        registerPage = new RegisterPage(page);
    }


}
