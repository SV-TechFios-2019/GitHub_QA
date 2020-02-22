package test;

import page.LoginPage;
import java.util.Random;
import page.QuickDraftPage;
import util.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidatePostTest {
	
	@Test
	public void AddTextToVerifyTextPosted() throws InterruptedException {
		//Start the browser and saves the driver in test class
		WebDriver driver = BrowserFactory.startBrowser();
		//Take you to the site
		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");		
		//Calling LoginPage Class or Activate  
		//PageFactory.initElement(driver, LoginPage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);		
		//calling the method inside LoginPage
		loginPage.login("opensourcecms", "opensourcecms");		
		//Activate the PostDr
		QuickDraftPage quickDraftPage = PageFactory.initElements(driver, QuickDraftPage.class);
		//call methods inside QuickDraft Page
		quickDraftPage.waitForPage();	
		//Activate Quick DraftPage
		quickDraftPage.waitForPage();	
		//A method to input a random information into QuickDraft
		quickDraftPage.fillinQuickDraftPageForm("Automation World 2222020", "Selenium with Java 2222020");
        Thread.sleep(4000);
        //Initiate Random Class
        Random random = new Random();    
        //Storage for Title and Content  
        String eTitle = "TestTitle"  + String.valueOf(random.nextInt(999));
        String eContent = String.valueOf(random.nextInt(99999));   
        //Method to input title and content
        quickDraftPage.inputTitleAndContent(eTitle, eContent);
        //click on submit button
        quickDraftPage.clickOnSubmitButton();     
        //Explicit wait validation
        quickDraftPage.waitForPage(); 
        //Assertion class to validate using assertTrue
        //Assert.assertEquals(actual, expected);("Success Message did not show!", quickDraftPage.isQuickDraftPageDisplayed());       
        //Assertion class to validate using assertEquals
        Assert.assertEquals("Success Message did not show!", eTitle, eContent);    	
        Thread.sleep(10000);		
	    
        driver.close(); 
		driver.quit();
	}

   }