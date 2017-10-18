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

public class ING_StudentFilter {
	WebDriver driver = null;
	 
	 @Given("^I loged in Internal user$")
	 public void LoginAsIsac() throws InterruptedException {
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

	 e.printStackTrace();
	 }
	 }
	 @When("^I Click On ING tab$")
	 public void OpenMap() throws InterruptedException {
		 driver.findElement(By.id("layout_19")).click();
	 }

	 @And("^I select academic year$")
	 public void SelectAcademyYear() throws InterruptedException {
		 Select selectByIndex = new Select(driver.findElement(By
					.xpath(".//*[@id='_ING_WAR_INGportlet_:ing1:acadYr']")));
			selectByIndex.selectByIndex(1);
	 }

	 @And("^I click on student tab$")
	 public void i_click_on_Student_tab() throws InterruptedException {
	driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing:student']")).click();
	 }
	 @And("^I Select a school$")
	 public void PickingSchool() {
		 Select selectByIndex = new Select(driver.findElement(By
					.xpath(".//*[@id='_ING_WAR_INGportlet_:list:school']")));
			selectByIndex.selectByIndex(2);
			driver.findElement(
					By.xpath(".//*[@id='_ING_WAR_INGportlet_:list']/p[1]/input"))
					.click();
	 }
	 
	 @Given("^I click on filter tab to filter$")
	 public void ClickOnFilter() throws Throwable {
	 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
	 }

	 @When("^I pass a ssn number to ssn field$")
	 public void PassNumber() throws Throwable {
	 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter:ssn']")).sendKeys("338114588");

	 }

	 @Then("^I should see the list$")
	 public void SSNList() throws Throwable {
	 //click on view to see
	 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[1]/input"))
	 .click();
	 }

	 @When("^I select term$")
	 public void SelectTerm() throws Throwable {
	 //click on student tab to reset the previous search
	 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:student']")).click();
	 //click on filter
	 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
	 //select term
	 Select selectByIndex = new Select(driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter:term']")));
	 selectByIndex.selectByIndex(2);	  
	 }

	/* @When("^I select ING code$")
	 public void SelectMapCode() throws Throwable {
	 //click on student tab to reset the previous search
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter:student']")).click();
	 //click on filter
		 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
	 //select term
	 Select selectByIndex = new Select(driver.findElement(By.xpath(".//*[@id='_MAP_WAR_MAPportlet_:studentFilter:mapCode']")));
	 selectByIndex.selectByIndex(1);
	 }*/

	 @When("^I select selected student only$")
	 public void SelectedStudent() throws Throwable {
		//click on student tab to reset the previous search
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:student']")).click();
		 //click on filter
		 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter']/fieldset/div/div/ul/li[1]/input")).click();
		 
	 }

	@When("^I select eligible student only$")
	public void EligibleStudent() throws Throwable {
		//click on student tab to reset the previous search
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:student']")).click();
		 //click on filter
		 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter']/fieldset/div/div/ul/li[2]/input"))
				.click();
	} 
	@When("^I select by 10 Year$")
	public void Year() throws Throwable {
		//click on student tab to reset the previous search
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:student']")).click();
		 //click on filter
		 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter']/fieldset/div/div/ul/li[3]/input"))
				.click();
	} 
	@When("^I select by ING units used$")
	public void INGUnits() throws Throwable {
		//click on student tab to reset the previous search
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:student']")).click();
		 //click on filter
		 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter']/fieldset/div/div/ul/li[5]/input"))
				.click();
	} 
	@When("^I select by ISAC default$")
	public void ISACDefault() throws Throwable {
		//click on student tab to reset the previous search
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:student']")).click();
		 //click on filter
		 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter']/fieldset/div/div/ul/li[6]/input"))
				.click();
	} 
	@When("^I select by applied late$")
	public void Aplliedlate() throws Throwable {
		//click on student tab to reset the previous search
		 driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:student']")).click();
		 //click on filter
		 driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[2]/input")).click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:studentFilter:applate']"))
				.click();
	} 

}
