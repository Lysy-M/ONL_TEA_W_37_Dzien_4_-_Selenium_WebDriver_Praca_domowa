package HomeWorkDay4;     //Zadanie4


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ElementSearchxPath4 {
    public static void main(String[] args) {
        // Ścieżka do sterownika przeglądarki Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        // Inicjalizacja przeglądarki Chrome
        WebDriver driver = new ChromeDriver();
        // Oczekiwanie na elementy przez 10 sekund
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        // Otwarcie strony sklepu internetowego
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.manage().window().maximize();

        // Wyszukiwanie elementów na stronie
        WebElement socialTitle = driver.findElement(By.id("field-id_gender-1"));
        WebElement firstName = driver.findElement(By.id("field-firstname"));
        WebElement lastName = driver.findElement(By.id("field-lastname"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"field-password\"]"));
        WebElement showPassword = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/div/div[5]/div[1]/div/span/button"));
        WebElement dateOfBirth = driver.findElement(By.id("field-birthday"));

        // Wyświetlenie tekstów z elementów
        System.out.println("Tytuł społeczny: " + socialTitle.getAttribute("innerText"));
        System.out.println("Imię: " + firstName.getAttribute("value"));
        System.out.println("Nazwisko: " + lastName.getAttribute("value"));
        System.out.println("E-mail: " + email.getAttribute("value"));
        System.out.println("Hasło: " + password.getAttribute("value"));
        System.out.println("Pokazać hasło: " + showPassword.getAttribute("type"));
        System.out.println("Data urodzenia: " + dateOfBirth.getAttribute("value"));

        // Zamknięcie przeglądarki
        //driver.quit();
    }
}