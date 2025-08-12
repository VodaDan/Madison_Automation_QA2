package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class ShoppingCart {
    private Page page;
    private String quantitySelector;
    private String removeItemButtonSelector;
    private String proceedToCheckoutButton;
    private String productsList;
    private String productTitle;
    private String productPrice;
    private String productQuantity;
    private String checkoutBottomButtonSelector;
    private String checkoutTopButtonSelector;
    private String nameCheckout;
    private String emptyCartButtonSelector;


    public ShoppingCart(Page pageSent){
        page = pageSent;
        quantitySelector               = "#qty";
        removeItemButtonSelector       = "tr.first td.a-center a.btn-remove";
        checkoutBottomButtonSelector   ="ul.checkout-types.bottom']";
        checkoutTopButtonSelector      ="ul.checkout-types.top";
        nameCheckout                   ="Proceed to Checkout";
        emptyCartButtonSelector        ="##empty_cart_button";
        quantitySelector         = "#qty";
        removeItemButtonSelector = "tr.first td.a-center a.btn-remove";
        proceedToCheckoutButton = "li.method-checkout-cart-methods-onepage-bottom button";
        productsList = "#shopping-cart-table";
        productTitle = ".product-cart-info .product-name";
        productPrice = ".product-cart-price .cart-price";
        productQuantity = ".input-text.qty";
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

    public String getProductTitle(){
        return page.locator(productTitle).last().innerText();
    }

    public String getPrice(){
        return page.locator(productPrice).last().innerText();
    }
    public String getQuantity(){
        return page.locator(productQuantity).last().inputValue();
    }
    public String getLastProductColor() {
        return page.locator("dl.item-options dt:has-text('Color') + dd").last().count() == 0 ? null : page.locator("dl.item-options dt:has-text('Color') + dd").last().innerText();
    }
    public String getLastProductSize() {
        return page.locator("dl.item-options dt:has-text('Size') + dd").last().count() == 0 ? null : page.locator("dl.item-options dt:has-text('Color') + dd").last().innerText();
    }
    public void checkoutTopButton(){
        page.locator(checkoutTopButtonSelector)
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions()
                        .setName(nameCheckout)).click();
    }

    public void emptyCart(){
        page.locator(emptyCartButtonSelector).click();
    }
}

