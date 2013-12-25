package ui;

/** Arahathwu Samma Sambuddha vu Budurajanan Wahanseta maage Namaskaraya Wewa!!!
 *  Sri Saddharmayatada maage namaskaraya wewa!!!
 *  Arya Maha Sangarathnayatada maage namaskaraya wewa!!!
 *  Sadu Sadu Saadu!!!
 */


import ui.MainWindow;
import ui.ResultsWindow;
import ui.MetaDataInitializer;
import javax.swing.UIManager;
/**
 *
 * @author Kanishka Dilshan
 */
public class tripitaka_main {
    public static MainWindow mainW;
    public static ResultsWindow resW=null;

    public static void main(String[] args)throws InterruptedException {
        System.out.println("Namo Buddhaya!!!");
         try{
            UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }
        new MetaDataInitializer();

    }

}
