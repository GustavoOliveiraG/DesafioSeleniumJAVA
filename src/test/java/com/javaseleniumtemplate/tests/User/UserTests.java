package com.javaseleniumtemplate.tests.User;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.flows.UserFlows;
import com.javaseleniumtemplate.pages.Usuario.CreateAccountPage;
import com.javaseleniumtemplate.pages.Usuario.EditAccountPage;
import com.javaseleniumtemplate.pages.Usuario.MyAccountPage;
import com.javaseleniumtemplate.utils.DriverFactory;
import com.javaseleniumtemplate.utils.ExcelUtils;
import com.javaseleniumtemplate.utils.ReadingCSVUtils;
import com.javaseleniumtemplate.utils.Recording;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserTests extends TestBase {
    //Objects
    ExcelUtils excelUtils;
    LoginFlows loginFlows;
    UserFlows userFlows;
    CreateAccountPage createAccountPage;
    EditAccountPage editAccountPage;
    MyAccountPage myAccountPage;
    Recording recording;

    //Cadastro Novo Usuario
    @Test
    public void cadastrarUsuarioNovo() throws Exception {
        //Objects instances
        userFlows = new UserFlows();
        createAccountPage = new CreateAccountPage();
        recording = new Recording();

        //Parameteres
        String name = "Usuario001";
        String nivelAcesso = "visualizador";

        //Test
        recording.startMove();
        userFlows.cadastrarUsuarioNovo(name, nivelAcesso);
        Assert.assertEquals(createAccountPage.validarUsuarioCadastradoSucesso(),"Usuário "+name+" criado com um nível de acesso de "+nivelAcesso+"");
        recording.stopMove();

        //Print HTML da Page
        /*
        Thread.sleep(1000);
        System.out.println( DriverFactory.INSTANCE.getPageSource());
        */
    }
    //Teste acima, com gravaçao de video e Print na INSTACIA

    @Test
    public void naoCadastrarUsuarioNomeIgual() {
        //Objects instances
        userFlows = new UserFlows();
        createAccountPage = new CreateAccountPage();
        myAccountPage = new MyAccountPage();

        //Parameteres
        String name = "UsuarioNomeIgual";
        String nivelAcesso = "visualizador";

        //Test
        userFlows.cadastrarUsuarioNovo(name, nivelAcesso);
        Assert.assertEquals(createAccountPage.validarUsuarioCadastradoSucesso(),"Usuário "+name+" criado com um nível de acesso de "+nivelAcesso+"");
        myAccountPage.clicarConvidarUsuario();
        createAccountPage.preenhcerNomeUsuario(name);
        createAccountPage.preenhcerNomeVerdadeiro(name+"_Base2");
        createAccountPage.preenhcerEmail(name+"@base2.com.br");
        createAccountPage.selecionarNivelAcesso(nivelAcesso);
        createAccountPage.clicarProtegido();
        createAccountPage.clicarCadastrar();
        Assert.assertEquals(createAccountPage.validarUsuarioCadastradoNomeIgual(),"Este nome de usuário já está sendo usado. Por favor, volte e selecione um outro.");
    }

    @Test
    public void cadastrarUsuarioSemNome() throws Exception {
        //Objects instances
        userFlows = new UserFlows();
        createAccountPage = new CreateAccountPage();

        //Parameteres
        String name = "";
        String nivelAcesso = "visualizador";

        //Test
        userFlows.cadastrarUsuarioNovo(name, nivelAcesso);

        Assert.assertEquals(createAccountPage.validarUsuarioSemNome(),"APPLICATION ERROR #805");

    }

    @Test
    public void cadastrarUsuarioNumeroNome() throws Exception {
        //Objects instances
        userFlows = new UserFlows();
        createAccountPage = new CreateAccountPage();

        //Parameteres
        String name = "123456789";
        String nivelAcesso = "visualizador";

        //Test
        userFlows.cadastrarUsuarioNovo(name, nivelAcesso);

        Assert.assertEquals(createAccountPage.validarUsuarioCadastradoSucesso(),"Usuário "+name+" criado com um nível de acesso de "+nivelAcesso+"");

    }

    @Test
    public void cadastrarUsuarioCaractereEspecialNome() throws Exception {
        //Objects instances
        userFlows = new UserFlows();
        createAccountPage = new CreateAccountPage();

        //Parameteres
        String name = "!@#$%&*";
        String nivelAcesso = "visualizador";

        //Test
        userFlows.cadastrarUsuarioNovo(name, nivelAcesso);

        Assert.assertEquals(createAccountPage.validarUsuarioSemNome(),"APPLICATION ERROR #805");
    }


    @Test(dataProvider = "dataAddUserCSVProvider", dataProviderClass = ReadingCSVUtils.class)
    public void cadastrarUsuariosNovosDDTCSV(String[] userData) {
        //Objects instances
        userFlows = new UserFlows();
        createAccountPage = new CreateAccountPage();

        //Parameteres
        String name = userData[0];
        String nivelAcesso = userData[1];

        //Test
        userFlows.cadastrarUsuarioNovo(name, nivelAcesso);
        Assert.assertEquals(createAccountPage.validarUsuarioCadastradoSucesso(),"Usuário "+name+" criado com um nível de acesso de "+nivelAcesso+"");
    }

    @Test
    public void cadastrarUsuariosNovosDDTEXCEL() throws IOException {
        //Parametros Excel
        String excelPath = "src/test/java/resources/addUserEXCEL.xlsx";
        String sheetName = "Usuarios";
        excelUtils  = new ExcelUtils(excelPath, sheetName);
        int tam = ExcelUtils.getRowCount();

        //Objects instances
        userFlows = new UserFlows();
        createAccountPage = new CreateAccountPage();
        loginFlows = new LoginFlows();

        for (int x = 1; x < tam; x++) {
            //Parameteres
            String name = ExcelUtils.getCellData(x, 0).toString();
            String nivelAcesso = ExcelUtils.getCellData(x, 1).toString();

            //Test
            userFlows.cadastrarUsuarioNovo(name, nivelAcesso);
            Assert.assertEquals(createAccountPage.validarUsuarioCadastradoSucesso(), "Usuário " + name + " criado com um nível de acesso de " + nivelAcesso + "");
            loginFlows.exitLogin();
        }

    }




    //Editar Usuario
    @Test
    public void editarNomeUsuario() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String nameeditado = "Usuario-EDITADO";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioSelecionado();
        editAccountPage.editarNomeusuario(nameeditado);
        editAccountPage.clicarProtegido();
        editAccountPage.clicarAtualizarUsuario();
        editAccountPage.clicarGerenciarUsuario();

        Assert.assertEquals(editAccountPage.validarUsuarioEditadoSucesso(),nameeditado);

    }

    @Test
    public void editarNomeVerdadeiroUsuario() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String nameRealeditado = "Usuario EDITADO com Sucesso";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioEditar2Selecionado();
        editAccountPage.editarNomeRealUsuario(nameRealeditado);
        editAccountPage.clicarProtegido();
        editAccountPage.clicarAtualizarUsuario();
        editAccountPage.clicarGerenciarUsuario();

        Assert.assertEquals(editAccountPage.validarUsuarioNameRealEditadoSucesso(),nameRealeditado);

    }

    @Test
    public void editarEmailUsuario() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String emailEditado = "usuarioEmail.EDITADO@base2.com.br";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioEditar2Selecionado();
        editAccountPage.editarEmailUsuario(emailEditado);
        editAccountPage.clicarProtegido();
        editAccountPage.clicarAtualizarUsuario();
        editAccountPage.clicarGerenciarUsuario();

        Assert.assertEquals(editAccountPage.validarUsuarioEmailEditadoSucesso(),emailEditado);

    }

    @Test
    public void editarnivelUsuario() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String nivelEditado = "desenvolvedor";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioNivelSelecionado();
        editAccountPage.editarNivelAcesso(nivelEditado);
        editAccountPage.clicarProtegido();
        editAccountPage.clicarAtualizarUsuario();
        editAccountPage.clicarGerenciarUsuario();

        Assert.assertEquals(editAccountPage.validarNivelEditadoSucesso(),nivelEditado);

    }

    @Test
    public void editarUsuarioProtegido() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String msgProtegido = "Conta protegida. Os campos \"Nível de acesso\" e \"ativado\" não podem ser modificados. Os demais campos foram atualizados com sucesso.";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioProtegido();
        editAccountPage.clicarProtegido();
        editAccountPage.clicarAtualizarUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioProtegido();
        editAccountPage.editarNomeusuario("Tentar Mudar Nome");
        editAccountPage.clicarAtualizarUsuario();

        Assert.assertEquals(editAccountPage.validarProtegido(),msgProtegido);

    }

    @Test
    public void editarUsuarioProtegidoNivel() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String msgProtegido = "Conta protegida. Os campos \"Nível de acesso\" e \"ativado\" não podem ser modificados. Os demais campos foram atualizados com sucesso.";
        String nivelEditado = "gerente";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioProtegido2();
        editAccountPage.editarNivelAcesso(nivelEditado);
        editAccountPage.clicarAtualizarUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioProtegido2();
        editAccountPage.clicarProtegido();
        editAccountPage.clicarAtualizarUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioProtegido2();
        editAccountPage.editarNivelAcesso("desenvolvedor");
        editAccountPage.clicarAtualizarUsuario();

        Assert.assertEquals(editAccountPage.validarProtegido(),msgProtegido);

        editAccountPage.clicarGerenciarUsuario();
        Assert.assertEquals(editAccountPage.validarNivelProtegido(),nivelEditado);

    }

    @Test
    public void editarNomeUsuarioVazio() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String nameeditado = "";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioNivelSelecionado();
        editAccountPage.editarNomeusuario(nameeditado);
        editAccountPage.clicarAtualizarUsuario();


        //Assert.assertEquals(createAccountPage.validarUsuarioEditarSemNome(),"APPLICATION ERROR #800");

    }




    //Representar Usuario
    @Test
    public void representarUsuario() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String nome = "Usuario-Representar ( Usuario para Representar )";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioRepresentarSelecionado();
        editAccountPage.clicarRepresentar();
        editAccountPage.clicarProsseguir();

        Assert.assertEquals(editAccountPage.validarUsuarioRepresentadoSucesso(),nome);

    }




    //Excluir Usuario
    @Test
    public void excluirUsuarioSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();

        //Parameteres
        String validaTeste = "Operação realizada com sucesso.";

        //Test
        userFlows.acessarCadastrodeUsuario();
        editAccountPage.clicarGerenciarUsuario();
        editAccountPage.clicarUsuarioExcluirSelecionado();
        editAccountPage.clicarApagarUsuario();
        editAccountPage.clicarConfirmarApagarusuario();

        Assert.assertEquals(editAccountPage.validarUsuarioExcluidoSucesso(),validaTeste);
    }





}
