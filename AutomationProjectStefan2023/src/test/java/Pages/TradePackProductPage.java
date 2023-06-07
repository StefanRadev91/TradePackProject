package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;



public class TradePackProductPage extends TradePackBasic {
    @FindBy (xpath = "//a[contains(@href, 'chanta-hartiena-28-2h8-5-29-25br-.html') and @class='gs-view-more accent-color' and text()='купи']")
    private WebElement wantedItem;
    @FindBy (xpath = "//a[@id='addToCartBtn' and contains(@class, 'gs-view-more') and contains(@class, 'accent-color') and contains(@class, 'gs-sbm-cart')]")
    private WebElement addToCardBtn;
    @FindBy (id = "gs-cookies-accept")
    private WebElement cookieBtn;
    @FindBy (xpath = "//a[contains(@href, 'chanta-hartiena-20-2h4-24-25br-biala.html') and @class='gs-view-more accent-color' and text()='купи']")
    private WebElement wantedItem2;
    @FindBy(xpath = "//a[@id='addToCartBtn' and contains(@class, 'gs-view-more accent-color gs-sbm-cart') and .//span[@class='icon icon-ico_cart'] and .//strong/em[@class='icon icon-tick']]")
    private WebElement addToCardBtn2;
    @FindBy(className = "gs-cart-sum")
    private WebElement shoppingCartBadge;
    @FindBy(id = "gs-cart-header")
    private WebElement shoppingCartOpener;
    @FindBy(xpath = "//a[@href='/client-information.html' and @class='gs-view-more accent-color']")
    private WebElement checkOutPage;
    @FindBy(xpath = "//div[@class='gs-footer-col']/h6[text()='Телефон']/following-sibling::span[contains(text(), '0876 500 556')]")
    private WebElement phoneNumberElement;

    public TradePackProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TradePackCheckOutPage addItemToTheCart() {
        cookieBtn.click();
        scrollIntoView(driver, wantedItem);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(wantedItem));
        FluentWait fluentWait = new FluentWait(driver);
        fluentWait.until(ExpectedConditions.elementToBeClickable(wantedItem));
        Assert.assertTrue(wantedItem.isDisplayed());
        wantedItem.click();
        addToCardBtn.click();
        scrollIntoView(driver, wantedItem2);
        wait.until(ExpectedConditions.visibilityOf(wantedItem2));
        Assert.assertTrue(wantedItem2.isDisplayed());
        wantedItem2.click();
        addToCardBtn2.click();
        shoppingCartOpener.click();
        checkOutPage.click();

        return new TradePackCheckOutPage(driver);
    }
    public void checkPhoneNumber() {
        String phoneNumber = phoneNumberElement.getText().trim();
        if (phoneNumber.equals("0876 555 556")) {
            System.out.println("Yes, that's the phone!");
        } else {
            System.out.println("No, that's not the correct phone. You just found a new BUG!!!");
        }
    }

    public static void scrollIntoView(WebDriver driver, WebElement wantedItem) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", wantedItem);
    }

}

