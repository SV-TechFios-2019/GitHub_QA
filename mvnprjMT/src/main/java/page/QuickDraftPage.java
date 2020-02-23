package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.NoSuchElementException;

public class QuickDraftPage extends BasePage {

	WebDriver driver;
	
	public QuickDraftPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//label[@for='title']")
	WebElement QuickDraftPage;
	@FindBy(how = How.XPATH, using = "//label[@for='title']")
	WebElement Title;
	@FindBy(how = How.ID, using = "content")
	WebElement Content;
	@FindBy(how = How.ID, using = "save-post")
	WebElement SaveDraftButton;
    	    

	  //Methods to interact with the elements
	  public void waitForPage() {
	       waitForElement(QuickDraftPage, driver);
	   }
	  public void fillinQuickDraftPageForm(String title, String content) {
		  QuickDraftPage.click();
		  Title.sendKeys(title);
		  Content.sendKeys(content);
		  SaveDraftButton.click();
	   }
	   public void inputTitleAndContent(String eTitle, String eContent) {
		   Title.sendKeys(eTitle);
		     Content.sendKeys(eContent);
	   }	          
	   public void clickOnSubmitButton() {
		   SaveDraftButton.click();
	  }   	   
	  public boolean isQuickDraftPageDisplayed() {
	         try {
	         waitForPage();
	         return true;
	         } catch (NoSuchElementException e) {
	         return false;
	         }
	     }
     }
	 

