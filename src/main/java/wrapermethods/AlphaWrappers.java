package wrapermethods;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.Alpha_DataInputProvider;
import utils.Alpha_ReporterUtilities;

public class AlphaWrappers extends Alpha_WrapperMethods {
	
	protected String browserName;
	protected String dataSheetName;
	protected static String testCaseName;
	protected static String testDescription;
	
	@BeforeSuite
	public void beforeSuite() throws FileNotFoundException, IOException{
		Alpha_ReporterUtilities.startResult();
		loadObjects();
	}

	@BeforeTest
	public void beforeTest(){
	System.out.println();	
	}
	
	@BeforeMethod
	public void beforeMethod(){
		Alpha_ReporterUtilities.startTestCase();
	}
		
	@AfterSuite
	public void afterSuite(){
		Alpha_ReporterUtilities.endResult();
	}

	@AfterTest
	public void afterTest(){
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void afterMethod(){
		//quitBrowser();
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return Alpha_DataInputProvider.getSheet(dataSheetName);		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
