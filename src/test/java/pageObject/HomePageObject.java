package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    WebDriver driver;

    public HomePageObject(WebDriver driver){
        PageFactory.initElements(driver,this);
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
    }

    public void clickit(){
        clickButton.click();
    }

    public void movetoSignIn(WebDriver driver){
        Actions a = new Actions(driver); // using action class to control driver
        a.moveToElement(signin).perform(); // using action class to hover on element
    }

    public void click_Signin(){
        clicksignin.click();
    }
}
