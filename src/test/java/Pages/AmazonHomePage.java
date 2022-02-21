package Pages;
/*  Bir page class'ı oluşturduğunda ilk yapman gereken, parametresiz constructor oluşturmak.
    Bu constructor içinde de PageFactory ile driver'a ilk değer atamasını yapmak.
    -- PageFactory.initElements(driver,this);
    -- Page objelerine ilk degerlerini atamak için page classlarında PageFactory kulanırız..

    Page class'larında Test'lerle ilgili locate işlemleri, methodlar gibi datalar tutulur.
    Webelementlere ve methodlara POM prensiplerince obje oluşturarak ulaşılır.
*/

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // @FindBy notasyonu test class’larinda kullanacagimiz Web Elementlerini Page
    //sayfasinda locate etmek icin kullanilir

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearchBox;
    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement amazonSearchResult;


}
