package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Utility;

public class RegistrationPage extends Utility {

	
	public RegistrationPage() {
	
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='givenName']")
	private WebElement txtfirstName;
	
	@FindBy (xpath="//input[@name='familyName']")
	private WebElement txtFamilyName;
	
	@FindBy (id="next-button")
	private WebElement btnNext;

	@FindBy(xpath="//option[text()='Male']")
	private WebElement gender;
	
	@FindBy(xpath="//input[@id='birthdateDay-field']")
	private WebElement txtbday;
	
	
	@FindBy(id="birthdateMonth-field")
	private  WebElement ddMonth;
	
	
	@FindBy(id="birthdateYear-field")
	private WebElement txtYear;
	
	
	@FindBy (id="address1")
	private WebElement txtAddress1;
	
	@FindBy(id="address2")
	private WebElement txtAddress2;
	
	@FindBy(id="cityVillage")
	private WebElement txtCity;
	
	@FindBy(xpath="//span[text()='Name: ']/parent::p")
	private WebElement txtName;
	
	@FindBy(xpath="//span[text()='Gender: ']/parent::p")
	private WebElement txtGender;
	
	
	@FindBy(xpath="//span[text()='Birthdate: ']/parent::p")
	private WebElement txtDOB;
	
	@FindBy(xpath="//span[text()='Address: ']/parent::p")
	private WebElement txtAddress;
	
	
	@FindBy(xpath="//span[text()='Phone Number: ']/parent::p")
	private WebElement txtPhoneNum;
	
	@FindBy(id="stateProvince")
	private WebElement txtState;
	
	
	@FindBy(id="country")
	private WebElement txtCountry;
	
	
	@FindBy(id="submit")
	private WebElement btnconfirm;
	
	public WebElement getTxtName() {
		return txtName;
	}

	public WebElement getTxtGender() {
		return txtGender;
	}

	public WebElement getTxtDOB() {
		return txtDOB;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtPhoneNum() {
		return txtPhoneNum;
	}

	public WebElement getBtnconfirm() {
		return btnconfirm;
	}

	@FindBy(xpath="//input[@name='phoneNumber']")
	private WebElement txtPhoneNumber;
	
	
	public WebElement getTxtAddress1() {
		return txtAddress1;
	}

	public WebElement getTxtAddress2() {
		return txtAddress2;
	}

	public WebElement getTxtCity() {
		return txtCity;
	}

	public WebElement getTxtState() {
		return txtState;
	}

	public WebElement getTxtPhoneNumber() {
		return txtPhoneNumber;
	}

	public WebElement getTxtCountry() {
		return txtCountry;
	}

	public WebElement getTxtpostcode() {
		return txtpostcode;
	}

	@FindBy(id="postalCode")
	private WebElement txtpostcode;
	
	public WebElement getTxtbday() {
		return txtbday;
	}

	public WebElement getDdMonth() {
		return ddMonth;
	}

	public WebElement getTxtYear() {
		return txtYear;
	}

	public WebElement getGender() {
		return gender;
	}

	public WebElement getTxtfirstName() {
		return txtfirstName;
	}

	public WebElement getTxtFamilyName() {
		return txtFamilyName;
	}

	public WebElement getBtnNext() {
		return btnNext;
	}
	
	
	
	
	
}
