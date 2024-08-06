package com.vtiger.utilities;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

//page class mai jake pageAction class ko inherit krdo toh all funtionality inherit krne
public class PageActions {

    public WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest logger;


    public PageActions(WebDriver driver ,ExtentTest logger)
    {
        this.driver = driver;
        this.logger =logger;
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    public void setInput(WebElement elm,String value,String msg )
    {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);
            logger.pass(msg);

        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("Unable to enter text into Textbox due to error "+e.getMessage()+"  "+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");
        }
    }
    //Another method of declaring the Webelements-->overload kiya inputs bcoz fw one time banta hai--
    // so u can add method of overload- no need to change other code --write new one with new method
    public void setInput(String Str,String value, String msg)
    {
        try
        {
          WebElement elm = driver.findElement(By.xpath(Str));
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.clear();
            elm.sendKeys(value);
            logger.pass(msg);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            logger.fail("unable to enter text into textbox deu to error " + e.getMessage()+"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");
        }
    }
    public void clickElement(WebElement elm,String msg) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elm));
            elm.click();
            logger.pass(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.fail("unable to click on element due to error" + e.getMessage()+ "   " +"<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");
        }
    }

    public void isElementExist(WebElement elm,String msg) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));
            elm.isDisplayed();
            logger.pass(msg);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.fail("unable to find element due to error" + e.getMessage());
        }
    }
    public void selectVisibletext(WebElement elm,String value,String msg) {
        try {
            wait.until(ExpectedConditions.visibilityOf(elm));Select sel=new Select(elm);
            sel.selectByVisibleText(value);
            logger.pass(msg);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.fail("unable to select values from dropdown to error " + e.getMessage() + " "+ "<a href ='"+getScreenshot()+"'><span class='label start-time'>Screenshot</span></a>");
        }
    }
    public String getScreenshot()
    {
        Date d = new Date();
        DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
        String fileName = ft.format(d);
        String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
        TakesScreenshot ts = ((TakesScreenshot)driver);
        File SrcFile=ts.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File(path);
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

}

