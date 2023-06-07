package StefanProjectTests;

import Basic.BasicTestUtil;
import Pages.*;
import org.testng.annotations.Test;

public class TradePackCompleteCheckoutTest extends BasicTestUtil {
    @Test
    public void CompleteCheckoutTest (){
        TradePackLoginPage tradePackLoginPage = new TradePackLoginPage(driver);
        TradePackProfilePage tradePackPrPage = tradePackLoginPage.login("drak0@abv.bg", "Lamzas22@");
        TradePackProductPage tradePackProPage = tradePackPrPage.homeButtonClick();
        TradePackCheckOutPage tradePackCoPage = tradePackProPage.addItemToTheCart();
        TradePackCompleteCheckoutPage tradePackCoCoPage  = tradePackCoPage.clientData("Stefan","Radev","0897269135","Sofia","Ulitsa Penko Penkov 119, bl 13-14");
        TradePackFinalPage tradePackFiPage = tradePackCoCoPage.submitOrderOrBackToHome();
    }
}
