package PapaJh_Test_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utility.Helper;

public class Checkout {
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;
	
	private By carrito;
	private By pagar;

	public Checkout(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;
		
		
		carrito= By.xpath("//b[contains(.,'Cart')]");
		pagar= By.xpath("(//span[contains(.,'Proceed to checkout')])[2]");
		
		
	}
	public void seleccion(String subDir) {

		Helper.waitSeconds(3);
		driver.findElement(carrito).click();
		Helper.waitSeconds(3);

		Helper.addEvidence(TAKE_SS, driver, test, "Evidencia paso 4 : ", subDir, "Chekout_01");

		driver.findElement(pagar).click();
		Helper.waitSeconds(3);
		
		Helper.addEvidence(TAKE_SS, driver, test, "Evidencia paso 5 : ", subDir, "Chekout_03");
		Helper.waitSeconds(3);

	}

}
