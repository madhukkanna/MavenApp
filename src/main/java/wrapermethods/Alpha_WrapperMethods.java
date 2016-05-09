package wrapermethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class Alpha_WrapperMethods {
	protected static AndroidDriver<WebElement> driver;
	protected static Properties prop;

	public Alpha_WrapperMethods() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadObjects() throws FileNotFoundException, IOException{
		prop = new Properties();
		prop.load(new FileInputStream(new File("./object.properties")));

	}

	public boolean launchApp(String appPackage,String appActivity,String deviceName ){
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("appPackage", appPackage);
			dc.setCapability("appActivity", appActivity);
			dc.setCapability("deviceName", deviceName);
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return true;	
	}

	public boolean launchActivity(String appPackage, String appActivity){
		try {
			driver.startActivity(appPackage, appActivity);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean launchBrowser(String browserName,String deviceName,String URL ){
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("browserName", browserName);
			dc.setCapability("deviceName", deviceName);
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.2:4724/wd/hub"), dc);
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return true;	
	}

	public boolean verifyAndInstallApp(String appPackage, String appPath) {
		boolean bInstallSuccess = false;

		if (driver.isAppInstalled(appPackage)) 
			driver.removeApp(appPackage);

		driver.installApp(appPath);
		bInstallSuccess=true;

		return bInstallSuccess;
	}

	public void sleep(int mSec){
		try {
			Thread.sleep(mSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printContext(){
		try {
			Set<String> contexts = driver.getContextHandles();
			for (String string : contexts) {
				System.out.println(string);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean switchContext(String Context){
		try {
			driver.context(Context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean clickByID(String ID){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID)));
			driver.findElementById(ID).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean clickByAccessebilityID(String ID){
		try {
			/*WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(ByAccessibilityId(ID));*/
			driver.findElementByAccessibilityId(ID).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean clickByXpath(String Xpath){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			driver.findElementByXPath(Xpath).click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean verifyContentDescIsDisplayed(String Xpath){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		if(driver.findElementByXPath(Xpath).isDisplayed())
			return true;
		else
			return false;
	}

	public boolean clickByLinkText(String LinkText){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(LinkText)));
			driver.findElementByLinkText(LinkText).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean enterTextByID(String ID,String value){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID)));
			driver.findElementById(ID).clear();
			driver.findElementById(ID).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean pressEnter(){
		driver.pressKeyCode(66);
		return true;
	}

	public boolean enterTextByXpath(String Xpath,String value){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			driver.findElementByXPath(Xpath).clear();
			driver.findElementByXPath(Xpath).sendKeys(value);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean enterTextByAccessibilityId(String id, String Value){
		try {
			/*WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@contect-desc='E-mail']")));*/
			driver.findElementByAccessibilityId(id).sendKeys(Value);
			return true;
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}
	
	public boolean tap(int fingers, String Xpath , int time){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		WebElement passtap = driver.findElementByXPath(Xpath);
		driver.tap(fingers, passtap, time);
		return true;
	}
	
	
		
	public boolean clickByAccessbilityId(String id ){
		driver.findElementByAccessibilityId(id).click();;
		return true;
		
	}
	
	
	public boolean takeScreenShot (String FileName){
		try {
			File srcFiler=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFiler, new File(FileName));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean verifyTextByID(String ID,String Expected){
		boolean val = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ID)));
			String name = driver.findElementById(ID).getText();
			if(name.contains(Expected)){
				val = true;
			}else
				val = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	public boolean scrollDownInBrowser(int val){
		try {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,"+val+"\")", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean backButton(){
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean scrollToInApp(String text){
		try {
			driver.scrollTo(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean scrollUsingDesc(String text){
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[contains(@content-desc,'"+text+"')]")));
			Dimension size = driver.manage().window().getSize();
			int x0 = (int) (size.getWidth()*0.2);
			int y0 = (int) (size.getHeight()*0.2);		
			Point xy = driver.findElementByXPath("//android.view.View[contains(@content-desc,'"+text+"')]").getLocation();
			int x1 = (int) (xy.getX());
			int y1 = (int) (xy.getY());
			TouchAction touch = new TouchAction(driver);
			touch.press(x1,y1).waitAction(2000).moveTo(x0, y0).release().perform();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean scrollUpinApp(){
		try {
			Dimension size = driver.manage().window().getSize();
			int x0 = (int) (size.getWidth()*0.2);
			int y0 = (int) (size.getHeight()*0.2);
			int x1 = (int) (size.getWidth()*0.8);
			int y1 = (int) (size.getHeight()*0.8);
			TouchAction touch = new TouchAction(driver);
			touch.press(x1,y1).waitAction(2000).moveTo(x0, y0).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean scrollHalfinApp(){
		try {
			Dimension size = driver.manage().window().getSize();
			int x0 = (int) (size.getWidth()*0.2);
			int y0 = (int) (size.getHeight()*0.2);
			int x1 = (int) (size.getWidth()*0.5);
			int y1 = (int) (size.getHeight()*0.5);
			TouchAction touch = new TouchAction(driver);
			touch.press(x1,y1).waitAction(2000).moveTo(x0, y0).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean clickInApp(){
		try {
			Dimension size = driver.manage().window().getSize();
			int x0 = (int) (size.getWidth()*0.2);
			int y0 = (int) (size.getHeight()*0.2);
			TouchAction touch = new TouchAction(driver);
			touch.press(x0,y0).release().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean pinchInApp(){
		try {
			Dimension size = driver.manage().window().getSize();
			int x0 = (int) (size.getWidth()*0.5);
			int y0 = (int) (size.getHeight()*0.5);
			driver.pinch(100, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean zoomInApp(){
		try {
			Dimension size = driver.manage().window().getSize();
			int x0 = (int) (size.getWidth()*0.5);
			int y0 = (int) (size.getHeight()*0.5);
			System.out.println(x0+" "+y0);
			driver.zoom(100, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean zoomUsingElement(String Xpath){
		try {
			driver.zoom(driver.findElementByXPath(Xpath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean pinchUsingElement(String Xpath){
		driver.pinch(driver.findElementByXPath(Xpath));
		return true;
	}

	public boolean pullFile(String remotePath){
		driver.pullFile(remotePath);

		return true;
	}

	
	public void moveDownInApp(){
		try {
			Dimension size = driver.manage().window().getSize();
			TouchActions touch = new TouchActions(driver);
			System.out.println(size.getWidth()/2);
			System.out.println((int) (0.8*(size.getHeight())));
			touch.move(size.getWidth()/2, (int) (0.8*(size.getHeight()))).release().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public void scrollToFindTextUsingContentDesc(String content) throws InterruptedException{
				scrollDownInBrowser(600);
	}
	
	
}
