package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExtendRepoter {

    public static ExtentReports generateExtendReport()
    {
        ExtentReports extendReporter = new ExtentReports();

        File extendReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtendReports\\extendReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extendReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Test Automation Tester Assessment Results Report");
        sparkReporter.config().setDocumentTitle("ABSA Test Automation Tester Assessment");
        sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extendReporter.attachReporter(sparkReporter);

        Properties properties = new Properties();
        File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\Config.properties");
        try {
            FileInputStream file = new FileInputStream(propFile);
            properties.load(file);
        }catch (Throwable e)
        {
            e.printStackTrace();
            e.getMessage();
        }
        extendReporter.setSystemInfo("Application URL", properties.getProperty("url"));
        extendReporter.setSystemInfo("Browser Name", properties.getProperty("browser"));
        extendReporter.setSystemInfo("Operating System", properties.getProperty("os.name"));
        extendReporter.setSystemInfo("Username", properties.getProperty("user.name"));
        extendReporter.setSystemInfo("Java version", properties.getProperty("java.version"));

        return extendReporter;
    }
}
