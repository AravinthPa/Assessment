package PedaSys_Assessment.PedaSys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class PedaSys_NavigationTab_Testcase {

	static WebDriver driver;

	@Given("^open the browser$")
	public void open_the_browser() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("browser opened....");

	}

	@When("^navigate into \"([^\"]*)\"$")
	public void navigate_into(String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(URL);
		System.out.println("URL entered....");

	}

	@Then("^move mouse into \"([^\"]*)\"$")
	public void move_mouse_into(String objectName) throws Throwable {

		try {
			// Write code here that turns the phrase above into concrete actions
			Actions act = new Actions(driver);
			Thread.sleep(5000);
			act.moveToElement(driver.findElement(By.linkText(objectName))).build().perform();
			System.out.println("Move to: "+objectName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^click \"([^\"]*)\"$")
	public void click(String ObjectName) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			Thread.sleep(5000);
			driver.findElement(By.linkText(ObjectName)).click();
			System.out.println("clicked: "+ ObjectName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Verify the Title \"([^\"]*)\"$")
	public void verify_the_Tittle(String Tittle) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		try {
			Thread.sleep(5000);
			String currentTittle = driver.getTitle();
			System.out.println("current tittle: "+ currentTittle);
			Assert.assertEquals(Tittle, currentTittle);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

}
