import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WishlistAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@class='header-icon-link user-profile-icon']")).click();
		driver.findElement(By.xpath("//a[@class='login-link authentication_popup']")).click();
		Thread.sleep(5000);	
		
		
		driver.findElement(By.xpath("//input[@class='email required input_authentication']")).sendKeys("priyangacvp@gmail.com");
		driver.findElement(By.xpath("//input[@class='required input_authentication']")).sendKeys("Priya@007");
		driver.findElement(By.id("ul_site_login")).click();
		
		driver.findElement(By.cssSelector("a[href='/bed?src=explore_categories']")).click();
		driver.findElement(By.cssSelector("a[href='/king-size-bed?src=cat_2\']")).click();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[@data-vid='69040']")).click();
		driver.findElement(By.xpath("//div[@id='shortlist-badge']")).click();
		System.out.println("My Wishlist:");
		System.out.println(driver.findElement(By.xpath("//div[@class='product-title product-title-sofa-mattresses']")).getText());
		
	

	}

}
