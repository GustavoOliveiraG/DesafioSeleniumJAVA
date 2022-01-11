package com.javaseleniumtemplate.pages.Usuario;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class CreateAccountPage extends PageBase {
    //Mapping
        //Adiconar usuarios
    By preencherUserName = By.id("user-username");
    By preencherUserNameOriginal = By.id("user-realname");
    By preencherUserEmail= By.id("email-field");
    By nivelAcessoSelect= By.id("user-access-level");
    By createHability = By.id("");
    By protegidoCheckBox = By.xpath("(//span[@class='lbl'])[2]");
    By cadastrarButton = By.xpath("//input[@value='Criar Usuário']");

        //ValidarUsuarios
    By validarUsuarioSucesso = By.xpath("//p[text()=' criado com um nível de acesso de ']");
    By erroCadastrousuario = By.xpath("//p[text()='Este nome de usuário já está sendo usado.  Por favor, volte e selecione um outro.']");




    //Actions
        //Criar Usuarios
    public void preenhcerNomeUsuario(String nomeUsuario){ sendKeys(preencherUserName, nomeUsuario); }
    public void preenhcerNomeVerdadeiro(String nomeUsuarioVerdadeiro){ sendKeys(preencherUserNameOriginal, nomeUsuarioVerdadeiro); }
    public void preenhcerEmail(String usuarioEmail){ sendKeys(preencherUserEmail, usuarioEmail); }
    public void selecionarNivelAcesso(String nivelAcesso){ sendKeys(nivelAcessoSelect, nivelAcesso); }
    public void clicarProtegido(){
        click(protegidoCheckBox);
    }
    public void clicarCadastrar(){
        click(cadastrarButton);
    }

        //Validar usuarios
    public String validarUsuarioCadastradoSucesso(){ return getText(validarUsuarioSucesso); }
    public String validarUsuarioCadastradoNomeIgual(){ return getText(erroCadastrousuario); }





}
