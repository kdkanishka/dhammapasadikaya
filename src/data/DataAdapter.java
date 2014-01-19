/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import models.SearchResult;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author Kanishka
 */
public class DataAdapter {

    DBConnManager DBCM = null;
    Connection conn = null;

    public DataAdapter() {
        DBCM = new DBConnManager();
    }
    
    public static String encode(String str){
        System.out.println(StringEscapeUtils.escapeHtml3(str));
        return StringEscapeUtils.escapeHtml3(str);
    }

    public List<SearchResult> search(String key) {
        List<SearchResult> tripitakaResult = new LinkedList<SearchResult>();
        String query = "SELECT fileName,pageContent FROM Pages WHERE pageContent LIKE \"%" + encode(key) + "%\" ORDER BY pageId";
        //TODO pagination LIMIT 10 OFFSET 0
        conn = DBCM.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                SearchResult result=new SearchResult(rs.getString(1), rs.getString(2));
                tripitakaResult.add(result);
            }
            stmt.close();
            rs.close();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Query failed! , " + se.getMessage(), "JDBC Error", JOptionPane.ERROR_MESSAGE);
        } catch (OutOfMemoryError e) {
            JOptionPane.showMessageDialog(null, "Out of memory! , " + e.getMessage(), "Memory Exception", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } finally {
            DBCM.close(conn);
        }
        return tripitakaResult;
    }

    public int countRecords() {
        String query = "SELECT COUNT(pageId) FROM Pages";
        conn = DBCM.connect();
        int count = 0;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Query failed! , " + se.getMessage(), "JDBC Error", JOptionPane.ERROR_MESSAGE);
        } catch (OutOfMemoryError e) {
            JOptionPane.showMessageDialog(null, "Out of memory! , " + e.getMessage(), "Memory Exception", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } finally {
            DBCM.close(conn);
        }
        return count;
    }

    public Vector searchFiles(String fileTxt) {
        Vector<Vector<String>> dataVec = new Vector<Vector<String>>();
        String query = "select pageId,fileName from pages where fileName like '%" + fileTxt + "%'";
        conn = DBCM.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rslt = stmt.executeQuery(query);
            while (rslt.next()) {
                Vector tmpVec = new Vector();
                tmpVec.add(rslt.getString(1));
                tmpVec.add(rslt.getString(2));
                dataVec.add(tmpVec);
            }
            stmt.close();
            rslt.close();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Query failed! , " + se.getMessage(), "JDBC Error", JOptionPane.ERROR_MESSAGE);
        } catch (OutOfMemoryError e) {
            JOptionPane.showMessageDialog(null, "Out of memory! , " + e.getMessage(), "Memory Exception", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } finally {
            DBCM.close(conn);
        }
        return dataVec;
    }

    public String retrieveContent(String fileID){
        String content="";
        String query="select pageContent from Pages where pageId="+fileID;
        conn=DBCM.connect();
        try{
            Statement stmt=conn.createStatement();
            ResultSet rslt=stmt.executeQuery(query);
            boolean isfound=rslt.next();
            if(isfound){
                content=rslt.getString(1);
            }
        }catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Query failed! , " + se.getMessage(), "JDBC Error", JOptionPane.ERROR_MESSAGE);
        } catch (OutOfMemoryError e) {
            JOptionPane.showMessageDialog(null, "Out of memory! , " + e.getMessage(), "Memory Exception", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } finally {
            DBCM.close(conn);
        }
        return content;
    }
}
