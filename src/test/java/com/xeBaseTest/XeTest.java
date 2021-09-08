package com.xeBaseTest;

import com.test.commonuties.ConfigFileReader;
import com.xePages.XePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XeTest {
    public static WebDriver driver;
    public static String userDir = System.getProperty("user.dir");



    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }

        System.setProperty("webdriver.chrome.driver", userDir + "/Driver&Jars/chromedriver");
        driver = new ChromeDriver();
        XePage test = new XePage(driver);
        return driver;
    }

    public void getUrl(String url) {
        getDriver().get(url);

    }

}