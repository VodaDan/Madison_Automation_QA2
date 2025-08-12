package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WishlistPage {
    Page page;
    private Locator successMessageWishlist;


    public WishlistPage(Page page){
        this.page = page;
        this.successMessageWishlist = page.locator(".success-msg");

    }
    public String getSuccessMessageWishlist(){
        return successMessageWishlist.innerText();
    }
}
