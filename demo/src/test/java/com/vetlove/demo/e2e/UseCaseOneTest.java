package com.vetlove.demo.e2e;

import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.vetlove.demo.Servicio.ClienteServicio;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UseCaseOneTest {
    private final String BASE_URL = "http://localhost:4200";

     @Autowired
     private ClienteServicio clienteServicio;

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void init(){
        
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        //chromeOptions.addArguments("--headless");

        this.driver = new ChromeDriver(chromeOptions);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void UseCaseOne_AddClienteTest(){
        driver.get(BASE_URL + "/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flip-card__btn")));
        WebElement btnSwtich = driver.findElement(By.className("slider"));

        btnSwtich.click();

        WebElement inputEmail = driver.findElement(By.id("cedula-login"));
        WebElement inputPassword = driver.findElement(By.id("password-login"));

        inputEmail.sendKeys("1");
        inputPassword.sendKeys("1");

        WebElement btnSendLogin = driver.findElement(By.id("send-login"));

        btnSendLogin.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-popup")));

        WebElement btnClosePopup = driver.findElement(By.id("close-popup"));

        btnClosePopup.click();

        inputEmail.sendKeys(Keys.BACK_SPACE);
        inputPassword.sendKeys(Keys.BACK_SPACE);
        inputEmail.sendKeys("12345678");
        inputPassword.sendKeys("password");

        btnSendLogin.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-sidebar")));

        WebElement linkClientes = driver.findElement(By.id("mis-clientes"));

        linkClientes.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-clientes-link")));

        WebElement linkAddClientes = driver.findElement(By.id("add-clientes-link"));

        linkAddClientes.click();

        WebElement inputClienteNombre = driver.findElement(By.id("id_nombre"));
        WebElement inputClienteCedula = driver.findElement(By.id("id_cedula"));
        WebElement inputClienteCorreo = driver.findElement(By.id("id_correo"));
        WebElement inputClienteCelular = driver.findElement(By.id("id_celular"));

        inputClienteNombre.sendKeys("Pedro Perez");
        inputClienteCedula.sendKeys("12345678888888888");
        inputClienteCorreo.sendKeys("0HkI8@example.com");
        inputClienteCelular.sendKeys("3125942118");

        WebElement btnAddCliente = driver.findElement(By.id("add-cliente-btn"));

        btnAddCliente.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("editBtn")));

        List<WebElement> btnsUpdateCliente = driver.findElements(By.className("editBtn"));

        btnsUpdateCliente.get(btnsUpdateCliente.size() - 1).click();

        WebElement inputClienteCedulaCorreccion = driver.findElement(By.id("id_cedula"));
        for (int i = 0; i < 9; i++) {
            inputClienteCedulaCorreccion.sendKeys(Keys.BACK_SPACE);
        }
        btnAddCliente = driver.findElement(By.id("add-cliente-btn"));
        btnAddCliente.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("app-sidebar")));

        WebElement linkMascotas = driver.findElement(By.id("mis-mascotas"));

        linkMascotas.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-mascotas-btn")));

        WebElement btnAddmascota = driver.findElement(By.id("add-mascotas-btn"));

        btnAddmascota.click();

        WebElement inputMascotaCedula = driver.findElement(By.id("id_dueno"));
        WebElement inputMascotaNombre = driver.findElement(By.id("id_nombre"));
        WebElement inputMascotaRaza = driver.findElement(By.id("id_raza"));
        WebElement inputMascotaImagen = driver.findElement(By.id("id_imagen"));
        WebElement inputMascotaEdad = driver.findElement(By.id("id_edad"));
        WebElement inputMascotaPeso = driver.findElement(By.id("id_peso"));

        inputMascotaCedula.sendKeys("12345678");
        inputMascotaNombre.sendKeys("Ginny");
        inputMascotaRaza.sendKeys("Persa");
        inputMascotaImagen.sendKeys("https://cdn.pixabay.com/photo/2015/10/30/20/13/cat-1015426_1280.jpg");
        inputMascotaEdad.sendKeys(Keys.BACK_SPACE);
        inputMascotaEdad.sendKeys("9");
        inputMascotaPeso.sendKeys(Keys.BACK_SPACE);
        inputMascotaPeso.sendKeys("5000");

        WebElement enviarMascota = driver.findElement(By.className("btn-enviar"));

        enviarMascota.click();

        driver.get(BASE_URL + "/login");

        WebElement inputCedula = driver.findElement(By.id("id_email"));

        inputCedula.sendKeys("12345678");

        WebElement btnLogin = driver.findElement(By.id("boton-login-dueño"));

        btnLogin.click();

        //Use wait to wait 5 seconds

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("setting-btn")));
        List<WebElement> mascotaNombre = driver.findElements(By.className("row-1"));
        List<WebElement> mascotaRaza = driver.findElements(By.className("row-2"));
        List<WebElement> mascotarEdad = driver.findElements(By.className("row-3"));


        Assertions.assertThat(mascotaNombre.get(1).getText()).isEqualTo("Ginny");
        Assertions.assertThat(mascotaRaza.get(1).getText()).isEqualTo("Persa");
        Assertions.assertThat(mascotarEdad.get(1).getText()).isEqualTo("9");

    }

    @Test
    public void UseCaseTwo_AplicarTratamiento(){
        driver.get(BASE_URL + "/veterinario/mis-tratamientos?id=1");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("flip-card__btn")));
    }

    @AfterEach
    void tearDown(){
        driver.quit();
        // clienteServicio.deleteById(51L);
    }
}
