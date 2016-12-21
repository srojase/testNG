package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactoPage {
	WebDriver driver;
	
	public ContactoPage(WebDriver driver){
		this.driver = driver;
		//Crea todos los elementos 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = ".//*[@id='wpcf7-f63-p10-o1']/form/div[2]/div[1]/div[1]/div[2]/span/input")
	private WebElement txtNombre;
	

	@FindBy(how = How.XPATH, using = ".//*[@id='wpcf7-f63-p10-o1']/form/div[2]/div[1]/div[2]/div[2]/span/input")
	private WebElement txtApellido;
	

	@FindBy(how = How.XPATH, using = ".//*[@id='wpcf7-f63-p10-o1']/form/div[2]/div[1]/div[3]/div[2]/span/input")
	private WebElement txtCorreo;

	public WebElement getTxtNombre() {
		return txtNombre;
	}


	public WebElement getTxtApellido() {
		return txtApellido;
	}


	public WebElement getTxtCorreo() {
		return txtCorreo;
	}
	
	public String validaCampos(){
		String resultado = "Ok";
		if(!txtApellido.isDisplayed())
			resultado = "No se despliega el txt Apellido";
		if(!txtCorreo.isDisplayed()){
			if(!resultado.equals("Ok"))
				resultado = resultado + "No se despliega el txt Correo";
			else
				resultado = "No se despliega el txt Correo";
		}
		if(!txtNombre.isDisplayed()){
			if(!resultado.equals("Ok"))
				resultado = resultado + "No se despliega el txt Nombre";
			else
				resultado = "No se despliega el txt Nombre";
		}
		return resultado;
	}
	
	public void AddFilter(String nombre,String apellido, String correo){
		txtNombre.sendKeys(nombre);
		txtApellido.sendKeys(apellido);
		txtCorreo.sendKeys(correo);
	}
	
	
}
