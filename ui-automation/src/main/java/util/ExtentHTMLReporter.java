package util;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentHTMLReporter {
	
	


	    private static ExtentReports extent;
	    private static ExtentTest test;

	    public static void setExtent() {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	    }

	    public static void createTest(String testName) {
	        test = extent.createTest(testName);
	    }

	    public static void logStatus(Status status, String message) {
	        test.log(status, message);
	    }

	    public static void flushReport() {
	        extent.flush();
	    }
	}
