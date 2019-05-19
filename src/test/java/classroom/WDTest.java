package classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WDTest {
	RemoteWebDriver driver;
	public void openBrowser(String URL) {
	//Invoke the browser
		WebDriverManager.chromedriver().version("74.0.3729.6").setup();
		//WebDriverManager.version().chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Search for a product
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
	

	}

}
