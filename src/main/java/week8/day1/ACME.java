package week8.day1;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ACME {
@Test
	public void runACME () throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/Chromedriver/chromedriver.exe");// in order to establish the connection between the browser and the software
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");// window to be opened
		driver.manage().window().maximize();//to open window and maximize the screen
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementByXPath("//button[@id='buttonLogin']").click();
		Actions builder=new Actions(driver);
		Thread.sleep(3000);
		WebElement Invoices = driver.findElementByXPath("//button[text()[normalize-space()='Invoices']]");
		builder.moveToElement(Invoices).perform();
		driver.findElementByXPath("//a[@href='/invoices/search']").click();
		driver.findElementById("vendorTaxID").sendKeys("DE763212");
		driver.findElementByXPath("//button[@class='btn btn-primary']").click();
		WebElement table = driver.findElementByClassName("table");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int InvoiceSize = rows.size();
		//System.out.println(InvoiceSize);
		//Map<String, Integer> InvoiceDetails = new HashMap<String,Integer>();
		for(int i=2;i<InvoiceSize;i++) {
		//String InvoiceItem = driver.findElementByXPath("(//td[text()='IT Support'])["+i+"]").getText();
		String InvoiceItem = driver.findElementByXPath("//table[@class='table']//tr["+i+"]/td[3]").getText();
		if(InvoiceItem.equals("IT Support")) {
			String invoiceNumber = driver.findElementByXPath("//table[@class='table']/tbody[1]/tr["+i+"]/td[1]").getText();
			System.out.println(invoiceNumber);
		}
		
			
		}
	/*	if((Country.equals("France"))&&(VendorName.equals("Blue Lagoon"))) {
			System.out.println("Text match");
		}else{
			System.out.println("Text Not match");
		}*/
		
		driver.findElementByXPath("//a[@href='/account/logout/']").click();
		driver.close();
	}

}
