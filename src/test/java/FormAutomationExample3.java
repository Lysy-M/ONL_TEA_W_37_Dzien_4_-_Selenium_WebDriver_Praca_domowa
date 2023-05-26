package HomeWorkDay4;      // Zadanie 3

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class FormAutomationExample3 {
    public static void main(String[] args) throws InterruptedException {
        // Ścieżka do pliku wykonywalnego ChromeDriver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");


        // Inicjalizacja przeglądarki Chrome
        WebDriver driver = new ChromeDriver();

        // Oczekiwanie na elementy przez 10 sekund
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Otwarcie strony z formularzem
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.manage().window().maximize();

        // Wprowadzenie danych do formularza
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        firstNameInput.sendKeys("LudwikXVI");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Wystrzelony w kosmos");

        WebElement genderMale = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
        genderMale.click();

        WebElement dobInput = driver.findElement(By.id("dob"));
        dobInput.sendKeys("05/22/2010");

        WebElement addressInput = driver.findElement(By.id("address"));
        addressInput.sendKeys("Prosta 51");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("karol.kowalski@mailinator.com");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Pass123");

        WebElement companyInput = driver.findElement(By.id("company"));
        companyInput.sendKeys("Coders Lab");

        WebElement commentInput = driver.findElement(By.id("comment"));
        commentInput.sendKeys("To jest mój pierwszy automat testowy");

        // Zatwierdzenie formularza
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Zamknięcie przeglądarki
        driver.quit();
    }
}