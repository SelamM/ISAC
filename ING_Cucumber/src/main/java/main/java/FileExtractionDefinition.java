package main.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FileExtractionDefinition {
	WebDriver driver = null;
	
	@Given("^I loged in$")
	public void i_loged_in() throws Throwable {
		try {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.navigate().to("http://isacportaluat.isac.org");
			driver.findElement(
					By.xpath(".//*[@id='_GAPLogin_WAR_GAPLoginportlet_:userregform:userid']"))
					.sendKeys("");
			driver.findElement(
					By.xpath(".//*[@id='_GAPLogin_WAR_GAPLoginportlet_:userregform:password']"))
					.sendKeys("");
			driver.findElement(
					By.xpath(".//*[@id='_GAPLogin_WAR_GAPLoginportlet_:userregform']/fieldset/div/ul/li[3]/input"))
					.click();
		} catch (Exception e) {

		}
	}

	@Given("^Click on ING$")
	public void clickOnING() throws Throwable {
		driver.findElement(By.id("layout_19")).click();
	}

	@When("^I click on File extraction tab$")
	public void FileExtraction() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing:file']")).click();
		  
	}
	@And("^I select School$")
	public void SelectAschool() throws Throwable {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:fileExtract:school']")));
		selectByIndex.selectByIndex(1);
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:fileExtract:continueBtn']"))
				.click();
	}

	@When("^I click on Creat new file extraction$")
	public void NewFileExtraction() throws Throwable {
	   driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:fileExtract:createBtn']")).click();
	}

	@Then("^I should have the option to select report types$")
	public void SelectReportType() throws Throwable {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:reports:reportName1']")));
		selectByIndex.selectByIndex(0);
	}

	@Then("^request report$")
	public void RequestReport() throws Throwable {
	driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:reports']/ul/li[4]/input")).click();  
	}


}
