import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddCartAutomation {

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
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//li[@class='topnav_item studyunit']"))).build().perform();
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(By.xpath("//li[@class='subnav_item 1729']"))).click().build().perform();
        Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Terry Study Table Furniture Terry Study Table (Golden Oak Finish)']")).click();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("add-to-cart-button")).click();
		WebElement wb=driver.findElement(By.id("select_0_quantity"));
		wb.click();
		wb.sendKeys(Keys.ARROW_DOWN);
		wb.sendKeys(Keys.ENTER);
		
		System.out.println("Product Name:"+driver.findElement(By.xpath("//div[@class='product-title']")).getText());
		System.out.println("Delivery Date:"+driver.findElement(By.xpath("//div[@class='delivery-date']")).getText());
		System.out.println("Quantity:"+driver.findElement(By.xpath("//option[@selected='selected']")).getText());
		System.out.println("Price:"+driver.findElement(By.xpath("//div[@class='final-price']")).getText());
		
		
		
		
	}

}
