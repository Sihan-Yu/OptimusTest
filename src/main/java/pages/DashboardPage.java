package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private WebDriver driver;
    private By flowsButton = By.xpath("//span[contains(text(), 'Flows')]");
    private By connectorsButton = By.xpath("//span[contains(text(), 'Connectors')]");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public String getDashboardTitle(){
        return driver.getTitle();
    }

    public String getDashboardUrl(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Flows")));
        return driver.getCurrentUrl();
    }

    public ConnectorsPage clickConnectors(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Connectors")));
        driver.findElement(connectorsButton).click();
        return new ConnectorsPage(driver);
    }

    public FlowsPage clickFlows(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Flows")));
        driver.findElement(flowsButton).click();
        return new FlowsPage(driver);
    }

}
