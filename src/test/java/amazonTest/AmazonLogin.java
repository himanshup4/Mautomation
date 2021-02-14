package amazonTest;

import amazonHelper.BrowserInit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"}) //can read multiple paramenter from TestNG file
    public void initDriver(String browser){
        String[] browser_selection = browser.split(",");// spliting values
        ah = new BrowserInit();
        driver = ah.initializeDriver(browser_selection[0]);
        jse = (JavascriptExecutor)driver;
        hpo = new HomePageObject(driver);
        lpo = new LoginPageObject(driver);
    }

    @Test(groups = {"test1"},dataProvider ="input1" )
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

    @Test(groups = {"test2"},dataProvider ="input2" )
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

    @DataProvider(name="input1")
    public Object[][] getData(){
        return new Object[][]{
                {"herainpandey@gmail.com","amazon@1988"},
                /*{"9717661012","himu@1988"}*/  //   If uncommented this line, then test will run two times
        };
    }

    @DataProvider(name="input2")
    public Object[][] getData1(){
        return new Object[][]{
                {"9717661012","himu@1988"}
        };
    }

    @AfterClass(alwaysRun = true)
    public void close(){
        driver.close();
    }
}
