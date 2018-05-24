import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainPage extends Page
{
    By popup = By.id("step-0");
    By closePopupButton = By.cssSelector("button[title='Больше не показывать']");
    By closeDefaultButton = By.xpath("//*[@id='page-content']/section/div/div[3]/button");
    By selectDate1 = By.id("select_dt1");
    By selectDate2 = By.id("select_dt2");
    By datePicker = By.id("ui-datepicker-div");

    public MainPage(WebDriver driver)
    {
        super(driver);
        if(driver.findElement(popup).isDisplayed()) {
            closePopup();
        }
        updateTable();
        closeDefaultSettings();
    }

    void closePopup()
    {
        WebElement element = driver.findElement(closePopupButton);
        element.click();
    }

    void closeDefaultSettings()
    {
        driver.findElement(closeDefaultButton).click();
    }

    void updateTable()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currentDayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) + 7 - calendar.getFirstDayOfWeek()) % 7;
        calendar.add(Calendar.DAY_OF_YEAR, -currentDayOfWeek);
        Date firstDayOfWeek = calendar.getTime();
        calendar.set(Calendar.DAY_OF_WEEK, -1);
        Date lastDayOfWeek = calendar.getTime();

        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.YYYY");
        setDate(selectDate1, formattedDate.format(firstDayOfWeek));
        wairForElementToHide(datePicker);
        setDate(selectDate2, formattedDate.format(lastDayOfWeek));

        wairForElementToHide(datePicker);
    }

    void setDate(By selectDate, String date)
    {
        WebElement element = driver.findElement(selectDate);
        element.clear();
        element.sendKeys(date);
        element.sendKeys(Keys.ENTER);
    }

    public File getScreenShot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
}
