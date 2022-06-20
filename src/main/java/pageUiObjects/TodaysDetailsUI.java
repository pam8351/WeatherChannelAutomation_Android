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

public class TodaysDetailsUI {

	public TodaysDetailsUI(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	LinkedHashMap<WebElement,WebElement> elementMap=new LinkedHashMap<WebElement,WebElement>();
	@FindBy(id="com.weather.Weather:id/search_icon")
	public WebElement searchIcon;


	@FindBy(className="android.widget.TextView")
	public List<WebElement> todaysDetails;

	@FindBy(xpath="//android.widget.TextView[@text='Wind']")
	public WebElement windText;
	//android.widget.TextView[@text='Wind']")
	@FindBy(id="com.weather.Weather:id/wind_desc")
	public WebElement windValue;

	@FindBy(id="com.weather.Weather:id/humidity_title")
	public WebElement humidityText;


	@FindBy(id="com.weather.Weather:id/humidity_desc")
	public WebElement humidityValue;

	@FindBy(id="com.weather.Weather:id/dew_point_title")
	public WebElement dewText;


	@FindBy(id="com.weather.Weather:id/dew_point_desc")
	public WebElement dewValue;

	@FindBy(id="com.weather.Weather:id/pressure_title")
	public WebElement pressureText;


	@FindBy(id="com.weather.Weather:id/pressure_desc")
	public WebElement pressureValue;

	@FindBy(id="com.weather.Weather:id/uv_title")
	public WebElement uvText;


	@FindBy(id="com.weather.Weather:id/uv_desc")
	public WebElement uvValue;

	@FindBy(id="com.weather.Weather:id/sunrise_title")
	public WebElement sunRiseText;


	@FindBy(id="com.weather.Weather:id/sunrise_desc")
	public WebElement sunRiseValue;

	@FindBy(id="com.weather.Weather:id/sunset_title")
	public WebElement sunSetText;


	@FindBy(id="com.weather.Weather:id/sunset_desc")
	public WebElement sunSetValue;



	@FindBy(id="com.weather.Weather:id/today_details_container")
	public WebElement  todaysDetailsContainer;

	public LinkedHashMap<WebElement, WebElement> hashMapCollection() {
		elementMap.put(windText,windValue);

		elementMap.put(humidityText, humidityValue);

		elementMap.put(dewText, dewValue);
		elementMap.put(pressureText, pressureValue);
		elementMap.put(uvText, uvValue);
		elementMap.put(sunRiseText, sunRiseValue);
		elementMap.put(sunSetText,sunSetValue);


		return elementMap;
	}
}
