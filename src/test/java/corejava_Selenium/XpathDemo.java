package corejava_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class XpathDemo {

    public static void main(String[] Args) throws InterruptedException {
      String letscodeit= "https://letskodeit.teachable.com/";
      String facebook = "https://www.facebook.com/";
      String currentD = System.getProperty("user.dir");
      //System.out.println(currentD);
      System.setProperty("webdriver.chrome.driver",currentD + "/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(letscodeit);
        System.out.println("User is on webpage");
        //driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
//        driver.findElement(By.name("user[email]")).sendKeys("Testing");//name
//        driver.findElement(By.id("user_email")).sendKeys("Testing");//id
//        driver.findElement(By.linkText("Login")).click(); // codeit
        driver.findElement(By.partialLinkText("Prac")).click(); // codeit
//        driver.findElement(By.className("_9npi")).sendKeys("Teseting password");// class name
//        driver.findElement(By.cssSelector("input[id=name]")).sendKeys("ccs id tag"); // css selector via ID i.e tagname "codeit"
//        driver.findElement(By.cssSelector("#name")).sendKeys("ccs id tag"); // css selector via ID i.e tag symbol  "codeit"
//        driver.findElement(By.cssSelector("#name")).sendKeys("ccs id tag"); // css selector via ID i.e tag symbol "codeit"
//        driver.findElement(By.cssSelector("._9npi")).sendKeys("test"); //"Facebook" css selector working with element with 1 class
//        driver.findElement(By.cssSelector(".inputtext._55r1._6luy._9npi")).sendKeys("test"); //"Facebook" css selector working with element with more than 1  class element
//working with WILD CARDS(CSS SELECTOR)
//        driver.findElement(By.cssSelector("input[class$='_9npi']")).sendKeys("test"); //"Facebook" css selector working with element with more than 1  class element using wild card
//        driver.findElement(By.cssSelector("input[placeholder^='Enter']")).sendKeys("test"); //"codeit" css selector working with element with more values including spaces using wild card
// Working with "Finding change nodes using css"
        driver.findElement(By.cssSelector("fieldset>label>input#bmwradio")).click(); //"codeit" css selector working to access child tag in combinition with wildcard


        Thread.sleep(3000);
        driver.close();

    }
}
