package PapaJh_Test_POM;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import utility.Helper;

public class Productos {
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;
	
	private By Agregar1;
	private By Agregar2;
	private By carrito;

	
	public Productos(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;
		
		Agregar1= By.xpath("(//span[contains(.,'Quick view')])[1]");
		Agregar2= By.xpath("(//span[contains(.,'Add to cart')])[2]");
		carrito= By.xpath("//span[contains(.,'Proceed to checkout')]");

	}
		public void seleccion(String subDir) {
			
			Helper.waitSeconds(3);

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,750)", "");
			Helper.waitSeconds(3);
			driver.findElement(Agregar1).click();		
			Helper.waitSeconds(3);
			
			driver.findElement(By.xpath("(//span[contains(.,'Continue shopping')])[2]")).click();
			driver.findElement(Agregar2).click();		
			Helper.waitSeconds(3);
			
			driver.findElement(carrito).click();	
	       
			Helper.waitSeconds(3);
			
			JavascriptExecutor jjse = (JavascriptExecutor)driver;
			jjse.executeScript("window.scrollBy(0,150)", "");
			
			
			driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]	")).click();
				
		    Helper.addEvidence(TAKE_SS, driver, test, "Evidencia paso 2 : ", subDir, "Seleccionar");

		
	}
}
