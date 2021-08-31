package PapaJh_Test_POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PapaJh_Test_POM.LoginPage;
import PapaJh_Test_POM.Productos;
import PapaJh_Test_POM.Productos;

@SuppressWarnings("unused")
public class TestAutomation {
	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private static String SUBDIR = "Ambiente_Base_Ta\\";
	private static Boolean TAKE_SS = true;

	@BeforeSuite
	public void configExtentReports() {
		// ExtentReports config
		this.extent = new ExtentReports("ExtentReports/AMBIENTE_BASE_TA.html", true);
	}

	@BeforeMethod
	public void configSelenium() {
		// Selenium config
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("Empresa", "Tecnova");
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
	}

	@Test (priority = 1)
	public void pruebaLoginCorrecto() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Validar Login Correcto", "Prueba del Login Ingresado Correctamente");
		test.log(LogStatus.INFO, "Prueba Login Correcto.-");
		LoginPage login = new LoginPage(driver, test, TAKE_SS);
		login.loginUser("prueba@qmail.com", subDir);
		login.Formulario("Prueba", "Prueba", "123456", "Prueba", "Prueba", "Prueba", "Prueba", "Prueba", "12345678", "123456789", "123456789", "Prueba", subDir);
	}

	@Test (priority = 2)
	public void pruebaCargaProductos() {
		String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
		test = extent.startTest("Validar Carga de Productos", "Prueba de Carga de Productos es correcta");
		test.log(LogStatus.INFO, "Carga de Productos.-");
		Productos prod = new Productos(driver, test, TAKE_SS);
       prod.seleccion(subDir);
	
	}

@Test (priority = 3)
public void pruebaChekout() {
	String subDir = SUBDIR + Thread.currentThread().getStackTrace()[1].getMethodName();
	test = extent.startTest("Validar Compra exitosa", "Prueba de Compra exitosa es correcta");
	test.log(LogStatus.INFO, "Compra exitosa.-");
	Checkout comp = new Checkout(driver, test, TAKE_SS);
     comp.Compras(subDir);

}

	

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test failed.- <br>" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped.- <br>" + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed.-");
		}
		driver.close();
		extent.endTest(test);
	}

	@AfterSuite
	public void closeExtentReports() {
		// writing everything to document.
		extent.flush();
	}
}
