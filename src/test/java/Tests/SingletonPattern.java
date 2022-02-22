package Tests;

import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.annotations.Test;

public class SingletonPattern {
    /* SingletonPattern bir class'tan sadece 1 adet obje üretilmesine müsaade eden bir modeldir.
       Bunu sağlamak için default constructor'ı tekrar oluşturup, acces modifier'ını private yapıyoruz.
    */
    @Test
    public static   void  singletonPatternTest(){

    /* SingletonPattern kullanılan bir modeldir. Korumak istdiğimiz class için kullanırız
    * Örneğin Drive class'ı içinde
    *   private Driver() constructor'ı oluşturalım.
    *
    * */

       // Driver driver=new Driver(); Obje oluşturulamaz.
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        Driver.closeDriver();

        // Biz Driver'ı sadece getDriver ve closeDriver olarak kullanmak istiyoruz.

}}
