package alphapages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import pages.common.Alpha_GeneralPage;
import utils.Alpha_ReporterUtilities;

public class Alpha_ChangePwdPage extends Alpha_GeneralPage{
	
	public Alpha_ChangePwdPage switchPage(){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Change Password']")));
		Set<String> pages = driver.getContextHandles();
		for(String curntpage : pages){
			System.out.println(curntpage);
			driver.context(curntpage);
		}
		
		return this;
	}

	public Alpha_ChangePwdPage tapByXpath() {
		tap(1, "//android.widget.EditText[@content-desc='EMail']", 3);
		return this;
	}

	public Alpha_ChangePwdPage enterEmail(){
		if(enterTextByXpath("//android.widget.EditText[@content-desc='EMail']", "madhan.tact@gmail.com"))
			Alpha_ReporterUtilities.reportStep("UserName entered successfully", "PASS");
		else
			Alpha_ReporterUtilities.reportStep("UserName could not be entered", "FAIL");
		return this;
		
	}
	
	
	
	

}
