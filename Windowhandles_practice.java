package Day26.Windows_Frames;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Windowhandles_practice {
	WebDriver driver;
public void testCase001() throws Exception {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("duffle bags for travel");
	driver.findElement(By.id("nav-search-submit-button")).click();
	
	driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> list = new LinkedList<String>(windowHandles); 
	driver.switchTo().window(list.get(1));
	driver.findElement(By.id("submit.add-to-cart")).click();
	
}
public static void main(String[] args) throws Exception {
	Windowhandles_practice wc = new Windowhandles_practice();
	wc.testCase001();
	
}
}
