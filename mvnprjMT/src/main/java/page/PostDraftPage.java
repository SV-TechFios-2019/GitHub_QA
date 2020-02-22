package page;

import page.BasePage;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;




public class PostDraftPage extends BasePage {
	WebDriver driver;
	
	public PostDraftPage(WebDriver driver) {
    this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='wpwrap']/descendant::div[text()='Posts']")
	WebElement Posts;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),\"All Posts\")]")
	WebElement AllPosts;
    @FindBy(how = How.XPATH, using = "//input[@type=\"submit\"]")
    List<WebElement> PostList;
      
     //System.out.println(manageaccount.get(0).getText());
 
     public void GotoPosts() {
     Actions action = new Actions(driver);
     action.moveToElement(Posts).build().perform();
     Posts.click();
     }
     public void waitForPage() {
    	   waitForElement(Posts, driver);
    	   }
    	   public void HoverOverPosts() {
    	   Actions action = new Actions(driver);
    	   action.moveToElement(Posts).build().perform();
    	   AllPosts.click();
    	   }
    	   public boolean isPostsDisplayed() {
    	   try {
    	   waitForPage();
    	   return true;
    	   } catch (Exception e) {
    	 }
    	 return false;
    	 }
        }  

