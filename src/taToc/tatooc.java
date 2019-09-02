package taToc;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;

public class tatooc {
	
	public static void checkelement() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
	    String baseUrl = "http://10.0.1.86/tatoc";
		driver.get(baseUrl);
		WebElement actual = driver.findElement(By.xpath("//*[text()='Test Automation Training Obstacle Course']"));
		if(actual.isDisplayed())
		 {
			 System.out.println("Test passed");
		 }
		 else
		{
			System.out.println("Test failed");
		 }
	
		
		String tagName =("");
	    tagName = driver.findElement(By.linkText("Basic Course")).getTagName();
	    System.out.println(tagName);
	
	     
		driver.findElement(By.linkText("Basic Course")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.findElement(By.xpath("//div[@class='greenbox']")).click();
        Thread.sleep(3);
       driver.switchTo().frame("main");
       String name = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
       System.out.println(name);
       String newName= "";
        while( !name.equalsIgnoreCase (newName) )
        {   driver.switchTo().defaultContent();
            driver.switchTo().frame("main");
        	driver.findElement(By.xpath("//a[text() ='Repaint Box 2']")).click();
            driver.switchTo().frame("child");
            newName = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
          
        }
        System.out.println(newName);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("main");
        driver.findElement(By.xpath("//a[text() ='Proceed']")).click();

        WebElement From=driver.findElement(By.xpath("//div[@id='dragbox']"));	
        
        //Element on which need to drop.		
        WebElement To=driver.findElement(By.xpath("//div[text()='DROPBOX']"));
        Actions act=new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
     
        driver.findElement(By.xpath("//a[text()='Proceed']")).click();
        
        driver.findElement(By.xpath("//a[@onclick='launchwindow();']")).click(); 

        Set<String> allHandles = driver.getWindowHandles();

      

        //Get current handle or default handle
        String currentWindowHandle = allHandles.iterator().next();
        System.out.println("currentWindow Handle"+currentWindowHandle);

        //Remove first/default Handle
        allHandles.remove(allHandles.iterator().next());

        //get the last Window Handle
        String lastHandle = allHandles.iterator().next();
        System.out.println("last window handle"+lastHandle);

        //switch to second/last window, because we know there are only two windows 1-parent window 2-other window(ad window)
    driver.switchTo().window(lastHandle);
        System.out.println(driver.getTitle());
        
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("sasdghs");
        driver.findElement(By.xpath("//input[@id='submit']")).click();
        driver.switchTo().window(currentWindowHandle);
        driver.findElement(By.xpath("//a[@onclick=\"gonext();\"]")).click();
        driver.findElement(By.xpath("//a[@onclick=\"generateToken();\"]")).click();

         String x = driver.findElement(By.xpath("//span[@id=\"token\"]")).getText();
         String x1[]=x.split(" ");
         String token=x1[1];
         Cookie cookie = new Cookie("Token", token);
         driver.manage().addCookie(cookie);
         driver.findElement(By.xpath("//a[@onclick=\"gonext();\"]")).click();
         driver.findElement(By.linkText("Advanced Course")).click();
       driver.findElement(By.xpath("//span[text()=\"Menu 2\"]")).click();
       driver.findElement(By.xpath("//span[text()=\"Go Next\"]")).click();
			
	}
	
public static void main(String[] args) throws InterruptedException {
	      
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		checkelement();
	    
	 }
}
		 