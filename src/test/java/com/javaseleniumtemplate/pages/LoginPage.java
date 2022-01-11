package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By username = By.id("username");
    By password = By.id("password");
    By entrarButton = By.xpath("//input[@value='Entrar']");
    By admButton = By.xpath("//span[text()='administrator']");
    By sairButton = By.xpath("//a[text()=\" Sair\"]");
    By msg = By.xpath("//p[text()='Sua conta pode estar desativada ou bloqueada ou o nome de usuário e a senha que você digitou não estão corretos.']");



    //Actions
    public void preenhcerUsuario(String usuario){ sendKeys(username, usuario); }
    public void preencherSenha(String senha){
        sendKeys(password, senha);
    }
    public String retornaMsgErro(){ return getText(msg); }
    public void clicarEmEntrar(){click(entrarButton);}
    public void clicarEmAdm(){click(admButton);}
    public void clicarEmSair(){click(sairButton);}


    //ActionsJS
    public void preenhcerUsuarioJS(){ SendKeysJavaScript(username, "administrator");}
    public void preencherSenhaJS(){
        SendKeysJavaScript(password, "root");
    }
    public void clicarEmEntrarJS(){ ClickJavaScript(entrarButton);}




}
