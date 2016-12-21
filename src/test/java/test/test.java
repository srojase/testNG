package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ContactoPage;
import util.CommUtil;
import util.DriverNavegador;

public class test {
	
	@BeforeClass
	public static void setup() throws IOException{
		DriverNavegador.setupDriver();	
        CommUtil.implicitWait(60);
        CommUtil.launchBrowser(DriverNavegador.WEB_SERVER);     
	}
	
	@Test(description="Valida los campos del formulario",groups = {"prueba"})
	public void a_validaCampos() throws InterruptedException{
		ContactoPage contacto = new ContactoPage(DriverNavegador.driver);
		String resultado = contacto.validaCampos();
		if (!resultado.equals("Ok"))
			Assert.fail(resultado);
		else
			Assert.assertTrue(false);
	}
	
	@Test(groups = {"prueba"},dependsOnMethods={"a_validaCampos"})
	public void b_addFiltro() throws InterruptedException{
		ContactoPage contacto = new ContactoPage(DriverNavegador.driver);
		try {
			contacto.AddFilter("Nombre", "Apellido", "Correo");
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
