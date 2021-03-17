package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class FlowsPage {

    private WebDriver driver;
    private By createNewFlowButton = By.cssSelector("[class='create-button']");
    private By flowNameField = By.name("Flow Name");
    private By nextButton = By.xpath("//button[contains(text(), 'Next')]");
    private By addTriggerButton = By.className("add-trigger-container");
    private By selectSystemToIntegrate = By.className("third-party-integration-item-v2-container tps-container");
    private By galaxyConnectorButton = By.linkText("Galaxy Connector Connector");
    private By HCConnectorButton = By.linkText("HikCentral - EU Connector");
    private By inputSearchFiled = By.cssSelector("input.input");
    private By eventButton = By.className("tree-view-drop-down-container event-category-selector");
    private By responseButton = By.linkText("Add Response");


    private By dropdown = By.id("dropdown");

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
        WebElement nextButtonElement = driver.findElement(nextButton);
        Actions action = new Actions(driver);
        action.moveToElement(nextButtonElement);
        driver.findElement(nextButton).click();
    }

    public void setFlowChart(String flowName){
        // click trigger
        setSystemAndEvent("Galaxy Connector Connector", flowName);
        // click response
        setSystemAndEvent("HikCentral - EU Connector", "DynamicallyTriggerAlarm");
    }

    public void setSystemAndEvent(String system, String event){
        clickLink(system);
    }

    public void setAssociation(){
        driver.findElement(By.name("GUID")).sendKeys("Guid");
        driver.findElement(By.name("name")).sendKeys("Name");
        driver.findElement(By.name("name")).sendKeys("Name");
    }



    public void selectFromDropDown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void addMultipleAttribute(){
        String script = "arguments[0].setAttribute('multiple','')";
        ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
    }

    private Select findDropDownElement(){
        return new Select(driver.findElement(dropdown));
    }

    public void clickAddTrigger(){
        driver.findElement(addTriggerButton).click();
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}

