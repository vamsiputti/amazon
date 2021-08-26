package arg.pack1;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

public class Amazon {
public static void main(String[] args) throws InterruptedException {
	

//webDriver launch
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	//lunch URL
	driver.navigate().to("https://www.amazon.in/");
	driver. manage().window().maximize();
	//product search " Samsung Galaxy Watch"
	WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
	element.sendKeys("Samsung Galaxy Watch (Bluetooth + LTE, 46 mm) - Silver",Keys.ENTER);
//finding parent window id
	String prwin = driver.getWindowHandle();
	driver.findElement(By.xpath("(//span[contains(text(),'Samsung Galaxy Watch (Bluetooth + LTE, 46 mm) - Silver')])[3]")).click();
	//find the allt he window ids
	Set<String> win = driver.getWindowHandles();
	System.out.println(win);
	System.out.println(prwin);
	for (String s : win) {
		if (!s.equals(prwin)) {
    driver.switchTo().window(s);
}
		
	}	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	//Add the item to cart
	WebElement ElementToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
	ElementToCart.click();
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
//go login page
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
//username
driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("7981337559");
driver.findElement(By.id("continue")).click();
//password
driver.findElement(By.id("ap_password")).sendKeys("kiran7559");
driver.findElement(By.id("signInSubmit")).click();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//seledct address
driver.findElement(By.xpath("(//a[contains(@data-action,'page-spinner-show')])[1]")).click();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//select payment
driver.findElement(By.xpath("//input[@value='SelectableAddCreditCard']")).click();
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.close();
//switch to parent window
 driver.switchTo().window(prwin);
 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 driver.navigate().refresh();
 //goto cart
 driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//delete item from cart
 driver.findElement(By.xpath("//input[@value='Delete']")).click();
 
	
}
}
