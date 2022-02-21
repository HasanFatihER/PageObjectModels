package Tests;
//Her kademenin ayrıntılı şekilde görülmesi için her class'ta yeni yöntemler denenmiştir.
import Utilities.Driver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*  POM --> Page Object Model
    *  POM bir Framework Design Pattern'dir. Bir Framework 3 temel package'tan oluşur. Bunlar
    *  Pages-Tests ve Utilities'dir. Bununla birlikte Configuration.properties class'ı da bizim
    için transport işlemi görür. Kullanacağımız değişkenleri,dataları tutar
    *  POM bir projenin anlaşılır ve bakımının kolay yapılabilmesini sağlar. Ayrıca OOP konsepti
    gereği; hem daha az kod yazıp, tekrar tekrar kullanma imkanı oluşturur.
    *POM'da genel prensip : driver'a static yöntemi ile sayfalara ise obje üzerinden ulaşılır.
*/
public class AmazonPageUrlTest {
    @Test
    // Driver class'ından çağırıyoruz.
    public void pageUrlTest(){
        Driver.getDriver().get("https://www.amazon.com/");
        String currentUrl= Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(currentUrl,"https://www.amazon.com/","PageUrlTest FAILED");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    // Driver Class'ta if() bloğu koymasaydık bu iki testi çalıştırdığımızda ayrı ayrı sayfada
    //açardı. Aynı şekilde closeDriver'da da driver'ın null olma durumunu değerlendirmezsek
    //2. teste geçiş yapmaz.
    @Test
    public void pageUrlTest2(){
        Driver.getDriver().get("https://www.ebay.com/");
        String currentUrl= Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(currentUrl,"https://www.ebay.com/","PageUrlTest FAILED");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
