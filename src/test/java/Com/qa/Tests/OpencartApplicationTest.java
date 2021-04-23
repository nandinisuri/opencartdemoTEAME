package Com.qa.Tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.qa.Browser.LoadDriver;
import Com.qa.Pages.ApplyCouponCode;
import Com.qa.Pages.HomePageE;
import Com.qa.Pages.LoginPageE;
import Com.qa.Pages.OrderHistoryPage;
import Com.qa.Pages.PlacementOrderPage;
import Com.qa.Pages.UploadFilePage;
import Com.qa.Pages.UserRegistrationPage;
import Com.qa.Pages.WishListPage;
import Com.qa.TestUtil.ExtentTestManager;

public class OpencartApplicationTest extends LoadDriver{
	  static WebDriver driver;
	    public JavascriptExecutor jse;
	    static WishListPage Wishlist;
		static HomePageE home;
		static LoginPageE login;
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
		login=new LoginPageE(driver);
		home=new HomePageE(driver);
		Applycoupon= new ApplyCouponCode(driver);
		orderhistory=new OrderHistoryPage(driver);
		}
	
	@Test(priority=1)
	public void Register() {
		home.clickMyaccount();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		register.RegisterAccount();
		
		 
		 }
	@Test(priority=2)
	public void Registerunsuccess() {
		home.clickMyaccount();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 register.createAccountWithoutPhone();

	}
	@Test(priority=3)
	public void RegisteredAccount() {
		 home.clickMyaccount();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 register.createAccountWithoutPhone();
		 TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
	}
	 @Test(priority=4)
	 public void Loginpage() throws IOException {
			
			 home.clickMyaccount();
			 home.clickLogin();
			 login=new LoginPageE(driver);
			 
			 login.clickLoginbtn();
			// VerifyTitle
				String actual = driver.getTitle();
				Reporter.log(actual);
				String expected = prop.getProperty("title");
				Reporter.log(expected);
				Assert.assertEquals(actual, expected, "Title matched");
			}
		

		// AddToCart
		@Test(enabled = true, priority = 5)
		public void addToCart() throws InterruptedException {
			home.clickDesktop();
			home.clickMAC();
			home.addtocart();

		}
		// FileUpload
		@Test(enabled = true, priority = 6)
		public void uploadFile() {
			uploadfile.Add_to_cart();
			uploadfile.Avbl_Information();
			home.addtocart();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
		}
		
		// OrderPlacementWithGuest
		@Test(enabled = true, priority = 7)
		public void orderPlacementWithGuest() {
			home.clickMyaccount();
			WebDriverWait logout = new WebDriverWait(driver, 5000);
			logout.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();

			AssertJUnit.assertEquals("Logout Failed", driver.getTitle(), "Account Logout");
			

			orderplace.findProduct();
			orderplace.addToCart();
			orderplace.viewCart();
			orderplace.guestCheckOut();
			//Waits.waitperiod();
			orderplace.billingDetails();
			orderplace.guestBillingDetails();
			orderplace.addDeliveryComment();
			orderplace.confirmOrder();

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}}
		
		
		
		@Test(enabled = true, priority = 7)
		
		public void registerbillingDetails() throws InterruptedException {
			
			orderplace.findProduct();
			orderplace.addToCart();
			orderplace.viewCart();
			orderplace.registerCheckOut();
			//Waits.waitperiod();
			orderplace.billingDetails();
			orderplace.registerBillingDetails();
			orderplace.addDeliveryComment();
			orderplace.registerDelivery();
			orderplace.paymentMethod();
			orderplace.confirmOrder();

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
				return;
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
			

		}		
		// NavigateToHomePage
		@Test(enabled = true, priority =9 )
		public void navigateHome() throws IOException {

			register.ClickMyAccount();
			home.clickLogin();
			
         login=new LoginPageE(driver);
			 
			 login.clickLoginbtn();
			register.editAccount();
			register.navigateToHomePage();
		}


		// productAvailabitlyInCart
		@Test(enabled = true, priority = 10)
		public void productAvailabitlyInCart() {
			home.CheckOutProduct();
			home.clickShoppingcart();
			home.clickRemove();
			orderplace.findProduct();
			orderplace.clickitemcart();
			orderplace.viewCart();
			home.clickShoppingcart();
			home.clickRemove();
			home.clickcontinue();
		}
		@Test(enabled = true, priority = 16)
		public void Orderhistory() {
			home.CheckOutProduct();
			home.clickShoppingcart();
			orderhistory.Order_History();
		}
		// applyCouponCode
		@Test(enabled = true, priority = 11)
		public void applyCouponCode() throws InterruptedException {

			// ActionsClass.actionCode(ap.lapAndNoteProducts);

			uploadfile.Add_to_cart();
			uploadfile.Avbl_Information();
			orderplace.clickitemcart();
			orderplace.viewCart();
			
			home.clickShoppingcart();
			
			 WebElement testDropDown =
			  driver.findElement(By.xpath("//a[text()='Use Coupon Code ']"));
				 testDropDown.click(); 
				 Applycoupon.Apply_Couponcode();
				 Applycoupon.Estimate_Shipping();
				 ; logger.log(Status.INFO,"Selects setTxtcoupon"); 
				
			   home.clickRemove();
		}
			@Test(enabled = true, priority = 12)
			public void emptyCouponCode() throws Exception {

				login.clickLoginbtn();;
				Applycoupon.Empty_Couponcode();
				Applycoupon.Estimate_Shipping();
				Applycoupon.BillingDetails();
				
			}
			// whishList
			@Test(enabled = true, priority = 15)
			public void whishListTest() throws InterruptedException {

				Wishlist.wishlist_method();

			}

			
			}


			
		
		







			
		


