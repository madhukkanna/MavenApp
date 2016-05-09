package alphapages;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import pages.common.Alpha_GeneralPage;
import utils.Alpha_ReporterUtilities;

public class Alpha_LoginPage extends Alpha_GeneralPage{
	
	public Alpha_LoginPage launchApp(String DeviceID ){
		
		launchApp("com.ionicframework.alpha823162","com.ionicframework.alpha823162.MainActivity",DeviceID);
		if(launchActivity("com.ionicframework.alpha823162", "com.ionicframework.alpha823162.MainActivity"))
			Alpha_ReporterUtilities.reportStep("The app activity: Android Shopping started successfully", "PASS");
		else
			Alpha_ReporterUtilities.reportStep("The app activity: Android Shopping  could not be started", "FAIL");		
		
		return this;
	}
	
	public Alpha_LoginPage enterUserName(){
		
		if(enterTextByAccessibilityId("E-mail", "testleaf50@gmail.com"))
			Alpha_ReporterUtilities.reportStep("Entered UserName successfully", "PASS");
		else
			Alpha_ReporterUtilities.reportStep("UserName could not be entered", "FAIL");
		return this;
		
	}
	
	public Alpha_LoginPage hideKeyPad(){
		driver.hideKeyboard();
		return this;
		
	}	
		
	public Alpha_LoginPage tapByXpath() {

		tap(1,"//android.view.View[3]/android.widget.EditText[1]", 3);
		return this;
	}
	
	public Alpha_LoginPage enterPassword(){
		if(enterTextByXpath("//android.view.View[3]/android.widget.EditText[1]", "testleaf"))
			Alpha_ReporterUtilities.reportStep("Password entered successfully", "PASS");
		else
			Alpha_ReporterUtilities.reportStep("Password could not be entered", "FAIL");	
		return this;
	}
	
	public Alpha_LoginPage clickLogin(){
		if(clickByXpath("//android.widget.Button[@content-desc='Login ']"))
			Alpha_ReporterUtilities.reportStep("Login done successfully", "PASS");
		else
			Alpha_ReporterUtilities.reportStep("Login Failed", "FAIL");
		return this;
	}
	
	public Alpha_LoginPage clickOK(){
		sleep(3000);
		clickByAccessbilityId("OK");
		return this;
		
	}

	public Alpha_LoginPage rotate() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
		return this;
	}

	

	public Alpha_SignUpPage clickSignUp() {
		if(clickByAccessbilityId("Sign Up "))
			Alpha_ReporterUtilities.reportStep("Login done successfully", "PASS");
		else
			Alpha_ReporterUtilities.reportStep("Login Failed", "FAIL");
		return new Alpha_SignUpPage() ;
		
		
	}

	public Alpha_SignUpPage clickChangePassword() {
		if(clickByAccessbilityId("Change Password "))
			Alpha_ReporterUtilities.reportStep("Login done successfully", "PASS");
		else
			Alpha_ReporterUtilities.reportStep("Login Failed", "FAIL");
		return new Alpha_SignUpPage() ;
		
	}

	
	
}
