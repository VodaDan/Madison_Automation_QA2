package pages;

import com.microsoft.playwright.*;

public class ShoppingCart {
    private Page page;
    private String categoryMenusSelector;
    private String subCategoryMenusSelector;
    private String productSelector;
    private String colorSelector;
    private String sizeSelector;
    private String quantitySelector;
    private String addToCartButtonSelector;
    private String removeItemButtonSelector;

    public ShoppingCart(Page pageSent){
        page = pageSent;
        categoryMenusSelector    = "#nav li.level0:nth-child(2)";
        subCategoryMenusSelector = "#nav li.nav-2-2 a";
        productSelector          = "#product-collection-image-403";
        colorSelector            = "#swatch27";
        sizeSelector             = "#swatch77";
        quantitySelector         = "#qty";
        addToCartButtonSelector  = "#product_addtocart_form button";
        removeItemButtonSelector = "tr.first td.a-center a.btn-remove";
    }

    public void hoverCategoryMenu() {
        page.locator(categoryMenusSelector).hover();
    }

    public void clickSubCategory() {
        page.locator(subCategoryMenusSelector).click();
    }

    public void selectProduct() {
        page.locator(productSelector).click();
    }

    public void selectColor() {
        page.locator(colorSelector).click();
    }

    public void selectSize() {
        page.locator(sizeSelector).click();
    }

    public void setQuantity(String quantity) {
        page.locator(quantitySelector).fill(quantity);
    }

    public void addToCart() {
        page.locator(addToCartButtonSelector).click();
    }

    public void removeItemFromCart() {
        page.locator(removeItemButtonSelector).click();
    }
}

