package PapaJh_Test_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import utility.Helper;

public class LoginPage {
	private WebDriver driver;
	private ExtentTest test;
	private Boolean TAKE_SS;
	private By Registro;
	private By usuarioInput;
	private By CrearCuenta;

	private By Title;
	private By FirstName;
	private By LastName;
	private By Pass;

	private By AdressName;
	private By AdressLastName;
	private By Company;
	private By Adress;
	private By City;
	private By PostalCode;
	private By HomePhone;
	private By MobilePhone;
	private By Reference;

	private By Registrar;

	public LoginPage(WebDriver driver, ExtentTest test, Boolean TAKE_SS) {
		this.driver = driver;
		this.test = test;
		this.TAKE_SS = TAKE_SS;

		Registro = By.xpath("//a[@class='login'][contains(.,'Sign in')]");
		usuarioInput = By.xpath("//*[@id=\"email_create\"]");
		CrearCuenta = By.xpath("//*[@id=\"SubmitCreate\"]/span");

		Title = By.xpath("//*[@id=\"uniform-id_gender1\"]");
		FirstName = By.xpath("//*[@id=\"customer_firstname\"]");
		LastName = By.xpath("//*[@id=\"customer_lastname\"]");
		Pass = By.xpath("//*[@id=\"passwd\"]");

		AdressName = By.xpath("//*[@id=\"firstname\"]");
		AdressLastName = By.xpath("//*[@id=\"lastname\"]");
		Company = By.xpath("//*[@id=\"company\"]");
		Adress = By.xpath("//*[@id=\"address1\"]");
		City = By.xpath("//*[@id=\"city\"]");
		PostalCode = By.xpath("//*[@id=\"postcode\"]");
		HomePhone = By.xpath("//*[@id=\"phone\"]");
		MobilePhone = By.xpath("//*[@id=\"phone_mobile\"]");
		Reference = By.xpath("//*[@id=\"alias\"]");

		Registrar = By.xpath("//*[@id=\"submitAccount\"]/span");

	}

	public void loginUser(String user, String subDir) {

		driver.findElement(Registro).click();
		Helper.waitSeconds(3);

		driver.findElement(usuarioInput).sendKeys(user);
		Helper.waitSeconds(5);

		Helper.addEvidence(TAKE_SS, driver, test, "Evidencia paso 1 : ", subDir, "login_01");

		driver.findElement(CrearCuenta).click();
		Helper.waitSeconds(3);

		Helper.addEvidence(TAKE_SS, driver, test, "Evidencia paso 1 : ", subDir, "login_01");

	}

	public void Formulario(String Nombre, String Apellido, String pass, String Direccion, String Direccion2,
			String companys, String direccion3, String ciudad, String postal, String phoneCasa, String PhoneMovil,
			String Referencia, String subDir) {

		Helper.waitSeconds(3);
		driver.findElement(Title).click();
		Helper.waitSeconds(3);

		driver.findElement(FirstName).sendKeys(Nombre);
		Helper.waitSeconds(2);

		driver.findElement(LastName).sendKeys(Apellido);
		Helper.waitSeconds(2);

		driver.findElement(Pass).sendKeys(pass);
		Helper.waitSeconds(2);

		driver.findElement(Title).click();

		driver.findElement(By.id("days")).click();
		driver.findElement(By.xpath("//*[@id=\"days\"]/option[5]")).click();
		Helper.waitSeconds(1);
		
		WebElement comboboxElementdia = driver.findElement(By.name("days"));
		Select combobox1 = new Select(comboboxElementdia);
		combobox1.selectByVisibleText("2");

		WebElement comboboxElementMes = driver.findElement(By.name("months"));
		Select combobox2 = new Select(comboboxElementMes);
		combobox2.selectByVisibleText("January");

		WebElement comboboxElementyear = driver.findElement(By.name("years"));
		Select combobox3 = new Select(comboboxElementyear);
		combobox3.selectByVisibleText("2020");

		Helper.waitSeconds(2);

		driver.findElement(AdressName).sendKeys(Direccion);
		Helper.waitSeconds(2);

		driver.findElement(AdressLastName).sendKeys(Direccion2);
		Helper.waitSeconds(2);

		driver.findElement(Company).sendKeys(companys);
		Helper.waitSeconds(2);

		driver.findElement(Adress).sendKeys(direccion3);
		Helper.waitSeconds(2);

		driver.findElement(City).sendKeys(ciudad);
		Helper.waitSeconds(2);

		WebElement comboboxElementestado = driver.findElement(By.id("id_state"));
		Select combobox4 = new Select(comboboxElementestado);
		combobox4.selectByVisibleText("Delaware");

		driver.findElement(PostalCode).sendKeys(postal);
		Helper.waitSeconds(2);

		driver.findElement(HomePhone).sendKeys(phoneCasa);
		Helper.waitSeconds(2);

		driver.findElement(MobilePhone).sendKeys(PhoneMovil);
		Helper.waitSeconds(2);

		driver.findElement(Reference).sendKeys(Referencia);
		Helper.waitSeconds(2);
		
		Helper.addEvidence(TAKE_SS, driver, test, "Evidencia paso 1 : ", subDir, "login_01");

		driver.findElement(Registrar).click();

		Helper.addEvidence(TAKE_SS, driver, test, "Evidencia paso 2 : ", subDir, "login_02");

	}

}
