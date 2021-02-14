package amazonTest;

import amazonHelper.BrowserInit;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.HomePageObject;
import sun.rmi.runtime.Log;

public class AmazonHome {
    WebDriver driver;
    String url ="https://www.amazon.com";
    HomePageObject hpo;
    BrowserInit ah;
    ExtentReports report;   // for reports
    ExtentTest test;        //for reports


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"}) //can read multiple paramenter from TestNG file
    public void initDriver(String browser){
        String[] browser_selection = browser.split(",");// spliting values
        ah = new BrowserInit();
        driver = ah.initializeDriver(browser_selection[0]);
        driver.get(url);
        report = new ExtentReports("D://Selenium//Reports//HomePageReport.html",true);
        test = report.startTest("User is on Home Page");
        hpo = new HomePageObject(driver,test);
        test.log(LogStatus.INFO,"Browser Started");


    }

    @Test(groups = {"Regression1"})
    public void verifyAmazonLaunch() throws InterruptedException {
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle,expectedTitle);
        test.log(LogStatus.PASS,"Home page is valid");
    }

    @Test(groups = {"Regression","Sanity"})
    public void verifySearch() {
        hpo.enterText("Shoes");
        hpo.clickit();
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        report.endTest(test);
        report.flush();
        driver.close();
    }
}
