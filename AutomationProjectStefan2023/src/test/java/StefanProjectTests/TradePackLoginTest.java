package StefanProjectTests;

import Basic.BasicTestUtil;
import Pages.TradePackLoginPage;
import Pages.TradePackProfilePage;
import org.testng.annotations.Test;

public class TradePackLoginTest extends BasicTestUtil {
    @Test
    public void successfulLogin() {
        TradePackLoginPage tradePackLoginPage = new TradePackLoginPage(driver);
        TradePackProfilePage tradePackPrPage = tradePackLoginPage.login("drak0@abv.bg", "Lamzas22@");
    }

}
