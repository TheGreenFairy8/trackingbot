import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page
{
    WebDriver driver;

    public Page(WebDriver webDriver)
    {
        driver = webDriver;
    }

    void wairForElementToShow(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 10 seconds.
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    void wairForElementToHide(By by)
    {
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 10 seconds.
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
