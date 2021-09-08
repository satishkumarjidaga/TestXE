package com.xeAcceptance;

import com.xeBaseTest.XeTest;
import com.xePages.XePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.test.commonuties.ConfigFileReader;
import org.testng.annotations.BeforeClass;

public class XEAcceptanceTest extends XeTest {
	private XePage xePage;
	private XeTest xeTest;
	ConfigFileReader config = new ConfigFileReader();
	String url = config.getConfigvalue("currencyconverterURL");

	@BeforeClass
	public void setUp() {
		getUrl(url);

	}

	@Test
	public void currencyConverter() throws Throwable {
		xePage = new XePage(getDriver());
		Thread.sleep(5000);
		xePage.btnAccept();
		Thread.sleep(5000);
		xePage.enterAmount();
		xePage.btnClosepopUP();
		String[] elements = { "US Dollar", "Euro", "British Pound", "Indian Rupee","Australian Dollar" };

		for (int i = 0; i <= elements.length - 1; i++) {

			xePage.currencyFrom(elements[i]);
			Thread.sleep(1000);
//			xePage.currencyFrom("EUR – Euro");

			if(i==0) {
				xePage.coverterSubmit();
			}


			Assert.assertTrue(xePage.lblFromResultCurrency().contains(elements[i]));
			Assert.assertTrue(xePage.lblToResultCurrency().contains("Euro"));
		}

	}
	@AfterTest

	public void closeBrowser(){

		driver.quit();
	}
}


