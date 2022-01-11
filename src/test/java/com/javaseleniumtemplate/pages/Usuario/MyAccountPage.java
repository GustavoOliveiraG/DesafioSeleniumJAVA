package com.javaseleniumtemplate.pages.Usuario;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MyAccountPage extends PageBase {
    //Mapping
        //Usuario
    By validusername = By.xpath("//span[text()='administrador']");
    By addNewUser = By.xpath("//a[text()=' Convidar Usuários']");

        //Projetos
    By gerenciarProjetosButton = By.linkText("Gerenciar Projetos");
    By criarNovoProjetoButton = By.xpath("//button[text()=\"Criar Novo Projeto\"]");

    //Actions
    public String retornaUsernameLogado(){ return getText(validusername); }
    public void clicarConvidarUsuario(){click(addNewUser);}

    public void clicarGerenciarProjetos(){
        click(gerenciarProjetosButton);
    }
    public void clicarCriarNovoProjeto(){ click(criarNovoProjetoButton); }

}
