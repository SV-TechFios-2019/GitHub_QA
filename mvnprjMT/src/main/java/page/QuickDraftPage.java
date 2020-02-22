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

	@FindBy(how = How.XPATH, using = "//span[text() ='Quick Draft']")
	WebElement QuickDraftPage;
	@FindBy(how = How.ID, using = "title")
	WebElement TitleField;
	@FindBy(how = How.ID, using = "content")
	WebElement ContentField;
	@FindBy(how = How.ID, using = "savedraft")
	WebElement SaveDraftButton;
    	    

	  //Methods to interact with the elements
	  public void waitForPage() {
	       waitForElement(QuickDraftPage, driver);
	   }
	  public void fillinQuickDraftPageForm(String title, String content) {
		  QuickDraftPage.click();
		  TitleField.sendKeys(title);
		  ContentField.sendKeys(content);
		  SaveDraftButton.click();
	   }
	   public void inputTitleAndContent(String eTitle, String eContent) {
		   TitleField.sendKeys(eTitle);
		     ContentField.sendKeys(eContent);
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
	 

