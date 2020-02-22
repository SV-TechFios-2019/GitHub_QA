package test;

import page.LoginPage;
import org.testng.Assert;
import util.BrowserFactory;
import page.QuickDraftPage;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.support.PageFactory;


public class LoginTest {
	        
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
	driver = BrowserFactory.startBrowser();
	} 
	@Test(priority = 1)
	public void validUserShouldBeAbleToLogin() {

	// Take you to the site
	driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

	// Calling LoginPage Class or Activate
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

	// Validate page show up using the title
	String expectedTitle = "Log In ‹ opensourcecms — WordPress"; // To store the actual title
	String actualTitle = loginPage.getPageTitle(); // To get and store the title
	System.out.println(actualTitle); // To print
	Assert.assertEquals(actualTitle, expectedTitle, "Wrong page!");

	// Call the login method from the LoginPage Class
	loginPage.login("opensourcecms", "opensourcecms");

	// Validate page show up using the Explicit Wait
	QuickDraftPage quickDraftPage = PageFactory.initElements(driver, QuickDraftPage.class); // Object Reference
	quickDraftPage.waitForPage();
	}

	@Test(priority = 2)
	public void invalidUserShouldNotBeAbleToLogin() {

	// Take you to the site
	driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

	// Calling LoginPage Class or Activate
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

	// Validate page show up using the title
	String expectedTitle = "Log In ‹ opensourcecms — WordPress"; // To store the actual title
	String actualTitle = loginPage.getPageTitle(); // To get and store the title
	System.out.println(actualTitle); // To print
	Assert.assertEquals(actualTitle, expectedTitle, "Wrong page!");

	// Call the login method from the LoginPage Class - opensourcecms
	loginPage.login("invalidgmail.com", "opensourcecms");     

	// Validate QuickDarftPage did not show up using Explicit Wait try/catch
	QuickDraftPage quickDraftPage = PageFactory.initElements(driver, QuickDraftPage.class); // Object Reference
	Assert.assertFalse(quickDraftPage.isQuickDraftPageDisplayed(), "Invalid User was able to login!!");
	}

	@AfterMethod
	public void close() {
	// close and quit
	driver.close();
	driver.quit();
	}
}	

