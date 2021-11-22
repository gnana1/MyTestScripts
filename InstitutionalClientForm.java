
package test.java;

import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static test.java.InputValues.*;

/**
 * Project: Gemini
 * Test: InstitutionalClientForm
 * Generated by: Gnana prasanna bheemineni (gnanaprasanna1gp@gmail.com)

 *   The below tests are written in Java in a Maven project
 - The extra packages downloaded are TestNG for running Multiple tests within a single class file and Allure to generate the Test Report
 - Both the packages are downloaded by updating the maven dependencies in POM.xml file
 - Once the Tests are executed the tests report can be generated by using the following command.
 - `allure serve PATH-TO_TEST_RESULTS/allure-results`

 *   The below Class files has 3 Test Cases
 - Happy Path: Form submission with Good data
 - Negative Path : Form Submission with Bad Data
 - Negative Path: Form submission with empty Data

 * */

public class InstitutionalClientForm {

    public static WebDriver driver;

    /** This method will initiate the WebDriver and open a selenium controlled chrome session before every test */
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver= new ChromeDriver();
        driver.get(sandBoxURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /** This method will quit the WebDriver and close the chrome session after running every test */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /** This method navigates from the sandbox Home page to Institutional Client Registration form */
    private void navigatetoClientForm() {

        // Click ‘Create new account’ link
        driver.findElement(By.linkText("Create new account")).click();

        // Click ‘OK’ button to accept cookies
        driver.findElement(By.linkText("OK")).click();

        // Use Javascript executor to navigate to the bottom of the page. The `Create a business account` button will  be displayed once the user scrolls down
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Wait until the captcha spinner is backgrounded for the `Create a business account` link to display
        By loadingImage = By.className("rc-anchor-invisible-text");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));

        //Click ‘Create a business account’ link
        driver.findElement(By.linkText("Create a business account")).click();

        //Verify that the Institutional Client Registration form is displayed successfully
        driver.findElement(By.xpath(("//*[text()='Institutional Client Registration']"))).isDisplayed();
    }

    /** This method Verifies the presence of all UI elements and their valid types on Institutional Client Registration Form */
    private void uiElementsClientForm() {

        // Verify that `Company Information` section is displayed
        driver.findElement(By.xpath(("//*[text()='Company Information']"))).isDisplayed();

        // Verify that `Legal Business Name field Header` is displayed
        driver.findElement(By.xpath(("//*[text()='Legal Business Name']"))).isDisplayed();

        // Verify that `Legal Business Name field` is a text field
        String LegalBusinessNameType = driver.findElement(By.name("company.legalName")).getAttribute("type");
        Assert.assertEquals(LegalBusinessNameType,"text");

        // Verify that `Company Type field Header` is displayed
        driver.findElement(By.xpath(("//*[text()='Company type']"))).isDisplayed();

        // Verify that `Company Type' field is a Dropdown field
        driver.findElement(By.cssSelector(".companyTypeDropdown__value-container.css-1hwfws3")).click();
        //the usual assertion using a `type` attribute is not working here since it is not defined by the developer in the html code
        //Select the first displayed option in the dropdown values
        driver.findElement(By.xpath("//*[text()='Broker-Dealer']")).click();

        // Verify that `Company Location` section is displayed
        driver.findElement(By.xpath(("//*[text()='Company Location']"))).isDisplayed();

        // Verify that `Country of Business field Header` is displayed
        driver.findElement(By.xpath(("//*[text()='Country of Business']"))).isDisplayed();

        // Verify that `Country of Business' field is a Dropdown field
        driver.findElement(By.className("css-1w3e7dh-control")).click();
        //Select United States as the value in the  displayed options
        driver.findElement(By.xpath("//div[. = 'United States']")).click();

        // Verify that `State field Header` is displayed
        driver.findElement(By.xpath(("//*[text()='State']"))).isDisplayed();

        // Verify that `State' field is a Dropdown field
        driver.findElement(By.cssSelector(".usStateDropdown__control.css-1w3e7dh-control")).click();
        driver.findElement(By.xpath("//*[text()='NJ']")).click();

        // Verify that `Personal Information` section is displayed
        driver.findElement(By.xpath(("//*[text()='Personal Information']"))).isDisplayed();

        // Verify that `Legal First Name` is displayed
        driver.findElement(By.xpath(("//*[text()='Legal First Name']"))).isDisplayed();

        // Verify that `Legal First Name' field is a Text field
        String LegalFirstType = driver.findElement(By.name("personal.legalName.firstName")).getAttribute("type");
        Assert.assertEquals(LegalFirstType, "text");

        // Verify that `Middle (Optional) field header` is displayed
        driver.findElement(By.xpath(("//*[text()='Middle (Opt']"))).isDisplayed();

        // Verify that `Middle (Optional)' field is a Text field
        String MiddleType = driver.findElement(By.name("personal.legalName.middleName")).getAttribute("type");
        Assert.assertEquals(MiddleType, "text");

        // Verify that `Legal Last Name field header` is displayed
        driver.findElement(By.xpath(("//*[text()='Legal Last Name']"))).isDisplayed();

        // Verify that `Legal Last Name' field is a Text field
        String LastType = driver.findElement(By.name("personal.legalName.lastName")).getAttribute("type");
        Assert.assertEquals(LastType, "text");

        // Verify that `Your Email Address field header` is displayed
        driver.findElement(By.xpath(("//*[text()='Your Email Address']"))).isDisplayed();

        // Verify that `Your Email Address' field is a email field
        String EmailType = driver.findElement(By.name("personal.email")).getAttribute("type");
        Assert.assertEquals(EmailType, "email");

        // Verify that `Continue` submit button is displayed
        driver.findElement(By.tagName("button")).isDisplayed();

        // Verify that `Continue' field is a submit button field used for submission of the form
        String ContinueType = driver.findElement(By.tagName("button")).getAttribute("type");
        Assert.assertEquals(ContinueType, "submit");

    }

    /** This method Scrolls to the bottom of the page to see Submit button */
    private void ScrollToBottomOfThePage() {

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /** This method Waits until the captcha spinner is backgrounded so that underlying element is clickable */
    private void waitForCaptchaSpinnerToDisappear() {

        By loadingImage = By.className("rc-anchor-invisible-text");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingImage));
    }

    /** This method submits the Institutional Client Registration Form */
    private void submitForm(){

        driver.findElement(By.tagName("button")).click();
    }

    @DisplayName("Client_Form_Happy_Path")
    @Test
    @Description("This test validates that user is able to fill Valid input values in all mandatory fields in the Form and submit successfully without any errors")
    private void Institutional_client_test_001() {

        // Navigate to Institutional Client Registration Form
        navigatetoClientForm();

        // Verify all UI elements and their valid types
        uiElementsClientForm();

        // Take a screenshot of the displayed Form to be stored locally- This can help in verifying the Test Output visually
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(screenshotPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Provide valid values in all displayed fields

        // Provide a valid Legal Business Name
        driver.findElement(By.name("company.legalName")).sendKeys(ValidLegalBusinessName);

        //Select a Company Type from the list of Dropdown options
        driver.findElement(By.cssSelector(".companyTypeDropdown__value-container.css-1hwfws3")).click();
        driver.findElement(By.xpath("//*[text()='Non-Profit Organization']")).click();

        // Select `United States` as Country of Business from the list of Dropdown Options
        driver.findElement(By.className("css-1w3e7dh-control")).click();
        driver.findElement(By.xpath("//div[. = 'United States']")).click();

        // Select a State from the list of Dropdown Options
        driver.findElement(By.cssSelector(".usStateDropdown__control.css-1w3e7dh-control")).click();
        driver.findElement(By.xpath("//*[text()='NJ']")).click();

        // Provide a valid Legal First Name
        driver.findElement(By.name("personal.legalName.firstName")).sendKeys(ValidLegalFirstName);
        // Provide a valid Middle Name
        driver.findElement(By.name("personal.legalName.middleName")).sendKeys(ValidLegalMiddleName);
        // Provide a valid Legal Last Name
        driver.findElement(By.name("personal.legalName.lastName")).sendKeys(ValidLegalLastName);
        // Provide a valid Email Address
        driver.findElement(By.name("personal.email")).sendKeys(ValidEmailAddress);

        ScrollToBottomOfThePage();
        waitForCaptchaSpinnerToDisappear();
        submitForm();

        // Verify that the form is submitted successfully without any errors
        driver.findElement(By.xpath("//*[text()='Thanks for Registering!']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Institutional Account Application']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Non-Profit Account Application']")).isDisplayed();

        // Take a screenshot of the displayed `Submit Success` Form to be stored locally- This can help in verifying the Test Output visually
        File screenshot_submit = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot_submit, new File(screenshotPath_submit));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @DisplayName("Client_Form_Negative_Path_Invalid_Input_Values")
    @Test
    @Description("This test validates that when user fills InValid input values in one of the fields , the form is not submitted and a relevant error message is displayed")
    private void Institutional_client_test_002() {

        // Navigate to Institutional Client Registration Form
        navigatetoClientForm();

        // Provide invalid values in all displayed fields

        // Provide an invalid Legal Business Name. Here sending emojis (☺️☺️) will result in a Compliance Error.
        driver.findElement(By.name("company.legalName")).sendKeys(InvalidLegalBusinessName);

        waitForCaptchaSpinnerToDisappear();
        //Select a Company Type from the list of Dropdown options
        driver.findElement(By.cssSelector(".companyTypeDropdown__value-container.css-1hwfws3")).click();
        driver.findElement(By.xpath("//*[text()='Broker-Dealer']")).click();
        // Select `United States` as Country of Business from the list of Dropdown Options
        driver.findElement(By.className("css-1w3e7dh-control")).click();
        driver.findElement(By.xpath("//div[. = 'United States']")).click();
        // Select a State from the list of Dropdown Options
        driver.findElement(By.cssSelector(".usStateDropdown__control.css-1w3e7dh-control")).click();
        driver.findElement(By.xpath("//*[text()='AL']")).click();

        // Provide an Invalid Legal First Name
        driver.findElement(By.name("personal.legalName.firstName")).sendKeys(InvalidLegalFirstName);
        // Provide an Invalid Middle Name
        driver.findElement(By.name("personal.legalName.middleName")).sendKeys(InvalidLegalMiddleName);
        // Provide a Invalid Legal Last Name
        driver.findElement(By.name("personal.legalName.lastName")).sendKeys(InvalidLegalLastName);
        // Provide a Invalid Email Address
        driver.findElement(By.name("personal.email")).sendKeys(InvalidEmailAddress);

        ScrollToBottomOfThePage();
        waitForCaptchaSpinnerToDisappear();
        submitForm();

        String currentUrl = driver.getCurrentUrl();
        // Verify that the form is not submitted and user is still on the same page.
        Assert.assertEquals(currentUrl,"https://exchange.sandbox.gemini.com/register/institution");

        // Verify that the relevant compliance error is displayed in the page
        driver.findElement(By.xpath("//*[text()='For compliance reasons, please enter your business name in English characters.']")).isDisplayed();

        // Provide a Valid Legal Business Name
        driver.findElement(By.name("company.legalName")).clear();
        driver.findElement(By.name("company.legalName")).sendKeys(ValidLegalBusinessName);

        ScrollToBottomOfThePage();
        waitForCaptchaSpinnerToDisappear();
        submitForm();

        // Verify that the form is not submitted and user is still on the same page.
        Assert.assertEquals(currentUrl,"https://exchange.sandbox.gemini.com/register/institution");

        // Verify that the relevant error is displayed in the page
        driver.findElement(By.xpath("//*[text()='Legal First Name is required.']")).isDisplayed();

        // Provide a valid Legal First Name
        driver.findElement(By.name("personal.legalName.firstName")).clear();
        driver.findElement(By.name("personal.legalName.firstName")).sendKeys(ValidLegalFirstName);

        ScrollToBottomOfThePage();
        waitForCaptchaSpinnerToDisappear();
        submitForm();

        // Verify that the form is not submitted and user is still on the same page.
        Assert.assertEquals(currentUrl,"https://exchange.sandbox.gemini.com/register/institution");

        // Verify that the relevant error is displayed in the page
        driver.findElement(By.xpath("//*[text()='Legal Last Name is required.']")).isDisplayed();

        // Provide a valid Legal Last Name
        driver.findElement(By.name("personal.legalName.lastName")).clear();
        driver.findElement(By.name("personal.legalName.lastName")).sendKeys(ValidLegalLastName);

        ScrollToBottomOfThePage();
        waitForCaptchaSpinnerToDisappear();
        submitForm();

        // Verify that the form is not submitted and user is still on the same page.
        Assert.assertEquals(currentUrl,"https://exchange.sandbox.gemini.com/register/institution");

        // Verify that the relevant error is displayed in the page
        driver.findElement(By.xpath("//*[text()='Please specify a valid email domain.']")).isDisplayed();


    }
    @DisplayName("Client_Form_Negative_Path_Empty_Input_Values")
    @Test
    @Description("This test validates that when user fills InValid input values in one of the fields , the form is not submitted and a relevant error message is displayed")
    private void Institutional_client_test_003() {

        // Navigate to Institutional Client Registration Form
        navigatetoClientForm();

        ScrollToBottomOfThePage();
        waitForCaptchaSpinnerToDisappear();
        submitForm();

        String currentUrl = driver.getCurrentUrl();
        // Verify that the form is not submitted and user is still on the same page.
        Assert.assertEquals(currentUrl,"https://exchange.sandbox.gemini.com/register/institution");

        // Verify that the relevant error is displayed in the page

        driver.findElement(By.xpath("//*[text()='Legal Business Name is required.']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Company type is required.']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='First name is required.']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Last name is required.']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Please enter a valid email address.']")).isDisplayed();
        driver.findElement(By.xpath("//*[text()='Company state is required.']")).isDisplayed();

    }

}