import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.io.*;
import java.lang.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax .swing.table.DefaultTableModel;


public class TEST extends javax.swing.JFrame {

    /**
     * Creates new form bill
     */
    Object[][] data=null;
    String[] columnNames = new String[2];

   /*static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL="jdbc:mysql://localhost:3306/gdb?zeroDateTimeBehavior=convertToNull";
   //static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";*/



    public TEST() {
        initComponents();
        CurrentDate();

           }

    public void CurrentDate(){
    Calendar cal=new GregorianCalendar();
    int month=cal.get(Calendar.MONTH);
    int year=cal.get(Calendar.YEAR);
    int day=cal.get(Calendar.DAY_OF_MONTH);
    Date.setText(day+"-"+(month+1)+"-"+year);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        netprofit = new javax.swing.JButton();
        netsum = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Date");

        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null, null, null, null},
                {"", null, null, null, "", null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Job No", "Item", "Billed Amount", "Parts cost", "Net Profit", "Percentage"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(20);
        jTable1.setRowMargin(2);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Job No");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Item");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Billed Amount");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Parts cost");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Net Profit");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Percentage");
        }

        netprofit.setText("Total Profit");
        netprofit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netprofitActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(netprofit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(netsum, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(save)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(netprofit)
                    .addComponent(netsum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(save)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Date.getAccessibleContext().setAccessibleName("date");
        save.getAccessibleContext().setAccessibleName("save");

        pack();
    }// </editor-fold>                        



    private void DateActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:

    }                                    

    private void netprofitActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:

    }                                         

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:

        Connection conn = null;

   Statement stmt = null;

        int count=jTable1.getRowCount();
        int col=jTable1.getColumnCount();
       String jobno[] =new String[count]; // name is array and index 4 means no. of row 
        String item[]=new String[count]; 
        String bill[] =new String[count]; // name is array and index 4 means no. of row 
         String part[]=new  String[count]; 
       String profit[] =new  String[count]; // name is array and index 4 means no. of row 
       String percent[]=new  String[count]; 

       for(int i=0;i<=count;i++) 
 {
     for(int j=0;j<=col;j++)
     {
 no[i]=jTable1.getValueAt(i,j).toString(); // it get value from 0 row and 0 column
it[i]=jTable1.getValueAt(i,j).toString();
 amount[i]=jTable1.getValueAt(i,j).toString();
 p[i]=jTable1.getValueAt(i,j).toString();
 cost[i]=jTable1.getValueAt(i,j).toString();
s[i]=jTable1.getValueAt(i,j).toString();


        try{

            String sql="INSERT INTO m (no,it,amount,cost,sell,p,date) VALUES('"+no[i]+"','"+it[i]+"','"+amount[i]+"','"+p[i]+"','"+cost[i]+"','"+s[i]+"','"+Date.getText()+"')";
          //  stmt.execute(sql);
            stmt.executeQuery(sql);
            //stmt.execute(sql);
            /*PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, "");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setString(6, "");
            ps.setString(7,Date.getText());
            ps.execute();*/

             JOptionPane.showMessageDialog(null,"saved");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
 }
    }                                    

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

         Connection conn = null;

   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
       //Class.forName("jdbc:mysql://localhost:3306/ganpatidb?zeroDateTimeBehavior=convertToNull");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ganpatidb", "root", "root");

      //STEP 4: Execute a query
      System.out.println("Creating database...");
      stmt = conn.createStatement();


   }catch(SQLException se){
      //Handle errors for JDBC
     // se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
     // e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         //se.printStackTrace();
      }//end finally try
   }//end try
   //System.out.println("Goodbye!");

        //int r=jTable1.selectedrow;
        //jTable1.getValue(3,3);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField Date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton netprofit;
    private javax.swing.JTextField netsum;
    private javax.swing.JButton save;
    // End of variables declaration                   
}