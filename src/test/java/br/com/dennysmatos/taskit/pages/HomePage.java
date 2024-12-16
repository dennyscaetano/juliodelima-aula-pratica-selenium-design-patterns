package br.com.dennysmatos.taskit.pages;

import br.com.dennysmatos.taskit.BasePage; // Herda funcionalidades da classe base
import org.openqa.selenium.By; // Localizar elementos por vários critérios
import org.openqa.selenium.WebDriver; // Interface principal para controlar o navegador
import org.openqa.selenium.WebElement; // Representa um elemento HTML na página
import org.openqa.selenium.support.FindBy; // Anotação para localizar elementos na página

public class HomePage extends BasePage {

    // Localiza o botão de cadastro ("Sign Up") pelo ID
    @FindBy(id = "signup")
    private WebElement botaoSignUp;

    public HomePage(WebDriver navegador) {
        super(navegador); // Inicializa a classe base e o WebDriver
    }

    // Acessa a página inicial do TaskIt
    public HomePage acessarPaginaDoTaskit() {
        navegador.get("http://www.juliodelima.com.br/taskit/"); // Define a URL do TaskIt

        // Retorna a própria instância da HomePage (para encadear ações)
        return this;
    }

    // Abre a página de registro clicando no botão "Sign Up"
    public RegistroPage abrirPaginaDeRegistro() {
        botaoSignUp.click(); // Clica no botão

        // Retorna uma nova instância da RegistroPage (assumindo que é a próxima página)
        return new RegistroPage(navegador);
    }

    // Realiza logout clicando no link "Logout"
    public HomePage fazerLogOut() {
        navegador.findElement(By.linkText("Logout")).click(); // Localiza e clica no link

        // Retorna a própria instância da HomePage
        return this;
    }
}