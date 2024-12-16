package br.com.dennysmatos.taskit.tests;

import br.com.dennysmatos.taskit.pages.HomePage; // Importa a classe HomePage
import io.github.bonigarcia.wdm.WebDriverManager; // Gerencia o WebDriver do Chrome
import org.junit.jupiter.api.*; // Anotações do JUnit 5
import org.openqa.selenium.WebDriver; // Interface principal do WebDriver
import org.openqa.selenium.chrome.ChromeDriver; // Implementação específica do ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions; // Configurações para o Chrome

import java.time.Duration; // Representa um intervalo de tempo
import java.util.Random; // Gera números aleatórios

@DisplayName("Testes Automatizados da Funcionalidade de Sign Up") // Nome amigável para a classe de teste
public class SignUpTests {

    private WebDriver navegador; // Variável para armazenar o navegador
    private String login; // Variável para armazenar o login do usuário

    @BeforeEach // Será executado antes de cada teste
    public void setUp() {
        // Configura o WebDriver do Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/path/to/some/new/profile"); // Define um perfil específico do Chrome (opcional)
        navegador = new ChromeDriver(options);

        // Maximiza a janela do navegador
        navegador.manage().window().maximize();

        // Define um tempo máximo de espera para elementos (6 segundos)
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @Test // Marca o método como um teste
    @DisplayName("Registrar um novo usuário com dados válidos") // Nome amigável para o teste
    public void testRegistrarUmNovoUsuarioComDadosValidos() {

        Random random = new Random(); // Cria um gerador de números aleatórios
        int numeroAleatorio = random.nextInt(1000); // Gera um número aleatório entre 0 e 999

        // Constrói o login único usando o nome "armando_" e o número aleatório
        login = "armando_" + numeroAleatorio;

        HomePage homePage = new HomePage(navegador); // Cria uma instância da HomePage

        // Encadeia ações na HomePage: acessar, registrar, pegar saudação
        String saudacaoAtual = homePage
                .acessarPaginaDoTaskit()
                .abrirPaginaDeRegistro()
                .registrarNovoUsuario("Armando", login, "123456")
                .pegarASaudacao();

        // Verifica se a saudação obtida corresponde ao esperado ("Hi, Armando")
        Assertions.assertEquals("Hi, Armando", saudacaoAtual);
    }

    @AfterEach // Será executado depois de cada teste
    public void tearDown() {
        // Faz logout usando a HomePage
        new HomePage(navegador)
                .fazerLogOut();

        // Fecha o navegador
        navegador.quit();
    }
}