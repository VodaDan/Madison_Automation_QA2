package pages;

import com.microsoft.playwright.*;

public class ShoppingCart {
    private Page page;
    private String quantitySelector;
    private String removeItemButtonSelector;
    private String proceedToCheckoutButton;

    public ShoppingCart(Page pageSent){
        page = pageSent;
        quantitySelector         = "#qty";
        removeItemButtonSelector = "tr.first td.a-center a.btn-remove";
        proceedToCheckoutButton = "li.method-checkout-cart-methods-onepage-bottom button";
    }

    public void setQuantity(String quantity) {
        page.locator(quantitySelector).fill(quantity);
    }

    public void removeItemFromCart() {
        page.locator(removeItemButtonSelector).click();
    }

    public void clickProceedToCheckout() {
        page.locator(proceedToCheckoutButton).click();
    }
}

