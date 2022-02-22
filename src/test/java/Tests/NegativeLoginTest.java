package Tests;

import Pages.ConcortHotelPage;
import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest {

    @Test
    public void negativeLoginTest()    {

        Driver.getDriver().get("https://www.concorthotel.com/");
        ConcortHotelPage concortHotelPage=new ConcortHotelPage();
        concortHotelPage.concortHotelLogin.click();
        concortHotelPage.concortHotelUserName.sendKeys("manager");
        concortHotelPage.concortHotelPassword.sendKeys("Manager1");
        concortHotelPage.concortHotelLoginButton.click();
        Assert.assertTrue(concortHotelPage.concortHotelNegativeLoginMessage.isDisplayed(),"Login Test FAILED");
        Driver.closeDriver();
    }
}
