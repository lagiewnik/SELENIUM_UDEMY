package autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A01_windowsPopUp {


    public static void main(String[] args) throws InterruptedException {

/*
Obejście poprzez dodanie username:password do adresu url
 */
        WebDriver driver = null;
        String url = "https://admin:admin@the-internet.herokuapp.com/";
        System.setProperty("webdriver.chrome,driver", "C:\\selenium_web_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);

        driver.findElement(By.linkText("Basic Auth")).click();




    }

}