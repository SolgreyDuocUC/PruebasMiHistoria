package com.duoc.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BotonGaleria {
    static WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-infobars");
        options.addArguments("--user-data-dir=/tmp/chrome-test-profile");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("que estoy en la página principal {string}")
    public void que_estoy_en_la_pagina_principal(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
    }

    @When("hago clic en el botón de galería con xpath {string}")
    public void hago_clic_en_el_boton_de_galeria_con_xpath(String xpathBoton) throws InterruptedException {
        driver.findElement(By.xpath(xpathBoton)).click();
        Thread.sleep(2000);
    }

    @Then("debo ser redirigido a la url {string}")
    public void debo_ser_redirigido_a_la_url(String urlEsperada) throws InterruptedException {
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(urlEsperada)) {
            System.out.println("Redirección exitosa a la galería: " + actualUrl);
        } else {
            System.out.println("Redirección fallida. URL actual: " + actualUrl);
        }
        Thread.sleep(2000);
    }
}

