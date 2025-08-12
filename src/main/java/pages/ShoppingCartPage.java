package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class ShoppingCartPage {
    private Page page;

    // Selectors
    private String quantitySelector;
    private String updateQuantityButton;
    private String editButton;
    private String removeItemButtonSelector;
    private String checkoutBottomButtonSelector;
    private String checkoutTopButtonSelector;
    private String nameCheckout;
    private String emptyCartButtonSelector;
    private String updateCartButtonSelector;
    private String continueShoppingButton;
    private String discountCodesField;
    private String estimateButtonSelector;
    private String countrySelector;
    private String stateSelector;
    private String citySelector;
    private String zipSelector;
    private String freeShippingButtonSelector;
    private String flatRateButtonSelector;
    private String productsList;
    private String productTitle;
    private String productPrice;
    private String productQuantity;


    public ShoppingCartPage(Page pageSent) {
        this.page = pageSent;

        quantitySelector             = "td.product-cart-actions input";
        updateQuantityButton         = "button:nth-child(2).btn-update";
        editButton                   = "ul:nth-child(3).cart-links a";
        removeItemButtonSelector     = "tr.first td.a-center a.btn-remove";
        checkoutBottomButtonSelector = "ul.checkout-types.bottom";
        checkoutTopButtonSelector    = "ul.checkout-types.top";
        nameCheckout                 = "Proceed to Checkout";
        emptyCartButtonSelector      = "#empty_cart_button";
        updateCartButtonSelector     = "button:nth-child(3).btn-update";
        continueShoppingButton       = "button.btn-continue";
        discountCodesField           = "#coupon_code";
        estimateButtonSelector       = "div.buttons-set button.button2";
        countrySelector              = "#country";
        stateSelector                = "#region_id";
        citySelector                 = "#city";
        zipSelector                  = "#postcode";
        freeShippingButtonSelector   = "#s_method_freeshipping_freeshipping";
        flatRateButtonSelector       = "#s_method_flatrate_flatrate";
        productsList                 = "#shopping-cart-table";
        productTitle                 = ".product-cart-info .product-name";
        productPrice                 = ".product-cart-price .cart-price";
        productQuantity              = ".input-text.qty";
    }

    // ===== Actions =====
    public void setQuantity(String quantity) { page.locator(quantitySelector).fill(quantity); }
    public void setUpdateQuantityButton() { page.locator(updateQuantityButton).click(); }
    public void editButton() { page.locator(editButton).click(); }
    public void removeItemFromCart() { page.locator(removeItemButtonSelector).click(); }

    public void checkoutBottomButton() {
        page.locator(checkoutBottomButtonSelector)
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions()
                        .setName(nameCheckout))
                .click();
    }

    public void checkoutTopButton() {
        page.locator(checkoutTopButtonSelector)
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions()
                        .setName(nameCheckout))
                .click();
    }

    public void emptyCart() { page.locator(emptyCartButtonSelector).click(); }
    public void updateCartButton() { page.locator(updateCartButtonSelector).click(); }
    public void continueShoppingButton() { page.locator(continueShoppingButton).click(); }
    public void discountCodesField(String discountCode) { page.locator(discountCodesField).fill(discountCode); }
    public void estimateButtonSelector() { page.locator(estimateButtonSelector).click(); }
    public void fillCountry(String country) { page.locator(countrySelector).selectOption(country); }
    public void fillState_DropDown(String state) { page.locator(stateSelector).selectOption(state); }
    public void fillState_NoDropDown(String region) { page.locator(stateSelector).fill(region); }
    public void fillCity(String city) { page.locator(citySelector).fill(city); }
    public void fillZip(String zip) { page.locator(zipSelector).fill(zip); }
    public void freeShippingButtonSelector() { page.locator(freeShippingButtonSelector).click(); }
    public void flatRateButtonSelector() { page.locator(flatRateButtonSelector).click(); }

    // ===== Getters =====
    public String getQuantitySelector()             { return quantitySelector; }
    public String getUpdateQuantityButton()         { return updateQuantityButton; }
    public String getEditButton()                   { return editButton; }
    public String getRemoveItemButtonSelector()     { return removeItemButtonSelector; }
    public String getCheckoutBottomButtonSelector() { return checkoutBottomButtonSelector; }
    public String getCheckoutTopButtonSelector()    { return checkoutTopButtonSelector; }
    public String getNameCheckout()                 { return nameCheckout; }
    public String getEmptyCartButtonSelector()      { return emptyCartButtonSelector; }
    public String getUpdateCartButtonSelector()     { return updateCartButtonSelector; }
    public String getContinueShoppingButton()       { return continueShoppingButton; }
    public String getDiscountCodesField()           { return discountCodesField; }
    public String getEstimateButtonSelector()       { return estimateButtonSelector; }
    public String getCountrySelector()              { return countrySelector; }
    public String getStateSelector()                { return stateSelector; }
    public String getCitySelector()                 { return citySelector; }
    public String getZipSelector()                  { return zipSelector; }
    public String getFreeShippingButtonSelector()   { return freeShippingButtonSelector; }
    public String getFlatRateButtonSelector()       { return flatRateButtonSelector; }
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

}
