package genericUtility;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.Files;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * This class provides implementation on ITestListeners in TestNG
 * @author Administrator
 *
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	String	methodName=result.getMethod().getMethodName();
	
	System.out.println(methodName+"--Test Execution started---------"); 
		
	// it will provide @test method name which is currently running
	
	test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String	methodName=result.getMethod().getMethodName();
		
		System.out.println(methodName+"--Test pass---------"); 
		test.log(Status.PASS, methodName +"---Test pass ------");	
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String	methodName=result.getMethod().getMethodName();
		
		System.out.println(methodName+"--Test fail---------"); 
		System.out.println(result.getThrowable());// used to throw the exception 
	
		test.log(Status.FAIL, methodName +"---Test pass ------");	
		test.log(Status.INFO, result.getThrowable());
		
		//capture screenshot
		TakesScreenshot screen = (TakesScreenshot) BaseClass.sdriver;
		File src= screen.getScreenshotAs(OutputType.FILE);
		LocalDateTime localDataTime= LocalDateTime.now();
		localDataTime.toString().replace(" ", "-").replace(":", "/");
	//	File dest = new File("./ScreenShot/\"+testName+\".png");
		
		try {
		//	Files.copy(src, dest);
			Files.copy(src,new File(methodName+".png"));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem is saving screenshot"+e.getMessage());
			}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String	methodName=result.getMethod().getMethodName();
		
		System.out.println(methodName+"--Test skip---------"); 
		System.out.println(result.getThrowable());// used to throw the exception 
		
		test.log(Status.SKIP, methodName +"---Test skip ------");	
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		String	methodName=result.getMethod().getMethodName();
		
		System.out.println(methodName+"--Test Execution started---------"); 
			
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--suite execution started----");
		
		//Configure the extent Reports
		ExtentSparkReporter htmlrep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemInFormat()+".html");
		htmlrep.config().setDocumentTitle("Vtiger Execution Report");
		htmlrep.config().setReportName("Execution report BuildV2.3.1");
		htmlrep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "http://TestEnv.com");
		report.setSystemInfo("Base Platform", "Windows - Family");
		report.setSystemInfo("Reporter Name", "Chaitra");
			
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("--suite execution finished----");
		
	}

	
	
}
