package HomeWorkDay4;   //Zadanie 1

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class myStoreRegistration1 {
    public static void main(String[] args) {
        // Ustaw ścieżkę do pliku chromedriver.exe dla Twojej konfiguracji
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Inicjalizacja przeglądarki Chrome
        WebDriver driver = new ChromeDriver();

        // Wejdź na stronę główną
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.manage().window().maximize();

        // Przejdź do opcji 'Sign in'
        //driver.findElement(By.linkText("Sign in")).click();
        WebElement signin = driver.findElement(By.linkText("Sign in"));
        signin.click();

        // Wybierz opcję "Nie masz konta? Utwórz go tutaj"
        WebElement noaccount = driver.findElement(By.id("submit-login"));
        noaccount.click();

        // Za pomocą metod nawigacyjnych przejdź do strony głównej
        driver.navigate().to("https://mystore-testlab.coderslab.pl/index.php");

        // Zamknij przeglądarkę
        driver.quit();
    }
}