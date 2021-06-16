import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day03_HardAssert {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Ignore
    @Test
    public void test(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        Assert.assertTrue(baslik.contains("car"));
    }

    @Ignore
    @Test
    public void test2(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();

        Assert.assertFalse(baslik.contains("car"));
    }

    @Test
    public void test3(){
        driver.get("http://amazon.com");
        String baslik = driver.getTitle();
        System.out.println(baslik);

        Assert.assertEquals("Amazon.com. Spend less. Smile more.",baslik);
    }

    @Test
    public void softAssertTest(){
        driver.get("http://amazon.com");
    }
}
