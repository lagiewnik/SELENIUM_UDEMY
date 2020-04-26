package autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class A02_uploadFile {


    public static void main(String[] args) throws InterruptedException, IOException {

/*
 */
        WebDriver driver = null;
        String url = "https://altoconvertpdftojpg.com/";


        String downloadPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome,driver", "C:\\selenium_web_driver\\chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions chropt = new ChromeOptions();
        chropt.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(chropt);
        driver.get(url);

        driver.findElement(By.xpath("//button[@id='dropzoneInput-label']")).click();
        Thread.sleep(3000);

        Runtime.getRuntime().exec("resources/fileUpload.exe");




        WebDriverWait wait  = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'g-btn g-btn--primary g-btn--medium')]")));
        WebElement convertButton = driver.findElement(By.xpath("//button[contains(@class,'g-btn g-btn--primary g-btn--medium')]"));
        convertButton.click();

        String linkText;
        By downloadButton = By.linkText("Download Now");

        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton));

        driver.findElement(downloadButton).click();

        Thread.sleep(10000);
        File f = new File( downloadPath + "/Converted.jpg");
        if(f.exists()){
            System.out.println("file found! Downloaded successful");
            Assert.assertTrue(f.exists());
           if( f.delete()){
               System.out.println("File deleted");
           };
        }


    }

}