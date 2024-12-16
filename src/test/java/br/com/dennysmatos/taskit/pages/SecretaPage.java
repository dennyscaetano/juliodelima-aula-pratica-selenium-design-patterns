package br.com.dennysmatos.taskit.pages;

import br.com.dennysmatos.taskit.BasePage; // Herda funcionalidades da classe base
import org.openqa.selenium.WebDriver; // Interface principal para controlar o navegador
import org.openqa.selenium.WebElement; // Representa um elemento HTML na página
import org.openqa.selenium.support.FindBy; // Anotação para localizar elementos na página

public class SecretaPage extends BasePage {

    // Localiza o elemento que contém a mensagem de saudação na página
    @FindBy(className = "me")
    private WebElement mensagemDeSaudacao;

    // Construtor da classe, inicializa a classe base e o WebDriver
    public SecretaPage(WebDriver navegador) {
        super(navegador);
    }

    // Obtém o texto da mensagem de saudação da página
    public String pegarASaudacao() {
        // Retorna o texto presente no elemento localizado
        return mensagemDeSaudacao.getText();
    }

}