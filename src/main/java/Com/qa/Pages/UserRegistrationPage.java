package Com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Com.qa.Browser.LoadDriver;



public class UserRegistrationPage extends LoadDriver {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement myaccount;
	@FindBy(xpath = "//a[text()='Register']")
	WebElement register;
	@FindBy(xpath = "//*[@id=\"input-firstname\"]")
	WebElement first;
	@FindBy(xpath = "//*[@id=\"input-lastname\"]")
	WebElement last;
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement mail;
	@FindBy(xpath = "//*[@id=\"input-telephone\"]")
	WebElement phonenumber;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement Password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmPswd;
	@FindBy(xpath = "//input[@value=1 and @name='newsletter']")
	WebElement subscribed;
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement privacyPolicee;
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement continueButton;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueButton2;
	@FindBy(xpath = "//div[@class='col-sm-10']/div[@class='text-danger']")
	WebElement errorMsgd;
	@FindBy(xpath = "//a[text()='Edit Account']")
	WebElement lnkeditAccountt;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msgRead;

	// Elements for logout

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement lnklogOut;

	public UserRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public void ClickMyAccount() {
		 
		  myaccount. click();
		  register.click();

	}

	public void RegisterAccount() {

		//Waits.waitperiod();

		first.sendKeys("nandini");
		last.sendKeys("suri");
		mail.sendKeys(prop.getProperty("Email"));
		phonenumber.sendKeys("9494220178");
		Password.sendKeys(prop.getProperty("Password"));
		confirmPswd.sendKeys("Mahika@124");
		subscribed.click();
		privacyPolicee.click();
		continueButton.click();
		//continueButton2.click();
	}

	public void createAccountWithoutPhone() {

		//Waits.waitperiod();

		first.sendKeys(prop.getProperty("FirstName"));
		last.sendKeys(prop.getProperty("LastName"));
		//mail.sendKeys(prop.getProperty("Email"));
		// phone.sendKeys(prop.getProperty("Phone"));

		Password.sendKeys(prop.getProperty("Password"));
		confirmPswd.sendKeys(prop.getProperty("Password"));
		subscribed.click();
		privacyPolicee.click();
		continueButton.click();
		// continueBtn2.click();
		String error = errorMsgd.getText();
		Reporter.log(error);
		System.out.println(error);

	}

	public void editAccount() {
		lnkeditAccountt.click();
		last.clear();
		last.sendKeys(prop.getProperty("LastNameedit"));
		btncontinue.click();
		String actual = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText", msgRead)
				.toString();
		System.out.println(actual + "----actual msg");
		String expected = prop.getProperty("Successmsg");
		

	}

	public void navigateToHomePage() {
       // Waits.waitperiod();
        driver.navigate().to(prop.getProperty("url"));
    }
	

}



