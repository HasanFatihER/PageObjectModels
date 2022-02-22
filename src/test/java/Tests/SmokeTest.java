package Tests;

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest {
    /*
    *  Önemli/temel fonksiyonlarini test etmek icin yaptığımız testtir.
    *  Login,logout,sepete ekle,odeme yap gibi.
    *  Eger smoke test FAILED olursa ivedi şekilde tüm ekibi haberdar ederiz.
    *
    */

    /*
    * 1) smokeTest Clası oluşturun.
       3 Farkli test Methodunda 3 senaryoyu test et
       - yanlisSifre
       - yanlisKulllanici
       - yanlisSifreKullanici
       test data yanlis username: manager1 , yanlis password : manager1
       2) https://www.concorthotel.com/ adresine git
       3) Login butonuna bas
       4) Verilen senaryolar ile giris yapilamadigini test et
     */
 @Test
    public void wrongPassword(){
     Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
     ConcortHotelPage concortHotelPage=new ConcortHotelPage();
     concortHotelPage.concortHotelLogin.click();
     concortHotelPage.concortHotelUserName.sendKeys(ConfigReader.getProperty("CHValidUserName"));
     concortHotelPage.concortHotelPassword.sendKeys("CHInValidPassword");
     concortHotelPage.concortHotelLoginButton.click();
     Assert.assertTrue(concortHotelPage.concortHotelNegativeLoginMessage.isDisplayed(),"Login Test FAILED");
     Driver.closeDriver();

 }
    @Test
    public void wrongUserName(){
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage=new ConcortHotelPage();
        concortHotelPage.concortHotelLogin.click();
        concortHotelPage.concortHotelUserName.sendKeys(ConfigReader.getProperty("CHInValidUserName"));
        concortHotelPage.concortHotelPassword.sendKeys("CHValidPassword");
        concortHotelPage.concortHotelLoginButton.click();
        Assert.assertTrue(concortHotelPage.concortHotelNegativeLoginMessage.isDisplayed(),"Login Test FAILED");
        Driver.closeDriver();

    }
    @Test
    public void wrongPasswordUserName(){
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage=new ConcortHotelPage();
        concortHotelPage.concortHotelLogin.click();
        concortHotelPage.concortHotelUserName.sendKeys(ConfigReader.getProperty("CHInValidUserName"));
        concortHotelPage.concortHotelPassword.sendKeys("CHInValidPassword");
        concortHotelPage.concortHotelLoginButton.click();
        Assert.assertTrue(concortHotelPage.concortHotelNegativeLoginMessage.isDisplayed(),"Login Test FAILED");
        Driver.closeDriver();

    }

}
