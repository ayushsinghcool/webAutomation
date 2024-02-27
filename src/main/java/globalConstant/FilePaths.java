package globalConstant;



import propertyManagement.CTReportProperties;
import propertyManagement.WebProperties;
import utils.DateUtil;

import java.io.File;

public class FilePaths {

    private  static final String USER_DIR = "user.dir";

    private FilePaths() {

    }

    static final String BASE_PATH = new File("").getAbsolutePath();
    public static final String EXTENT_REPORT_PATH = BASE_PATH +File.separator+ "reports"+File.separator+"htmlReports"+File.separator;
    public static final  String CT_REPORT = System.getProperty(USER_DIR) + File.separator+"CTReports"+File.separator;
    public static final String CIT_REPORT_OUTPUT_FILE = CT_REPORT + CTReportProperties.getInstance().getProperty("BUILDID") + "_"
            + CTReportProperties.getInstance().getProperty("TestFrameworkName") + "_" +
            CTReportProperties.getInstance().getProperty("ProductInterface")
            + "_" + DateUtil.getCurrentDateTimeExcel() + ".xlsx";
}
