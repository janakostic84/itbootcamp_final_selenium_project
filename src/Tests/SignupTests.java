package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {
	
	@Test(priority=1)
	public void visitsTheSignupPage() {

		navPage.getSignUpBtn().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/signup"),
				"ERROR: Url should contain /signup.");
	}
	
	@Test(priority=2)
	public void checksInputTypes() {

		navPage.getSignUpBtn().click();
		
		Assert.assertEquals(
				signupPage.getEmailInput().getAttribute("type"), 
				"email",
				"ERROR: Input type should be email");
		
		Assert.assertEquals(
				signupPage.getPasswordInput().getAttribute("type"), 
				"password",
				"ERROR: Input type should be password");
		
		Assert.assertEquals(
				signupPage.getPasswordInput().getAttribute("type"), 
				"password",
				"ERROR: Input type should be password");
	}
	
	@Test(priority=3)
	public void displaysErrorsWhenUserAlreadyExists() {

		navPage.getSignUpBtn().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/signup"),
				"ERROR: Url should contain /signup.");
		
		signupPage.getUserNameInput().sendKeys("Another User");
		signupPage.getEmailInput().sendKeys("admin@admin.com");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpBtn().click();
		
		messagePopUpPage.waitForPopUpVisibility();
		
		Assert.assertTrue(
				messagePopUpPage.getElementsWithTextMessages()
				.getText()
				.equals("E-mail already exists"),
				"ERROR: Message should be E-mail already exists");
	}
	
	@Test(priority=4)
	public void signup() throws InterruptedException {

		navPage.getSignUpBtn().click();
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/signup"),
				"ERROR: Url should contain /signup.");
		
		signupPage.getUserNameInput().sendKeys("Pera Peric");
		signupPage.getEmailInput().sendKeys("pera.peric@itbootcamp.rs");
		signupPage.getPasswordInput().sendKeys("12345");
		signupPage.getConfirmPasswordInput().sendKeys("12345");
		signupPage.getSignMeUpBtn().click();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(
				messagePopUpPage.getVerifyYourAccountMsg().getText().equals("IMPORTANT: Verify your account"),
				"ERROR: Wrong message.");
		
		messagePopUpPage.getCloseBtn().click();
		navPage.getLogoutBtn().click();

	}

}
