package sample;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
 
public class AppiumTest {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		caps.setCapability(MobileCapabilityType.UDID, "1738ae18");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		caps.setCapability(MobileCapabilityType.NO_RESET, "true");
		
		caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\ashok\\Downloads\\ContactManager.apk");
		
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		
		//Instantiate Appium Driver
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);
			
		System.out.println("App installed");
		
		driver.quit();
	}
 
}
