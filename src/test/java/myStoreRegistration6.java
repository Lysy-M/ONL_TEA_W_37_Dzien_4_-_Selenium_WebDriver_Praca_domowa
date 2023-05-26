package HomeWorkDay4;   //Zadanie6

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class myStoreRegistration6 {
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

        // Definicja liczby użytkowników do utworzenia, 3x wypełni się formularz
        int liczbaUzytkownikow = 3;

        for (int i = 1; i <= liczbaUzytkownikow; i++) {
            // Generowanie losowych danych
            String imie = generateRandomString(8);
            String nazwisko = generateRandomString(10);
            String email = "test" + generateRandomString(10) + "@chrome.com";
            String haslo = generateRandomString(10);
            //String ulica = generateRandomString(12);
            //String kodPocztowy = "generateRandomNumber(10000, 99999)";
            //String miasto = generateRandomString(8);

            // Przejście do formularza rejestracji
            // Wybór Sign in
            WebElement clickSignIn = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
            clickSignIn.click();
//            WebElement SignIn = driver.findElement(By.linkText("Sign in"));
//            SignIn.click();
            // Wybierz opcję "Nie masz konta? Utwórz go tutaj"
            WebElement noAccount = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
            noAccount.click();

            //driver.findElement(By.id("")).sendKeys(....);
            //driver.findElement(By.id("")).click();

            // Wypełnianie formularza rejestracji
            WebElement idgender = driver.findElement(By.id("field-id_gender-1"));
            idgender.click();
            WebElement firstname = driver.findElement(By.id("field-firstname"));
            firstname.sendKeys(imie);
            WebElement lastname = driver.findElement(By.id("field-lastname"));
            lastname.sendKeys(nazwisko);

            // Wyszukiwanie elemnentów w formularzu
            WebElement emailadd = driver.findElement(By.id("field-email"));
            emailadd.sendKeys(email);
            WebElement password = driver.findElement(By.id("field-password"));
            password.sendKeys(haslo);
            WebElement customerprivacy = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/section/form/div/div[8]/div[1]/span/label/input"));
            customerprivacy.click();
            WebElement customerfrom = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div/section/form/div/div[10]/div[1]/span/label/input"));
            //customerfrom.click(); Klikniecie spowoduje zatrzymanie kodu

            //driver.findElement(By.id("address1")).sendKeys(ulica);
            //driver.findElement(By.id("postcode")).sendKeys(kodPocztowy);
            //driver.findElement(By.id("city")).sendKeys(miasto);
            //driver.findElement(By.id("phone_mobile")).sendKeys("generateRandomNumber(100000000, 999999999)");
            WebElement save = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/footer/button"));
            save.click();

            // Wyświetlenie informacji o utworzonym użytkowniku
            System.out.println("Użytkownik " + i + ":");
            System.out.println("Imię: " + imie);
            System.out.println("Nazwisko: " + nazwisko);
            System.out.println("E-mail: " + email);
            System.out.println("Hasło: " + haslo);
            //System.out.println("Adres: " + ulica + ", " + kodPocztowy + " " + miasto);
            System.out.println("-------------------------------------");
        }

        // Zamknięcie przeglądarki
        //driver.quit();
    }

    private static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < length) {
            int index = (int) (rnd.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }

        return builder.toString();
    }
    private static String generateRandomNumber(int min, int max) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(max - min + 1) + min;
        return Integer.toString(randomNumber);
    }
}
