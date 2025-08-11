package utils;

import com.microsoft.playwright.Page;

public class Navigation {
    Page page;

    public Navigation(Page page) {
        this.page = page;
    }

    public void navigateToHomepage(){
        page.navigate("http://qa2magento.dev.evozon.com/");
    }

    public void navigateToRegisterPage() {
        this.navigateToHomepage();
        this.page.locator("a[data-target-element='#header-account']").click();
        this.page.locator("a[title='Register']").click();
    }
}
