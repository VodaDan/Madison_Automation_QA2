package tests;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import models.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import pages.HeaderPage;
import pages.Homepage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utils.Navigation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class BaseTest {

    private Playwright playwright;
    private Browser browser;
    protected Page page;
    protected ProductPage productPage;
    protected Homepage homepage;
    protected HeaderPage headerPage;
    protected Navigation navigation;
    protected User globalUser;
    BrowserContext context;

    @BeforeEach
    public void startSession () {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300));
        context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        page = context.newPage();  // Folosește doar acest page
        navigation = new Navigation(page);
        globalUser = new User("Jon","Jon","Jon@email.com","user1234");
    }


    @AfterEach
    public void tearDown(TestInfo testInfo) throws IOException {
        String uniqueName = testInfo.getDisplayName() + "_" + System.currentTimeMillis();
        String fullPath = "screenshots/" + uniqueName + ".png";

        Files.createDirectories(Paths.get("screenshots"));

        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        Files.write(Paths.get(fullPath), screenshot);

        Path tracePath = Paths.get("target/trace.zip");
        context.tracing().stop(new Tracing.StopOptions().setPath(tracePath));

        Allure.addAttachment(uniqueName, "image/png", Files.newInputStream(Paths.get(fullPath)).toString());

        browser.close();
        playwright.close();
    }

}
