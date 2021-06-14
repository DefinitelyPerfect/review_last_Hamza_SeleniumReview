import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Day01_OrnekAmazon {
    // 1. Amazon.com'a gideceğiz.
    // 2. Arama kutusuna "baby stroller"
    // 3. 2. Sıradaki ürüne tıklayacağız.
    // 4. Ürün sayfasına gittikten sonra, ürünün toplam fiyatını alacağız.
    // 5. Ürünün ortalama puanını (5 üzerinden) alacağız.

    WebDriver driver;

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http:amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller"+ Keys.ENTER);

        WebElement ikinciUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ikinciUrun.click();

        WebElement fiyat = driver.findElement(By.id("priceblock_saleprice"));
        System.out.println("Urunun fiyati: "+fiyat.getText());

        WebElement yildizSayisi = driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star a-star-4-5'])[1]"));
        System.out.println("Urunun yildiz sayisi: "+yildizSayisi.getText());

    }

    @Test
    public void test2(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("http://google.com");
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("John Travolta"+Keys.ENTER);
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println("Sonuc sayisi: "+sonucSayisi.getText());

    }



}
