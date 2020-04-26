package testcases;

import objectrepository.RediffHomePage;
import objectrepository.RediffLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginApplication {
    @Test
    public void Login()
    {
        String url = "https://mail.rediff.com/cgi-bin/login.cgi";
        System.setProperty("webdriver.chrome.driver","c:\\selenium_web_driver\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        RediffLoginPage rd = new RediffLoginPage(driver);

        rd.emailId().sendKeys("whatsup@mail.ll");
        rd.passwdId().sendKeys("feufueuf");
        rd.submitId().click();
        rd.homeId().click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RediffHomePage rh = new RediffHomePage(driver);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(1, SECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement shoppingBox = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
                return rh.ShoppingId();
            }
        });
        shoppingBox.click();


    }
}
