/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ui.ResultPane;

/**
 *
 * @author Kanishka
 */
public class Launcher {
    public void win7launch(String path) {
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void launch(String url) {
        try {
            URI tripitaka = new URI(url);
            java.awt.Desktop.getDesktop().browse(tripitaka);
        } catch (URISyntaxException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }

        //for windows 7
       //win7launch(url);
    }

    public void launch(File url) {
        try {
            java.awt.Desktop.getDesktop().open(url);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
        }
        //for windows 7
       //win7launch(url.getPath());
    }
    
    public void showResultInResultPane(File file,String fileName){
        try {
            System.out.println(file.toURI().toURL());
            ResultPane resltPane = new ResultPane(file.toURI().toURL().toString(),fileName);
            resltPane.setLocationRelativeTo(null);
            URL url = getClass().getResource("/ico2.png");
            ImageIcon imageIcon = new ImageIcon(url);
            Image image = imageIcon.getImage();
            resltPane.setIconImage(image);
            resltPane.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
