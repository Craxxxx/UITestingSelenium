package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import testNG annotations
import org.testng.annotations.*;

//import driverManager
import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.Util.DriverManager;




public class Setup {

    protected static WebDriver driver;
    protected static WebDriver driver2;
    
    @BeforeSuite
    public void setupDriver()
    {
        System.out.println("Setting up driver");
        //this methods automatically downloads and configures the correct driver binary at runtime
        // Optionally pre-create named drivers, or let tests lazily fetch them.
        // DriverManager.getDriver("siteA");
        // DriverManager.getDriver("siteB");
    }



    @AfterSuite
    public void teardownTest()
    {
        System.out.println("Tearing down env");
        DriverManager.quitAll();
    }
}
