package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ProductsPage;
import TestBase.BaseClass;
import Utilities.RetryAnalyzer;

public class AddToCart extends BaseClass {

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void TestAddtoCart() {

        logger.info("========== Starting Test: AddToCart ==========");
        logger.debug("Initializing Page Objects");

        try {

            // Home Page Actions
            logger.info("Entering user details on Home Page");
            HomePage HP = new HomePage(getDriver());

            logger.debug("Entering name: Nitisha");
            HP.EnterName("Nitisha");

            logger.debug("Selecting Gender: Female");
            HP.ClickGender("Female");

            logger.debug("Clicking Lets Shop button");
            HP.ClickLetsShop();


            // Products Page Actions
            logger.info("Navigating to Products Page");
            ProductsPage PP = new ProductsPage(getDriver());

            logger.debug("Scrolling to product: Jordan 6 Rings");
            PP.scrollToText("Jordan 6 Rings");

            logger.debug("Clicking Add To Cart");
            PP.ClickAddToCart();

            logger.debug("Clicking Cart icon");
            PP.ClickCart();


            // Cart Page Validation
            logger.info("Validating Cart Page Title");
            CartPage CP = new CartPage(getDriver());

            String Cart1 = CP.VerifyCartTitle();
            logger.debug("Actual Cart Title: {}", Cart1);

            try {
                Assert.assertEquals(Cart1, "Cart");
                logger.info("Cart title validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Cart title validation FAILED. Expected: Cart, Actual: {}", Cart1);
                throw ae;  // Important: rethrow so Retry + Extent works
            }

        } catch (Exception e) {
            logger.error("Test execution failed due to exception", e);
            throw e;  // Rethrow so TestNG marks test as failed
        }

        logger.info("========== Test Completed: AddToCart ==========");
    }
}