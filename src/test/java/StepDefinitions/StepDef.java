package StepDefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import POM_Pages.HomePage;
import POM_Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	private static WebDriver dvr;
	private static HomePage home;
	private static LoginPage log;
	
	@Before
	public void setUp() {
		String URL = "https://www.keka.com/";
		ChromeOptions opt = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("profile.default_content_setting_values.notifications", 2);
		opt.setExperimentalOption("prefs", prefs);
		opt.addArguments("chrome.switches", "--disable-extensions");
		opt.addArguments("--disable-save-password");
		opt.addArguments("disable-infobars");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\dell 7570\\OneDrive\\Documents\\Suren\\Java\\Work_Space\\kekaportallogin\\src\\main\\resources\\chromedriver.exe");

		dvr = new ChromeDriver(opt);
		dvr.manage().window().maximize();
		dvr.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		dvr.get(URL);

	}
	
	@After
	public void tearDown() {
		dvr.quit();
	}

	@Given("I am loging into keka portal with {string} and {string}")
	public void i_am_loging_into_keka_portal_with_and(String string, String string2) {
		home = new HomePage(dvr);
	    log = new LoginPage(dvr);
	    log.clickLoginBtn();
	    log.inputEmailField(string);
	    log.clickkoginKekaBtn();
	    log.inputPasswordFiled(string2);
	    log.clickSubmitBtn();
	}

	@When("I press the clock-in button in home page")
	public void i_press_the_clock_in_button_in_home_page() {
	    home.clickClockInBtn();
	}

	@Then("I should be clocked-in for the day")
	public void i_should_be_clocked_in_for_the_day() {
	    home.verfiyClockIn();
	}


	@Then("logout from the keka portal")
	public void logout_from_the_keka_portal() {
	    home.clickLogoutBtn();
	}
	
	@When("I press the clock-out button in home page")
	public void i_press_the_clock_out_button_in_home_page() {
		home.clickClockOutBtn();
		home.clickClockOutBtn();
	}

	@Then("I should be clocked-out for the day")
	public void i_should_be_clocked_out_for_the_day() {
	   home.verifyClockOut();
	}

}
