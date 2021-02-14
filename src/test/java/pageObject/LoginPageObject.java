package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement username;

    @FindBy(css = "input[class*='a-span12 auth-autofocus']")
    WebElement password;

    @FindBy(css = "input[id^='conti']")
    WebElement proceed;

    @FindBy(css = "#signInSubmit")
    WebElement signIn;



    public void enterUser(String userName){
        username.sendKeys(userName);
    }

    public void clickContinue(){
        proceed.click();
    }

    public void enterPass(String pass){
        password.sendKeys(pass);
    }

    public void click_Signin(){
        signIn.click();
    }
}
