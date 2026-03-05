package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import TestBase.BaseClass;
import Utilities.RetryAnalyzer;

public class LaunchApp extends BaseClass {

    @Test(groups = {"sanity", "regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void LaunchAppTest() {

        logger.info("========== Starting Test: LaunchAppTest ==========");

        try {

            logger.info("Initializing Home Page");
            HomePage Hp = new HomePage(getDriver());

            logger.debug("Fetching Home Page label text");
            String homePageText = Hp.VerifyName();

            logger.debug("Actual Home Page Text: {}", homePageText);

            try {
                logger.info("Validating Home Page text");
                Assert.assertEquals(homePageText, "Your Name");
                logger.info("Home Page validation PASSED");

            } catch (AssertionError ae) {
                logger.error("Home Page validation FAILED. Expected: 'Your Name', Actual: {}", homePageText);
                throw ae; // Important for RetryAnalyzer
            }

        } catch (Exception e) {
            logger.error("Exception occurred during LaunchAppTest execution", e);
            throw new RuntimeException(e); // Important for retry + reporting
        }

        logger.info("========== Test Completed: LaunchAppTest ==========");
    }
}