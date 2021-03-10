package base;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ConnectionProceedPage;
import pages.DashboardPage;
import pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.EventReporter;


public class BaseTests {

    protected ConnectionProceedPage connectionProceedPage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    private EventFiringWebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        // driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

        driver.get("https://10.199.28.206:44332/");
        connectionProceedPage= new ConnectionProceedPage(driver);
        loginPage = connectionProceedPage.clickProceed();

        loginPage.setPassword("hik12345+");
        dashboardPage = loginPage.clickLoginButton();
    }

//    @BeforeMethod
//    public void goHome(){
//
//    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

}
