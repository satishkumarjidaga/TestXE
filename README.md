# TestXESelenium-Java-TestNG Framework
A Maven framework in which to build Selenium tests written in Java with extended reports of test results.

Project is to test for 5 iteration of currency converter with assert

Getting Started
Copy the repo into your local machine.

Run tests locally
Right click the testng file and select "Run" or "Debug" to start the test.

Run tests through the commandline
As this project uses Maven, we can invoke the tests using Maven goals.
To run the test, use your CI or point Maven to the project and use the goals:
clean install site

Defining the browser
By default, the project will default to ChromeLocal (running a local Chrome instance).

Browser type
System property value

chrome version : 93

Chrome (Local)
ChromeLocal


Chrome (Remote)
ChromeRemote


Writing tests
To write tests, you can call any Webdriver methods by calling:
DriverManager.getDriver()
This will allow you access all the available methods to all Webdrivers as outlined by the W3C standard.

Info
Log.Info("This is an info level message");


Reporting
The default reporting provided by the framework is extend report.

Built With

Selenium - Browser automation framework

Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns. In Page Factory, testers use @FindBy annotation. The initElements method is used to initialize web elements.
@FindBy: An annotation used in Page Factory to locate and declare web elements using different locators

Maven - Dependency management

TestNG - Testing framework

Allure - Reporting framework

WebDriverManager - Local driver binary management

