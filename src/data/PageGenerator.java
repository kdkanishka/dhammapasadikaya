/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kanishka
 */
public class PageGenerator {

    File relFile = null;
    String pageCont;
    String key;

    public PageGenerator(String fl, String pageCont, String key) {
        relFile = new File(fl);
        this.pageCont = pageCont;
        this.key = key;
    }

    public PageGenerator(String fl, String pageCont) {
        relFile = new File(fl);
        this.pageCont = pageCont;
    }

    public void highlightAndSave() {
        try {

            boolean isCreated = relFile.createNewFile();
            if (isCreated) {
                System.out.println("File created sucessfully..!");
            } else {
                System.out.println("File is already exist..!");
            }

            FileWriter fw = new FileWriter(relFile);
            PrintWriter pw = new PrintWriter(fw);
            String template = "<SPAN style='BACKGROUND-COLOR: #ffff00'>" + key + "</SPAN>";
            if (key.length() == 1) {
                JOptionPane.showMessageDialog(null, "Keyword Highlighling is Not Supported for This Result!", "Sathya Gaweshakaya", JOptionPane.INFORMATION_MESSAGE);
                saveOnly();
            } else {
                pageCont = pageCont.replaceAll(key, template);

                pw.println(pageCont);
                pw.close();
                fw.close();
            }
        } catch (IOException e) {
        } catch (PatternSyntaxException pse) {
            JOptionPane.showMessageDialog(null, "Keyword Highlighling is Not Supported for This Result!", "Sathya Gaweshakaya", JOptionPane.INFORMATION_MESSAGE);
            saveOnly();
        }
    }

    public void saveOnly() {
        try {

            boolean isCreated = relFile.createNewFile();
            if (isCreated) {
                System.out.println("File created sucessfully..!");
            } else {
                System.out.println("File is already exist..!");
            }

            FileWriter fw = new FileWriter(relFile);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(pageCont);
            pw.close();
            fw.close();
        } catch (IOException e) {
        }
    }
}
