package flows;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestUtil;

public class CreateNewFlowTests extends BaseTests {

    private String sheetName = "galaxyEvent";

    @DataProvider(name = "flowName-provider")
    public Object[] flowData ()
    {
        Object flowName[] = TestUtil.getTestData(sheetName);
        return flowName;
    }

    @Test (dataProvider = "flowName-provider")
    public void testClickCreateNewFlow(String flowName){
        //var flowsPage = dashboardPage.clickFlows();
        //flowsPage.clickCreateNewFlow(); // issue here: click some button which is not actually we want
        // flowsPage.setFlowName("test");

        System.out.println("Flow Name: " + flowName + "\n" );
    }

}
