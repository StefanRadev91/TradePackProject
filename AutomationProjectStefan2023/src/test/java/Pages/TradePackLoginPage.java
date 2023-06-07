package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradePackLoginPage extends TradePackBasic {


    @FindBy(xpath = "//input[@id = 'usernameInp']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id = 'passwordInp']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id = 'submitBtn']")
    private WebElement loginBtn;
    public TradePackLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public TradePackProfilePage login(String email, String password){

        usernameInput.click();
        usernameInput.clear();
        usernameInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
        return new TradePackProfilePage(driver);
    }

}