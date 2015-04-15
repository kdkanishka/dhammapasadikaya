package ui;


import utils.Launcher;
import data.DataAdapter;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/*
 * MetaDataInitializer.java
 *
 * Created on Jun 24, 2010, 11:00:51 PM
 */

/**
 *
 * @author Kanishka Dilshan
 */
public class MetaDataInitializer extends javax.swing.JFrame {
         private String task1="Checking Java VM version...";
         private String task2="Searching fonts...";
//         private String task3="Initializing Path...";
//         private String task4="Initializing Directories...";
         private String task3="Testing the database...";
         private String task5="Starting the Program...";

    /** Creates new form MetaDataInitializer */
    public MetaDataInitializer() {
        initComponents();
        URL url= getClass().getResource("/ico2.png");
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage();
        setIconImage(image);

        

        setVisible(true);
        setLocationRelativeTo(null);
        CheckJavaVersion jvmdetect=new CheckJavaVersion();
        jvmdetect.run();

        File fl=new File("./Results");
        if(!fl.isDirectory()){
            fl.mkdir();
        }


        FontDetector fdet=new FontDetector();
        fdet.run();

        ValidateDB vdb=new ValidateDB();
        vdb.run();

//        InitPath initDi=new InitPath();
//        initDi.run();
//
//        InitDirs initD=new InitDirs();
//        initD.setFileCount();

        dispose();
        println(task5);

        tripitaka_main.mainW=new MainWindow();
        tripitaka_main.mainW.setVisible(true);
        tripitaka_main.mainW.setVisible(true);
        tripitaka_main.mainW.setIconImage(image);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Initializing...");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/NamoBuddhaya.jpg"))); // NOI18N
        jLabel1.setText("Loading....");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 255, 51));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables


    //inner classes to perform essesntial tasks
    private void println(Object o){
        jTextArea1.append(o+"\n");
    }

    //test the database
    class ValidateDB{
        public void run(){
            println(task3);
            DataAdapter da=new DataAdapter();
            int pageCount=da.countRecords();
            println("Threre are "+pageCount+" pages in the database.");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(MetaDataInitializer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //class for detect java version
    class CheckJavaVersion {

        public void run(){
            println(task1);
            String jvmVer=System.getProperty("java.version").substring(0,3);
            float ver=Float.parseFloat(jvmVer);
            //System.out.println(ver);
            if(ver<1.6){
                println("Outdated Java Version!");
                URI getJava=null;
                try {
                    getJava = new URI("http://www.java.com/en/download/manual.jsp");
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MetaDataInitializer.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    //java.awt.Desktop.getDesktop().browse(getJava);
                    new Launcher().launch(getJava.getPath());

                } catch (Exception ex) {
                    Logger.getLogger(MetaDataInitializer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                println("Java Version is compatible");
            }
        }
    }

    //class for detect fonts
    class FontDetector {
        public void run(){
            println(task2);
            GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
            String fontArr[]=ge.getAvailableFontFamilyNames();
            String efont1="Tipitaka_Sinhala1";
            String efont2="Iskoola Pota";
            String efont3="Times_CSX+";
            boolean isF1=false;
            boolean isF2=true;
            boolean isF3=true;
            for(String fontFamily:fontArr){
                if(fontFamily.equalsIgnoreCase(efont1))
                    isF1=true;
                else if(fontFamily.equals(efont2))
                    isF2=true;
                else if(fontFamily.equals(efont3))
                    isF3=true;
            }
            if(!isF1 && !isF2 && !isF3){
                println("Essential fonts are not available.");
            }
            else if(!isF1){
                println(efont1+" is not found!");
            }else if (!isF2){
                println(efont2+" is not found!");
            }else if (!isF3){
                println(efont2+" is not found!");
            }else{
                println("Font detection is OK");
            }
            installFonts();
        }
    }

    private void installFonts(){
        try {
            String source = "Fonts" + File.separator;
            File sourceFonts = new File(source);
            File sourceFontArr[] = sourceFonts.listFiles();
            String destFontDir = getFontDir();
            for (File fl : sourceFontArr) {
                if (fl.isFile()) {
                    File destFile = new File(destFontDir + getFileName(fl.toString()));
                    if (!destFile.isFile()) {
                        boolean bl = fontCopy(fl, destFile);
                        System.out.println(getFileName(fl.toString()) + " copied :" + bl);
                        println(getFileName(fl.toString()) + " installed :" + bl);
                    }
                }
            }
        } catch (Exception e) {
            println("Some font files are missing!");
            System.out.println("Some font files are missing!");
        }
        
    }
    
    public static boolean fontCopy(File source, File dest) {
        boolean result = false;
        try {
            InputStream in = new FileInputStream(source);
            if (!dest.isFile()) {
                OutputStream out = new FileOutputStream(dest);

                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
                result = true;
            }
        } catch (FileNotFoundException ex) {
            result = false;
        } catch (IOException e) {
            result = false;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    private String getFileName(String absPath){
        return absPath.substring(absPath.lastIndexOf(File.separator)+1);
    }

    private String getFontDir(){
        String str = System.getProperty("user.home");
        String winDrv = str.substring(0, 3);
        String template = winDrv + "WINDOWS" + File.separator + "Fonts" + File.separator;
        return template;
    }
    //class for initialize path
//    class InitPath {
//        public void run(){
//            println(task3);
//            File pathData=new File("./Path.data");
//            if(pathData.isFile()){
//                //file is available we have to read it for path data
//                try{
//                    FileReader fr=new FileReader(pathData);
//                    BufferedReader br=new BufferedReader(fr);
//                    String path=br.readLine();
//                    if(path!=null){
//                        //set the path which is already configured
//                        println("Path is already configured");
//                        MetaData.tripitakaDirectory=path;
//                        println("Tripitaka path :\n"+path);
//                    }else{
//                        println("Path is not configured yet!");
//                    }
//                    br.close(); //close the bufferedreader
//                }catch(FileNotFoundException e){
//                    e.printStackTrace();
//                }catch(IOException e){
//                    e.printStackTrace();
//                }
//            }else{
//                //file is not available i am going to create it
//                try{
//                    pathData.createNewFile();
//                }catch(IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
    
    //class for init directories
//    class InitDirs{
//        int fileCount;
//
//        public InitDirs() {
//            fileCount=0;
//            println(task4);
//        }
//
//
//        String getExtension(String file){
//        //return file extension of a given file
//            return (file.substring(file.lastIndexOf(".")+1).toUpperCase());
//        }
//
//        void crawl(String path) {
//            //A recursive method for crawling pages
//            File tmpFl=new File(path);
//            File fileArr[]=tmpFl.listFiles();
//            for(File fileEl:fileArr){
//                if(fileEl.isDirectory()){
//                    crawl(fileEl.toString());
//                }else if(fileEl.isFile()){
//                    if(getExtension(fileEl.toString()).equals("HTML")||getExtension(fileEl.toString()).equals("HTM"))
//                        fileCount++;
//                }
//            }
//        }
//
//        void setFileCount(){
//            if(MetaData.tripitakaDirectory.equals("")){
//                println("Tripitaka directory is not found!");
//            }else{
//                crawl(MetaData.tripitakaDirectory);
//                println("File Count : "+fileCount);
//                MetaData.noOfFiles=fileCount;
//            }
//        }
//    }

    

}