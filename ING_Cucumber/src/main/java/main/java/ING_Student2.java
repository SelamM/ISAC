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

public class ING_Student2 {
	WebDriver driver = null;

	@Given("^I logged in as ISAC user$")
	public void Login() throws InterruptedException {
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

	@When("^I Click on ING tab$")
	public void OpenMap() throws InterruptedException {
		driver.findElement(By.id("layout_19")).click();
	}

	@And("^I Clicked on Student tab$")
	public void Studenttab() {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing:student']"))
				.click();
	}

	@And("^I Selected a school$")
	public void PickingSchool() {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:list:school']")));
		selectByIndex.selectByIndex(2);
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list']/p[1]/input"))
				.click();
	}

	@When("^I click On Search Icon$")
	public void i_click_On_Search_Icon() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:studentlist:0:edit']"))
				.click();
	}

	@Then("^I should be on student detail eligiblity page$")
	public void i_should_be_able_to_see_the_payment_page_for_the_selected_student()
			throws Throwable {

	}

	@And("^when I click on Eligiblity$")
	public void Eligiblity() {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-search:detail']"))
				.click();
	}

	@Then("^I should see selected student eligiblity detail$")
	public void EligiblityPage() {

	}

	@And("^when I click on School changes$")
	public void SchoolChanges() {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-search:schoolChanges1']"))
				.click();
	}

	@Then("^I should see the school changes for the selected student$")
	public void Schools() {

	}

	@And("^when I click on Student Update$")
	public void StudentUpdate() {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-search:studentUpdate1']"))
				.click();
	}

	@Then("^I should see the updates$")
	public void Updates() {

	}

}
