package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By passwordField = By.name("Password");
    private By loginButton = By.cssSelector(".flat-button-v2.button.red");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public DashboardPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new DashboardPage(driver);
    }

}
