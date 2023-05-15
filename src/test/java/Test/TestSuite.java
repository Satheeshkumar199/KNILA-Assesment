package Test;

import java.awt.AWTException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.DashBoardPage;
import PageObjects.HomePage;
import PageObjects.PatientDetailsPage;
import PageObjects.RegistrationPage;

public class TestSuite extends Utility {

	Map<String, String> patientdetails = new HashMap<>();

	static DashBoardPage dp;
	static HomePage hp;
	static RegistrationPage rp;
	static PatientDetailsPage pdp;

	@BeforeTest
	public void PreSteps() {
		LaunchApp("https://qa-refapp.openmrs.org/openmrs/login.htm");

	}

	@Test
	public void ValidatetheuserloggedintotheApp() {
		hp = new HomePage();
		typeText(hp.getTxtUsername(), "Admin");
		typeText(hp.getTxtPassword(), "Admin123");
		clickElement(hp.getBtnlocInpatientward());
		clickElement(hp.getBtnLogin());
		dp = new DashBoardPage();
		Assert.assertTrue(dp.getTxtheading().isDisplayed());
	}

	@Test
	public void validateThePatientInformation() {

		patientdetails.put("firstName", "Testjohn");
		patientdetails.put("familyname", "smith");
		patientdetails.put("DOB", "25, March, 2000");
		patientdetails.put("gender", "Male");
		patientdetails.put("Address", "13B, NewYork, NY, US, 1022");
		patientdetails.put("Phonenumber", "099999999999");
		clickElement(dp.getBtnRegister());
		rp = new RegistrationPage();
		typeText(rp.getTxtfirstName(), patientdetails.get("firstName"));
		typeText(rp.getTxtFamilyName(), patientdetails.get("familyname"));
		clickElement(rp.getBtnNext());
		clickElement(rp.getGender());
		clickElement(rp.getBtnNext());
		typeText(rp.getTxtbday(), "25");
		selectDropDownvalue(rp.getDdMonth(), 3);
		typeText(rp.getTxtYear(), "2000");
		clickElement(rp.getBtnNext());
		typeText(rp.getTxtAddress1(), "13B");
		typeText(rp.getTxtCity(), "NewYork");
		typeText(rp.getTxtState(), "NY");
		typeText(rp.getTxtCountry(), "US");
		typeText(rp.getTxtpostcode(), "1022");
		clickElement(rp.getBtnNext());
		typeText(rp.getTxtPhoneNumber(), patientdetails.get("Phonenumber"));
		clickElement(rp.getBtnNext());
		clickElement(rp.getBtnNext());

		Assert.assertTrue(rp.getTxtName().getText().contains(" " + patientdetails.get("firstName")));
		System.out.println("Name is verified ");

		Assert.assertTrue(rp.getTxtAddress().getText().contains(" " + patientdetails.get("Address")));

		System.out.println("Address is verified");

		Assert.assertTrue(rp.getTxtDOB().getText().contains(patientdetails.get("DOB")));

		System.out.println("DOB is verified ");

		// System.out.println("Actual"+rp.getGender().getText() +"Expected"+
		// patientdetails.get("gender") );
		Assert.assertTrue(rp.getTxtGender().getText().contains(patientdetails.get("gender")));
		System.out.println("Gender is verified");

		Assert.assertTrue(rp.getTxtPhoneNum().getText().contains(patientdetails.get("Phonenumber")));
		System.out.println("Phonenumber is verified");

		clickElement(rp.getBtnconfirm());

		LocalDate dob = LocalDate.of(2000, 03, 25);
		LocalDate curDate = LocalDate.now();
		Assert.assertEquals("23", String.valueOf(Period.between(dob, curDate).getYears()));

	}

	@Test
	public void validatetheFileAttachments() throws AWTException, InterruptedException {
		pdp = new PatientDetailsPage();
		clickElement(pdp.getBtnStartVisit());
		clickElement(pdp.getBtnConfirmStartVisit());
		Thread.sleep(2000);
		clickElement(pdp.getBtnAttachements());
		clickElement(pdp.getFileUpload());
		String filedir = System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\abc.txt";
		uploadafile(filedir);
		Thread.sleep(2000);
		typeText(pdp.getTxtcaption(), "For testing");
		clickElement(pdp.getBtnUpload());
		Assert.assertTrue(pdp.getTxtToastmessage().isDisplayed());
		clickElement(pdp.getRedirectionPatientDetail());
		Assert.assertTrue(pdp.getAttachment().isDisplayed());
		System.out.println("Attachment validation is done");
		Assert.assertTrue(pdp.getRecentVisits().size() == 1);
		clickElement(pdp.getBtnEndvisit());
		clickElement(pdp.getBtnYes());
		clickElement(pdp.getBtnStartVisit());
		clickElement(pdp.getBtnConfirmStartVisit());
		String height = "167";
		String weight = "87";
		clickElement(pdp.getBtnCapturevitals());
		typeText(pdp.getTxtheight(), height);
		;
		clickElement(pdp.getBtnnext());
		typeText(pdp.getWeight(), weight);
		clickElement(pdp.getBtnnext());

		double ht = Double.valueOf(height) / 100;
		double wt = Double.valueOf(weight) / 100;

		double BMI = (wt / (ht * ht)) * 100;

		DecimalFormat df = new DecimalFormat("##.#");
		System.out.println(df.format(BMI));

		Assert.assertEquals(df.format(BMI), (pdp.getCalcBMI().getText()));
		System.out.println("BMI is verified");

		clickElement(pdp.getBtnsaveform());
		clickElement(pdp.getBtnSave());
		Thread.sleep(2000);
		clickElement(pdp.getBtnend());

		clickElement(pdp.getBtnyes());
		clickElement(pdp.getRedirectionPatientDetail());
		
		Assert.assertTrue(pdp.getHeight().getText().equals(height));
		
	}

}
