package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConnectionProceedPage {
    private WebDriver driver;
    private By detailsButton = By.id("details-button");
    private By proceedLink = By.id("proceed-link");

    public ConnectionProceedPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickProceed(){
        driver.findElement(detailsButton).click();
        driver.findElement(proceedLink).click();
        return new LoginPage(driver);
    }
}
