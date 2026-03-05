package TestCases;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.FinalPurchasePage;
import PageObjects.HomePage;
import PageObjects.ProductsPage;
import TestBase.BaseClass;
import Utilities.RetryAnalyzer;

public class CompletePurchase extends BaseClass {

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void TestCompletePurchase() {

        logger.info("========== Starting Test: CompletePurchase ==========");

        try {

            // ---------------- Home Page ----------------
            logger.info("Entering user details on Home Page");
            HomePage HP = new HomePage(getDriver());

            logger.debug("Entering Name: Nitisha");
            HP.EnterName("Nitisha");

            logger.debug("Selecting Gender: F");
            HP.ClickGender("F");

            logger.debug("Clicking Lets Shop");
            HP.ClickLetsShop();


            // ---------------- Products Page ----------------
            logger.info("Navigating to Products Page");
            ProductsPage PP = new ProductsPage(getDriver());

            logger.debug("Scrolling to product: Jordan 6 Rings");
            PP.scrollToText("Jordan 6 Rings");

            logger.debug("Clicking Add To Cart");
            PP.ClickAddToCart();

            logger.debug("Opening Cart");
            PP.ClickCart();


            // ---------------- Cart Page ----------------
            logger.info("Handling Cart Page");
            CartPage CP = new CartPage(getDriver());

            logger.debug("Clicking Checkbox");
            CP.ClickCheckbox();

            logger.debug("Clicking Terms button to open WebView");
            CP.TestBtnToWeb();


            // ---------------- WebView Handling ----------------
            logger.info("Switching context to WebView");
            FinalPurchasePage FPP = new FinalPurchasePage(getDriver());

            Set<String> contexts = getDriver().getContextHandles();
            logger.debug("Available contexts:");

            for (String contextName : contexts) {
                logger.debug("Context found: {}", contextName);
            }

            FPP.switchContext("WEBVIEW_com.androidsample.generalstore");
            logger.info("Switched to WEBVIEW context successfully");

            logger.debug("Waiting for WebView to load (30 seconds)");
            Thread.sleep(30000);

            logger.debug("Entering text in WebView");
            FPP.setText();

            logger.debug("Pressing back from WebView");
            FPP.pressBack();

            logger.info("Switching back to Native App context");
            FPP.switchContext("NATIVE_APP");


            // ---------------- Validation ----------------
            logger.info("Validating return to Home Page");

            String homePage = HP.VerifyName();
            logger.debug("Actual Home Page Title: {}", homePage);

            try {
                Assert.assertEquals(homePage, "Your Name");
                logger.info("Home page validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Home page validation FAILED. Expected: 'Your Name', Actual: {}", homePage);
                throw ae;
            }

        } catch (Exception e) {
            logger.error("Test execution failed due to exception", e);
            throw new RuntimeException(e);
        }

        logger.info("========== Test Completed: CompletePurchase ==========");
    }
}