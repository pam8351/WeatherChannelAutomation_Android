package pageUiObjects;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TredingDetailsPageUI {

	public TredingDetailsPageUI(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	LinkedHashMap<WebElement,WebElement> elementMap=new LinkedHashMap<WebElement,WebElement>();
	@FindBy(xpath="//android.widget.TextView[@text='Feels like']")
	
	public WebElement feelsLikeOption;

	@FindBy(xpath="//android.widget.TextView[@text='Temperature']")
	public WebElement temperatureOption;
	
	@FindBy(xpath="//android.widget.TextView[@text='Wind']")
	public WebElement windOption;
	
	@FindBy(xpath="//android.widget.TextView[@text='Humidity']")
	public WebElement humidityOption;
	
	@FindBy(xpath="//android.widget.TextView[@text='Dew Point']")
	public WebElement dewPoint;

	
	@FindBy(id="com.weather.Weather:id/temp_text")
	public List<WebElement> valueContainer;

}
