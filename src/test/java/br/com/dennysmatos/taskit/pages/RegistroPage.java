package br.com.dennysmatos.taskit.pages;

import br.com.dennysmatos.taskit.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistroPage extends BasePage {

    @FindBy(id = "name-sign-up")
    private WebElement campoNome;

    @FindBy(id = "login-sign-up")
    private WebElement campoLogin;

    @FindBy(id = "password-sign-up")
    private WebElement campoSenha;

    @FindBy(id = "btn-submit-sign-up")
    private WebElement botaoSalvar;

    public RegistroPage(WebDriver navegador) {
        super(navegador);
    }

    public SecretaPage registrarNovoUsuario(String nome, String login, String senha) {
        // Vou digitar o nome no campo com ID igual a name-sign-up
        campoNome.sendKeys(nome);

        // Vou digitar o login no campo com ID igual a login-sign-up
        campoLogin.sendKeys(login);

        // Vou digitar a senha com campo com ID igual a password-sign-up
        campoSenha.sendKeys(senha);

        // Vou clicar no botão com ID igual a btn-submit-sign-up
        botaoSalvar.click();

        return new SecretaPage(navegador);
    }
}
