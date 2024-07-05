import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ECommerceAutomation {
        public static void main(String[] args) {
                // Set the path to the chromedriver executable
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

                // Initialize the WebDriver
                WebDriver driver = new ChromeDriver();

                try {
                        // Open the e-commerce site
                        driver.get("https://www.flipkart.com/");

                        // Search for a product
                        WebElement searchBox = driver.findElement(By.className("Pke_EE"));
                        searchBox.sendKeys("dress");
                        searchBox.submit();

                        // Wait for search results to load
                        new WebDriverWait(driver, Duration.ofSeconds(10));

                        // Select a product
                        driver.findElement(By.className("hCKiGj")).click();

                        // Store the current window handle
                        String mainWindow = driver.getWindowHandle();

                        // Switch to new tab
                        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                        tabs.remove(mainWindow);
                        driver.switchTo().window(tabs.get(0));

                        // Wait for product page to load
                        new WebDriverWait(driver, Duration.ofSeconds(10));

                        // Add product to cart
                        driver.findElement(By.className("QqFHMw vslbG+ In9uk2")).click();

                        // Wait for cart modal to appear
                        new WebDriverWait(driver, Duration.ofSeconds(10))
                                        .until(ExpectedConditions.presenceOfElementLocated(By.className("layer_cart")));

                        // Proceed to checkout
                        driver.findElement(By.cssSelector(".button-medium[title='Proceed to checkout']")).click();

                } finally {
                        // Close the browser
                        driver.quit();
                }
        }
}
