package flows;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FlowsPage;

public class CreateNewFlowTests extends BaseTests {
    @Test
    public void testClickCreateNewFlow(){
        var flowsPage = dashboardPage.clickFlows();
        flowsPage.clickCreateNewFlow();
        // flowsPage.setFlowName("test");
        // flowsPage.clickNextButton();
    }
}
