package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwagLabsPage extends BasePage {
    @FindBy(className = "app_logo")
    private WebElement appLogo;

    protected SwagLabsPage(WebDriver driver) {
        super(driver);
    }

    public String getLogoText(){
        return appLogo.getText();
    }

    static SwagLabsPage waitUntilLoaded(WebDriver driver) {
       return new SwagLabsPage(driver)
               .waitUntilLoaded();
    }

    private SwagLabsPage waitUntilLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOf(appLogo));
        return this;
    }
}
