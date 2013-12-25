package utils;

/**
 *
 * @author Kanishka Dilshan
 */
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class Extractor {

    Queue<String> dataQueue;
    String toSearch;
    String filePath;
    JPanel contentHolder;//panel for containing output result

    public Extractor(String toSearch, String filePath, JPanel contHold) {
        dataQueue = new LinkedList<String>();
        this.toSearch = toSearch;
        this.filePath = filePath;
        this.contentHolder = contHold;
    }

    public static String metaFilter(String s) {
        String newStr = s.replace("&gt;", ">");
        newStr = newStr.replace("&lt;", "<");
        return newStr;
    }

    public static String removeTags(String s) {
        //remove tags
        String skeyStr1 = "<font face=\"Tipitaka_Sinhala1\" size=\"4\">";
        String skeyStr2 = "<font face=\"Tipitaka_Sinhala1\" size=\"6\">";
        String skeyStr3 = "<p align=\"CENTER\">";
        String ekeyStr4 = "</font>";
        String newStr = s.replace(skeyStr1, "");
        newStr = newStr.replace(skeyStr2, "");
        newStr = newStr.replace(skeyStr3, "");
        newStr = newStr.replace(ekeyStr4, "");
        newStr = newStr.replace("</p>", "");
        newStr = newStr.replace("<p>", "");
        return newStr;
    }

    public void queueTheFile() throws IOException {
        System.out.println(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line;

        String skeyStr1 = "<font face=\"Tipitaka_Sinhala1\" size=\"4\">";
        String skeyStr2 = "<font face=\"Tipitaka_Sinhala1\" size=\"6\">";
        String skeyStr3 = "<p align=\"CENTER\">";
        String ekeyStr4 = "</font>";

        StringBuffer para = new StringBuffer();
        boolean inProgress = false;	//no data in the queue
        while ((line = br.readLine()) != null) {
            //to do
            if (!inProgress) {
                //There is no opened tag yet
                int st1 = line.lastIndexOf(skeyStr1);
                int st2 = line.lastIndexOf(skeyStr2);
                int st3 = line.lastIndexOf(skeyStr3);
                //check for the tag
                if (st1 != -1) {
                    //tag skeyStr1 found
                    String subs = line.substring(st1 + skeyStr1.length());
                    para.append(subs + "\n");
                    inProgress = true;
                } else if (st2 != -1) {
                    String subs = line.substring(st2 + skeyStr2.length());
                    para.append(subs + "\n");
                    inProgress = true;
                } else if (st3 != -1) {
                    String subs = line.substring(st3 + skeyStr3.length());
                    para.append(subs + "\n");
                    inProgress = true;
                }
            } else {
                //There is a opened tag so we have to collect data within the tag
                int end = line.lastIndexOf(ekeyStr4);
                if (end != -1) {
                    //the closed tag found in this line
                    //String subs=line.substring(0,end);
                    para.append(line + "\n");
                    inProgress = false; //stop collecting data from the current tag
                    //add collected data to the Queue
                    dataQueue.add(para.toString());
                    //clear the buffer
                    para.setLength(0);
                } else {
                    //no closed tag in this line
                    //we can directly append the whole line to the buffer
                    para.append(line + "\n");
                }
            }
        }
        //now we have the collected data in the StringBuffer
        br.close();
    }

    /*
     public  void generateResults() throws IOException{
     FileOutputStream fos=new FileOutputStream(new File("SearchResult.txt"));
     BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos,"UTF16"));

     while(!dataQueue.isEmpty()){
     String test=metaFilter(removeTags(dataQueue.poll()));
     if(test.indexOf(toSearch)!=-1){
     bw.write("____________________________________");
     bw.newLine();
     bw.write(test);

     }
     }
     bw.flush();
     bw.close();
     }
     *
     */
    public void fillThePanel() {
        Color c1 = new Color(223, 255, 255);
        Color c2 = new Color(213, 255, 210);
        int i = 0;

        while (!dataQueue.isEmpty()) {
            String test = metaFilter(removeTags(dataQueue.poll()));

            if (test.indexOf(toSearch) != -1) {
                System.out.println("FOUND!");
                JTextArea jta = new JTextArea();
                jta.setFont(new Font("Tipitaka_Sinhala1", Font.PLAIN, 18));
                jta.setEditable(false);
                contentHolder.setLayout(new BoxLayout(contentHolder, BoxLayout.Y_AXIS));
                //jPanel1.setLayout(new GridLayout(dataQueue.size(),1));

                JPanel xp = new JPanel();
                xp.setLayout(new BoxLayout(xp, BoxLayout.Y_AXIS));
                xp.add(jta);
                xp.add(new JSeparator());

                //xp.setAlignmentX(TOP_ALIGNMENT);
                jta.setLineWrap(true);
                contentHolder.add(xp);
                jta.setText(test.trim());
                if (i % 2 == 0) {
                    jta.setBackground(c1);
                } else {
                    jta.setBackground(c2);
                }
                i++;
            }
        }

    }

    public void run() {

        try {
            queueTheFile();
            fillThePanel();
        } catch (IOException ex1) {
            System.out.println(ex1.getMessage());
        }
    }
}
