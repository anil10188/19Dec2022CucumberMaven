package stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.qa.nopcommerce.pageObject.AdminPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base {

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() throws Exception {
		 //System.setProperty("webdriver.chrome.driver","D:\\Automation Setup\\Browser Drivers\\chromedriver_win32_v111\\chromedriver.exe");
		 //driver = new ChromeDriver();

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		driver = new ChromeDriver(chromeOptions);
		Thread.sleep(2000);
		ad = new AdminPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
		ad.setUsernmae(email);
		ad.setPassword(password);
		Thread.sleep(2000);
	}

	@When("Click on Login")
	public void click_on_login() throws Exception {
		ad.clickLogin();
		Thread.sleep(2000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) throws Exception {
		Assert.assertEquals(title, driver.getTitle());
		Thread.sleep(2000);
	}

	@Then("Close browser")
	public void close_browser() throws Exception {

		driver.close();
		Thread.sleep(2000);

	}

}
