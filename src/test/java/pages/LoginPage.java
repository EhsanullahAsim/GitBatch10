package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement usernamebox;

    @FindBy(id = "txtPassword")
    public WebElement passwordbox;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

   public LoginPage(){
        PageFactory.initElements(driver, this);
    }
}
