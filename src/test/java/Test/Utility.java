package Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {

	public static WebDriver driver;

	public static void LaunchApp(String url) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void clickElement(WebElement element) {
		try {

			element.click();
		} catch (Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);

		}

	}

	public static void typeText(WebElement element, String text) {
		try {element.sendKeys(text);}
		catch(Exception e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value',"+text+");", element);
			
		}

	}

	public static void selectDropDownvalue(WebElement element, int index) {

		Select s = new Select(element);
		s.selectByIndex(index);

	}

	public static void back() {
		driver.navigate().back();

	}

	public static void closeApp() {
		driver.quit();

	}
	
	public static  void uploadafile(String filedir) throws AWTException, InterruptedException {
		
		StringSelection ss=new StringSelection(filedir);
		
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  
		  Thread.sleep(7000);
		  Robot rb=new Robot();
		     // press Contol+V for pasting
		     rb.keyPress(KeyEvent.VK_CONTROL);
		     rb.keyPress(KeyEvent.VK_V);
		 
		    // release Contol+V for pasting
		    rb.keyRelease(KeyEvent.VK_CONTROL);
		    rb.keyRelease(KeyEvent.VK_V);
		 
		    // for pressing and releasing Enter
		    rb.keyPress(KeyEvent.VK_ENTER);
		    rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
}
