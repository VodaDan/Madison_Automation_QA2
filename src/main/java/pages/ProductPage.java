package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;
import java.util.Random;

public class ProductPage {
    Page page;
    private final Locator addToCartButton;
    private final Locator successMessage;
    private final Locator productsGrid;
    private final Locator productItem;

    public ProductPage(Page page) {
        this.page = page;
        this.addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        this.successMessage = page.locator(".success-msg");
        this.productsGrid = page.locator(".products-grid .item");
        this.productItem = page.locator(".products-grid .item .product-image");
    }

    public Locator getSuccessMessage() {
        return successMessage;
    }

    public void setAddToCartButton(){
        addToCartButton.click();
    }

    public void clickRandomProductFromList() {
        List<Locator> products = productsGrid.all();

        if (products.isEmpty()) {
            throw new RuntimeException("There are no products on the page.");
        }
        Random random = new Random();
        int idx = random.nextInt(products.size());
        Locator randomProduct = products.get(idx);
        randomProduct.click();
    }

}
