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

public class RecommendedCourse {
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
  public void testRecommendedCourse() throws Exception {
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000/");
	Thread.sleep(500);
    driver.findElement(By.linkText("Account")).click();
	Thread.sleep(500);
    driver.findElement(By.linkText("Login")).click();
	Thread.sleep(500);
    driver.findElement(By.id("username")).click();
	Thread.sleep(500);
    driver.findElement(By.id("username")).clear();
	Thread.sleep(500);
    driver.findElement(By.id("username")).sendKeys("camdenawright");
	Thread.sleep(500);
    driver.findElement(By.id("password")).clear();
	Thread.sleep(500);
    driver.findElement(By.id("password")).sendKeys("43830389");
	Thread.sleep(500);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(500);
    driver.findElement(By.linkText("Course Suggustion")).click();
	Thread.sleep(500);
    driver.findElement(By.id("id_suggestedCourse")).click();
	Thread.sleep(500);
    driver.findElement(By.id("id_suggestedCourse")).clear();
	Thread.sleep(1000);
    driver.findElement(By.id("id_suggestedCourse")).sendKeys("Game Design Course");
	Thread.sleep(2000);
    driver.findElement(By.id("id_suggestedCourseDescription")).click();
    driver.findElement(By.id("id_suggestedCourseDescription")).clear();
    driver.findElement(By.id("id_suggestedCourseDescription")).sendKeys("I want a course to talk about game development and game design and just a place to get cool ideas and advice on my game.");
	Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Submit']")).click();
	Thread.sleep(2000);
    driver.findElement(By.id("home")).click();
	Thread.sleep(500);
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000/admin");
	Thread.sleep(500);
    driver.findElement(By.linkText("Sugguest courses")).click();
	Thread.sleep(500);
    driver.findElement(By.linkText("Game Design Course")).click();	
    Thread.sleep(5000);
    driver.findElement(By.name("_save")).click();
	Thread.sleep(500);
    driver.findElement(By.linkText("Django administration")).click();
    driver.get("http://ec2-3-95-26-219.compute-1.amazonaws.com:8000");
	Thread.sleep(1000);
    driver.findElement(By.linkText("Account")).click();
	Thread.sleep(1000);
    driver.findElement(By.linkText("Log Out")).click();
    Thread.sleep(2000);

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
