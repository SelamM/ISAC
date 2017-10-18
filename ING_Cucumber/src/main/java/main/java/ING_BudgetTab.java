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

public class ING_BudgetTab {
	WebDriver driver = null;	
	
	@Given("^I login as Internal user$")
	public void Login() throws Throwable {
		try {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			driver.navigate().to("http://isacportaluat.isac.org");
			driver.findElement(
					By.xpath(".//*[@id='_GAPLogin_WAR_GAPLoginportlet_:userregform:userid']"))
					.sendKeys("Sgebreti");
			driver.findElement(
					By.xpath(".//*[@id='_GAPLogin_WAR_GAPLoginportlet_:userregform:password']"))
					.sendKeys("Mamasina31");
			driver.findElement(
					By.xpath(".//*[@id='_GAPLogin_WAR_GAPLoginportlet_:userregform']/fieldset/div/ul/li[3]/input"))
					.click();
		} catch (Exception e) {

		}
	}

	@And("^I click on ING$")
	public void OpenMap() throws InterruptedException {
		driver.findElement(By.id("layout_19")).click();
	}
	@When("^I click on budget tab$")
	public void BudgetTab() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing:budget']")).click();
	}

	@When("^I select school$")
	public void SelectAschool() throws Throwable {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:schoolBudgetForm:school']")));
		selectByIndex.selectByIndex(1);
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:schoolBudgetForm:continueBtn']"))
				.click();
	}

	@Then("^I shold see the budget Information for the school$")
	public void BudgetInfo() throws Throwable {
	   
	}
}
