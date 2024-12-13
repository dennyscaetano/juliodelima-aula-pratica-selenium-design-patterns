# Selenium Training Project

Este repositório contém um projeto de treinamento para a aplicação do framework **Selenium**, utilizando padrões de design (**Design Patterns**) para estruturar testes automatizados de forma eficiente e escalável. Os padrões implementados incluem **Page Objects**, **Page Factory** e **Fluent Pages**.

## Objetivo
O objetivo principal deste projeto é demonstrar como aplicar Design Patterns de forma fundamentada para resolver problemas comuns em projetos de automação de testes Web, promovendo organização, reutilização de código e facilidade de manutenção.

> **Dica Master:** Não aplique Design Patterns simplesmente porque quer usá-los. Aplique-os quando perceber que há problemas que podem ser resolvidos por eles.

## Padrões de Design Implementados

### Page Objects
- **Descrição:** Organiza os testes com base nas ações e elementos disponíveis em cada página.
- **Benefício:** Mantém o código mais limpo e fácil de manter, separando a lógica de interação com a página da lógica dos testes.
- **Exemplo:**
  ```java
  public class LoginPage {
      private WebDriver driver;

      public LoginPage(WebDriver driver) {
          this.driver = driver;
      }

      public void enterUsername(String username) {
          driver.findElement(By.id("username")).sendKeys(username);
      }

      public void enterPassword(String password) {
          driver.findElement(By.id("password")).sendKeys(password);
      }

      public void clickLoginButton() {
          driver.findElement(By.id("loginButton")).click();
      }
  }
  ```

### Page Factory
- **Descrição:** Facilita a inicialização de elementos das páginas, permitindo um acesso mais simples e reduzindo a verbosidade no código.
- **Benefício:** Aumenta a clareza e a eficiência na inicialização de elementos.
- **Exemplo:**
  ```java
  public class LoginPage {
      @FindBy(id = "username")
      private WebElement usernameField;

      @FindBy(id = "password")
      private WebElement passwordField;

      @FindBy(id = "loginButton")
      private WebElement loginButton;

      public LoginPage(WebDriver driver) {
          PageFactory.initElements(driver, this);
      }

      public void login(String username, String password) {
          usernameField.sendKeys(username);
          passwordField.sendKeys(password);
          loginButton.click();
      }
  }
  ```

### Fluent Pages
- **Descrição:** Permite a criação de testes de maneira encadeada e limitada ao escopo das páginas, promovendo uma sintaxe mais fluida.
- **Benefício:** Melhora a legibilidade dos testes, promovendo uma abordagem mais natural para ações sequenciais.
- **Exemplo:**
  ```java
  public class LoginPage {
      private WebDriver driver;

      public LoginPage(WebDriver driver) {
          this.driver = driver;
      }

      public LoginPage enterUsername(String username) {
          driver.findElement(By.id("username")).sendKeys(username);
          return this;
      }

      public LoginPage enterPassword(String password) {
          driver.findElement(By.id("password")).sendKeys(password);
          return this;
      }

      public HomePage clickLoginButton() {
          driver.findElement(By.id("loginButton")).click();
          return new HomePage(driver);
      }
  }

  // Exemplo de uso:
  LoginPage loginPage = new LoginPage(driver);
  HomePage homePage = loginPage.enterUsername("user")
                                .enterPassword("pass")
                                .clickLoginButton();
  ```

## Tecnologias Utilizadas
- **Linguagem:** Java
- **Framework de Automação:** Selenium WebDriver
- **Gerenciamento de Dependências:** Maven
- **Padrões de Projeto:** Page Objects, Page Factory, Fluent Pages

## Como Executar o Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/selenium-training-project.git
   ```

2. Importe o projeto em sua IDE preferida (IntelliJ IDEA, Eclipse, etc.).

3. Configure o navegador e o driver correspondente (ex.: ChromeDriver).

4. Execute os testes via IDE ou terminal:
   ```bash
   mvn test
   ```

## Estrutura do Projeto
```
selenium-training-project/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pages/   # Classes com as implementações de Page Objects, Page Factory e Fluent Pages
│   ├── test/
│       └── java/
│           └── tests/  # Scripts de teste utilizando as páginas
├── pom.xml             # Gerenciamento de dependências
└── README.md           # Documentação
```

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests para melhorias ou correções.

## Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.
