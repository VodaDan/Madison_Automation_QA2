package pages;

import com.microsoft.playwright.Page;

public class Homepage {
    public Page page;

    public Homepage(Page page) {
        this.page = page;
    }

    public void navigate(){
        page.navigate("http://qa2magento.dev.evozon.com/");
    }
}
