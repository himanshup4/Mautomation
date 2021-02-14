package amazonTest;

import amazonHelper.BrowserInit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePageObject;

public class AmazonLogin {
    WebDriver driver;
    String url ="https://www.amazon.com";
    HomePageObject hpo;
    BrowserInit ah;
    JavascriptExecutor jse;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"}) //can read multiple paramenter from TestNG file
    public void initDriver(String browser){
        String[] browser_selection = browser.split(",");// spliting values
        ah = new BrowserInit();
        driver = ah.initializeDriver(browser_selection[0]);
        jse = (JavascriptExecutor)driver;
        hpo = new HomePageObject(driver);
    }

    @Test
    public void validateLogin() throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,100);");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,-100);");
        hpo.movetoSignIn(driver);
        Thread.sleep(2000);
        hpo.click_Signin();
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        driver.close();
    }
}
