package handlingShadowDom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Handling Shadow-DOM
		String jsPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")";
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement pizzaName = (WebElement)js.executeScript(jsPath);
		pizzaName.sendKeys("Margherita pizza");
		Thread.sleep(1000);
		driver.quit();
	}

}
