package page;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    public WebDriver driver;
    @FindBy(xpath = "//*[@class='btn btn-link pull-right']")
    private WebElement verifyUserList;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void VerifyUserList()
    {
        verifyUserList.isDisplayed();
    }
}
