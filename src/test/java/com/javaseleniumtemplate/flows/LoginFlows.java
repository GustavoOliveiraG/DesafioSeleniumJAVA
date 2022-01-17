package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.Tasks.CreateTasksPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;
    CreateTasksPage createTasksPage;

    public LoginFlows(){
        loginPage = new LoginPage();
    }

    //Flows
    public void efetuarLogin(String user, String senha){
        loginPage.preenhcerUsuario(user);
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha(senha);
        loginPage.clicarEmEntrar();
    }

    public void exitLogin(){
        loginPage.clicarEmAdm();
        loginPage.clicarEmSair();
    }

    public void acessarSistema(){
        loginPage.preenhcerUsuario("administrator");
        loginPage.clicarEmEntrar();
        loginPage.preencherSenha("root");
        loginPage.clicarEmEntrar();
    }


}
