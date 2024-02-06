package functional.dashboard.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;


	public abstract class DashboardPageObjects extends BaseTest {
		
		


		
		public DashboardPageObjects(WebDriver driver){
			BaseTest.driver=driver;
			
			PageFactory.initElements(driver,this); 
			
		}

		
		
		
		@FindBy(how=How.XPATH,using="//button[.='New']") 
		protected
		WebElement addcustomer;
		
		@FindBy(how=How.XPATH,using="//p[.='Add Customer Details']") 
		protected
		WebElement titleverify;
		
		@FindBy(how=How.XPATH,using="//tbody/tr[1]/td[8]/div[1]/button[1]") 
		protected
		WebElement threedots;
		
		@FindBy(how=How.XPATH,using="//ul[@class='dropdown-menu show']//a[@class='dropdown-item cursor-pointer'][normalize-space()='Create Invoice']") 
		protected
		WebElement createinvoice;
		
		@FindBy(how=How.XPATH,using="//a[normalize-space()='Sales']") 
		protected
		WebElement expandsales;
		
		@FindBy(how=How.XPATH,using="//a[normalize-space()='Customer']") 
		protected
		WebElement customer;
		
		@FindBy(how=How.XPATH,using="//a[normalize-space()='Invoice']") 
		protected
		WebElement invoice;
		
		@FindBy(how=How.XPATH,using="//ul[@id='submenu1']") 
		protected
		WebElement menu;
		
		@FindBy(how=How.XPATH,using="//p[@class='m-0 fs-5 fw-normal']") 
		protected
		WebElement customertitle;
		
		@FindBy(how=How.XPATH,using="//ul[@class='dropdown-menu show']//a[@class='dropdown-item cursor-pointer'][normalize-space()='View Customer']") 
		protected 
		WebElement viewcustomer;
		
		@FindBy(how=How.XPATH,using="//p[@class='m-0 fs-5 fw-semibold ng-star-inserted']") 
		protected
		WebElement viewcustomertitle;
		
		@FindBy(how=How.XPATH,using="//ul[@class='dropdown-menu show']//a[@class='dropdown-item cursor-pointer'][normalize-space()='Edit Customer']") 
		protected
		WebElement editcustomertitle;
		
		@FindBy(how=How.XPATH,using="//button[normalize-space()='Import']") 
		protected
		WebElement importcustomer;

			}

