package com.javaseleniumtemplate.pages.Projects;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class EditSubProjectsPage extends PageBase {
    //Mapping
        //Adiconar SubProjetos
    By gerenciarSubProjetosButton2 = By.linkText("» SubProjeto 02");
    By gerenciarSubProjetosButton3 = By.linkText("» SubProjeto 03");
    By gerenciarSubProjetosButton4 = By.linkText("» SubProjeto 04");
    By gerenciarSubProjetosButton5 = By.linkText("» SubProjeto 05");
    By gerenciarSubProjetosButton6 = By.linkText("» SubProjeto 06");
    By gerenciarSubProjetosButton10 = By.linkText("» SubProjeto 10");
    By gerenciarSubProjetosButton11 = By.linkText("» SubProjeto 11");
    By preencherNameSubProjeto = By.id("project-name");
    By estadoSelect= By.id("project-status");
    By habilitarCheckBox = By.xpath("(//span[@class='lbl'])[1]");
    By visibilidadeSelect= By.id("project-view-state");
    By preencherDescricao = By.id("project-description");

    //p[text()='Um projeto com este nome já existe.  Por favor, volte e entre um nome diferente.']


        //Validar SubProjeto
    By validarNameSubProjeto = By.xpath("//a[text()='» SubEditado']");
    By validarEstadoEditado = By.xpath("//td[text()='release']");
    By validarHabilitadoEditado = By.xpath("//i[@class=\"fa fa-check fa-lg\"]");
    By validarVisibilidadeEditado = By.xpath("//td[text()='privado']");
    By validarDescricaoEditado = By.xpath("//td[text()='111BBBAAA']");
    By validarSubProjetoDuplicado = By.xpath("//p[text()='APPLICATION ERROR #701']");


    By cadastrarSubProjetoButton = By.xpath("//input[@value='Atualizar Projeto']");
    By excluirrSubProjetoButton = By.xpath("//input[@value='Apagar Projeto']");



    //Actions
        //Editar SubProjetos
    public void clicarSubProjeto02(){click(gerenciarSubProjetosButton2);}
    public void clicarSubProjeto03(){click(gerenciarSubProjetosButton3);}
    public void clicarSubProjeto04(){click(gerenciarSubProjetosButton4);}
    public void clicarSubProjeto05(){click(gerenciarSubProjetosButton5);}
    public void clicarSubProjeto06(){click(gerenciarSubProjetosButton6);}
    public void clicarSubProjeto10(){click(gerenciarSubProjetosButton10);}
    public void clicarSubProjeto11(){click(gerenciarSubProjetosButton11);}

    public void preenhcerNomeSubProjeto(String nomeProjeto){ clearAndSendKeys(preencherNameSubProjeto, nomeProjeto); }
    public void selecionarEstadoSubProjeto(String estado){ sendKeys(estadoSelect, estado); }
    public void clicarhabilitar(){
        click(habilitarCheckBox);
    }
    public void selecionarVisibilidade(String visibilidade){ sendKeys(visibilidadeSelect, visibilidade); }
    public void preenhcerDescricaoSubProjeto(String descricaoProjeto){ clearAndSendKeys(preencherDescricao, descricaoProjeto); }

    public void clicarCadastrarSubProjeto(){click(cadastrarSubProjetoButton);}
    public void clicarExcluirSubProjeto(){click(excluirrSubProjetoButton);}

    //Validar usuarios
    public String validarSubProjetoCadastradoSucesso(){ return getText(validarNameSubProjeto); }
    public String validarEstadoSubProjetoeditado(){ return getText(validarEstadoEditado); }
    public String validarHabilitadoSubProjetoeditado(){ return getText(validarHabilitadoEditado); }
    public String validarVisibilidadeSubProjetoeditado(){ return getText(validarVisibilidadeEditado); }
    public String validarDescricaoSubProjetoeditado(){ return getText(validarDescricaoEditado); }
    public String validarNameProjetoIgual(){ return getText(validarSubProjetoDuplicado); }
















}
