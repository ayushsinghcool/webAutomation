package intializers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import reportManagement.CTReport;
import reportManagement.ExtentManager;


public class TestInit {
    private static ExtentReports extent;
    protected static ExtentTest pNode;
    ThreadLocal parent = new ThreadLocal();

    private static Logger logger = LoggerFactory.getLogger(TestInit.class);

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite()  {

        logger.info("Before Suite Started");
        extent =  ExtentManager.getInstance();

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        //To create parent Node in extent report
        pNode = extent.createTest(getClass().getSimpleName());
        parent.set(pNode);

    }

    @AfterClass
    public void afterClass(){
        extent.flush();
    }

    @AfterSuite
    public void afterSuite(){
        extent.flush();
        new CTReport();
        CTReport.generateCTReport(ExtentManager.getExtentReportFileName());
       // DriverFactory.closeDriver();
    }
}
