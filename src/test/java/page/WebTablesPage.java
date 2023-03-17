package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends Base {
    public WebDriver driver;

    @FindBy(xpath = "//*[@class='btn btn-link pull-right']")
    private WebElement pullRight;

    @FindBy(xpath = "//h3[@class='ng-binding']")
    private WebElement binding;

    public WebTablesPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void VerifyUserClickAddUser()
    {
        pullRight.click();
        binding.isDisplayed();
    }
}
