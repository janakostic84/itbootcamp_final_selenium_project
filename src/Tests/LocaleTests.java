package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {
	
	@Test(priority=1)
	public void setLocaleToES() {

		navPage.getChooseALanguageBtn().click();
		navPage.getEsLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Página de aterrizaje"),
				"ERROR: Header should be Página de aterrizaje");
	}
	
	@Test(priority=2)
	public void setLocaleToEN() {

		navPage.getChooseALanguageBtn().click();
		navPage.getEnLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Landing"),
				"ERROR: Header should be Landing");
	}
	
	@Test(priority=3)
	public void setLocaleToCN() {

		navPage.getChooseALanguageBtn().click();
		navPage.getCnLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("首页"),
				"ERROR: Header should be 首页");
	}
	
	@Test(priority=4)
	public void setLocaleToFR() {

		navPage.getChooseALanguageBtn().click();
		navPage.getFrLang().click();
		
		Assert.assertTrue(
				navPage.getHeaderFromWelcomePage().getText().equals("Page d'atterrissage"),
				"ERROR: Header should be Page d'atterrissage");
	}

}
