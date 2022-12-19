package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class HomePage extends ClaseBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Las pages tienen por objetivo centralizar los localizadores y acciones de una pagina
    By locatorBtnRegistrate = By.xpath("//button[contains(text(),\"Regístrate\")]");
    By locatorBtnBuscar = By.xpath(("//ul/li[2]/a"));


    //Acciones
    public void irARegistrarte(){
        click(esperarElementoWeb(locatorBtnRegistrate));
    }
    public void BtnBuscar(){
        click(esperarElementoWeb(locatorBtnBuscar));
    }
}
