package testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import alphapages.Alpha_LoginPage;
import wrapermethods.AlphaWrappers;


public class Testcase_LogIn extends AlphaWrappers{

	@BeforeClass
	public void setValues(){
		dataSheetName 	= "TC001";
		testCaseName 	= "SignIn to Alpha App";
		testDescription = "SignIn to Alpha app (using POM framework)";
	}

	@Test(dataProvider="fetchData")
	public void Alpha(String DeviceID){
		new Alpha_LoginPage()
		.launchApp(DeviceID)
		//.rotate()
		.enterUserName()
		.hideKeyPad()
		.tapByXpath()
		.enterPassword()
		.hideKeyPad()
		.clickLogin()
		.clickOK();
	}
	

}
