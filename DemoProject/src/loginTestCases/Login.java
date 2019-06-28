package loginTestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	
	String[][] data= null;
	WebDriver driver;
	
	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException {
		//return the test data
		data= getExcelData();
		return data;
			
	}
	public String[][] getExcelData() throws BiffException, IOException
	{
		FileInputStream excel= new FileInputStream("C:\\Users\\komal\\Desktop\\loginData.xls");
        Workbook workbook= Workbook.getWorkbook(excel);
        
        Sheet sheet= workbook.getSheet(0);
        
        int rowCount=sheet.getRows();
        int columnCount=sheet.getColumns();
        String testData[][]=new String[rowCount-1][columnCount];
	       
        for(int i=1;i<rowCount;i++)
        {
        	for(int j=0;j<columnCount;j++)
        	{
        		testData[i-1][j]=sheet.getCell(j,i).getContents();
        		
        	}
        }
        return testData;
	}
	
	@BeforeTest 
	public void beforeTest() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\komal\\Downloads\\chromedriver_win32\\chromedriver.exe");
  		
		 driver = new ChromeDriver();
		
	}
	
	@Test(dataProvider = "loginData")
	
	public void loginWithBothIncorrect(String username,String password) {
		
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		WebElement usernameBox= driver.findElement(By.id("txtUsername"));
		usernameBox.sendKeys(username);
		
		WebElement passwordBox= driver.findElement(By.id("txtPassword"));
		passwordBox.sendKeys(password);
		
		WebElement login= driver.findElement(By.id("btnLogin"));
		login.click();
		
		
	}
	
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}

}
