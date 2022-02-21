package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {
   public ConcortHotelPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//li[@id='navLogon']")
    public WebElement concortHotelLogin;

    @FindBy(xpath = "// input[@id='UserName']")
    public WebElement concortHotelUserName;


}
