package utils;


/**
 *
 * @author Kanishka Dilshan
 */
import data.MetaData;
import data.PageGenerator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.io.*;
import javax.swing.*;
import org.apache.commons.lang3.StringEscapeUtils;

public class TextExtractor {

    Queue<String> dataQueue;
    String toSearch;
    String filePath;//this will be the output file
    JPanel contentHolder;//panel for containing output result
    String pageContent;
    int noOfResults = 0;

    public TextExtractor(String toSearch, String filePath, String pageContent, JPanel contHold) {
        dataQueue = new LinkedList<String>();
        this.toSearch = toSearch;
        this.filePath = filePath;
        this.contentHolder = contHold;
        this.pageContent = pageContent;
    }
    
    public String decodeString(String str){
        return StringEscapeUtils.unescapeHtml3(str);
    }

//    public static String metaFilter(String s) {
//
//        String newStr = s.replace("&gt;", ">");
//        newStr = newStr.replace("&amp;", "&");
//        newStr = newStr.replace("&lt;", "<");
//        newStr = newStr.replace("&iquest;", "¿");
//        newStr = newStr.replace("&iexcl;", "¡");
//        newStr = newStr.replace("&mdash;", "—");
//        newStr = newStr.replace("&iexcl;", "¡");
//        newStr = newStr.replace("&quot;", "\"");
//        newStr = newStr.replace("&ldquo;", "“");
//        newStr = newStr.replace("&rdquo;", "”");
//        newStr = newStr.replace("&lsquo;", "‘");
//        newStr = newStr.replace("&rsquo;", "’");
//        newStr = newStr.replace("&laquo;", "«");
//        newStr = newStr.replace("&raquo;", "»");
//        newStr = newStr.replace("&nbsp;", " ");
//        newStr = newStr.replace("&cent;", "¢");
//        newStr = newStr.replace("&copy;", "©");
//        newStr = newStr.replace("&divide;", "÷");
//        newStr = newStr.replace("&micro;", "µ");
//        newStr = newStr.replace("&middot;", "·");
//        newStr = newStr.replace("&para;", "¶");
//        newStr = newStr.replace("&plusmn;", "±");
//        newStr = newStr.replace("&euro;", "€");
//        newStr = newStr.replace("&pound;", "£");
//        newStr = newStr.replace("&reg;", "®");
//        newStr = newStr.replace("&sect;", "§");
//        newStr = newStr.replace("&trade;", "™");
//        newStr = newStr.replace("&sect;", "§");
//        newStr = newStr.replace("&yen;", "¥");
//        newStr = newStr.replace("&aacute;", "á");
//        newStr = newStr.replace("&Aacute;", "Á");
//        newStr = newStr.replace("&agrave;", "à");
//        newStr = newStr.replace("&Agrave;", "À");
//        newStr = newStr.replace("&acirc;", "â");
//        newStr = newStr.replace("&Acirc;", "Â");
//        newStr = newStr.replace("&aring;", "å");
//        newStr = newStr.replace("&Aring;", "Å");
//        newStr = newStr.replace("&atilde;", "ã");
//        newStr = newStr.replace("&Atilde;", "Ã");
//        newStr = newStr.replace("&auml;", "ä");
//        newStr = newStr.replace("&Auml;", "Ä");
//        newStr = newStr.replace("&aelig;", "æ");
//        newStr = newStr.replace("&AElig;", "Æ");
//        newStr = newStr.replace("&ccedil;", "ç");
//        newStr = newStr.replace("&Ccedil;", "Ç");
//        newStr = newStr.replace("&eacute;", "é");
//        newStr = newStr.replace("&Eacute;", "É");
//        newStr = newStr.replace("&egrave;", "è");
//        newStr = newStr.replace("&Egrave;", "È");
//        newStr = newStr.replace("&ecirc;", "ê");
//        newStr = newStr.replace("&Ecirc;", "Ê");
//        newStr = newStr.replace("&euml;", "ë");
//        newStr = newStr.replace("&Euml;", "Ë");
//        newStr = newStr.replace("&iacute;", "í");
//        newStr = newStr.replace("&Iacute;", "Í");
//        newStr = newStr.replace("&igrave;", "ì");
//        newStr = newStr.replace("&Igrave;", "Ì");
//        newStr = newStr.replace("&icirc", "î");
//        newStr = newStr.replace("&Icirc;", "Î");
//        newStr = newStr.replace("&iuml;", "ï");
//        newStr = newStr.replace("&Iuml;", "Ï");
//        newStr = newStr.replace("&ntilde;", "ñ");
//        newStr = newStr.replace("&Ntilde;", "Ñ");
//        newStr = newStr.replace("&oacute;", "ó");
//        newStr = newStr.replace("&Oacute;", "Ó");
//        newStr = newStr.replace("&ograve;", "ò");
//        newStr = newStr.replace("&Ograve;", "Ò");
//        newStr = newStr.replace("&ocirc;", "ô");
//        newStr = newStr.replace("&Ocirc;", "Ô");
//        newStr = newStr.replace("&oslash;", "ø");
//        newStr = newStr.replace("&Oslash;", "Ø");
//        newStr = newStr.replace("&otilde;", "õ");
//        newStr = newStr.replace("&Otilde;", "Õ");
//        newStr = newStr.replace("&ouml;", "ö");
//        newStr = newStr.replace("&Ouml;", "Ö");
//        newStr = newStr.replace("&szlig;", "ß");
//        newStr = newStr.replace("&Yacute;", "Ý");
//        newStr = newStr.replace("&uacute;", "ú");
//        newStr = newStr.replace("&Uacute;", "Ú");
//        newStr = newStr.replace("&ugrave;", "ù");
//        newStr = newStr.replace("&Ugrave;", "Ù");
//        newStr = newStr.replace("&ucirc;", "û");
//        newStr = newStr.replace("&Ucirc;", "Û");
//        newStr = newStr.replace("&uuml;", "ü");
//        newStr = newStr.replace("&Uuml;", "Ü");
//        newStr = newStr.replace("&yuml;", "ÿ");
//
//        newStr = newStr.replace("&ETH;", "Ð");
//        newStr = newStr.replace("&curren;", "¤");
//        newStr = newStr.replace("&brvbar;", "¦");
//        newStr = newStr.replace("&uml;", "¨");
//        newStr = newStr.replace("&ordf;", "ª");
//        newStr = newStr.replace("&macr;", "¯");
//
//        newStr = newStr.replace("&thorn;", "þ");
//        newStr = newStr.replace("&THORN;", "Þ");
//        newStr = newStr.replace("&eth;", "ð");
//        return newStr;
//    }

    public static String removeTags(String s) {
        String noHtml = s.replaceAll("\\<.*?>", "");
        return noHtml;
    }

    public void fillThePanel() throws IOException {
        Color c1 = new Color(223, 255, 255);
        Color c2 = new Color(213, 255, 210);
        int i = 0;
        byte pageBytes[] = pageContent.getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(pageBytes);
        BufferedReader br = new BufferedReader(new InputStreamReader(bais));
        String line;
        while ((line = br.readLine()) != null) {
            line = decodeString(removeTags(line));

            if (line.indexOf(toSearch) != -1) {
                noOfResults++;
                JTextArea jta = new JTextArea();
                if (MetaData.lang == 0) {
                    jta.setFont(new Font("Tipitaka_Sinhala1", Font.PLAIN, 18));
                } else if (MetaData.lang == 1) {
                    jta.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                } else if (MetaData.lang == 2) {
                    jta.setFont(new Font("Times_CSX+", Font.PLAIN, 18));
                }
                jta.setEditable(false);
                contentHolder.setLayout(new BoxLayout(contentHolder, BoxLayout.Y_AXIS));
                //jPanel1.setLayout(new GridLayout(dataQueue.size(),1));

                JPanel xp = new JPanel();
                xp.setLayout(new BoxLayout(xp, BoxLayout.Y_AXIS));
                xp.add(jta);

                xp.add(new JSeparator());


                String ttpText = "<html><FONT FACE=\"Tipitaka_Sinhala1\" SIZE=5>iuzmQK iQ;1 foaYkdj lshjSug wod, fldgi u; jrla la,sla lrkak</FONT>";
                ttpText += "<br>File Name : " + filePath + "</html>";
                jta.setToolTipText(ttpText);

                ActionClass acc = new ActionClass(filePath);//object for handling dynamic click events
                jta.addMouseListener(acc);

                //xp.setAlignmentX(TOP_ALIGNMENT);
                jta.setLineWrap(true);
                contentHolder.add(xp);
                jta.setText(line.trim());
                if (i % 2 == 0) {
                    jta.setBackground(c1);
                } else {
                    jta.setBackground(c2);
                }
                i++;
            }
        }

    }

    public int run() {
        try {
            fillThePanel();
        } catch (IOException ex1) {
            System.out.println(ex1.getMessage());
        }
        return noOfResults;
    }

    private class ActionClass implements MouseListener {
        //class for handle click event

        String data; //location of the generated file
        String fileName;

        public ActionClass(String data) {
            fileName=data;
            String resultPageLocation = "Results" + File.separator;
            this.data = resultPageLocation + data;
        }

        public void mouseClicked(MouseEvent e) {
            try {
                //create the file and launch it
                System.out.println(data);
                PageGenerator hlt = new PageGenerator(data, pageContent, toSearch);
                if (MetaData.enableHighlighting) {
                    hlt.highlightAndSave();
                } else {
                    hlt.saveOnly();
                }


//                new Launcher().launch(new File(data));
                new Launcher().showResultInResultPane(new File(data),fileName);
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Your JVM doesn't support this feature.\nPlease update your JVM.\n" + ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }
    }
}
