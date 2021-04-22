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
	WebDriver driver;
	@FindBy(xpath = "(//a[text()='Order History'])[3]")
	WebElement orderHistory;
	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement view;

	public OrderHistoryPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void orderHistoryView() throws Exception {
		
		orderHistory.click();
		view.click();
		TakesScreenshot ts = (TakesScreenshot)driver;
 		File src = ts.getScreenshotAs(OutputType.FILE);
 		String path = System.getProperty("user.dir")+"\"E:\\\\JavaPractice\\\\OpenCartRepo\\\\screenshot\", \"ViewOrder\"";
 		File destination = new File(path);
 		try {
 			FileUtils.copyFile(src, destination);
 			return;
 		}catch(IOException e) {
 			e.printStackTrace();
 			return;
 		}}
	
	
	
	

}
