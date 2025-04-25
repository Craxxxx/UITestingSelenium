package selenium;

import org.testng.Assert;
//import testNG annotations
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

//import testNG Assertions
import static org.testng.Assert.*;

import selenium.Util.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class SeleniumMethod extends Setup{


    @Test
    public void testTwowebsites()
    {
        //declaring a variable with WebDriver data type to obtain the driver object
        WebDriver siteA = DriverManager.getDriver("siteA");
        WebDriver siteB = DriverManager.getDriver("siteB");

        //use the driver object to open the website
        siteA.get("https://www.google.com/");
        siteB.get("https://www.saucedemo.com/");

        Assert.assertTrue(siteA.getTitle().contains("Google"));
        Assert.assertTrue(siteB.getTitle().contains("Swag Labs"));
    }
    
    @Test
    public void LocatorTestMethods()
    {
        driver2.get("https://www.saucedemo.com/");
        
        System.out.println("Testing locator methods");
        
        //FINDING ELEMENTS//
        //finding element by css selector
        driver2.findElement(By.cssSelector("input#user-name"));

        //if wrong it will say no such element
        //driver2.findElement(By.cssSelector("input#user-names"));

        ///finding element by xpath
        driver2.findElement(By.xpath("//*[@id=\"password\"]"));

        //finding element by id
        driver2.findElement(By.id("login-button"));
        //FINDING ELEMENTS//


        //GETTING TITLE AND CURRENT URL//
        String title = driver2.getTitle();
        String currentUrl = driver2.getCurrentUrl();

        System.out.println("the title of the page is: " + title);
        System.out.println("The url of the current page is : " + currentUrl );
        //GETTING TITLE AND CURRENT URL//
    }

    @Test
    public void simulateUserInteractionMethods()
    {
        System.out.println("Simulating user interaction");
         
        //SIMULATING USER INTERACTION//
        driver2.get("https://www.saucedemo.com/");
        
        //simulate logging in
        driver2.findElement(By.id("user-name")).sendKeys("standard_user");
        driver2.findElement(By.id("password")).sendKeys("secret_sauce");;
        driver2.findElement(By.id("login-button")).click();;

        //SIMULATING USER INTERACTION//

    }

    @Test
    public void NavigationMethodTest() throws InterruptedException
    {
        System.out.println("Testing navigation methods");

        WebDriver drive = WebDriverManager.chromedriver().create();

        //Navigation methods//
        drive.navigate().to("https://www.saucedemo.com/");
        drive.navigate().refresh();
        drive.navigate().to("https://jayjay.co/");
        drive.navigate().back();

        Thread.sleep(2000);
        drive.navigate().forward();
        Thread.sleep(2000);

        String title = drive.getTitle();
        String currentUrl = drive.getCurrentUrl();
        System.out.println("the title of the page is: " + title);
        System.out.println("The url of the current page is : " + currentUrl );
    }

   
    
}
