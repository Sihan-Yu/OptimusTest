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
    private By nextButton = By.xpath("/html/body/div/div[2]/div[2]/div[4]/button[1]");
    private By addTriggerButton = By.xpath("//span[contains(text(), 'Add Trigger')]");
    private By selectSystemToIntegrate = By.className("selected-container");
    private By selectEvent = By.className("selection-result");
    private By galaxyConnectorButton = By.xpath("//span[.='Galaxy Connector Connector']");
    private By flowChartOKButton = By.xpath("//button[contains(text(), 'OK')]");
    private By HCConnectorButton = By.linkText("HikCentral - EU Connector");
    private By inputSearchFiled = By.cssSelector("input.input");
    private By searchResults = By.className("child-drop-down-item");
    private By expandEventDropdownListButton = By.className("option-text-container");
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
        driver.findElement(nextButton).click();
    }

    public void setFlowChart(String flowName){
        // set trigger
        driver.findElement(addTriggerButton).click();
        setSystemAndEvent("Galaxy Connector", flowName);

        // set response
        //driver.findElement(addTriggerButton).click();
        //setSystemAndEvent("HikCentral - EU Connector", "DynamicallyTriggerAlarm");
    }

    public void setSystemAndEvent(String system, String event){
        driver.findElement(selectSystemToIntegrate).click();
        driver.findElements(inputSearchFiled).get(0).sendKeys(system);
        driver.findElement(galaxyConnectorButton).click();
        driver.findElement(selectEvent).click();
        driver.findElements(inputSearchFiled).get(1).sendKeys(event);
        driver.findElement(expandEventDropdownListButton).click();
        driver.findElement(searchResults).click();
        driver.findElement(flowChartOKButton).click();
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

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}

