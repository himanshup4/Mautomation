package amazonTest;

import amazonHelper.BrowserInit;
import amazonHelper.DataPro;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;

public class AmazonLogin {
    WebDriver driver;
    String url ="https://www.amazon.com";
    HomePageObject hpo;
    BrowserInit ah;
    JavascriptExecutor jse;
    LoginPageObject lpo;
    ExtentReports report;   // for reports
    ExtentTest test;        //for reports


    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"}) //can read multiple paramenter from TestNG file
    public void initDriver(String browser){
        String[] browser_selection = browser.split(",");// spliting values
        ah = new BrowserInit();
        driver = ah.initializeDriver(browser_selection[0]);
        jse = (JavascriptExecutor)driver;
        lpo = new LoginPageObject(driver);
        report = new ExtentReports("D://Selenium//Reports//LoginPageReport.html",true);
        test = report.startTest("User is on login page");
        hpo = new HomePageObject(driver,test);
    }

    @Test(groups = {"test1"},dataProvider ="input1" , dataProviderClass = DataPro.class)
    public void validateLogin1(String username, String password) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,100);");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,-100);");
        hpo.movetoSignIn(driver);
        Thread.sleep(2000);
        hpo.click_Signin();
        Thread.sleep(2000);
        lpo.enterUser(username);
        lpo.clickContinue();
        lpo.enterPass(password);
        lpo.click_Signin();
    }

    @Test(groups = {"test2"},dataProvider ="input2" , dataProviderClass = DataPro.class )
    public void validateLogin2(String username, String password) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,100);");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,-100);");
        hpo.movetoSignIn(driver);
        Thread.sleep(2000);
        hpo.click_Signin();
        Thread.sleep(2000);
        lpo.enterUser(username);
        lpo.clickContinue();
        lpo.enterPass(password);
        lpo.click_Signin();
    }


    @AfterClass(alwaysRun = true)
    public void close(){
        report.endTest(test);
        report.flush();
        driver.close();
    }
}
