/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Kanishka
 */
public class DBConnManager {
    Connection conn=null;
    String connStr=null;
    public DBConnManager(){
        String databaseName=MetaData.dbName;
        connStr=new String("jdbc:sqlite:"+databaseName);
    }

    public Connection connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(connStr);
        }catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "SQLite JDBC Driver not found!, "+e.getMessage(),"JDBC Error",JOptionPane.ERROR_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Couldn't connect to the database!, "+e.getMessage(),"JDBC Error",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

    public void close(Connection con){
        try{
            con.close();
        }catch(SQLException se){  }
    }
}
