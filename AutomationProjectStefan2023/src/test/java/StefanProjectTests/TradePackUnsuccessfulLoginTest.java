package StefanProjectTests;
import Basic.BasicTestUtil;
import Pages.TradePackLoginPage;
import Pages.TradePackProfilePage;
import au.com.bytecode.opencsv.CSVReader;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;

public class TradePackUnsuccessfulLoginTest extends BasicTestUtil {

    @Test
    public void unSuccessfulLogin() {
        String csvFilePath = "src/test/resources/wrongUsers.csv";
        String[] credentials;
        int numberOfLinesToRead = 3;

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            int lineCount = 0;
            while ((credentials = reader.readNext()) != null && lineCount < numberOfLinesToRead) {
                String email = credentials[0];
                String password = credentials[1];

                TradePackLoginPage tradePackLoginPage = new TradePackLoginPage(driver);
                TradePackProfilePage tradePackPrPage = tradePackLoginPage.login(email, password);

                lineCount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

