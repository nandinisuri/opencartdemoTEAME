package Com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
WebDriver driver;
	

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement myaccount;

	@FindBy(css="#top-links > ul > li.dropdown.open > ul > li:nth-child(2) > a")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	WebElement desktops;
	
	@FindBy(xpath="(//a[text()='Mac (1)'])[1]")
	WebElement Mac;
	@FindBy(xpath = "//img[contains(@src,'1-228x228.jpg')]")
	WebElement iMac;
	@FindBy(xpath = "//button[contains(@id,'button-cart')]")
	WebElement AddToCart1;
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void clickMyaccount() {
		myaccount.click();
	}
	public void clickLogin() {
		loginbtn.click();
	}
	public void clickDesktop() {
		desktops.click();
	}
	public void clickMAC() {
		Mac.click();
	}
	public void addtocart() {
		iMac.click();
		AddToCart1.click();

	}

	
	}


