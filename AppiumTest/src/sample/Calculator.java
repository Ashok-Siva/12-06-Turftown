package sample;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void beforetest() throws MalformedURLException, InterruptedException
	{
		//Set the Desired Capabilities
				DesiredCapabilities caps = new DesiredCapabilities();
				
				caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
				caps.setCapability(MobileCapabilityType.UDID, "1738ae18");
				caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
				caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
				caps.setCapability(MobileCapabilityType.NO_RESET, "true");
				
				caps.setCapability("appPackage", "com.miui.calculator");
				caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
				
				URL url = new URL("http://0.0.0.0:4723/wd/hub");
				
				//Instantiate Appium Driver
				
				driver = new AndroidDriver<MobileElement>(url, caps);
				Thread.sleep(5000);
	} 
	
  @Test
  public void f() 
  {
	  System.out.println("App is Opened");
  }
  
  
  @AfterTest
  public void aftertest()
  {
	  driver.quit();
  }
}
