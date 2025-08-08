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
}
