package amazonTest;

import amazonHelper.BrowserInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.HomePageObject;

public class AmazonHome {
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
        driver.get(url);
        hpo = new HomePageObject(driver);

    }

    @Test(groups = {"Regression1"})
    public void verifyAmazonLaunch() throws InterruptedException {
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        Thread.sleep(2000);
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(groups = {"Regression","Sanity"})
    public void verifySearch() {
        hpo.enterText("Shoes");
        hpo.clickit();
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
