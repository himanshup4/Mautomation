package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


    public void enterText(String textToEnter){
        entertext.sendKeys(textToEnter);
    }

    public void clickit(){
        clickButton.click();
    }
}
