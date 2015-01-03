/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import sun.audio.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import model.Player;
import model.game;



/**
 *
 * @author USER
 */
public class gameFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6580542711963684128L;
		/**
	 * 
	 */
        /**view logic instance */
        private ViewLogic view;
        private  Player p;
        private int cardAfterDeal = 0;
        public ArrayList<JLabel> playersHand = new ArrayList<>() ;
        public ArrayList<JLabel> dealersHand = new ArrayList<>() ;
        Timer timer;
        JToggleButton b = new JToggleButton("Start/Stop");// creating the 
        public int tellHimToStop = 0;
        public int flagNotShuffle = 0;
        game g = null;
        String dealClearMenuSrc= "xxx.png"; 
        ImageIcon dealClearImgIcon = new ImageIcon(getClass().getResource(dealClearMenuSrc));
        
        //final JToggleButton deal = new JToggleButton("DEAL");// creating the button
        
        
	/**
     * Creates new form gameFrame
     */
    public gameFrame(ViewLogic v,Player player) {
        // initlizing method
        
        initComponents();
        
        
        view = v;
        p= player;
        System.err.println("suprise------------"+p.toString());
        //backCard = null;
        
        dealBtn.setVisible(false);
        settingTranspert(dealBtn);
        //setting label design
         this.setResizable(false);
         
      
        
         
        playersHand = new ArrayList<>() ;
        dealersHand = new ArrayList<>() ;
         
         settingTranspert(hitBtn);
         settingTranspert(standBtn);
         settingTranspert(clearBtn);
         clearBtn.setVisible(false);
         cubsLabel.setOpaque(false);
         jToggleDealBtn.setOpaque(false);
         jToggleDealBtn.setContentAreaFilled(false);
         jToggleDealBtn.setBorderPainted(false);
         jToggleDealBtn.setText("");
      
         jToggleDealBtn.setVisible(true);
         runAnimation();
         jToggleDealBtn= b;
         homeLabel.add(jToggleDealBtn);
         b.setOpaque(false);
         b.setContentAreaFilled(false);
         b.setBorderPainted(false);
         b.setText(""); 
        
        //jButton1.setBackground(Color.GREEN.darker());
         
      
    }
      public gameFrame(ViewLogic v, game gi) {
        // initlizing method
        initComponents();
        view = v;
        g=gi;
        //backCard = null;
        //setting label design
         this.setResizable(false);
         dealBtn.setVisible(false);
         settingTranspert(dealBtn);
      
        
         
        playersHand = new ArrayList<>() ;
        dealersHand = new ArrayList<>() ;
         
         settingTranspert(hitBtn);
         settingTranspert(standBtn);
         
         jToggleDealBtn.setOpaque(false);
         jToggleDealBtn.setContentAreaFilled(false);
         jToggleDealBtn.setBorderPainted(false);
         jToggleDealBtn.setText("");
      
         jToggleDealBtn.setVisible(true);
         runAnimation();
         jToggleDealBtn= b;
         homeLabel.add(jToggleDealBtn);
         b.setOpaque(false);
         b.setContentAreaFilled(false);
         b.setBorderPainted(false);
         b.setText(""); 
        
        //jButton1.setBackground(Color.GREEN.darker());
      
    }
    
    //siwar
       private void runAnimation(){

        hitBtn.setText("");
 
        Runnable r = new Runnable() {
            

            @Override
            public void run() {
                
                ImageIcon im = new ImageIcon(getClass().getResource("hiddenCard.jpg"));
                final JLabel animation = new JLabel(im); // creating the label and giving him the first index in label
                animation.setBounds(800, 120, im.getIconHeight(), im.getIconWidth());
                homeLabel.add(animation, BorderLayout.CENTER);// adding the first label to the center
                animation.setVisible(false);

                ActionListener animate = new ActionListener() { 
                
                    private int index = 0;
                    private int whichWay= 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                        ImageIcon im = new ImageIcon(getClass().getResource("hiddenCard.jpg"));
                        if (index<20) {
                        index++;
                        if (whichWay == 0){
                        animation.setIcon(im);
                        animation.setBounds(800-index*10, 120+ index*10, im.getIconHeight(), im.getIconWidth());
                        animation.setVisible(true);//////////////////////////////
                        }
                        else {
                        animation.setIcon(im);
                        animation.setBounds(800-index*10, 120, im.getIconHeight(), im.getIconWidth());
                        animation.setVisible(true);//////////////////////////////
                        }
                        } else {
                            tellHimToStop ++;
                            
                            if (tellHimToStop==1){
                                if (g==null){
                                g = view.loadStringCard(); // calling deal method
                                    System.err.println("");
                                 System.err.println("game 1");
                                }
                                else {
                                    view.nextRound();
                                     clearBtn.setVisible(false);
                                    System.err.println("game2");
                                }
                                
                                setFirstCardsPlayer(0);
                                animation.setVisible(false);
                                timer.stop();
                                index=0;
                                
                            }
                            if (tellHimToStop==2){
                                setFirstCardsPlayer(1);
                                animation.setVisible(false);
                                timer.stop();
                                whichWay=1;
                                index=0;
                                
                            }
                            if (tellHimToStop==3){
                                setFirstCardsDealer(0);
                                animation.setVisible(false);
                                timer.stop();
                                index=0;
                                
                            }
                            if (tellHimToStop==4){
                                setFirstCardsDealer(1);
                                animation.setVisible(false);
                                timer.stop();
                                settingsAfterDeal();
                                
                                
                            }
                            b.setVisible(false);
                        }   
                    }
                };
               timer = new Timer(15,animate);

                //final JToggleButton b = new JToggleButton("Start/Stop");// creating the button
                ActionListener startStop = new ActionListener() { // creating the action listener

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b.isSelected()) { // if the button is selected
                            timer.start();
         
                        } else {
                            timer.stop();
                        }
                    }
                };
                b.addActionListener(startStop); // adding for the button b the action listener
                
                jToggleDealBtn.addActionListener(startStop);
                homeLabel.add(jToggleDealBtn, BorderLayout.PAGE_END);
                homeLabel.add(b, BorderLayout.PAGE_END); //adding to gui the button with his place
                b.setBounds(620, 480, 70, 40);
                jToggleDealBtn.setVisible(true);
                b.setVisible(true);
                jTextField1.setBounds(1020,170,60,20);
                jTextField2.setBounds(1090, 170,60,20);
                jTextField1.setForeground(Color.WHITE);
                jTextField1.setOpaque(false);
                jTextField1.setBorder(null);
                jTextField2.setForeground(Color.WHITE);
                jTextField2.setOpaque(false);
                jTextField2.setBorder(null);
                jTextField1.setText(view.getNumberOfWinnings()+"");
                jTextField2.setText(view.getNumberOfLosts()+"");
                jTextField1.setVisible(true);
                homeLabel.add(jTextField1);
                jTextField2.setVisible(true);
                homeLabel.add(jTextField2);
            }
        };
        r.run();
    }
    
    private void settingTranspert(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);      
    }
    //siwar
    private void setFirstCardsPlayer(int i){ // setting the first Card
         ArrayList<String> sources = new ArrayList<>();
         sources = view.getPlayerSHand();
         if (i==0){
         ImageIcon imageIcon = new ImageIcon(getClass().getResource(sources.get(0)));
         this.playersHand.add((new JLabel()));
         homeLabel.add(this.playersHand.get(0));
         this.playersHand.get(0).setIcon(imageIcon);
         this.playersHand.get(0).setBounds(515, 250, 100,  imageIcon.getIconHeight()+100);
         
         this.playersHand.get(0).setVisible(true);
         cardAfterDeal =1;
         runAnimation();
         
         }
         else{
          
         ImageIcon imageIcon = new ImageIcon(getClass().getResource(sources.get(1)));
         this.playersHand.add((new JLabel()));
         homeLabel.add(this.playersHand.get(1));
         this.playersHand.get(1).setIcon(imageIcon);
         this.playersHand.get(1).setBounds(540, 230, 100,  imageIcon.getIconHeight()+100);
  
         this.playersHand.get(1).setVisible(true);
             
         }
    }
   //siwar
     private void setFirstCardsDealer(int num){ // setting the first Card
         ArrayList<String> sources = new ArrayList<>();
         sources = view.getDealerSHand();
         if (num==0){
         ImageIcon imageIcon = new ImageIcon(getClass().getResource(sources.get(0)));
         this.dealersHand.add((new JLabel()));
         homeLabel.add(this.dealersHand.get(0));
         this.dealersHand.get(0).setIcon(imageIcon);
         this.dealersHand.get(0).setBounds(515, 55, 100,  imageIcon.getIconHeight()+100);
         
         this.dealersHand.get(0).setVisible(true);
         runAnimation();
         }
         else {
          ImageIcon imageIcon = new ImageIcon(getClass().getResource("hiddenCard.jpg"));
         this.dealersHand.add((new JLabel()));
         homeLabel.add(this.dealersHand.get(1));
         this.dealersHand.get(1).setIcon(imageIcon);
         this.dealersHand.get(1).setBounds(540, 35, 100,  imageIcon.getIconHeight()+100);
        
         this.dealersHand.get(1).setVisible(true);
         runAnimation();   
         }
     }
    /** This function sets the Right Label's for the specifec time ones its called */
    private void settingStringsOfArr(String whose){
        //LAODING IMAGES FOR CARDS FUNCTION
        ArrayList<String> sources = new ArrayList<>();
            switch (whose) {
                case "playersHand":
                    sources = view.getPlayerSHand();

                    int j=0;
                    while (j< sources.size()){
                        ImageIcon imageIcon = new ImageIcon(getClass().getResource(sources.get(j)));
                        this.playersHand.add((new JLabel()));
                         this.playersHand.get(j).setIcon(imageIcon);
                        this.playersHand.get(j).setBounds((500 + 15*(j)), (300)-(j*10),100,  120);
                     this.playersHand.get(j).setVisible(true);
                        j++;
                    }
                    int i=sources.size()-1;
                    while (i>=0){
                        System.err.println("this is the arr labels in player: "+ sources.toString());
                        
                        homeLabel.add(this.playersHand.get(i));
                        i--;
                    }
                    break;
                    //siwar
                case "dealersHand":
                    sources = view.getDealerSHand();
                    //int k =0;
                     j=0;
                     
                    while (j< sources.size()){
                        System.err.println("this is the arr labels in dealer: "+ sources.toString());
                        ImageIcon imageIcon;
                        if (cardAfterDeal==0){
                           imageIcon= new ImageIcon(getClass().getResource("hiddenCard.jpg"));
                             cardAfterDeal = 1;
                        }
                        else{
                            imageIcon = new ImageIcon(getClass().getResource(sources.get(j)));
                        }
                        this.dealersHand.add((new JLabel()));
                         this.dealersHand.get(j).setIcon(imageIcon);
                        this.dealersHand.get(j).setBounds(500 + 40*(j), 100-(j*10),imageIcon.getIconWidth(),  imageIcon.getIconHeight());
                     this.dealersHand.get(j).setVisible(true);
                        j++;
                    }
                    int k=sources.size()-1;
                    while (k>=0){
                        
                        homeLabel.add(this.dealersHand.get(k));
                       
                        k--;
                    }
                    break;
            }
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        dealBtn = new javax.swing.JButton();
        cubsLabel = new javax.swing.JLabel();
        homeLabel = new javax.swing.JLabel();
        clearBtn = new javax.swing.JButton();
        standBtn = new javax.swing.JButton();
        hitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JPlayer = new javax.swing.JLabel();
        JDealer = new javax.swing.JLabel();
        jplayerStatus = new javax.swing.JLabel();
        jDealerStatus = new javax.swing.JLabel();
        jToggleDealBtn = new javax.swing.JToggleButton();
        jStars = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jDesktopPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jDesktopPane1MouseExited(evt);
            }
        });

        dealBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealBtnActionPerformed(evt);
            }
        });
        dealBtn.setBounds(620, 490, 70, 30);
        jDesktopPane1.add(dealBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cubsLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Tal\\Desktop\\kobb.png")); // NOI18N
        cubsLabel.setText("jLabel1");
        cubsLabel.setBounds(970, 80, 180, 90);
        jDesktopPane1.add(cubsLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        homeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/xxx.png"))); // NOI18N
        homeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeLabelMouseClicked(evt);
            }
        });
        homeLabel.setBounds(0, 0, 1220, 590);
        jDesktopPane1.add(homeLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        clearBtn.setBounds(540, 460, 80, 50);
        jDesktopPane1.add(clearBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        standBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standBtnActionPerformed(evt);
            }
        });
        standBtn.setBounds(550, 453, 60, 70);
        jDesktopPane1.add(standBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        hitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitBtnActionPerformed(evt);
            }
        });
        hitBtn.setBounds(620, 463, 80, 60);
        jDesktopPane1.add(hitBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("jLabel6");
        jLabel6.setBounds(150, 320, 120, 150);
        jDesktopPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("jLabel7");
        jLabel7.setBounds(330, 320, 120, 150);
        jDesktopPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JPlayer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JPlayer.setForeground(new java.awt.Color(255, 255, 255));
        JPlayer.setText("jLabel8");
        JPlayer.setBounds(690, 340, 180, 50);
        jDesktopPane1.add(JPlayer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JDealer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JDealer.setForeground(new java.awt.Color(255, 255, 255));
        JDealer.setText("jLabel9");
        JDealer.setBounds(690, 170, 150, 40);
        jDesktopPane1.add(JDealer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jplayerStatus.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jplayerStatus.setForeground(new java.awt.Color(204, 153, 0));
        jplayerStatus.setBounds(670, 300, 210, 40);
        jDesktopPane1.add(jplayerStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jDealerStatus.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jDealerStatus.setForeground(new java.awt.Color(204, 153, 0));
        jDealerStatus.setText("jLabel9");
        jDealerStatus.setBounds(700, 129, 160, 50);
        jDesktopPane1.add(jDealerStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jToggleDealBtn.setText("jToggleButton1");
        jToggleDealBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleDealBtnActionPerformed(evt);
            }
        });
        jToggleDealBtn.setBounds(380, 480, 70, 40);
        jDesktopPane1.add(jToggleDealBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jStars.setBounds(270, 180, 140, 250);
        jDesktopPane1.add(jStars, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField1.setText("jTextField1");
        jTextField1.setBounds(30, 220, 59, 20);
        jDesktopPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField2.setText("jTextField2");
        jTextField2.setBounds(50, 450, 59, 20);
        jDesktopPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeLabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_homeLabelMouseClicked

    private void updatedPlayerCardsInHit()
    {
       String playerAmount =Integer.toString(view.getPlayerHand());
        JPlayer.setText("Player-"+playerAmount);
        homeLabel.add(JPlayer);
        JPlayer.setVisible(true);     
    }
    
    private void updatedDelearCardsInHit()
    {
        String delearAmount =Integer.toString(view.getDealerHand());
        JDealer.setText("Delear-"+delearAmount);
        homeLabel.add(JDealer);
        JDealer.setVisible(true); 
    }
    private void hitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitBtnActionPerformed
        // TODO add your handling code here:
        
        //SIWAR
         // HIT FUNCTION
        String s = view.hitButton(); // getting next card
        System.err.println("what is the card after hit button: "+s);
        settingStringsOfArr("playersHand");//setting the card's labels
        
        if (view.checkWin()== -1){ 
             try {
                InputStream in;
//                in = new FileInputStream("C:\\Users\\Lee\\git\\Project1\\Copy (2) of blackJackIterationTwo\\src\\view\\lost.wav");
               in = this.getClass().getResourceAsStream("../Sounds/lost.wav");
                AudioStream a = new AudioStream(in);
                AudioPlayer.player.start(a);
             ImageIcon test1 = new ImageIcon(getClass().getResource("bust.gif"));
             view.setStatus(false);
            jplayerStatus.setIcon(test1);
            homeLabel.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
            standBtn.setVisible(false);
            updatedPlayerCardsInHit();
            updatedDelearCardsInHit();
            homeLabel.setIcon(dealClearImgIcon);
            settingTranspert(clearBtn);
            clearBtn.setVisible(true);
            homeLabel.add(clearBtn);
            return;
              } catch (Exception ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (view.checkWin()== 1){
            try {
                InputStream in;
              //  in = new FileInputStream("C:\\Users\\Lee\\git\\Project1\\Copy (2) of blackJackIterationTwo\\src\\view\\Ta Da1.wav");
                in = this.getClass().getResourceAsStream("../Sounds/Ta Da1.wav");
                AudioStream a = new AudioStream(in);
                AudioPlayer.player.start(a);
                ImageIcon test = new ImageIcon(getClass().getResource("win5.gif"));
                view.setStatus(true);
                jplayerStatus.setIcon(test);
                //jplayerStatus.setText("Win!");
                homeLabel.add(jplayerStatus);
                jplayerStatus.setVisible(true);
                hitBtn.setVisible(false);
                standBtn.setVisible(false);
                homeLabel.setIcon(dealClearImgIcon);
                settingTranspert(clearBtn);
                clearBtn.setVisible(true);
                homeLabel.add(clearBtn);
            } catch (Exception ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ///LEE
        updatedPlayerCardsInHit();
        updatedDelearCardsInHit();    
    }//GEN-LAST:event_hitBtnActionPerformed

    private void updateSumOfCardForDealer()
    { 
        String delearAmount =Integer.toString(view.getDealerHandAgterStand());
        JDealer.setText("Delear-"+delearAmount);
        homeLabel.add(JDealer);
        JDealer.setVisible(true);
    }
    private void standBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standBtnActionPerformed
        // TODO add your handling code here:
    
        //SIWAR 
        ArrayList<String> arr = this.view.standButton();
        if (arr.isEmpty()){
            System.err.println("NULL");
        }
        
        for (String s: arr){
            System.err.println("Cards After Stand: "+s);
        }
        settingStringsOfArr("dealersHand");
        if (view.checkWin() == 1){
               try {
                InputStream in;
              //  in = new FileInputStream("C:\\Users\\Lee\\git\\Project1\\Copy (2) of blackJackIterationTwo\\src\\view\\Ta Da1.wav");
                 in = this.getClass().getResourceAsStream("../Sounds/Ta Da1.wav");
                 AudioStream a = new AudioStream(in);
                AudioPlayer.player.start(a);
            ImageIcon test = new ImageIcon(getClass().getResource("win5.gif"));
            view.setStatus(true);
            jplayerStatus.setIcon(test);
            //jplayerStatus.setText("Win!");
            homeLabel.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            standBtn.setVisible(false);
            hitBtn.setVisible(false);
            homeLabel.setIcon(dealClearImgIcon);
            settingTranspert(clearBtn);
            clearBtn.setVisible(true);
            homeLabel.add(clearBtn);
             } catch (Exception ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (view.checkWin() == -1){
            System.err.println("Dealer wins");
            jDealerStatus.setText("Win!");
            view.setStatus(false);
            homeLabel.add(jDealerStatus);
            jDealerStatus.setVisible(true);
            standBtn.setVisible(false);
            hitBtn.setVisible(false);
            homeLabel.setIcon(dealClearImgIcon);
            settingTranspert(clearBtn);
            clearBtn.setVisible(true);
            homeLabel.add(clearBtn);
        }
        
        
        //LEE
        updateSumOfCardForDealer();
            
        
    }//GEN-LAST:event_standBtnActionPerformed

    private void jToggleDealBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleDealBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleDealBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        view.executeSysExit(); 
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         view.executeSysExit();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jDesktopPane1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDesktopPane1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jDesktopPane1MouseExited

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        
        jDesktopPane1.removeAll();
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        
        jDesktopPane1.add(homeLabel);
        homeLabel.removeAll();
        homeLabel.setIcon(dealClearImgIcon);
        homeLabel.setVisible(true);
        
        
        JLabel reviewLabel = new JLabel("Total Score:");
        reviewLabel.setBounds(520, 100, 200, 200);
        reviewLabel.setForeground(Color.YELLOW);
        reviewLabel.setVisible(true);
        Font f = new Font("Serif", Font.BOLD, 24);
        reviewLabel.setFont(f);
        int i = view.calculateScoreForGame();
        
        String score = i+"";
        System.err.print("FRAME: "+i);
        JLabel scoreForRound = new JLabel(score);
        scoreForRound.setBounds(670, 100, 200, 200);
        scoreForRound.setForeground(Color.YELLOW);
        scoreForRound.setFont(f);
        scoreForRound.setVisible(true);
        
        
        JLabel newRecord = new JLabel();
        newRecord.setOpaque(false);
        if (view.checkNewRecord()){
            System.err.print("new record-----------------------------------------------"+view.checkNewRecord());
           ImageIcon good = new ImageIcon(getClass().getResource("nr2.gif"));
            
            newRecord.setIcon(good);
            newRecord.setBounds(250, 250, good.getIconWidth(), good.getIconHeight());
            homeLabel.add(newRecord);
            newRecord.setVisible(true);
        }
        else
        {
             System.err.print("old record-----------------------------------------------"+view.checkNewRecord());
            newRecord.setVisible(false);
        }
        
        
        homeLabel.add(reviewLabel);
        homeLabel.add(scoreForRound);
        dealBtn.setVisible(true);
        homeLabel.add(dealBtn);
        
        //jTextField1.setText(score);
        
        
        
    }//GEN-LAST:event_clearBtnActionPerformed

    private void dealBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealBtnActionPerformed
        
       /* this.dispose();
        new gameFrame(view, g).setVisible(true);*/
        jDesktopPane1.removeAll();
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        
        jDesktopPane1.add(homeLabel);
        homeLabel.removeAll();
        homeLabel.setIcon(dealClearImgIcon);
        homeLabel.setVisible(true);
        
        JLabel loadingLabel= new JLabel("Loading...");
        
        loadingLabel.setBounds(590, 320, 200, 200);
        loadingLabel.setForeground(Color.DARK_GRAY);
        Font f = new Font("Serif", Font.BOLD, 24);
        loadingLabel.setFont(f);
        loadingLabel.setVisible(true);
        
        JLabel loadingAnimation= new JLabel();

           ImageIcon good = new ImageIcon(getClass().getResource("laoding.gif"));
            
            loadingAnimation.setIcon(good);
            loadingAnimation.setBounds(500,100, good.getIconWidth(), good.getIconHeight());
            loadingAnimation.setVisible(true);
            homeLabel.add(loadingAnimation);
        //loadingRunAnimation();
            homeLabel.add(loadingLabel);
            
        

    }//GEN-LAST:event_dealBtnActionPerformed

    private void loadingRunAnimation(){ // loading to the next turn
        
 
        Runnable r = new Runnable() {
            

            @Override
            public void run() {
                 JLabel loadingAnimation= new JLabel();
                 ImageIcon good = new ImageIcon(getClass().getResource("laoding.gif"));
                 loadingAnimation.setIcon(good);
                 loadingAnimation.setBounds(500,100, good.getIconWidth(), good.getIconHeight());
                 loadingAnimation.setVisible(true);

                ActionListener animate = new ActionListener() { 
                
                    private int index = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                       
                        ImageIcon im = new ImageIcon(getClass().getResource("laoding.gif"));
                        if (index<20) {
                        index++;
                        
                        } else {
                                timer.stop();
                                index=0;
                                openNewRoundFunc();
                               
                                
                                
                                
                            }
                            
                            }
                            
                        };  

               timer = new Timer(15,animate);

                //final JToggleButton b = new JToggleButton("Start/Stop");// creating the button
                ActionListener startStop = new ActionListener() { // creating the action listener

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (b.isSelected()) { // if the button is selected
                            timer.start();
         
                        } else {
                            timer.stop();
                            
                        }
                    }
                };
                b.addActionListener(startStop); // adding for the button b the action listener
                
                jToggleDealBtn.addActionListener(startStop);
                homeLabel.add(jToggleDealBtn, BorderLayout.PAGE_END);
                homeLabel.add(b, BorderLayout.PAGE_END); //adding to gui the button with his place
                b.setBounds(620, 480, 70, 40);
                
                
            };
        };
        r.run();
    }

    private void openNewRoundFunc(){

        this.dispose();
        new gameFrame(view, g).setVisible(true);
}
    private void settingsAfterDeal(){
        String menu= "xxx2.png"; 
        ImageIcon x = new ImageIcon(getClass().getResource(menu));
        
      //  dealBtn.setVisible(false);
        homeLabel.setIcon(x);
        hitBtn.setVisible(true);
        standBtn.setVisible(true);
        homeLabel.add(hitBtn);
        homeLabel.add(standBtn);
        
        ///LEE
        String playerAmount =Integer.toString(view.getPlayerHand());
        JPlayer.setText("Player-"+playerAmount);
        homeLabel.add(JPlayer);
        JPlayer.setVisible(true);
        String delearAmount =Integer.toString(view.getDealerHand());
        JDealer.setText("Delear-"+delearAmount);
        homeLabel.add(JDealer);
        JDealer.setVisible(true);
        
         if (view.checkWinOnStart()== 1){
             try {
             InputStream in;
            // in = new FileInputStream("C:\\Users\\Lee\\git\\Project1\\Copy (2) of blackJackIterationTwo\\src\\view\\Ta Da1.wav");
             in = this.getClass().getResourceAsStream("../Sounds/Ta Da1.wav");
             AudioStream a = new AudioStream(in);
             AudioPlayer.player.start(a); 
            ImageIcon test = new ImageIcon(getClass().getResource("win5.gif"));
             view.setStatus(true);
            jplayerStatus.setIcon(test);
            //jplayerStatus.setText("Win!");
            homeLabel.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
            standBtn.setVisible(false);
            homeLabel.setIcon(dealClearImgIcon);
            settingTranspert(clearBtn);
            clearBtn.setVisible(true);
            homeLabel.add(clearBtn);
              } catch (Exception ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else
         {
         hitBtn.setVisible(true);
         homeLabel.add(hitBtn);
         }
        // b.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDealer;
    private javax.swing.JLabel JPlayer;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel cubsLabel;
    private javax.swing.JButton dealBtn;
    private javax.swing.JButton hitBtn;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel jDealerStatus;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jStars;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleDealBtn;
    private javax.swing.JLabel jplayerStatus;
    private javax.swing.JButton standBtn;
    // End of variables declaration//GEN-END:variables
}
