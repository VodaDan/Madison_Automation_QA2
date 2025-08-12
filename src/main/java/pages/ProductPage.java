package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;
import java.util.Random;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class ProductPage {
    Page page;
    private final Locator addToCartButton;
    private final Locator successMessage;
    private final Locator productsGrid;
    private final Locator colorsList;
    private final Locator sizesList;

    private final Locator addToWishlistButton;
    private final Locator productTitleLocator;
    private String title;
    private String selectedColor = null;
    private String selectedSize =  null;
    private Locator priceLocator;
    private String price = null;
    private final Locator quantityField;

    public ProductPage(Page page) {
        this.page = page;
        this.addToCartButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to Cart"));
        this.successMessage = page.locator(".success-msg");
        this.productsGrid = page.locator(".products-grid .item");
        this.colorsList = page.locator("#configurable_swatch_color li:not(.not-available)");
        this.sizesList = page.locator("#configurable_swatch_size li:not(.not-available) .swatch-label");
        this.addToWishlistButton = page.locator(".add-to-links .link-wishlist");
        this.productTitleLocator = page.locator(".product-shop .product-name");
        this.priceLocator = page.locator(".price-info .price-box .regular-price .price");
        this.quantityField = page.locator("#qty");
    }

    public Locator getSuccessMessage() {
        return successMessage;
    }

    public void setAddToCartButton(){
        addToCartButton.click();
    }

    public void setQuantityField(String quantity){
        quantityField.clear();
        assertThat(quantityField).isEditable();
        quantityField.fill(quantity);
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

        title = productTitleLocator.innerText();
        price = priceLocator.innerText();
        System.out.println(title);
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
        selectedColor = randomColor.locator("img").getAttribute("alt");
        System.out.println(selectedColor);
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
        selectedSize = randomSize.innerText();
        System.out.println(selectedSize);
    }

    public void addRandomProductToCart(String quantity){
        selectedColor = null;
        selectedSize = null;

        clickRandomProductFromList();

        if (colorsList.count() > 0)
            selectColorAvailable();
        if (sizesList.count()  > 0)
            selectSizeRandom();

        setQuantityField(quantity);
        setAddToCartButton();
    }


    public void addToWishlist(){
        clickRandomProductFromList();
        addToWishlistButton.click();
    }

    public String getProductTitle(){
        return title;
    }

    public  String getSelectedColor(){
        return selectedColor;
    }

    public String getSelectedSize(){
        return selectedSize;
    }

    public String getProductPrice(){
        return price;
    }
}
