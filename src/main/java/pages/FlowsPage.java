package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlowsPage {

    private WebDriver driver;
    private By createNewFlowButton = By.cssSelector("div.create-button");
    private By flowNameField = By.className("Flow Name");
    private By nextButton = By.xpath("'//button[text()=\"Next\"]'");
    private By addTriggerButton = By.className("create-button");

    public FlowsPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickCreateNewFlow(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createNewFlowButton));
        driver.findElement(createNewFlowButton).click();
    }

    public void setFlowName(String flowName){
        driver.findElement(flowNameField).sendKeys(flowName);
    }

    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }

    public void clickAddTrigger(){
        driver.findElement(addTriggerButton).click();
    }
}

