package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.io.FileHandler;

public class Listeners implements ITestListener {
    ExtentReports extendRepoter;
    ExtentTest extentTest;
    @Override
    public void onStart(ITestContext context) {
        extendRepoter = ExtendRepoter.generateExtendReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest = extendRepoter.createTest(testName);
        extentTest.log(Status.INFO, testName + " started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.PASS,testName + " successfully PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();

        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        File srcScreenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir")+"\\src\\Screenshots\\"+testName+".png";

        try {
            FileHandler.copy(srcScreenShot, new File(screenShotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        extentTest.addScreenCaptureFromPath(screenShotPath);
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, testName + " FAILED");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.INFO, testName + " SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        extendRepoter.flush();
    }
}
