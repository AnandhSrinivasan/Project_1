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


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login_Step_Def {
	
	public static WebDriver driver ;


	@Given("the user is on the SpiceJet login page")
	public void the_user_is_on_the_spice_jet_login_page() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		System.out.println(driver.getTitle());
	}

	@When("the user click the login button")
	public void the_user_click_the_login_button() {
	WebElement loginbutton = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
	loginbutton.click();
		
	}

	@And("the user enters valid mailid {string} and password {string}")
	public void the_user_enters_valid_mailid_and_password(String string, String string2) throws InterruptedException {
		
		WebElement emailidbutton = driver.findElement(By.xpath("//div[text()='Email']"));
		emailidbutton.click();
		WebElement enteremail =driver.findElement(By.xpath("//input[@type='email']"));
	    enteremail.sendKeys("devanandh2902@gmail.com");
	    Thread.sleep(3000);
	    WebElement enterpassword =driver.findElement(By.xpath("//input[@data-testid='password-input-box-cta']"));
	    enterpassword.sendKeys("Batman12@#");
	    
	}

	@And("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		
		driver.findElement(By.xpath("//div[@data-testid='login-cta']")).click();
	}

	@Then("the user should be successfully logged in")
	public void the_user_should_be_successfully_logged_in() throws InterruptedException {
		
		try {
            // Find an element to capture a screenshot of (e.g., a button or some specific part of the page)
            driver.findElement(By.xpath("//div[text()='Hi Muruganandh']")); // Replace with your element's locator

            // Take a screenshot of the element
            File ScreenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // Copy the screenshot to a desired location
            FileUtils.copyFile(ScreenShots, new File("D:\\Eclipse\\SpiceJet_Airline\\ScreenShots\\Loginokscreenshot.png"));

            System.out.println("Screenshot captured and saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to capture the screenshot: " + e.getMessage());
        }
		WebElement getaccname = driver.findElement(By.xpath("//div[text()='Hi Muruganandh']"));
		String accnameverify = getaccname.getText();
		System.out.println(accnameverify);
		Thread.sleep(3000);
		driver.quit();
	}

	@And("the user enters invalid emailid {string} and password {string}")
	public void the_user_enters_invalid_emailid_and_password(String string, String string2) throws InterruptedException {
		
		WebElement emailidbutton = driver.findElement(By.xpath("//div[text()='Email']"));
		emailidbutton.click();
		WebElement enteremail =driver.findElement(By.xpath("//input[@type='email']"));
	    enteremail.sendKeys("deva@gmail.com");
	    Thread.sleep(3000);
	    WebElement enterpassword =driver.findElement(By.xpath("//input[@data-testid='password-input-box-cta']"));
	    enterpassword.sendKeys("Batman");
	    
	}

	@Then("the user should see an error message")
	public void the_user_should_see_an_error_message() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@data-testid='login-cta']")).click();
		try {
            // Find an element to capture a screenshot of (e.g., a button or some specific part of the page)
			driver.findElement(By.xpath("//div[contains(text(),'Please try again or signup as a new user')]")); // Replace with your element's locator

            // Take a screenshot of the element
            File ScreenShots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            // Copy the screenshot to a desired location
            FileUtils.copyFile(ScreenShots, new File("D:\\Eclipse\\SpiceJet_Airline\\ScreenShots\\LoginFailscreenshot.png"));

            System.out.println("Screenshot captured and saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to capture the screenshot: " + e.getMessage());
        }

		try {
			WebElement errormessage = driver.findElement(By.xpath("//div[contains(text(),'Please try again or signup as a new user')]"));
			String errormessageverify =errormessage.getText();
			System.out.println(errormessageverify);
			Thread.sleep(5000);
		} catch (Exception e) {
			driver.quit();
		}
		
	}

}