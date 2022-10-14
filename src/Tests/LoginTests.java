package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
	
	@Test(priority=1)
	public void visitTheLoginPage() {

		navPage.getChooseALanguageBtn().click();
		navPage.getEnLang().click();
		navPage.getLoginBtn().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should contain /login.");
	}
	
	@Test(priority=2)
	public void checkInputTypes() {

		navPage.getLoginBtn().click();
		Assert.assertEquals(
				loginPage.getEmailInput().getAttribute("type"), 
				"email",
				"ERROR: Input type should be email");
		
		Assert.assertEquals(
				loginPage.getPasswordInput().getAttribute("type"), 
				"password",
				"ERROR: Input type should be password");
	}
	
	@Test(priority=3)
	public void displaysErrorsWhenUserDoesNotExist() {

		navPage.getLoginBtn().click();
		
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginBtn().click();
		
		messagePopUpPage.waitForPopUpVisibility();
		
		Assert.assertTrue(
				messagePopUpPage.getElementsWithTextMessages()
				.getText()
				.equals("User does not exists"),
				"ERROR: Message should be User does not exist.");
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should contain /login.");
			
	}
	
	@Test(priority=4)
	public void displaysErrorsWhenPasswordIsWrong() {

		navPage.getLoginBtn().click();
		
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginBtn().click();
		
		messagePopUpPage.waitForPopUpVisibility();
		
		Assert.assertTrue(
				messagePopUpPage.getElementsWithTextMessages()
				.getText()
				.equals("Wrong password"),
				"ERROR: Message should be Wrong password");
		
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/login"),
				"ERROR: Url should contain /login.");
			
	}
	
	@Test(priority=5)
	public void  login() throws InterruptedException {

		navPage.getLoginBtn().click();
		
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginBtn().click();
		Thread.sleep(1000);
		Assert.assertTrue(
				driver.getCurrentUrl().contains("/home"),
				"ERROR: Url should contain /home.");
	}
	
	@Test(priority=6)
	public void logout() {

		Assert.assertTrue(
				navPage.getLogoutBtn().isDisplayed(),
				"ERROR: Logout button is not displayed.");
		navPage.getLogoutBtn().click();
		
		

	}
}