package PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.Utility;

public class PatientDetailsPage extends Utility {

	public PatientDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[text()='Recent Visits']/ancestor::div[@class='info-header']/following-sibling::div//li")
	private List<WebElement> recentVisits;

	public List<WebElement> getRecentVisits() {
		return recentVisits;
	}
	@FindBy(xpath = "//div[contains(text(),'Start Visit')]")
	private WebElement btnStartVisit;

	public WebElement getBtnStartVisit() {
		return btnStartVisit;
	}

	@FindBy(xpath="(//a[contains(@id,'endVisit')])[2]")
	private WebElement btnEndvisit;
	public WebElement getBtnEndvisit() {
		return btnEndvisit;
	}

	public WebElement getBtnConfirmStartVisit() {
		return btnConfirmStartVisit;
	}

	public WebElement getBtnAttachements() {
		return btnAttachements;
	}

	public WebElement getFileUpload() {
		return fileUpload;
	}

	public WebElement getBtnUpload() {
		return btnUpload;
	}

	public WebElement getTxtcaption() {
		return txtcaption;
	}

	
	@FindBy(xpath="//div[@class='toast-container toast-position-top-right']//div")
	
	private WebElement txtToastmessage;
	@FindBy(xpath = "//button[@id='start-visit-with-visittype-confirm']")
	private WebElement btnConfirmStartVisit;

	@FindBy(xpath = "//a[contains(@id,'attachments')]")
	private WebElement btnAttachements;

	public WebElement getTxtToastmessage() {
		return txtToastmessage;
	}
	
	@FindBy(xpath="//a[contains(@id,'vitals')]")
	private WebElement btnCapturevitals;

	@FindBy(xpath="//input[@id='w8']")
	private WebElement txtheight;
	@FindBy(xpath="//input[@id='w10']")
	private WebElement weight;
	
	
	@FindBy(xpath="(//button[text()='Yes' and @class='confirm right'])[2]")
	private WebElement btnYes;
	public WebElement getBtnYes() {
		return btnYes;
	}
	@FindBy(xpath = "//div[text()='Click or drop a file here.']")
	private WebElement fileUpload;
	@FindBy(id="next-button")
private WebElement btnnext;

	@FindBy(xpath="(//button[text()='Yes'])[3]")
	private WebElement btnyes;
	public WebElement getBtnyes() {
		return btnyes;
	}

	public WebElement getBtnCapturevitals() {
		return btnCapturevitals;
	}

	public WebElement getTxtheight() {
		return txtheight;
	}
	
	
	@FindBy(id="save-form")
	private WebElement btnsaveform;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	private WebElement btnSave;
	public WebElement getBtnsaveform() {
		return btnsaveform;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}
	@FindBy(xpath="//span[@id='calculated-bmi']")
private WebElement calcBMI;
	public WebElement getCalcBMI() {
		return calcBMI;
	}

	public WebElement getWeight() {
		return weight;
	}

	public WebElement getBtnnext() {
		return btnnext;
	}
	@FindBy(xpath = "//button[text()='Upload file']")
	private WebElement btnUpload;

	@FindBy(xpath = "//textarea[@placeholder='Enter a caption']")
	private WebElement txtcaption;
	
	@FindBy(xpath="(//li//a)[5]")
	private WebElement redirectionPatientDetail;

	@FindBy(xpath="//div[@ng-click='toggleEditMode(true)']")
	private WebElement attachment;
	
	public WebElement getAttachment() {
		return attachment;
	}

	public WebElement getRedirectionPatientDetail() {
		return redirectionPatientDetail;
	}
	@FindBy(xpath="//a[text()=' End Visit']")
private WebElement btnend;

	public WebElement getBtnend() {
		return btnend;
		
	}
	
	@FindBy(xpath="//span[@id='weight']//span[@class='value']")
	private WebElement Weight;
	@FindBy(xpath="//span[@id='height']//span[@class='value']")
	private WebElement Height;

	public WebElement getHeight() {
		return Height;
	}

}
