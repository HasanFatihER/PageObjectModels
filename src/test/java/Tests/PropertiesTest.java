package Tests;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
/*   Properties--> bizim için test datalarını tuttuğumuz ve gerektiğinde buradan çağıracağımız
   bir alandır.
   --src altında configiration.properties olarak bir File oluştururuz. Bu dosyaya datalarımızı key=value mantığı
   ile yazarız.

   -- configiration.properties dosyasına ulaşmak için Utilities package'ı altında configurationReader adında
   bir class oluştururuz ve bu class üzerinden configiration.properties'e ulaşım sağlarız.

   -- configiration.properties ile birlikte temel POM'u tamamlamış oluruz.

   --Methodlarıve variable'ları static yaparız.


 */

public class PropertiesTest {

    @Test
    public void positiveLoginTest()    {

        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage=new ConcortHotelPage();
        concortHotelPage.concortHotelLogin.click();
        concortHotelPage.concortHotelUserName.sendKeys(ConfigReader.getProperty("CHValidUserName"));
        concortHotelPage.concortHotelPassword.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.concortHotelLoginButton.click();
        Assert.assertTrue(concortHotelPage.concortHotelLoginMessage.isDisplayed(),"Login Test FAILED");
        Driver.closeDriver();
}}
