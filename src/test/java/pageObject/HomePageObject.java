package pageObject;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    WebDriver driver;
    ExtentTest test;

    public HomePageObject(WebDriver driver,ExtentTest test){
        PageFactory.initElements(driver,this);
        this.test=test;
    }

    @FindBy(xpath = "//div[@class='nav-search-field ']/input")
    WebElement entertext;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']/span/input")
    WebElement clickButton;

    @FindBy(css = "#nav-link-accountList-nav-line-1")
    WebElement signin;

    @FindBy(css = ".nav-action-inner")
    WebElement clicksignin;

    public void enterText(String textToEnter){
        entertext.sendKeys(textToEnter);
        test.log(LogStatus.INFO,"User enter text");
    }

    public void clickit(){
        clickButton.click();
        test.log(LogStatus.INFO,"User click");
    }

    public void movetoSignIn(WebDriver driver){
        Actions a = new Actions(driver); // using action class to control driver
        a.moveToElement(signin).perform(); // using action class to hover on element
        test.log(LogStatus.INFO,"Move to Sign up button");
    }

    public void click_Signin(){
        clicksignin.click();
        test.log(LogStatus.INFO,"Click on Sign in button");
    }
}
