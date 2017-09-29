import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ENTER;

public class AdminPage {
    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    // Settings, Add Category
    @FindBy(xpath = "//*[@id=\"app-navbar-collapse\"]/ul[2]/li[1]/div/ul/li[1]/a")
    public WebElement Categories;
    @FindBy(xpath = "//*[@id=\"addCategoryLink\"]")
    public WebElement AddCategory;
    @FindBy(xpath = "//*[@id=\"parentCategorySelect\"]/div/button")
    public WebElement ChooseParentCategory;
    @FindBy(xpath = "//*[@id=\"parentCategorySelect\"]/div/div/ul/li[2]/a")
    public WebElement ChooseShooes;
    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement InputCategoryName;
    @FindBy(xpath = "//*[@id=\"add_category_btn\"]")
    public WebElement AddCategoryButton;
    @FindBy(xpath = "//*[@id=\"addCategory\"]/div[2]/div/button")
    public WebElement CancelAddCategoryButton;
//    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[1]/td[2]/a")
//    public WebElement ChangeCategory;
//    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[1]/td[2]/form/input[3]")
//    public WebElement DeleteCategory;

    public void Categories() {
        Categories.click();
    }

    public void AddCategory() {
        AddCategory.click();
    }

    public void ChooseParentCategory() {
        ChooseParentCategory.click();
    }

    public void ChooseShoes() {
        ChooseShooes.click();
    }

    public void InputCategoryName(String name) {
        InputCategoryName.sendKeys(name);
    }

    public void AddCategoryButton() {
        AddCategoryButton.submit();
    }

    public void CancelAddCategoryButton() {
        CancelAddCategoryButton.click();
    }

    // Add Directory
    @FindBy(css = "#app-navbar-collapse > ul.nav.navbar-nav.navbar-right > li:nth-child(1) > div > ul > li:nth-child(2) > a")
    public WebElement Directory;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div[1]/div/div[2]/a")
    public WebElement AddDirectory;
    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement InputDirectoryName;
    @FindBy(xpath = "//*[@id=\"value\"]")
    public WebElement InputDirectoryValue;
    @FindBy(xpath = "//*[@id=\"addRefbook\"]/div[1]/div[3]/div/a")
    public WebElement AddAnotherValue;
    @FindBy(xpath = "//*[@id=\"addRefbook\"]/div[1]/div[3]/div/input")
    public WebElement InputAnotherValue;
    @FindBy(xpath = "//*[@id=\"addRefbook\"]/div[2]/div/input")
    private WebElement AddDirectoryButton;
    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[1]/td[2]/a")
    public WebElement ChangeDirectory;
    @FindBy(xpath = "//*[@id=\"addRefbook\"]/div[2]/div/button")
    public WebElement CancleAddDirectoryButton;

    public void Directory() {
        Directory.click();
    }

    public void AddDirectory() {
        AddDirectory.click();
    }

    public void InputDirectoryName(String name) {
        InputDirectoryName.sendKeys(name);
    }

    public void InputDirectoryValue(String name) {
        InputDirectoryValue.sendKeys(name);
    }

    public void AddAnotherValue() {
        AddAnotherValue.click();
    }

    public void InputAnotherValue(String name) {
        InputAnotherValue.sendKeys(name);
    }

    public void AddDirectoryButton() {
        AddDirectoryButton.submit();
    }

    public void ChangeDirectory() {
        ChangeDirectory.click();
    }

    public void CancleAddDirectoryButton() {
        CancleAddDirectoryButton.click();
    }

    // Add Characteristics
    @FindBy(xpath = "//*[@id=\"app-navbar-collapse\"]/ul[2]/li[1]/div/ul/li[3]/a")
    public WebElement Characteristics;
    @FindBy(xpath = "//*[@id=\"app\"]/div[5]/div[1]/div/div[2]/a")
    public WebElement AddCharacteristic;
    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement InputCharacteristicName;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[1]/div[2]/div/div/button")
    public WebElement ChooseCharacteristicsValue;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[1]/div[2]/div/div/div/ul/li[4]/a")
    public WebElement ChooseValueDirectory;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[1]/div[2]/div/div/div/ul/li[1]/a")
    public WebElement ChooseValueText;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[1]/div[2]/div/div/div/ul/li[2]/a/span[1]")
    public WebElement ChooseValuePhoto;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[1]/div[2]/div/div/div/ul/li[3]/a")
    public WebElement ChooseValueNumber;

    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[1]/div[3]/div/div/button/span[1]")
    public WebElement ChooseDirectory;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[1]/div[3]/div/div/button")
    public WebElement ChooseTypeofDirectory;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[2]/div/input")
    public WebElement AddCharacteristicButton;
    @FindBy(xpath = "//*[@id=\"addCharacteristic\"]/div[2]/div/button")
    public WebElement CancelCharacteristicButton;
//    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[1]/td[3]")
//    public WebElement RenameCharacteristic;
//    @FindBy(xpath = "//*[@id=\"name\"]")
//    public WebElement InputNewCharacteristicName;
//    @FindBy(xpath = "//*[@id=\"editCharacteristic\"]/div[2]/div/input")
//    public WebElement RenameCharacteristicButton;

    public void Characteristics() {
        Characteristics.click();
    }

    public void AddCharacteristic() {
        AddCharacteristic.click();
    }

    public void InputCharacteristicName(String name) {
        InputCharacteristicName.sendKeys(name);
    }

    public void ChooseCharacteristicsValue() {
        ChooseCharacteristicsValue.click();
    }

    public void ChooseValueDirectory() {
        ChooseValueDirectory.click();
    }

    public void ChooseValueText() {
        ChooseValueText.click();
    }

    public void ChooseValuePhoto() {
        ChooseValuePhoto.click();
    }

    public void ChooseValueNumber() {
        ChooseValueNumber.click();
    }

    public void ChooseDirectory() {
        ChooseDirectory.click();
    }

    public void ChooseTypeofDirectory() {
        ChooseTypeofDirectory.click();
    }

    public void AddCharacteristicButton() {
        AddCharacteristicButton.submit();
    }

    public void CancelCharacteristicButton() {
        CancelCharacteristicButton.submit();
    }

    //Add Brand
    @FindBy(id = "settingsNavbarDropdown")
    public WebElement Settings;
    @FindBy(css = "#app-navbar-collapse > ul.nav.navbar-nav.navbar-right > li:nth-child(1) > div > ul > li:nth-child(4) > a")
    public WebElement AddBrand;
    @FindBy(css = "#app > div:nth-child(5) > div.both-sides-top-bar > div > div.col-xs-6.col-sm-9 > a")
    public WebElement AddNewBrand;
    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement InputBrandName;
    @FindBy(xpath = "//*[@id=\"addBrand\"]/div[2]/div/input")
    public WebElement AddBrandButton;
    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[38]/td[2]/form/input[3]")
    public WebElement DeleteBrand;
    @FindBy(xpath = "//*[@id=\"addBrand\"]/div[2]/div/button")
    public WebElement CancleAddBrand;

    public void Settings() {
        Settings.click();
    }

    public void AddBrand() {
        AddBrand.click();

    }

    public void AddNewBrand() {
        AddNewBrand.click();

    }

    public void InputBrandName(String name) {
        InputBrandName.sendKeys(name);
    }

    public void AddBrandButton() {
        AddBrandButton.submit();
    }

    public void DeleteBrand() {
        DeleteBrand.submit();
    }

    public void CancleAddBrand() {
        CancleAddBrand.click();
    }

    // Add Groups
    @FindBy(xpath = "//*[@id=\"app-navbar-collapse\"]/ul[2]/li[1]/div/ul/li[5]/a")
    public WebElement Groups;
    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div[1]/div/div[2]/a")
    public WebElement AddGroup;
    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement InputGroupName;
    @FindBy(xpath = "//*[@id=\"addGroup\"]/div[2]/div/input")
    public WebElement AddGroupButton;


    public void Groups() {
        Groups.click();
    }

    public void AddGroup() {
        AddGroup.click();
    }

    public void AddGroupButton() {
        AddGroupButton.click();
    }
    public void InputGroupName(String name) {
        InputGroupName.sendKeys(name);
    }

///// Add user

    @FindBy(linkText = "Пользователи")
    public WebElement Users;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/a")
    public WebElement AddUser;
    @FindBy(id = "companyName")
    public WebElement InputCompanyName;
    @FindBy(id = "fullName")
    public WebElement InputName;
    @FindBy(id = "phone")
    public WebElement InputPhone;
    @FindBy(id = "email")
    public WebElement InputEmail;
    @FindBy(id = "password")
    public WebElement InputPassword;
    @FindBy(id = "password-confirm")
    public WebElement InputPasswordConfirm;
    @FindBy(xpath = "//*[@id=\"userInfo\"]/div/div/div[7]/div/div/button/span[1]")
    public WebElement typeField;
    @FindBy(xpath = "//*[@id=\"userInfo\"]/div/div/div[7]/div/div/div/ul/li[1]/a/span[1]")
    public WebElement Seller;
    //    @FindBy(xpath = "//*[@id=\"userInfo\"]/div/div/div[7]/div/div/div/ul/li[2]/a")
//    public WebElement OnlineShop;
//    @FindBy(xpath = "//*[@id=\"userInfo\"]/div/div/div[7]/div/div/div/ul/li[3]/a/span[1]")
//    public WebElement Operator;
    @FindBy(xpath = "//*[@id=\"userInfo\"]/div/div/div[9]/div/div/button/span[1]")
    public WebElement Brand;
    @FindBy(xpath = "//*[@id=\"userInfo\"]/div/div/div[9]/div/div/div/ul/li[1]/a/span[1]")
    public WebElement ChooseBrand;
    @FindBy(id = "street")
    public WebElement InputStreet;
    @FindBy(id = "store-num")
    public WebElement InputStoreNumber;
    //    @FindBy(id = "site")
//    public WebElement siteAdressField;
    @FindBy(xpath = "//*[@id=\"userInfo\"]/div/div/div[11]/input")
    public WebElement CreateUserButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr[6]/td[8]/a")
    public WebElement ChangeUser;
    @FindBy(xpath = "//*[@id=\"status\"]")
    public WebElement ActivateUser;
    @FindBy(xpath = "//*[@id=\"deleteUserForm\"]/input[3]")
    public WebElement DeleteUser;
    @FindBy(xpath = "//*[@id=\"deleteUserModalBtn\"]")
    public WebElement DeleteUserButton;

    public void Users() {
        Users.click();
    }

    public void AddUser() {
        AddUser.click();
    }

    public void InputCompanyName(String name) {
        InputCompanyName.sendKeys(name);
    }

    public void InputName(String name) {
        InputName.sendKeys(name);
    }

    public void InputPhone(String name) {
        InputPhone.sendKeys(name);
    }

    public void InputEmail(String name) {
        InputEmail.sendKeys(name);
    }

    public void InputPassword(String password) {
        InputPassword.sendKeys("123456");
    }

    public void InputPasswordConfirm(String passwordconfirm) {
        InputPasswordConfirm.sendKeys("123456");
    }

    public void typeField() {
        typeField.click();
    }

    public void Seller() {
        Seller.click();
    }

    public void Brand() {
        Brand.click();
    }

    public void ChooseBrand() {
        ChooseBrand.click();
    }

    public void InputStreet(String street) {
        InputStreet.sendKeys("Голубая");
    }

    public void InputStoreNumber(String number) {
        InputStoreNumber.sendKeys("2323");
    }

    public void CreateUserButton() {
        CreateUserButton.submit();
    }

    public void ChangeUser() {
        ChangeUser.click();
    }

    public void ActivateUser() {
        ActivateUser.click();
    }
    public void DeleteUserButton() {
        DeleteUserButton.click();
    }

    // Add Photosession

    @FindBy(linkText = "Фотосессии")
    public WebElement Photosessions;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div[1]/div/div[2]/a")
    public WebElement AddPhotosession;
    @FindBy(xpath = "//*[@id=\"supplierSelect\"]/div/button/span[1]")
    public WebElement SellerField;
    @FindBy(xpath = "//*[@id=\"supplierSelect\"]/div/div/ul/li[2]/a")
    public WebElement ChooseSeller;
    @FindBy(id = "created")
    public WebElement InputDate;
    @FindBy(xpath = "//*[@id=\"categorySelect\"]/div/button/span[1]")
    public WebElement CategoryField;
    @FindBy(xpath = "//*[@id=\"categorySelect\"]/div/div/ul/li[13]/a")
    public WebElement ChooseCategory;
    @FindBy(xpath = "//*[@id=\"products_count\"]")
    public WebElement InputProductsCount;
    @FindBy(xpath = "//*[@id=\"angles_count\"]")
    public WebElement InputAnglesCount;
    @FindBy(xpath = "//*[@id=\"addPhotosession\"]/div[6]/div/input")
    public WebElement AddPhotosessionButton;
    @FindBy(xpath = "//*[@id=\"photosessionActionsDropdown\"]")
    public WebElement UploadButton;
    @FindBy(xpath = "//*[@id=\"photosessionImportExcel\"]")
    public WebElement UploadExele;


    @FindBy(xpath = "//*[@id=\"photosessionCoverPhoto\"]")
    public WebElement UploadCoverPhoto;
    @FindBy(xpath = "//*[@id=\"photosessionAnglePhoto\"]")
    public WebElement UploadAngelPhoto;
    //    @FindBy(xpath = "//*[@id=\"draggable-tr-1\"]/td[1]/div/button")
//    public WebElement DeleteProduct;
//    @FindBy(id = "addNewProduct")
//    public WebElement AddNewProduct;
    @FindBy(xpath = "//*[@id=\"created\"]")
    public WebElement InputDateField;
    @FindBy(xpath = "//*[@id=\"bulkSave\"]/div[1]/div/div/div/div[5]/div/div/input")
    public WebElement SavePhotosessionButton;
    @FindBy(xpath = "//*[@id=\"bulkSave\"]/div[1]/div/div/div/div[5]/div/div/div/input")
    public WebElement ShowPhotosession;
    @FindBy(xpath = "//*[@id=\"import-preview\"]")
    public WebElement AddExelButton;
    @FindBy(xpath = "//*[@id=\"saveMatchedPhotosession\"]/input[7]")
    public WebElement SaveExele;
    @FindBy(xpath = "//*[@id=\"publish-submit\"]")
    public WebElement Publicate;


    public void Photosessions() {
        Photosessions.click();
    }

    public void AddPhotosession() {
        AddPhotosession.click();
    }

    public void SellerField() {
        SellerField.click();
    }

    public void ChooseSeller() {
        ChooseSeller.click();
    }

    public void InputDate(String date) {
        InputDate.sendKeys("06-09-2017");
    }

    public void CategoryField() {
        CategoryField.click();
    }

    public void ChooseCategory() {
        ChooseCategory.click();
    }

    public void InputProductsCount(String productCounts) {
        InputProductsCount.sendKeys("30");
    }

    public void InputAnglesCount(String angleCounts) {
        InputAnglesCount.sendKeys("\b\b 1");
        InputAnglesCount.sendKeys(ENTER);
    }


    public void AddPhotosessionButton() {
        AddPhotosessionButton.click();
    }

    public void UploadButton() {
        UploadButton.click();
    }

    public void UploadExele() {
        UploadExele.click();
    }

    public void UploadCoverPhoto() {
        UploadCoverPhoto.click();

    }

    public void UploadAngelPhoto() {
        UploadAngelPhoto.click();
    }

    //    public void DeleteProduct() {
//        DeleteProduct.click();
//    }
//    public void AddNewProduct() {
//        AddNewProduct.click();
//    }
    public void AddExelButton() {
        AddExelButton.submit();
    }

    public void SaveExele() {
        SaveExele.submit();
    }
    public void InputDateField(String date) {
        InputDateField.sendKeys("\b\b\b\b\b\b\b\b\b\b 29-09-2017");
    }

    public void ShowPhotosession() {
        ShowPhotosession.click();
    }

    public void SavePhotosessionButton() {
        SavePhotosessionButton.submit();
    }
    public void Publicate() {
        Publicate.submit();
    }

    // Change Photosession
    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[2]/td[1]/a")
    public WebElement OpenPhotosession;
    @FindBy(xpath = "//*[@id=\"clearPhotos\"]")
    public WebElement CleanPhoto;

    public void OpenPhotosession() {
        OpenPhotosession.click();
    }

    public void CleanPhoto() {
        CleanPhoto.click();
    }

    ////Filters
    @FindBy(linkText = "Товары")
    public WebElement Products;
    @FindBy(css = "#app > div.container-fluid.no-gutter > div > div > button")
    public WebElement FiltersButton;
    @FindBy(xpath = "//*[@id=\"filterProductForm\"]/div[1]/div[1]/div/div/button/span[1]")
    public WebElement CategoryList;
    @FindBy(xpath = "//*[@id=\"createdfrom\"]")
    public WebElement DateField;
    @FindBy(xpath = "//*[@id=\"filterProductForm\"]/div[1]/div[1]/div/div/div/ul/li[4]/a")
    public WebElement SelectCategory;
    @FindBy(xpath = "//*[@id=\"filterProductForm\"]/div[1]/div[4]/div/div/button")
    public WebElement SellerList;
    @FindBy(xpath = "//*[@id=\"filterProductForm\"]/div[1]/div[4]/div/div/div/ul/li[1]/a")
    public WebElement SelectSeller;
    @FindBy(xpath = "//*[@id=\"filterProductForm\"]/div[2]/div/input")
    public WebElement AddFiltersButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[7]/div/div/div[1]/a")
    public WebElement ResetFilterButton;

    public void Products() {
        Products.click();
    }
    public void FiltersButton() {
        FiltersButton.click();
    }

    public void CategoryList() {
        CategoryList.click();
    }

    public void SelectSeller() {
        SelectSeller.click();
    }

    public void SelectCategory() {
        SelectCategory.click();
    }

    public void SellerList() {
        SellerList.click();
    }

    public void DateField(String date) {
        DateField.sendKeys("01-01-2017");
    }

    public void AddFiltersButton() {
        AddFiltersButton.submit();
    }
    public void  ResetFilterButton() {
        ResetFilterButton.submit();
    }

    //// Download products

    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[1]/td[1]/input")
    public WebElement SelectProduct;
    @FindBy(id = "selectAllProducts")
    public WebElement SelectAllProducts;
    @FindBy(id = "dropdownMenu1")
    public WebElement DownloadButton;
    @FindBy(xpath = "//*[@id=\"export_all_excel_products_hrefs\"]")
    public WebElement DownloadForOnlineShop;
    @FindBy(id = "export_all_excel_products")
    public WebElement DownloadDescription;
    @FindBy(id = "downloadAllProductImages")
    public WebElement DownloadPhotos;

    public void SelectProduct() {
        SelectProduct.click();
    }

    public void SelectAllProducts() {
        SelectAllProducts.click();
    }

    public void DownloadButton() {
        DownloadButton.click();
    }

    public void DownloadForOnlineShop() {
        DownloadForOnlineShop.click();
    }

    public void DownloadDescription() {
        DownloadDescription.click();
    }

    public void DownloadPhotos() {
        DownloadPhotos.click();
    }

    ////Edit Products

    @FindBy(xpath = "//*[@id=\"editProductsLink\"]")
    public WebElement EditButton;
    @FindBy(xpath = "//*[@id=\"editProductForm\"]/div[1]/div[3]/div/div/button/span[1]")
    public WebElement BrandList;
    @FindBy(xpath = "//*[@id=\"editProductForm\"]/div[1]/div[3]/div/div/div/ul/li[2]/a")
    public WebElement SelectBrand;
    @FindBy(xpath = "//*[@id=\"editProductForm\"]/div[2]/div/input")
    public WebElement SaveButton;

    public void EditButton() {
        EditButton.click();
    }

    public void BrandList() {
        BrandList.click();
    }

    public void SelectBrand() {
        SelectBrand.click();
    }

    public void SaveButton() {
        SaveButton.submit();
    }

    //// Add Product

    @FindBy(xpath = "//*[@id=\"app\"]/div[8]/div[2]/div/div[1]/div/button")
    public WebElement AddProductButton;
    @FindBy(xpath = "//*[@id=\"vcode\"]")
    public WebElement ArticleField;
    @FindBy(xpath = "//*[@id=\"quantity\"]")
    public WebElement CountField;
    @FindBy(xpath = "//*[@id=\"characteristic_23\"]")
    public WebElement PhotoDateField;
    @FindBy(xpath = "//*[@id=\"characteristic_24\"]")
    public WebElement PerchasePriceField;
    @FindBy(xpath = "//*[@id=\"characteristic_25\"]")
    public WebElement CodeField;
    @FindBy(xpath = "//*[@id=\"characteristic_26\"]")
    public WebElement DescriptionField;
    @FindBy(xpath = "//*[@id=\"characteristic_29\"]")
    public WebElement SellingPriceField;
    @FindBy(xpath = "//*[@id=\"addProductForm\"]/div[2]/div/input")
    public WebElement AddNewProductButton;
    @FindBy(xpath = "//*[@id=\"addProductForm\"]/div[2]/div/button")
    public WebElement CancelAddNewProductButton;

    public void AddProductButton() {
        AddProductButton.sendKeys(Keys.ENTER);
    }

    public void ArticleField(String name) {
        ArticleField.sendKeys(name);
    }

    public void CountField(String count) {
        CountField.sendKeys("2");
    }

    public void PhotoDateField(String count) {
        PhotoDateField.sendKeys("2017-09-05");
    }

    public void PerchasePriceField(String count) {
        PerchasePriceField.sendKeys("200");
    }

    public void CodeField(String name) {
        CodeField.sendKeys(name);
    }

    public void DescriptionField(String count) {
        DescriptionField.sendKeys("1111111");
    }

    public void SellingPriceField(String count) {
        SellingPriceField.sendKeys("300");
    }

    public void AddNewProductButton() {
        AddNewProductButton.submit();
    }
    public void CancelAddNewProductButton() {
        CancelAddNewProductButton.submit();
    }
    /////News

    @FindBy(xpath = "//*[@id=\"app-navbar-collapse\"]/ul[1]/li[3]/a")
    public WebElement News;
    @FindBy(xpath = "//*[@id=\"productsTable\"]/tbody/tr[1]/td[1]/a")
    public WebElement ChooseNews;
    @FindBy(xpath = "//*[@id=\"changesTable\"]/tbody/tr/td[1]/input")
    public WebElement SelectChange;
    @FindBy(xpath = "//*[@id=\"selectAllChanges\"]")
    public WebElement SelectAllChanges;
    @FindBy(xpath = "//*[@id=\"dropdownMenu1\"]")
    public WebElement ActionsButton;
    @FindBy(xpath = "//*[@id=\"approve_product_change\"]")
    public WebElement PublicateEdits;
    @FindBy(xpath = "//*[@id=\"rejectChanges\"]")
    public WebElement Reject;

    public void News() {
        News.click();
    }

    public void ChooseNews() {
        ChooseNews.click();
    }

    public void SelectChange() {
        SelectChange.click();
    }

    public void SelectAllChanges() {
        SelectAllChanges.click();
    }

    public void ActionsButton() {
        ActionsButton.click();
    }

    public void PublicateEdits() {
        PublicateEdits.click();
    }

    public void Reject() {
        Reject.click();
    }

    // Profile

    @FindBy(xpath = "//*[@id=\"app-navbar-collapse\"]/ul[2]/li[1]/a")
    public WebElement Profile;

    public void Profile() {
        Profile.click();
    }

    ///Photosession Filters
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div[1]/div/div/button")
    public WebElement FiltersPhotosessionButton;
    @FindBy(xpath = "//*[@id=\"createdfrom\"]")
    public WebElement DateCreateBeforeField;
    @FindBy(xpath = "//*[@id=\"filterPhotosessionsForm\"]/div[2]/div/input")
    public WebElement AddPhotosessionFilter;

    public void FiltersPhotosessionButton() {
        FiltersPhotosessionButton.click();
    }
    public void DateCreateBeforeField (String date) {
        DateCreateBeforeField.sendKeys("01-01-2017");
    }
    public void AddPhotosessionFilter () {
        AddPhotosessionFilter.submit();
    }
}
