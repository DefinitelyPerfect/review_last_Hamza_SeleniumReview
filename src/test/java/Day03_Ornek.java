import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day03_Ornek {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void amazonDropdownTest(){
        driver.get("http://amazon.com");
        WebElement menu = driver.findElement(By.cssSelector("#searchDropdownBox"));
        Select select = new Select(menu);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@dir='auto']"));
        aramaKutusu.sendKeys("JAVA"+ Keys.ENTER);

        WebElement sonucSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());

        WebElement ilkSiradaki = driver.findElement(By.xpath("//*[contains(text(),'real-world')]"));
        ilkSiradaki.click();

        WebElement link = driver.findElement(By.linkText("Back to results"));

        Assert.assertTrue(link.isDisplayed());

    }
}
