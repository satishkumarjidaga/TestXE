package com.xeTests;

import com.xeBaseTest.XeTest;
import com.xePages.XePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.test.commonuties.ConfigFileReader;
import org.testng.annotations.BeforeClass;


public class exTest extends XeTest {
	private XePage xePage;
	private XeTest xeTest;
	ConfigFileReader config = new ConfigFileReader();
	String url = config.getConfigvalue("currencyconverterURL");
	@BeforeClass
	public void setUp() {
		getUrl(url);

	}

	@Test
	public void goToPortal() throws InterruptedException {
		xePage = new XePage(getDriver());
		//xePage.currencyFrom("EUR – Euro");
		Thread.sleep(5000);


		xePage.btnAccept();
		Thread.sleep(5000);
		xePage.enterAmount();
		xePage.btnClosepopUP();
		xePage.currencyFrom("EUR – Euro");
		//xePage.currencyFrom("USD - US Dollar");
		xePage.currencyTo("USD – US Dollar");
		xePage.coverterSubmit();
	}
}

//	@Test
//	public void currencyTest() throws InterruptedException {
//		//test = new XePage(driver);
//
//		Thread.sleep(5000);
//
//		WebElement cookiesButton = driver.findElement(By.xpath("//button[contains(text(),'Accept')]"));
//
//		cookiesButton.click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("100");
//		//xePage.enterAmount();
//		test.currencyFrom("EUR – Euro");
//		//xePage.currencyFrom("USD - US Dollar");
//		test.currencyTo("USD – US Dollar");
//		test.coverterSubmit();
//
//		driver.quit();
//
//	}
