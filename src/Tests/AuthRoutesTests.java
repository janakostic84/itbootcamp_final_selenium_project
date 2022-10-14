package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

	@Test(priority=1)
	public void forbidsVisitsToHomeUrlIfNotAuthenticated() {

		driver.get(baseUrl + "/home");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should end with /login");
	
	}
	
	@Test(priority=2)
	public void forbidsVisitsToProfileUrlIfNotAuthenticated() {

		driver.get(baseUrl + "/profile");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should end with /login");
	}
	
	@Test(priority=3)
	public void  forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

		driver.get(baseUrl + "/admin/cities");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should end with /login");
	}
	
	@Test(priority=4)
	public void  forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {

		driver.get(baseUrl + "/admin/users");
		
		Assert.assertTrue(
				driver.getCurrentUrl().endsWith("/login"),
				"ERROR: Url should end with /login");
	}

}
