package com.javaseleniumtemplate.pages.Usuario;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class EditAccountPage extends PageBase {
    //Mapping
        //Selecionar Usuario
    By gerenciasUsuariosButton = By.linkText("Gerenciar Usuários");
    By selecionarUsuariosButton = By.linkText("Usuario-Editar");
    By selecionarUsuariosNomeRealButton = By.linkText("Usuario-Editar2");
    By selecionarUsuariosRepresentarButton = By.linkText("Usuario-Representar");
    By selecionarUsuariosExcluir = By.linkText("Usuario-Excluir");
    By selecionarUsuariosNivel = By.linkText("Usuario-Nivel");
    By selecionarUsuarioProtegido = By.linkText("Usuario-Protegido");
    By selecionarUsuarioProtegido2 = By.linkText("Usuario-Protegido2");

        //Editar Usuarios
    By editarUserName = By.id("edit-username");
    By editarUserNameReal = By.id("edit-realname");
    By editarEmail = By.id("email-field");
    By editnivelAcesso= By.id("edit-access-level");
    By editarprotegidoCheckBox = By.xpath("(//span[@class='lbl'])[2]");

        //Gravar Edicao
    By gravarAtualizacaoButton = By.xpath("//input[@value='Atualizar Usuário']");

        //Validacao Usuario
    By validarNameEditado = By.linkText("Usuario-EDITADO");
    By validarNameRealEditado = By.xpath("//td[text()='Usuario EDITADO com Sucesso']");
    By validarEmailEditado = By.xpath("//td[text()='usuarioEmail.EDITADO@base2.com.br']");
    By validarNivelEditado = By.xpath("//td[text()='desenvolvedor']");
    By validarNivelprotegido = By.xpath("//td[text()='gerente']");
    By validarProtegido = By.xpath("//p[text()='Conta protegida. Os campos \"Nível de acesso\" e \"ativado\" não podem ser modificados. Os demais campos foram atualizados com sucesso.']");


    //Excluir Usuario
    By excluiUsuarioButton = By.xpath("//input[@value='Apagar Usuário']");
    By ExcluiUsuarioConfirmaButton = By.xpath("//input[@value='Apagar Conta']");
        //Validar Exclusao
    By validarExclusao = By.xpath("//p[text()='Operação realizada com sucesso.']");


    //Representar
    By representarButton = By.xpath("//input[@value='Representar Usuário']");
    By prosseguirButton = By.xpath("//a[text()='Clique aqui para prosseguir']");
        //Valida Representar
    By validarUsuarioRepresentado = By.xpath("//a[text()='Usuario-Representar ( Usuario para Representar ) ']");


    //Actions
        //Selecionar Usuario
    public void clicarGerenciarUsuario(){click(gerenciasUsuariosButton);}
    public void clicarUsuarioSelecionado(){ click(selecionarUsuariosButton); }
    public void clicarUsuarioEditar2Selecionado(){ click(selecionarUsuariosNomeRealButton); }
    public void clicarUsuarioRepresentarSelecionado(){ click(selecionarUsuariosRepresentarButton); }
    public void clicarUsuarioExcluirSelecionado(){ click(selecionarUsuariosExcluir); }
    public void clicarUsuarioNivelSelecionado(){ click(selecionarUsuariosNivel); }
    public void clicarUsuarioProtegido(){ click(selecionarUsuarioProtegido); }
    public void clicarUsuarioProtegido2(){ click(selecionarUsuarioProtegido2); }

        //Editar usuario
    public void editarNomeusuario(String nomeNovoUsuario){ clearAndSendKeys(editarUserName,nomeNovoUsuario);}
    public void editarNomeRealUsuario(String nomeNovoRealUsuario){ clearAndSendKeys(editarUserNameReal,nomeNovoRealUsuario);}
    public void editarEmailUsuario(String novoEmailUsuario){ clearAndSendKeys(editarEmail,novoEmailUsuario);}
    public void editarNivelAcesso(String nivelAcesso){ sendKeys(editnivelAcesso, nivelAcesso); }
    public void clicarProtegido(){ click(editarprotegidoCheckBox);}
    public void clicarAtualizarUsuario(){click(gravarAtualizacaoButton);}

        //Validacao Edicao
    public String validarUsuarioEditadoSucesso(){ return getText(validarNameEditado); }
    public String validarUsuarioNameRealEditadoSucesso(){ return getText(validarNameRealEditado); }
    public String validarUsuarioEmailEditadoSucesso(){ return getText(validarEmailEditado); }
    public String validarNivelEditadoSucesso(){ return getText(validarNivelEditado); }
    public String validarProtegido(){ return getText(validarProtegido); }
    public String validarNivelProtegido(){ return getText(validarNivelprotegido); }



        //Excluir Usuario
    public void clicarApagarUsuario(){ click(excluiUsuarioButton);}
    public void clicarConfirmarApagarusuario(){ click(ExcluiUsuarioConfirmaButton);}

        //Validacao Exclusao
    public String validarUsuarioExcluidoSucesso(){ return getText(validarExclusao); }



        //Representar Usuario
    public void clicarRepresentar(){ click(representarButton);}
    public void clicarProsseguir(){ click(prosseguirButton);}
    public String validarUsuarioRepresentadoSucesso(){ return getText(validarUsuarioRepresentado); }


}
