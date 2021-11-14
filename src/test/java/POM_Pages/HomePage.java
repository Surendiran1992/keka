package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	private static WebDriver dvr;
	private static WebElement element;
	private static final String CLOCK_IN_BTN="//button[text()='Web Clock-In']";
	private static final String CLOCK_OUT_BTN="//button[text()='Clock-out']";
	private static final String CURRENT_TIME="//div[@class='d-flex align-items-center w-100 justify-content-between']/div";
	private static final String PROFILE_PIC="//img[@class='profile-picture']";
	private static final String LOGOUT_BTN="//a[@routerlink='/logout']";
	private static WebDriverWait wait;
	
	public HomePage(WebDriver dvr) {
		HomePage.dvr= dvr;
	}
	public void clickClockInBtn() {
		element= dvr.findElement(By.xpath(CLOCK_IN_BTN));
		element.isEnabled();
		element.click();
	}
	
	public void clickClockOutBtn() {
		element= dvr.findElement(By.xpath(CLOCK_OUT_BTN));
		element.isEnabled();
		element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public String whatIsCurrentTime() {
		String currentTime= dvr.findElement(By.xpath(CURRENT_TIME)).getText();
		return currentTime;
	}
	
	public void clickLogoutBtn() {
		dvr.findElement(By.xpath(PROFILE_PIC)).click();
		element = dvr.findElement(By.xpath(LOGOUT_BTN));
		element.isEnabled();
		element.click();
	}
	
	public void handlingPopUp() {
		dvr.switchTo().alert().dismiss();
	}
	public void verfiyClockIn() {
		wait = new WebDriverWait(dvr, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(CLOCK_IN_BTN)));
		 System.out.println("\n"+"\n"+"\n"+"-------------------------------------"+"\n"+
				    "YOU ARE SUCCESSFULLY LOGGED IN TODAY"+"\n"+"--------------------------------"+
				    "\n"+"\n"+"\n");
	}
	public void verifyClockOut() {
		wait = new WebDriverWait(dvr, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CLOCK_IN_BTN)));
		 System.out.println("\n"+"\n"+"\n"+"-------------------------------------"+"\n"+
				    "YOU ARE SUCCESSFULLY LOGGED OUT TODAY"+"\n"+"--------------------------------"+
				    "\n"+"\n"+"\n");
	}
}
