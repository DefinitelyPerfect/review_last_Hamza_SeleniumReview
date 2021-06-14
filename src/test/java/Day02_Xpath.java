import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day02_Xpath {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){

        driver.get("http://a.testaddressbook.com/");
        WebElement signInLink = driver.findElement(By.linkText("Sign in"));
        signInLink.click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<WebElement> linkList = driver.findElements(By.xpath("//a"));
        System.out.println(linkList.size());

        for(WebElement w : linkList){
            System.out.println(w.getText());
        }

        WebElement email = driver.findElement(By.cssSelector("#session_email"));
        email.sendKeys("testtechproed@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input[type='password'"));
        password.sendKeys("Test1234!");

        WebElement signIn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        signIn.click();

//        List<WebElement> listAllElements = driver.findElements(By.xpath("//*"));
//        for(WebElement w : listAllElements){
//            System.out.println(w.getText());
//        }

        WebElement tumYazilar = driver.findElement(By.tagName("body"));
        System.out.println(tumYazilar.getText());

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
