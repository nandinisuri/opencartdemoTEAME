package Com.qa.Pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.qa.Browser.LoadDriver;

public class WishListPage extends LoadDriver{
	WebDriver driver;

	 @FindBy(xpath = "(//a[contains(@class,'dropdown-toggle')])[4]")
	 WebElement components;
	 @FindBy(xpath = "//a[contains(@href,'28')]")
	 WebElement monitors;
	 @FindBy(xpath = "//select[@id='input-sort']")
	 WebElement sortby_dropdown;
	 @FindBy(xpath = "(//i[contains(@class,'fa fa-heart')])[2]")
	 WebElement wishlist_button;
	 @FindBy(xpath = "//span[contains(.,'Wish List (1)')]")
	 WebElement wishlist_icon;
	 @FindBy(xpath = "(//i[contains(@class,'fa fa-shopping-cart')])[3]")
	 WebElement addtocart;
	 Date newdate = new Date();
	 
	 String FileName = newdate.toString().replace(":", "_").replace(" ", "_") + ".png";
	 
	 
	 public WishListPage(){
	 PageFactory.initElements(driver, this);
	 }
	 
	public void wishlist_method() throws InterruptedException{
	 Actions action = new Actions(driver);
	 action.moveToElement(components).click().build().perform();
	 monitors.click();
	
	 Select select = new Select(sortby_dropdown);
     select.selectByVisibleText("Price (High > Low)");
	 wishlist_button.click();
	 Thread.sleep(2000);
	 wishlist_icon.click();
	 addtocart.click();
	 Thread.sleep(2000);
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
	
	

}}
