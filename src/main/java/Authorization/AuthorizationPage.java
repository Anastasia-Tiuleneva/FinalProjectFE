package Authorization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends AbstractPage {

    @FindBy(css = "input[type=text]")
    private WebElement username;

    @FindBy(css = "input[type=password]")
    private WebElement password;

    @FindBy(css = "button[form=login]")
    private WebElement login;


    public void userName(){
        this.username.click();
    }
    public void passWord(){
        this.password.click();
    }

    public void logIn(){
        this.login.click();
    }

    public AuthorizationPage setUsername(String username) {
        this.username.sendKeys(username);
        return this;
    }

    public AuthorizationPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }





}
