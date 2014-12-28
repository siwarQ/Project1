/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import sun.audio.*;

import java.awt.BorderLayout;
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
import model.game;



/**
 *
 * @author USER
 */
public class gameFrame extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        /**view logic instance */
        private ViewLogic view;
        private int cardAfterDeal = 0;
        public ArrayList<JLabel> playersHand = new ArrayList<>() ;
        public ArrayList<JLabel> dealersHand = new ArrayList<>() ;
        Timer timer;
        JToggleButton b = new JToggleButton("Start/Stop");// creating the 
        public int tellHimToStop = 0;
        public int flagNotShuffle = 0;
        game g = null;
        
        //final JToggleButton deal = new JToggleButton("DEAL");// creating the button
        
        
	/**
     * Creates new form gameFrame
     */
    public gameFrame(ViewLogic v) {
        // initlizing method
        initComponents();
        view = v;
        //backCard = null;
        //setting label design
         this.setResizable(false);
         
        NextLeveljButton.setVisible(false);// setting the next level button not visible
        
         
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
         jLabel1.add(jToggleDealBtn);
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
         
        NextLeveljButton.setVisible(false);// setting the next level button not visible
        
         
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
         jLabel1.add(jToggleDealBtn);
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
                jLabel1.add(animation, BorderLayout.CENTER);// adding the first label to the center
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
                jLabel1.add(jToggleDealBtn, BorderLayout.PAGE_END);
                jLabel1.add(b, BorderLayout.PAGE_END); //adding to gui the button with his place
                b.setBounds(620, 480, 70, 40);
                
                //b.setBounds(800, 480, 70, 30);
                jToggleDealBtn.setVisible(true);
                b.setVisible(true);
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
         jLabel1.add(this.playersHand.get(0));
         this.playersHand.get(0).setIcon(imageIcon);
         this.playersHand.get(0).setBounds(515, 250, 100,  imageIcon.getIconHeight()+100);
         
         this.playersHand.get(0).setVisible(true);
         cardAfterDeal =1;
         runAnimation();
         
         }
         else{
          
         ImageIcon imageIcon = new ImageIcon(getClass().getResource(sources.get(1)));
         this.playersHand.add((new JLabel()));
         jLabel1.add(this.playersHand.get(1));
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
         jLabel1.add(this.dealersHand.get(0));
         this.dealersHand.get(0).setIcon(imageIcon);
         this.dealersHand.get(0).setBounds(515, 55, 100,  imageIcon.getIconHeight()+100);
         
         this.dealersHand.get(0).setVisible(true);
         runAnimation();
         }
         else {
          ImageIcon imageIcon = new ImageIcon(getClass().getResource("hiddenCard.jpg"));
         this.dealersHand.add((new JLabel()));
         jLabel1.add(this.dealersHand.get(1));
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
                        
                        jLabel1.add(this.playersHand.get(i));
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
                        
                        //this.dealersHand.add(new JLabel());
                        jLabel1.add(this.dealersHand.get(k));
                        /*this.dealersHand.get(k).setIcon(imageIcon);
                        this.dealersHand.get(k).setBounds(500 + 40*(k), 100-(k*10),imageIcon.getIconWidth(),  imageIcon.getIconHeight());
                        //this.dealersHand.get(k).setVisible(true);*/
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
        jLabel1 = new javax.swing.JLabel();
        hitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        standBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        JPlayer = new javax.swing.JLabel();
        JDealer = new javax.swing.JLabel();
        jplayerStatus = new javax.swing.JLabel();
        jDealerStatus = new javax.swing.JLabel();
        jToggleDealBtn = new javax.swing.JToggleButton();
        NextLeveljButton = new javax.swing.JButton();
        jStars = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/xxx.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.setBounds(0, 0, 1220, 590);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

        standBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standBtnActionPerformed(evt);
            }
        });
        standBtn.setBounds(550, 453, 60, 70);
        jDesktopPane1.add(standBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        jToggleDealBtn.setBounds(380, 480, 70, 40);
        jDesktopPane1.add(jToggleDealBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        NextLeveljButton.setText("Next Level");
        NextLeveljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextLeveljButtonActionPerformed(evt);
            }
        });
        NextLeveljButton.setBounds(20, 260, 130, 23);
        jDesktopPane1.add(NextLeveljButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jStars.setBounds(270, 180, 140, 250);
        jDesktopPane1.add(jStars, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void updatedPlayerCardsInHit()
    {
       String playerAmount =Integer.toString(view.getPlayerHand());
        JPlayer.setText("Player-"+playerAmount);
        jLabel1.add(JPlayer);
        JPlayer.setVisible(true);     
    }
    
    private void updatedDelearCardsInHit()
    {
        String delearAmount =Integer.toString(view.getDealerHand());
        JDealer.setText("Delear-"+delearAmount);
        jLabel1.add(JDealer);
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
           // jplayerStatus.setText("Bust!");  
             try {
                InputStream in;
//                in = new FileInputStream("C:\\Users\\Lee\\git\\Project1\\Copy (2) of blackJackIterationTwo\\src\\view\\lost.wav");
               in = this.getClass().getResourceAsStream("../Sounds/lost.wav");
                AudioStream a = new AudioStream(in);
                AudioPlayer.player.start(a);
             ImageIcon test1 = new ImageIcon(getClass().getResource("bust.gif"));
            jplayerStatus.setIcon(test1);
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
            standBtn.setVisible(false);
            updatedPlayerCardsInHit();
            updatedDelearCardsInHit();
            NextLeveljButton.setVisible(true);
            jLabel1.add(NextLeveljButton);
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
                jplayerStatus.setIcon(test);
                //jplayerStatus.setText("Win!");
                jLabel1.add(jplayerStatus);
                jplayerStatus.setVisible(true);
                hitBtn.setVisible(false);
                standBtn.setVisible(false);
                NextLeveljButton.setVisible(true);
                jLabel1.add(NextLeveljButton);
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
        jLabel1.add(JDealer);
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
            jplayerStatus.setIcon(test);
            //jplayerStatus.setText("Win!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            standBtn.setVisible(false);
            hitBtn.setVisible(false);
            NextLeveljButton.setVisible(true);
            jLabel1.add(NextLeveljButton);
             } catch (Exception ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (view.checkWin() == -1){
            System.err.println("Dealer wins");
            jDealerStatus.setText("Win!");
            jLabel1.add(jDealerStatus);
            jDealerStatus.setVisible(true);
            standBtn.setVisible(false);
            hitBtn.setVisible(false);
            NextLeveljButton.setVisible(true);
            jLabel1.add(NextLeveljButton);
        }
        
        
        //LEE
        updateSumOfCardForDealer();
            
        
    }//GEN-LAST:event_standBtnActionPerformed

    private void NextLeveljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextLeveljButtonActionPerformed
        // TODO add your handling code here:
        /*this.dispose();
        new gameFrame(view).setVisible(true);*/
        this.dispose();
        //System.err.print("HERE BEFORE NEW: "+view.calculateScoreForGame());
        new wainFrame(view, g).setVisible(true);
        
        
        
    }//GEN-LAST:event_NextLeveljButtonActionPerformed

    private void settingsAfterDeal(){
        String menu= "xxx2.png"; 
        ImageIcon x = new ImageIcon(getClass().getResource(menu));
        
      //  dealBtn.setVisible(false);
        jLabel1.setIcon(x);
        hitBtn.setVisible(true);
        standBtn.setVisible(true);
        jLabel1.add(hitBtn);
        jLabel1.add(standBtn);
        
        ///LEE
        String playerAmount =Integer.toString(view.getPlayerHand());
        JPlayer.setText("Player-"+playerAmount);
        jLabel1.add(JPlayer);
        JPlayer.setVisible(true);
        String delearAmount =Integer.toString(view.getDealerHand());
        JDealer.setText("Delear-"+delearAmount);
        jLabel1.add(JDealer);
        JDealer.setVisible(true);
        
         if (view.checkWinOnStart()== 1){
             try {
             InputStream in;
            // in = new FileInputStream("C:\\Users\\Lee\\git\\Project1\\Copy (2) of blackJackIterationTwo\\src\\view\\Ta Da1.wav");
             in = this.getClass().getResourceAsStream("../Sounds/Ta Da1.wav");
             AudioStream a = new AudioStream(in);
             AudioPlayer.player.start(a); 
            ImageIcon test = new ImageIcon(getClass().getResource("win5.gif"));
            jplayerStatus.setIcon(test);
            //jplayerStatus.setText("Win!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
            standBtn.setVisible(false);
            NextLeveljButton.setVisible(true);
            jLabel1.add(NextLeveljButton);
              } catch (Exception ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else
         {
         hitBtn.setVisible(true);
         jLabel1.add(hitBtn);
         }
        // b.setVisible(false);
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDealer;
    private javax.swing.JLabel JPlayer;
    private javax.swing.JButton NextLeveljButton;
    private javax.swing.JButton hitBtn;
    private javax.swing.JLabel jDealerStatus;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jStars;
    private javax.swing.JToggleButton jToggleDealBtn;
    private javax.swing.JLabel jplayerStatus;
    private javax.swing.JButton standBtn;
    // End of variables declaration//GEN-END:variables
}
