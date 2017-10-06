import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ClientTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminPage adminPage;
    public static Select select;
    public LogEntries logEntries;

    public void logConsoleEntries(LogEntries logEntries) {
        for (LogEntry logEntry : logEntries) {
            if (logEntry.getLevel() == Level.SEVERE)
                System.out.println(String.valueOf(" Time Stamp: " + logEntry.getTimestamp()));
            System.out.println(String.valueOf(" Log Level: " + logEntry.getLevel()));
            System.out.println(String.valueOf(" Log Message: " + logEntry.getMessage()));
        }
    }
    public void fileExist() {

        File tmpDir = new File("C:\\Users\\Admin\\Downloads");
        boolean exists = tmpDir.exists();
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

    public void showLogs() {
        logEntries = driver.manage().logs().get(LogType.BROWSER);
        logConsoleEntries(logEntries);
    }

    public static void sleep(int time) {
        try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(time * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isElementPreset(By selector) {
        try {
            driver.findElement(selector);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test(priority = 1)
    public void ClientLogin() {
        driver.get("http://dev.forsage-studio.com.ua/login");
        loginPage.inputLogin("client@gmail.com");
        loginPage.Password("client");
        loginPage.LoginSubmit();
        sleep(1);
        showLogs();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/product"));

    }

    @Test(priority = 2, dependsOnMethods = {"ClientLogin"})
    public void ClientDownloadForOnlineShop() {
        adminPage.FiltersButton();
        adminPage.DateField("01-01-2017");
        adminPage.AddFiltersButton();
        sleep(5);
        adminPage.SelectAllProducts();
        adminPage.DownloadButton();
        adminPage.DownloadForOnlineShop();
        sleep(10);
        showLogs();
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"app\"]/div/div/div[2]")));
    }


    @Test(priority = 3, dependsOnMethods = {"ClientLogin"})
    public void ClientDownloadDescriptiion() {
        adminPage.FiltersButton();
        sleep(5);
        adminPage.DateField("01-01-2017");
        adminPage.SellerList();
        sleep(3);
        adminPage.SelectSeller();
        sleep(3);
        adminPage.AddFiltersButton();
        sleep(10);
        adminPage.SelectAllProducts();
        adminPage.DownloadButton();
        adminPage.DownloadDescription();
        sleep(5);
        showLogs();
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"app\"]/div/div/div[2]")));
    }
    @Test(priority = 4, dependsOnMethods = {"ClientLogin"})
    public void ClientDownloadPhotos() {
        adminPage.FiltersButton();
        sleep(5);
        adminPage.DateField("01-01-2017");
        adminPage.SellerList();
        sleep(3);
        adminPage.SelectSeller();
        sleep(3);
        adminPage.AddFiltersButton();
        sleep(5);
        adminPage.DownloadButton();
        adminPage.DownloadPhotos();
        sleep(5);
        showLogs();
    }
    }



