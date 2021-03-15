package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class FlowsPage {

    private WebDriver driver;
    private By createNewFlowButton = By.cssSelector("div.create-button");
    private By flowNameField = By.className("Flow Name");
    private By nextButton = By.xpath("'//button[text()=\"Next\"]'");
    private By addTriggerButton = By.className("create-button");
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
}

