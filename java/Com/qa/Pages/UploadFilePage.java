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

public class UploadFilePage extends LoadDriver  {
	WebDriver driver;
	
	@FindBy(xpath="//a[text()='Components']")
	WebElement components;
	@FindBy(xpath="//a[text()='Monitors (2)']")
	WebElement monitors;
	@FindBy(xpath="//a[text()='Apple Cinema 30\"']")
	WebElement applecinema;
	@FindBy(xpath="//*[@id=\"input-option223\"]/div[1]/label/input")
	WebElement checkbox;
	@FindBy(xpath="//*[@id=\"input-option208\"]")
	WebElement text;
	@FindBy(xpath="//*[@id=\"input-option217\"]")
	WebElement selectdrpdwn;
	@FindBy(xpath="//*[@id=\"input-option209\"]")
	WebElement textarea;
	@FindBy(xpath="//*[@id=\"button-upload222\"]")
	WebElement uploadfile;
	@FindBy(xpath="//*[@id=\"product\"]/div[7]/div/span/button/i")
	WebElement selectDate;
	@FindBy(xpath="//*[@id=\"product\"]/div[8]/div/span/button/i")
	WebElement selectTime;
	@FindBy(xpath="//*[@id=\"input-quantity\"]")
	WebElement Qty1;
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement Addtocart;
    Date newdate = new Date();
	 
	 String FileName = newdate.toString().replace(":", "_").replace(" ", "_") + ".png";
	 	 
	
	
	public UploadFilePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void Add_to_cart() {
		 
		 Actions action = new Actions(driver);
		 
		  action.moveToElement(components).build().perform();
		  action.click();
		  monitors.click();
		  applecinema.click();
		}
	
public void Avbl_Information() {
		
		checkbox.click();
		text.sendKeys("test");
		Select DROPDOWN = new Select(selectdrpdwn);
		DROPDOWN.selectByVisibleText("Blue (+$3.00)");
		textarea.sendKeys("for testing" );
		selectDate.sendKeys("09252013");
		uploadfile.sendKeys("C:\\Users\\SAILESH\\Desktop\\method-in-java.png");
		

        //Press tab to shift focus to time field
		
		selectTime.sendKeys("0245PM");
		Qty1.sendKeys("2");
		Addtocart.click();
		 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 try {
		 FileUtils.copyFile(screenshot, new File("D:\\Selenium\\Com.qa.OpenCart\\screenshot" + FileName));
		 } catch (IOException e) {
		 }
		 
	}
	

}
