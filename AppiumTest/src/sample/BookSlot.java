package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class BookSlot 
{
	AndroidDriver<MobileElement> driver;
	TouchAction action;
	
	int j;
	
    public XSSFWorkbook workbook;
	
    public XSSFSheet sheet;
    
    public XSSFCell cell;
    
    // Import excel sheet.
    //public File src=new File("C:\\Users\\ashok\\OneDrive\\Documents\\Mobile Application TC.xlsx");
    public File src=new File("C:\\Users\\New\\Desktop\\Ashok\\Excel\\Mobile Application TC.xlsx");
    
	@BeforeTest
	public void beforetest() throws MalformedURLException
	{
		//Set the Desired Capabilities
				DesiredCapabilities caps = new DesiredCapabilities();
				/*
				//personal device
				{
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
				caps.setCapability(MobileCapabilityType.UDID, "1738ae18");
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
				caps.setCapability(MobileCapabilityType.NO_RESET, "true");
				}
				*/
				
				//virtual device
				{
					caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
					caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			        caps.setCapability("deviceName","Android Emulator");
			        caps.setCapability("platformVersion", "4.4");
			        
				}
				
				caps.setCapability("appPackage", "com.turftown");
				caps.setCapability("appActivity", "com.turftown.MainActivity");
				
				//caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\ashok\\Downloads\\ContactManager.apk");
				
				URL url = new URL("http://0.0.0.0:4723/wd/hub");
				
				//Instantiate Appium Driver
				
				driver = new AndroidDriver<MobileElement>(url, caps);
					
				System.out.println("App installed");
	}
 

	 @Test(priority=0)
	  public void splash_screen() throws InterruptedException, IOException 
	  {
	    	// Load the file.
		    FileInputStream finput = new FileInputStream(src);
			// Load he workbook.
		    workbook = new XSSFWorkbook(finput);
		    // Load the sheet in which data is stored.
		    sheet = workbook.getSheet("sheet1");
		  
		  try 
		  {
			  swipe();
			  Thread.sleep(3000);
			  swipe();
			  Thread.sleep(3000);
			  swipe();
			  Thread.sleep(3000);
			  swipe();
			  Thread.sleep(3000);
			  System.out.println("PageSwipe");
			  System.out.println("Splash screen pass");
			  //sheet.getRow(1).createCell(j).setCellValue("Pass");
			  
		} catch (Exception e) {
			// TODO: handle exception
			//sheet.getRow(1).createCell(j).setCellValue("fail");
			System.out.println("Fail");
		}
		  
		  
		  
		  
		  MobileElement get_started = driver.findElementByXPath("//*[@text='GET STARTED']");
		  get_started.click();
		  
		  Thread.sleep(3000);
		  
		  
		        FileOutputStream fileOutput = new FileOutputStream(src);
		        // finally write content
		        workbook.write(fileOutput);
		         // close the file
		        fileOutput.close();
		  
	  }
	  
	  @Test(priority=1)
	  public void Login_via_Mobile_number() throws InterruptedException
	  {
		  //===========MOBILE NUMBER============//
		  
		  driver.findElementByXPath("//*[@text='Mobile Number']").sendKeys("8136948537");
		  Thread.sleep(3000);
		  System.out.println("Mobile number is entered");
		  
		  MobileElement submit = driver.findElementsByXPath("//*[@text='SUBMIT']").get(0);
		  submit.click();
		  Thread.sleep(3000);
	  }
	  
	  
	  @Test(priority=2)
	  public void OTP_PAGE() throws InterruptedException
	  {
		  
		  //default OTP for static phone number
		  
		  MobileElement one = driver.findElementsByClassName("android.widget.EditText").get(0);
		  one.sendKeys("7");
		  MobileElement digit2 = driver.findElementsByClassName("android.widget.EditText").get(1);
		  digit2.sendKeys("4");
		  MobileElement digit3 = driver.findElementsByClassName("android.widget.EditText").get(2);
		  digit3.sendKeys("8");
		  MobileElement digit4 = driver.findElementsByClassName("android.widget.EditText").get(3);
		  digit4.sendKeys("4");
		  
		  if(driver.findElementsByXPath("//*[@text='INVALID OTP']").size() != 0)
		  {
			  System.out.println("Entered a invalid OTP");
		  }
		  else
		  {
		  System.out.println("Login successfully");
		  }
	  }
	  
	  
	  
	  
	  public void swipe()
	  {  
		  TouchAction action = new TouchAction(driver);
		  PointOption p1= new PointOption();
		  
		  action.longPress(PointOption.point(925, 1000)).moveTo(PointOption.point(40, 950)).release().perform();
	   }
  
  //@AfterTest
  public void aftertest()
  {
	  driver.quit();
  }
}
