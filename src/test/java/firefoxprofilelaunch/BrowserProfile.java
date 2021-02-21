package firefoxprofilelaunch;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class BrowserProfile {
     WebDriver driver;
     String url;

    @Before
    public void setup(){
        url = "https://letskodeit.teachable.com/p/practice";
        String resource = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", resource + "src/main/resources/geckodriver.exe");
        ProfilesIni in = new ProfilesIni(); // Opening ProfilesIni objc to getFirefox profile
        FirefoxProfile fp = in.getProfile("automationprofile"); //Storing Firefox Profile

        FirefoxOptions fo = new FirefoxOptions();   // Getting firefox Options
        fo.setProfile(fp); // Setting firefox Profile

        driver = new FirefoxDriver(fo);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
    @Test
    public void test(){
        driver.get(url);
       System.out.println("User is on website");
    }

}
