package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.Usuario.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    LoginFlows loginFlows;
    MyAccountPage myAccountPage;

    @Test
    public void efetuarLoginComSucesso(){
        //Objects instances
        loginFlows = new LoginFlows();
        myAccountPage = new MyAccountPage();

        //Parameteres

        //Test
        loginFlows.efetuarLogin("administrator", "root");
        Assert.assertEquals(myAccountPage.retornaUsernameLogado(),"administrador");
    }

    @Test
    public void bloquearLoginUsuarioNaoCadastrado(){
        //Objects instances
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        myAccountPage = new MyAccountPage();

        //Parameteres

        //Test
        loginFlows.efetuarLogin("Usuario", "123456");
        Assert.assertEquals(loginPage.retornaMsgErro(),"Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.");
    }

    @Test
    public void efetuarLogOFFComSucesso(){
        //Objects instances
        loginFlows = new LoginFlows();
        myAccountPage = new MyAccountPage();
        loginPage = new LoginPage();

        //Parameteres

        //Test
        loginFlows.efetuarLogin("administrator", "root");
        Assert.assertEquals(myAccountPage.retornaUsernameLogado(),"administrador");
       loginFlows.exitLogin();
    }

    @Test
    public void efetuarLoginComSucessoUtilizandoJS(){
        //Objects instances
        myAccountPage = new MyAccountPage();
        loginPage = new LoginPage();

        //Parameteres

        //Test
        loginPage.preenhcerUsuarioJS();
        loginPage.clicarEmEntrarJS();
        loginPage.preencherSenhaJS();
        loginPage.clicarEmEntrarJS();

        Assert.assertEquals(myAccountPage.retornaUsernameLogado(),"administrador");
    }


}
