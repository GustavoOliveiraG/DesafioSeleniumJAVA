package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;

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


}
