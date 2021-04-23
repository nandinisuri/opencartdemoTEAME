package Com.qa.Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.qa.Browser.LoadDriver;



public class OrderHistoryPage extends LoadDriver {
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement MyAccount;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement orderhistory;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	WebElement Continue;
	public OrderHistoryPage(WebDriver driver) throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
public void Order_History() {
	MyAccount.click();
	orderhistory.click();
	Continue.click();

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
	
	
	

}
