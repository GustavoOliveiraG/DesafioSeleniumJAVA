package com.javaseleniumtemplate.tests.Tasks;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.flows.UserFlows;
import com.javaseleniumtemplate.pages.Projects.CreateProjectsPage;
import com.javaseleniumtemplate.pages.Projects.CreateSubProjectsPage;
import com.javaseleniumtemplate.pages.Projects.EditProjectPage;
import com.javaseleniumtemplate.pages.Tasks.CreateTasksPage;
import com.javaseleniumtemplate.pages.Usuario.EditAccountPage;
import com.javaseleniumtemplate.pages.Usuario.MyAccountPage;
import com.javaseleniumtemplate.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TasksTests extends TestBase {
    //Objects
    ExcelUtils excelUtils;
    LoginFlows loginFlows;
    UserFlows userFlows;
    CreateProjectsPage createProjectsPage;
    EditAccountPage editAccountPage;
    MyAccountPage myAccountPage;
    EditProjectPage editProjectPage;
    CreateSubProjectsPage createSubProjectsPage;
    CreateTasksPage createTasksPage;


    //Selecionar Projetos
    @Test
    public void selecionarProjeto() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        createTasksPage = new CreateTasksPage();


        //Parameteres
        String validaTeste = "Operação realizada com sucesso.";

        //Test
        loginFlows.acessarSistema();
        createTasksPage.clicarTarefas();
        createTasksPage.selecionarTarefaProjeto("Projeto 012 INSERT query via BANCO");
        createTasksPage.clicarProjeto();

        //Assert.assertEquals(createProjectsPage.validarProjetoCadastradoSucesso(),"Projeto 001");
    }

    @Test
    public void cadastrarTarefaProjeto13() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        createTasksPage = new CreateTasksPage();


        //Parameteres
        String descTarefa = "Tarefa 001";

        //Test
        loginFlows.acessarSistema();
        createTasksPage.clicarTarefas();
        createTasksPage.selecionarTarefaProjeto("Projeto 013 INSERT query via BANCO");
        createTasksPage.clicarProjeto();
        createTasksPage.preenhcerResumoTarefa("Tarefa QA Teste");
        createTasksPage.preenhcerDescricaoTarefa(descTarefa);
        createTasksPage.clicarCadastrarTarefa();

        Assert.assertEquals(createTasksPage.validarTarefaCriada(),descTarefa);
    }

    @Test
    public void cadastrarTarefaNumeroNome() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        createTasksPage = new CreateTasksPage();


        //Parameteres
        String descTarefa = "123456";

        //Test
        loginFlows.acessarSistema();
        createTasksPage.clicarTarefas();
        createTasksPage.selecionarTarefaProjeto("Projeto 013 INSERT query via BANCO");
        createTasksPage.clicarProjeto();
        createTasksPage.preenhcerResumoTarefa("Tarefa QA Teste - Numero");
        createTasksPage.preenhcerDescricaoTarefa(descTarefa);
        createTasksPage.clicarCadastrarTarefa();

        Assert.assertEquals(createTasksPage.validarTarefaNumero(),descTarefa);
    }

    @Test
    public void cadastrarTarefaCaractereNome() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        createTasksPage = new CreateTasksPage();


        //Parameteres
        String descTarefa = "!@#$%&*";

        //Test
        loginFlows.acessarSistema();
        createTasksPage.clicarTarefas();
        createTasksPage.selecionarTarefaProjeto("Projeto 013 INSERT query via BANCO");
        createTasksPage.clicarProjeto();
        createTasksPage.preenhcerResumoTarefa("Tarefa QA Teste - Caractere");
        createTasksPage.preenhcerDescricaoTarefa(descTarefa);
        createTasksPage.clicarCadastrarTarefa();

        Assert.assertEquals(createTasksPage.validarTarefaCaractere(),descTarefa);
    }





}
