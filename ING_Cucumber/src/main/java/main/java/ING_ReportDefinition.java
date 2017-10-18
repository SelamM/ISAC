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

public class ING_ReportDefinition {
WebDriver driver = null;	
	
	@Given("^I loged in as ISAC user$")
	public void Login() throws Throwable {
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

	@And("^I Click on ING$")
	public void OpenMap() throws InterruptedException {
		driver.findElement(By.id("layout_19")).click();
	}
	@When("^I click on Report tab$")
	public void BudgetTab() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing:reports']")).click();
	}

	@When("^I Select school$")
	public void SelectAschool() throws Throwable {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:reports:school']")));
		selectByIndex.selectByIndex(1);
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:reports:continueBtn']"))
				.click();
	}

	@Then("^I Should see the budget Information for the school$")
	public void BudgetInfo() throws Throwable {
	   
	}
	@And("^when I clcik on create Report tab$")
	public void CreateReport() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:reports:createBtn']"))
				.click();

	}

	@Then("^I should have the option to select report type$")
	public void i_should_have_the_option_to_select_report_type()
			throws InterruptedException {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:reports:reportName']")));
		selectByIndex.selectByIndex(1);
	}

	@And("^request a report$")
	public void request_a_report() throws InterruptedException {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:reports']/ul/li[6]/input"))
				.click();
	}

}
