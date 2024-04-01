
package myclass.testdb;

import java.awt.Image;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SUN_KaveewatPC
 */
public class ShopCustomer extends javax.swing.JFrame {

    private String Username;
    
    
    
    public ShopCustomer() {
        initComponents();
    }
    
    

    ShopCustomer(String myUser) throws SQLException {
        initComponents();
        Username = myUser;
       jLabel2.setText("NAME : " + Username);
       jComboBox1.addItem("All");
        
        try {
            String sql = "SELECT * FROM category";
            DbConnector CON0123 = new DbConnector();
            ResultSet rs = CON0123.Getresultset(sql);
            while (rs.next()) {
                String name = rs.getString("Category_Name");
                jComboBox1.addItem(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setProduct();
        
       
    }
    ShopCustomer(String myUser , String card , String QTY) throws SQLException {
        initComponents();
        Username = myUser;
       jLabel2.setText("NAME : " + Username);
       jComboBox1.addItem("All");
        
        try {
            String sql = "SELECT * FROM category";
            DbConnector CON0123 = new DbConnector();
            ResultSet rs = CON0123.Getresultset(sql);
            while (rs.next()) {
                String name = rs.getString("Category_Name");
                jComboBox1.addItem(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setProductCategory();
        
       
    }
private int page;
private String pro1 , pro2 , pro3 , pro4 , pro5 , pro6;

    public void setProduct() throws SQLException{
        reDisplay();
        rebut();
         page = Integer.parseInt(jTextField1.getText());
        
        String sql1 = ("SELECT * FROM product");
        DbConnector Connec = new DbConnector();
        ResultSet rs = Connec.Getresultset(sql1);
        String[] strID = new String[100];
        String[] strName = new String[100];
        String[] strbrand = new String[100];
        String[] strCategory = new String[100];
        String[] strPrice = new String[100];
        String[] strDetail = new String[100];
        String[] strQTY = new String[100];
        String[] strPicture = new String[100];
        int i = 0;
        while(rs.next())
        {
            strID[i] = rs.getString(1);
            strName[i] = rs.getString(2);
            strbrand[i] = rs.getString(3);
            strCategory[i] = rs.getString(4);
            strPrice[i] = rs.getString(5);
            strDetail[i] = rs.getString(6);
            strQTY[i] = rs.getString(7);
            strPicture[i] = rs.getString(8);
            
            System.out.println("StrID,Name = " + strID[i] +" , " + strName[i]);
            System.out.println("QTY,Picture = " + strQTY[i] +" , " + strPicture[i]);
            i++;
        }
        
        int page_ = page;
        System.out.println("\npage_ = "+page_);
        int spage_ = page * 6;
        int idpet = spage_ - 5;
        System.out.println("idpet = "+idpet);
        idpet--;
        int rp = 0;
            
            ImageIcon Icon1 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
            pro1 = strID[idpet];
            Image img1 = Icon1.getImage();
            Image imgScale1 = img1.getScaledInstance(jLabel4.getWidth() , jLabel4.getHeight() , Image.SCALE_SMOOTH);
            ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
            jLabel4.setIcon(scaledIcon1);
            System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
            idpet++;         
            ImageIcon Icon2 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
            pro2 = strID[idpet];
            Image img2 = Icon2.getImage();
            Image imgScale2 = img2.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
            ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
            jLabel5.setIcon(scaledIcon2);
            System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
            idpet++;
            ImageIcon Icon3 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
            pro3 = strID[idpet];
            Image img3 = Icon3.getImage();
            Image imgScale3 = img3.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
            ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
            jLabel6.setIcon(scaledIcon3);
            System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
            idpet++;
            ImageIcon Icon4 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
            pro4 = strID[idpet];
            Image img4 = Icon4.getImage();
            Image imgScale4 = img4.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
            ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
            jLabel9.setIcon(scaledIcon4);
            System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
            idpet++;
            ImageIcon Icon5 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
            pro5 = strID[idpet];
            Image img5 = Icon5.getImage();
            Image imgScale5 = img5.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
            ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
            jLabel8.setIcon(scaledIcon5);
            System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
            idpet++;
            ImageIcon Icon6 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
            pro6 = strID[idpet];
            Image img6 = Icon6.getImage();
            Image imgScale6 = img6.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
            ImageIcon scaledIcon6 = new ImageIcon(imgScale6);
            jLabel7.setIcon(scaledIcon6);
        
        System.out.println(pro1 + pro2 + pro3 +pro4 + pro5 +pro6);
    
    }
    public void rebut(){
        jButton3.setText("BUY");
                jButton8.setText("BUY");
                jButton7.setText("BUY");
                        jButton4.setText("BUY");
                        jButton5.setText("BUY");
                                jButton6.setText("BUY");
    
    }
    
    public void reDisplay(){
        jLabel4.setIcon(null);
        jLabel5.setIcon(null);
        jLabel6.setIcon(null);
        jLabel9.setIcon(null);
        jLabel8.setIcon(null);
        jLabel7.setIcon(null);
    }
    public void setProductCategory() throws SQLException{
        rebut();
        reDisplay();
        
        page = Integer.parseInt(jTextField1.getText());
        
        String getitem = (String) jComboBox1.getSelectedItem();
        
        System.out.println("selected item = " + getitem);
        String getItems = "";
        try {
            String sql = "SELECT * FROM category";
            DbConnector CON0123 = new DbConnector();
            ResultSet rs3 = CON0123.Getresultset(sql);
            while (rs3.next()) {
                String get = rs3.getString(2);
                if(getitem.equals(get)){
                    getItems = rs3.getString("Category_ID");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String sql1;
        if(getitem.equals("All")){
            sql1 = ("SELECT * FROM product");
        }else{
            sql1 = ("SELECT * FROM product WHERE Product_Category = '"+getItems+"' ");
        }
       // String sql1 = ("SELECT * FROM product");
        DbConnector Connec = new DbConnector();
        ResultSet rs = Connec.Getresultset(sql1);
        String[] strID = new String[100];
        String[] strName = new String[100];
        String[] strbrand = new String[100];
        String[] strCategory = new String[100];
        String[] strPrice = new String[100];
        String[] strDetail = new String[100];
        String[] strQTY = new String[100];
        String[] strPicture = new String[100];
        int i = 0;
        while(rs.next())
        {
            strID[i] = rs.getString(1);
            strName[i] = rs.getString(2);
            strbrand[i] = rs.getString(3);
            strCategory[i] = rs.getString(4);
            strPrice[i] = rs.getString(5);
            strDetail[i] = rs.getString(6);
            strQTY[i] = rs.getString(7);
            strPicture[i] = rs.getString(8);
        
        System.out.println("StrID,Name = " + strID[i] +" , " + strName[i]);
        System.out.println("QTY,Picture = " + strQTY[i] +" , " + strPicture[i]);
        i++;
        }
        
        int page_ = page;
        System.out.println("\npage_ = "+page_);
        int spage_ = page * 6;
        int idpet = spage_ - 5;
        System.out.println("idpet = "+idpet);
        idpet--;
        int rp = 0;
        
        
        
        ImageIcon Icon1 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
        pro1 = strID[idpet];
        if(Integer.parseInt(strQTY[idpet])< 1){
            jButton3.setText("OUT");
        } 
        Image img1 = Icon1.getImage();
        Image imgScale1 = img1.getScaledInstance(jLabel4.getWidth() , jLabel4.getHeight() , Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
        jLabel4.setIcon(scaledIcon1);
        
        
        
        System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
        idpet++;
        ImageIcon Icon2 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
        pro2 = strID[idpet];
        if(Integer.parseInt(strQTY[idpet])< 1){
            jButton8.setText("OUT");
        } 
        Image img2 = Icon2.getImage();
        Image imgScale2 = img2.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
        jLabel5.setIcon(scaledIcon2);
        
        
        
        System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
        idpet++;
        ImageIcon Icon3 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
        pro3 = strID[idpet];
        if(Integer.parseInt(strQTY[idpet])< 1){
            jButton7.setText("OUT");
        } 
        Image img3 = Icon3.getImage();
        Image imgScale3 = img3.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
        jLabel6.setIcon(scaledIcon3);
        
        
        
        System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
        idpet++;
        ImageIcon Icon4 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
        pro4 = strID[idpet];
        if(Integer.parseInt(strQTY[idpet]) < 1){
            jButton4.setText("OUT");
        } 
        Image img4 = Icon4.getImage();
        Image imgScale4 = img4.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
        jLabel9.setIcon(scaledIcon4);
        
        
        
        System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
        idpet++;
        ImageIcon Icon5 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
        pro5 = strID[idpet];
        if(Integer.parseInt(strQTY[idpet]) < 1){
            jButton5.setText("OUT");
        } 
        Image img5 = Icon5.getImage();
        Image imgScale5 = img5.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
        ImageIcon scaledIcon5 = new ImageIcon(imgScale5);
        jLabel8.setIcon(scaledIcon5);
        
        
        
        System.out.println("strPicture = "+strPicture[idpet] + "strID" + strID[idpet]);
        idpet++;
        ImageIcon Icon6 = new ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\Pet\\" + strPicture[idpet]);
        pro6 = strID[idpet];
        if(Integer.parseInt(strQTY[idpet]) < 1){
            jButton6.setText("OUT");
        } 
        Image img6 = Icon6.getImage();
        Image imgScale6 = img6.getScaledInstance(jLabel5.getWidth() , jLabel5.getHeight() , Image.SCALE_SMOOTH);
        ImageIcon scaledIcon6 = new ImageIcon(imgScale6);
        jLabel7.setIcon(scaledIcon6);
        
        System.out.println(pro1 + pro2 + pro3 +pro4 + pro5 +pro6);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("NAME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText(">");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 40, 40));

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 40, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 140, 140));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jButton3.setText("BUY");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 60, -1));

        jButton4.setText("BUY");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 60, -1));

        jButton5.setText("BUY");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, 60, -1));

        jButton6.setText("BUY");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 60, -1));

        jButton7.setText("BUY");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 60, -1));

        jButton8.setText("BUY");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 60, -1));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("1");
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 40, 40));

        jButton11.setText("INFOR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 70, -1));

        jButton12.setText("INFOR");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 190, 70, -1));

        jButton13.setText("INFOR");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 70, -1));

        jButton14.setText("INFOR");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 70, -1));

        jButton15.setText("INFOR");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 70, -1));

        jButton16.setText("INFOR");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 70, -1));

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton9.setText("CART");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String select = jButton5.getText();
        if(select.equals("BUY")){
            String m = JOptionPane.showInputDialog("Enter Amount?", 1);
            System.out.println(m + pro5);

            list1.add(pro5);
            list2.add(m);
        }else{
        JOptionPane.showMessageDialog(frame, "OUT OF STOCK!");
        }
       
    }//GEN-LAST:event_jButton5ActionPerformed
private JFrame frame;
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        CART ct = new CART(list1 , list2 , Username );
        ct.setVisible(true);


    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            int p = Integer.parseInt(jTextField1.getText());
            p++;
            jTextField1.setText(""+p);
            setProduct();
            setProductCategory();
        } catch (SQLException ex) {
            Logger.getLogger(ShopCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            int p = Integer.parseInt(jTextField1.getText());
            p--;
            jTextField1.setText(""+p);
            setProduct();
            setProductCategory();
        } catch (SQLException ex) {
            Logger.getLogger(ShopCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

private ArrayList<String> list1 = new ArrayList<>(); 
private ArrayList<String> list2 = new ArrayList<>(); 
private ArrayList<String> list3 = new ArrayList<>(); 
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        String select = jButton3.getText();
        if(select.equals("BUY")){
            String m = JOptionPane.showInputDialog("Enter Amount?", 1);
            System.out.println(m + pro1);

            list1.add(pro1);
            list2.add(m);

        }else{
            JOptionPane.showMessageDialog(frame, "OUT OF STOCK!");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String select = jButton8.getText();
        if(select.equals("BUY")){
            String m = JOptionPane.showInputDialog("Enter Amount?", 1);
            System.out.println(m + pro2);

            list1.add(pro2);
            list2.add(m);
        }else{
            JOptionPane.showMessageDialog(frame, "OUT OF STOCK!");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String select = jButton7.getText();
        if(select.equals("BUY")){
            String m = JOptionPane.showInputDialog("Enter Amount?", 1);
            System.out.println(m + pro3);

            list1.add(pro3);
            list2.add(m);
        }else{
            JOptionPane.showMessageDialog(frame, "OUT OF STOCK!");
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String select = jButton4.getText();
        if(select.equals("BUY")){
            String m = JOptionPane.showInputDialog("Enter Amount?", 1);
            System.out.println(m + pro4);

            list1.add(pro4);
            list2.add(m);
        }else{
            JOptionPane.showMessageDialog(frame, "OUT OF STOCK!");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String select = jButton6.getText();
        if(select.equals("BUY")){
            String m = JOptionPane.showInputDialog("Enter Amount?", 1);
            System.out.println(m + pro6);

            list1.add(pro6);
            list2.add(m);
        }else{
        JOptionPane.showMessageDialog(frame, "OUT OF STOCK!");
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked

        
        
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            setProductCategory();
        } catch (SQLException ex) {
            Logger.getLogger(ShopCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ProductInfor pi = new ProductInfor(pro6 , Username);
        pi.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        ProductInfor pi = new ProductInfor(pro1 , Username);
        pi.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        ProductInfor pi = new ProductInfor(pro2 , Username);
        pi.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        ProductInfor pi = new ProductInfor(pro3 , Username);
        pi.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        ProductInfor pi = new ProductInfor(pro4 , Username);
        pi.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        ProductInfor pi = new ProductInfor(pro5 , Username);
        pi.setVisible(true);
    }//GEN-LAST:event_jButton16ActionPerformed

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
            java.util.logging.Logger.getLogger(ShopCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShopCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShopCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShopCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShopCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
