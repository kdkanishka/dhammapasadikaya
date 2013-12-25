/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.*;
import java.util.Stack;
import java.util.Vector;
import javax.swing.JOptionPane;
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

//    public static String validate(String s) {
//
//        String newStr = s.replace(">", "&gt;");
//        //newStr = newStr.replace( "&","&amp;");
//        newStr = newStr.replace("<", "&lt;");
//        newStr = newStr.replace("¿", "&iquest;");
//        newStr = newStr.replace("¡", "&iexcl;");
//        newStr = newStr.replace("—", "&mdash;");
//        newStr = newStr.replace("¡", "&iexcl;");
//        newStr = newStr.replace("\"", "&quot;");
//        newStr = newStr.replace("“", "&ldquo;");
//        newStr = newStr.replace("”", "&rdquo;");
//        newStr = newStr.replace("‘", "&lsquo;");
//        newStr = newStr.replace("’", "&rsquo;");
//        newStr = newStr.replace("«", "&laquo;");
//        newStr = newStr.replace("»", "&raquo;");
//        newStr = newStr.replace(" ", "&nbsp;");
//        newStr = newStr.replace("¢", "&cent;");
//        newStr = newStr.replace("©", "&copy;");
//        newStr = newStr.replace("÷", "&divide;");
//        newStr = newStr.replace("µ", "&micro;");
//        newStr = newStr.replace("·", "&middot;");
//        newStr = newStr.replace("¶", "&para;");
//        newStr = newStr.replace("±", "&plusmn;");
//        newStr = newStr.replace("€", "&euro;");
//        newStr = newStr.replace("£", "&pound;");
//        newStr = newStr.replace("®", "&reg;");
//        newStr = newStr.replace("§", "&sect;");
//        newStr = newStr.replace("™", "&trade;");
//        newStr = newStr.replace("§", "&sect;");
//        newStr = newStr.replace("¥", "&yen;");
//        newStr = newStr.replace("á", "&aacute;");
//        newStr = newStr.replace("Á", "&Aacute;");
//        newStr = newStr.replace("à", "&agrave;");
//        newStr = newStr.replace("À", "&Agrave;");
//        newStr = newStr.replace("â", "&acirc;");
//        newStr = newStr.replace("Â", "&Acirc;");
//        newStr = newStr.replace("å", "&aring;");
//        newStr = newStr.replace("Å", "&Aring;");
//        newStr = newStr.replace("ã", "&atilde;");
//        newStr = newStr.replace("Ã", "&Atilde;");
//        newStr = newStr.replace("ä", "&auml;");
//        newStr = newStr.replace("Ä", "&Auml;");
//        newStr = newStr.replace("æ", "&aelig;");
//        newStr = newStr.replace("Æ", "&AElig;");
//        newStr = newStr.replace("ç", "&ccedil;");
//        newStr = newStr.replace("Ç", "&Ccedil;");
//        newStr = newStr.replace("é", "&eacute;");
//        newStr = newStr.replace("É", "&Eacute;");
//        newStr = newStr.replace("è", "&egrave;");
//        newStr = newStr.replace("È", "&Egrave;");
//        newStr = newStr.replace("ê", "&ecirc;");
//        newStr = newStr.replace("Ê", "&Ecirc;");
//        newStr = newStr.replace("ë", "&euml;");
//        newStr = newStr.replace("Ë", "&Euml;");
//        newStr = newStr.replace("í", "&iacute;");
//        newStr = newStr.replace("Í", "&Iacute;");
//        newStr = newStr.replace("ì", "&igrave;");
//        newStr = newStr.replace("Ì", "&Igrave;");
//        newStr = newStr.replace("î", "&icirc");
//        newStr = newStr.replace("Î", "&Icirc;");
//        newStr = newStr.replace("ï", "&iuml;");
//        newStr = newStr.replace("Ï", "&Iuml;");
//        newStr = newStr.replace("ñ", "&ntilde;");
//        newStr = newStr.replace("Ñ", "&Ntilde;");
//        newStr = newStr.replace("ó", "&oacute;");
//        newStr = newStr.replace("Ó", "&Oacute;");
//        newStr = newStr.replace("ò", "&ograve;");
//        newStr = newStr.replace("Ò", "&Ograve;");
//        newStr = newStr.replace("ô", "&ocirc;");
//        newStr = newStr.replace("Ô", "&Ocirc;");
//        newStr = newStr.replace("ø", "&oslash;");
//        newStr = newStr.replace("Ø", "&Oslash;");
//        newStr = newStr.replace("õ", "&otilde;");
//        newStr = newStr.replace("Õ", "&Otilde;");
//        newStr = newStr.replace("ö", "&ouml;");
//        newStr = newStr.replace("Ö", "&Ouml;");
//        newStr = newStr.replace("ß", "&szlig;");
//        newStr = newStr.replace("Ý", "&Yacute;");
//        newStr = newStr.replace("ú", "&uacute;");
//        newStr = newStr.replace("Ú", "&Uacute;");
//        newStr = newStr.replace("ù", "&ugrave;");
//        newStr = newStr.replace("Ù", "&Ugrave;");
//        newStr = newStr.replace("û", "&ucirc;");
//        newStr = newStr.replace("Û", "&Ucirc;");
//        newStr = newStr.replace("ü", "&uuml;");
//        newStr = newStr.replace("Ü", "&Uuml;");
//        newStr = newStr.replace("ÿ", "&yuml;");
//
//        newStr = newStr.replace("Ð", "&ETH;");
//        newStr = newStr.replace("¤", "&curren;");
//        newStr = newStr.replace("¦", "&brvbar;");
//        newStr = newStr.replace("¨", "&uml;");
//        newStr = newStr.replace("ª", "&ordf;");
//        newStr = newStr.replace("¯", "&macr;");
//
//        newStr = newStr.replace("þ", "&thorn;");
//        newStr = newStr.replace("Þ", "&THORN;");
//        newStr = newStr.replace("ð", "&eth;");
//        System.out.println(newStr);
//        return newStr;
//    }

    public Vector search(String key) {
        Vector<Vector<String>> tripitakaResult = new Stack<Vector<String>>();
        String query = "SELECT fileName,pageContent FROM Pages WHERE pageContent LIKE \"%" + encode(key) + "%\"";
        conn = DBCM.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Vector tripitakaDataRow = new Vector();
                tripitakaDataRow.add(rs.getString(1));
                tripitakaDataRow.add(rs.getString(2));
                tripitakaResult.add(tripitakaDataRow);
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
