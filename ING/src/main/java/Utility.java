package main.java;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void CaptureScreenShot(WebDriver driver, String ScreenShotName){
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source,new File("./screenshots/" + ScreenShotName + ".png"));
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot" + e);
		} 
	}

}
