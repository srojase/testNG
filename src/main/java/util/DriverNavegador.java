package util;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class DriverNavegador {
	
	static ArchivoProperties propiedades = new ArchivoProperties();
	static Properties properties = propiedades.getProperties("conexion.properties");
	
	protected static final String CUR_DIR = System.getProperty("user.dir");
	protected static final String DIR_DOWNLOAD = System.getProperty("user.home", "C:") + File.separator + "Downloads" + File.separator;
	protected static final String BROWSER = System.getProperty("BROWSER",properties.getProperty("p_navegador"));
	public static final String WEB_SERVER = System.getProperty("WEB_SERVER",properties.getProperty("p_URL_WebServer"));
	
	
	public static WebDriver driver;
	
	
	public static boolean setupDriver(){	
		try{			
			if (BROWSER.equals("firefox")) {
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver(capabilities);
				
				
			} else if (BROWSER.equalsIgnoreCase("chrome")) {
				String path = CUR_DIR + "\\src\\main\\resources\\drivers\\ChromeDriver\\chromedriver_win32.exe";
				System.setProperty("webdriver.chrome.driver", path);
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("internetExplorer")) {
				String path = CUR_DIR + "\\src\\main\\resources\\drivers\\IEDriver\\IEDriverServer_Win32_2.53.0.exe";
	            System.setProperty("webdriver.ie.driver", path);
	            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            capabilities.setCapability("requireWindowFocus", true);
	            driver = new InternetExplorerDriver(capabilities);				
			} else if (BROWSER.equalsIgnoreCase("jenkins")) {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
			} else {
				System.out.println("Tipo de Browser No Soportado");
				return false;
			}
		}catch(Exception ex){
			System.out.println("Error al ejecutar el Driver: "+ex.toString());
			return false;
		}
		return true;
	}
	
	public static boolean setupDriver2() {
		try {

			if (BROWSER.equals("firefox")) {
				FirefoxProfile fprofile = new FirefoxProfile();

				fprofile.setPreference("browser.download.dir", DIR_DOWNLOAD);						
				fprofile.setPreference("browser.download.folderList", 2);
				fprofile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
						  "application/msword, "
						+ "application/vnd.ms-excel, "
						+ "application/mspowerpoint, "
						+ "application/csv, "
						+ "text/csv, "
						+ "application/pdf, "
						+ "image/png, "					
						+ "text/plain, "
						+ "application/plain,"
						+ "application/zip, "
						+ "application/x-zip, "
						+ "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, "
						+ "application/xls;text/csv,  "
						+ "application/octet-stream");
				fprofile.setPreference("browser.download.manager.showWhenStarting", false);
				// fprofile.setPreference( "pdfjs.disabled", true );
				// Set preferences for file type
				fprofile.setPreference("browser.helperApps.neverAsk.openFile", 
						  "application/msword, "
						+ "application/vnd.ms-excel, "
						+ "application/mspowerpoint, "
						+ "application/csv, "
						+ "text/csv, "
						+ "application/pdf, "
						+ "image/png, "					
						+ "text/plain, "
						+ "application/plain,"
						+ "application/zip, "
						+ "application/x-zip, "
						+ "application/octet-stream");
				fprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
				fprofile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				fprofile.setPreference("browser.download.manager.focusWhenStarting", false);
				fprofile.setPreference("browser.download.manager.useWindow", false);
				fprofile.setPreference("browser.download.manager.showAlertOnComplete", false);
				fprofile.setPreference("browser.download.manager.closeWhenDone", false);
				driver = new FirefoxDriver(fprofile);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			} else if (BROWSER.equalsIgnoreCase("chrome")) {
				String path = CUR_DIR + "\\src\\main\\resources\\drivers\\ChromeDriver\\chromedriver_x32.exe";
				
				System.setProperty("webdriver.chrome.driver", path);
				ChromeOptions options = new ChromeOptions();
				HashMap<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", DIR_DOWNLOAD);
				prefs.put("download.prompt_for_download", true);
				prefs.put("download.directory_upgrade", true);
				prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });				

				options.setExperimentalOption("prefs", prefs);

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				
				driver = new ChromeDriver(capabilities);
			} else if (BROWSER.equalsIgnoreCase("internetExplorer")) {
				String path = CUR_DIR + "\\src\\main\\resources\\drivers\\IExplorerDriver\\IEDriverServer_x32.exe";
				
				System.setProperty("webdriver.ie.driver", path);
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,	true);
		        capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
//		        capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
//		        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		        capabilities.setJavascriptEnabled(true);

				driver = new InternetExplorerDriver(capabilities);
			} else {
				System.out.println("Tipo de Browser No Soportado");
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error al ejecutar el Driver: " + ex.toString());
			return false;
		}
		return true;
	}


}
