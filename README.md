# **Desafio Automação - Selenium WebDriver**

Desafio da Base 2 para automação WEB.



### Requisitos

- Instalação do Docker e importação do container "Mantis".

- Configuração do Mantis.

- Importação das dependências.

  

  

###  Instalação

#### 	Mantis

1. Criar uma pasta  em C:\ com nome Mantis.

2. Abra um terminal e acesse o diretório recém criado.

3. Colar o arquivo **docker-compose.yml** no diretório

4. Execute o comando> `docker-compose.exe up -d`

5. Após o processamento se tudo correr bem, as imagens serão baixadas e novos contêineres criados.

6. Para validar a criação e execução, execute o comando `docker ps -a` e os contêineres estarão disponíveis e executando:

   

   #### **Banco de Dados**

   Faça o seu primeiro acesso ao Mantis pelo endereço [*http://127.0.0.1:8989*](http://127.0.0.1:8989/)

   Após acessar será necessário configurar o banco de dados conforme tabela abaixo:

   | Variável                                        | Valor          |
   | ----------------------------------------------- | -------------- |
   | Type of Database                                | MySQL Improved |
   | Hostname (for Database Server)                  | mantis_db_1    |
   | Username (for Database)                         | mantisbt       |
   | Password (for Database)                         | mantisbt       |
   | Database name (for Database)                    | bugtracker     |
   | Admin Username (to create Database if required) | root           |
   | Admin Password (to create Database if required) | root           |

   Após preencher, clicar em **Continue** e aguardar o processamento.

   




## Desafio:

Desafio Automação - Selenium WebDriver

## Testes

- Implementar 50 scripts de testes que manipulem uma aplicação cuja interface é uma API REST.  -

Testes distribuídos em classes localizadas na  pasta **tests** . Utilizado a arquitetura padrão disponibilizada pela Base2. Os testes foram baseados nas rotinas de   **Logins**(Logintests), **Usuários**(UserTests), **Projetos**(Projects) e **Tarefas**(task)



- Alguns scripts devem ler dados de uma planilha Excel para implementar Data-Driven.

*Implementado o DDT via **CSV** e **Excel**. Criando as classes **ReadingCSVUtils.class** e **Excelutils.class** para leitura dos arquivos, que se encontram dentro da pasta **resources**. Na classe **UserTests.class** foi feito a chamada dos testes **cadastrarUsuariosNovosDDTCSV** e **cadastrarUsuariosNovosDDTEXCEL()** para execução dos DDT.*



-  Os casos de testes precisam ser executados em no mínimo três navegadores. Utilizando o Selenium Grid.

*Feito a parametrização e configuração do SeleniumGrid de forma local, como se fosse um servidor de testes. Arquivos disponíveis na pasta SeleniumGrid dentro do projeto.*

*Navegadores,  IE, Chrome e Firefox*



- ​	Gravar screenshots ou vídeo automaticamente dos casos de testes.

*Criado a classe **Recording.class** para adição das configurações do **ATUTestRecorder**, para efetuar a gravação de vídeos da execução dos testes.* 

*Dentro do projeto podemos também parametrizar na **globalParameters** o campo **get.screenshot.for.each.step=true** e dentro da **Utils.class** parametrizar a função **getScreenshot()** para configuração de prints dos testes.*

*Links de apoio:* 

1. [*ATUTestRecorder*](https://medium.com/@alanpaulooficial/como-gravar-evid%C3%AAncias-de-automa%C3%A7%C3%A3o-de-testes-em-v%C3%ADdeos-utilizando-o-selenium-webdriver-c12a0dab8452) 
2. *[Conversor](https://convertio.co/pt/)*



-  O projeto deverá gerar um relatório de testes automaticamente com screenshots ou vídeos embutidos.

*Ao final da execução dos testes é salvo um relatório na pasta **\target\reports**.  O relatório é configurado pela classe **ExtentReportsUtils.class**  e chamado nos métodos **@BeforeSuite, @BeforeMethod, @AfterMethod e @AfterSuite**  da classe **TestBase.class** para que seja criado em  cada execução de forma automática.*



- A massa de testes deve ser preparada neste projeto, seja com scripts carregando massa nova no BD ou com restore de banco de dados.


*Utilizado os parâmetros da classe **DButils.class** para conexão e execução das queries. Configurado o banco em **globalParameters.properties**. Criando algumas chamadas para execução antes de alguns testes, como por exemplo, excluir e cadastrar usuários antes de inicar os testes, no **@BeforeSuite** . A classes que chamam as queries fica na pasta **dbsteps** e os arquivos .sql estão salvos em **queries**.  Dessa forma podendo aproveitar a query mais de uma vez em diferentes testes.*



- Um dos scripts deve injetar Javascript para executar alguma operação na tela. O objetivo aqui é exercitar a injeção de Javascript dentro do código do Selenium.

*Dentro da classe **LoginPage**, criado as funções **preenhcerUsuarioJS**, **preencherSenhaJS** e **clicarEmEntrarJS**. Que são chamadas na **Logintests** no teste **efetuarLoginComSucessoUtilizandoJS** . Esse teste efetua login usando os parametros JS*



- Testes deverão ser agendados pelo Azure DevOps, Gitlab-CI, Jenkins, CircleCI, TFS ou outra ferramenta de CI que preferir.

*Os testes rodam de forma continua pelo GitLab Runner, apos o processo merge na branche main. Foi necessário configurar o Runner  no servidor local(Pasta GitLab_Runner), simulando o servidor PRD ou HML do ambiente de desenvolvimento e as configurações de execução do  CI estão presentes no arquivo **.gitlab-ci.ym**l.*

*Links de apoio:* 

- *[Git Runnes - Instalação.](https://docs.gitlab.com/runner/install/windows.html)*
- *[Git Runners - Configuração.](https://docs.gitlab.com/runner/register/index.html)*
- *[Configuração ambiente, se precisar](https://stackoverflow.com/questions/68050125/gitlab-runner-prepare-environment-failed-to-start-process-pwsh-in-windows).*
- *[Instalação MAVEN](http://luizricardo.org/2014/06/instalando-configurando-e-usando-o-maven-para-gerenciar-suas-dependencias-e-seus-projetos-java/).*

​	

