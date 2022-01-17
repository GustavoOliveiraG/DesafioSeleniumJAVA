package com.javaseleniumtemplate.pages.Projects;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class EditProjectPage extends PageBase {
    //Mapping
        //Selecionar Usuario
    By gerenciarProjetosButton = By.linkText("Projeto 001 INSERT query via BANCO");
    By gerenciarProjetosButton4 = By.linkText("Projeto 004 INSERT query via BANCO");
    By gerenciarProjetosButton5 = By.linkText("Projeto 005 INSERT query via BANCO");
    By gerenciarProjetosButton6 = By.linkText("Projeto 006 INSERT query via BANCO");
    By gerenciarProjetosButton7 = By.linkText("Projeto 007 INSERT query via BANCO");
    By gerenciarProjetosButton8 = By.linkText("Projeto 008 INSERT query via BANCO");
    By gerenciarProjetosButton9 = By.linkText("Projeto 009 INSERT query via BANCO");
    By gerenciarProjetosButton20 = By.linkText("Projeto 020 INSERT query via BANCO");

    By preencherNameProjeto = By.id("project-name");
    By estadoSelect= By.id("project-status");
    By habilitarCheckBox = By.xpath("(//span[@class='lbl'])[1]");
    By herdarCategoriasCheckBox = By.xpath("(//span[@class='lbl'])[2]");
    By visibilidadeSelect= By.id("project-view-state");
    By preencherDescricao = By.id("project-description");

    By editarProjetoButton = By.xpath("//input[@value='Atualizar Projeto']");
    By excluirProjetoButton = By.xpath("//input[@value='Apagar Projeto']");

    By validarNameEditado = By.linkText("Projeto 001 - EDITADO");
    By validarEstadoEditado = By.xpath("//td[text()='obsoleto']");
    By validarVisibilidadeEditado = By.xpath("//td[text()='privado']");
    By validarDescricaoEditado = By.xpath("//td[text()='aaabbb111']");
    By validarHabilitadoEditado = By.xpath("//i[@class=\"fa fa-check fa-lg\"]");
    By validarExclusao =By.linkText("Projeto 009 INSERT query via BANCO");
    By ProjetoSemName =By.id("Projeto 009 INSERT query via BANCO");




    //Actions
    //Criar Projetos
    public void clicarProjeto(){click(gerenciarProjetosButton);}
    public void clicarProjeto4(){click(gerenciarProjetosButton4);}
    public void clicarProjeto5(){click(gerenciarProjetosButton5);}
    public void clicarProjeto6(){click(gerenciarProjetosButton6);}
    public void clicarProjeto7(){click(gerenciarProjetosButton7);}
    public void clicarProjeto8(){click(gerenciarProjetosButton8);}
    public void clicarProjeto9(){click(gerenciarProjetosButton9);}
    public void clicarProjeto20(){click(gerenciarProjetosButton20);}

    public void preenhcerNomeProjeto(String nomeProjeto){ clearAndSendKeys(preencherNameProjeto, nomeProjeto); }
    public void selecionarEstadoProjeto(String estado){ sendKeys(estadoSelect, estado); }
    public void clicarhabilitar(){
        click(habilitarCheckBox);
    }
    public void clicarHerdarCategorias(){
        click(herdarCategoriasCheckBox);
    }
    public void selecionarVisibilidade(String visibilidade){ sendKeys(visibilidadeSelect, visibilidade); }
    public void preenhcerDescricaoProjeto(String descricaoProjeto){ clearAndSendKeys(preencherDescricao,descricaoProjeto);}


    public void clicarSalvarProjeto(){click(editarProjetoButton);}
    public void clicarExcluirProjeto(){click(excluirProjetoButton);}

    //Validar Projeto
    public String validarProjetoeditadoSucesso(){ return getText(validarNameEditado); }
    public String validarEstadoProjetoeditado(){ return getText(validarEstadoEditado); }
    public String validarVisibilidadeProjetoeditado(){ return getText(validarVisibilidadeEditado); }
    public String validarDescricaoProjetoeditado(){ return getText(validarDescricaoEditado); }
    public String validarHabilitadoProjetoeditado(){ return getText(validarHabilitadoEditado); }
    public String validarExclusao(){ return getText(validarExclusao); }


}
