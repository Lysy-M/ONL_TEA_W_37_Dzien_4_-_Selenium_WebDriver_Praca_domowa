package HomeWorkDay4;    //Zadanie 3

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FormAutomation3 {
    public static void main(String[] args) {
        // Ścieżka do sterownika przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Inicjalizacja przeglądarki Chrome
        WebDriver driver = new ChromeDriver();

        // Oczekiwanie na elementy przez 10 sekund
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Otwarcie strony z formularzem
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        driver.manage().window().maximize();

        // Wypełnienie danych w formularzu
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("LudwikXVI");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Wystrzelony w kosmos");

        WebElement gender = driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[3]/div/div/label[1]/input"));
        gender.click();

        WebElement dateOfBirth = driver.findElement(By.id("dob"));
        dateOfBirth.sendKeys("05/22/2010");

        WebElement address = driver.findElement(By.id("address"));
        address.sendKeys("Prosta 51");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("karol.kowalski@mailinator.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Pass123");

        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("Coders Lab");

        WebElement comment = driver.findElement(By.id("comment"));
        comment.sendKeys("To jest mój pierwszy automat testowy");

        // Zatwierdzenie formularza
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        // Zamknięcie przeglądarki
        driver.quit();
    }
}