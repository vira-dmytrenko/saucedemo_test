import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @AfterMethod
    protected void afterMethod(){
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
