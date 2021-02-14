package amazonTest;

import amazonHelper.BrowserInit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.HomePageObject;

public class AmazonHome {
    WebDriver driver;
    String url ="https://www.amazon.com";
    HomePageObject hpo;
    BrowserInit ah;

    @BeforeClass(alwaysRun = true)
    public void initDriver(){
        ah = new BrowserInit();
        driver = ah.initializeDriver("chrome");
        driver.get(url);
    }

    @Test(groups = {"Regression"})
    public void verifyAmazonLaunch() {
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test(groups = {"Regression","Sanity"})
    public void verifySearch() {
        hpo = new HomePageObject(driver);
        hpo.enterText("Shoes");
        hpo.clickit();
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        driver.close();
    }
}
