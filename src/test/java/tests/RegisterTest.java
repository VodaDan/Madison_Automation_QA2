package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;

    @Override
    @BeforeEach
    public void startSession () {
        super.startSession();
        registerPage = new RegisterPage(page);
    }

    @Test
    public void registerVerifyInputFieldAndButtonTest(){
        navigation.navigateToRegisterPage();
        assertThat(page.locator(registerPage.getFirstNameSelector())).isEditable();
        assertThat(page.locator(registerPage.getLastNameSelector())).isEditable();
        assertThat(page.locator(registerPage.getEmailSelector())).isEditable();
        assertThat(page.locator(registerPage.getPasswordSelector())).isEditable();
        assertThat(page.locator(registerPage.getConfirmationPasswordSelector())).isEditable();
        assertThat(page.locator(registerPage.getMiddleNameSelector())).isEditable();
        assertThat(page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Register"))).isVisible();
        assertThat(page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Register"))).isEnabled();

    }
}
