package selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import selenium.Util.DriverManager;

public class SeleniumWait extends Setup {

    @Test(description = "Implicit wait test")
    public void WaitMethodImplicit()
    {
        //always set implicit wait at startup before 

        WebDriver siteA = DriverManager.getDriver("SiteA");
         //IMPLICIT WAIT only needs to be set once and it will be applied to all elements in the driver instance
        siteA.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        //what wait does is it will wait for the element to be present in the DOM and then it will find the element and return it
        //and if the element is present before the timout expires it will skip the wait and return the element immediately


        siteA.get("https://saucedemo.com/");
        siteA.findElement(By.id("user-name")).sendKeys("standard_user");
        siteA.findElement(By.id("password")).sendKeys("secret_sauce");
        siteA.findElement(By.id("login-button")).click();

        assertEquals(siteA.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(), "Sauce Labs Backpack");

    }


    @Test
    public void WaitMethodExplicit()
    {
        //Use explicit waits when you need to wait for a specific condition—such as visibility, 
        //  clickability, or presence—on an element before proceeding

        //in explicit wait place the waits immediately before the action requiring the wait or synchronization
        //always user appropriate Expected Conditions for clarity and reliability

        //get the webdriver object from the driver manager
        WebDriver siteA = DriverManager.getDriver("SiteA");

        //call the websites
        siteA.get("https://saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(siteA, Duration.ofMillis(5000));
        
        //explicitly wait for the element to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        siteA.findElement(By.id("user-name")).sendKeys("standard_user");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        siteA.findElement(By.id("password")).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        siteA.findElement(By.id("login-button")).click();
        //explicitly wait for the element to be present

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]")));
        assertEquals(siteA.findElement(By.xpath("//*[@id=\"item_4_title_link\"]")).getText(), "Sauce Labs Backpack");

    }




    public void WaitMethodFluent()
    {

        //call the driver manager
        WebDriver siteA = DriverManager.getDriver("SiteA");

        //call the websites
        siteA.get("https://saucedemo.com/");




        
    }
}
