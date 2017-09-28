import org.junit.runners.AllTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    public static void Logs() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.SERVER, Level.ALL);
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        driver = new ChromeDriver(capabilities);
    }
    @BeforeClass
    public static void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        LoggingPreferences loggingprefs = new LoggingPreferences();
//        loggingprefs.enable(LogType.BROWSER, Level.ALL);
//        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
//        driver = new ChromeDriver(capabilities);
    }



//    public void ExtractJSLogs() {
//        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
//        Logs log = driver.manage().logs();
//        List<LogEntry> logsEntries = log.get("browser").getAll();
//        for (LogEntry entry : logEntries) {
//            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
//        }
//    }



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
    public void AdminLogin() {
        driver.get("http://test.forsage-studio.com.ua/login");
        loginPage.inputLogin("admin@gmail.com");
        loginPage.Password("admin");
        loginPage.LoginSubmit();
        sleep(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("http://test.forsage-studio.com.ua/product"));
//        ExtractJSLogs();
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
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newDirectoryName + "']")));
        sleep(2);

    }

    @Test(priority = 4, dependsOnMethods = {"AdminLogin"})
    public void AdminCharacteristics() {
        String newCharacteristicName = "Test Characteristic " + new Timestamp(System.currentTimeMillis());
        String newDirectoryValue = "грн";
        System.out.printf(newCharacteristicName);
        adminPage.Settings();
        adminPage.Characteristics();
        adminPage.AddCharacteristic();
        sleep(10);
        adminPage.InputCharacteristicName(newCharacteristicName);
        sleep(2);
        adminPage.ChooseCharacteristicsValue();
        sleep(2);
        adminPage.ChooseValueText();
        sleep(2);
        adminPage.AddCharacteristicButton();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newCharacteristicName + "']")));
        sleep(2);

    }

    @Test(priority = 5, dependsOnMethods = {"AdminLogin"})
    public void AdminBrand() {
        String newBrandName = "Test Brand " + new Timestamp(System.currentTimeMillis());
        System.out.printf(newBrandName);
        adminPage.Settings();
        adminPage.Brand();
        adminPage.AddBrand();
        sleep(10);
        adminPage.InputBrandName(newBrandName);
        sleep(2);
        adminPage.AddBrandButton();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newBrandName + "']")));
        sleep(2);

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
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newGroupName + "']")));
        sleep(2);

    }

    @Test(priority = 7, dependsOnMethods = {"AdminLogin"})
    public void AdminUser() {
        int i = 1;
        int n = 1;

        String newCompanyName = "Test Company " + new Timestamp(System.currentTimeMillis());
        String newEmail = i + "test@gmail.com";
        String newPhone = "380631234566";
        String newName = "Test Name " + new Timestamp(System.currentTimeMillis());
        System.out.print(newCompanyName);
        System.out.print(newName);
//
//        do  {n++;
//            System.out.print( newPhone + n);}
//         while (n<10);

        while (true) {
            System.out.print(i + newEmail);
            i++;
//        System.out.print(newPhone + n);
            adminPage.Users();
            sleep(5);
            adminPage.ChangeUser();
            adminPage.DeleteUser.click();
            sleep(3);
            adminPage.DeleteUserButton();
            adminPage.Users();
            adminPage.AddUser();
            sleep(2);
            adminPage.InputCompanyName(newCompanyName);
            sleep(2);
            adminPage.InputName(newName);
            adminPage.InputPhone(newPhone);
            adminPage.InputEmail(i + newEmail);

            adminPage.InputPassword("123456");
            adminPage.InputPasswordConfirm("123456");
            adminPage.typeField();
            sleep(5);
            adminPage.Seller();
            sleep(7);
            adminPage.Brand();
            sleep(5);
            adminPage.ChooseBrand();
            sleep(5);
            adminPage.InputStreet("Голубая");
            adminPage.InputStoreNumber("2323");
            adminPage.CreateUserButton();
            Assert.assertTrue(isElementPreset(By.xpath("//a[text()='" + newName + "']")));
            sleep(5);



        }
    }

    @Test(priority = 8, dependsOnMethods = {"AdminLogin"})
    public void AdminFilters() {
        adminPage.FiltersButton();
        adminPage.DateField("01-01-2017");
        adminPage.AddFiltersButton();
        sleep(2);
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"app\"]/div[7]/div/div/div[1]/a")));
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
        Assert.assertTrue(isElementPreset(By.xpath("//td[text()='" + newArticle + "']")));
        sleep(10);

    }


    @Test(priority = 10, dependsOnMethods = {"AdminLogin"})
    public void AdminEditProduct() {
//        adminPage.FiltersButton();
//        adminPage.DateField("01-01-2017");
//        adminPage.AddFiltersButton();
//        sleep(3);
        adminPage.SelectProduct();
        adminPage.EditButton();
//        ExtractJSLogs();

    }
}
