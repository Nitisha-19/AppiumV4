package Utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            String reportPath = System.getProperty("user.dir") 
                    + "/reports/ExtentReport_" + timeStamp + ".html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Appium Automation Report");
            sparkReporter.config().setDocumentTitle("Test Execution Results");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("Tester", "Nitisha");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Platform", "Android");

        }

        return extent;
    }

}
