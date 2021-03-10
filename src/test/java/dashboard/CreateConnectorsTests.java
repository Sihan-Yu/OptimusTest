package dashboard;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CreateConnectorsTests extends BaseTests {
    @Test
    public void testClickCreateNewConnectors(){
        var connectorsPagePage = dashboardPage.clickConnectors();
        connectorsPagePage.clickCreateNewConnector();
    }
}
