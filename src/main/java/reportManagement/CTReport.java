package reportManagement;

import globalConstant.FilePaths;
import lombok.Getter;
import propertyManagement.ApiProperties;
import propertyManagement.CTReportProperties;
import utils.ExcelUtil;

import java.io.File;
import java.io.IOException;

public class CTReport {
    @Getter
    private final String buildID;
    @Getter
    private final String leadName;
    @Getter
    private final String testFrameworkIP;
    @Getter
    private final String testFrameworkName;
    private final String testFrameworkGitPath;
    @Getter
    private final String productInterface;
    private final String inf01;
    private final String inf02;
    @Getter
    private final String testType;
    public CTReport(){
        this.leadName = CTReportProperties.getInstance().getProperty("LeadName");
        this.productInterface = CTReportProperties.getInstance().getProperty("ProjectName");
        this.testFrameworkName = CTReportProperties.getInstance().getProperty("TestFrameworkName");
        this.testFrameworkIP = CTReportProperties.getInstance().getProperty("TestFrameworkIP");
        this.testFrameworkGitPath = CTReportProperties.getInstance().getProperty("TestFrameworkGitPath");
        this.buildID = CTReportProperties.getInstance().getProperty("BUILDID");
        this.inf01 = ApiProperties.getProperty("project.name");
        this.inf02 = ApiProperties.getProperty("language.code");
        this.testType = CTReportProperties.getInstance().getProperty("TestType");
    }
    public static void generateCTReport(String htmlReportPath) {
        try{
        File directory = new File(FilePaths.CT_REPORT);

        if (!directory.exists()) {
            directory.mkdir();
        }
        ExcelUtil.writeCTReportFileHeader();

        Object[][] reporterObject = HTMLParser.generateReporterObject(htmlReportPath);
        ExcelUtil excelUtil = new ExcelUtil();
        excelUtil.writeTestCaseSheetNew(FilePaths.CT_REPORT, reporterObject);
    }
    catch(IOException io){
        io.printStackTrace();
    }}

    public static void main(String[] args) {

        String path = "/Users/ayushkumarsingh/Downloads/p3/paytm_ncmc_app_automation/reports/htmlReports/NCMC App06-02-2024-05-22-00.html";
        CTReport ctReport = new CTReport();
        ctReport.generateCTReport(path);
    }

    public String getCountry() {
        return this.inf01;
    }
    public String getLanguage() {
        return this.inf02;
    }
    public String getTestFrameworkSVNPath() {
        return this.testFrameworkGitPath;
    }


}
