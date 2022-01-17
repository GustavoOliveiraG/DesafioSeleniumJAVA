package com.javaseleniumtemplate.tests.Projects;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.flows.SubProjetosFlows;
import com.javaseleniumtemplate.flows.UserFlows;
import com.javaseleniumtemplate.pages.Projects.CreateProjectsPage;
import com.javaseleniumtemplate.pages.Projects.CreateSubProjectsPage;
import com.javaseleniumtemplate.pages.Projects.EditProjectPage;
import com.javaseleniumtemplate.pages.Projects.EditSubProjectsPage;
import com.javaseleniumtemplate.pages.Usuario.EditAccountPage;
import com.javaseleniumtemplate.pages.Usuario.MyAccountPage;
import com.javaseleniumtemplate.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubProjectsTests extends TestBase {
    //Objects
    ExcelUtils excelUtils;
    LoginFlows loginFlows;
    UserFlows userFlows;
    CreateProjectsPage createProjectsPage;
    EditAccountPage editAccountPage;
    MyAccountPage myAccountPage;
    EditProjectPage editProjectPage;
    CreateSubProjectsPage createSubProjectsPage;
    EditSubProjectsPage editSubProjectsPage;
    SubProjetosFlows subProjetosFlows;


    //Cadastrar SubProjetos
    @Test
    public void cadastrarSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto4();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 003");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarHerdarSubCategorias();
        createSubProjectsPage.clicarHerdarSubCategoriasPAI();
        createSubProjectsPage.selecionarVisibilidade("público");
        createSubProjectsPage.preenhcerDescricaoSubProjeto("TesteSUB123ABC");
        createSubProjectsPage.clicarCadastrarSubProjeto();



        Assert.assertEquals(createSubProjectsPage.validarSubProjetoCadastradoSucesso(),"» SubProjeto 003");
    }

    @Test
    public void cadastrarSubProjetoNameIgual() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();

        String msg = "APPLICATION ERROR #701";
        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto20();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 020");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        myAccountPage.clicarConvidarUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto20();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 020");
        createSubProjectsPage.clicarCadastrarSubProjeto();

        //Assert.assertEquals(editSubProjectsPage.validarNameProjetoIgual(),"APPLICATION ERROR #701");
    }

    @Test
    public void cadastrarSubProjetoSemName() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();


        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto4();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("");
        createSubProjectsPage.clicarCadastrarSubProjeto();


        //Assert.assertEquals(editSubProjectsPage.validarNameProjetoIgual(),"APPLICATION ERROR #701");
    }

    //Cadastrar SubProjetos
    @Test
    public void cadastrarSubProjetosemDescricao() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto4();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 004");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarCadastrarSubProjeto();



        Assert.assertEquals(createSubProjectsPage.validarSubProjetoCadastradosemDescricao(),"» SubProjeto 004");
    }

    @Test
    public void cadastrarSubProjetoNumeroNome() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto4();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("123456789");
        createSubProjectsPage.clicarCadastrarSubProjeto();



        Assert.assertEquals(createSubProjectsPage.validarSubProjetoCadastradoNumero(),"» 123456789");
    }

    @Test
    public void cadastrarSubProjetoNomeCaractereEspecial() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        editProjectPage.clicarProjeto4();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("!@#$%&*");
        createSubProjectsPage.clicarCadastrarSubProjeto();



        Assert.assertEquals(createSubProjectsPage.validarSubProjetoCadastradoCaractere(),"» !@#$%&*");
    }





    //Editar SubProjetos
    @Test
    public void editarNameSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 02");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarHerdarSubCategorias();
        createSubProjectsPage.clicarHerdarSubCategoriasPAI();
        createSubProjectsPage.selecionarVisibilidade("público");
        createSubProjectsPage.preenhcerDescricaoSubProjeto("SubEditar");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        editSubProjectsPage.clicarSubProjeto02();
        editSubProjectsPage.preenhcerNomeSubProjeto("SubEditado");
        editSubProjectsPage.clicarCadastrarSubProjeto();



        Assert.assertEquals(editSubProjectsPage.validarSubProjetoCadastradoSucesso(),"» SubEditado");
    }

    @Test
    public void editarEstadoSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();
        subProjetosFlows = new SubProjetosFlows();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 03");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarHerdarSubCategorias();
        createSubProjectsPage.clicarHerdarSubCategoriasPAI();
        createSubProjectsPage.selecionarVisibilidade("público");
        createSubProjectsPage.preenhcerDescricaoSubProjeto("SubEstado");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        editSubProjectsPage.clicarSubProjeto03();
        editSubProjectsPage.selecionarEstadoSubProjeto("release");
        editSubProjectsPage.clicarCadastrarSubProjeto();

        Assert.assertEquals(editSubProjectsPage.validarEstadoSubProjetoeditado(),"release");
    }

    @Test
    public void editarHabilitadoSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();
        subProjetosFlows = new SubProjetosFlows();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 04");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarHerdarSubCategorias();
        createSubProjectsPage.clicarHerdarSubCategoriasPAI();
        createSubProjectsPage.selecionarVisibilidade("público");
        createSubProjectsPage.preenhcerDescricaoSubProjeto("SubEstado");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        editSubProjectsPage.clicarSubProjeto04();
        editSubProjectsPage.clicarhabilitar();
        editSubProjectsPage.clicarCadastrarSubProjeto();

        Assert.assertEquals(editSubProjectsPage.validarHabilitadoSubProjetoeditado(),"");
    }

    @Test
    public void editarVisibilidadeSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();
        subProjetosFlows = new SubProjetosFlows();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 05");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarHerdarSubCategorias();
        createSubProjectsPage.clicarHerdarSubCategoriasPAI();
        createSubProjectsPage.selecionarVisibilidade("público");
        createSubProjectsPage.preenhcerDescricaoSubProjeto("SubVisibilidade");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        editSubProjectsPage.clicarSubProjeto05();
        editSubProjectsPage.selecionarVisibilidade("privado");
        editSubProjectsPage.clicarCadastrarSubProjeto();

        Assert.assertEquals(editSubProjectsPage.validarVisibilidadeSubProjetoeditado(),"privado");
    }

    @Test
    public void editarDescrisaoSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();
        subProjetosFlows = new SubProjetosFlows();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 06");
        createSubProjectsPage.selecionarEstadoSubProjeto("release");
        createSubProjectsPage.clicarHerdarSubCategorias();
        createSubProjectsPage.clicarHerdarSubCategoriasPAI();
        createSubProjectsPage.selecionarVisibilidade("público");
        createSubProjectsPage.preenhcerDescricaoSubProjeto("SubDescricao");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        editSubProjectsPage.clicarSubProjeto06();
        editSubProjectsPage.preenhcerDescricaoSubProjeto("111BBBAAA");
        editSubProjectsPage.clicarCadastrarSubProjeto();

        Assert.assertEquals(editSubProjectsPage.validarDescricaoSubProjetoeditado(),"111BBBAAA");
    }

    @Test
    public void editarNomeVazioSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();
        subProjetosFlows = new SubProjetosFlows();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 10");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        editSubProjectsPage.clicarSubProjeto10();
        editSubProjectsPage.preenhcerNomeSubProjeto("");
        editSubProjectsPage.clicarCadastrarSubProjeto();

        //Assert.assertEquals(editSubProjectsPage.validarSubProjetoCadastradoSucesso(),"» SubEditado");
    }



    //Excluir SubProjeto
    @Test
    public void excluirSubProjetoSucesso() {
        //Objects instances
        loginFlows = new LoginFlows();
        userFlows = new UserFlows();
        myAccountPage = new MyAccountPage();
        editAccountPage = new EditAccountPage();
        createProjectsPage = new CreateProjectsPage();
        editProjectPage = new EditProjectPage();
        createSubProjectsPage = new CreateSubProjectsPage();
        editSubProjectsPage = new EditSubProjectsPage();
        subProjetosFlows = new SubProjetosFlows();

        //Test
        userFlows.acessarCadastrodeUsuario();
        myAccountPage.clicarGerenciarProjetos();
        createSubProjectsPage.clicarProjeto10();
        createProjectsPage.clicarCadastrarSubProjeto();
        createSubProjectsPage.preenhcerNomeSubProjeto("SubProjeto 11");
        createSubProjectsPage.clicarCadastrarSubProjeto();
        editSubProjectsPage.clicarSubProjeto11();

        editSubProjectsPage.clicarExcluirSubProjeto();
        editSubProjectsPage.clicarExcluirSubProjeto();

        //Assert.assertEquals(editSubProjectsPage.validarSubProjetoCadastradoSucesso(),"» SubEditado");
    }

}
