package br.com.loja.dal;
import java.sql.*;
public class ModuloConexao {
    //método de conexão com o BD
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
        //chamar o driver
        String driver = "com.mysql.cj.jdbc.Driver";
        
        //Armazando infos do banco 
        String url = "jdbc:mysql://localhost:3306/dblojaetec";
        String user = "root";
        String password = "";
        
        //Estabelecer a conexão 
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        }catch (Exception e){
            return null;
        }
    }
}
