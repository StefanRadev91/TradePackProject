package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TradePackProfilePage extends TradePackBasic {

        @FindBy(id = "user-info")
        private WebElement userInfo;
        @FindBy (id = "user-edit")
        private WebElement userEdit;
        @FindBy(className = "logo")
        private WebElement tradePackLogo;
        @FindBy (xpath = "//a[@class='submit left' and text()='Към онлайн магазина']")
        private WebElement homeButton;

        public TradePackProfilePage(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);

        }

    public TradePackProductPage homeButtonClick () {
            homeButton.click();
            return new TradePackProductPage(driver);
    }


}



