/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringTokenizer;
import javax.swing.JLabel;

/**
 *
 * @author Kanishka
 */
public class UpdateCheckProcess extends Thread{
    //version|update type|description|url
    URLConnection urlC=null;
    URL updateData=null;
    JLabel errorLbl=null;
    JLabel loadingLbl=null;
    UpdateDetails updtls;

    public UpdateCheckProcess(JLabel errorLbl,JLabel loadingLbl,UpdateDetails updtls){
        this.errorLbl=errorLbl;
        this.updtls=updtls;
        this.loadingLbl=loadingLbl;
        try {
            updateData = new URL("http://sites.google.com/site/dhammapasaadikaya/update/update.dat");
        } catch (MalformedURLException e) {
            errorLbl.setVisible(true);
            loadingLbl.setVisible(true);
        }
    }


    @Override
    public void run() {
        try {
            loadingLbl.setVisible(true);//show progress
            urlC = updateData.openConnection();
            urlC.setDoOutput(false);
            InputStreamReader isr = new InputStreamReader(urlC.getInputStream());
            BufferedReader buffR = new BufferedReader(isr);
            String tmpLine = "";
            tmpLine=buffR.readLine();
            while((tmpLine=buffR.readLine())!=null){
                System.out.println(tmpLine);
            }
                    
            
            System.out.println(tmpLine);

            String delimiter="|";
            StringTokenizer stkz=new StringTokenizer(tmpLine);
            String version=stkz.nextToken(delimiter);
            String updateType=stkz.nextToken(delimiter);
            String description=stkz.nextToken(delimiter);
            String url=stkz.nextToken(delimiter);

            updtls.getjPanel_update().setVisible(true);
            //updtls.getjLabel_updateURL().setText("URL : " + url);
            updtls.getjLabel_updateURL().setText(url);
            updtls.getjLabel_updatetype().setText("Update Type : "+ updateType);
            updtls.getjLabel_version().setText("Version : "+ version);
            updtls.getjTextArea_updateDescription().setText(description);


            float updtVersion=1.0f;
            try{
                updtVersion=Float.parseFloat(version);
            }catch(NumberFormatException e){}
            float currentVersion=VersionDetails.version;
            if(updtVersion>currentVersion){
                updtls.getjLabel_updateStatus().setText("A new version is available!");
            }else{
                updtls.getjLabel_updateStatus().setText("Current version is the latest version.");
            }



//            System.out.println(version);
//            System.out.println(updateType);
//            System.out.println(description);
//            System.out.println(url);

            loadingLbl.setVisible(false);//hide loader
        } catch (IOException ex) {
            errorLbl.setVisible(true);
            loadingLbl.setVisible(false);
        } catch (Exception e) {
            errorLbl.setVisible(true);
            loadingLbl.setVisible(true);
        }
    } 
}
