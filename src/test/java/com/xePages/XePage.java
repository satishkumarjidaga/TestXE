package com.xePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class XePage {

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement txtamountFeild;

    @FindBy(xpath = "//button[@id='midmarketFromCurrency']")
    private WebElement dpocurrencyFrom;

    @FindBy(xpath = "//div[@id='midmarketToCurrency-descriptiveText']")
    private WebElement dpocurrencyTo;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnConverter;

    @FindBy(xpath = "//button[contains(text(),'Accept')]")
    private WebElement btnAccept;

    public XePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void enterAmount() {
        txtamountFeild.sendKeys("1000");
    }

    public void btnAccept() {
        btnAccept.click();
    }

    public void currencyFrom(String arg1) {


   dpocurrencyFrom.sendKeys(arg1);
      dpocurrencyFrom.sendKeys(Keys.ENTER);
//        Select select = new Select(dpocurrencyFrom);
//        select.selectByVisibleText(arg1);

    }

    public void currencyTo(String arg1) {
        Select select = new Select(dpocurrencyTo);
        select.selectByVisibleText(arg1);

    }

    public void coverterSubmit(){
        btnConverter.click();
    }


    public void acceptCookiesSubmit(){
        btnAccept.click();
    }
}
