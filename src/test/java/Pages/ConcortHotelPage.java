package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {
    public ConcortHotelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='navLogon']")
    public WebElement concortHotelLogin;

    @FindBy(xpath = "// input[@id='UserName']")
    public WebElement concortHotelUserName;

    @FindBy(xpath = "// input[@class='form-control required password']")
    public WebElement concortHotelPassword;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement concortHotelLoginButton;

    @FindBy(xpath = "//span[@class='caption-subject font-green-sharp bold uppercase']")
    public WebElement concortHotelLoginMessage;

    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement concortHotelNegativeLoginMessage;


}
