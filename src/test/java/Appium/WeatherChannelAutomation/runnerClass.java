package Appium.WeatherChannelAutomation;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pageUiObjects.HourlyForecastUI;
import pageUiObjects.LaunchPageUI;
import pageUiObjects.TodaysDetailsUI;
import pageUiObjects.TredingDetailsPageUI;
import utilities.DriverFactory;
import utilities.UtilityFunctions;

public class runnerClass extends DriverFactory {

	@BeforeTest
	public static void launchApp() throws IOException {
		System.out.println("Launching the application");
		AndroidDriver driver=driverInitiation("watherChannel.apk");

	}

	@Test(priority=1)
	public static  void validate_user_LookUp_Location_For_Weather_CheckUp()throws InterruptedException, IOException {
		// TODO Auto-generated method stub



		LaunchPageUI launchPage=new LaunchPageUI(driver);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.weather.Weather:id/search_icon")));
		System.out.println("Searching the city...");
		launchPage.searchIcon.click();
		//driver.findElement(By.id("com.weather.Weather:id/search_icon")).click();
		//WebDriverWait wait = new WebDriverWait(driver, 10);

		// WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));
		launchPage.searchText.sendKeys("Santa cruz,CA");
		List<WebElement> resultSet=launchPage.searchResultSet;
		for(int i=0;i<resultSet.size();i++) {
			if(resultSet.get(i).getText().equalsIgnoreCase("California")) {


				launchPage.searchResultSet.get(i).click();
				break;
			}
		}
		//update this value from property file
		if(launchPage.resultedCity.getText().equalsIgnoreCase("Santa Cruz, CA")) {
			Assert.assertTrue(true);
		}else
			Assert.assertTrue(false);

	}
	@Test(priority=2)
	public static void validate_Hourly_details_displayed() throws InterruptedException {




		HourlyForecastUI hourly=new HourlyForecastUI(driver);




		System.out.println("Validating hourly details is diplayed "+hourly.hourlyForecastContainer.isDisplayed());
		//System.out.println(resultSet.get(0).getText());com.weather.Weather:id/hourly_forecast_adapter_column
		List<WebElement> hourlyList=hourly.hourlyTempContainer;
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		UtilityFunctions utils=new UtilityFunctions(driver);
		WebElement detailsButton=utils.scrollToParticularText("See Details");
		//driver.findElement(AppiumBy.androidUIAutomator ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"See Details\"));"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertEquals(hourlyList.size(),5);
		if(detailsButton.isDisplayed()) {
			Assert.assertTrue(true);
		}else
			Assert.assertTrue(false);
		
	}

		@Test(priority=3)
		public static void validate_Todays_Details_is_displayed() throws IOException {
		//System.out.println("See details button displayed ,"+detailsButton.isDisplayed());
			UtilityFunctions utils=new UtilityFunctions(driver);
		    WebElement Today_Details=utils.scrollToParticularText("Today's Details");
		    //AppiumBy.androidUIAutomator ("new UiScrollable(new UiSelector().scrollable(true)).scrollForward(10)");
		    WebElement moreDetaills=utils.scrollToParticularText("More Details");
		//driver.findElement(AppiumBy.androidUIAutomator ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Today's Details\"));"));
		    TodaysDetailsUI todayData=new TodaysDetailsUI(driver);
			String name=todayData.windText.getAttribute("text");

		System.out.println("Validating Todays details each creteria..");
		
	

		WebElement wind=driver.findElement(By.id("com.weather.Weather:id/wind_desc"));
		if(wind.getText().length()>1){
			System.out.println("Wind details  are displayed "+wind.getText());
		}
	
		
		String[] arr = {"Wind","Humidity","Dew Point","Pressure","UV Index","Sunrise","Sunset"};
		//String[] arr = {"Wind","Humidity"};
		
		
		for(String x:arr) {
			System.out.println("Array "+x);
		}
		LinkedHashMap<WebElement, WebElement> map=todayData.hashMapCollection();
		
		for(WebElement element:map.keySet()) {
			//System.out.println("inside first loop");
			for(int i=0;i<arr.length;i++) {
				//System.out.println("inside second loop");
				if(arr[i].equalsIgnoreCase(element.getText())) {
					//System.out.println("inside if loop");
					Assert.assertTrue(map.get(element).getText().length()>0);
					System.out.println("Verified "+element+" details are displayed");
					
					
				}
			}
			System.out.println(element.getText()+" "+map.get(element).getText());
		}
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		moreDetaills.click();
		
		}
		//WebElement moreDetails=driver.findElement(AppiumBy.androidUIAutomator ("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"More Details\"));"));
		//WebElement moreDetails=driver.findElement(By.xpath("//android.widget.Button[@text='More Details']"));
	
		//Thread.sleep(2000);
		
		@Test(priority=4)
		public static void verify_Trend_Graph_For_Each_Condition() {
			TredingDetailsPageUI trendUI=new TredingDetailsPageUI(driver);
		System.out.println("Validating Feels Like option");	
		trendUI.windOption.click();
		//driver.switchTo().frame(driver.findElement(By.className("android.widget.RelativeLayout")));
		List<WebElement> trendValues=trendUI.valueContainer;
		//System.out.println(temp_text.size());
		boolean validateTrend=verifyTrend(trendValues);
		Assert.assertTrue(validateTrend);
		System.out.println("All values and graph chart is displayed for Feels Like option "+validateTrend);

		System.out.println("Validating Humidity option");
		trendUI.humidityOption.click();
		trendValues=trendUI.valueContainer;
		validateTrend=verifyTrend(trendValues);
		Assert.assertTrue(validateTrend);
		System.out.println("All values and graph chart is displayed for Humidity option "+validateTrend);
		System.out.println("Validating Dew point option");
		trendUI.dewPoint.click();
		trendValues=trendUI.valueContainer;
		validateTrend=verifyTrend(trendValues);
		Assert.assertTrue(validateTrend);
		System.out.println("All values and graph chart is displayed for Dew point option "+validateTrend);
		System.out.println("Validating wind option");
		trendUI.windOption.click();
		trendValues=trendUI.valueContainer;
		validateTrend=verifyTrend(trendValues);
		Assert.assertTrue(validateTrend);
		System.out.println("All values and graph chart is displayed for wind option "+validateTrend);
		System.out.println("Validating Temperature option");	
		trendUI.temperatureOption.click();
		trendValues=trendUI.valueContainer;
		validateTrend=verifyTrend(trendValues);
		Assert.assertTrue(validateTrend);
		System.out.println("All values and graph chart is displayed for temperature option "+validateTrend);


		//driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"More Details\"));"));
		//driver.AndroidFindBy("new UiScrollable(new UiSelector()).scrollIntoView(text(\"More Details\"));");
		//TouchActions action = new TouchActions(driver);
		//WebElement element=driver.findElement(By.id("com.weather.Weather:id/details_button"));
		//action.scroll(element, 10, 2000);
		//action.perform();
		//driver.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"More Details\"));"));


	}

	private static boolean verifyTrend(List<WebElement> list) {
		// TODO Auto-generated method stub
		if(list.size()>=6) {
			System.out.println(list.size());
			for(int i=0;i<list.size();i++) {
				String unit=list.get(i).getText();
				System.out.println(unit);
				if(unit.length()<=1) {
					//System.out.println("inside the loop");
					return false;

				}
			}
		}
		return true;
	}

}
