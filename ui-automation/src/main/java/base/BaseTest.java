package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import util.ExtentHTMLReporter;
import util.Constants;


public class BaseTest {

	public static WebDriver driver;
	public ExtentHTMLReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static AndroidDriver driver1;

	 DesiredCapabilities capability=new DesiredCapabilities();

	
	static Logger log = Logger.getLogger(BaseTest.class.getName());


	@BeforeTest
	public void beforeTestMethod() {

		String path=System.getProperty("user.dir")+ File.separator + "reports" + File.separator +"AutomationReport.html";
	   ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Automation Test Results");
		
		
		extent = new ExtentReports(path);
//		extent.attachReporter(reporter);;
		extent.addSystemInfo("Azhar","SDET");
//		ExtentTest Test=extent.createTest("My Test");
//		Test.pass("pass");
//		Test.fail("fail");
//		Test.info("info");
		
		
		
		
		
	}
	
	
    @BeforeMethod
     @Parameters(value= {"browserName"})
     
	public void beforeMethodMethod(@Optional String browserName, Method testMethod) throws IOException {
    	 ExtentTest logger = extent.startTest("Dashboard");


    		/**
    		 * Create new LandingPage object with the given driver.<br>
    		 * <br>
    		 * Driver is passed through to the backing object class.
    		 * 
    		 * @param driver active driver to use for this page
    		 */

		//logger=extent.createTest(testMethod.getName());
		setupDriver1(driver);
		//setupDriver(browserName);

		driver.manage().window().maximize();
		log.info("window maximise");
		//Test.info("window maximise");
		  logger.log(LogStatus.INFO, "window maximise");

		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}  
	
	
	
	
	


	@AfterMethod
	public void afterMethodMethod(ITestResult result) {
    	 //ExtentTest logger = extent.startTest("Report");

		if(result.getStatus()==ITestResult.SUCCESS) {
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case:" +methodName + "Passed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		    //logger.log(LogStatus.PASS, "m");
		   // logger.log(LogStatus.PASS, "pass");

			
		}else if(result.getStatus()==ITestResult.FAILURE) {
			String methodName=result.getMethod().getMethodName();
			String logText="Test Case:" +methodName + "Failed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		    //logger.log(LogStatus.FAIL,  "m");
			  //logger.log(LogStatus.FAIL, "fail");

			
			String fileName=System.getProperty("user.dir")+ File.separator + "screenshots" + File.separator + result.getMethod().getMethodName();
			File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		    try {
				FileUtils.copyFile(SrcFile, new File(fileName+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			
		}	
		
		}	
		driver.quit();
		
	}
	
	
	
	
	@AfterTest
	public void afterTestMethod() {
		extent.flush();
			
	}
	
   public void setupDriver(@Optional String browserName) {

		//System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator + "drivers" + File.separator +"chromedriver.exe");
		driver=new ChromeDriver();
		//ChromeOptions options = new ChromeOptions();
       
		//options.addArguments("--remote-allow-origins=*");

		//ChromeDriver driver = new ChromeDriver(options);


		
	}
	public WebDriver setupDriver1(WebDriver driver2) throws IOException{
		 com.relevantcodes.extentreports.ExtentTest test = extent.startTest("browser");

			//FileReader reader=new FileReader("D:\\ecilipsestaples\\Ecilipse\\ui-test-robustautomation\\src\\main\\java\\Base\\global.properties");  
			  FileReader reader=new FileReader(System.getProperty("user.dir")+ File.separator + "src/main/java/Base" + File.separator +"global.properties"); 

			    Properties p=new Properties();  
			    p.load(reader);  
		   String browserame=p.getProperty("browser");
			// Thread.sleep(3000);
				if(browserame.equalsIgnoreCase("chrome")){
				//	System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");

					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ File.separator + "drivers" + File.separator +"chromedriver.exe");
					driver=new ChromeDriver();
					//DesiredCapabilities cap=DesiredCapabilities.chrome();
					//URL u=new URL("http://localhost:4444/wd/hub");
					//RemoteWebDriver dir=new RemoteWebDriver(u,cap);
					  log.info(" chrome open " );
				 	  test.log(LogStatus.INFO, " chrome open " );				
							        }
				else if(browserame.equalsIgnoreCase("safari")) {
					//WebDriver driver = new SafariDriver();
					driver=new SafariDriver();
					  log.info(" safari open " );
				 	  test.log(LogStatus.INFO, " safari open " );				
					 }
				else if(browserame.equalsIgnoreCase("firefox")) {
					//WebDriver driver = new SafariDriver();
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ File.separator + "drivers" + File.separator +"geckodriver.exe");

					  driver = new FirefoxDriver();
					  log.info(" firefox open " );
				 	  test.log(LogStatus.INFO, " firefox open " );				
					 }
				else if(browserame.equalsIgnoreCase("mobile")) {
					//WebDriver driver = new SafariDriver();
						//AndroidDriver<AndroidElement>  driver=capabilities();
					 DesiredCapabilities capability=new DesiredCapabilities();

					  //  capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi Note 10T 5G");
					    capability.setCapability(MobileCapabilityType.DEVICE_NAME, "4lmzpf4pscovxccy");
					    capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
					    capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
					 capability.setCapability("automatorName", "UiAutomator2");
					 capability.setCapability("uiautomator2ServerInstallTimeout" , "50000");
					capability.setCapability("noSign", "true");
					capability.setCapability("noReset", "true");
					 capability.setCapability("appWaitForLaunch", "false");
					 capability.setCapability("adbExecTimeout", 50000);
					 //capability.setCapability("adbExecTimeout", 50000);
				
					 capability.setCapability("browserName", "Chrome");
					capability.setCapability("chromedriverExecutable","D:\\driver\\chromedriver.exe");
					// capability.setCapability("browserVersion", "90.0.4844.88");
					// capability.setCapability("appPackage", "com.eservicepro.tech.e_service_pro_technician");


					//capability.setCapability("appActivity", "com.eservicepro.tech.e_service_pro_technician.MainActivity");
						

					//  capability.setCapability("appPackage", "com.hss.android.viaetruck");


					//	capability.setCapability("appActivity", "com.hss.android.viaetruck.activity.SplashScreen");
						
					//    driver=new ChromeDriver();

						AndroidDriver driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
						
						//URL url = new URL("http://127.0.1.1:4723/wd/hub");
					   // System.out.println("Hardcoded URL: " + url);
					   // AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, capability);
					     //  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);			
						//driver=new AndroidDriver(capability);		
						//driver=new ChromeDriver();
						this.driver=driver;
						log.info(" mobile open " );
					 	  test.log(LogStatus.INFO, " mobile open " );			
				}
				
			
                return driver;
			
		}

	



	public void runScript() throws IOException {
		// TODO Auto-generated method stub
		
	}
	protected void executeTest() {
		// TODO Auto-generated method stub
		
	}
	
}
