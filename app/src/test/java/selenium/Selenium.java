package selenium;

//import the testNG
import org.testng.annotations.*;
//import testNG assertions
import static org.testng.Assert.*;

//brings Selenium’s By class into your Java code, which is the factory for all built-in locator strategies used to find elements on a web page
import org.openqa.selenium.By;

//import selenium webDriver
import org.openqa.selenium.WebDriver;


public class Selenium extends Setup {


    @Test
    public void testGoogleTitle()
    {
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        assertTrue(title.contains("Google"),"Page title should contain 'Google'");
    }
    
}
