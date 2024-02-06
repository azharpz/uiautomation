package functional.dashboard.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import functional.dashboard.pageobjects.DashboardPageObjects;

public class DashboardPages extends DashboardPageObjects {
	static com.aventstack.extentreports.ExtentReports report;
	static ExtentTest test;
//		   driver.findElement(By.cssSelector("//input[@id='customFile']")).sendKeys("D:\\azhar\\azhar\\company\\IMG_20190814_061616.jpg");


	/**
	 * Create new LandingPage object with the given driver.<br>
	 * <br>
	 * Driver is passed through to the backing object class.
	 * 
	 * @param driver active driver to use for this page
	 */

	static Logger log = Logger.getLogger(DashboardPages.class.getName());

	public DashboardPages() {

		super(driver);
	}

	/**
	 * Selects the 'MY ACCOUNT' option from the header navigation ribbon.<br>
	 * <br>
	 * This is expected to display the list of options directly below (no page
	 * navigation).
	 * @throws IOException
	 */

	
	

	private void reportVP(String string, String pass, String string2) {
		// TODO Auto-generated method stub

	}

	

public boolean threeDots() throws IOException, InterruptedException{
		
     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
     	   Thread.sleep(9000);
	
		     threedots.click();
	     	 Thread.sleep(2000);
             
             if(threedots.isEnabled()){
    	     	 
				return true;

            	 
             }
			   
		 else{
				log.error("User not navigates to invoice page"+driver.getTitle());
			 test.log(LogStatus.FAIL,  "User not navigates to invoice page");
				return false;


			}
	}
	
	public boolean addCustomer() throws IOException, InterruptedException{
		
     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
     	   Thread.sleep(9000);
     	  addcustomer.click();
		 String  pagetitle=titleverify.getText();

			if(pagetitle.contains("Add Customer Details")){
				log.info("navigated to customer page " +driver.getTitle());
				test.log(LogStatus.INFO, "navigated to customer page"+driver.getTitle());
				return true;

			}
			else{
				log.error("User not navigates to customer page"+driver.getTitle());
				   test.log(LogStatus.FAIL,  "User not navigates to customer page");

					return false;
 
			}
			
	
	}
	
public boolean expandSales() throws IOException, InterruptedException{
		
     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
     	   Thread.sleep(9000);
     	  expandsales.click();
		 String  pagetitle=menu.getText();

			if(!pagetitle.isEmpty()){
				log.info("expanded sucessfully " +pagetitle);
				test.log(LogStatus.INFO, "expanded sucessfully"+pagetitle);
				return true;

			}
			else{
				log.error(" not expanded sucessfully"+pagetitle);
				   test.log(LogStatus.FAIL,  "User not expanded sucessfully"+pagetitle);

					return false;
			}
		}
			
			public boolean customeClickr() throws IOException, InterruptedException{
				
		     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
		     	   Thread.sleep(9000);
		     	  customer.click();
		     	   Thread.sleep(6000);
				 String  pagetitle=customertitle.getText();

					if(pagetitle.contains("Customer Details")){
						log.info("navigated   to customer listing page " +pagetitle);
						test.log(LogStatus.PASS, "navigated   to customer listing page"+pagetitle);
						return true;

					}
					else{
						log.error(" not navigated   to customer listing page"+pagetitle);
						   test.log(LogStatus.FAIL,  "User not navigated   to customer listing page"+pagetitle);

							return false;
		 
					}
			
	
	}
	
			
					
					public boolean invoiceClick() throws IOException, InterruptedException{
						
				     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
				     	   Thread.sleep(9000);
				     	  invoice.click();
				     	   Thread.sleep(6000);
						 String  pagetitle=customertitle.getText();

							if(pagetitle.contains("Invoice Details")){
								log.info("navigated   to invoice listing page " +pagetitle);
								test.log(LogStatus.PASS, "navigated   to invoice listing page"+pagetitle);
								return true;

							}
							else{
								log.error(" not navigated   to invoice listing page"+pagetitle);
								   test.log(LogStatus.FAIL,  "User not navigated   to invoice listing page"+pagetitle);

									return false;
				 
							}
							
					}
					
							public boolean viewcustomerClick() throws IOException, InterruptedException{
								
						     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
						     	   Thread.sleep(9000);
						     	  viewcustomer.click();
						     	   Thread.sleep(6000);
								 String  pagetitle=viewcustomertitle.getText();

									if(pagetitle.contains("View Customer Details")){
										log.info("navigated   to view customer page " +pagetitle);
										test.log(LogStatus.PASS, "navigated   to view customer page"+pagetitle);
										return true;

									}
									else{
										log.error(" not navigated   to view customer pagee"+pagetitle);
										   test.log(LogStatus.FAIL,  "User not navigated   view customer pagee"+pagetitle);

											return false;
						 
									}
							
			
			}
				
                          public boolean createinvoiceClick() throws IOException, InterruptedException{
								
						     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
						     	   Thread.sleep(9000);
						             createinvoice.click(); 
						             if(driver.getCurrentUrl().contains("invoice")){
						    	     	 Thread.sleep(4000);
						            	 log.info("navigated to invoice page " +driver.getTitle());
						 				test.log(LogStatus.INFO, "navigated to invoice page"+driver.getTitle());
										return true;

						            	 
						             }
									   
								 else{
										log.error("User not navigates to invoice page"+driver.getTitle());
									 test.log(LogStatus.FAIL,  "User not navigates to invoice page");
										return false;


									}
							}
			
	
                          public boolean editCustomer() throws IOException, InterruptedException{
                      		
                           	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
                           	   Thread.sleep(9000);
                           	editcustomertitle.click();
                      		/* String  pagetitle=titleverify.getText();

                      			if(pagetitle.contains("Add Customer Details")){
                      				log.info("navigated to customer page " +driver.getTitle());
                      				test.log(LogStatus.INFO, "navigated to customer page"+driver.getTitle());
                      				return true;

                      			}
                      			else{
                      				log.error("User not navigates to customer page"+driver.getTitle());
                      				   test.log(LogStatus.FAIL,  "User not navigates to customer page");*/

                      					return false;
                       
                      			}
                          public boolean importcustomer() throws IOException, InterruptedException, AWTException{
                      		
                           	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("Dashboard");
                           	   Thread.sleep(9000);
                           	importcustomer.click();
                            Robot rb = new Robot();
                           	rb.setAutoDelay(2000);
                           	StringSelection str = new StringSelection("D:\\azhar\\azhar\\company\\IMG_20190814_061616.jpg");
                               Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
                           	rb.setAutoDelay(2000);

                                // press Contol+V for pasting
                               rb.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
                               rb.keyPress(java.awt.event.KeyEvent.VK_V);

                           	rb.setAutoDelay(2000);

                            
                               // release Contol+V for pasting
                             
                               rb.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
                               rb.keyRelease(java.awt.event.KeyEvent.VK_V);
                           	rb.setAutoDelay(2000);

                               // for pressing and releasing Enter
                               rb.keyPress(java.awt.event.KeyEvent.VK_ENTER);
                               rb.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
							return false;

                        }
                      	public boolean verifyLinks() throws IOException, InterruptedException{
							
					     	com.relevantcodes.extentreports.ExtentTest test = extent.startTest("verifylinks");
					     	   Thread.sleep(9000);
					     	 // System.out.println(driver.findElements(By.tagName("a")).stream().map(element->element.getAttribute("innerHTML")).collect(Collectors.toList()));
					     	  List<WebElement> links = driver.findElements(By.tagName("a"));

					          // This line will print the number of links and the count of links.
					          System.out.println("No of links are "+ links.size());  
					        
					          //checking the links fetched.
					          for(int i=0;i<links.size();i++)
					          {
					              WebElement E1= links.get(i);
					              String url= E1.getAttribute("innerHTML");
					              //String url= E1.getAttribute("href");

					          //	System.out.println(url);
					            //  verifyLinks(url);
					              //	System.out.println(url);
					              	if(E1.isEnabled()) {
					              		//System.out.println(" valid"+url);
					              		log.info("valid links " +url);
										test.log(LogStatus.PASS, "valid links "+url);
									     Reporter.log("valid links"+url);

					              	}
					              	else {
					              		//System.out.println("not valid"+url);
					              		log.error("not valid links  " +url);
										test.log(LogStatus.FAIL, "not valid links "+url);
									     Reporter.log("not valid links"+url);

					              	}
					          }
							return true;
					          
					        
					      }
					      
					      
					      public static void verifyLinks(String linkUrl)
					      {
					          try
					          {
					              URL url = new URL(linkUrl);

					              //Now we will be creating url connection and getting the response code
					              HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
					              httpURLConnect.setConnectTimeout(5000);
					              httpURLConnect.connect();
					              if(httpURLConnect.getResponseCode()>=400)
					              {
					              	System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
					              }    
					         
					              //Fetching and Printing the response code obtained
					              else{
					                  System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
					              }
					          }catch (Exception e) {
					        }
					     }
					  }
                     
				    

