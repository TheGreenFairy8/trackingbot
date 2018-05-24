import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Main
{
    static final String chatId = "-288608492";

    public static void main( String[] args )
    {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(dc);

        AuthPage authPage = new AuthPage(driver);
        authPage.logIn();

        MainPage mainPage = new MainPage(driver);
        File screenShot = mainPage.getScreenShot();

        driver.quit();

        TrackingReminderBot bot = new TrackingReminderBot();
        bot.sendImage(chatId, screenShot);
    }
}
