import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UserSearch {
    private WebDriver driver;

    @BeforeTest
    public void SetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mytheresa.com/en-de/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void testUserSearch() {
        //Accept site cookies
        if (driver.findElement(By.cssSelector("#privacy-iframe")).isDisplayed()) {
            WebElement cookie_frame = driver.findElement(By.cssSelector("#privacy-iframe"));
            driver.switchTo().frame(cookie_frame);
            driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/button[1]")).click();
            driver.switchTo().defaultContent();
        }

        //Find search element
        WebElement element = driver.findElement(By.id("search"));
        // Clear the existing text value
        element.clear();
        // Enter something to search for
        element.sendKeys("Gucci bags");
        // Now submit the form
        element.submit();
        WebElement result = driver.findElement(By.cssSelector(".search-result-intro > p"));
        assertEquals("SEARCH RESULTS FOR 'GUCCI BAGS'", result.getText());
        System.out.println("The number of products found is: " + driver.findElement(By.cssSelector(".toolbar:nth-child(2) .amount")).getText());
    }

    @AfterTest
    public void tearDown() throws Exception {
        // Close the browser
        driver.quit();
    }
}
