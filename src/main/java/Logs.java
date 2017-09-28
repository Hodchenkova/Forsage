import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Logs {


    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminPage adminPage;
    public static Select select;
    public LogEntries logEntries;

    public static void logConsoleEntries (LogEntries logEntries) {
        for (LogEntry logEntry : logEntries) {
            System.out.println(String.valueOf(" Time Stamp: " + logEntry.getTimestamp()));
            System.out.println(String.valueOf(" Log Level: " + logEntry.getLevel()));
            System.out.println(String.valueOf(" Log Message: " + logEntry.getMessage()));
        }
    }



    @BeforeClass
    public static void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    public static void sleep(int time) {
        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test(priority = 1)
    public void AdminLogin() {
        driver.get("http://test.forsage-studio.com.ua/login");
        loginPage.inputLogin("admin@gmail.com");
        loginPage.Password("admin");
        loginPage.LoginSubmit();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://test.forsage-studio.com.ua/product"));
    }
    @Test(priority = 10, dependsOnMethods = {"AdminLogin"})
    public void AdminEditProduct() throws Exception{
        adminPage.FiltersButton();
       adminPage.DateField("01-01-2017");
        adminPage.AddFiltersButton();
      sleep(3);
        adminPage.SelectProduct();
        adminPage.EditButton();
        logEntries = driver.manage().logs().get(LogType.BROWSER);
        logConsoleEntries(logEntries);
//        webDriver.quit();
    }
}

