package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradePackCompleteCheckoutPage extends TradePackBasic{

    @FindBy(xpath = "//a[@href='/logout/' and @title='Изход']")
    private WebElement logoutButton;
    @FindBy(xpath = "//input[@id='nextBtn' and @class='submit' and @type='submit' and @value='Поръчай']")
    private WebElement orderButton;
    @FindBy(xpath = "//input[@type='checkbox' and @name='agreeWithTerms' and @value='1']")
    private WebElement agreeWithTermsCheckbox;

    public TradePackCompleteCheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public TradePackFinalPage submitOrderOrBackToHome () {

        logoutButton.click();

        return new TradePackFinalPage(driver);
    }

}
