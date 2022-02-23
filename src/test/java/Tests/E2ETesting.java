package Tests;
    /* End to End Test(E2E): Bir uygulamanin tum adimlarini bastan sona test etmektir.
    Bu testin diger adi da Sistem Testi’dir.
    *  Örneğin bir eticaret sitesi Sdet görevi yapıyorsunuz. E2E testi olarak bir kullanıcının alışveriş sitesine
    girdiği andan alışverişini tamamlamasına kadar ki tüm süresi ve olasılıkları test etmelisiniz.
    */

import Pages.ConcortHotelPage;
import Utilities.ConfigReader;
import Utilities.Driver;
import Utilities.WaitThreadSleep;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2ETesting {
    // 1. Tests packagenin altına class olusturun: E2ETesting
    // 2. Bir metod olusturun: createHotel


    ConcortHotelPage concortHotelPage=new ConcortHotelPage();

    @Test
    public void createHotel() {

        // 3. https://www.concorthotel.com/ adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("CHUrl"));
        concortHotelPage.concortHotelLogin.click();
        // 4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri
        // a. Username : manager
        // b. Password : Manager1!
        // 5. Login butonuna tıklayın.
        concortHotelPage.concortHotelUserName.sendKeys(ConfigReader.getProperty("CHValidUserName"));
        concortHotelPage.concortHotelPassword.sendKeys(ConfigReader.getProperty("CHValidPassword"));
        concortHotelPage.concortHotelLoginButton.click();

        // 6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        concortHotelPage.concortHotelManagement.click();
        concortHotelPage.concortHotelList.click();
        concortHotelPage.concortHotelListADDUser.click();
        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions action=new Actions(Driver.getDriver());
        Faker faker=new Faker();
       action.click(concortHotelPage.concortHotelListCreateUser)
               .sendKeys(faker.address().zipCode())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.name().fullName())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.address().fullAddress())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.phoneNumber().cellPhone())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.internet().emailAddress())
               .sendKeys(Keys.TAB).perform();
        Select select=new Select(concortHotelPage.concortHotelListCreateUserSelection);
        select.selectByVisibleText("Hotel Type2");
        // 8. Save butonuna tıklayın.
        concortHotelPage.concortHotelListCreateUserSave.click();
        WaitThreadSleep waitThreadSleep=new WaitThreadSleep();
        waitThreadSleep.waitThreadSleep(2);
        // 9. “Hotel was inserted successfully” textinin göründüğünü test edin.
        String expectedMessage="Hotel was inserted successfully";
        String actualMessage=concortHotelPage.concortHotelListCreateUserCorrectMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage,"E2E TEST FAILED");
        // 10. OK butonuna tıklayın.
        concortHotelPage.concortHotelListCreateUserCorrectMessageOK.click();
        Driver.closeDriver();

    }
}
