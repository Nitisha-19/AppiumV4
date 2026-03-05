package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.ProductsPage;
import TestBase.BaseClass;
import Utilities.RetryAnalyzer;

public class ShopSelectingUS extends BaseClass {

    // Initialize Log4j logger
    private static final Logger logger = LogManager.getLogger(ShopSelectingUS.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void ShopSelectingUSTest() {
        HomePage Lp = new HomePage(getDriver());
        try {
            logger.info("Starting ShopSelectingUS test");
            logger.debug("Scrolling to 'United States'");
            Lp.scrollToText("United States");

            logger.debug("Clicking on 'United States'");
            Lp.scrollToTextAndClick("United States");

            logger.debug("Entering name: Nitisha");
            Lp.EnterName("Nitisha");

            logger.debug("Selecting gender: F");
            Lp.ClickGender("F");

            logger.debug("Clicking 'Let's Shop' button");
            Lp.ClickLetsShop();

         // -------- Products Page --------
            logger.info("Navigating to Products Page");
            ProductsPage Pp = new ProductsPage(getDriver());

            logger.debug("Fetching Products Page title");
            String productsTitle = Pp.getProductPageTitle();

            logger.debug("Actual Products Page Title: {}", productsTitle);

            try {
                logger.info("Validating Products Page title");
                Assert.assertEquals(productsTitle, "Products");
                logger.info("Products Page validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Products Page validation FAILED. Expected: 'Products', Actual: {}", productsTitle);
                throw ae; // Required for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred during ShopSelectingUS execution", e);
            throw new RuntimeException(e); // Required for retry
        }

        logger.info("========== Test Completed: ShopSelectingUS ==========");
    }
}