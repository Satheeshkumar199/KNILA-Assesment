package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Utility;

public class HomePage extends Utility {

	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="loginButton")
	private WebElement btnLogin;
	
	@FindBy(id="Inpatient Ward")
	private WebElement btnlocInpatientward;

	public WebElement getBtnlocInpatientward() {
		return btnlocInpatientward;
	}

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
	
	
	
	
}
