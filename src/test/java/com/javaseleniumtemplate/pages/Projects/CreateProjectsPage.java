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
    By validarProjetoNomeIgual = By.xpath("//p[text()='APPLICATION ERROR #701']");
    By validarProjetoSemNome = By.xpath("//p[text()='APPLICATION ERROR #702']");
    By validarProjetoNumeroNome = By.xpath("//a[text()='» 123456789']");
    By validarProjetoCaractereNome = By.xpath("//a[text()='» !@#$%&*']");

        //SubProjetos
    By cadastrarNovoSubProjeto = By.xpath("//button[text()='Criar novo Subprojeto']");


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
    public String validarProjetoNomeIgual(){ return getText(validarProjetoNomeIgual); }
    public String validarProjetoSemNome(){ return getText(validarProjetoSemNome); }
    public String validarProjetoNumeroNome(){ return getText(validarProjetoNumeroNome); }
    public String validarProjetoCaractereNome(){ return getText(validarProjetoCaractereNome); }

        //SubProjetos
    public void clicarCadastrarSubProjeto(){click(cadastrarNovoSubProjeto);}





}
