package Tests;

import Pages.ConcortHotelPage;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTest {
    /*  1 ) Bir Class olustur : PositiveLoginTest
        2) Bir test method olustur positiveLoginTest()
        https://www.concorthotel.com/ adresine git
        login butonuna bas
        test data username: manager ,
        test data password : Manager1!
        Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et*/


        @Test
        public void positiveLoginTest()    {

            Driver.getDriver().get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage=new ConcortHotelPage();
        concortHotelPage.concortHotelLogin.click();
        concortHotelPage.concortHotelUserName.sendKeys("manager");
        concortHotelPage.concortHotelPassword.sendKeys("Manager1!");
        concortHotelPage.concortHotelLoginButton.click();
            Assert.assertTrue(concortHotelPage.concortHotelLoginMessage.isDisplayed(),"Login Test FAILED");
        Driver.closeDriver();
    }
}
