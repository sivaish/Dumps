package Neustar.AUReg.StepDefinitions;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage {

	WebDriver driver;

	@Given("^Open auregistery in chrome driver$")
	public void open_auregistery_in_chrome_driver() throws Throwable {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ausregistry.com.au/");
	}

	@Then("^I get the no of registered domains$")
	public void i_get_the_no_of_registered_domains() throws Throwable {
		String Total = driver.findElement(By.xpath("//*[@id=\"post-11560\"]/div/div[4]/div/div/div/h1/span/div"))
				.getText();

		String newTotal = Total.replaceAll(",", "");

		System.out.println("Total Registered - " + newTotal);
	}

	@And("^I check the total number is greater than (\\d+) billion$")
	public void i_check_the_total_number_is_greater_than_billion(int newTotal) throws Throwable {

		if (newTotal < 3000000) {
			System.out.println("The value is more than three million");
		} else {
			System.out.println("The value is less than three million");
		}
		
		driver.quit();

	}

	@When("^I open the domain availability page$")
	public void i_open_the_domain_availability_page() throws Throwable {

		Thread.sleep(5000);

		Robot robot = new Robot();

		robot.mouseMove(1758, 600);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"shortcutLinks\"]/ul/li[1]/a")).click();
	}

	@Then("^I enter the \\.com\\.au domain name and verify$")
	public void i_enter_the_com_au_domain_name_and_verify() throws Throwable {
		
		driver.findElement(By.id("whois-input-box")).sendKeys("test-automation");

		driver.findElement(By.id("whois-submit-btn")).click();

		String Dom_Avil_Msg = driver.findElement(By.xpath("//*[@id=\"post-11559\"]/div/div[1]/div/div/div")).getText();

		System.out.println(Dom_Avil_Msg);
		
		if (Dom_Avil_Msg.contains("Sorry")) {
			System.out.println("The requested site/domain is not available");
		}
		
	}

	@Then("^I enter the \\.org\\.au domain name and verify$")
	public void i_enter_the_org_au_domain_name_and_verify() throws Throwable {

		driver.findElement(By.id("whois-input-box")).sendKeys("test-automation");

		Select oSelect = new Select(driver.findElement(By.id("a_zone")));

		oSelect.selectByVisibleText(".org.au");

		driver.findElement(By.id("whois-submit-btn")).click();

		String Dom_Avil_Msg1 = driver.findElement(By.xpath("//*[@id=\"post-11559\"]/div/div[1]/div/div/div")).getText();

		System.out.println(Dom_Avil_Msg1);
		
		if (Dom_Avil_Msg1.contains("Great")) {
			System.out.println("The requested site/domain is available");
		}
		
		driver.quit();
	}

	@When("^I open the Registrar page$")
	public void i_open_the_Registrar_page() throws Throwable {
		
		Thread.sleep(5000);

		Robot robot = new Robot();

		robot.mouseMove(1758, 600);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"shortcutLinks\"]/ul/li[4]/a")).click();
	}

	@Then("^I get the count of external links$")
	public void i_get_the_count_of_external_links() throws Throwable {
		
		int LinkCount = driver.findElements(By.xpath("//*[@id=\"randomizedLogos\"]/div/p")).size();
		
		System.out.println("The count of links avaialbe are : " +LinkCount);

	}
	
	@And("^I Become a Registrar and verify the page$")
	public void i_Become_a_Registrar_and_verify_the_page() throws Throwable {

		driver.findElement(By.xpath("//*[@id=\"post-12063\"]/div/div[3]/div/div[2]/div/div[1]/a/span")).click();

		String MainMsg1 = driver.findElement(By.xpath("//*[contains(text(), 'Email')]")).getText();

		System.out.println("The message is - " + MainMsg1);

		String MainMsg2 = driver.findElement(By.xpath("//*[contains(text(), 'Phone')]")).getText();

		System.out.println("The message is - " + MainMsg2);
		
		driver.quit();
	}

}