package servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import classroom.WDTest;

public class DeleteIncident extends WDTest {
	@Test()
	public void deleteIncident() {
		/*
		 * This test case resolves an incident
		 * @pre-condition = Incident number
		 * 
		 */	

		//Launch the application
		openBrowser("https://dev68676.service-now.com/");

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		//Login
		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys("Qarc@2019");
		driver.findElement(By.id("sysverb_login")).click();

		//Verify login is successful
		boolean isLoginSucceeded = driver.findElement(By.xpath("//span[text()='System Administrator']")).isDisplayed();
		if(isLoginSucceeded) {
			System.out.println("Login Sucessful");
		}else {
			System.out.println("Login failed");
		}

		//Search the keyword 'incident'
		driver.findElement(By.id("filter")).click();
		driver.findElement(By.id("filter")).sendKeys("Incident");

		//Click on incident
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("ServiceDesk")));

		driver.findElement(By.xpath("(//*[text()='Incidents'])[2]")).click();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_hide_search']//input[@placeholder='Search']"))
		.sendKeys("INC0010125", Keys.ENTER);

		driver.close();

	}

}
