package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
    WebDriver driver;

    public RediffLoginPage(WebDriver driver) {
        this.driver = driver;
    }


    By username = By.xpath(".//*[@id='login1']");
    By password = By.name("passwd");
    By go = By.name("proceed");
    By homeLink = By.linkText("Home");

    public WebElement emailId(){
        return driver.findElement(username);
    }

    public WebElement passwdId(){
        return driver.findElement(password);
    }

    public WebElement submitId(){
        return driver.findElement(go);
    }

    public WebElement homeId(){
        return driver.findElement(homeLink);
    }


}
