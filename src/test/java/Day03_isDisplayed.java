import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_isDisplayed {

    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void isDisplayed(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement baslik = driver.findElement(By.xpath("//*[.='Dynamic Controls']"));
        boolean gorunuyorMu = baslik.isDisplayed();
        System.out.println("Gorumuyor mu: "+gorunuyorMu);
    }

    @Test
    public void isSelected(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        boolean seciliMi = checkbox.isSelected();

        System.out.println("secili mi: "+seciliMi);

        checkbox.click();

        seciliMi = checkbox.isSelected();

        System.out.println("secili mi: "+seciliMi);
    }

    @Test
    public void isEnabled(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableBox = driver.findElement(By.xpath("//input[@type='text']"));

        boolean aktifMi = enableBox.isEnabled();

        System.out.println("aktif mi: "+aktifMi);

        WebElement enableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        aktifMi = enableBox.isEnabled();

        System.out.println("aktif mi: "+aktifMi);

    }
}

