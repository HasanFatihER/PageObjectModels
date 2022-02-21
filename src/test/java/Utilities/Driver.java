package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        // Her seferinde driver oluşturmaması ve yeni sayfa açmaması için if kullanırız.
        //Her bir WebDriver' için setup seçenekleri sunalım.
        if (driver == null) {

            driver = new ChromeDriver();
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;

    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }


    }

}
