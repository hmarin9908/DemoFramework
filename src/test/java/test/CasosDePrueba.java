package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;

public class CasosDePrueba {
    //Atributos
    private HomePage homePage;
    private RegisterPage registerPage;
    private SearchPage searchPage;
    private WebDriver driver;
    private String browser = "CHROME";
    private String propertyDriver = "webdriver.chrome.driver";
    private String urlDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String url = "https://open.spotify.com/";

    @BeforeMethod
    public void preparacionTest(){
        homePage = new HomePage(driver); //Se crea la page del home
        homePage.conexionBrowser(browser,propertyDriver,urlDriver); //Se conecta el driver de chrome
        registerPage = new RegisterPage(homePage.getDriver()); //Se crea la page de registro

        homePage.cargarPagina(url);
        homePage.maximizarBrowser();
        searchPage = new SearchPage(homePage.getDriver());


    }
    @Test
    public void CP001_Registro_Fallido_Captcha_En_Blanco(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("humberto.marin@tsoftlatam.com", "humberto.marin@tsoftlatam.com",
                "Marin10M123456.","BetoMarin992008","20","Agosto","1999");
        Assert.assertEquals(registerPage.obtenerErrorCaptcha(),"Confirma que no eres un robot.");
    }
    @Test
    public void CP002_Registro_Fallido_Nombre_Usuario_Faltante(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("humberto.marin@tsoftlatam.com", "humberto.marin@tsoftlatam.com",
                "Marin10M123456.","","20","Agosto","1999");
        Assert.assertEquals(registerPage.obtenerErrorUsuario(),"Introduce un nombre para tu perfil.");
    }
    @Test
    public void CP003_Busqueda_De_Artista(){
        homePage.BtnBuscar();
        searchPage.buscarArtista("The 1975");
        Assert.assertEquals(searchPage.busquedaArtistaExitosa(),"The 1975");
    }
    @Test
    public void CP004_Registro_Fallido_Falta_Confirmacion_Correo(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("humberto.marin@tsoftlatam.com", "",
                "Marin10M123456.","BetoMarin992008","20","Agosto","1999");
        Assert.assertEquals(registerPage.obtenerErrorConfCorreo(),"Es necesario que confirmes tu email.");
    }
    @Test
    public void CP005_Registro_Fallido_Año_Inválido(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("humberto.marin@tsoftlatam.com", "humberto.marin@tsoftlatam.com",
                "Marin10M123456.","BetoMarin992008","20","Agosto","199");
        Assert.assertEquals(registerPage.obtenerErrorAñoInvalido(),"Indica un año válido.");
    }
    @Test
    public void CP006_Registro_Fallido_Dia_Del_Mes_Inválido(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistro("humberto.marin@tsoftlatam.com", "humberto.marin@tsoftlatam.com",
                "Marin10M123456.","BetoMarin992008","40","Agosto","1999");
        Assert.assertEquals(registerPage.obtenerErrorMesInvalido(),"Indica un día del mes válido.");
    }
    @Test
    public void CP006_Registro_Fallido_Sin_Seleccion_Sexo(){
        homePage.irARegistrarte();
        registerPage.completarFormularioRegistroErrorGenero("humberto.marin@tsoftlatam.com", "humberto.marin@tsoftlatam.com",
                "Marin10M123456.","BetoMarin992008","20","Agosto","1999");
        Assert.assertEquals(registerPage.obtenerErrorSinGenero(),"Selecciona tu sexo.");
    }



    @AfterMethod
    public void posTests(){
        registerPage.cerrarBrowser();

    }
}
