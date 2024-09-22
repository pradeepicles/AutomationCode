package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void webDriverSetUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        driver = new ChromeDriver(chromeOptions);//Initialize ChromeDriver
        driver.get("https://www.entrata.com/a");//Opening link in Chrome Browser
        driver.manage().window().maximize();// Maximize Window
        WebElement cookiesDecline = driver.findElement(By.id("cookie-decline"));// Example of Storing Webelement
        //Explicit Wait with expectedConditions of Visibility of WebELement.
        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOf(cookiesDecline));
        cookiesDecline.click();// Clicking on Element.
    }

    public void clickOnElement(By locator) {
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        }
    }

    public void enterTextInElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public void selectDropDownValueByIndex(By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public void scrollDownToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
    }

    public List<WebElement> getListOfWebElements(By loctor) {
        return driver.findElements(loctor);
    }

    public String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    @AfterMethod
    public void webDriverQuit() {
        driver.quit();
    }
}
