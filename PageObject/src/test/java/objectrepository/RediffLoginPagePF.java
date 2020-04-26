package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {
    WebDriver driver;

    public RediffLoginPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    /*By username = By.xpath(".//*[@id='login1']");
    By password = By.name("passwd");
    By go = By.name("proceed");
    By homeLink = By.linkText("Home");*/

    @FindBy(xpath = ".//*[@id='login1']")
    WebElement username;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(name = "proceed")
    WebElement go;

    @FindBy(linkText = "Home")
    WebElement homeLink;

    public WebElement emailId(){
        return username;
    }

    public WebElement passwdId(){
        return password;
    }

    public WebElement submitId(){
        return go;
    }

    public WebElement homeId(){
        return  homeLink;
    }


}
