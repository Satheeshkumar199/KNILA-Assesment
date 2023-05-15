package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Utility;

public class DashBoardPage  extends Utility{

	
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[contains(text(),'Logged in')]")
	private WebElement txtheading;

	public WebElement getTxtheading() {
		return txtheading;
	}
	@FindBy(xpath="//a[contains(@id,'registrationapp')]")
	private WebElement btnRegister;

	public WebElement getBtnRegister() {
		return btnRegister;
	}

	
}
