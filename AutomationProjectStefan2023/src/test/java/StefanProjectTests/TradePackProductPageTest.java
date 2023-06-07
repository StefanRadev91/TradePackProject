package StefanProjectTests;

import Basic.BasicTestUtil;
import Pages.TradePackCheckOutPage;
import Pages.TradePackLoginPage;
import Pages.TradePackProductPage;
import Pages.TradePackProfilePage;
import org.testng.annotations.Test;

public class TradePackProductPageTest extends BasicTestUtil {
    @Test
    public void SuccessfulAddItemsToCart (){
        TradePackLoginPage tradePackLoginPage = new TradePackLoginPage(driver);
        TradePackProfilePage tradePackPrPage = tradePackLoginPage.login("drak0@abv.bg", "Lamzas22@");

        TradePackProductPage tradePackProPage = tradePackPrPage.homeButtonClick();
        TradePackCheckOutPage tradePackCoPage = tradePackProPage.addItemToTheCart();

    }

}
