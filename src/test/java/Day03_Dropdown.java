import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day03_Dropdown {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void dropdown(){
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropDown);

        select.getFirstSelectedOption(); // secili olan secim

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByVisibleText("Baby"); // gorunur texte gore secim

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByIndex(5); // index degerine gore secim (0'dan baslar!)

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        select.selectByValue("search-alias=computers"); // value attributune gore secim

        List<WebElement> tumSecenekler = select.getOptions();

        for(WebElement w : tumSecenekler){
            System.out.println(w.getText());
        }

        System.out.println("Toplam kategori sayisi: "+tumSecenekler.size());

        WebElement seciliOlan = select.getFirstSelectedOption();
        System.out.println("Su an secili olan: "+seciliOlan.getText());
    }
}
