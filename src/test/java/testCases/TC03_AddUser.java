package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AddUserPage;
import page.HomePage;
import page.WebTablesPage;

public class TC03_AddUser extends Base {
    public WebDriver driver;
    WebDriverWait waitElementToDisplay;
    HomePage homePage;
    AddUserPage addUserPage;

    public TC03_AddUser(){
        super();
    }
    @BeforeMethod
    public void nevigateToUrl()
    {
        driver = initializeBrowserAndOpenURL(prop.getProperty("browser"));

    }

    @Test(priority = 1)
    public void validateThatYouAreOnTheUserListTable()
    {
        homePage = new HomePage(driver);
        homePage.VerifyUserList();

    }
    @Test(priority = 2)
    public void VerifyUserClickAddUser()
    {
        WebTablesPage webTablesPage = new WebTablesPage(driver);
        webTablesPage.VerifyUserClickAddUser();
    }
    @Test(priority = 3, dataProvider = "testData")
    public void addUsersWithTheFollowingDetails(String strFName,String strLName, String strUserName, String strPassword, String strCustomer, String strRole, String strEmail, String strCellNumber)
    {
        addUserPage = new AddUserPage(driver);

        VerifyUserClickAddUser();
        AddUserPage.AddUsersWithTheFollowingDetails(strFName,strLName,strUserName,strPassword,strCustomer,strRole,strEmail,strCellNumber);

  }

    @DataProvider
    public Object[][] testData()
    {
        Object[][] data = utilities.getTestData.getTestDataFromExcel("Sheet1");
        return data;
    }

    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
