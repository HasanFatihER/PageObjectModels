package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@class='inputtext _55r1 _6luy']")
    public WebElement facebookEmailBox;
    @FindBy(xpath = "//input[@type='password']")
    public WebElement facebookPasswordBox;
    @FindBy(xpath = "//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
    public WebElement facebookLogin;
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement facebookLoginMessage;


}
