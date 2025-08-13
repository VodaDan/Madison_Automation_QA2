package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class WishlistPage {
    Page page;
    private Locator successMessageWishlist;
    private Locator lastProductPrice;
    private Locator wishlistItems;

    public WishlistPage(Page page){
        this.page = page;
        this.successMessageWishlist = page.locator(".success-msg");
        this.lastProductPrice = page.locator(".my-wishlist tbody tr.last .price");

    }
    public String getSuccessMessageWishlist(){
        return successMessageWishlist.innerText();
    }
    public String getLastProductPrice(){
        return lastProductPrice.innerText();
    }
    public String getWishlistPriceForSelectedProduct(String productName) {
        page.waitForSelector(".my-wishlist tbody tr");
        List<Locator> wishlistItems = page.locator(".my-wishlist tbody tr").all();
        for (Locator wishlistItem : wishlistItems) {
            String name = wishlistItem.locator(".product-name").innerText().trim();
             if(name.equalsIgnoreCase(productName))
             {
                 return wishlistItem.locator(".price").innerText().trim();
             }
        }
        return "Not found";
    }
}
