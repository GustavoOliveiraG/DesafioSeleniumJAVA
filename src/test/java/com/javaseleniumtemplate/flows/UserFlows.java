package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.Tasks.CreateTasksPage;
import com.javaseleniumtemplate.pages.Usuario.CreateAccountPage;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.Usuario.MyAccountPage;

public class UserFlows {
    //Objects and constructor
    LoginPage loginPage;
    LoginFlows loginFlows;
    MyAccountPage myAccountPage;
    CreateAccountPage createAccountPage;


    public UserFlows(){
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        myAccountPage = new MyAccountPage();
        createAccountPage = new CreateAccountPage();
    }

    //Flows
    public void cadastrarUsuarioNovo(String nomeUser, String nivelAcesso){
        loginFlows.efetuarLogin("administrator", "root");
        myAccountPage.clicarConvidarUsuario();
        createAccountPage.preenhcerNomeUsuario(nomeUser);
        createAccountPage.preenhcerNomeVerdadeiro(nomeUser+"_Base2");
        createAccountPage.preenhcerEmail(nomeUser+"@base2.com.br");
        createAccountPage.selecionarNivelAcesso(nivelAcesso);
        createAccountPage.clicarProtegido();
        createAccountPage.clicarCadastrar();
    }

    public void acessarCadastrodeUsuario(){
        loginFlows.efetuarLogin("administrator", "root");
        myAccountPage.clicarConvidarUsuario();
    }













}
