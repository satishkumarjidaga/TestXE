package com.xeBaseTest;

import com.test.commonuties.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XeTest {
    private WebDriver driver;
    String userDir = System.getProperty("user.dir");


    protected WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }

        System.setProperty("webdriver.chrome.driver", userDir + "/Driver&Jars/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }

    public void getUrl(String url) {
        getDriver().get(url);

    }

}