import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWithChromeTest {
  public static void main(String[] args) {
    // Set path to the ChromeDriver executable (no full path needed if in project
    // folder)
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

    // Initialize ChromeDriver
    WebDriver driver = new ChromeDriver();

    // Navigate to a website
    driver.get("https://www.amazon.com");

    // Print the page title
    System.out.println("Page title is: " + driver.getTitle());

    // Close the browser
    driver.quit();
  }
}
