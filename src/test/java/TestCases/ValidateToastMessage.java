package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import TestBase.BaseClass;
import Utilities.RetryAnalyzer;

public class ValidateToastMessage extends BaseClass {

    // Initialize Log4j logger
    private static final Logger logger = LogManager.getLogger(ValidateToastMessage.class);

    @Test(groups = {"regression"}, retryAnalyzer = RetryAnalyzer.class)
    public void TestToastMessage() {
        try {
            logger.info("Starting ValidateToastMessage test");

            HomePage HP = new HomePage(getDriver());
            logger.debug("Clicking 'Let's Shop' without entering name");
            HP.ClickLetsShop();

            logger.debug("Capturing Toast message");
            String toastMessage = getDriver()
                    .findElement(By.xpath("(//android.widget.Toast)[1]"))
                    .getAttribute("name");

            logger.info("Toast message displayed: " + toastMessage);

            try {
                Assert.assertEquals(toastMessage, "Please enter your name", "Toast message mismatch!");
                logger.info("Toast message validation passed");
            } catch (AssertionError e) {
                logger.error("Assertion failed: " + e.getMessage());
                throw e; // rethrow to mark test as failed
            }

        } catch (Exception e) {
            logger.error("Exception occurred during ValidateToastMessage test: " + e.getMessage());
            e.printStackTrace();
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}