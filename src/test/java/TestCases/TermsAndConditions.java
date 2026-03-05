package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.ProductsPage;
import TestBase.BaseClass;
import Utilities.RetryAnalyzer;

public class TermsAndConditions extends BaseClass {

    // Initialize Log4j logger
    private static final Logger logger = LogManager.getLogger(TermsAndConditions.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void TestTermsAndConditions() {
        try {
            logger.info("Starting TermsAndConditions test");

            HomePage HP = new HomePage(getDriver());
            logger.debug("Entering name: Nitisha");
            HP.EnterName("Nitisha");

            logger.debug("Selecting gender: F");
            HP.ClickGender("F");

            logger.debug("Clicking 'Let's Shop'");
            HP.ClickLetsShop();

            ProductsPage PP = new ProductsPage(getDriver());
            logger.debug("Scrolling to 'Jordan 6 Rings'");
            PP.scrollToText("Jordan 6 Rings");

            logger.debug("Clicking 'Add to Cart'");
            PP.ClickAddToCart();

            logger.debug("Clicking Cart icon");
            PP.ClickCart();

            CartPage CP = new CartPage(getDriver());
            logger.debug("Performing long press on Terms and Conditions");
            CP.LongPressTermsAndConditions();

            String TandC = CP.VerifyAletTitle();
            logger.debug("Verifying Terms and Conditions alert title: " + TandC);

            try {
                Assert.assertEquals(TandC, "Terms Of Conditions", "Alert title mismatch!");
                logger.info("TermsAndConditions test passed");
            } catch (AssertionError e) {
                logger.error("Assertion failed: " + e.getMessage());
                throw e; // rethrow to mark test as failed
            }

        } catch (Exception e) {
            logger.error("Exception occurred during TermsAndConditions test: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}