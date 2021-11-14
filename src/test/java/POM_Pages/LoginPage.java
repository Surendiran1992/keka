package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static final String LOGIN_BUTTON = "//a[text()='login']";
	private static final String LOGIN_KEKA_BUTTON = "//button[@title='Login with Keka Password']";
	private static final String EMAIL_FIELD ="//input[@id='email']";
	private static final String PASSWORD_FIELD ="//input[@id='password']";
	private static final String SUBMIT_BUTTON = "//button[@type='submit']";
	private static WebDriver dvr;
	private static WebElement element;
	
	public LoginPage(WebDriver dvr) {
		LoginPage.dvr=dvr;
	}
	public void clickLoginBtn() {
		element= dvr.findElement(By.xpath(LOGIN_BUTTON));
		element.isDisplayed();
		element.click();
	}
	
	public void clickkoginKekaBtn() {
		element= dvr.findElement(By.xpath(LOGIN_KEKA_BUTTON));
		element.isDisplayed();
		element.click();
	}
	public void inputEmailField(String email) {
		element= dvr.findElement(By.xpath(EMAIL_FIELD));
		element.isDisplayed();
		element.sendKeys(email);
		dvr.findElement(By.xpath(SUBMIT_BUTTON)).click();
	}
	public void inputPasswordFiled(String password) {
		element= dvr.findElement(By.xpath(PASSWORD_FIELD));
		element.isDisplayed();
		element.sendKeys(password);
	}
	public void clickSubmitBtn() {
		element= dvr.findElement(By.xpath(SUBMIT_BUTTON));
		element.isDisplayed();
		element.click();
	}
	
}
