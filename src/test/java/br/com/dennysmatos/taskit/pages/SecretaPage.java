package br.com.dennysmatos.taskit.pages;

import br.com.dennysmatos.taskit.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecretaPage extends BasePage {

    @FindBy(className = "me")
    private WebElement mensagemDeSaudacao;

    public SecretaPage(WebDriver navegador) {
        super(navegador);
    }

    public String pegarASaudacao() {
        return mensagemDeSaudacao.getText();
    }

}
