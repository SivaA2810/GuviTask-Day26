package Day26.Windows_Frames;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiple_iframes {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://the-internet.herokuapp.com/nested_frames");
	driver.manage().window().maximize();
	List<WebElement> frames = driver.findElements(By.tagName("frame"));
	int size = frames.size();System.out.println("total frames - "+size);
//	Switch to the top frame.	
	driver.switchTo().frame(0);
	List<WebElement> frames2 = driver.findElements(By.tagName("frame"));
//	Verify that there are three frames on the page.	
	int size2 = frames2.size();System.out.println("total frames in top - "+size2);
	driver.switchTo().frame(0);
//	Verify that the left frame has a text "LEFT".
	WebElement frameleft = driver.findElement(By.tagName("body"));
    String text = frameleft.getText();System.out.println(text);
//  Switch back to the top frame.
    driver.switchTo().parentFrame();
//  Switch to the middle frame.
    driver.switchTo().frame(1);
//	Verify that the middle frame has a text "MIDDLE".   
    WebElement framemidle = driver.findElement(By.tagName("body"));
    String text1 = framemidle.getText();System.out.println(text1);
    driver.switchTo().parentFrame();
//  Switch to the Right frame.
    driver.switchTo().frame(2);
    WebElement frameRight = driver.findElement(By.tagName("body"));
    String text2 = frameRight.getText();System.out.println(text2);
    driver.switchTo().parentFrame();
//  Switch to the bottom frame. 
    driver.switchTo().parentFrame();
    driver.switchTo().frame(1);
    WebElement framebottom = driver.findElement(By.tagName("body"));
    String text3 = framebottom.getText();System.out.println(text3);
}
}
