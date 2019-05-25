package classroom;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WDTest {
	public RemoteWebDriver driver;
	public void openBrowser(String URL) {
		//Invoke the browser
		WebDriverManager.chromedriver().version("74.0.3729.6").setup();
		//WebDriverManager.version().chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//Search for a product
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

	}

	/*
	 * Switch to a child window
	 */

	public void switchToChildWindow() {
		Set<String> windowHandles =driver.getWindowHandles();
		int i=0;
		for (String winHandle : windowHandles) {
			if(i==1) {
				driver.switchTo().window(winHandle);
				break;
			}
			i++;
		}
	}

	/*
	 * Select dropdown value based on visible text
	 */

	public void selectByVisibleOption(WebElement dropdown, String visibleText) {
		Select dp = new Select(dropdown);
		dp.selectByVisibleText(visibleText);
	}


	/*
	 * Write the output to a property file
	 */

	public void writeToPropertyFile(String IncidentNum) {
		Properties prop = new Properties();
		prop.setProperty("Incident", IncidentNum);
		
		//Store the value
		try {
			FileOutputStream fos = new FileOutputStream("./src/test/resources/output.properties");
			prop.store(fos, "The incident number is stored");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

// Read from a property file
	
	public String readPropertyFile(String key) {
		Properties prop = new Properties();
		String IncidentNum = null;
		try {
			prop.load(new FileInputStream("./src/test/resources/output.properties"));
			IncidentNum = prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return IncidentNum;
		
	}


}
