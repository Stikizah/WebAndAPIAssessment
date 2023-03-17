package testCases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

public class TC01_Home extends Base {
    public WebDriver driver;

    public TC01_Home(){
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
        HomePage homePage = new HomePage(driver);
        homePage.VerifyUserList();
    }

    @AfterMethod
    public void teaDown()
    {
        driver.quit();
    }
}
