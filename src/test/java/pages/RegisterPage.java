package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class RegisterPage extends ClaseBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
    By locatorTxtCorreo = By.xpath("//input[@id=\"email\"]");
    By locatorTxtConfCorreo = By.xpath("//input[@id=\"confirm\"]");
    By locatorTxtContraseña = By.xpath("//input[@placeholder=\"Crea una contraseña.\"]");
    By locatorTxtUsuario = By.xpath("//input[@placeholder=\"Introduce un nombre de perfil.\"]");
    By locatorTxtDiaNac = By.xpath("//input[@placeholder=\"DD\"]");
    By locatorDDLMesNac = By.xpath("//select[@id=\"month\"]");
    By locatorTxtAñoNac = By.xpath("//input[@placeholder=\"AAAA\"]");
    By locatorRdBtGéneroH = By.xpath("//button[@type=\"submit\"]");
    By locatorChkMkt = By.xpath("//label[@for=\"marketing-opt-checkbox\"]");
    By locatorChkCompDatos = By.xpath("//label[@for=\"third-party-checkbox\"]");
    By locatorBtnRegistrarte = By.xpath("//button[@type='submit']");
    By locatorLblErrorCaptcha = By. xpath("//div[contains(text(), \"Confirma que no eres un robot.\")]");
    By locatorLblNomUsuarioFaltante = By. xpath("//div[contains(text(),\"Introduce un nombre para tu perfil.\")]");
    By locatorBusquedaArtista = By.xpath("//h1[text()=\"The 1975\"]");
    By locatorConfCorreoFaltante = By.xpath("//div[contains(text(),\"Es necesario que confirmes tu email.\")]");
    By locatorAñoInvalido = By.xpath("//div[contains(text(),\"Indica un año válido.\")]");
    By locatorDiaMesInvalido = By.xpath("//div[contains(text(),\"Indica un día del mes válido.\")]");
    By locatorSinGeneroSeleccionado = By.xpath("//div[contains(text(),\\\"Selecciona tu sexo.\\\")]");



    //Realizar acciones en el sitio

    public void completarFormularioRegistro(String correo, String confirmarCorreo,String password, String usuario, String DiaNac, String mes, String año){

        esperarXSegundos(1000);

        agregarTexto(esperarElementoWeb(locatorTxtCorreo), correo);
        agregarTexto(esperarElementoWeb(locatorTxtConfCorreo), confirmarCorreo);
        agregarTexto(esperarElementoWeb(locatorTxtContraseña), password);
        agregarTexto(esperarElementoWeb(locatorTxtUsuario), usuario);
        agregarTexto(esperarElementoWeb(locatorTxtDiaNac), DiaNac);
        ScrollElementoWeb(esperarElementoWeb(locatorDDLMesNac));
        seleccionarDDLPorText(esperarElementoWeb(locatorDDLMesNac), mes);
        agregarTexto(esperarElementoWeb(locatorTxtAñoNac), año);
        click(esperarElementoWeb(locatorRdBtGéneroH));
        ScrollElementoWeb(esperarElementoWeb(locatorChkMkt));
        click(esperarElementoWeb(locatorChkMkt));
        click(esperarElementoWeb(locatorChkCompDatos));
        ScrollElementoWeb(esperarElementoWeb(locatorBtnRegistrarte));
        click(esperarElementoWeb(locatorBtnRegistrarte));
    }
    public void completarFormularioRegistroErrorGenero(String correo, String confirmarCorreo,String password, String usuario, String DiaNac, String mes, String año){

        esperarXSegundos(1000);

        agregarTexto(esperarElementoWeb(locatorTxtCorreo), correo);
        agregarTexto(esperarElementoWeb(locatorTxtConfCorreo), confirmarCorreo);
        agregarTexto(esperarElementoWeb(locatorTxtContraseña), password);
        agregarTexto(esperarElementoWeb(locatorTxtUsuario), usuario);
        agregarTexto(esperarElementoWeb(locatorTxtDiaNac), DiaNac);
        ScrollElementoWeb(esperarElementoWeb(locatorDDLMesNac));
        seleccionarDDLPorText(esperarElementoWeb(locatorDDLMesNac), mes);
        agregarTexto(esperarElementoWeb(locatorTxtAñoNac), año);
        //click(esperarElementoWeb(locatorRdBtGéneroH));
        ScrollElementoWeb(esperarElementoWeb(locatorChkMkt));
        click(esperarElementoWeb(locatorChkMkt));
        click(esperarElementoWeb(locatorChkCompDatos));
        ScrollElementoWeb(esperarElementoWeb(locatorBtnRegistrarte));
        click(esperarElementoWeb(locatorBtnRegistrarte));
    }
    public String obtenerErrorCaptcha(){
        return obtenerTexto(esperarElementoWeb(locatorLblErrorCaptcha));
    }
    public String obtenerErrorUsuario(){
        return obtenerTexto(esperarElementoWeb(locatorLblNomUsuarioFaltante));
    }
    public String obtenerErrorConfCorreo(){
        return obtenerTexto(esperarElementoWeb(locatorConfCorreoFaltante));
    }
    public String obtenerErrorAñoInvalido(){
        return obtenerTexto(esperarElementoWeb(locatorAñoInvalido));
    }

    public String obtenerErrorMesInvalido(){
        return obtenerTexto(esperarElementoWeb(locatorDiaMesInvalido));
    }
    public String obtenerErrorSinGenero(){
        return obtenerTexto(esperarElementoWeb(locatorSinGeneroSeleccionado));
    }


}
