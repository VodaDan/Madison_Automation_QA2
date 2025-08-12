package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HeaderPage {
    private Page page;
    private final Locator accountIcon;
    private final Locator searchField;
    private  final Locator searchButton;
    private final Locator dressesAndSkirts;
    private final  Locator womenDropdown;

    public HeaderPage(Page page) {
        this.page = page;
        this.accountIcon = page.locator("[data-target-element='#header-account']");
        this.searchField =  page.locator("#search");
        this.searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        this.dressesAndSkirts = page.locator("[alt='Dresses & Skirts']");
        this.womenDropdown = page.locator(".level0.nav-1");

    }

    public void clickAccountButton(){
        accountIcon.click();
    }

    public void searchFor(String keyword) {
        searchField.clear();
        searchField.fill(keyword);
        searchButton.click();
    }

    public void navigateToDressesAndSkirts(){
        womenDropdown.click();
        dressesAndSkirts.click();
    }
}
