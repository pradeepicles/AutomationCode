package ElementRepository;

import org.openqa.selenium.By;

public class repo {

    //Not Created separate Repo for Each Testcase as we have only 3 tcs

    public static By watchDemo = By.xpath("(//div[text()='Watch Demo'])[2]");
    public static By firstName = By.id("FirstName");
    public static By lastName = By.id("LastName");
    public static By email = By.id("Email");
    public static By company = By.id("Company");
    public static By phone = By.id("Phone");
    public static By unitCount = By.id("Unit_Count__c");
    public static By demoRequest = By.id("demoRequest");
    public static By title = By.id("Title");
    public static By watchdemoBtn = By.xpath("//button[text()='WATCH DEMO']");
    public static String xpath = "//parent::a//h3[text()='%s']//..//following-sibling::a";
    public static String xpath1 = "//parent::div//h3[text()='%s']//..//following-sibling::a";
    public static By productElement = By.xpath("//div[@class='w-layout-blockcontainer container w-container']//div[@class='footer-nav']//div//h3");
    public static String propertyManagement = "ResidentPay|ResidentPortal|Entrata Business Intelligence|Entrata Revenue Intelligence|Student Revenue Intelligence|Access Connect|Message Center|Facility Management|Reporting|SiteTablet";
    public static String marketingAndLeasing = "ProspectPortal|LeadManager|Digital Marketing Bundle|Marketing Strategy Hub|ReputationAdvisor|Resident Services|Renters Insurance|Deposit Alternative|ResidentVerify|PreciseID|Verification of Income|Entrata Redd";
    public static String accounting = "General Accounting|Budgeting|Job Costing|Bill Pay";
    public static String utilities = "ResidentUtility|Utility Expense Management|Utility Procurement|Sales Tax Audits|Sustainable Energy Management";
    public static String solutions = "All Solutions|Multifamily|Student|Affordable|Military|Commercial|Operating System|Entrata Layered Intelligence|Training Services|Business Consulting";
    public static String companyproduct = "Summit|Resources|Blog|Careers|Entrata Cares|Partners|Legal|API Docs|Integrations|Theme Gallery";
    public static By errorMsg = By.className("AlreadyRegisteredDialog__errorMessages___1d88");
    public static By summit = By.xpath("(//*[text()='Summit'])[2]");
    public static By registerNow = By.xpath("//a[text()='Register Now']");
    public static By alreadyRegister = By.xpath("//a[text()='Already registered?']");
    public static By emailAddress = By.name("emailAddress");
    public static By confirmationNumber = By.name("confirmationNumber");
    public static By logInBtn = By.xpath("//*[@class='AlreadyRegisteredDialog__button___1d88 css-87ndg2']");
}
