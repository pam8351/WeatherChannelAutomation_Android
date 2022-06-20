package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UtilityFunctions {
	AndroidDriver driver;
	
	public String currentProjectDir=System.getProperty("user.dir");
	
	public UtilityFunctions(AndroidDriver driver) {
		this.driver=driver;
		
	}
	public WebElement scrollToParticularText(String text) {
		WebElement element=driver.findElement(AppiumBy.androidUIAutomator ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+text+"\"));"));
		return element;
	}
	public void getScreenshot(String testName) throws IOException {
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File(currentProjectDir+"\\"+testName+".png"));
	}

}
