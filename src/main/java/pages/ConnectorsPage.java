package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConnectorsPage {

    private WebDriver driver;
    private By createNewConnectorButton = By.linkText("Create New Connector");

    public ConnectorsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCreateNewConnector(){
        driver.findElement(createNewConnectorButton).click();
    }
}
