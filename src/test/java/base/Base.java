package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Base {
    WebDriver driver;
    public Properties prop;
    public Base()
    {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\Config.properties");
        try {
            FileInputStream file = new FileInputStream(propFile);
            prop.load(file);
        }catch (Throwable e)
        {
            e.printStackTrace();
            e.getMessage();
        }
    }

    public WebDriver initializeBrowserAndOpenURL(String browserName)
    {

        if (browserName.equalsIgnoreCase("chrome")) {
            driver= new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver =new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

        return driver;
    }
}
