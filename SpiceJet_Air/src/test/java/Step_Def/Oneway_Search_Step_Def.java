package Step_Def;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Oneway_Search_Step_Def {


	public WebDriver driver = null;
	
	@Given("Here I am in the SpiceJet website")
	public void here_i_am_in_the_spice_jet_website() throws InterruptedException {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
		//Click Login
		WebElement loginbutton = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		loginbutton.click();
		//Click email option
		WebElement emailidbutton = driver.findElement(By.xpath("//div[text()='Email']"));
		emailidbutton.click();
		//Enter email id
		WebElement enteremail =driver.findElement(By.xpath("//input[@type='email']"));
	    enteremail.sendKeys("devanandh2902@gmail.com");
	    Thread.sleep(3000);
	    //Enter Password
	    WebElement enterpassword =driver.findElement(By.xpath("//input[@data-testid='password-input-box-cta']"));
	    enterpassword.sendKeys("Batman12@#");
	    
	    //Click Login
	    WebElement clicktologin = driver.findElement(By.xpath("//div[@data-testid='login-cta']"));
	    clicktologin.click();
	    
	    //Get Account holder name to verify
	    WebElement getaccname = driver.findElement(By.xpath("//div[text()='Hi Muruganandh']"));
		String accnameverify = getaccname.getText();
		System.out.println(accnameverify);
	    
	}

	@When("I search for one way flights")
	public void i_search_for_one_way_flights() throws InterruptedException {
		Thread.sleep(3000);
		
		//Click One-way option to Search, Book and Confirm
		WebElement clickoneway = driver.findElement(By.xpath("//div[contains(text(),'one way')]"));
		clickoneway.click();
		
		//Enter the Pickup location to start journey
		WebElement pickup = driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[1]/div[1]/div[3]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]"));
	    pickup.sendKeys("Chen");
	    Thread.sleep(2000);
	    
	    //Enter the Drop Locations to end Journey
	    WebElement drop = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input[@type='text']"));
	    drop.sendKeys("Mum");
	    //WebElement calendaroneway = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[2]/*[name()='svg'][1]"));
	    //calendaroneway.click();
	    
	    //Select the Date 
	    WebElement calendardateoneway = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[3]/div[3]/div[4]/div[1]/div[1]"));
	    calendardateoneway.click();
	    
	    //Click the Search flight
	    WebElement clickserachflight = driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']"));
	    clickserachflight.click();
		
	}

	@And("I select a flight for my trip")
	public void i_select_a_flight_for_my_trip() throws InterruptedException {
		Thread.sleep(5000);
		
		//Click the Continue Button
		WebElement continuebutton = driver.findElement(By.xpath("//div[@data-testid='continue-search-page-cta']"));
		continuebutton.click();
	}

	@And("I fill in the passenger form")
	public void i_fill_in_the_passenger_form() throws InterruptedException {
		
		WebElement entercity = driver.findElement(By.xpath("//input[@data-testid='city-inputbox-contact-details']"));
		entercity.sendKeys("Chennai");
		driver.findElement(By.xpath("(//*[name()='rect'])[3]")).click();
		Thread.sleep(5000);
		try {
            // Find an element to capture a screenshot of (e.g., a button or some specific part of the page)
			driver.findElement(By.xpath("//div[@data-testid='traveller-info-continue-cta']")); // Replace with your element's locator

            // Take a screenshot of the element
            File ScreenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // Copy the screenshot to a desired location
            FileUtils.copyFile(ScreenShots, new File("D:\\Eclipse\\SpiceJet_Airline\\ScreenShots\\passengerformdone.png"));

            System.out.println("Screenshot captured and saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to capture the screenshot: " + e.getMessage());
        }
		WebElement amountcontinue = driver.findElement(By.xpath("//div[@data-testid='traveller-info-continue-cta']"));
		amountcontinue.click();
		
	}

	@Then("I select my seat preference")
	public void i_select_my_seat_preference() throws InterruptedException {
		Thread.sleep(5000);
		//Click continue
		WebElement clickcontinue = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]"));
		clickcontinue.click();
		Thread.sleep(5000);
		//Click Pop up to select our wish to select the seat
		WebElement popupselect = driver.findElement(By.xpath("//span[text()='SELECT NOW']"));
		popupselect.click();
		
		//Select the Required seat
		WebElement selectseat =  driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-poiln3 r-1enofrn r-1wyvozj r-u8s1d r-1v2oles r-1i38069 r-184en5c'][normalize-space()='21E'])[1]"));
	    selectseat.click();
		Thread.sleep(2000);
		
		//The below codes are Premium seats options 
		//driver.findElement(By.xpath("(//*[name()='circle'])[12]")).click();
		//driver.findElement(By.xpath("//div[contains(text(),'Skip')]")).click();
		//Thread.sleep(3000);
		
		//After Select seat clcik done
		WebElement donebutton = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-15bsvpr r-1w50u8q r-ah5dr5 r-1otgn73']"));
		donebutton.click();
		
		try {
            // Find an element to capture a screenshot of (e.g., a button or some specific part of the page)
			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]"));// Replace with your element's locator

            // Take a screenshot of the element
            File ScreenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // Copy the screenshot to a desired location
            FileUtils.copyFile(ScreenShots, new File("D:\\Eclipse\\SpiceJet_Airline\\ScreenShots\\Selectseatdone.png"));

            System.out.println("Screenshot captured and saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to capture the screenshot: " + e.getMessage());
        }
		Thread.sleep(2000);
		
		//Again click continue 
		WebElement againclickcontinue = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]"));
		againclickcontinue.click();
		
	}

	//Payment process
	@When("I enter my card details as follows:")
	public void i_enter_my_card_details_as_follows(String cardNumber, String Year, String Month, String cvv, String cardHolderName) {
	   
		//Switch to Nested iframe
		
		// Switch to the card number frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='card_number_iframe_K1gGKJVJSbQKmWQa']")));
		driver.switchTo();
		// Switch to the card number frame
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_number_iframe']")));
		
		// Input holder name
		driver.findElement(By.xpath("//input[@placeholder='Cardholder Name']")).sendKeys(cardHolderName);
		// Switch to the holder name frame
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='name_on_card_iframe']")));

		// Switch to the month frame
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_exp_month_iframe']")));
		// Input month
		driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys(Month);
		
		// Switch to the year frame
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_exp_year_iframe']")));
		// Input year
		driver.findElement(By.xpath("//input[@placeholder='YY']")).sendKeys(Year);
		

		// Switch to the CVV frame
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='security_code_iframe']")));
		// Input CVV
		driver.findElement(By.xpath("//input[@placeholder='123']")).sendKeys(cvv);
		

//	   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_number_iframe']")));
//     driver.switchTo();
//	   WebElement cardnumber =  driver.findElement(By.xpath("//input[@placeholder='Enter Card Number Here']"));	    
//	   cardnumber.sendKeys(cardNumber);
//	   driver.switchTo().defaultContent();
//	   
//	   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='name_on_card_iframe']")));
//	   driver.switchTo();
//	   WebElement cardnumbername = driver.findElement(By.xpath("//input[@placeholder='Cardholder Name']"));
//	   cardnumbername.sendKeys(cardHolderName);
//	   driver.switchTo().defaultContent();
//	  
//	   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_exp_month_iframe']")));
//	   driver.switchTo();
//	   WebElement MonthMonth = driver.findElement(By.xpath("//input[@placeholder='MM']"));
//	   MonthMonth.sendKeys(Month);
//	   driver.switchTo().defaultContent();
//	   
//	   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_exp_year_iframe']")));
//	   driver.switchTo();
//	   WebElement YearYear = driver.findElement(By.xpath("//input[@placeholder='YY']"));
//	   YearYear.sendKeys(Year);
	   driver.switchTo().defaultContent();
//	   
//	   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='security_code_iframe']")));
//	   driver.switchTo();
//	   WebElement cvvcvv = driver.findElement(By.xpath("//input[@placeholder='123']"));
//	   cvvcvv.sendKeys(cvv);
//	   driver.switchTo().defaultContent();
	}

	@When("I click the proceed to pay button")
	public void i_click_the_proceed_to_pay_button() throws InterruptedException {
	   WebElement clickproceedtopay = driver.findElement(By.xpath("//div[text()='Proceed to pay']"));
	   clickproceedtopay.click();
	   
	   Thread.sleep(5000);  

	   WebElement proceedtopay = driver.findElement(By.xpath("//button[@id='btnSubmitForm']"));
	   proceedtopay.click();
	   WebElement submitjapan = driver.findElement(By.xpath("//button[@id='enter']"));
	   submitjapan.click();
	   try {
           // Find an element to capture a screenshot of (e.g., a button or some specific part of the page)
			driver.findElement(By.xpath("//h1[contains(text(),'HTTP Status 400 – Bad Request')]"));// Replace with your element's locator

           // Take a screenshot of the element
           File ScreenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

           // Copy the screenshot to a desired location
           FileUtils.copyFile(ScreenShots, new File("D:\\Eclipse\\SpiceJet_Airline\\ScreenShots\\submitunsuccessjapan.png"));

           System.out.println("Screenshot captured and saved successfully.");
       } catch (Exception e) {
           System.out.println("Failed to capture the screenshot: " + e.getMessage());
       }
	   Thread.sleep(3000);
	   driver.quit();
	}

//	@Then("I should see a confirmation message")
//	public void i_should_see_a_confirmation_message() {
//	   
//	   
//	}
//
//	@Then("my ticket should be booked successfully")
//	public void my_ticket_should_be_booked_successfully() {
//	   
//	   
//	}

	

	@When("I enter invalid card details as follows:")
	public void i_enter_invalid_card_details_as_follows(String cardNumber, String Year, String Month, String cvv, String cardHolderName) {
	    
		//Switch to Nested iframe
		   
		   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_number_iframe']")));
	       driver.switchTo();
		   WebElement cardnumber =  driver.findElement(By.xpath("//input[@placeholder='Enter Card Number Here']"));	    
		   cardnumber.sendKeys(cardNumber);
		   driver.switchTo().defaultContent();
		   
		   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='name_on_card_iframe']")));
		   driver.switchTo();
		   WebElement cardnumbername = driver.findElement(By.xpath("//input[@placeholder='Cardholder Name']"));
		   cardnumbername.sendKeys(cardHolderName);
		   driver.switchTo().defaultContent();
		  
		   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_exp_month_iframe']")));
		   driver.switchTo();
		   WebElement MonthMonth = driver.findElement(By.xpath("//input[@placeholder='MM']"));
		   MonthMonth.sendKeys(Month);
		   driver.switchTo().defaultContent();
		   
		   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='card_exp_year_iframe']")));
		   driver.switchTo();
		   WebElement YearYear = driver.findElement(By.xpath("//input[@placeholder='YY']"));
		   YearYear.sendKeys(Year);
		   driver.switchTo().defaultContent();
		   
		   driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='security_code_iframe']")));
		   driver.switchTo();
		   WebElement cvvcvv = driver.findElement(By.xpath("//input[@placeholder='123']"));
		   cvvcvv.sendKeys(cvv);
		   driver.switchTo().defaultContent();
		   
		}
	
//	@Then("I should see an error message indicating the payment has failed")
//	public void i_should_see_an_error_message_indicating_the_payment_has_failed() {
//	   
//	   
//	}
	
	
}