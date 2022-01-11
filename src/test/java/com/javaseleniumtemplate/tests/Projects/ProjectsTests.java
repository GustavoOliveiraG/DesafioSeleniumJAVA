package com.javaseleniumtemplate.tests.Projects;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.flows.UserFlows;
import com.javaseleniumtemplate.pages.Projects.CreateProjectsPage;
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
        String validaTeste = "Operação realizada com sucesso.";

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
        String validaTeste = "Operação realizada com sucesso.";

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto();
        editProjectPage.preenhcerNomeProjeto("Projeto 001 - EDITADO");
        editProjectPage.clicarSalvarProjeto();

        Assert.assertEquals(editProjectPage.validarProjetoeditadoSucesso(),"Projeto 001 - EDITADO");
    }




}
