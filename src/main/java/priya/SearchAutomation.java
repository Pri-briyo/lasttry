import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']")).click();
		driver.findElement(By.xpath("//a[@class='login-link authentication_popup']")).click();
		Thread.sleep(5000);	
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@class='email required input_authentication']")).sendKeys("priyangacvp@gmail.com");
		driver.findElement(By.xpath("//input[@class='required input_authentication']")).sendKeys("Priya@007");
		driver.findElement(By.id("ul_site_login")).click();
		
		WebElement wb=driver.findElement(By.id("search"));
		wb.click();
		wb.sendKeys("Night lamp");
		driver.findElement(By.id("search_button")).click();
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//li[@data-group='category']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filters_primary_category_Table_Lamps']")).click();
		
		a.moveToElement(driver.findElement(By.xpath("//li[@data-group='price']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='price_limit_839-8371']")).click();
		
		a.moveToElement(driver.findElement(By.xpath("//li[@data-group='base finish']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='filters_lamp_base_finish_Natural']")).click();
		
		a.moveToElement(driver.findElement(By.xpath("//div[@data-group='sorting']"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-key='new_arrival']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Night Lamp Furniture Madera Table Lamp (Natural Base Finish, White Shade Color, Square Shade Shape)']")).click();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath("//a[@class='continueshop']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentId);
		
		driver.findElement(By.xpath("//span[@data-vid='96396']")).click();
		a.moveToElement(driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']"))).build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.id("logout")).click();
		System.out.println("Successfully filter and search the items and added to the cart");
		
		
		
		
		

	}

}
