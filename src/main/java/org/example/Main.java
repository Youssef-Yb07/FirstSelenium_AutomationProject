package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class Main {
    public static void main(String[] args) {
        // Initialize the driver
        WebDriver driver = new ChromeDriver();

        // Open the browser
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximize the window
        driver.manage().window().maximize();

        // Use WebDriverWait to ensure elements are present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Get web elements
        WebElement login = wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//input[@placeholder='Username']")));
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//input[@placeholder='Password']")));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));

        // Perform actions
        login.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();

        // Wait for the dashboard to load and retrieve the title
        WebElement dashboardTitle = wait.until(ExpectedConditions.presenceOfElementLocated(xpath("//h6[normalize-space()='Dashboard']")));
        System.out.println("Title of dashboard page: " + dashboardTitle.getText());


        // Logout
        WebElement dropdown = driver.findElement(By.cssSelector(".oxd-userdropdown"));

        dropdown.click();

        WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));

        logout.click();

        driver.quit();

    }


    //Les 3 types de wait en Selenium :
    //1. Implicit Wait (Attente implicite)
    //Une attente globale appliquée à tous les éléments du script Selenium.
    //Si un élément n'est pas immédiatement localisé, Selenium attend la durée spécifiée avant de relever une exception.
    //Si l'élément est trouvé avant la fin de la durée, le script continue sans attendre.
    //Clé : S’applique à tout le code.
    //2. Explicit Wait (Attente explicite)
    //Une attente ciblée qui s’applique à un élément spécifique.
    //Selenium attend une durée spécifique pour qu'une condition précise soit remplie (par exemple, que l'élément soit cliquable).
    //Si la condition est remplie avant la fin de la durée, le script continue. Sinon, une exception est relevée.
    //Clé : Utilisé pour des conditions spécifiques à des éléments particuliers.
    //3. Fluent Wait (Attente fluide)
    //Une attente personnalisable, plus avancée que l'attente explicite.
    //Tu peux définir :
    //Une durée maximale d'attente.
    //Un intervalle de vérification (fréquence à laquelle Selenium vérifie si l'élément est localisé ou si la condition est remplie).
    //Les exceptions à ignorer (par exemple, ignorer temporairement les erreurs NoSuchElementException).
    //Selenium continue de vérifier régulièrement jusqu'à ce que la condition soit remplie ou que la durée maximale soit atteinte.
    //Clé : Flexible, idéale pour des cas où les éléments prennent un temps variable pour apparaître ou devenir interactifs.
}
