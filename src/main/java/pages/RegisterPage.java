package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import models.User;

public class RegisterPage {

    private Page page;
    private String firstNameSelector;
    private String lastNameSelector;
    private String emailSelector;
    private String passwordSelector;
    private String registerButtonSelector;
    private String confirmationPasswordSelector;
    private String middleNameSelector;

    public RegisterPage(Page pageSent) {
        page = pageSent;
        firstNameSelector = "#firstname";
        lastNameSelector = "#lastname";
        emailSelector = "#email_address";
        passwordSelector = "#password";
        confirmationPasswordSelector = "#confirmation";
        registerButtonSelector = "#";
        middleNameSelector ="#middlename";
    }

    public void fillFirstName(String firstName) {
        page.locator(firstNameSelector).fill(firstName);
    }

    public void fillLastName(String lastName) {
        page.locator(lastNameSelector).fill(lastName);
    }

    public void fillEmail(String email) {
        page.locator(emailSelector).fill(email);
    }

    public void fillPassword(String password) {
        page.locator(passwordSelector).fill(password);
        page.locator(confirmationPasswordSelector).fill(password);
    }

    public void submitRegistration() {
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Register")).click();
    }

    public void fillRegistrationForm(User testUser){
        fillFirstName(testUser.getFirstName());
        fillLastName(testUser.getLastName());
        fillEmail(testUser.getEmail());
        fillPassword(testUser.getPassword());
        submitRegistration();
    }

}
