package com.javaseleniumtemplate.pages.Projects;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class CreateProjectsPage extends PageBase {
    //Mapping
        //Adiconar usuarios
    By preencherNameProjeto = By.id("project-name");
    By estadoSelect= By.id("project-status");
    By herdarCategoriasCheckBox = By.xpath("(//span[@class='lbl'])[1]");
    By visibilidadeSelect= By.id("project-view-state");
    By preencherDescricao = By.id("project-description");


    By cadastrarProjetoButton = By.xpath("//input[@value='Adicionar projeto']");


        //Validar Projeto
    By validarProjetoCadastrado = By.xpath("//a[text()='Projeto 001']");




    //Actions
        //Criar Projetos
    public void preenhcerNomeProjeto(String nomeProjeto){ sendKeys(preencherNameProjeto, nomeProjeto); }
    public void selecionarEstadoProjeto(String estado){ sendKeys(estadoSelect, estado); }
    public void clicarHerdarCategorias(){
        click(herdarCategoriasCheckBox);
    }
    public void selecionarVisibilidade(String visibilidade){ sendKeys(visibilidadeSelect, visibilidade); }
    public void preenhcerDescricaoProjeto(String descricaoProjeto){ sendKeys(preencherDescricao, descricaoProjeto); }


    public void clicarCadastrarProjeto(){click(cadastrarProjetoButton);}

        //Validar usuarios
    public String validarProjetoCadastradoSucesso(){ return getText(validarProjetoCadastrado); }





}
