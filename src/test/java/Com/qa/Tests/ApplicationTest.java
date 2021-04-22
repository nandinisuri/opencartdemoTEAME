package Com.qa.Tests;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.qa.Browser.LoadDriver;
import Com.qa.Pages.ApplyCouponCode;
import Com.qa.Pages.HomePage;
import Com.qa.Pages.LoginPage;
import Com.qa.Pages.OrderHistoryPage;
import Com.qa.Pages.PlacementOrderPage;
import Com.qa.Pages.UploadFilePage;
import Com.qa.Pages.UserRegistrationPage;
import Com.qa.Pages.WishListPage;

public class ApplicationTest  {
    static WebDriver driver;
    public JavascriptExecutor jse;
    static WishListPage Wishlist;
	static HomePage home;
	static LoginPage login;
	static ApplyCouponCode Applycoupon;
	static OrderHistoryPage orderhistory;
	static PlacementOrderPage orderplace;
	static UploadFilePage uploadfile;
	static UserRegistrationPage register;
	static ExtentReports extent=new ExtentReports();
	static ExtentTest logger;
	
	@Parameters({ "browser" })
	@BeforeClass
	public static void launchBrowser() throws IOException{    	
		 driver = LoadDriver.loadBrowser("chrome", "http://demo.opencart.com/");	
		 driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		register= new UserRegistrationPage(driver);
		uploadfile = new UploadFilePage(driver);
		orderplace  = new PlacementOrderPage(driver);
		login=new LoginPage(driver);
		}
	@BeforeMethod
	public void setup(Method method) {
    	logger=extent.createTest(method.getName());
	}
	
	@AfterMethod
	public void checkStatus(ITestResult result) {
		
			if(result.getStatus()== ITestResult.FAILURE) {
				TakesScreenshot ts = (TakesScreenshot)driver;
		 		File src = ts.getScreenshotAs(OutputType.FILE);
			
		 		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		 		File destination = new File(path);
			
		 		try {
		 			FileUtils.copyFile(src, destination);
		 			return;
		 		}catch(IOException e) {
		 			e.printStackTrace();
		 			return;
		 		}
			}
		extent.flush();
	}
	
	
		
	@Test(priority=1)
	public void login() throws IOException{
		home.clickMyaccount();
		home.clickLogin();
		
		 login = new LoginPage(driver);

		      login.clickLogin();
	}

		

		
		 
	}

