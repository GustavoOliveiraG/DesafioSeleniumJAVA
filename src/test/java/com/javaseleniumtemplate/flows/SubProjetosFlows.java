package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.Projects.CreateProjectsPage;
import com.javaseleniumtemplate.pages.Projects.CreateSubProjectsPage;
import com.javaseleniumtemplate.pages.Projects.EditProjectPage;
import com.javaseleniumtemplate.pages.Projects.EditSubProjectsPage;
import com.javaseleniumtemplate.pages.Usuario.EditAccountPage;
import com.javaseleniumtemplate.pages.Usuario.MyAccountPage;
import com.javaseleniumtemplate.utils.ExcelUtils;

public class SubProjetosFlows {
    //Objects and constructor
    LoginPage loginPage;
    ExcelUtils excelUtils;
    LoginFlows loginFlows;
    UserFlows userFlows;
    CreateProjectsPage createProjectsPage;
    EditAccountPage editAccountPage;
    MyAccountPage myAccountPage;
    EditProjectPage editProjectPage;
    CreateSubProjectsPage createSubProjectsPage;
    EditSubProjectsPage editSubProjectsPage;

    public SubProjetosFlows(){
        loginPage = new LoginPage();
    }

    //Flows
    public void CadastrarSubProjeto(){
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 03 - Flow");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarHerdarSubCategorias();
        createSubProjectsPage.clicarHerdarSubCategoriasPAI();
        createSubProjectsPage.selecionarVisibilidade("público");
        createSubProjectsPage.preenhcerDescricaoSubProjeto("SubProjetoFlow");
        createSubProjectsPage.clicarCadastrarSubProjeto();
    }




}
