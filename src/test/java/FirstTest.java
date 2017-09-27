import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.*;
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

public class FirstTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminPage adminPage;
    public static Select select;


    @BeforeClass
    public static void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://dev.forsage-studio.com.ua/login");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//        driver = new ChromeDriver(caps);
    }

    public void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }
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
    public void AdminLogin() {
        loginPage.inputLogin("admin@gmail.com");
        loginPage.Password("admin");
        loginPage.LoginSubmit();
        sleep(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/product"));
        analyzeLog();
    }

    @Test(priority = 2, dependsOnMethods = {"AdminLogin"})
    public void AdminSettings() {
        Assert.assertTrue(isElementPreset(By.cssSelector("[id='settingsNavbarDropdown']")));
    }

    @Test(priority = 3, dependsOnMethods = {"AdminLogin"})
    public void AdminCategories() {
        adminPage.Settings();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Категории']")));
        analyzeLog();
    }

    @Test(priority = 4, dependsOnMethods = {"AdminLogin"})
    public void AdminDirectories() {
        adminPage.Settings();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Справочники']")));
        analyzeLog();
    }

    @Test(priority = 5, dependsOnMethods = {"AdminLogin"})
    public void AdminCharacteristics() {
        adminPage.Settings();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Характеристики']")));
        analyzeLog();
    }

    @Test(priority = 6, dependsOnMethods = {"AdminLogin"})
    public void AdminGroups() {

        adminPage.Settings();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Группы']")));

        analyzeLog();
    }

    @Test(priority = 7, dependsOnMethods = {"AdminLogin"})
    public void AdminGuest() {
        adminPage.Settings();

        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Гость']")));
        analyzeLog();
    }

    @Test(priority = 8, dependsOnMethods = {"AdminLogin"})
    public void AdminSupplier() {
        adminPage.Settings();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Поставщик']")));
        sleep(5);
        analyzeLog();
    }

    @Test(priority = 9, dependsOnMethods = {"AdminLogin"})
    public void AdminOnlineShop() {
        adminPage.Settings();

        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Интернет-магазин']")));
        analyzeLog();
    }

    @Test(priority = 10, dependsOnMethods = {"AdminLogin"})
    public void AdminOrderOfcharacteristics() {
        adminPage.Settings();
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Порядок характеристик']")));
        analyzeLog();
    }

    @Test(priority = 11, dependsOnMethods = {"AdminLogin"})
    public void AdminUsers() {
        analyzeLog();
        Assert.assertTrue(isElementPreset(By.linkText("Пользователи")));
    }

    @Test(priority = 12, dependsOnMethods = {"AdminLogin"})
    public void AdminPhotosessions() {

        Assert.assertTrue(isElementPreset(By.linkText("Фотосессии")));
        analyzeLog();
    }

    @Test(priority = 13, dependsOnMethods = {"AdminLogin"})
    public void AdminAddPhotosessions() {

        adminPage.Photosessions();
        Assert.assertTrue(isElementPreset(By.linkText("Добавить фотосессию")));
        analyzeLog();
    }

    @Test(priority = 14, dependsOnMethods = {"AdminLogin"})
    public void AdminPhotosessionFilter() {

        adminPage.Photosessions();
        Assert.assertTrue(isElementPreset(By.cssSelector("#app > div.container > div.both-sides-top-bar > div > div.col-xs-6.col-sm-3 > button")));
        analyzeLog();
    }

    @Test(priority = 15, dependsOnMethods = {"AdminLogin"})
    public void AdminProductFilter() {
        adminPage.Products();
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"app\"]/div[7]/div/div/button")));
        analyzeLog();
    }

    @Test(priority = 16, dependsOnMethods = {"AdminLogin"})
    public void AdminAddProduct() {
        sleep(10);
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"app\"]/div[8]/div[2]/div/div[1]/div/button")));
        analyzeLog();
    }

    @Test(priority = 17, dependsOnMethods = {"AdminLogin"})
    public void AdminEditProduct() {
        sleep(10);
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"editProductsLink\"]")));
        analyzeLog();
    }

    @Test(priority = 18, dependsOnMethods = {"AdminLogin"})
    public void AdminDownload() {
        sleep(10);
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"dropdownMenu1\"]")));
        analyzeLog();

    }

    @Test(priority = 19, dependsOnMethods = {"AdminLogin"})
    public void AdminNews() {
        analyzeLog();

        Assert.assertTrue(isElementPreset(By.linkText("Новости")));
    }

    @Test(priority = 20, dependsOnMethods = {"AdminLogin"})
    public void AdminLogout() {
        loginPage.LogoutButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/login"));
        analyzeLog();

    }

    @Test(priority = 21)
    public void ClientLogin() {
        loginPage.inputLogin("client@gmail.com");
        loginPage.Password("client");
        loginPage.LoginSubmit();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/product"));
        analyzeLog();

    }

    @Test(priority = 22, dependsOnMethods = {"ClientLogin"})
    public void ClientProfile() {
        Assert.assertTrue(isElementPreset(By.linkText("Профиль")));
        analyzeLog();
    }

    @Test(priority = 23, dependsOnMethods = {"ClientLogin"})
    public void ClientSettings() {
        adminPage.Products();
        Assert.assertFalse(isElementPreset(By.linkText("Настройки")));
        analyzeLog();
    }

    @Test(priority = 24, dependsOnMethods = {"ClientLogin"})
    public void ClientPhotosession() {
        Assert.assertFalse(isElementPreset(By.linkText("Фотосессии")));
        analyzeLog();
    }
    @Test(priority = 25, dependsOnMethods = {"ClientLogin"})
    public void ClientFilters() {
        Assert.assertTrue(isElementPreset(By.cssSelector("#app > div.container-fluid.no-gutter > div > div > button")));
        analyzeLog();
    }
    @Test(priority = 26, dependsOnMethods = {"ClientLogin"})
    public void ClientAddProduct() {
        Assert.assertFalse(isElementPreset(By.cssSelector("//*[@id=\"app\"]/div[8]/div[2]/div/div[1]/div/button")));
        analyzeLog();
    }

    @Test(priority = 27, dependsOnMethods = {"ClientLogin"})
    public void ClientEditProduct() {
        Assert.assertFalse(isElementPreset(By.cssSelector("#editProductsLink")));
        analyzeLog();
    }
    @Test(priority = 28, dependsOnMethods = {"ClientLogin"})
    public void ClientDownload() {
        Assert.assertTrue(isElementPreset(By.cssSelector("#dropdownMenu1")));
        analyzeLog();

    }
    @Test(priority = 29, dependsOnMethods = {"ClientLogin"})
    public void ClientNews() {
        Assert.assertTrue(isElementPreset(By.linkText("Новости")));
        analyzeLog();
    }
        @Test(priority = 30, dependsOnMethods = {"ClientLogin"})
        public void ClientUsers() {
            analyzeLog();
            Assert.assertFalse(isElementPreset(By.linkText("Пользователи")));
        }


    @Test(priority = 31, dependsOnMethods = {"ClientLogin"})
    public void ClientLogout() {
        loginPage.LogoutButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/login"));
        analyzeLog();

    }
    @Test(priority = 32)
    public void SupplierLogin() {
        loginPage.inputLogin("supplier@gmail.com");
        loginPage.Password("supplier");
        loginPage.LoginSubmit();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/product"));
        analyzeLog();

    }

    @Test(priority = 33, dependsOnMethods = {"SupplierLogin"})
    public void SupplierProfile() {
        Assert.assertTrue(isElementPreset(By.linkText("Профиль")));
        analyzeLog();
    }

    @Test(priority = 34, dependsOnMethods = {"SupplierLogin"})
    public void SupplierSettings() {
        Assert.assertFalse(isElementPreset(By.linkText("Настройки")));
        analyzeLog();
    }

    @Test(priority = 35, dependsOnMethods = {"SupplierLogin"})
    public void SupplierUsers() {
        analyzeLog();
        Assert.assertFalse(isElementPreset(By.linkText("Пользователи")));
    }

    @Test(priority = 36, dependsOnMethods = {"SupplierLogin"})
    public void SupplierPhotosession() {
        Assert.assertTrue(isElementPreset(By.linkText("Фотосессии")));
        analyzeLog();
    }
    @Test(priority = 37, dependsOnMethods = {"SupplierLogin"})
    public void SupplierPhotosessionFilter() {
        adminPage.Photosessions();
        Assert.assertTrue(isElementPreset(By.cssSelector("#app > div.container > div.both-sides-top-bar > div > div.col-xs-6.col-sm-3 > button")));
        analyzeLog();
    }
    @Test(priority = 38, dependsOnMethods = {"SupplierLogin"})
    public void SupplierFilters() {
        adminPage.Products();
        sleep(5);
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"app\"]/div[7]/div/div/button")));
        analyzeLog();
    }
    @Test(priority = 39, dependsOnMethods = {"SupplierLogin"})
    public void SupplierAddProduct() {
        Assert.assertFalse(isElementPreset(By.cssSelector("//*[@id=\"app\"]/div[8]/div[2]/div/div[1]/div/button")));
        analyzeLog();
    }
    @Test(priority = 40, dependsOnMethods = {"SupplierLogin"})
    public void SupplierAddPhotosession() {
        adminPage.Photosessions();
        Assert.assertFalse(isElementPreset(By.linkText("Добавить фотосессию")));
        analyzeLog();
    }
    @Test(priority = 41, dependsOnMethods = {"SupplierLogin"})
    public void SupplierEditProduct() {
        Assert.assertFalse(isElementPreset(By.cssSelector("#editProductsLink")));
        analyzeLog();
    }
    @Test(priority = 42, dependsOnMethods = {"SupplierLogin"})
    public void SupplierDownload() {
        adminPage.Products();
        sleep(5);
        Assert.assertTrue(isElementPreset(By.xpath("//*[@id=\"dropdownMenu1\"]")));
        analyzeLog();

    }
    @Test(priority = 43, dependsOnMethods = {"SupplierLogin"})
    public void SupplierNews() {
        Assert.assertTrue(isElementPreset(By.linkText("Новости")));
        analyzeLog();

    }
    @Test(priority = 44, dependsOnMethods = {"SupplierLogin"})
    public void SupplierLogout() {
        loginPage.LogoutButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/login"));
        analyzeLog();

    }
    @Test(priority = 45)
    public void GuestLogin() {
       loginPage.Guest();
        sleep(1);
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/product"));
        analyzeLog();

    }

    @Test(priority = 46, dependsOnMethods = {"GuestLogin"})
    public void GuestProfile() {
        Assert.assertFalse(isElementPreset(By.linkText("Профиль")));
        analyzeLog();
    }

    @Test(priority = 47, dependsOnMethods = {"GuestLogin"})
    public void GuestSettings() {
        Assert.assertFalse(isElementPreset(By.linkText("Настройки")));
        analyzeLog();
    }

    @Test(priority = 48, dependsOnMethods = {"GuestLogin"})
    public void GuestPhotosession() {
        Assert.assertFalse(isElementPreset(By.linkText("Фотосессии")));
        analyzeLog();
    }
    @Test(priority = 49, dependsOnMethods = {"GuestLogin"})
    public void GuestFilters() {
        adminPage.Products();
        Assert.assertTrue(isElementPreset(By.cssSelector("<button type=\"button\" class=\"btn btn-primary btn-default filterAddAction\">Фильтры</button>")));
        analyzeLog();
    }
    @Test(priority = 50, dependsOnMethods = {"GuestLogin"})
    public void GuestAddProduct() {
        Assert.assertFalse(isElementPreset(By.cssSelector("//*[@id=\"app\"]/div[8]/div[2]/div/div[1]/div/button")));
        analyzeLog();
    }

    @Test(priority = 51, dependsOnMethods = {"GuestLogin"})
    public void GuestEditProduct() {
        Assert.assertFalse(isElementPreset(By.cssSelector("#editProductsLink")));
        analyzeLog();
    }
    @Test(priority = 52, dependsOnMethods = {"GuestLogin"})
    public void GuestDownload() {
        Assert.assertFalse(isElementPreset(By.cssSelector("#dropdownMenu1")));
        analyzeLog();

    }
    @Test(priority = 53, dependsOnMethods = {"GuestLogin"})
    public void GuestNews() {
        Assert.assertFalse(isElementPreset(By.linkText("Новости")));
        analyzeLog();
    }
        @Test(priority = 54, dependsOnMethods = {"GuestLogin"})
        public void GuestUsers() {
            analyzeLog();
            Assert.assertFalse(isElementPreset(By.linkText("Пользователи")));
        }


    @Test(priority = 55, dependsOnMethods = {"GuestLogin"})
    public void GuestLogout() {
        loginPage.LogoutButton();
        Assert.assertTrue(driver.getCurrentUrl().equals("http://dev.forsage-studio.com.ua/login"));
        analyzeLog();

    }
}



