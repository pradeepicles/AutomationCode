package test;

import ElementRepository.repo;
import org.example.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class EntrataTest extends BaseClass {

    @Test
    public void verifyScheduleDemoFormForEntrataWebsite() {
        clickOnElement(repo.watchDemo);// Xpath example on Indexing
        enterTextInElement(repo.firstName, "Pradeep");// entering text in TextBox
        enterTextInElement(repo.lastName, "Bhosale");
        enterTextInElement(repo.email, "pradeep.bhosale@gmail.com");
        enterTextInElement(repo.company, "Entrata");
        enterTextInElement(repo.phone, "9668855447");
        //Select DropDown Value from DropDown
        selectDropDownValueByIndex(repo.unitCount, 1);
        selectDropDownValueByIndex(repo.demoRequest, 1);
        enterTextInElement(repo.title, "Dr.");
        //Assertion
        Assert.assertTrue(isElementDisplayed(repo.watchdemoBtn));
    }

    @Test
    public void verifyProductListOfEntrataWebsite() {
        SoftAssert softAssert = new SoftAssert();
        List<String> productsName = new ArrayList<>();
        scrollDownToElement(repo.productElement);
        for (WebElement product : getListOfWebElements(repo.productElement)) {
            String productName = product.getText();
            if (productName.equalsIgnoreCase("Property Management")) {
                for (WebElement pm : getListOfWebElements(By.xpath(String.format(repo.xpath, productName)))) {
                    if (!(pm.getText().equalsIgnoreCase("") || pm.getText().isEmpty() || pm.getText() == null)) {
                        productsName.add(pm.getText());
                    }
                }
                List<String> expectedColumnNames = Arrays.asList(repo.propertyManagement.split("[|]"));
                softAssert.assertEquals(productsName, expectedColumnNames);
                productsName.clear();
            } else if (productName.equalsIgnoreCase("Marketing & Leasing")) {
                List<WebElement> productUnderML = product.findElements(By.xpath(String.format(repo.xpath, productName)));
                for (WebElement ml : productUnderML) {
                    if (!(ml.getText().equalsIgnoreCase("") || ml.getText().isEmpty() || ml.getText() == null)) {
                        productsName.add(ml.getText());
                    }
                }
                List<String> expectedColumnNames = Arrays.asList(repo.marketingAndLeasing.split("[|]"));
                softAssert.assertEquals(productsName, expectedColumnNames);
                productsName.clear();
            } else if (productName.equalsIgnoreCase("Accounting")) {
                List<WebElement> productUnderA = product.findElements(By.xpath(String.format(repo.xpath, productName)));
                for (WebElement account : productUnderA) {
                    if (!(account.getText().equalsIgnoreCase("") || account.getText().isEmpty() || account.getText() == null)) {
                        productsName.add(account.getText());
                    }
                }
                List<String> expectedColumnNames = Arrays.asList(repo.accounting.split("[|]"));
                softAssert.assertEquals(productsName, expectedColumnNames);
                productsName.clear();
            } else if (productName.equalsIgnoreCase("Utilities")) {
                List<WebElement> productUnderU = product.findElements(By.xpath(String.format(repo.xpath, productName)));
                for (WebElement utilities : productUnderU) {
                    if (!(utilities.getText().equalsIgnoreCase("") || utilities.getText().isEmpty() || utilities.getText() == null)) {
                        productsName.add(utilities.getText());
                    }
                }
                List<String> expectedColumnNames = Arrays.asList(repo.utilities.split("[|]"));
                softAssert.assertEquals(productsName, expectedColumnNames);
                productsName.clear();
            } else if (productName.equalsIgnoreCase("Solutions")) {
                List<WebElement> productUnderS = product.findElements(By.xpath(String.format(repo.xpath1, productName)));
                for (WebElement solutions : productUnderS) {
                    if (!(solutions.getText().equalsIgnoreCase("") || solutions.getText().isEmpty() || solutions.getText() == null)) {
                        productsName.add(solutions.getText());
                    }
                }
                List<String> expectedColumnNames = Arrays.asList(repo.solutions.split("[|]"));
                softAssert.assertEquals(productsName, expectedColumnNames);
                productsName.clear();
            } else if (productName.equalsIgnoreCase("Company")) {
                List<WebElement> productUnderC = product.findElements(By.xpath(String.format(repo.xpath1, productName)));
                for (WebElement company : productUnderC) {
                    if (!(company.getText().equalsIgnoreCase("") || company.getText().isEmpty() || company.getText() == null)) {
                        productsName.add(company.getText());
                    }
                }
                List<String> expectedColumnNames = Arrays.asList(repo.companyproduct.split("[|]"));
                softAssert.assertEquals(productsName, expectedColumnNames);
                productsName.clear();
            } else if (productName.equalsIgnoreCase("")) {
                softAssert.assertFalse(false);
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyAlreadyRegisterFUnctionalityWithIncorrectDetails() {
        clickOnElement(repo.summit);
        String parentWindow = driver.getWindowHandle();
        Set<String> setOfWindows = driver.getWindowHandles();
        Iterator<String> iterator = setOfWindows.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!childWindow.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(childWindow);
                wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(repo.registerNow)));
                clickOnElement(repo.registerNow);
                String parentWindow1 = driver.getWindowHandle();
                Set<String> setOfWindows1 = driver.getWindowHandles();
                Iterator<String> iterator1 = setOfWindows1.iterator();
                while (iterator1.hasNext()) {
                    String childWindow1 = iterator1.next();
                    if (!childWindow1.equalsIgnoreCase(parentWindow1)) {
                        String pagetTitle = driver.switchTo().window(childWindow1).getTitle();
                        if (pagetTitle.equalsIgnoreCase("Personal Information - Summit 2024")) {
                            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
                            wait = new WebDriverWait(driver, Duration.ofMinutes(3));
                            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(repo.alreadyRegister)));
                            scrollDownToElement(repo.alreadyRegister);
                            clickOnElement(repo.alreadyRegister);
                            enterTextInElement(repo.emailAddress, "shdbfhjdsjs@gmail.com");
                            enterTextInElement(repo.confirmationNumber, "1235648289");
                            clickOnElement(repo.logInBtn);
                            Assert.assertEquals(getTextFromElement(repo.errorMsg), "This confirmation number doesn't exist.");
                        }
                    }
                }
            }
        }
    }
}

