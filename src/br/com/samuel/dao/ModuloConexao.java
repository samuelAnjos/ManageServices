
package br.com.samuel.dao;
import java.sql.*;
//1

public class ModuloConexao {
   public static Connection conector(){
       java.sql.Connection conexao = null;
       String driver = "com.mysql.jdbc.Driver";
       String url = "jdbc:mysql://localhost:3306/loja";
       String user = "root";
       String password = "ovelhapreta";
       
       try {
	   Class.forName(driver);
	   conexao = DriverManager.getConnection(url,user,password);
	   return conexao;
       } catch (Exception e) {
	   return null;
       }
   } 
}
