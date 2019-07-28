package com.hybridprofinal.commonutility;

import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hybridprofinal.initiate.Base;


public class Interaction extends Base
{

    //public WebDriver driver;
	String pageLoadStatus = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;  
    public Interaction(WebDriver driver)
    {
        this.driver = driver;
    }
	
    public void  WaitTime(int seconds) throws InterruptedException {
		try {
			seconds = seconds * 1000;
		}
		catch (Exception e) {
			seconds = 1000;
		}
		Thread.sleep(seconds);
	}


	public void  WaitForPageToLoad() {
		pageLoadStatus = (String)js.executeScript("return document.readyState");
	}



	public void  GoToURL(String url) {
		driver.navigate().to(url);
	}
	
	public String GetTitle()
	{
		return driver.getTitle();
	}

	public void  Back() {
		driver.navigate().back();
	}


	public void  Refresh() {
		driver.navigate().refresh();
	}



	public String  GetCurrentURL() {
		return driver.getCurrentUrl();
	}


	public void  Type(By by, String value) {
		WaitVisible(by);
		driver.findElement(by).sendKeys(value);
	}


	public void  Type(By by, String value, int waittimeinsecs) throws InterruptedException {
		WaitVisible(by);
		driver.findElement(by).sendKeys(value);
	}


	public void  Clear(By by) {
		WaitVisible(by);
		driver.findElement(by).clear();
	}



	public void  Clear(By by, int waittimeinsecs) {
		WaitVisible(by);
		driver.findElement(by).clear();
	}


	public void  TypeClear(By by, String value,WebDriver driver) {
		WaitVisible(by);
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(value);
	}


	public void  ScrollBy(int scroll) {
		js.executeScript("window.scrollBy(0,1000)");
	}



	public void  ScrollToViewElement(By by) {
		WaitVisible(by);
		WebElement element = driver.findElement(by);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}


	//Scroll up to element to be visible
	public void  ScrollToViewElement(WebElement element)
	{
		WaitVisible(element);
		js.executeScript("arguments[0].scrolSlIntoView(true);", element);
	}


	//Scroll upto element to be visible
	public void  ScrollToViewelement(By by)
	{
		WaitVisible(by);
		js.executeScript("arguments[0].scrolSlIntoView(true);", by);
	}


	//Scroll to bottom of page
	public void  ScrollToBottomOfPage()
	{
		js.executeScript("window.scrollTo(0, document.body.clientHeight);");
	}


	//Scroll to top of page
	public void  ScrollToTopOgPage()
	{
		js.executeScript("window.scrollTo(0, 0)");
	}



	//Get single element
	public  WebElement GetElement(By by)
	{
		WaitVisible(by);
		return driver.findElement(by);
	}


	//Get single element
	public  WebElement GetElement(By by, int waittimeinsecs)
	{
		WaitVisible(by);
		return driver.findElement(by);
	}


	//Get Multiple elements
	public  List<WebElement> GetElements(By by)
	{
		WaitVisible(by);
		return  driver.findElements(by);
	}


	//Check element is displayed or not
	public  boolean IsElementDisplayed(By by) throws Exception
	{
		try
		{
			WaitVisible(by);
			boolean displayed = driver.findElement(by).isDisplayed();
			return displayed;
		}
		catch(Exception e)
		{
			throw new Exception("ELEMENTNOTDISPLAYED");
		}
	}


	// Element is enabled or not
	public  boolean IsElementEnabled(By by) throws Exception
	{
		try
		{
			WaitVisible(by);
			boolean enabled = driver.findElement(by).isEnabled();
			return enabled;
		}
		catch(Exception e)
		{
			throw new Exception("ELEMENTNOTENABLED");
		}
	}


	//Element is selected or not
	public  boolean IsElementSelected(By by) throws Exception
	{
		try
		{
			WaitVisible(by);
			boolean selected = driver.findElement(by).isSelected();
			return selected;
		}
		catch(Exception e)
		{
			throw new Exception("ELEMENTNOTSELECTED");
		}
	}


	public void  WaitVisible(By by)
	{

		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}




	public void  WaitVisible(By by,int timeinsec)
	{
		WaitVisible(by);
		WebDriverWait wait = new WebDriverWait(driver, timeinsec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}



	public void  WaitVisible(WebElement element)
	{
		WaitVisible(element);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}



	public void  WaitVisible(WebElement element,int timeinsec)
	{
		WaitVisible(element);
		WebDriverWait wait = new WebDriverWait(driver, timeinsec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}



	public void  WaitExist(By by)
	{
		WaitVisible(by);
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}



	public void  WaitExistsForMultipleElements(By by)
	{
		WaitVisible(by);
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}


	public void  WaitExistsForNestedElements(By by,By nestedlocator)
	{
		WaitVisible(by);
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(by, nestedlocator));
	}



	public void  WaitExistsForNestedElements(WebElement element,By subelement)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(subelement, subelement));
	}



	public void  WaitTillNotVisible(By by,int timeinsec)
	{
		boolean stillExists = true;
		while (stillExists)
		{
			try
			{
				WaitVisible(by,timeinsec);
			}
			catch(Exception e)
			{
				stillExists = false;
			}
		}
	}



	public  WebElement WaitUntilElementClickable(WebElement element)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,300);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element : '" + element + "' was not found in current context page.");
			throw e;
		}
	}



	public void  WaitUntilElementClickable(By by)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,300);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		}
		catch (NoSuchElementException e)
		{
			System.out.println("Element : '" + by + "' was not found in current context page.");
			throw e;
		}
	}



	public  boolean WaitUntilStalenessOfElement(WebElement element, int timeinsec)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,300);
			return wait.until(ExpectedConditions.stalenessOf(element));
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element is still not attached to current DOM");
			return false;
		}
	}


	/*Click*/
	public void  Click(By by)
	{
		WaitVisible(by);
		driver.findElement(by).click();
	}


	public void  ClickAndWait(By by,int timeinsec) throws InterruptedException
	{
		WaitTime(timeinsec);
		driver.findElement(by).click();
	}


	public void  DoubleClick(By by) throws InterruptedException
	{
		WebElement element = driver.findElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.doubleClick();
		action.build().perform();
		WaitTime(4);
	}


	public void  JsClick(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,300);
		js.executeScript( "arguments[0].click();", element );
	}



	/*Alert Handler*/
	public  boolean AcceptAlert()
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
			System.out.println("Alert Was Present");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("No Alert Found");
			return false;
		}
	}


	public  boolean DismissAlert()
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			System.out.println("Alert Was Present");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("No Alert Found");
			return false;
		}
	}


	public  String GetAlertText()
	{
		try
		{
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println("Alert Was Present");
			return text;
		}
		catch(Exception e)
		{
			System.out.println("No Alert Found");
			return null;
		}
	}


	public void MouseHoverOnElement(By by)
	{
		WebElement elementToHover = driver.findElement(by);
		Actions hover = new Actions(driver);
		hover.moveToElement(elementToHover);
		hover.perform();
	}



	public void MouseHoverAndClick(By by)
	{
		WaitVisible(by);
		WebElement elementToHover = driver.findElement(by);
		Actions hover = new Actions(driver);
		hover.moveToElement(elementToHover).click().perform();

	}



	public void MouserHoverAndClick(By hoverby, By clickby)
	{
		WaitVisible(hoverby);
		WebElement elementToHover = driver.findElement(hoverby);
		Actions hover = new Actions(driver);
		hover.moveToElement(elementToHover).perform();
		WebElement elementToClick = driver.findElement(clickby);
		hover.moveToElement(elementToClick).click().perform();

	}





	public void SelectByText(By by, String text)
	{
		WaitVisible(by);
		WebElement elementToHover = driver.findElement(by);
		Select select = new Select(elementToHover);
		select.selectByVisibleText(text);

	}



	//Select By Value from Drop down
	public void SelectByValue(By by, String value)
	{
		WaitVisible(by);
		WebElement elementToHover = driver.findElement(by);
		Select select = new Select(elementToHover);
		select.selectByVisibleText(value);
	}



	//Select by Index from drop down
	public void SelectByIndex(By by, int index)
	{
		WaitVisible(by);
		WebElement elementToHover = driver.findElement(by);
		Select select = new Select(elementToHover);
		select.selectByIndex(index);
	}

	public void Enter(By by)
	{
		driver.findElement(by).sendKeys(Keys.ENTER);
	}

	public void GetText(By by)
	{
		driver.findElement(by).getText();
	}

	public String GenerateRandonString(String text)
	{
		LocalTime currenttime = LocalTime.now();
		String newcategoryname = text + currenttime;

		return newcategoryname;
	}
    
    

}
