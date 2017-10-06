import com.steadystate.css.parser.Locatable;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.junit.runners.AllTests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.LogManager;

public class AdminTest {


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
    public static boolean scroll_Page(WebElement webelement, int scrollPoints)
    {
        try
        {
            Actions dragger = new Actions(driver);
            // drag downwards
            int numberOfPixelsToDragTheScrollbarDown = 10;
            for (int i = 10; i < scrollPoints; i = i + numberOfPixelsToDragTheScrollbarDown)
            {
                dragger.moveToElement(webelement).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release(webelement).build().perform();
            }
            Thread.sleep(500);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean checkIfElementExists(String selector) {
        try {
            driver.findElement(By.xpath(selector));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test(priority = 1)
    public void AdminLogin() {
        driver.get("http://dev.forsage-studio.com.ua/login");
        loginPage.inputLogin("admin@gmail.com");
        loginPage.Password("admin");
        loginPage.LoginSubmit();
        sleep(1);
        showLogs();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/product"));

    }

    @Test(priority = 2, dependsOnMethods = {"AdminLogin"})
    public void AdminCategories() {
        String newCategoryName = "Test Category " + new Timestamp(System.currentTimeMillis());
        System.out.printf(newCategoryName);
        adminPage.Settings();
        adminPage.Categories();
        adminPage.AddCategory();
        sleep(10);
        adminPage.InputCategoryName(newCategoryName);
        sleep(2);
        adminPage.AddCategoryButton();
        sleep(3);
        showLogs();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newCategoryName + "']")));
        sleep(2);

    }

    @Test(priority = 3, dependsOnMethods = {"AdminLogin"})
    public void AdminDirectories() {
        String newDirectoryName = "Test Directory " + new Timestamp(System.currentTimeMillis());
        String newDirectoryValue = "грн";
        System.out.printf(newDirectoryName);
        adminPage.Settings();
        adminPage.Directory();
        adminPage.AddDirectory();
        sleep(10);
        adminPage.InputDirectoryName(newDirectoryName);
        sleep(2);
        adminPage.InputDirectoryValue(newDirectoryValue);
        sleep(2);
        adminPage.AddDirectoryButton();
        sleep(3);
        showLogs();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newDirectoryName + "']")));
        sleep(2);

    }

//    @Test(priority = 4, dependsOnMethods = {"AdminLogin"})
//    public void AdminCharacteristics() {
//        String newCharacteristicName = "Test Characteristic " + new Timestamp(System.currentTimeMillis());
//        String newDirectoryValue = "грн";
//        System.out.printf(newCharacteristicName);
//        adminPage.Settings();
//        adminPage.Characteristics();
//        adminPage.AddCharacteristic();
//        sleep(10);
//        adminPage.InputCharacteristicName(newCharacteristicName);
//        sleep(2);
//        adminPage.ChooseCharacteristicsValue();
//        sleep(2);
//        adminPage.ChooseValueText();
//        sleep(2);
//        showLogs();
//        adminPage.AddCharacteristicButton();
//        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newCharacteristicName + "']")));
//        sleep(2);
//
//    }

    @Test(priority = 5, dependsOnMethods = {"AdminLogin"})
    public void AdminBrand() {
        String newBrandName = "Test Brand " + new Timestamp(System.currentTimeMillis());
        System.out.printf(newBrandName);
        adminPage.Settings();
        adminPage.AddBrand();
        sleep(5);
        adminPage.AddNewBrand();
        sleep(3);
        adminPage.InputBrandName(newBrandName);
        sleep(2);
        adminPage.AddBrandButton();
        showLogs();
        WebElement scrollArea = driver.findElement(By.cssSelector("#app > div:nth-child(5) > div.row"));
        scroll_Page(scrollArea ,100);
        Assert.assertTrue(isElementPreset(By.xpath("//td[text()='" + newBrandName + "']")));
        sleep(3);

    }

    @Test(priority = 6, dependsOnMethods = {"AdminLogin"})
    public void AdminGroup() {
        String newGroupName = "Test Group " + new Timestamp(System.currentTimeMillis());
        System.out.printf(newGroupName);
        adminPage.Settings();
        adminPage.Groups();
        adminPage.AddGroup();
        sleep(10);
        adminPage.InputGroupName(newGroupName);
        sleep(2);
        adminPage.AddGroup();
        sleep(3);
        showLogs();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newGroupName + "']")));
        sleep(2);

    }

    @Test(priority = 7, dependsOnMethods = {"AdminLogin"})
    public void AdminUser() {

        String newCompanyName = "Test Company " + new Timestamp(System.currentTimeMillis());
        String newEmail = "test@gmail.com";
        String newPhone = "380631234566";
        String newName = "Test Name " + new Timestamp(System.currentTimeMillis());
        System.out.printf(newCompanyName);
        System.out.printf(newName);
adminPage.Users();
//            adminPage.ChangeUser();
//            adminPage.DeleteUser.click();
//            sleep(3);
//            adminPage.DeleteUserButton();
            adminPage.AddUser();
            sleep(2);
            adminPage.InputCompanyName(newCompanyName);
            sleep(2);
            adminPage.InputName(newName);
            adminPage.InputPhone(newPhone);
            adminPage.InputEmail(newEmail);

            adminPage.InputPassword("123456");
            adminPage.InputPasswordConfirm("123456");
            adminPage.typeField();
            sleep(5);
            adminPage.Seller();
            sleep(8);
            adminPage.Brand();
            sleep(8);
            adminPage.ChooseBrand();
            sleep(5);
            adminPage.InputStreet("Голубая");
            adminPage.InputStoreNumber("2323");
            sleep(3);
            adminPage.CreateUserButton();
            sleep(2);
            showLogs();
        WebElement scrollArea = driver.findElement(By.cssSelector("#app > div"));
        scroll_Page(scrollArea ,100);
        sleep(3);
        Assert.assertTrue(isElementPreset(By.xpath("//td[text()='" + newCompanyName + "']")));
            sleep(5);


        }


    @Test(priority = 8, dependsOnMethods = {"AdminLogin"})
    public void AdminFilters() {
        adminPage.FiltersButton();
        adminPage.DateField("01-01-2017");
        adminPage.AddFiltersButton();
        sleep(5);
        showLogs();
        Assert.assertTrue(isElementPreset(By.cssSelector("#app > div.container-fluid.no-gutter > div > div > div.applied_filters > a")));
        sleep(2);

    }

    @Test(priority = 9, dependsOnMethods = {"AdminLogin"})
    public void AdminAddProduct() {
        String newArticle = "Test Product " + new Timestamp(System.currentTimeMillis());
        System.out.print(newArticle);
        String newCode = "Test Code " + new Timestamp(System.currentTimeMillis());
        System.out.print(newCode);
        adminPage.AddProductButton();
        sleep(10);
        adminPage.ArticleField(newArticle);
        adminPage.CountField("2");
        adminPage.PhotoDateField("2017-09-05");
        adminPage.PerchasePriceField("200");
        adminPage.CodeField(newCode);
        adminPage.DescriptionField("1111111");
        adminPage.SellingPriceField("300");
        adminPage.AddNewProductButton();
        adminPage.Products();
        sleep(5);
        showLogs();
        Assert.assertTrue(isElementPreset(By.xpath("//td[text()='" + newArticle + "']")));
        sleep(10);

    }
    @Test(priority = 10, dependsOnMethods = {"AdminLogin"})
    public void AdminDownloadForOnlineShop() {
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
        adminPage.DownloadForOnlineShop();
        sleep(10);
        showLogs();
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"app\"]/div/div/div[2]"))); }

    @Test(priority = 11, dependsOnMethods = {"AdminLogin"})
    public void AdminDownloadDescriptionAllProducts() {
        adminPage.FiltersButton();
        sleep(5);
        adminPage.DateField("01-01-2017");
        adminPage.SellerList();
        sleep(3);
        adminPage.SelectSeller();
        sleep(3);
        adminPage.AddFiltersButton();
        sleep(10);
        adminPage.DownloadButton();
        adminPage.DownloadDescription();
        sleep(5);
        showLogs();
        Assert.assertTrue(checkIfElementExists("//*[@id=\"export_all_excel_products\"]"));
    }
    @Test(priority = 12, dependsOnMethods = {"AdminLogin"})
    public void AdminDownloadPhotos() {
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
//        Assert.assertTrue(isResourceAvailableByUrl(By.id("downloadAllProductImages")));
    }

    @Test(priority = 13, dependsOnMethods = {"AdminLogin"})
    public void AdminFullExport() {
        adminPage.FiltersButton();
        sleep(5);
        adminPage.DateField("01-01-2017");
        adminPage.AddFiltersButton();
        sleep(5);
        adminPage.SelectAllProducts();
        adminPage.DownloadButton();
adminPage.DownloadFullExport.click();
sleep(5);
showLogs();
////Assert.assertTrue()

    }
}
