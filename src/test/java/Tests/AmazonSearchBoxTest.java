package Tests;

import Pages.AmazonHomePage;
import Utilities.Driver;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonSearchBoxTest {

    @Test
    public void searchInSearchBox(){
        Driver.getDriver().get("https://www.amazon.com/");
        AmazonHomePage amazonHomePage=new AmazonHomePage();
        amazonHomePage.amazonSearchBox.sendKeys("Drum"+ Keys.ENTER);
        // Aramalarda drum içerdiğini kontrol edelim.
        String amazonAcctualSearchResult= amazonHomePage.amazonSearchResult.getText();
        Assert.assertTrue(amazonAcctualSearchResult.contains("Drum"),"\"Search Result Test FAILED\"");

        Driver.closeDriver();
    }
    /* Aşağıdaki testte locaterlarımı yine AmazonHomePage'den çağırdık. Tekrar locate etmeme gerek yok.
    *  POM 'un bize sağladığı özellikleri net bir şekilde anlayabiliyoruz. Bir sonraki aşamada
    * Driver.getDriver().get("https://www.amazon.com/"); için de bir işlem yapalım. Kodlarımız ne kadar
    * sade ve anlaşılabilir hale gelirse o kadar başarılı olmuşuzdur.
    *  */

    @Test
    public void searchInSearchBox2(){
        Driver.getDriver().get("https://www.amazon.com/");
        AmazonHomePage amazonHomePage=new AmazonHomePage();
        amazonHomePage.amazonSearchBox.sendKeys("Java"+ Keys.ENTER);
        // Aramalarda drum içerdiğini kontrol edelim.
        String amazonAcctualSearchResult= amazonHomePage.amazonSearchResult.getText();
        Assert.assertTrue(amazonAcctualSearchResult.contains("Java"),"\"Search Result Test FAILED\"");

        Driver.closeDriver();
    }
}
