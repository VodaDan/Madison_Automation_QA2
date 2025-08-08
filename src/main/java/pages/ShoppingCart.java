package pages;

import com.microsoft.playwright.*;

public class ShoppingCart {
    private Page page;
    private String quantitySelector;
    private String removeItemButtonSelector;

    public ShoppingCart(Page pageSent){
        page = pageSent;
        quantitySelector         = "#qty";
        removeItemButtonSelector = "tr.first td.a-center a.btn-remove";
    }

    public void setQuantity(String quantity) {
        page.locator(quantitySelector).fill(quantity);
    }

    public void removeItemFromCart() {
        page.locator(removeItemButtonSelector).click();
    }
}

