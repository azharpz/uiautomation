package functional.dashboard.scripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import functional.dashboard.pages.DashboardPages;

@Test
public class Dashboard001_SearchTruck extends BaseTest{


	@Test

	public  void searchTruck() throws IOException, InterruptedException, AWTException 
    {
	
		// WebDriver driver=capabilities();
		 DashboardPages dashboard = PageFactory.initElements(driver, DashboardPages.class);

		
		 //dashboard.selectFromCity();
		
		 		
    }
	
	

}

