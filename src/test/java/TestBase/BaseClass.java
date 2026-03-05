package TestBase;

import java.io.InputStream;

import Utilities.ConfigReader;
import java.net.URI;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class BaseClass {
	// ThreadLocal ensures driver is unique per thread (parallel execution)
	private static ThreadLocal<AndroidDriver> driverThread = new ThreadLocal<>();
	protected static final Logger logger = LogManager.getLogger(BaseClass.class);
	private Properties prop;

	// Getter for driver
	public static AndroidDriver getDriver() {
		return driverThread.get();
	}

	public String getScreenshot(String testName) {

		String path = System.getProperty("user.dir") + "/reports/" + testName + ".png";

		try {
			logger.debug("Capturing screenshot for test: {}", testName);
			File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(path));
			logger.info("Screenshot saved at: {}", path);

		} catch (Exception e) {
			logger.error("Failed to capture screenshot for test: " + testName, e);
		}

		return path;
	}

	@BeforeMethod (groups = {"sanity", "regression", "datadriven"})
	@Parameters({"deviceName", "systemPort"})
	public void ConfigureAppium(String deviceName, String systemPort) throws Exception 
	{
		logger.info("========== Starting Test on Device: {} ==========", deviceName);

        try {
            ThreadContext.put("device", deviceName);

            logger.debug("Loading config.properties");

            prop = new Properties();
            InputStream input = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (input == null) {
                logger.error("config.properties not found in resources folder");
                throw new RuntimeException("config.properties not found");
            }
        prop.load(input);

        String appURL = prop.getProperty("appURL");
        String appPath = prop.getProperty("appPath");
        int waitTime = Integer.parseInt(prop.getProperty("implicitWait"));
        
        logger.debug("App URL: {}", appURL);
        logger.debug("App Path: {}", appPath);
        logger.debug("Implicit Wait: {} seconds", waitTime);

        int sysPort = Integer.parseInt(systemPort);

        logger.debug("System Port: {}", sysPort);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setSystemPort(sysPort);
        options.setApp(appPath);

     // If hybrid app, use manual chromedriver path
        options.setCapability("chromedriverExecutable",
        	    "C://Drivers//Chromedrivers//chromedriver-144.exe");
        
        logger.debug("Chromedriver path set");
        logger.info("Initializing Appium driver...");
        
        // --- Initialize driver ---
       AndroidDriver driver = new AndroidDriver(new URI(appURL).toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		

        // Store in ThreadLocal
        driverThread.set(driver);
        logger.info("Driver initialized successfully on device: {}", deviceName);

        } catch (Exception e) {
            logger.error("Driver initialization FAILED for device: " + deviceName, e);
            throw new RuntimeException("Driver setup failed", e);
        }
	}
	
	
	@AfterMethod (groups = {"sanity", "regression", "datadriven"})
	public void tearDown()
	{
		logger.info("Starting teardown process...");

        try {
            if (getDriver() != null) {
                logger.debug("Closing driver session");
                getDriver().quit();
                driverThread.remove();
                logger.info("Driver closed successfully");
            } else {
                logger.warn("Driver was null during teardown");
            }
        } catch (Exception e) {
            logger.error("Error during driver teardown", e);
        } finally {
            ThreadContext.clearAll();
            logger.info("========== Test Finished ==========");
        }
	}

}