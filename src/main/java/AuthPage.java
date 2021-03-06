import org.openqa.selenium.*;

public class AuthPage extends  Page
{
    By loginElement = By.name("login");
    By passwordElement = By.name("pass");
    By submitButton = By.className("btn-primary");

    public AuthPage(WebDriver webDriver)
    {
        super(webDriver);

        String url = "https://gbu.myalm.ru/pm/SAT/participants/spenttime/activitiesreport?report=activitiesreport&basemodule=project-spenttime&area=favs";
        driver.get(url);
    }

    public void logIn()
    {
        driver.findElement(loginElement).sendKeys("Muhametdinov");
        driver.findElement(passwordElement).sendKeys("mIaczVi1lB");
        driver.findElement(submitButton).submit();
    }
}
