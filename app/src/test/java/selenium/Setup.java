package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import testNG annotations
import org.testng.annotations.*;

//import driverManager
import io.github.bonigarcia.wdm.WebDriverManager;




public class Setup {

    protected static WebDriver driver;
    
    @BeforeSuite
    public void setupDriver()
    {
        System.out.println("Setting up driver");
        //this methods automatically downloads and configures the correct driver binary at runtime
        WebDriverManager.chromedriver().setup();

        System.out.println("Setting up env");
        driver = new ChromeDriver();
    }



    @AfterSuite
    public void teardownTest()
    {
        System.out.println("Tearing down env");
        //check if the driver is not null and close the browser
        if(driver != null)
        {
            driver.quit();
        }
        
    }
}
