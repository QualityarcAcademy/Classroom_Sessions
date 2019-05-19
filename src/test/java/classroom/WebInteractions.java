package classroom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebInteractions extends WDTest {

	@Test
	public void webInteractions() throws IOException {
		openBrowser("http://the-internet.herokuapp.com/upload");


//		/*
//		 * Handle Dropdown 
//		 * //select[@id='dropdown']
//		 */
		WebElement dropdownEle = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select dp = new Select(dropdownEle);
		dp.selectByVisibleText("Option 1");
		List<WebElement> listOfDropdownVals = dp.getOptions();

		for (WebElement webElement : listOfDropdownVals) {
			System.out.println(webElement.getText());

		}
//
//
//		/*
//		 * Checkbox
//		 */
		driver.findElement(By.xpath("//form[@id='checkboxes']/*[1]")).click();
		boolean checkboxSelected = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).isSelected();
		System.out.println(checkboxSelected);
//
//		/*
//		 * Handle browser windows
//		 */
		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.linkText("Elemental Selenium")).click();
//
//		//Switching to a new window
		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			String title = driver.switchTo().window(window).getTitle();
			if(title.equals("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro")) {
				String headerText = driver.findElement(By.tagName("h2")).getText();
				System.out.println(headerText);
			}


		}
//
//		/*
//		 * Alerts
//		 * 
//		 * 
//		 */
//
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		driver.switchTo().alert().sendKeys("Test Alert");
		driver.switchTo().alert().accept();
//
//		/*
//		 * Frames
//		 * 
//		 */
				driver.switchTo().frame("mce_0_ifr");
				driver.findElement(By.id("tinymce")).sendKeys("Im iframe");

		/*
		 * Taking screenshot
		 */

				String screenshot = driver.getScreenshotAs(OutputType.BASE64);
				FileWriter file = new FileWriter("C:\\Users\\Local User\\Desktop\\data\\test");
				file.write(screenshot);
				file.close();
				//file.flush();
				
//				File screenshot = driver.getScreenshotAs(OutputType.FILE);
//				FileUtils.copyFile(screenshot, new File("./Screenshot/screeshotpg.png"));


		/*
		 * File upload
		 */
		driver.findElement(By.id("file-upload")).click();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Local User\\eclipse-workspace\\training.class\\Screenshot\\screeshotpg.png");


		//driver.close();
	}

}
