package Com.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePageE {
	
WebDriver driver;
	

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	WebElement myaccount;

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	WebElement desktops;
	
	@FindBy(xpath="(//a[text()='Mac (1)'])[1]")
	WebElement Mac;
	@FindBy(xpath = "//img[contains(@src,'1-228x228.jpg')]")
	WebElement iMac;
	@FindBy(xpath = "//button[contains(@id,'button-cart')]")
	WebElement AddToCart1;
	@FindBy(xpath = "//*[@id=\"search\"]/input")

	WebElement SearchBox;
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	WebElement SearchButton;
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]/span")
	WebElement AddtoCart;
	@FindBy(xpath="//*[@id=\"cart-total\"]")
	WebElement Cart;
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
	WebElement CheckOut;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")
	WebElement QuntityBox;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]/i")
	WebElement Refresh;
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement CheckOutOption;
	 @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a/span")
	 WebElement ShoppingCart1;
	    @FindBy(xpath="//*[@id=\"accordion\"]/div[2]/div[1]/h4/a")
	    WebElement E_SandT;
	    @FindBy(id="input-country")
	    WebElement SelectCountry;
	    @FindBy(id="input-zone")
	    WebElement SelectState;
	    @FindBy(xpath="//*[@id=\"input-postcode\"]")
	    WebElement PostCode;
	    @FindBy(xpath="//*[@id=\"button-quote\"]")
	    WebElement Quote;
	    @FindBy(xpath="//*[@id=\"modal-shipping\"]/div/div/div[2]/div/label/input")
	    WebElement SelectFlat;
	    @FindBy(xpath="//*[@id=\"button-shipping\"]")
	    WebElement ApplyShipping;
	    @FindBy(xpath="//span[text()='Shopping Cart']")
		WebElement Shoppingcart;
		@FindBy(xpath="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]/i")
		WebElement remove;
		@FindBy(xpath="//a[text()='Continue']")
		WebElement Continuer;
	
	public HomePageE(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void clickShoppingcart() {
		Shoppingcart.click();
	}
	public void clickRemove() {
		remove.click();
	}
	public void clickcontinue() {
		Continuer.click();
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
	public void CheckOutProduct() {
		SearchBox.sendKeys("iphone");
		SearchButton.click();
		AddtoCart.click();
		Cart.click();
		CheckOut.click();
		QuntityBox.sendKeys("2");
		Refresh.click();
		CheckOutOption.click();

		
	}
	public void E_shipping() {
        ShoppingCart1.click();
        E_SandT.click();
        Select COUNTRY = new Select(SelectCountry);
        COUNTRY.selectByVisibleText("India");
        Select STATE = new Select(SelectState);
        STATE.selectByVisibleText("Andhra Pradesh");
        PostCode.sendKeys("516002");
        Quote.click();
        SelectFlat.click();
        ApplyShipping.click();
	}

	
	}


