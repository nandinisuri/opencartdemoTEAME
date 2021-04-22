package Com.qa.Tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Com.qa.Browser.LoadDriver;
import Com.qa.Pages.ApplyCouponCode;
import Com.qa.Pages.HomePage;
import Com.qa.Pages.LoginPage;
import Com.qa.Pages.OrderHistoryPage;
import Com.qa.Pages.PlacementOrderPage;
import Com.qa.Pages.UploadFilePage;
import Com.qa.Pages.UserRegistrationPage;
import Com.qa.Pages.WishListPage;

public class UserRegisterTest extends LoadDriver{
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
		 driver = LoadDriver.loadBrowser("chrome", "https://demo.opencart.com/index.php?route=account/register");	
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		register= new UserRegistrationPage(driver);
		uploadfile = new UploadFilePage(driver);
		orderplace  = new PlacementOrderPage(driver);
		login=new LoginPage(driver);
		}
	
	@Test(priority=1)
	public void Register() {
		home.clickMyaccount();
		register.RegisterAccount();
	}
}
