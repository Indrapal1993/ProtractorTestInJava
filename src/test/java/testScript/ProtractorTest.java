package testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProtractorTest {
	static WebDriver driver;
	static NgWebDriver ngDriver;

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.manage().window().maximize();
		driver.get("http://juliemr.github.io/protractor-demo/");
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
		driver.findElement(ByAngular.model("first")).sendKeys("2");
		driver.findElement(ByAngular.model("second")).sendKeys("2");
		// driver.findElement(By.id("gobutton")).click();
		driver.findElement(ByAngular.buttonText("Go!")).click();
  
		
	}
}
