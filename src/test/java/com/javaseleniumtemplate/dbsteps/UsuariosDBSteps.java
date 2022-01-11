package com.javaseleniumtemplate.dbsteps;

import com.javaseleniumtemplate.utils.DBUtils;
import com.javaseleniumtemplate.utils.Utils;

public class UsuariosDBSteps {

    private static String queriesPath = "src/test/java/com/javaseleniumtemplate/queries/Users/";

    public static void deletaUsuarios(){
        String query = Utils.getFileContent(queriesPath + "deletaUsuarios.sql");
        DBUtils.executeQuery(query);
    }

    public static void cadastrarUsuarios(){
        String query = Utils.getFileContent(queriesPath + "cadastraUsuarios.sql");
        DBUtils.executeQuery(query);
    }







}
