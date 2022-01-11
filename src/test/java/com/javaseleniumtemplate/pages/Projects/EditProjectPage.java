package com.javaseleniumtemplate.pages.Projects;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class EditProjectPage extends PageBase {
    //Mapping
        //Selecionar Usuario
    By gerenciarProjetosButton = By.linkText("Projeto 001 INSERT query via BANCO");
    By preencherNameProjeto = By.id("project-name");
    By estadoSelect= By.id("project-status");
    By habilitarCheckBox = By.xpath("(//span[@class='lbl'])[1]");
    By herdarCategoriasCheckBox = By.xpath("(//span[@class='lbl'])[2]");
    By visibilidadeSelect= By.id("project-view-state");
    By preencherDescricao = By.id("project-description");

    By editarProjetoButton = By.xpath("//input[@value='Atualizar Projeto']");
    By excluirProjetoButton = By.xpath("//input[@value='Apagar Projeto']");

    By validarNameEditado = By.linkText("Projeto 001 - EDITADO");



    //Actions
    //Criar Projetos
    public void clicarProjeto(){
        click(gerenciarProjetosButton);
    }

    public void preenhcerNomeProjeto(String nomeProjeto){ clearAndSendKeys(preencherNameProjeto, nomeProjeto); }
    public void selecionarEstadoProjeto(String estado){ sendKeys(estadoSelect, estado); }
    public void clicarhabilitar(){
        click(herdarCategoriasCheckBox);
    }
    public void clicarHerdarCategorias(){
        click(herdarCategoriasCheckBox);
    }
    public void selecionarVisibilidade(String visibilidade){ sendKeys(visibilidadeSelect, visibilidade); }
    public void preenhcerDescricaoProjeto(String descricaoProjeto){ sendKeys(preencherDescricao, descricaoProjeto); }


    public void clicarSalvarProjeto(){click(editarProjetoButton);}
    public void clicarExcluirProjeto(){click(excluirProjetoButton);}

    //Validar Projeto
    public String validarProjetoeditadoSucesso(){ return getText(validarNameEditado); }


}
