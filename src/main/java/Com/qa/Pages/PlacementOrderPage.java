package Com.qa.Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Com.qa.Browser.LoadDriver;

public class PlacementOrderPage extends LoadDriver {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
	WebElement LaptopsandNotebookss;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
	WebElement ShowLaptopsandNotebookss;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[4]/div[1]/div/div[2]/div[1]/h4/a")
	WebElement HP_LP3065c;
	@FindBy(id = "input-option225")
	WebElement date;

	@FindBy(id = "button-cart")
	WebElement addToCart;
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement item_cart;
	@FindBy(id = "cart")
	WebElement viewCart;

	@FindBy(xpath = "//a[@href='https://demo.opencart.com/index.php?route=checkout/checkout']")
	WebElement btnCheckOut;
	@FindBy(xpath="//input[@value='guest']")
	WebElement Guestcheckout;
	@FindBy(id="button-account")
	WebElement GuestContinue;
	@FindBy(xpath = "//a[@class='panel-title' and text()='Step 1: Checkout Options']")
	WebElement checkOutOptions;

	@FindBy(name = "firstname")
	WebElement firstName;

	@FindBy(name = "lastname")
	WebElement lastName;
	@FindBy(id = "input-payment-telephone")
	WebElement phone;
	@FindBy(id = "input-payment-email")
	WebElement email;
	@FindBy(id = "input-payment-password")
	WebElement paymentPswd;
	@FindBy(id = "input-payment-confirm")
	WebElement paymentConfirmPswd;
	@FindBy(name = "address_1")
	WebElement address;
	@FindBy(name = "city")
	WebElement city;
	@FindBy(name = "postcode")
	WebElement postcode;
	@FindBy(id = "input-payment-zone")
	WebElement region;
	@FindBy(id = "input-payment-country")
	WebElement country;
	@FindBy(id = "button-guest")
	WebElement btncontinue;
	@FindBy(xpath = "//input[@value='guest']")
	WebElement rdoguestCheckout;
	@FindBy(xpath = "//input[@value='register']")
	WebElement rdoregisterCheckout;
	@FindBy(id = "button-account")
	WebElement btncheckoutContinue;
	@FindBy(name = "comment")
	WebElement deliveryComment;
	@FindBy(id = "button-shipping-method")
	WebElement btndeliveryContinue;
	@FindBy(id = "button-payment-method")
	WebElement btndeliveryContinueafter;
	@FindBy(id = "button-shipping-address")
	WebElement btnregisterDeliverContinue;
	@FindBy(name = "agree")
	WebElement agreeTerms;
	@FindBy(id = "button-confirm")
	WebElement btnconfirmOrder;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement continueorder;
	@FindBy(xpath = "//input[@name='agree' and @value='1']")
	WebElement registerBillingCheckbox;
	@FindBy(xpath = "//*[@id=\"button-register\"]")
	WebElement btnregisterBillingContinue;
	@FindBy(id = "button-payment-method")
	WebElement btnpaymentContinue;

	public PlacementOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void findProduct() {

		LaptopsandNotebookss.click();
		ShowLaptopsandNotebookss.click();
		
		 HP_LP3065c.click();
		//Waits.waitperiod();
		// ScrollPage.scrollPagedown();
		date.clear();
		date.sendKeys("2021-04-23");
	}

	public void addToCart() {
		addToCart.click();
	}
	public void clickitemcart() {
		item_cart.click();
	}

	public void viewCart() {
		viewCart.click();
		btnCheckOut.click();
	}

	public void guestCheckOut() {
		btnCheckOut.click();
		Guestcheckout.click();
		GuestContinue.click();

	}

	public void registerCheckOut() {

		btnCheckOut.click();
		rdoregisterCheckout.click();
		btncheckoutContinue.click();

	}

	public void billingDetails() {

		firstName.sendKeys(prop.getProperty("FirstName"));
		lastName.sendKeys(prop.getProperty("LastName"));
		email.sendKeys(prop.getProperty("Emailnew"));
		phone.sendKeys(prop.getProperty("Phone"));
		address.sendKeys(prop.getProperty("Address"));
		city.sendKeys(prop.getProperty("City"));
		postcode.sendKeys(prop.getProperty("PostalCode"));
		Select country1 = new Select(country);
		country1.selectByVisibleText(prop.getProperty("Country"));
		
		// ScrollPage.scrollPagedown();
		Select state = new Select(region);
		state.selectByVisibleText(prop.getProperty("Region/State"));

	}

	public void guestBillingDetails() {
		btncontinue.click();
	}

	public void registerBillingDetails() {
		paymentPswd.sendKeys(prop.getProperty("Password"));
		paymentConfirmPswd.sendKeys(prop.getProperty("CPassword"));

		registerBillingCheckbox.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click();", btnregisterBillingContinue);
		btnregisterBillingContinue.click();

	}

	public void addDeliveryComment() {
		deliveryComment.sendKeys(prop.getProperty("DeliveryComment"));
		btndeliveryContinue.click();
		agreeTerms.click();
		btndeliveryContinueafter.click();
	}

	public void registerDelivery() {

		btnregisterDeliverContinue.click();

	}

	public void paymentMethod() {

		deliveryComment.sendKeys(prop.getProperty("DeliveryComment"));
		registerBillingCheckbox.click();
		btnpaymentContinue.click();
	}

	public void confirmOrder() {
		btnconfirmOrder.click();
		continueorder.click();
	}
	

}


