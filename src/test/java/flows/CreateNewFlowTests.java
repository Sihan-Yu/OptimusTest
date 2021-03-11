package flows;

import base.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestUtil;

public class CreateNewFlowTests extends BaseTests {

    private String sheetName = "contacts";


    @DataProvider(name = "flowName-provider")
    public Object [][]  flowData ()
    {
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test
    public void testClickCreateNewFlow(){
        var flowsPage = dashboardPage.clickFlows();
        flowsPage.clickCreateNewFlow(); // issue here: click some button which is not actually we want
        // flowsPage.setFlowName("test");
        // flowsPage.clickNextButton();
    }

}
