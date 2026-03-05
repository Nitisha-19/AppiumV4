package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.ProductsPage;
import TestBase.BaseClass;
import Utilities.DataProviders;
import Utilities.RetryAnalyzer;

public class LetsShop extends BaseClass {

    @Test(
        groups = {"sanity", "regression", "datadriven"},
        dataProvider = "LoginData",
        dataProviderClass = DataProviders.class,
        retryAnalyzer = RetryAnalyzer.class
    )
    public void TestLetsShop(String name, String Gender) {

        logger.info("========== Starting Test: TestLetsShop ==========");
        logger.info("Executing with Data Set -> Name: {}, Gender: {}", name, Gender);

        try {

            // -------- Home Page --------
            logger.info("Initializing Home Page");
            HomePage Ls = new HomePage(getDriver());

            logger.debug("Entering Name: {}", name);
            Ls.EnterName(name);

            logger.debug("Selecting Gender: {}", Gender);
            Ls.ClickGender(Gender);

            logger.debug("Clicking Lets Shop button");
            Ls.ClickLetsShop();


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
            logger.error("Exception occurred during TestLetsShop execution", e);
            throw new RuntimeException(e); // Required for retry
        }

        logger.info("========== Test Completed: TestLetsShop ==========");
    }
}