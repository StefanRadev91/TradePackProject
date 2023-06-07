package StefanProjectTests;

import Basic.BasicTestUtil;
import Pages.TradePackLoginPage;
import Pages.TradePackProductPage;
import Pages.TradePackProfilePage;
import org.testng.annotations.Test;

public class TradePackProfilePageTest extends BasicTestUtil {
    @Test
    public void ProfilePage (){
        TradePackLoginPage tradePackLoginPage = new TradePackLoginPage(driver);
        TradePackProfilePage tradePackPrPage = tradePackLoginPage.login("drak0@abv.bg", "Lamzas22@");

        TradePackProductPage tradePackProPage = tradePackPrPage.homeButtonClick();
    }
}
