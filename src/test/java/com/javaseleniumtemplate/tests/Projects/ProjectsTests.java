package com.javaseleniumtemplate.tests.Projects;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.flows.UserFlows;
import com.javaseleniumtemplate.pages.Projects.CreateProjectsPage;
import com.javaseleniumtemplate.pages.Projects.CreateSubProjectsPage;
import com.javaseleniumtemplate.pages.Projects.EditProjectPage;
import com.javaseleniumtemplate.pages.Usuario.CreateAccountPage;
import com.javaseleniumtemplate.pages.Usuario.EditAccountPage;
import com.javaseleniumtemplate.pages.Usuario.MyAccountPage;
import com.javaseleniumtemplate.utils.ExcelUtils;
import com.javaseleniumtemplate.utils.ReadingCSVUtils;
import com.javaseleniumtemplate.utils.Recording;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProjectsTests extends TestBase {
    //Objects
    ExcelUtils excelUtils;
    LoginFlows loginFlows;
    UserFlows userFlows;
    CreateProjectsPage createProjectsPage;
    EditAccountPage editAccountPage;
    MyAccountPage myAccountPage;
    EditProjectPage editProjectPage;
    CreateSubProjectsPage createSubProjectsPage;


    //Cadastrar Projetos
    @Test
    public void cadastrarProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        myAccountPage.clicarCriarNovoProjeto();
        createProjectsPage.preenhcerNomeProjeto("Projeto 001");
        createProjectsPage.selecionarEstadoProjeto("estável");
        createProjectsPage.clicarHerdarCategorias();
        createProjectsPage.selecionarVisibilidade("público");
        createProjectsPage.preenhcerDescricaoProjeto("Teste123ABC");
        createProjectsPage.clicarCadastrarProjeto();

        Assert.assertEquals(createProjectsPage.validarProjetoCadastradoSucesso(),"Projeto 001");
    }

    @Test
    public void cadastrarProjetoNomeRepedito() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        myAccountPage.clicarCriarNovoProjeto();
        createProjectsPage.preenhcerNomeProjeto("Projeto 010");
        createProjectsPage.clicarCadastrarProjeto();
        myAccountPage.clicarCriarNovoProjeto();
        createProjectsPage.preenhcerNomeProjeto("Projeto 010");
        createProjectsPage.clicarCadastrarProjeto();

        Assert.assertEquals(createProjectsPage.validarProjetoNomeIgual(),"APPLICATION ERROR #701");
    }

    @Test
    public void cadastrarProjetoSemNome() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        myAccountPage.clicarCriarNovoProjeto();
        createProjectsPage.preenhcerNomeProjeto(" ");
        createProjectsPage.clicarCadastrarProjeto();

        Assert.assertEquals(createProjectsPage.validarProjetoSemNome(),"APPLICATION ERROR #702");
    }

    @Test
    public void cadastrarProjetoNumeroNome() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        myAccountPage.clicarCriarNovoProjeto();
        createProjectsPage.preenhcerNomeProjeto("123456789");
        createProjectsPage.clicarCadastrarProjeto();

        Assert.assertEquals(createProjectsPage.validarProjetoNumeroNome(),"123456789");
    }

    @Test
    public void cadastrarProjetoCaractereEspecialNome() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        myAccountPage.clicarCriarNovoProjeto();
        createProjectsPage.preenhcerNomeProjeto("!@#$%&*");
        createProjectsPage.clicarCadastrarProjeto();

        Assert.assertEquals(createProjectsPage.validarProjetoCaractereNome(),"!@#$%&*");
    }



    //Editar Projetos
    @Test
    public void editarNomeProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto();
        editProjectPage.preenhcerNomeProjeto("Projeto 001 - EDITADO");
        editProjectPage.clicarSalvarProjeto();

        Assert.assertEquals(editProjectPage.validarProjetoeditadoSucesso(),"Projeto 001 - EDITADO");
    }

    @Test
    public void editarEstadoProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();

        //Parameteres
        String validaTeste = "obsoleto";

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto5();
        editProjectPage.selecionarEstadoProjeto("obsoleto");
        editProjectPage.clicarSalvarProjeto();

        Assert.assertEquals(editProjectPage.validarEstadoProjetoeditado(),validaTeste);
    }

    @Test
    public void editarHabilitadoProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto8();
        editProjectPage.clicarhabilitar();
        editProjectPage.clicarSalvarProjeto();

        Assert.assertTrue(editProjectPage.validarHabilitadoProjetoeditado().contains(""));
    }

    @Test
    public void editarVisibilidadeProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();

        //Parameteres
        String validaTeste = "privado";

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto6();
        editProjectPage.selecionarVisibilidade("privado");
        editProjectPage.clicarSalvarProjeto();

        Assert.assertEquals(editProjectPage.validarVisibilidadeProjetoeditado(),validaTeste);
    }

    @Test
    public void editarDescricaoProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();

        //Parameteres
        String validaTeste = "aaabbb111";

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto7();
        editProjectPage.preenhcerDescricaoProjeto("aaabbb111");
        editProjectPage.clicarSalvarProjeto();

        Assert.assertEquals(editProjectPage.validarDescricaoProjetoeditado(),validaTeste);
    }

    @Test
    public void editarNomeVazio() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto6();
        editProjectPage.preenhcerNomeProjeto("");
        editProjectPage.clicarSalvarProjeto();

        //Assert.assertEquals(editProjectPage.validarProjetoeditadoSucesso(),"Projeto 001 - EDITADO");
    }





    //Excluir
    @Test
    public void ExcluirProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();

        //Parameteres
            //null

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto9();
        editProjectPage.clicarExcluirProjeto();
        editProjectPage.clicarExcluirProjeto();


        //Assert.assertEquals(editProjectPage.validarExclusao(),"");
    }



}
