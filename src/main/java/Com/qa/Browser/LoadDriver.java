package Com.qa.Browser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadDriver {
	
	    public static WebDriver driver;
		public static Properties prop;
		public  static WebDriverWait wait;
		
	
		public LoadDriver() {
//	Load Properties File 
	        this.driver = driver;

				prop = new Properties();
				FileInputStream file;
				try {
					file = new FileInputStream("E:\\seleniumFiles\\selenium_workspace\\com.qa.Opencarthack\\src\\main\\java\\Com\\qa\\Config\\config.properties");
					prop.load(file);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		public static WebDriver loadBrowser(String browserName) {
			if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
			} else if (browserName.equals("ie")) {
				System.setProperty("webdriver.chrome.driver", "E:\\\\seleniumFiles\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver","E:\\seleniumFiles\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}
		public static WebDriver loadBrowser(String browserName,String URL) {
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "E:\\\\seleniumFiles\\\\Drivers\\\\chromedriver_win32\\\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equals("ie")) {
				System.setProperty("webdriver.gecko.driver","E:\\seleniumFiles\\Drivers\\geckodriver.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver","./softwares\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
		}
//		Open the URL 
		
			public static void openURL(String browsertype){
				
				
				if(browsertype.equals("chrome")) {
					driver =new ChromeDriver();
				}
				if(browsertype.equals("firefox")) {
					driver = new FirefoxDriver();
				}
				
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
	  
			}
			
			
		
		public static WebDriver getDriver(){
			return driver;
		}
		 public static String  takeScreenshot(WebDriver driver) {
	 		TakesScreenshot ts = (TakesScreenshot)driver;
	 		File src = ts.getScreenshotAs(OutputType.FILE);
	 		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	 		File destination = new File(path);
	 		try {
	 			FileUtils.copyFile(src, destination);
	 			return path;
	 		}catch(IOException e) {
	 			e.printStackTrace();
	 			return null;
	 		}}
	}
