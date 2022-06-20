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

public class LaunchPageUI {
	
	public LaunchPageUI(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="com.weather.Weather:id/search_icon")
	public WebElement searchIcon;
	

	
	@FindBy(id="com.weather.Weather:id/search_text")
	public WebElement searchText;

	@FindBy(id="com.weather.Weather:id/name")
	public List<WebElement> searchResultSet;
	
	@FindBy(id="com.weather.Weather:id/txt_location_name")
	public WebElement resultedCity;
}
