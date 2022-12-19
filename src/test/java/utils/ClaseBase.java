package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//La clase base define las acciones de Selenium (Wrapper)
public class ClaseBase {
        //Atributos
        protected WebDriver driver;
        protected JavascriptExecutor js;
        protected WebDriverWait wait;

        protected Select select;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
//Métodos

    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    //Enmascarar las acciones de selenium

    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);
    }

    public void cargarPagina(String url){
        this.driver.get(url);
    }

    //Conectar el driver al navegador
    public WebDriver conexionBrowser(String browser, String propertyDriver, String rutaDriver){
        switch (browser){
            case "CHROME":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new ChromeDriver();
                return this.driver;
            case "EDGE":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new EdgeDriver();
                return this.driver;
            case "FIREFOX":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new FirefoxDriver();
                return this.driver;
            default:
                this.driver = null;
                return this.driver;
        }
    }

    //Scroll
    public void ScrollElementoWeb (By localizador){
        js = (JavascriptExecutor) this.driver;

        js.executeScript("arguments [0].scrollIntoView();", this.driver.findElement(localizador));


    }
    public void ScrollElementoWeb (WebElement elemento){
        js = (JavascriptExecutor) this.driver;

        js.executeScript("arguments [0].scrollIntoView();",elemento);


    }
    //Tiempos de espera
    public void esperarXSegundos(int milisegundos){
        try{
            Thread.sleep(3000);
        }catch (Exception ex){
            System.out.println("Fallo la espera en milisegundos definida");

        }
    }
    //Espera en base a evento
    public WebElement esperarElementoWeb(By localizador){
        wait = new WebDriverWait(this.driver,20);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));

    }

    //Click
    public void click(WebElement elemento){
        elemento.click();
    }

    //ObtenerTexto
    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();

    }




    //Submit
    public void submitFormulario (By localizador){
        this.driver.findElement(localizador).submit();
    }


    //AgregarTexto
    //Metodo sobreescrito es aquel que tiene el mismo nombre, retorna lo mismo y tiene los mismos parametros. Solo cambia el cuerpo de la pagina
    //Un método sobrecargado es aque que tiene alguno de los elementos anteriormente mencionados de forma distinta
    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }
    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    //Maximizar ventana
    public void maximizarBrowser(){
        driver.manage().window().maximize();
    }

    public void seleccionarDDLPorText(WebElement elemento,String texto){
        select = new Select(elemento);

        select.selectByVisibleText(texto);
    }

    public void cerrarBrowser(){
        this.driver.quit();
    }
}
