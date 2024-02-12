import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.Selector;
import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.seconds;

public class opnebrows {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",
                new java.util.HashMap<String, Object>() {{
                    put("profile.default_content_setting_values.notifications", 1);
                }});
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.paruvendu.fr/");
        driver.manage().window().maximize();
        //driver.findElement(By.id("L2AGLb")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("cmp_pv.cookie.saveConsent(true)");
        driver.navigate().refresh();
        String xpathExpression = "//*[@id=\"user_tools\"]/div[1]/a";
        By xpathSelector = By.xpath(xpathExpression);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpathSelector));         System.out.println("ok");
        element.click();
       // Select cat = new Select(driver.findElement(By.id("choixFamille1Error")));
        //cat.selectByVisibleText("AUTO-MOTO-BATEAU");

    }}