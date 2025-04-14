import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class TestSelenium {
    public static void main(String[] args) {

        Page page = new Page("bismarck.berrios@itti.digital", "Admin123");

        WebDriver driver = new ChromeDriver();
        driver.get("https://frontend-humanitti-core-front-development-dxtxa.humanitti-sdlc.itti-platform.digital/sign-in");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        System.out.println("Título: " + driver.getTitle());
        driver.manage().timeouts();
        driver.manage().window().maximize();
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(page.getMail());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(page.getPassword());
        driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeLarge MuiButton-containedSizeLarge MuiButton-colorPrimary css-f4qyey']")).click();

        for (int i = 0; i < 3; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1wcf7ku']")));
            driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1wcf7ku']")).click();

            try {
                Thread.sleep(3000); // Espera 3 segundos entre cada clic
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //driver.quit();
    }
}
