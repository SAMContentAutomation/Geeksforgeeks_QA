package taToc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class advncTatoc {
	
		public  void advtatoc()
		{
			WebDriver driver = new ChromeDriver();
			String baseUrl = "http://jsbin.com/osebed/2";
			driver.get(baseUrl);
			Select drop =new Select(driver.findElement(By.xpath("//select[@id=\"fruits\"]")));
			drop.selectByVisibleText("Banana");
			drop.selectByIndex(1);
			
		}
	
public static void main(String[] args)
{
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	advncTatoc xyz = new advncTatoc();
	xyz.advtatoc();
}
}