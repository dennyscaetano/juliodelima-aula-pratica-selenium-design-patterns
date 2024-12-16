package br.com.dennysmatos.taskit.pages;

import br.com.dennysmatos.taskit.BasePage; // Herda da classe BasePage
import org.openqa.selenium.WebDriver; // Interface principal do WebDriver
import org.openqa.selenium.WebElement; // Representa um elemento da página web
import org.openqa.selenium.support.FindBy; // Anotação para localizar elementos

public class RegistroPage extends BasePage {

    @FindBy(id = "name-sign-up") // Localiza o campo de nome pelo ID
    private WebElement campoNome;

    @FindBy(id = "login-sign-up") // Localiza o campo de login pelo ID
    private WebElement campoLogin;

    @FindBy(id = "password-sign-up") // Localiza o campo de senha pelo ID
    private WebElement campoSenha;

    @FindBy(id = "btn-submit-sign-up") // Localiza o botão de salvar pelo ID
    private WebElement botaoSalvar;

    public RegistroPage(WebDriver navegador) {
        super(navegador); // Inicializa a classe base com o WebDriver
    }

    public SecretaPage registrarNovoUsuario(String nome, String login, String senha) {
        // Preenche o campo de nome
        campoNome.sendKeys(nome);

        // Preenche o campo de login
        campoLogin.sendKeys(login);

        // Preenche o campo de senha
        campoSenha.sendKeys(senha);

        // Clica no botão de salvar
        botaoSalvar.click();

        // Retorna uma nova instância da SecretaPage (assumindo que é a página seguinte)
        return new SecretaPage(navegador);
    }
}