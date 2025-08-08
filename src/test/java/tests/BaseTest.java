package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.HeaderPage;
import pages.Homepage;
import pages.ProductPage;


public class BaseTest {

    private Playwright playwright;
    private Browser browser;
    protected Page page;
    protected ProductPage productPage;
    protected Homepage homepage;
    protected HeaderPage headerPage;


    @BeforeEach
    public void startSession () {
        this.playwright = Playwright.create();
        this.browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
        this.page = browser.newPage();
        this.productPage = new ProductPage(page);
        this.homepage = new Homepage(page);
        this.headerPage = new HeaderPage(page);
    }

    @AfterEach
    public void tearDown() {
        browser.close();
        playwright.close();
    }

}
