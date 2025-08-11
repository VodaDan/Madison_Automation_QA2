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
    private final Locator colorsList;
    private final Locator productItem;
    private final Locator sizesList;

    private final Locator addToWishlistButton;

    public ProductPage(Page page) {
        this.page = page;
        this.addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        this.successMessage = page.locator(".success-msg");
        this.productsGrid = page.locator(".products-grid .item");
        this.productItem = page.locator(".products-grid .item .product-image");
        this.colorsList = page.locator("#configurable_swatch_color > li");
        this.sizesList = page.locator("#configurable_swatch_size .swatch-label");
        this.addToWishlistButton = page.locator(".add-to-links .link-wishlist");
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

    public void selectColorAvailable(){
        List<Locator> colors = colorsList.all();

        if (colors.isEmpty()) {
            System.out.println("There are no colors available.");
            return;
        }

        Random random = new Random();
        int idx = random.nextInt(colors.size());
        Locator randomColor = colors.get(idx);


        if(randomColor.isVisible()){
            randomColor.click();
        }
    }

    public void selectSizeRandom(){
        List<Locator> sizes = sizesList.all();

        if (sizes.isEmpty()) {
            System.out.println("There are no sizes available.");
            return;
        }

        Random random = new Random();
        int idx = random.nextInt(sizes.size());
        Locator randomSize = sizes.get(idx);

        if(randomSize.isVisible()){
            randomSize.click();
        }
    }

    public void addRandomProductToCart(){
       clickRandomProductFromList();
       selectColorAvailable();
       selectSizeRandom();
       setAddToCartButton();
    }

    public void addToWishlist(){
        clickRandomProductFromList();
        addToWishlistButton.click();
    }
}
