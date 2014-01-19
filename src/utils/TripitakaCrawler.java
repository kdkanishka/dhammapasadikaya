package utils;

/**
 *
 * @author Kanishka Dilshan
 * @purpose : Crawling all pages of the tripitaka
 */
import data.DataAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.SearchResult;
import ui.ResultsWindow;

public class TripitakaCrawler extends Thread {

    int fileCount;
    JLabel statusBar;
    JPanel contHolder;
    String wtToSrch;
    JLabel numberOfResults;
    JButton trigger;
    int numOfResults = 0;
    int numUnique = 0;

    public TripitakaCrawler(JLabel statusBar, JPanel chldr, String wtToSrch, JLabel numberOfResults, JButton trigger) {
        fileCount = 0;
        this.statusBar = statusBar;
        this.contHolder = chldr;
        this.wtToSrch = wtToSrch;
        this.numberOfResults = numberOfResults;
        this.trigger = trigger;
    }
    
    public void search() {
        DataAdapter da = new DataAdapter();
        List<SearchResult> tripitakaResult = null;
        String key = this.wtToSrch;
        tripitakaResult = da.search(key);

        Iterator<SearchResult> i1 = tripitakaResult.iterator();

        while (i1.hasNext()) {
            SearchResult result = i1.next();
            TextExtractor myTxtExt = new TextExtractor(wtToSrch, result.getFileName(), result.getFileContent(), contHolder);
            int results = myTxtExt.run();
            numOfResults += results;
            if (results > 0) {
                numUnique++;    //number of unique pages
            }
            numberOfResults.setText("Total results :" + numOfResults + "  Number of unique pages : " + numUnique);
        }
    }

    public int getFileCount() {
        return fileCount;
    }

    @Override
    public void run() {
        statusBar.setVisible(true);
        this.search();
        statusBar.setVisible(false);
        trigger.setText("fidhkak");
        ResultsWindow.inProgress = false;
    }
}
