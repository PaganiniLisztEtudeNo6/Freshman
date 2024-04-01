
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.*;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Hp
 */
public class Main extends javax.swing.JFrame {
    
    Random rd = new Random(); 
      
    int money = 0;
    
    Timer cooldown;
    Timer cooldown1;
    int Card_Num_rd_player1 = 0 ;
    int Card_Num_rd_player2 = 0 ;
    int Card_Num_rd_player3 = 0 ;
    int Card_Sb_rd_player1 = 0 ;
    int Card_Sb_rd_player2 = 0 ;
    int Card_Sb_rd_player3 = 0 ;
    int Card_Num_rd_Bot1 = 0 ;
    int Card_Num_rd_Bot2 = 0 ;
    int Card_Num_rd_Bot3 = 0 ;
    int Card_Sb_rd_Bot1 = 0 ;
    int Card_Sb_rd_Bot2 = 0 ;
    int Card_Sb_rd_Bot3 = 0 ;
    int money_Bit =0;
    
    int sum_1 = 0;
    int sum_2 = 0;

    int sum_1_bot = 0;
    int sum_2_bot = 0;
    
    int sum__ = 0;
 
    String Sta = "";
    
    String date = "";
    String time = "";
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        
        //BG_MAIN.setIcon(new ImageIcon("src\\main\\java\\Image_2\\BG_MAIN.jpg"));
        jButton1.hide();
        jButton2.hide(); 
        jLabel4.hide();
        jLabel5.hide();
        jTable1.hide();
        jScrollPane1.hide();
        
        datetime();
        
        
        
        
    }

  
    String playername1;
    String moneyy11;
    Main(String playername, String moneyy1) {
        initComponents();
        this.playername1 = playername;
        this.moneyy11 = moneyy1;
        T_Name.setText(playername1);
        T_money.setText(moneyy11);
        jTable1.hide();
        jScrollPane1.hide();
        //BG_MAIN.setIcon(new ImageIcon("src\\main\\java\\Image_2\\BG_MAIN.jpg"));
        jButton1.hide();
        jButton2.hide(); 
        jLabel4.hide();
        jLabel5.hide();
        
        datetime();
    }

 

   
   
    
    public void datetime(){
        Date dd = new Date();
        SimpleDateFormat dt01 = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat dt02 = new SimpleDateFormat("H:mm:ss");
        date = dt01.format(dd);
        time = dt02.format(dd);    
           
    }
  
    public void delay(){
        
        cooldown = new Timer (2000 , new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {

                 
                 String AA = test_score.getText();
                 String BB = BotScore.getText();
                 
                 if("Tong".equals(AA)){AA = "7";}
                 if("Straight Flush".equals(AA)){AA = "6";}
                 if("Straight".equals(AA)){AA = "5";}
                 if("Tong".equals(BB)){AA = "7";}
                 if("Straight Flush".equals(BB)){AA = "6";}
                 if("Straight".equals(BB)){AA = "5";}
                 
                 int AAA = Integer.parseInt(AA);
                 int BBB = Integer.parseInt(BB);
                 
                 
                 if(AAA == BBB){                   
                     
                     jLabel6.show();
                     jLabel8.show();
                     jLabel6.setIcon(new ImageIcon("src\\main\\java\\Image_2\\FrameTIE.png"));
                     Sta = "TIE";
                     
                     int summoney = money_Bit;
                     int summoney1 = Integer.parseInt(T_money.getText());
                     jLabel7.setText(" ");                                      
                             
                     jButton2.show();
                     int a = summoney+summoney1;
                     T_money.setText("");
                     T_money.setText(""+a);
                 
                 }else if(AAA > BBB){
                           
                     int Bonus = 2;
                     jLabel6.show();
                     jLabel8.show();
                     Sta = "WIN";
                     jLabel7.setText(" ");
                     if((xtext.getText().equals("x2"))){Bonus++;}
                     if((xtext.getText().equals("x3"))){Bonus = Bonus+2;}                   
                             
                     jLabel6.setIcon(new ImageIcon("src\\main\\java\\Image_2\\FrameGame.png"));   
                     
                     getmoney.setText(" ");    
                     money_Bit = money_Bit*Bonus;
                     getmoney.setText(""+money_Bit);   
                     jButton1.show();                                         
                     
                     int summoney = Integer.parseInt(getmoney.getText());
                     int summoney1 = Integer.parseInt(T_money.getText());
                     int summ = summoney1+summoney;
                     T_money.setText("");
                     T_money.setText(""+summ);
                     
                 }else if (AAA < BBB){
                     
                     int Bonus = 1;
                     
                     if((BotScore2.getText().equals("x2"))){Bonus++;}
                     if((BotScore2.getText().equals("x3"))){Bonus = Bonus+2;}                                                 
                     jLabel6.hide();
                     jLabel8.show();
                     Sta = "LOSE";
                     jLabel7.setText(" ");
                     jLabel8.setIcon(new ImageIcon("src\\main\\java\\Image_2\\FrameGame2_.png"));  
                     money_Bit = money_Bit * Bonus;
                     
                     getmoney.setText(" ");    
                     getmoney.setText(""+money_Bit);   
                     
                     int summoney = Integer.parseInt(getmoney.getText());
                     int summoney1 = Integer.parseInt(T_money.getText());
                     int summ = summoney1-summoney;
                     T_money.setText("");
                     T_money.setText(""+summ); 
                     
                     jButton2.show();                                                              
                                                 
                 }                                                                   
                 cooldown.stop();           
            }
        });
    }
    
    public void delay1(){
        cooldown1 = new Timer (1000 , new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {

                 /*
             jLabel6.setText(" ");    
             money_Bit = money_Bit*2;
             jLabel6.setText("Money + "+money_Bit);   
             */
             
             cooldown1.stop();
            }
        });
    }
    
    public void delay2(){
        cooldown1 = new Timer (1000 , new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {

             
             cooldown1.stop();
            }
        });
    }
    
    
    

    public void BotCal(){     
        
        Card_Bot3.show();
        /*
            Card_Num_rd_Bot3 = rd.nextInt(13);
            Card_Sb_rd_Bot3 = rd.nextInt(3);*/
        
            
        
            Card_Bot3.setIcon(new ImageIcon("src\\main\\java\\Image_2\\"+(Card_Num_rd_Bot3+1)+"_"+(Card_Sb_rd_Bot3+1)+".jpg"));
            
            Card_Num_rd_Bot3++;
            Card_Sb_rd_Bot3++;
            
            if (Card_Num_rd_Bot3 > 9 ){Card_Num_rd_Bot3 = 10;}
         
            sum__ = sum_2_bot + Card_Num_rd_Bot3;  
            
            if(sum__ > 9 )
            {   

                String asdf = (String.valueOf(sum__));
                char ch1 = asdf.charAt(1);    
                BotScore.setText(String.valueOf(ch1));
                   
            }
            else{

                BotScore.setText(String.valueOf(sum__));

                }
           
            
        if( Card_Sb_rd_Bot1 == Card_Sb_rd_Bot3 )
        {
            if(Card_Sb_rd_Bot3 == Card_Sb_rd_Bot2){BotScore2.setText("x3");
            if(Card_Num_rd_Bot1 == Card_Num_rd_Bot2){
                    if(Card_Num_rd_Bot2 == Card_Num_rd_Bot3){BotScore2.setText("x5");}}}
        }        
        if(Card_Num_rd_Bot1 == Card_Num_rd_Bot2)
        {
            if(Card_Num_rd_Bot2 == Card_Num_rd_Bot3){
                BotScore.setText("Tong");
                BotScore2.setText("x3");
                if(Card_Sb_rd_Bot1 == Card_Sb_rd_Bot2){
                    if(Card_Sb_rd_Bot2 == Card_Sb_rd_Bot3){BotScore2.setText("x5");}}}
        }
        
        if(Card_Num_rd_Bot1+1 == Card_Num_rd_Bot2)
        {
            if(Card_Num_rd_Bot2+1 == Card_Num_rd_Bot3)
            {
                BotScore.setText("Straight");
                BotScore2.setText("x2");
                if( Card_Sb_rd_Bot1 == Card_Sb_rd_Bot2 )
                {
                    if(Card_Sb_rd_Bot2 == Card_Sb_rd_Bot3)
                    {
                        BotScore.setText("Straight Flush");
                        if(Card_Num_rd_Bot1 == Card_Num_rd_Bot2){
                            if(Card_Num_rd_Bot2 == Card_Num_rd_Bot3){BotScore2.setText("x3");}}}}} // 123
        }
   
    }
    
    public void BACKCARDBOT()
    {
        Card_Bot01.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));
        Card_Bot02.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));

          
    }

    Main(String name, int money ,String money1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        /*
        this();
        T_Name.setText(name);
        T_money.setText(String.valueOf(money));
        draw.setEnabled(false);
        stay.setEnabled(false);
    */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        getmoney = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BotScore2 = new javax.swing.JLabel();
        xtext = new javax.swing.JLabel();
        Card_player3 = new javax.swing.JLabel();
        Card_player2 = new javax.swing.JLabel();
        Card_player1 = new javax.swing.JLabel();
        Card_Bot3 = new javax.swing.JLabel();
        Card_Bot02 = new javax.swing.JLabel();
        Card_Bot01 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        test_score = new javax.swing.JLabel();
        BotScore = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BG_MAIN = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Bit = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        T_Name = new javax.swing.JLabel();
        T_money = new javax.swing.JLabel();
        draw = new javax.swing.JButton();
        stay = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GamePD");
        setBackground(new java.awt.Color(0, 0, 0));
        setIconImages(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getmoney.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(getmoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, 340, 40));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setText("Collect");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 160, 70));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton2.setText("OK");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 160, 70));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 90)); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 790, 510));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 90)); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 790, 510));

        BotScore2.setBackground(new java.awt.Color(255, 255, 255));
        BotScore2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BotScore2.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(BotScore2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 90, 40));

        xtext.setBackground(new java.awt.Color(255, 255, 255));
        xtext.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        xtext.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(xtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, 90, 40));
        getContentPane().add(Card_player3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 480, 170, 230));
        getContentPane().add(Card_player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 170, 230));
        getContentPane().add(Card_player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 170, 230));
        getContentPane().add(Card_Bot3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 180, 240));
        getContentPane().add(Card_Bot02, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 170, 230));
        getContentPane().add(Card_Bot01, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 170, 230));

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 270, 70));

        test_score.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        test_score.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(test_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 420, 150, 30));

        BotScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BotScore.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(BotScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 280, 130, 30));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("score");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, 50, -1));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("score");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 50, -1));
        getContentPane().add(BG_MAIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1030, 720));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(153, 102, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setText("BIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 139, 42));
        jPanel4.add(Bit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 139, -1));

        jPanel3.setBackground(new java.awt.Color(153, 102, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Money");

        jLabel2.setText("Name");

        T_Name.setBackground(new java.awt.Color(0, 0, 0));
        T_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        T_money.setBackground(new java.awt.Color(0, 0, 0));
        T_money.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T_money, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(T_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(T_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(T_money, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 70));

        draw.setBackground(new java.awt.Color(153, 102, 0));
        draw.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        draw.setText("DRAW");
        draw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawActionPerformed(evt);
            }
        });
        jPanel4.add(draw, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, 80));

        stay.setBackground(new java.awt.Color(153, 102, 0));
        stay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stay.setText("STAY");
        stay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stayActionPerformed(evt);
            }
        });
        jPanel4.add(stay, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 90, 80));

        jButton4.setBackground(new java.awt.Color(102, 51, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton4.setText("Save & Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 180, 60));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA1234\\NB\\Pokdeng_project\\src\\main\\java\\Image_3\\TA2_ver5.jpg")); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -30, 1480, 140));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 736, 1440, -1));

        jTable1.setBackground(new java.awt.Color(102, 0, 102));
        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 0, 102), new java.awt.Color(102, 0, 102), new java.awt.Color(102, 0, 102), new java.awt.Color(102, 0, 102)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TIme", "Status", "YOU", "BOT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 310, 460));

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hp\\OneDrive\\Desktop\\JAVA1234\\NB\\Pokdeng_project\\src\\main\\java\\Image_3\\BG_ver1.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1443, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1440, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stayActionPerformed
        // TODO add your handling code here:        

        Bit.setEnabled(true);

        jLabel5.show();
        Card_Num_rd_Bot1 = rd.nextInt(13);
        Card_Sb_rd_Bot1 = rd.nextInt(3);

        Card_Num_rd_Bot2 = rd.nextInt(13);
        Card_Sb_rd_Bot2 = rd.nextInt(3);
        
        Card_Bot01.setIcon(new ImageIcon("src\\main\\java\\Image_2\\"+(Card_Num_rd_Bot1+1)+"_"+(Card_Sb_rd_Bot1+1)+".jpg"));
        Card_Bot02.setIcon(new ImageIcon("src\\main\\java\\Image_2\\"+(Card_Num_rd_Bot2+1)+"_"+(Card_Sb_rd_Bot2+1)+".jpg"));
        
        int score_cnrp1 = Card_Num_rd_Bot1+1; 
        int score_cnrp2 = Card_Num_rd_Bot2+1;                   
            
        if (score_cnrp1 > 9 ){score_cnrp1 = 10;}
        if (score_cnrp2 > 9 ){score_cnrp2 = 10;}

        
        sum_2_bot = score_cnrp1 + score_cnrp2;   
       
        if(sum_2_bot > 9 )
            {   
                String str = (String.valueOf(sum_2_bot));
                char ch = str.charAt(1);
                int sum__ = Character.getNumericValue(ch);
                sum_2_bot = sum__;
            } 
  
        if(sum_2_bot < 4)
        {           
           BotCal();               
        }
        else
        {
            BotScore.setText(String.valueOf(sum_2_bot));
            if(Card_Sb_rd_Bot1 == Card_Sb_rd_Bot2)
            {
            BotScore2.setText("x2");
            }
        }
             
        stay.setEnabled(false);
        draw.setEnabled(false);
        jLabel6.hide();  
        jLabel8.hide();
        
        
        delay();
        cooldown.start();
      
      
    }//GEN-LAST:event_stayActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        

        jLabel4.show();
        jLabel4.show();
        

        try 
        {
            
            money = Integer.parseInt(Bit.getText());
            int money_main = Integer.valueOf(T_money.getText());
                
            if(money == 0 || money > money_main )
            {
                Bit.setText("");
                throw new Exception();
            }
            else
            {
                money_Bit = Integer.parseInt(Bit.getText());              
                Bit.setText("");
                money_main = money_main - money_Bit;
                jLabel7.setText("Bit : "+money_Bit);                
                T_money.setText(String.valueOf(money_main));
            
                Card_Num_rd_player1 = rd.nextInt(13);
                Card_Sb_rd_player1 = rd.nextInt(3);

                Card_Num_rd_player2 = rd.nextInt(13);
                Card_Sb_rd_player2 = rd.nextInt(3);

         
        
            Card_player1.setIcon(new ImageIcon("src\\main\\java\\Image_2\\"+(Card_Num_rd_player1+1)+"_"+(Card_Sb_rd_player1+1)+".jpg"));
            Card_player2.setIcon(new ImageIcon("src\\main\\java\\Image_2\\"+(Card_Num_rd_player2+1)+"_"+(Card_Sb_rd_player2+1)+".jpg"));
            BACKCARDBOT();            
         
            draw.setEnabled(true);
            stay.setEnabled(true);            
            
            int score_cnrp1 = Card_Num_rd_player1+1; 
            int score_cnrp2 = Card_Num_rd_player2+1;                   
            
            if (score_cnrp1 > 9 ){score_cnrp1 = 10;}
            if (score_cnrp2 > 9 ){score_cnrp2 = 10;}
            
            sum_1 = score_cnrp1 + score_cnrp2;            
            sum_2 = score_cnrp1 + score_cnrp2;
            
            
            
            if(sum_2 > 9 )
            {   

                String str = (String.valueOf(sum_1));
                char ch = str.charAt(1);
                test_score.setText(String.valueOf(ch));
              
            }
            else {

                test_score.setText(String.valueOf(sum_1));

                }            
            
            if(Card_Sb_rd_player1 == Card_Sb_rd_player2){
            xtext.setText("x2");
            }                       
            }
            }
            catch(Exception e)
            {                
                JOptionPane.showMessageDialog(this, "Pls Enter Number in fill !","Warning !",JOptionPane.PLAIN_MESSAGE);               
            }            
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void drawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawActionPerformed
        // TODO add your handling code here:
        Card_player3.show();
        xtext.setText("");
        Card_Num_rd_player3 = rd.nextInt(13);
        Card_Sb_rd_player3 = rd.nextInt(3);
        Card_player3.setIcon(new ImageIcon("src\\main\\java\\Image_2\\"+(Card_Num_rd_player3+1)+"_"+(Card_Sb_rd_player3+1)+".jpg"));
        
     
        if( Card_Sb_rd_player1 == Card_Sb_rd_player2 )
        {
            if(Card_Sb_rd_player2 == Card_Sb_rd_player3){xtext.setText("x3");
                if(Card_Num_rd_player1 == Card_Num_rd_player2){
                    if(Card_Num_rd_player2 == Card_Num_rd_player3){xtext.setText("x4");}}
            }
        }
        
        if(Card_Num_rd_player1 == Card_Num_rd_player2)
        {
            if(Card_Num_rd_player2 == Card_Num_rd_player3){
                test_score.setText("Tong");
                xtext.setText("x3");
                if(Card_Sb_rd_player1 == Card_Sb_rd_player2){
                    if(Card_Sb_rd_player2 == Card_Sb_rd_player3){xtext.setText("x5");}}}
        }
        
        if(Card_Num_rd_player1+1 == Card_Num_rd_player2)
        {
            if(Card_Num_rd_player2+1 == Card_Num_rd_player3)
            {
                test_score.setText("Straight");
                xtext.setText("x2");
                if( Card_Sb_rd_player1 == Card_Sb_rd_player2 )
                {
                    if(Card_Sb_rd_player2 == Card_Sb_rd_player3)
                    {
                        test_score.setText("Straight Flush");
                        if(Card_Num_rd_player1 == Card_Num_rd_player2){
                            if(Card_Num_rd_player2 == Card_Num_rd_player3){xtext.setText("x3");}}
                    }
                }
            }           
        }         
        
        
        Card_Num_rd_player3++;
        if (Card_Num_rd_player3 > 9 ){Card_Num_rd_player3 = 10;}
        sum_1 = sum_1 + Card_Num_rd_player3;
  
        
        if(sum_1 > 9 )
            {   
                String str = (String.valueOf(sum_1));
                char ch = str.charAt(1);
                test_score.setText(String.valueOf(ch));            
            }
            else{
                test_score.setText(String.valueOf(sum_1));
                }      
        draw.setEnabled(false);

        
    }//GEN-LAST:event_drawActionPerformed

    String pl = "";
    String bt = "";
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TODO add your handling code here:
       bt = BotScore.getText();
       pl = test_score.getText();
       datetime();
        History();
        ReGame();
        getmoney.setText(" ");
        jScrollPane1.show();
        jLabel6.hide();
        jLabel8.hide();
        jTable1.show();        
        jLabel7.setText(" ");
        Card_player3.hide();
        Card_Bot3.hide();
        
        
        
        
        jButton2.hide();
        jButton1.hide();

        if(Integer.valueOf(T_money.getText()) <= 0){
        
            
        frame = new JFrame("Exit");

        JOptionPane.showConfirmDialog(frame , "Game over.","",JOptionPane.CLOSED_OPTION); 
        
            
        
            Game_over();
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
private JFrame frame;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        bt = BotScore.getText();
        pl = test_score.getText();
        datetime();
        History();
        ReGame();
        getmoney.setText(" ");
        jScrollPane1.show();
        jLabel6.hide();
        jLabel8.hide();
        jTable1.show();
        jLabel7.setText(" ");
        Card_player3.hide();
        Card_Bot3.hide();
        
        
        
        jButton2.hide();
        jButton1.hide();
        
        if(Integer.valueOf(T_money.getText()) <= 0){
        
            
        frame = new JFrame("Exit");

        JOptionPane.showConfirmDialog(frame , "Game over.","",JOptionPane.CLOSED_OPTION); 
        
            
        
            Game_over();
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        datetime();
    }//GEN-LAST:event_jTable1MouseClicked


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        frame = new JFrame("Exit");
        
        if (JOptionPane.showConfirmDialog(frame , "Confirm to Save and Exit","",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION)
        {
            
        
        String getmoney = T_money.getText();
        String getname = T_Name.getText();
        String[] name02 = new String[7];
        String forsavefile ="";
        
        try {            
            BufferedReader name = new BufferedReader(new FileReader("src\\main\\java\\Member\\"+getname+".txt"));
            for(int i = 0 ; i < name02.length ; i ++){
                name02[i] = name.readLine();     
                
            }
            int summ = Integer.parseInt(name02[6]) + Integer.parseInt(getmoney);
            name02[6] = String.valueOf(summ);
            
            for(int i = 0 ; i < name02.length  ; i++  ){
                   forsavefile = forsavefile + name02[i]+ "\n";
            }
            
            FileWriter Wri = new FileWriter("src\\main\\java\\Member\\"+getname+".txt");         
            Wri.write(forsavefile);
            Wri.close();
            name.close();


            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "There was an error with the combination of email \naddress and password you entered. !","Warning !",JOptionPane.PLAIN_MESSAGE);               

            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.exit(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public void ReGame(){ 
   
        draw.setEnabled(true);
        stay.setEnabled(true);
         Card_Num_rd_player1 = 0 ;
         Card_Num_rd_player2 = 0 ;
         Card_Num_rd_player3 = 0 ;
         Card_Sb_rd_player1 = 0 ;
         Card_Sb_rd_player2 = 0 ;
         Card_Sb_rd_player3 = 0 ;
         Card_Num_rd_Bot1 = 0 ;
         Card_Num_rd_Bot2 = 0 ;
         Card_Num_rd_Bot3 = 0 ;
         Card_Sb_rd_Bot1 = 0 ;
         Card_Sb_rd_Bot2 = 0 ;
         Card_Sb_rd_Bot3 = 0 ;

         sum_1 = 0;
         sum_2 = 0;

         sum_1_bot = 0;
         sum_2_bot = 0;

         sum__ = 0;

         BotScore2.setText("");
         xtext.setText("");
         
         test_score.setText("");
         BotScore.setText("");
    
         jLabel6.hide();
         jLabel8.hide();
         
         Card_player1.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));
         Card_player2.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));
         Card_player3.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));
         Card_Bot01.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));
         Card_Bot02.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));
         Card_Bot3.setIcon(new ImageIcon("src\\main\\java\\Image\\backcard.jpg"));
    
    }    
    
    public void History(){
  
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();    
        
      

        model.addRow(new Object[]{Sta, time ,pl , bt});
        
       bt = "";
       pl = "";

  
    
    
    }
    
    public void Game_over(){
        
            try{
                String getmoney = T_money.getText();
                String getname = T_Name.getText();
                String[] name02 = new String[7];
                String forsavefile ="";

                try {            
                    BufferedReader name = new BufferedReader(new FileReader("src\\main\\java\\Member\\"+getname+".txt"));
                    for(int i = 0 ; i < name02.length ; i ++){
                        name02[i] = name.readLine();     

                    }

                    int summ = Integer.parseInt(name02[6]) + Integer.parseInt(getmoney);
                    name02[6] = String.valueOf(summ);

                    for(int i = 0 ; i < name02.length  ; i++  ){
                           forsavefile = forsavefile + name02[i]+ "\n";
                    }

                    FileWriter Wri = new FileWriter("src\\main\\java\\Member\\"+getname+".txt");         
                    Wri.write(forsavefile);
                    Wri.close();
                    name.close();



                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "There was an error. !","Warning !",JOptionPane.PLAIN_MESSAGE);               

                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
                }
            new Start().setVisible(true);
            setVisible(false);
            
      }catch(NumberFormatException e){
          
        JOptionPane.showMessageDialog(this, "Pls Enter Number in fill !","Warning !",JOptionPane.PLAIN_MESSAGE);               
      
      }
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG_MAIN;
    private javax.swing.JTextField Bit;
    private javax.swing.JLabel BotScore;
    private javax.swing.JLabel BotScore2;
    private javax.swing.JLabel Card_Bot01;
    private javax.swing.JLabel Card_Bot02;
    private javax.swing.JLabel Card_Bot3;
    private javax.swing.JLabel Card_player1;
    private javax.swing.JLabel Card_player2;
    private javax.swing.JLabel Card_player3;
    private javax.swing.JLabel T_Name;
    private javax.swing.JLabel T_money;
    private javax.swing.JButton draw;
    private javax.swing.JLabel getmoney;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton stay;
    private javax.swing.JLabel test_score;
    private javax.swing.JLabel xtext;
    // End of variables declaration//GEN-END:variables
}
