package Step_Def;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Signup_Step_Def {
	WebDriver driver;

	@Given("I am on the SpiceJet sign-up page")
	public void i_am_on_the_spice_jet_sign_up_page() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		String HomepageTitle =driver.getTitle();
		System.out.println(HomepageTitle);
		WebElement ClickSignupbutton=  driver.findElement(By.xpath("//div[contains(text(),'Signup')]"));
		ClickSignupbutton.click();
	}

	@When("I enter a valid email address")
	public void i_enter_a_valid_email_address() {
		//Next page forward for Acc Registration
		//A. New Window Open 

		String mainwindow= driver.getWindowHandle();
		for (String newwindow : driver.getWindowHandles()) {
			if (!newwindow.equals(mainwindow)) {
				driver.switchTo().window(newwindow);

				WebElement emailid = driver.findElement(By.xpath("//input[@id='email_id']"));
				emailid.sendKeys("devanandh2902@gmail.com");				
			}
		}
	}

	@And("I enter a valid password")
	public void i_enter_a_valid_password() {

		WebElement password =driver.findElement(By.xpath("//input[@id='new-password']"));
		password.sendKeys("Batman12@#");
	}

	@And("I confirm the password")
	public void i_confirm_the_password() {
		WebElement confirmpassword =driver.findElement(By.xpath("//input[@id='c-password']"));
		confirmpassword.sendKeys("Batman12@#");
		confirmpassword.click();
	}

	@And("I provide other required details")
	public void i_provide_other_required_details() {

		//B.Select dropdown Mr title
		Actions actions = new Actions(driver);
		By Title = By.xpath("//select[@class='form-control form-select ']");
		WebElement optiondropdown = driver.findElement(Title);
		actions.click(optiondropdown);
		Select select = new Select(optiondropdown);
		select.selectByValue("MR");

		//C. First name and Last name
		WebElement firstname = driver.findElement(By.id("first_name"));
		firstname.sendKeys("Muruganandh");
		WebElement lastname = driver.findElement(By.id("last_name"));
		lastname.sendKeys("Srinivasan");

		//D. Select dropdown country
		By country = By.xpath("//select[@class='form-control form-select']");
		WebElement countrydropdown = driver.findElement(country);
		Select select2 = new Select(countrydropdown);
		select2.selectByValue("IN");

		//E. Send keys DOB
		WebElement DOB = driver.findElement(By.xpath("//input[@id='dobDate']"));
		DOB.sendKeys("02/29/1996");
		DOB.click();

		//F. Send Phone number and emailid and password twotimes and click dialog box

		WebElement phnnum = driver.findElement(By.xpath("//input[@placeholder='+91 01234 56789']"));
		phnnum.sendKeys("9566259258");
		phnnum.click();
	}

	@And("I click the sign-up button")
	public void i_click_the_sign_up_button() {

		WebElement dialogboxclick = driver.findElement(By.xpath("(//input[@id='defaultCheck1'])[1]"));
		dialogboxclick.click();

		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	}

	@And("I should be successfully registered")
	public void i_should_be_successfully_registered() {

		WebElement AccNameforverify = driver.findElement(By.xpath("//div[@class='d-none d-lg-block hello']"));
		String verifyAccReg = AccNameforverify.getText();
		System.out.println(verifyAccReg);
	}

	@Then("Browser closed")
	public void browser_closed() {

		driver.close();
	}


	@Given("I am in the SpiceJet sign-up page")
	public void i_am_in_the_spice_jet_sign_up_page() {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("http://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);
		String HomepageTitle =driver.getTitle();
		System.out.println(HomepageTitle);
		WebElement ClickSignupbutton=  driver.findElement(By.xpath("//div[contains(text(),'Signup')]"));
		ClickSignupbutton.click();
	}
	@When("I enter an invalid email address")
	public void i_enter_an_invalid_email_address() {

		//Next page forward for Acc Registration
				//A. New Window Open 

				String mainwindow= driver.getWindowHandle();
				for (String newwindow : driver.getWindowHandles()) {
					if (!newwindow.equals(mainwindow)) {
						driver.switchTo().window(newwindow);

						WebElement emailid = driver.findElement(By.xpath("//input[@id='email_id']"));
						emailid.sendKeys("DEVADEVA@gmail.com");				
					}
				}
	}

	@And("I enter a invalid password")
	public void i_enter_a_invalid_password() {
		
		WebElement password =driver.findElement(By.xpath("//input[@id='new-password']"));
		password.sendKeys("Batman12@#");	
	}

	@And("I conform the password")
	public void i_conform_the_password() {
		WebElement confirmpassword =driver.findElement(By.xpath("//input[@id='c-password']"));
		confirmpassword.sendKeys("Batman12@#");
		confirmpassword.click();
	}
	
	@And("I give other required details invalid")
	public void i_give_other_required_details_invalid() {
		//B.Select dropdown Mr title
		Actions actions = new Actions(driver);
		By Title = By.xpath("//select[@class='form-control form-select ']");
		WebElement optiondropdown = driver.findElement(Title);
		actions.click(optiondropdown);
		Select select = new Select(optiondropdown);
		select.selectByValue("MR");

		//C. First name and Last name
		WebElement firstname = driver.findElement(By.id("first_name"));
		firstname.sendKeys("Muruganandh");
		WebElement lastname = driver.findElement(By.id("last_name"));
		lastname.sendKeys("Srinivasan");

		//D. Select dropdown country
		By country = By.xpath("//select[@class='form-control form-select']");
		WebElement countrydropdown = driver.findElement(country);
		Select select2 = new Select(countrydropdown);
		select2.selectByValue("IN");

		//E. Send keys DOB
		WebElement DOB = driver.findElement(By.xpath("//input[@id='dobDate']"));
		DOB.sendKeys("02/29/1996");
		DOB.click();

		//F. Send Phone number and emailid and password twotimes and click dialog box

		WebElement phnnum = driver.findElement(By.xpath("//input[@placeholder='+91 01234 56789']"));
		phnnum.sendKeys("9566259258");
		phnnum.click();
	}

	@And("I click the sign-up")
	public void i_click_the_sign_up() {

		WebElement dialogboxclick = driver.findElement(By.xpath("(//input[@id='defaultCheck1'])[1]"));
		dialogboxclick.click();

		driver.findElement(By.xpath("//button[text()='Submit']")).click();

	}

	@And("I should see an error message")
	public void i_should_see_an_error_message() {
	
		WebElement Error = driver.findElement(By.xpath("//div[contains(text(),'Member account exists with given email ID')]"));
		String errormessage = Error.getText();
		System.out.println(errormessage);
	}
	
	@Then("Browser was closed")
	public void browser_was_closed() {

		driver.close();
	}
}