package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.WebTablesPage;

public class TC02_WebTables extends Base {

    public TC02_WebTables(){
        super();
    }
    public WebDriver driver;
    HomePage homePage;
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

    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
