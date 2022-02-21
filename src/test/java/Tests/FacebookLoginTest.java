package Tests;

import Pages.FacebookPage;
import Utilities.Driver;
import Utilities.WaitThreadSleep;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookLoginTest {

    /*
    1 - https://www.facebook.com/ adresine gidin
    2- POM’a uygun olarak email, sifre kutularini ve giris yap
    butonunu locate edin
    3- Faker class’ini kullanarak email ve sifre degerlerini
    yazdirip, giris butonuna basin
    4- Basarili giris yapilamadigini test edin */
    WaitThreadSleep sleep=new WaitThreadSleep();

    @Test
    public void facebookLoginTest(){
        FacebookPage facebookPage=new FacebookPage();
        Driver.getDriver().get("https://www.facebook.com/");
        Faker faker=new Faker();
        facebookPage.facebookEmailBox.sendKeys(faker.internet().emailAddress());
        facebookPage.facebookPasswordBox.sendKeys(faker.internet().password());
        facebookPage.facebookLogin.click();
        String actualMessage=facebookPage.facebookLoginMessage.getText();
        Assert.assertTrue(actualMessage.contains("The email address you entered isn't connected to an account."));
        sleep.waitThreadSleep(2);
        Driver.closeDriver();
    }
}
