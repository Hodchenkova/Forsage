import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(css = "input[name='email']")
    public WebElement loginField;
    @FindBy(css = "input[name='password']")
    public WebElement password;
    @FindBy(css ="input[type='submit'],input[class='btn btn-primary auth-btn']")
    public WebElement loginButton;
    @FindBy(linkText = "Выйти")
    public WebElement Logout;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/div/a")
    public WebElement Guest;


    public void inputLogin (String name) {
        loginField.sendKeys(name);
    }
    public void Password( String name) {
        password.sendKeys(name);
    }
    public void LoginSubmit() {
        loginButton.submit();
    }
    public void LogoutButton(){Logout.click();
    }
    public void Guest(){Guest.click();
    }
    //////// Registration
    @FindBy(xpath = "//*[@id=\"login\"]/div[3]/div/div[2]/a")
    public WebElement Registration;
    @FindBy(id = "email")
    public WebElement emailField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "password-confirm")
    public WebElement passwordConfirmField;
    @FindBy(id = "phone")
    public WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"registration\"]/div[6]/div/div/button/span[1]")
    public WebElement typeField;
    @FindBy(xpath = "//*[@id=\"registration\"]/div[6]/div/div/div/ul/li[1]/a/span[1]")
    public WebElement Seller;
    //    @FindBy(css = "#registration > div.form-group.reg-type-group > div > div > div > ul > li.selected > a > span.text")
//    public WebElement onlineShop;
    @FindBy(css = "#registration > div:nth-child(10) > div > div > button > span.filter-option.pull-left")
    public WebElement Brand;
    @FindBy(xpath = "//*[@id=\"registration\"]/div[8]/div/div/div/ul/li[1]/a/span[1]")
    public WebElement ChooseBrand;
    @FindBy(id = "street")
    public WebElement Street;
    @FindBy (id = "store-num")
    public WebElement StoreNumber;

    //    @FindBy(css = "site")
//    public WebElement siteAdressField;
    @FindBy(css = "#registration > div.form-group.reg-submit-group > div > div:nth-child(1) > input")
    public WebElement registrationButton;

    public void Registration(){
        Registration.click();
    }
    public void inputEmail (String email) {
        emailField.sendKeys("ctapto@gmail.com");
    }
    public void inputPassword (String password) {
        passwordField.sendKeys("123456");
    }
    public void inputConfirmPassword (String ConfirmPassword) {
        passwordConfirmField.sendKeys("123456");
    }
    public void inputPhone (String phone) {
        phoneField.sendKeys("380634567897");
    }
    public void chooseType(){
        typeField.click();
    }
    public void Seller() {
        Seller.click();
    }
    public void chooseBrand() {
        Brand.click();
    }
    public void newBrand(){
        ChooseBrand.click();
    }
    public void InputStreetNumber(String store){
        Street.sendKeys("Голубая");
    }

    public void InputStoreNumber(String store){
        StoreNumber.sendKeys("2222");

    }
    public void Register() {
        registrationButton.submit();
    }


}

