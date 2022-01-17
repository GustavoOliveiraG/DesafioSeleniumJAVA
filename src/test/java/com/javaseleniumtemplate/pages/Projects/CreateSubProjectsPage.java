package com.javaseleniumtemplate.pages.Projects;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class CreateSubProjectsPage extends PageBase {
    //Mapping
        //Adiconar SubProjetos
    By preencherNameProjeto = By.id("project-name");
    By estadoSelect= By.id("project-status");
    By herdarCategoriasCheckBox = By.xpath("(//span[@class='lbl'])[1]");
    By herdarCategoriasPAICheckBox = By.xpath("(//span[@class='lbl'])[2]");
    By visibilidadeSelect= By.id("project-view-state");
    By preencherDescricao = By.id("project-description");
    By cadastrarProjetoButton = By.xpath("//input[@value='Adicionar projeto']");

    By gerenciarProjetosButton10 = By.linkText("Projeto 010 INSERT query via BANCO");

        //Validar Projeto
    By validarProjetoCadastrado = By.xpath("//a[text()='» SubProjeto 003']");
    By validarProjetoCadastradoNumero = By.xpath("//a[text()='» 123456789']");
    By validarProjetoCadastradosemDescricao = By.xpath("//a[text()='» SubProjeto 004']");
    By validarProjetoCadastradoCaractere = By.xpath("//a[text()='» !@#$%&*']");



    //Actions
        //Criar Projetos
    public void clicarProjeto10(){click(gerenciarProjetosButton10);}

    public void preenhcerNomeSubProjeto(String nomeProjeto){ sendKeys(preencherNameProjeto, nomeProjeto); }
    public void selecionarEstadoSubProjeto(String estado){ sendKeys(estadoSelect, estado); }
    public void clicarHerdarSubCategorias(){
        click(herdarCategoriasCheckBox);
    }
    public void clicarHerdarSubCategoriasPAI(){
        click(herdarCategoriasPAICheckBox);
    }
    public void selecionarVisibilidade(String visibilidade){ sendKeys(visibilidadeSelect, visibilidade); }
    public void preenhcerDescricaoSubProjeto(String descricaoProjeto){ sendKeys(preencherDescricao, descricaoProjeto); }


    public void clicarCadastrarSubProjeto(){click(cadastrarProjetoButton);}

        //Validar usuarios
    public String validarSubProjetoCadastradoSucesso(){ return getText(validarProjetoCadastrado); }
    public String validarSubProjetoCadastradosemDescricao(){ return getText(validarProjetoCadastradosemDescricao); }
    public String validarSubProjetoCadastradoNumero(){ return getText(validarProjetoCadastradoNumero); }
    public String validarSubProjetoCadastradoCaractere(){ return getText(validarProjetoCadastradoCaractere); }





}
