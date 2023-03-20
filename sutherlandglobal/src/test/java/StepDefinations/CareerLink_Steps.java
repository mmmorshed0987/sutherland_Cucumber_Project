package StepDefinations;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CareerLink_Steps {
	public static WebDriver driver;
	
	public static String jobTittle;
	public static String jobLocation;
    public static String jobId;

    
    
	@Given("User Will Open Chrome Driver And Browse to URL= {string}")
	public void user_will_open_chrome_driver_and_browse_to_url(String url) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
	    driver.findElement(By.xpath("//button[contains(text(),'Accept All Cookies')]")).click();
		
	}

	@When("User Clicks on Career Link")
	public void user_clicks_on_career_link() {
	    driver.findElement(By.linkText("Careers")).click();
	    Set<String> winhandles=driver.getWindowHandles();
	    System.out.println(winhandles);
	    
	    Iterator<String>iterator=winhandles.iterator();
	    String parentwin=iterator.next();
	    String childwin=iterator.next();
	    
	    driver.switchTo().window(childwin);
	    	    
	}
	

	@When("EnterText {string} in the Search Box")
	public void enter_text_in_the_search_box(String enterText) throws InterruptedException {
	driver.findElement(By.xpath("/html/body/div[1]/section[2]/div/div/header/div[1]/div/div[4]/section/div/form/div[2]/div/div/div[1]/input")).sendKeys(enterText);
		
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"typehead-result-item-0\"]")).click();
		}
		

	@When("User Will Get Job Tittle,Job Location and Job Id of QA Developer")
	public void user_will_get_job_tittle_job_location_and_job_id_of_qa_developer() {
	    String jobTittle=driver.findElement(By.xpath("//h1[@class=\"job-title\"]")).getText();
	    String jobLocation=driver.findElement(By.xpath("//span[@class=\"au-target job-location\"]")).getText();
	    String jobId=driver.findElement(By.xpath("//span[@class=\"au-target jobId\"]")).getText();
	    
	    System.out.println("Job Tittle is: "+jobTittle);
	    System.out.println("Job Location is: "+jobLocation);
	    System.out.println("Job Id is: "+jobId); 
	}

	@Then("User Will Validate Job Tittle={string},Job Location={string} and Job Id={string}")
	public void user_will_validate_job_tittle_job_location_and_job_id(String expectedJobTitle, String expectedLocation, String expectedJobId) {
		if(jobTittle.contains(expectedJobTitle)) {
			System.out.println("Job Title validation passed");
		}
		else {
			System.out.println("Job Title validation failed");
		}
		
		if(jobLocation.contains(expectedLocation)) {
			System.out.println("Job Title validation passed");
		}
		else {
			System.out.println("Job Locations validation failed");
		}
		
		if(jobId.contains(expectedJobId)) {
			System.out.println("Job ID validation passed");
		}
		else {
			System.out.println("Job ID validation failed");
		}
		
		
		
		
	}
		

	@Then("User Will Validate Required Knowledge={string},Required Years={string},Required Skills={string}")
	public void user_will_validate_required_knowledge_required_years_required_skills(String expectedKnow, String expectedYears, String expectedSkills) {
	List<WebElement> ttlList=driver.findElements(By.xpath("//div[@class=\"jd-info au-target\"]/child::ul/li/p[1]"));
	    
	for(WebElement eList:ttlList) {
	String req=eList.getText();
	
	if(req.contains(expectedKnow)) {
		System.out.println("Expected Knowledge passed");
	}
	else {
		System.out.println("expected Knowleged test failed");
	}
	
	if(req.contains(expectedYears)) {
		System.out.println("Expected Years test passed");
	}
	else {
		System.out.println("expected Years test failed");
	}
	
	if(req.contains(expectedSkills)) {
		System.out.println("Expected Expected Skills Test passed");
	}
	else {
		System.out.println("expected Expected Skills Test failed");
	}
	 
	 	 
	 
	}
		
		
			
		
	}


	@When("User Clicks on Apply Now Button")
	public void user_clicks_on_apply_now_button() throws InterruptedException {
	
	
	driver.findElement(By.xpath("//div[@class='Sub-Actions']/child::a")).click();
	 					
		
	}

	@Then("User Will Return Job Search and Click")
	public void user_will_return_job_search_and_click() {
	  
	}
}
