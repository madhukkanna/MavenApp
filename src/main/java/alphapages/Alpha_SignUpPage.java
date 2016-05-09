package alphapages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.common.Alpha_GeneralPage;

public class Alpha_SignUpPage extends Alpha_GeneralPage {
	
	public Alpha_SignUpPage tapByXpath(){
		tap(1,"//android.widget.EditText[@content-desc='E-mail']",2);
		return this;
		
	}

	public Alpha_SignUpPage enterEmail(){
		enterTextByXpath("//android.widget.EditText[@content-desc='E-mail']","madhan.tact@gmail.com" );
		return this;
		
	}

	
}
