package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class SearchPage extends ClaseBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By locatorBuscarArtista = By.xpath("//input[@placeholder=\"¿Qué quieres escuchar?\"]");
    By locatorBusquedaExitosa = By.xpath("//div[contains(text(),\\\"The 1975\\\")]");


    public void buscarArtista (String artista){
        esperarXSegundos(1000);

        agregarTexto(esperarElementoWeb(locatorBuscarArtista), artista);
    }
    public String busquedaArtistaExitosa(){

        return obtenerTexto(esperarElementoWeb(locatorBusquedaExitosa));
    }


}
