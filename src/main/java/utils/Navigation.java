package utils;

import com.microsoft.playwright.Page;

import javax.swing.plaf.PanelUI;

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

    public  void navigateToWomenDressesAndSkirts(){
        page.navigate("http://qa2magento.dev.evozon.com/women/dresses-skirts.html");
    }
    public void navigateToManShirts(){
        page.navigate("http://qa2magento.dev.evozon.com/men/shirts.html");
    }

    public void navigateToJewelry(){
        page.navigate("http://qa2magento.dev.evozon.com/accessories/jewelry.html");
    }
}
