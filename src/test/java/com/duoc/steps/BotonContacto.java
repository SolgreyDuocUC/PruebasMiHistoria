package com.duoc.steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.opera.OperaDriver;
//aimport org.openqa.selenium.opera.OperaOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;



public class BotonContacto {

    static WebDriver driver;

    @Before
    public void setup(){

        //Descargar el webdriver
        //WebDriverManager.operadriver().setup();
        WebDriverManager.chromedriver().setup();

        //Nos va a permitir trabajar con las opciones de inicio de opera
        ChromeOptions options = new ChromeOptions();

        //Chrome modo incognito
        options.addArguments("--incognito");
        //desactiva las contraseñas guardadas
        options.addArguments("--disable-save.password-bubble");
        //Desactiva los pop ups
        options.addArguments("--disable-popup-blocking");
        //Evita la pregunta de navegador por defecto
        options.addArguments("--no-default-browser-checka");
        //Desactiva los infobars
        options.addArguments("--disable-infobars");
        //Generoa perfil de chrome limpio
        options.addArguments("--user-data-dir=/tmp/chrome-test-profile");

        driver = new ChromeDriver(options);

        //Maximixo la pantalla
        driver.manage().window().maximize();
        //Elimino las cockies
        driver.manage().deleteAllCookies();

    }

    @After
    public void teardown() throws Exception{
        if(driver != null){
            driver.quit(); // Cierro la pestaña
        }

    }

    @Given("Para navegar hasta laa url {string}")
    public void para_navegar_hasta_laa_url(String url) throws InterruptedException{

        driver.get(url);
        Thread.sleep(5000);

    }

    @When("hacemos click en el link {string}")
    public void hacemos_click_en_el_link(String link) throws InterruptedException {

        driver.findElement(By.xpath(link)).click();
    }

    @Then("Redireccionarte a la url {string}")
    public void redireccionarte_a_la_url(String urlEsperada) throws InterruptedException{

        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(urlEsperada)) {
            System.out.println("Redirección exitosa a contacto: " + actualUrl);
        } else {
            System.out.println("Redirección fallida. URL actual: " + actualUrl);
        }
        Thread.sleep(2000);
    }

}
