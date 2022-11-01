package tests;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.Constants;

public class BaseTests {
	
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeTest
	public void BeforeTest() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+File.separator+"reports"+File.separator+"automationRun.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		extent= new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Rashmi Dandekar");
	}
	
	@BeforeMethod
	public void BeforeMethod(Method testMethod) {
		logger= extent.createTest(testMethod.getName());
		setUpDriver();
		driver.manage().window().maximize();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void AfterMethod() {
		driver.quit();
	}
	
	@AfterTest
	public void AfterTest() {
		extent.flush();
	}
	
	public void setUpDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+ "driver" + File.separator+ "chromedriver.exe");
		driver= new ChromeDriver();
	}
}
