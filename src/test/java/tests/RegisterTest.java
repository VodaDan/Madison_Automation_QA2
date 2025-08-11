package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import models.User;
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

    @Test
    public void registerInvalidUserTest() {
        navigation.navigateToRegisterPage();
        registerPage.submitRegistration();
        assertThat(page).hasTitle("Create New Customer Account");
    }

    // TODO: User better asserts and validate user has been registered
    // Added asserts that the user account details are correct
    @Test
    public void registerValidUserTest() {
        User mockUser = new User();
        navigation.navigateToRegisterPage();
        registerPage.fillRegistrationForm(mockUser);
        assertThat(page).hasTitle("My Account");
        assertThat(page.locator("p.hello strong")).containsText(mockUser.getFirstName());
        assertThat(page.locator("p.hello strong")).containsText(mockUser.getLastName());
        assertThat(page.locator("div.box-content p").nth(0)).containsText(mockUser.getEmail());
    }


    // TODO: Use a automation testing project user all across the app
    @Test
    public void registerAlreadyRegisteredUserTest() {
        User mockUser = new User("Jon","Jon","Jon@email.com","user1234");
        navigation.navigateToRegisterPage();
        registerPage.fillRegistrationForm(mockUser);
        assertThat(page).hasTitle("Create New Customer Account");
    }


}
