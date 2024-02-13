package Day26.Windows_Frames;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class IframePractice {
	
public void framechecking() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.navigate().to("https://the-internet.herokuapp.com/iframe");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	WebElement frame1 = driver.findElement(By.xpath("//iframe[@title='Rich Text Area']"));
	driver.switchTo().frame(frame1);
	WebElement body = driver.findElement(By.xpath("//body[@id='tinymce']"));  
	body.clear();
	body.sendKeys("Hello People");

}
public static void main(String[] args) {
	IframePractice ifc = new IframePractice();
	ifc.framechecking();
	
}
}
