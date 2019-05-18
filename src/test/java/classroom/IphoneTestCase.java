package classroom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IphoneTestCase extends WDTest {

	@Test
	public void firstTest() {
		openBrowser("https://www.amazon.com");

		//Search and click iPhone
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);

		//Get the products from first page

		List<WebElement> phonelist = driver.findElements(By.tagName("h2"));
		System.out.println(phonelist.size());

		//Print all the products

		int i = 1;
		for (WebElement webElement : phonelist) {
			String phoneName = webElement.getText();
			System.out.println(i+". "+phoneName);
			i++;

			if(phoneName.contains("Apple iPhone 8")) {
				webElement.click();
				break;
			}

		}

		//Get the price
		String dollarVal = driver.findElement(By.id("priceblock_ourprice")).getText();
		System.out.println(dollarVal);
		
		//Remove the dollar sign
		String replacedStr = dollarVal.replace("$", "");
		System.out.println("Replaced string "+replacedStr);
		
		//Substring
		String subStrVal = dollarVal.substring(1);
		System.out.println("The substring val is "+subStrVal);
		
		//Split
		String[] dollarStrigArr = dollarVal.split("\\$");
		System.out.println(dollarStrigArr.length);
		System.out.println(dollarStrigArr[1]);
		
		
		//Convert a string to float
		float dollarFloat = Float.parseFloat(subStrVal);
		float increament = dollarFloat +10;
		
		System.out.println("The increased val is "+increament);
		driver.close();

	}

}
