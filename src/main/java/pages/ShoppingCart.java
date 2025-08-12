package pages;

import com.microsoft.playwright.*;

public class ShoppingCart {
    private Page page;
    private String quantitySelector;
    private String removeItemButtonSelector;
    private String checkoutBottomButtonSelector;
    private String checkoutTopButtonSelector;
    private String nameCheckout;
    private String emptyCartButtonSelector;
    private String proceedToCheckoutButton;

    public ShoppingCart(Page pageSent){
        page = pageSent;
        quantitySelector               = "#qty";
        removeItemButtonSelector       = "tr.first td.a-center a.btn-remove";
        checkoutBottomButtonSelector   ="ul.checkout-types.bottom button[title='Proceed to Checkout']";
        checkoutTopButtonSelector      ="ul.checkout-types.top";
        nameCheckout                   ="Proceed to Checkout";
        emptyCartButtonSelector        ="##empty_cart_button";
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
    public void checkoutBottomButton(){
        page.locator(checkoutBottomButtonSelector)
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions()
                        .setName(nameCheckout)).click();
    }
    public void checkoutTopButton(){
        page.locator(checkoutTopButtonSelector)
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions()
                        .setName(nameCheckout)).click();
    }

    public void emptyCart(){
        page.locator(emptyCartButtonSelector).click();
    }

    public void clickProceedToCheckout() {
        page.locator(proceedToCheckoutButton).click();
    }
}

