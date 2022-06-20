package pageUiObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HourlyForecastUI {
	
	public HourlyForecastUI(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="com.weather.Weather:id/hourly_forecast_container")
	public WebElement hourlyForecastContainer;
	
	@FindBy(id="com.weather.Weather:id/hourly_forecast_adapter_column")
	public List<WebElement> hourlyTempContainer;
	
	

}
