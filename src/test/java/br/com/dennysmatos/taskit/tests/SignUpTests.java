package br.com.dennysmatos.taskit.tests;

import br.com.dennysmatos.taskit.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Random;

@DisplayName("Testes Automatizados da Funcionalidade de Sign Up")
public class SignUpTests {

    private WebDriver navegador;
    private String login;

    @BeforeEach
    public void setUp() {
        // Vou abrir o Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/path/to/some/new/profile");
        navegador = new ChromeDriver(options);

        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos() {

        Random random = new Random();
        int numeroAleatorio = random.nextInt(1000);

        login = "armando_" + numeroAleatorio;

        String saudacaoAtual = new HomePage(navegador)
                .acessarPaginaDoTaskit()
                .abrirPaginaDeRegistro()
                .registrarNovoUsuario("Armando", login, "123456")
                .pegarASaudacao();

        Assertions.assertEquals("Hi, Armando", saudacaoAtual);
    }

    @AfterEach
    public void tearDown() {
        new HomePage(navegador)
                .fazerLogOut();

        navegador.quit();
    }
}