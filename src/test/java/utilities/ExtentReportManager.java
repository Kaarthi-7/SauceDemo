package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports report;
	public ExtentTest test;

	String reportName;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		reportName = "TestNG_ExtentReport"+timeStamp+".html";

		String filepath = System.getProperty("user.dir") + "/Reports/";
		sparkReporter = new ExtentSparkReporter(filepath + reportName);// specify location of the report

		sparkReporter.config().setDocumentTitle("SauceDemo"); // Title of report
		sparkReporter.config().setReportName("Demo"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
				
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		report.setSystemInfo("Application", "SauceDemo");
		report.setSystemInfo("Module", "Demo");
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("User Name", System.getProperty("user.name"));
		report.setSystemInfo("Browser", System.getProperty("driver.name"));
	}

	public void onTestSuccess(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = report.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		report.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\Reports\\"+reportName;
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}