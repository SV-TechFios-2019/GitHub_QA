package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BasePage {
	
	   public static void waitForElement(WebElement element, WebDriver driver) {
       WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOf(element));
	  }
   }
