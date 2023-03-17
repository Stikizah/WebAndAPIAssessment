package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddUserPage extends Base {
    public WebDriver driver;

    @FindBy(name = "FirstName")
    private static WebElement FirstName;

    @FindBy(name = "LastName")
    private static WebElement LastName;

    @FindBy(name = "UserName")
    private static WebElement UserName;

    @FindBy(name = "Password")
    private static WebElement Password;

    @FindBy(xpath = "//*[@class='modal-body']/./form/./table/./tbody/./tr/./td[2]/./label/./input[@value = '15']")
    private static WebElement Company_AAA;

    @FindBy(xpath = "//*[@class='modal-body']/./form/./table/./tbody/./tr/./td[2]/./label/./input[@value = '16']")
    private static WebElement Company_BBB;

    @FindBy(xpath = "//*[@name='RoleId']")
    private static WebElement dropRoles;

    @FindBy(name = "Email")
    private static WebElement Email;
    @FindBy(name = "Mobilephone")
    private static WebElement Mobilephone;
      public AddUserPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public static void AddUsersWithTheFollowingDetails(String strFName, String strLName, String strUserName, String strPassword,String strCustomer, String strRole, String strEmail, String strCellNumber)
    {
        FirstName.sendKeys(strFName);
        LastName.sendKeys(strLName);
        UserName.sendKeys(strUserName);
        Password.sendKeys(strPassword);

        selectCompany(strCustomer);
        selectRole(strRole);

        enterEmailAndPhone(strEmail, strCellNumber);
    }
    public static void selectCompany(String strCustomer)
    {
        WebDriverWait waitElementToDisplay = null;
        if (strCustomer.equalsIgnoreCase("Company AAA"))
        {
            Company_AAA.click();

        }else {
            Company_BBB.click();
        }
    }

    public static void selectRole(String strRole)
    {
        int intRole;
        if (strRole.equalsIgnoreCase("Sales Team"))
        {
            intRole = 1;
        } else if (strRole.equalsIgnoreCase("Customer")) {
            intRole = 2;
        }else {
            intRole = 3;
        }
        Select se = new Select(dropRoles);
        se.selectByIndex(intRole);
    }
    public static void enterEmailAndPhone(String strEmail, String strCellNumber)
    {
        Email.sendKeys(strEmail);
        Mobilephone.sendKeys(strCellNumber);
    }
}
