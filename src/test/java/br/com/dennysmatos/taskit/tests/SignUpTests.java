package br.com.dennysmatos.taskit.tests;

import br.com.dennysmatos.taskit.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@DisplayName("Testes Automatizados da Funcionalidade de Sign Up")
public class SignUpTests {

    private WebDriver navegador;

    @BeforeEach
    public void setUp() {
        // Vou abrir o Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/path/to/some/new/profile");
        navegador = new ChromeDriver(options);
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @DisplayName("Registrar um novo usuário com dados válidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos() {
        String saudacaoAtual = new HomePage(navegador)
                .acessarPaginaDoTaskit()
                .abrirPaginaDeRegistro()
                .registrarNovoUsuario("Rosinha", "rosinha00010", "123456")
                .pegarASaudacao();

        Assertions.assertEquals("Hi, Rosinha", saudacaoAtual);
    }

    @AfterEach
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}