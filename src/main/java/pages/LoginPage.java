package pages;

import com.microsoft.playwright.Page;
import models.User;

public class LoginPage {

    private static Page page;
    private static String emailSelector;
    private static String passwordSelector;
    private static String loginButtonSelector;

    public  LoginPage(Page pageSent) {
        page = pageSent;
        emailSelector = "#email";
        passwordSelector = "#pass";
        loginButtonSelector = "#send2";
    }

    public void login(User testUser) {
        fillEmail(testUser.getEmail());
        fillPassword(testUser.getPassword());
        submitLogin();
    }

    public void fillEmail(String email) {
        page.locator(emailSelector).fill(email);
    }

    public void fillPassword(String password) {
        page.locator(passwordSelector).fill(password);
    }

    public void submitLogin(){
        page.locator(loginButtonSelector).click();
    }
}
