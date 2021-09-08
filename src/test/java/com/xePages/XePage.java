package com.xePages;

import com.xeBaseTest.XeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XePage {

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement txtamountFeild;

    @FindBy(xpath = "//input[@id='midmarketFromCurrency']")
    private WebElement dpocurrencyFrom;

    XeTest base = new XeTest();

    public WebElement selectFrom(String val) throws Throwable {
        Thread.sleep(1000);
        return base.getDriver().findElement(By.xpath("//span[contains(text(),'" + val + "')]"));
    }
    // span[contains(text(),'US Dollar')]

    @FindBy(xpath = "//div[@id='midmarketToCurrency-descriptiveText']")
    private WebElement dpocurrencyTo;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnConverter;

    @FindBy(xpath = "//button[contains(text(),'Accept')]")
    private WebElement btnAccept;

    @FindBy(xpath = "//button[@aria-label='close']")
    private WebElement btnClosepopUP;

    @FindBy(xpath = "//input[@id='midmarketToCurrency']/following::p[1]")
    private WebElement lblFromResultCurrency;
    @FindBy(xpath = "//input[@id='midmarketToCurrency']/following::p[2]")
    private WebElement lblToResultCurrency;



    public XePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void enterAmount() {
        txtamountFeild.sendKeys("1000");
    }

    public void btnAccept() {
        btnAccept.click();
    }

    public void btnClosepopUP() {
        waiter(btnClosepopUP);
        btnClosepopUP.click();
    }

    public void waiter(WebElement element) {
        WebDriverWait wait = new WebDriverWait(base.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void currencyFrom(String option) throws Throwable {

        waiter(dpocurrencyFrom);
        dpocurrencyFrom.click();
        waiter(selectFrom(option));
        selectFrom(option).click();
    }

    public void currencyTo(String option) throws Throwable {
        waiter(dpocurrencyTo);
        dpocurrencyTo.click();
        waiter(selectFrom(option));
        selectFrom(option).click();

    }

    public void coverterSubmit() {
        btnConverter.click();
    }

    public void acceptCookiesSubmit() {
        btnAccept.click();
    }

    public String lblFromResultCurrency() throws InterruptedException {

        //waiter(lblFromResultCurrency);
        Thread.sleep(2000);
        System.out.println("Values from system " + lblFromResultCurrency.getText());
       return lblFromResultCurrency.getText();

    }

    public String lblToResultCurrency(){

        System.out.println("Values from system " + lblToResultCurrency.getText());
        return lblToResultCurrency.getText();

    }
}
