package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{

    public loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    public WebElement Input_Username;

    @FindBy(name = "password")
    public WebElement Input_Password;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    public WebElement log_button;


    public void InputUsername(String username){
        Input_Username.sendKeys(username);
    }
    public void InputPassword(String password){
        Input_Password.sendKeys(password);
    }


}
