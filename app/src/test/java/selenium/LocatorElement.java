package selenium;

//import testNG annotations
import org.testng.annotations.*;
//import testNG Assertions
import static org.testng.Assert.*;


import org.openqa.selenium.By;



public class LocatorElement extends Setup{
    
    @Test
    public void LocatorTest()
    {
        driver2.get("https://www.saucedemo.com/");

        //finding element by css selector
        driver2.findElement(By.cssSelector("input#user-name"));

        //if wrong it will say no such element
        //driver2.findElement(By.cssSelector("input#user-names"));

        ///finding element by xpath
        driver2.findElement(By.xpath("//*[@id=\"password\"]"));

        //finding element by id
        driver2.findElement(By.id("login-button"));
    }
    
}
