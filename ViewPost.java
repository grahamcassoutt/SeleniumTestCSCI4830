import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class ViewPost {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/camdenawright/4830/workspace4830/workspace4830-Wright/Testing/project_webapp_testing1/lib/mac/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testViewPost() throws Exception {
	driver.manage().window().maximize();
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000");
    driver.findElement(By.id("navbarDropdown")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("All Subjects")).click();
	Thread.sleep(1000);
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000/subjects/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Subjects'])[2]/following::a[1]")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("Algebra")).click();
	Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Algebra Forum'])[2]/following::a[1]")).click();
	Thread.sleep(10000);
    driver.findElement(By.id("home")).click();
	Thread.sleep(1000);
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000/");
	Thread.sleep(1000);
    driver.findElement(By.id("navbarDropdown")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("All Subjects")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Subjects'])[2]/following::a[1]")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("Algebra")).click();
    js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='AlgebraWordProblems-Worksheet1-NumberProblems_GsXPaWQ_FBZJLVh.pdf'])[1]/following::a[1]")).click();
	Thread.sleep(10000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
