package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.Utils;

public class ProjetosDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/Projects/";

    public static void deletaProjetos(){
        String query = Utils.getFileContent(queriesPath + "deletarProjetos.sql");
        DBUtils.executeQuery(query);
    }

    public static void cadastrarProjetos(){
        String query = Utils.getFileContent(queriesPath + "cadastrarProjetos.sql");
        DBUtils.executeQuery(query);
    }







}
