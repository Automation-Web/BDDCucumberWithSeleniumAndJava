package Pages;

import DriverUtilities.ShareDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.util.TimeUtils;
import stepDefination.Configuration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;


public class BasePage {

    WebDriver driver;
    ShareDriver share=new ShareDriver();

    public BasePage(WebDriver driver){
        this.driver =driver;
    }


    public void navigate(){
        try {
            driver.get(Configuration.getURL());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void captureScreenShot(String name) throws IOException {

        Date d=new Date();
        SimpleDateFormat set= new SimpleDateFormat("(dd-MM-yyyy)_(HH:mm:ss)");
//        System.currentTimeMillis();
        String date= set.format(d);

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File("target\\SnapShots\\screenshots\\"+name+".png"));

    }

    public void handleAlert(){

        Alert alt=driver.switchTo().alert();

        alt.accept();
        //alt.dismiss();
        //alt.sendKeys("Ok");
        //alt.getText();
    }

    public void switchToWindow(){
        ArrayList<String> set=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(set.get(1));
    }

    public void jsClick(String path){

        WebElement element=driver.findElement(By.xpath(path));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);

    }
    public void clicked(String path){
        WebElement element=driver.findElement(By.xpath(path));
        element.click();
    }

    public boolean isVisible(String path){
        WebElement element= driver.findElement(By.xpath(path));
        element.isDisplayed();
        return true;
    }

    public void sendKeys(String path, String input){
        WebElement element=driver.findElement(By.xpath(path));
        element.sendKeys(input);

    }

    public void sendInput(WebElement element, String input){
        element.sendKeys(input);
    }

    public void click(WebElement element){
        element.click();
    }

    public void closeBrowser(){
        driver.close();
    }
}
