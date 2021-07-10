package PedaSys_Assessment.PedaSys;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PedaSys_Form_Validation {
	static WebDriver driver;
	static Properties prop;

	@Given("^open browser$")
	public void open_browser() throws Throwable {
		File file = new File("./Properites\\FormData.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@When("^Navigate into URL \"([^\"]*)\"$")
	public void navigate_into_URL(String URL) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.get(prop.getProperty(URL));

	}

	@Then("^Type \"([^\"]*)\" into \"([^\"]*)\"$")
	public void type_into(String value, String object) throws Throwable {
		try {
			Thread.sleep(3000);
			boolean status = driver.findElement(By.xpath(prop.getProperty(object))).isDisplayed();
			if (status == true) {
				driver.findElement(By.xpath(prop.getProperty(object))).sendKeys(prop.getProperty(value));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^Select \"([^\"]*)\" from \"([^\"]*)\"$")
	public void select_from(String value, String object) throws Throwable {
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath(prop.getProperty(object)));
		Select sel=new Select(element);
		sel.selectByVisibleText(prop.getProperty(value));

	}

	@Then("^click value in \"([^\"]*)\"$")
	public void click_value_in(String object) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		//System.out.println(prop.getProperty(object));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty(object))).click();
		
		if(object.contentEquals("Submit")) {
		List<WebElement> msg = driver.findElements(By.xpath("//label[@class='hs-error-msg'] "));
		for (int i = 0; i < msg.size(); i++) {
			System.out.println(msg.get(i).getText());
		}
		}

	}

}
