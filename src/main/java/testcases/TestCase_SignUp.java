package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import alphapages.Alpha_LoginPage;
import alphapages.Alpha_SignUpPage;
import pages.common.Alpha_GeneralPage;
import wrapermethods.AlphaWrappers;

public class TestCase_SignUp extends AlphaWrappers{
	@BeforeClass
	public void setValues(){
		dataSheetName 	= "TC001";
		testCaseName 	= "SignUp to Alpha App";
		testDescription = "SignUp to Alpha app (using POM framework)";
	}

	@Test(dataProvider="fetchData")
	public void Alpha_signUp(String DeviceID){
		new Alpha_LoginPage()
		.launchApp(DeviceID)
		.clickSignUp(); 
		new Alpha_SignUpPage()
		.tapByXpath()
		.enterEmail();
		
		
	}

}
