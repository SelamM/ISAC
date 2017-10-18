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

public class ING_StudentTabDefinition {
	WebDriver driver = null;

	@Given("^I login as ISAC user$")
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

	@When("^I click on ING tab$")
	public void OpenMap() throws InterruptedException {
		driver.findElement(By.id("layout_19")).click();
	}

	@When("^i select academic year$")
	public void SelectAcademyYear() throws InterruptedException {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:ing1:acadYr']")));
		selectByIndex.selectByIndex(1);
		
	}

	@And("^I put ssn number to the view student list field$")
	public void PutSSN() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing1:ssn1']")).sendKeys("319903345");
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing1:studsubmit']")).click();
	}
	@Then("^I should be in the student detail eligiblity page$")
	public void StudentDetailPage() throws InterruptedException {
		
	}
	
	@Given("^I clicked on Student tab$")
	public void Studenttab(){
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing:student']")).click();
	}
	
	@And("^I selected a school$")
	public void PickingSchool() {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:list:school']")));
		selectByIndex.selectByIndex(1);
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list']/p[1]/input"))
				.click();
	}

	@When("^I click on first, next, last and previous buttons$")
	public void ClickOnFLNP() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:first']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:next']")).click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:previous']"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:last']")).click();

	}

	@Then("^I should be able to navigate through each pages$")
	public void Navigate() throws Throwable {

	}

	@When("^I select number of entrees$")
	public void NumberOfEntreis() throws Throwable {
		Select selectByIndex = new Select(driver.findElement(By
				.xpath(".//*[@id='_ING_WAR_INGportlet_:list:listPageSize1']")));
		selectByIndex.selectByIndex(2);
	}

	@Then("^I should see the number of student selected$")
	public void NumberOfStudent() throws Throwable {

	}

	@And("^when I Click on view report$")
	public void ViewReport() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list']/span[2]/a[1]"))
				.click();
		// driver.findElement(By.xpath(".//*[@id='_MAP_WAR_MAPportlet_:report:refreshBtn']")).click();
		driver.close();
	}

	@Then("^I should see the report for the selected school$")
	public void SeeReport() throws Throwable {

	}

	@And("^when i click on excel report$")
	public void ClickOnexcelReport() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:list']/span[2]/a[2]"))
		.click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:report:refreshBtn']"))
				.click();
		driver.close();
	}

	@Then("^I should get excel report$")
	public void GetExcelReport() throws Throwable {

	}

	@Given("^I selected a student$")
	public void SelectAstudent() throws Throwable {
		// click on the search icon
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:list:studentlist:0:edit']"))
				.click();
	}

	@When("^I clcik on person detail$")
	public void PersonDetail() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-search']/h2[2]/a"))
				.click();
	}

	@Then("^I should be on the persons detal page$")
	public void PersonDetailPage() throws Throwable {

	}

	@And("^when i click on History$")
	public void ClickOnHistory() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-deatils:historybutton']"))
				.click();
	}

	@Then("^I should see the History of the student$")
	public void HistoryOfStudent() throws Throwable {

	}

	@And("^when I filter the entries$")
	public void FilterEntries() throws Throwable {
		Select selectByIndex = new Select(
				driver.findElement(By
						.xpath(".//*[@id='_Person_WAR_Personportlet_:person-update:example_length']/label/select")));
		selectByIndex.selectByIndex(0);
	}

	@Then("^I should only see the selected number of reports$")
	public void NumberOfReports() throws Throwable {

	}

	@And("^when I click on back button$")
	public void BackButton() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-update']/div[1]/input"))
				.click();
	}

	@Then("^I should be back to the person detail page$")
	public void DetailPage() throws Throwable {

	}

	@And("^when I select the view button of associatd program for each year$")
	public void ViewButton() throws Throwable {
		Select selectByIndex = new Select(
				driver.findElement(By
						.xpath(".//*[@id='_Person_WAR_Personportlet_:person-deatils:viewSampleDataTable:0:ylist']")));
		selectByIndex.selectByIndex(0);
		driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-deatils:viewSampleDataTable_data']/tr[1]/td[4]/input[1]"))
				.click();
		
		/*driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-search']/h2/input"))
				.click();
		Select selectByIndex1 = new Select(
				driver.findElement(By
						.xpath(".//*[@id='_Person_WAR_Personportlet_:person-search:year']")));
		selectByIndex1.selectByIndex(1);
		driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-search']/h2/input"))
				.click();
		Select selectByIndex2 = new Select(
				driver.findElement(By
						.xpath(".//*[@id='_Person_WAR_Personportlet_:person-search:year']")));
		selectByIndex2.selectByIndex(2);
		driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-search']/h2/input"))
				.click();*/
	}

	@Then("^I should be on person transaction list page$")
	public void PersonTransaction() throws Throwable {

	}

	@And("^Clicking on the person detail should take me back to person detal page$")
	public void BackToPersonDetail() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-search']/h2[2]/a"))
				.click();
	}

	@When("^I click on Units used$")
	public void UnitsUsed() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-deatils:viewSampleDataTable_data']/tr[1]/td[4]/input[2]"))
				.click();
	}

	@Then("^I should see the units used for all academic years$")
	public void UnitsForAllAcademicYear() throws Throwable {

	}

	@And("^when I click on Person detail button$")
	public void PersonDetailButton() throws Throwable {
		driver.findElement(
				By.xpath(".//*[@id='_Person_WAR_Personportlet_:person-search:j_idt39']"))
				.click();
	}

	@Given("^I want to sort the student list$")
	public void SortStudent() throws InterruptedException {
		//click on student tab
		driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing:student']"))
				.click();
		//click on sort
		driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[3]/input")).click();
	}

	@When("^I select the sorting options$")
	public void SortingOption() throws InterruptedException {
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing']/div[3]/div[1]/select/option[1]"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing']/div[3]/div[2]/input[1]"))
				.click();
	}

	@And("^I click on View$")
	public void ClickOnview() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='tabs4']/ul/li[1]/input"))
				.click();
	}

	@Then("^I should be able to see the sorted lists$")
	public void SeeTheList() throws InterruptedException {

	}
}
