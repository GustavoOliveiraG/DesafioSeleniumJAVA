package com.javaseleniumtemplate.pages.Tasks;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class CreateTasksPage extends PageBase {
    //Mapping
        //Tarefas
    By selecionarTarefaoButton = By.xpath("//a[text()=' Criar Tarefa']");
    By projetoTarefaSelect= By.id("select-project-id");
    By selecionarProjeto = By.xpath("//input[@value='Selecionar Projeto']");

    By projetoTarefaFrequenciaSelect= By.id("select-project-id");

    By preencherResumoTarefa = By.id("summary");
    By preencherDescricaoTarefa = By.id("description");
    By cadastrarTarefaButton = By.xpath("//input[@value='Criar Nova Tarefa']");


    By validarTarefa = By.xpath("//td[text()='Tarefa 001']");
    By validarTarefaNumero = By.xpath("//td[text()='123456']");
    By validarTarefaCaractere = By.xpath("//td[text()='!@#$%&*']");




    //Actions
        //Criar Tarefas
    public void clicarTarefas(){click(selecionarTarefaoButton);}
    public void selecionarTarefaProjeto(String projeto){ sendKeys(projetoTarefaSelect, projeto); }
    public void clicarProjeto(){click(selecionarProjeto);}

    public void preenhcerResumoTarefa(String resumoTarefa){ sendKeys(preencherResumoTarefa, resumoTarefa); }
    public void preenhcerDescricaoTarefa(String descricaoTarefa){ sendKeys(preencherDescricaoTarefa, descricaoTarefa); }
    public void clicarCadastrarTarefa(){click(cadastrarTarefaButton);}


    public String validarTarefaCriada(){ return getText(validarTarefa); }
    public String validarTarefaNumero(){ return getText(validarTarefaNumero); }
    public String validarTarefaCaractere(){ return getText(validarTarefaCaractere); }







}
