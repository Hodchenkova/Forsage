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
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class PhotosessionTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminPage adminPage;
    public static HelperPage helperPage;
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

    public void showLogs() {
        logEntries = driver.manage().logs().get(LogType.BROWSER);
        logConsoleEntries(logEntries);
    }

    public void sleep(int time) {
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

    public static void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
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
    @Title("Создание новой фотосессии")
    @Description("В этом тесте создается новая фотосессия: импорт таблицы Excele, импорт фото, публикация фотосессии")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, dependsOnMethods = {"AdminLogin"})
    @Step("Заполнение необходимых данных для создания фотосессии")
    public void CreatePhotosession() throws AWTException {

        adminPage.Photosessions();
        adminPage.AddPhotosession();
        adminPage.SellerField();
        sleep(3);
       adminPage.ChooseSeller();
        adminPage.InputDate("\b\b\b\b\b\b\b\b\b\b 06-09-2017");
        adminPage.CategoryField();
        sleep(3);
        adminPage.ChooseCategory();
        adminPage.InputProductsCount("30");
        adminPage.InputAnglesCount("\b\b 1, ENTER");
        adminPage.SavePhotosessionButton();
        showLogs();
//        @Step("Импорт таблицы Excele")

        File file = new File("C:\\Users\\Admin\\Desktop\\Форсаж exeles\\TEST\\TEST");
        adminPage.UploadButton();
        adminPage.UploadExele();
        setClipboardData(file.getAbsolutePath());
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(300);
        sleep(5);

        adminPage.AddExelButton();
        sleep(3);
        adminPage.SaveExele();
        sleep(10);
        showLogs();

//        @Step("Импорт фото обложки и ракурсов")
//        public void UploadPhotos() throws AWTException {
            File file1 = new File("C:\\Users\\Admin\\Desktop\\Форсаж фото\\TEST\\2\\\"1\" \"2\" \"3\" \"4\" \"5\" \"6\" \"7\" \"8\" \"9\" \"10\" \"11\" \"12\" \"13\" \"14\" \"15\" \"16\" \"17\" \"18\" \"19\" \"20\" \"21\" \"22\" \"23\" \"24\" \"25\" \"26\" \"27\" \"28\" \"29\" \"30\" ");
        adminPage.UploadButton();
        adminPage.UploadCoverPhoto();
        setClipboardData(file1.getAbsolutePath());
        Robot rb = new Robot();
        rb.delay(1000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.delay(300);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.delay(300);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(300);
        adminPage.UploadButton();
        adminPage.UploadAngelPhoto();
        rb.delay(1000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.delay(300);
        rb.keyPress(KeyEvent.VK_V);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_V);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.delay(300);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.delay(300);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.delay(300);
        sleep(10);
            showLogs();


//    @Step("Сохранение и публикация")
//    public void savePhotosession() throws AWTException {
        adminPage.SavePhotosessionButton();
        sleep(40);
//        adminPage.ShowPhotosession();
        adminPage.Publicate();
        showLogs();
        adminPage.Photosessions();
        Assert.assertTrue(isElementPreset(By.xpath("//td[text()='Navigator']")));

    }

    @Test(priority = 2, dependsOnMethods = {"AdminLogin"})
    public void AddNewPhotosession1() throws AWTException {
        adminPage.Photosessions();
        sleep(5);
        Assert.assertTrue(isElementPreset(By.xpath("//a[text()='Company']")));


    }
}
