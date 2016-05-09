package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import alphapages.Alpha_ChangePwdPage;
import alphapages.Alpha_LoginPage;
import alphapages.Alpha_SignUpPage;
import wrapermethods.AlphaWrappers;

public class Testcase_ChangePassword extends AlphaWrappers{

	@BeforeClass
	public void setValues(){
		dataSheetName 	= "TC001";
		testCaseName 	= "Chnage Password to Alpha App";
		testDescription = "Chnage Password to Alpha app (using POM framework)";
	}

	@Test(dataProvider="fetchData")
	public void Alpha_changePwd(String DeviceID){
		new Alpha_LoginPage()
		.launchApp(DeviceID)
		.clickChangePassword(); 
		new Alpha_ChangePwdPage()
		.switchPage()
		.tapByXpath()
		.enterEmail();
		
		
	}
}
