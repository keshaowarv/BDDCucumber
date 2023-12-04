package StepDef;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep 
{
	
	WebDriver driver;
	
	@Given("user is log onto the Amazon Website Home page")
	public void user_is_on_login_page() {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	 System.out.println("Inside is on login page");
	}
	
	
	@When("user searches a I phone product on the home page")
	public void user_enters_username_and_password() {
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		System.out.println("User can see the product list");
	}

	@Then("user should be able to view product and add to cart product")
	public void user_should_be_able_to_view_product_and_add_to_cart_product() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of the element is " +price);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("8329337746");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		System.out.println("User add the product into cart");
	}

	@And("closed")
	public void closed() {
		driver.quit();
		
		System.out.println(" user can logout ");
	}

}
