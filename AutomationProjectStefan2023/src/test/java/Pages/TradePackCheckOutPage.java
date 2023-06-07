package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TradePackCheckOutPage extends TradePackBasic {
    @FindBy(xpath = "//input[@id = 'name']")
    private WebElement clientCheckOutName;
    @FindBy(xpath = "//input[@id = 'nameLast']")
    private WebElement clientCheckOutNameLast;
    @FindBy(xpath = "//input[@id = 'phone']")
    private WebElement clientCheckOutPhone;
    @FindBy(xpath = "//input[@id = 'cityName']")
    private WebElement clientCheckOutCity;
    @FindBy(xpath = "//input[@id = 'address']")
    private WebElement clientCheckOutAddress;
    @FindBy(xpath = "//input[@id = 'nextBtn']")
    private WebElement completeCheckOutBtn;

    public TradePackCheckOutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public TradePackCompleteCheckoutPage clientData (String name, String nameLast, String phone, String cityName, String address) {
        clientCheckOutName.click();
        clientCheckOutName.clear();
        clientCheckOutName.sendKeys(name);

        clientCheckOutNameLast.click();
        clientCheckOutNameLast.clear();
        clientCheckOutNameLast.sendKeys(nameLast);

        clientCheckOutPhone.click();
        clientCheckOutPhone.clear();
        clientCheckOutPhone.sendKeys(phone);

        clientCheckOutCity.click();
        clientCheckOutCity.clear();
        clientCheckOutCity.sendKeys(cityName);

        clientCheckOutAddress.click();
        clientCheckOutAddress.clear();
        clientCheckOutAddress.sendKeys(address);

        completeCheckOutBtn.click();

        return new TradePackCompleteCheckoutPage(driver);
    }
}

