package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AtributosElement {

	/**
	 * @Metodo getColorCss
	 * @Descripcion Metodo que permite validar si el color de un objeto x coincide con el ingresado en el parametro (color)
	 * @Parametro WebElement objeto, LogResult logResult, String color, String nombreObjeto
	 * @Retorno boolean
	 * @Version 1
	 * @Fecha 27/04/2016
	 * @Autor Yhoel Candia
	 * @
	 */
	
	//FORMATO QUE DEBEN INGRESAR EL COLOR  ejemplo : "rgba(51, 122, 183, 1)"
	public boolean getColorCss(WebDriver driver, WebElement objeto, String color, String nombreObjeto)  {
		String colorObtenido = objeto.getCssValue("color");
		
		   System.out.println("color: "+objeto.getCssValue("color"));
		    System.out.println("fuente: "+objeto.getCssValue("font-family"));
		    System.out.println("size: "+objeto.getCssValue("font-size"));
		    System.out.println("tamano: "+objeto.getCssValue("font-weight"));
		    
		String[] numbers = colorObtenido.replace("rgba(", "").replace(")", "").split(",");
		
		try{	
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[1].trim());
			int b = Integer.parseInt(numbers[2].trim());
			System.out.println("r: " + r + "g: " + g + "b: " + b);
	
			colorObtenido = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
					
			System.out.println("color obtenido: "+colorObtenido);
				
			if (colorObtenido.equals(color)) {	
				System.out.println("VP color del boton '"+nombreObjeto+"' aprobado");
				System.out.println("VP Color del boton '"+nombreObjeto+"' "+"El color del boton '"+nombreObjeto+"' fue detectado correctamente");
			}
			else{		
				System.out.println("VP color del boton '"+nombreObjeto+"' rechazado");
				System.out.println("VP Color del boton '"+nombreObjeto+"' "+"El color del boton '"+nombreObjeto+"' no fue detectado correctamente");
				return false;
			}
		}  	        
		catch(Exception ex){
			System.out.println("VP color del boton '"+nombreObjeto+"' alerta");
			System.out.println("VP Color del boton '"+nombreObjeto+"' "+ex.toString()); 
			return false;
		}
	    return true;
	}
	
	/**
	 * @Metodo getTipoFuente
	 * @Descripcion Metodo que permite validar si el tipo de fuente de un objeto x coincide con el ingresado en el parametro (tipoFuenteIngreso) normal = 400 y negrita = 700
	 * @Parametro WebElement objeto, LogResult logResult, String tipoFuenteIngreso, String nombreTexto
	 * @Retorno boolean
	 * @Version 1
	 * @Fecha 27/04/2016
	 * @Autor Yhoel Candia
	 * @
	 */
	//Se debe ingresar 400 para font-weight: normal , y 700 para font- weight: negrita en la variable tipoFuenteIngreso
	public boolean getTipoFuente(WebDriver driver, WebElement objeto, String tipoFuenteIngreso, String nombreTexto) {
	    String tipoFuenteObtenido = objeto.getCssValue("font-weight");	    
		if(tipoFuenteIngreso.equals("400")){
		    try{			
				if (tipoFuenteObtenido.equals("400")) {	
					System.out.println("VP fuente normal de '"+nombreTexto+"' aprobado");
					System.out.println("VP fuente normal de '"+nombreTexto+"'"+"La fuente normal de '"+nombreTexto+"' fue detectada correctamente");
				}
				else{		
					System.out.println("VP fuente normal de '"+nombreTexto+"' rechazado");
					System.out.println("VP fuente normal de '"+nombreTexto+"' "+"La fuente normal de '"+nombreTexto+"' no fue detectada correctamente");
					return false;
				}
			}  	        
			catch(Exception ex){
				System.out.println("VP fuente normal de '"+nombreTexto+"' alerta");
				System.out.println("VP fuente normal de '"+nombreTexto+"'"+ex.toString()); 
				return false;
			}
		}if(tipoFuenteIngreso.equals("700")){
			 try{			
					if (tipoFuenteObtenido.equals("700")) {	
						System.out.println("VP fuente negrita de '"+nombreTexto+"' aprobado");
						System.out.println("VP fuente negrita de '"+nombreTexto+"' "+"La fuente negrita de '"+nombreTexto+"' fue detectada correctamente");
					}
					else{		
						System.out.println("VP fuente negrita de '"+nombreTexto+"' rechazado");
						System.out.println("VP fuente negrita de '"+nombreTexto+"' "+"La fuente negrita de '"+nombreTexto+"' no fue detectada correctamente");
						return false;
					}
				}  	        
				catch(Exception ex){
					System.out.println("VP fuente negrita de '"+nombreTexto+"' alerta");
					System.out.println("VP fuente negrita de '"+nombreTexto+"'"+ex.toString()); 
					return false;
				}
		}
	    return true;
	}
	/**
	 * @Metodo getTamanioLetra
	 * @Descripcion Metodo que permite validar si el tamaño de fuente de un objeto x coincide con el ingresado en el parametro (tamanoLetraIngresado)
	 * @Parametro WebElement objeto, LogResult logResult, String tamanoLetraIngresado, String nombreTexto
	 * @Retorno boolean
	 * @Version 1
	 * @Fecha 27/04/2016
	 * @Autor Yhoel Candia
	 * @
	 */
	//FORMATO QUE DEBEN INGRESAR EL TAMAñO  ejemplo : "15px"
	public boolean getTamanioLetra(WebElement objeto, String tamanoLetraIngresado, String nombreTexto) {
		String tamanoLetraObtenido = objeto.getCssValue("font-size");
		System.out.println("tamanio letra obtenido: "+tamanoLetraObtenido);
		try{			
			if (tamanoLetraObtenido.equals(tamanoLetraIngresado)) {	
				System.out.println("VP tamanio letra de '"+nombreTexto+"' aprobado");
				System.out.println("VP tamanio letra de '"+nombreTexto+"'"+"El tamanio de letra de '"+nombreTexto+"' fue detectado correctamente");
			}
			else{		
				System.out.println("VP tamanio letra de '"+nombreTexto+"' rechazado");
				System.out.println("VP tamanio letra de '"+nombreTexto+"'"+"El tamanio de letra de '"+nombreTexto+"' no fue detectado correctamente");
				return false;
			}
		}  	        
		catch(Exception ex){
			System.out.println("VP tamanio letra de '"+nombreTexto+"' alerta");
			System.out.println("VP tamanio letra de '"+nombreTexto+"'"+ex.toString()); 
			return false;
		}
	    return true;
	}
	
	/** 
	 * Function: verifyAtrPlaceHolder
	 * Description: comprueba a traves del atributo place Holder que el nombre y/o descripción de un cuadro de texto este correcto
	 * @param objeto (WebElement) elemento a verificar
	 * @param textObject (String) texto que se espera que contenga el elemento en su atributo PlaceHolder
	 * @param cantIntentos (int) nro de intentos que se realizara para buscar el objeto en la pantalla, ya que a veces el objeto no es encontrado debido a que la pagina aun no termina de cargar
	 * @param sleepTimeMs (long) tiempo de espera entre los intentos de busqueda del objecto
	 * @param logResult(LogResult) variable para crear log asociado a la prueba
	 * @return boolean
	 * @author Daniela Trincado
	 * Date: 17-05-2016
	 **/
	public boolean verifyAtrPlaceHolder(WebDriver driver, WebElement objeto, String textObject, String titleVp, String detalleVp, int cantIntentos,long sleepTimeMs) {
		//Obtiene el valor del placeholder del objecto
		String placeHolderObtenido = objeto.getAttribute("placeholder");
		//Variable que indica si el elemento a validar de a pagina se encuentra presente.
		boolean objectPresent = false;
		
		try{
			//Espera que se despligue el objeto, realizando pausas en la ejecuci�n y luego de la pausa retoma la busqueda
			objectPresent = Function.waitforExistsObject(driver, objeto, cantIntentos, sleepTimeMs);

			if (placeHolderObtenido.contains(textObject) && objectPresent){		
				Function.scrollTo(driver, objeto);
				MarcoObjeto en=new MarcoObjeto();
				en.enmarcarObjeto(driver, objeto);
				System.out.println("VP "+titleVp+ detalleVp+"' fue detectado correctamente");
			    en.desenmarcarObjeto(driver, objeto);
			}else{
				System.out.println("VP "+titleVp+" "+ detalleVp+"' no fue detectado correctamente."
						+ "Resultado Esperado: "+textObject
						+ "Resultado Obtenido: "+ placeHolderObtenido);
				return false;
			}
		}catch(Exception ex){
			System.out.println(titleVp+" "+ex.toString()); 
			return false;
		}
	    return true;
	}
	
	/** 
	 * Function: verifyAtrPlaceHolder
	 * Description: comprueba a traves del atributo place Holder que el nombre y/o descripción de un cuadro de texto este correcto
	 * @param objeto (WebElement) elemento a verificar
	 * @param textObject (String) texto que se espera que contenga el elemento en su atributo PlaceHolder
	 * @param cantIntentos (int) nro de intentos que se realizara para buscar el objeto en la pantalla, ya que a veces el objeto no es encontrado debido a que la pagina aun no termina de cargar
	 * @param sleepTimeMs (long) tiempo de espera entre los intentos de busqueda del objecto
	 * @return boolean
	 * @author Daniela Trincado
	 * Date: 17-05-2016
	 **/
	public static boolean verifyAttributeElement (WebDriver driver, WebElement objeto, String attribute, String textObject, String titleVp, String detalleVp, int cantIntentos,long sleepTimeMs) {
		
		//Variable que indica si el elemento a validar de a pagina se encuentra presente.
		boolean objectPresent = false;
		boolean existe = false;
		
		try{
			//Espera que se despligue el objeto, realizando pausas en la ejecuci�n y luego de la pausa retoma la busqueda
			objectPresent = Function.waitforExistsObject(driver, objeto, cantIntentos, sleepTimeMs);
			
			if(objectPresent)
			{
				//Obtiene el valor del placeholder del objecto
				String sAttribute = objeto.getAttribute(attribute); 
				if (sAttribute.toString().contains(textObject)){		
					Function.scrollTo(driver, objeto);				
					existe = true;
				}else{
					return false;
				}
			}
		}catch(Exception ex){
			return true;
		}
	    return existe;
	}
	
	/**
	 * @Metodo getContentCss
	 * @Descripcion Metodo que permite validar si el color de un objeto x coincide con el ingresado en el parametro (color)
	 * @Parametro WebElement objeto, LogResult logResult, String color, String nombreObjeto
	 * @Retorno boolean
	 * @Version 1
	 * @Fecha 27/04/2016
	 * @Autor Yhoel Candia
	 * @
	 */
	
	//FORMATO QUE DEBEN INGRESAR EL COLOR  ejemplo : "rgba(51, 122, 183, 1)"
	public boolean getContentCss(WebDriver driver, WebElement objeto, String color, String nombreObjeto)  {
		String contentObtenido = objeto.getCssValue("content");
		System.out.println("color obtenido: "+contentObtenido);
//		
//		try{	
//			int r = Integer.parseInt(numbers[0].trim());
//			int g = Integer.parseInt(numbers[1].trim());
//			int b = Integer.parseInt(numbers[2].trim());
//			System.out.println("r: " + r + "g: " + g + "b: " + b);
//	
//			colorObtenido = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
//					
//			System.out.println("color obtenido: "+colorObtenido);
//				
//			if (colorObtenido.equals(color)) {	
//				System.out.println("VP color del boton '"+nombreObjeto+"' aprobado");
//			    logResult.passLog("VP Color del boton '"+nombreObjeto+"'","El color del boton '"+nombreObjeto+"' fue detectado correctamente", Driver.driver);
//			}
//			else{		
//				System.out.println("VP color del boton '"+nombreObjeto+"' rechazado");
//				logResult.errorLog("VP Color del boton '"+nombreObjeto+"'","El color del boton '"+nombreObjeto+"' no fue detectado correctamente", Driver.driver);
//				return false;
//			}
//		}  	        
//		catch(Exception ex){
//			System.out.println("VP color del boton '"+nombreObjeto+"' alerta");
//			logResult.warningLog("VP Color del boton '"+nombreObjeto+"'",ex.toString(),Driver.driver); 
//			return false;
//		}
	    return true;
	}


	
}

