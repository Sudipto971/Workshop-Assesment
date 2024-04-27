import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headed");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.get("https://demoqa.com/");
    }
    @DisplayName("Visit website")
    @Test
    public void visitWebsite(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        String title= driver.getTitle();
        String currentUrl= driver.getCurrentUrl();

        System.out.println(title);
        System.out.println(currentUrl);

        Assertions.assertTrue(title.contains("ORANGEHRM"));
    }
    @Test
    public void fillupForm(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");




        List<WebElement> txtBox= driver.findElements(By.className("form-control"));
        txtBox.get(1).sendKeys("ADMIN");
        txtBox.get(2).sendKeys("admin123");


        driver.findElement(By.id("submit")).click();

    }