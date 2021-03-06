//Array
import java.util.ArrayList;
import java.lang.String;

//koneksi
//import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//gui
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

//button
import java.awt.event.*; 
import javax.swing.*; 

//button-event
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

// Packages to import 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 


//view08-3
//Class SQL untuk melakukan methode INSERT
class SqlInsert {  
      SqlInsert(String id_obat, String nama_obat, String kandungan) {  
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:C:/Users/Asus/Downloads/3_bluej/CRUDdataObatdb.db"; //yourPathDirectory-SQLITE-database
            Connection conn = DriverManager.getConnection(dbURL);
            
            if (conn != null) {
                Statement st=conn.createStatement();        
                String sql ="INSERT INTO list_obat VALUES ("+id_obat+",'"+nama_obat+"', '"+kandungan+"');"; //SQL-INSERT
                st.executeUpdate (sql);
                conn.close();
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


//view09-3
//Class SQL untuk melakukan methode UPDATE
class SqlUpdate {
      SqlUpdate(String id_obat, String nama_obat, String kandungan) {  
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:C:/Users/Asus/Downloads/3_bluej/CRUDdataObatdb.db"; //yourPathDirectory-SQLITE-database
            Connection conn = DriverManager.getConnection(dbURL);
            
            if (conn != null) {
                Statement st=conn.createStatement();        
                String sql ="UPDATE list_obat SET nama_obat='"+nama_obat+"',kandungan='"+kandungan+"' WHERE id_obat="+id_obat+";"; //SQL-UPDATE
                st.executeUpdate (sql);
                conn.close();
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}


//view10-3
//Class SQL untuk melakukan methode DELETE
class SqlDelete {
      SqlDelete(String id_obat, String nama_obat, String kandungan) {  
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:C:/Users/Asus/Downloads/3_bluej/CRUDdataObatdb.db"; //yourPathDirectory-SQLITE-database
            Connection conn = DriverManager.getConnection(dbURL);
            
            if (conn != null) {
                Statement st=conn.createStatement();        
                String sql = "DELETE FROM list_obat WHERE id_obat="+id_obat+";"; //SQL-DELETE
                st.executeUpdate (sql);
                conn.close();
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
}







// main class Program CRUD_Data_Obat
public class CRUD_Data_Obat extends JFrame implements ActionListener {  

    //view11-3
    // JFrame dideklarasi menjadi f
    static JFrame f; 

    // JButton 
    static JButton databaseB,newB,EditB,DelB; 

    // label to display CRUD_Data_Obat 
    static JLabel judul,l,idLabel,nmLabel,kdgLabel; 

    // JTextField 
    static JTextField idT,nmT;
    
    static JRadioButton Sulf, nSulf;
    static ButtonGroup bg;
    
    
    //view04-2
    //event btn
    private static void btnDatabaseActionPerformed(java.awt.event.ActionEvent evt) {                                             
       String x = "";
       String y = "";
       String z = "";
       
       JTableExamplesSatu jtes = new JTableExamplesSatu();
       //SqlSelect SSel = new SqlSelect(x,y,z);  //mengecek class->function SqlSelect()
    }
    private javax.swing.JButton btnDatabase;//btnDatabase
    
    
    //view08-2
    private static void btnNewActionPerformed(java.awt.event.ActionEvent evt) {                                             
       String x = idT.getText();
       String y = nmT.getText();

       String z = " "; 
       if (Sulf.isSelected()) { 
           z = "Sulfa"; 
       } 
       else if (nSulf.isSelected()) { 
           z = "Non-Sulfa"; 
       } 
       else { 
           z = "Not Selected"; 
       } 
       
       SqlInsert SIns = new SqlInsert(x,y,z);
    }
    private javax.swing.JButton btnNew;//btnNew 
    
    
    //view09-2
    private static void btnEditActionPerformed(java.awt.event.ActionEvent evt) {                                             
       //System.out.println ("Email \t \t \t Telpn \t \t Kelamin \t Tgl Lahir");
       
       String x = idT.getText();
       String y = nmT.getText();
       
       String z = " "; 
       if (Sulf.isSelected()) { 
           z = "Sulfa"; 
       } 
       else if (nSulf.isSelected()) { 
           z = "Non-Sulfa"; 
       } 
       else { 
           z = "Not Selected"; 
       } 
       
       SqlUpdate SUpd = new SqlUpdate(x,y,z);
    }
    private javax.swing.JButton btnEdit;//btnEdit  
    
    
    //view10-2
    private static void btnDelActionPerformed(java.awt.event.ActionEvent evt) {                                             
       String x = idT.getText();
       String y = "";
       String z = ""; 

       SqlDelete SDel = new SqlDelete(x,y,z);
    }
    private javax.swing.JButton btnDel;//btnDel
    
    
    
    
    //view01
    // main class-> Function Program CRUD_Data_Obat
    public static void main(String[] args) 
    { 
        
        //System.out.print("\u000c"); //Membersihkan Layar
        
        //view02
        // create a new frame to store CRUD_Data_Obat field and button 
        f = new JFrame("Form CRUD Data Obat"); 
        
        //view03
        // create a label to display CRUD_Data_Obat 
        judul = new JLabel("Form CRUD Data Obat");
        

        //view04-1
        databaseB = new JButton("Show Database");
        databaseB.setBounds(50, 40, 330, 20);
        databaseB.setName("btnDatabase");
        databaseB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatabaseActionPerformed(evt);
                
            }
        });
        
        
        //view05-1
        idLabel = new JLabel("ID");
        idLabel.setBounds(50, 70, 150, 30);
        
        //view05-2
        idT = new JTextField("", 16);
        idT.setBounds(140, 70, 240, 30);
        
        //view06-1
        nmLabel = new JLabel("Nama Obat");
        nmLabel.setBounds(50, 100, 150, 30);
        
        //view06-2
        nmT = new JTextField("", 16);
        nmT.setBounds(140, 100, 240, 30);

        //view07-1
        // Defining Kandungan Buttons
        kdgLabel = new JLabel("Kandungan");
        kdgLabel.setBounds(50, 130, 150, 30);
        
        //view07-2
        Sulf = new JRadioButton("Sulfa");
        Sulf.setBounds(140, 130, 60, 30);

        //view07-3
        nSulf = new JRadioButton("Non-Sulfa");
        nSulf.setBounds(210, 130, 100, 30);            

        //view07-4
        bg = new ButtonGroup(); 
        bg.add(Sulf); 
        bg.add(nSulf); 
        
        
        // create a object of the CRUD_Data_Obat class 
        //CRUD_Data_Obat te = new CRUD_Data_Obat(); 
        
        
        //view08-1
        // create a new button 
        newB = new JButton("[+] Buat Baru");
        newB.setBounds(140, 170, 240, 20);
        newB.setName("btnNew");
        newB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)  {
                btnNewActionPerformed(evt);

            }
        });
        
        
        //view09-1
        EditB = new JButton("Update / Edit");
        EditB.setBounds(140, 200, 110, 20);
        EditB.setName("btnEdit");
        EditB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);

            }
        });
        
        
        //view10-1
        DelB = new JButton("Delete");
        DelB.setBounds(270, 200, 110, 20);
        DelB.setName("btnDel");
        DelB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);

            }
        });
        
        
        //view11-1
        // create a panel 
        JPanel p = new JPanel();   

        //view11-2
        // add buttons and textfield to panel
        p.add(judul); //judul
        
        // deklarasi f
        
        //view11-4
        f.add(databaseB);
        
        f.add(idLabel); //id
        f.add(idT); 
        f.add(nmLabel); //nama
        f.add(nmT); 
        
        f.add(kdgLabel); //kandungan
        f.add(Sulf);
        f.add(nSulf);
        
        
        f.add(newB);  //Menambahkan Data Baru
        f.add(EditB); //Mengedit data by Id
        f.add(DelB); //Menghapus data by Id
        
        
        // add panel to frame 
        f.add(p); 
        
        // set the size of frame 
        f.setSize(440, 320); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.show(); 
        
        //view12 - auto menjalankan show JTable
        JTableExamplesSatu jtes = new JTableExamplesSatu();
    } 

    //view13 - Eksekusi Ketika Tombol ditekan
    // if the button is pressed 
    public void actionPerformed(ActionEvent e) 
    { 

    } 
    
} 






//view04-4
//Class SQL untuk melakukan methode SELECT
class SqlSelect {
        
    String dataSatu[][]=new String[20][5]; //Data-Array Yang di Transfer 
    
    SqlSelect(String id_obat, String nama_obat, String kandungan) {  
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:C:/Users/Asus/Downloads/3_bluej/CRUDdataObatdb.db"; //yourPathDirectory-SQLITE-database
            Connection conn = DriverManager.getConnection(dbURL);
            
            if (conn != null) {
                String x;
                String y;
                String z;
                int berhitung=0;
                

                Statement st=conn.createStatement();        
                ResultSet rs=st.executeQuery("SELECT * FROM list_obat;");
                
                while (rs.next()){
                  //Mengambil ResultSet dari NamaTable di Database 
                  x = rs.getString("id_obat");
                  y = rs.getString("nama_obat");
                  z = rs.getString("kandungan");
                  
                  //Menyimpan hasil ResultSet ke dalam Array Dua Dimensi
                  dataSatu[berhitung][0] = x;
                  dataSatu[berhitung][1] = y;
                  dataSatu[berhitung][2] = z;
                  
                  //Jumlah Data Didalam Database
                  berhitung = berhitung + 1;
                  
                }
                
                
                /*
                String[][] data = { 
                  { "01", "Probiotik", "Sulfa" },
                  { "02", "Kencur", "NonSulfa" }, 
                  { "03", "Silicat", "Sulfa" },
                  { "04", "Jamu", "NonSulfa" }
                }; 
                */
                
                
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public String[][] getDataArray(){  //membuat function -> Data-Array Yang di Transfer
        return this.dataSatu.clone();  //Menampilkan Data-Array Yang di Transfer
    }
}


//view04-3
class JTableExamplesSatu { 
    // frame 
    JFrame f; 
    // Table 
    JTable j; 

    // Constructor 
    JTableExamplesSatu() 
    { 
        // Frame initiallization 
        f = new JFrame();  

        // Frame Title 
        f.setTitle("Table from Database - CRUDdataObatdb.db - Form CRUD Data Obat"); 

        String x = "";
        String y = "";
        String z = ""; 
        
        
        // Data yg akan di Tampilkan pada JTable bila SqlSelect GAGAL koneksi ke database
        // [][]
        String[][] data = { 
            { "01", "Probiotik", "Sulfa" },
            { "02", "Kencur", "NonSulfa" }, 
            { "03", "Silicat", "Sulfa" },
            { "04", "Jamu", "NonSulfa" }
        }; 
        
        SqlSelect SSel = new SqlSelect(x,y,z);
        data = SSel.getDataArray();  //Data-Array Yang di Transfer 
        
        // Column Names  //Kolom Nama
        String[] columnNames = { "ID", "Nama Obat", "Kandungan" }; 

        // Initializing the JTable   //inisialisasi JTable
        j = new JTable(data, columnNames); 
        j.setBounds(30, 40, 200, 300); 

        // adding it to JScrollPane  //menambahkan buttom scroll
        JScrollPane sp = new JScrollPane(j); 
        f.add(sp); 

        // Frame Size 
        f.setSize(700, 200); 

        // Frame Visible = true 
        f.setVisible(true); 
    } 
    
} 


