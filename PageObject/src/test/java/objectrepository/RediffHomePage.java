package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {
    WebDriver driver;

    public RediffHomePage(WebDriver driver) {
        this.driver = driver;
    }


    By searchBox = By.id("srchquery_tbox");
    By searchSubmit = By.xpath(".//*[@type='submit']");
    String linkText;
    By shopingKey = By.linkText("Shopping");

    public WebElement searchBoxId(){
        return driver.findElement(searchBox);
    }

    public WebElement searchSubmitId(){
        return driver.findElement(searchSubmit);
    }

    public WebElement ShoppingId(){
        return driver.findElement(shopingKey);
    }




}
