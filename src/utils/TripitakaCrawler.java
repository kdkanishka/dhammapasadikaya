package utils;

/**
 *
 * @author Kanishka Dilshan
 * @purpose : Crawling all pages of the tripitaka
 */
import data.DataAdapter;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ui.ResultsWindow;



public class TripitakaCrawler extends Thread {
    int fileCount;
    JLabel statusBar;
    JPanel contHolder;
    String wtToSrch;
    JLabel numberOfResults;
    JButton trigger;
    int numOfResults=0;
    int numUnique=0;

    public TripitakaCrawler(JLabel statusBar,JPanel chldr,String wtToSrch,JLabel numberOfResults,JButton trigger){
        fileCount=0;
        this.statusBar=statusBar;
        this.contHolder=chldr;
        this.wtToSrch=wtToSrch;
        this.numberOfResults=numberOfResults;
        this.trigger=trigger;
    }

//    private String getExtension(String file){
//        //return file extension of a given file
//        return (file.substring(file.lastIndexOf(".")+1).toUpperCase());
//    }

//    public void crawl(String path) {
//        //A recursive method for crawling pages
//        File tmpFl=new File(path);
//        File fileArr[]=tmpFl.listFiles();
//        for(File fileEl:fileArr){
//            if(fileEl.isDirectory()){
//                crawl(fileEl.toString());
//            }else if(fileEl.isFile()){
//                //System.out.println(fileEl.toString());
//                infoBar.setText(fileEl.toString());
//                if(getExtension(fileEl.toString()).equals("HTML")||getExtension(fileEl.toString()).equals("HTM"))
//                    fileCount++;
//
//                //-------------We are going to inspect all validated files and extract the content----
//                //contHolder
//                       float totFiles=(float)MetaData.noOfFiles;
//                       int prog=(int)((fileCount/totFiles)*100);
//                       this.progressPercentage.setText(String.valueOf(prog)+"%");
//                       //TextExtractor myEx=new TextExtractor(wtToSrch, fileEl.toString(), contHolder);
//                       //myEx.run();
//                //-------------current file extracted and inspected successfully----------------------
//            }
//        }
//    }

    public void search(){
        DataAdapter da=new DataAdapter();
        Vector<Vector<String>> tripitakaResult=null;
        String key=this.wtToSrch;
        tripitakaResult=da.search(key);

        Iterator i1=tripitakaResult.iterator();
        //System.out.println(i.hasNext());
        //Vector row=(Vector)i.next();
        //Iterator i2=row.iterator();
        //i2.next();
        //String page= i2.next().toString();
        //System.out.println(page);

        while(i1.hasNext()){
            Vector row=(Vector)i1.next();
            Iterator i2=row.iterator();
            while(i2.hasNext()){
                //i2.next();  //ignoring the file ID
                String fileName=i2.next().toString();
                String pageContent=i2.next().toString();
                TextExtractor myTxtExt=new TextExtractor(wtToSrch, fileName, pageContent, contHolder);
                int results=myTxtExt.run();
                numOfResults+=results;
                if(results>0)
                    numUnique++;    //number of unique pages
                numberOfResults.setText("Total results :"+numOfResults+"  Number of unique pages : "+numUnique);
            }
        }
    }

    public int getFileCount(){
        return fileCount;
    }

    @Override
    public void run(){
        statusBar.setVisible(true);
        //crawl(rootPath);
        this.search();
        statusBar.setVisible(false);
        //infoBar.setText("Total number of files : "+String.valueOf(getFileCount()));
        trigger.setText("fidhkak");
        ResultsWindow.inProgress=false;
    }
}
