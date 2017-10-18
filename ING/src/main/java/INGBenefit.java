package main.java;

import java.io.File;
import java.io.FileInputStream;

import library.Utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class INGBenefit {
	@Test
	public static void main() throws Exception{
		WebDriver driver;
		String username = "updt1638";
		String pasword = "Isacmap#1";
		String secQue = "deerfield";
		driver = createWebDriver(username, pasword, secQue);
		String[][] data = excelRead();
		 double Value;
			for(int i = 1; i < data.length; i++)
				Value = benefit(driver, data[i][0], data[i][1], data[i][2], data[i][3], data[i][4]);
		} 
	
	public static double benefit(WebDriver driver, String ssn, String hour, String indsricttution, String outdistrict, String feeamount) throws Exception{
		 int i=0;
		try {
			//select academic year
			// driver.findElement(By.id("_ING_WAR_INGportlet_:ing1:acadYr")).clear();
					Select selectByIndex = new Select(driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:ing1:acadYr']")));
					selectByIndex.selectByIndex(0);
					
			//put ssn and click go
					driver.findElement(By.id("_ING_WAR_INGportlet_:ing1:ssn1")).clear();
					driver.findElement(By.id("_ING_WAR_INGportlet_:ing1:ssn1")).sendKeys(ssn);
					driver.findElement(By.id("_ING_WAR_INGportlet_:ing1:studsubmit")).click();	
			//wait till the next page launchs
					Thread.sleep(1000);
			//click on benefit
					driver.findElement(By.id("_ING_WAR_INGportlet_:person-search:Benefits1")).click();	
			//select from the last column
					Select selectByValue = new Select(driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[2]/td[4]/select")));
					selectByValue.selectByValue("P");
					
			//fill out the fields. 
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[3]/td[4]/input")).clear();
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[3]/td[4]/input")).sendKeys(hour);
					
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[4]/td[4]/input")).clear();
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[4]/td[4]/input")).sendKeys(indsricttution);
					
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[5]/td[4]/input")).clear();
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[5]/td[4]/input")).sendKeys(outdistrict);
					
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[6]/td[4]/input")).clear();
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[6]/td[4]/input")).sendKeys(feeamount);
					
					Select selectByValue1 = new Select(driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit:benefitTop']/tbody/tr[8]/td[4]/select")));
					selectByValue1.selectByValue("40");		
			
			//save changes
					driver.findElement(By.xpath(".//*[@id='_ING_WAR_INGportlet_:person-benefit']/input[3]")).click();
			//click home to go back
					driver.findElement(By.id("_ING_WAR_INGportlet_:person-benefit:home")).click();
		} catch (Exception e) {
			 i++;
			Utility.CaptureScreenShot(driver, "INGBenefit"+i);
			e.printStackTrace();
		}
		return 0;
		
				
	}

	private static WebDriver createWebDriver(String user, String pasword,
			String secQue) throws Exception {
		WebDriver driver = new FirefoxDriver();
		String appUrl = "https://isacportaluat.isac.org";
		driver.get(appUrl);
		driver.manage().window().maximize();

		String expectedTitle = "GAP Access - ISAC Gift Assistance Programs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);

		// put user name and pasword and login
		driver.findElement(
				By.id("_GAPLogin_WAR_GAPLoginportlet_:userregform:userid"))
				.sendKeys(user);
		driver.findElement(
				By.id("_GAPLogin_WAR_GAPLoginportlet_:userregform:password"))
				.sendKeys(pasword);
		driver.findElement(
				By.xpath(".//*[@id='_GAPLogin_WAR_GAPLoginportlet_:userregform']/fieldset/div/ul/li[3]/input"))
				.click();

		// wait till the page launchs
		Thread.sleep(1000);
		// submit security questions.
		driver.findElement(
				By.id("_GAPLogin_WAR_GAPLoginportlet_:forgetpwdform:ca1"))
				.sendKeys("abcd1");
		driver.findElement(
				By.id("_GAPLogin_WAR_GAPLoginportlet_:forgetpwdform:submit"))
				.click();

		// click on ING
		driver.findElement(By.id("layout_19")).click();
		// click on student list
		// driver.findElement(By.linkText("View Student List")).click();
		return driver;

	}
	
	public static String[][] excelRead() throws Exception{
		File excel = new File("C:\\Selenium\\Book1.xls");
		FileInputStream fis = new FileInputStream(excel);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet ws = wb.getSheet("BeneFit");
		
		int rowNum = ws.getLastRowNum() + 1;
		int colNum = ws.getRow(0).getLastCellNum();
		String[][] Data = new String[rowNum][colNum];
		
		for(int i = 1; i < rowNum; i++){
			HSSFRow row = ws.getRow(i);
			
			for(int j = 0; j <colNum; j++){
			HSSFCell cell = row.getCell(j);
			String value ="";
			if(cell != null){
				value = cellToString(cell);
			}
			Data[i][j] = value;
			}
		}
		return Data;
	}
	
	public static String cellToString(HSSFCell cell) throws Exception {
		int type;
		Object result;
		type = cell.getCellType();
		
		switch(type){
		
		case 0:
			result = cell.getNumericCellValue();
			break;
		case 1:
			result = cell.getStringCellValue();
			break;
		case 3:
			result = cell.getStringCellValue();
		      break;
			default:
				throw new RuntimeException("No cell support");
		}
		return result.toString();

	}

		}


