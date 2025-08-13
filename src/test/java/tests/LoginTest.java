package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    @Override
    @BeforeEach
    public void startSession () {
        super.startSession();
        loginPage = new LoginPage(page);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test/loginDataValid.csv", numLinesToSkip = 1)
    @DisplayName("Login Test")
    public void testLogin(String email, String password){
        navigation.navigateToLoginPage();
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.submitLogin();
        assertThat(page).hasTitle("My Account");
    }
}
