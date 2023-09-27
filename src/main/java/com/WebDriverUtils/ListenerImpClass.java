package com.WebDriverUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener
{
	
ExtentReports report;
ExtentTest test;
	@Override
	public void onTestStart(ITestResult result)
	{
		// actual Testscripts execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName+"------->Execution starts");
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+"--->Passed");
		Reporter.log(methodName+"------>TestScript executed successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		/*TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/Failedscript.png");
		try
		{
			FileUtils.copyFile(src, dst);
		}
		catch (Exception e) {
			e.printStackTrace();
		}*/
		String methodName = result.getMethod().getMethodName();
		try
		{
			String FailedScript = WebdriverUtility.takeScreenShot(BaseClass.sdriver, methodName);
			test.addScreenCaptureFromPath(FailedScript);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL,methodName+"------>Failed" );
		Reporter.log(methodName+"---->Failed");
	}
	

	@Override
	public void onTestSkipped(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, methodName+"--->skipped");
		Reporter.log(methodName+"---->skipped");
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		//create html reports
	ExtentSparkReporter htmlreport = new ExtentSparkReporter("./Extentreport/report.html");
		
	htmlreport.config().setDocumentTitle("SDET-51");
	htmlreport.config().setTheme(Theme.DARK);
	htmlreport.config().setReportName("Online_Tourism_Management_System");
	
	 report = new ExtentReports();
	report.attachReporter(htmlreport);
	report.setSystemInfo("OS", "windows 10 pro");
	report.setSystemInfo("Base-Browser", "chrome");
	report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Tourism_Management_System");
	report.setSystemInfo("Reporter Name", "Abhishek");
	
	
	}

	@Override
	public void onFinish(ITestContext context)
	{
		report.flush();
	}

	
}
