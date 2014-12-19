/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        private boolean cardAfterDeal = false;
        public ArrayList<JLabel> playersHand = new ArrayList<>() ;
        public ArrayList<JLabel> dealersHand = new ArrayList<>() ;
        final JToggleButton b = new JToggleButton("Start/Stop");// creating the button
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
         
        
          /*jButton1.setOpaque(false);
         jButton1.setContentAreaFilled(false);
         jButton1.setBorderPainted(false);*/
         
         settingTranspert(dealBtn);
         settingTranspert(hitBtn);
         settingTranspert(standBtn);
         
         runAnimation();
        //jButton1.setBackground(Color.GREEN.darker());
      
    }
    
    
       private void runAnimation(){
        final ImageIcon[] frames = {
            //ImageIO.read((ImageInputStream) new ImageIcon(getClass().getResource("small.png"))),
            // ImageIO.read(new URL("small.png")),
            new ImageIcon(getClass().getResource("test1.jpg")),
            new ImageIcon(getClass().getResource("test2.jpg"))
           
        };
        Runnable r = new Runnable() {
            

            @Override
            public void run() {
                //JPanel gui = new JPanel(new BorderLayout()); // creating the frame

                final JLabel animation = new JLabel(frames[0]); // creating the label and giving him the first index in label
                animation.setBounds(700, 200, frames[0].getIconHeight(), frames[0].getIconWidth());
                jLabel1.add(animation, BorderLayout.CENTER);// adding the first label to the center
                animation.setVisible(true);

                ActionListener animate = new ActionListener() { 

                    private int index = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (index<frames.length-1) {
                            index++;
                        } else {
                            index = 0;
                        }
                        animation.setIcon(frames[index]);
                        animation.setBounds(600, 200, frames[index].getIconHeight(), frames[index].getIconWidth());
                        animation.setVisible(true);//////////////////////////////
                    }
                };
               final Timer timer = new Timer(200,animate);

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
                //jplayerStatus.addAncestorListener(s);
                b.addActionListener(startStop); // adding for the button b the action listener
                dealBtn.addActionListener(startStop);
                jLabel1.add(b, BorderLayout.PAGE_END); //adding to gui the button with his place
                b.setBounds(800, 480, 70, 30);
                b.setVisible(true);

                //JOptionPane.showMessageDialog(null, gui);
            }
        };
        r.run();
    }
    
    private void settingTranspert(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);      
    }
    
    /** This function sets the Right Label's for the specifec time ones its called */
    private void settingStringsOfArr(String whose){
        //LAODING IMAGES FOR CARDS FUNCTION
        ArrayList<String> sources = new ArrayList<>();
            switch (whose) {
                case "playersHand":
                    sources = view.getPlayerSHand();
                    jLabel4.setVisible(false);
                    jLabel5.setVisible(false);
                    int i=0;
                    while (i<sources.size()){
                        System.err.println("this is the arr labels in player: "+ sources.toString());
                        ImageIcon imageIcon = new ImageIcon(getClass().getResource(sources.get(i)));
                        this.playersHand.add((new JLabel()));
                        jLabel1.add(this.playersHand.get(i));
                        this.playersHand.get(i).setIcon(imageIcon);
                        this.playersHand.get(i).setBounds(500 + 40*(i), 300-(i*10),imageIcon.getIconWidth(),  imageIcon.getIconHeight());
                     
             
                        this.playersHand.get(i).setVisible(true);
                        i++;
                    }
                    break;
                case "dealersHand":
                    sources = view.getDealerSHand();
                    jLabel2.setVisible(false);
                    jLabel3.setVisible(false);
                    int j =0;
                    while (j<sources.size()){
                        System.err.println("this is the arr labels in dealer: "+ sources.toString());
                        ImageIcon imageIcon;
                        if (cardAfterDeal){
                             imageIcon= new ImageIcon(getClass().getResource("hiddenCard.jpg"));
                             cardAfterDeal = false;
                        }
                        else{
                            imageIcon = new ImageIcon(getClass().getResource(sources.get(j)));
                        }
                        this.dealersHand.add(new JLabel());
                        jLabel1.add(this.dealersHand.get(j));
                        this.dealersHand.get(j).setIcon(imageIcon);
                        this.dealersHand.get(j).setBounds(500 + 40*(j), 100-(j*10),imageIcon.getIconWidth(),  imageIcon.getIconHeight());
                        this.dealersHand.get(j).setVisible(true);
                        j++;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hitBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        standBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        JPlayer = new javax.swing.JLabel();
        JDealer = new javax.swing.JLabel();
        jplayerStatus = new javax.swing.JLabel();
        jDealerStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dealBtn.setBackground(new java.awt.Color(82, 0, 0));
        dealBtn.setForeground(new java.awt.Color(137, 0, 0));
        dealBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealBtnActionPerformed(evt);
            }
        });
        dealBtn.setBounds(620, 480, 70, 30);
        jDesktopPane1.add(dealBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel2.setBounds(600, 104, 70, 100);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel3.setBounds(570, 120, 80, 110);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel4.setBounds(580, 260, 80, 110);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/xxx.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jLabel1.setBounds(0, 0, 1220, 590);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel5.setBounds(554, 270, 90, 130);
        jDesktopPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        JPlayer.setBounds(720, 310, 170, 50);
        jDesktopPane1.add(JPlayer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JDealer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JDealer.setForeground(new java.awt.Color(255, 255, 255));
        JDealer.setText("jLabel9");
        JDealer.setBounds(680, 120, 140, 30);
        jDesktopPane1.add(JDealer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jplayerStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jplayerStatus.setForeground(new java.awt.Color(255, 255, 255));
        jplayerStatus.setText("jLabel8");
        jplayerStatus.setBounds(360, 300, 110, 50);
        jDesktopPane1.add(jplayerStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jDealerStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jDealerStatus.setForeground(new java.awt.Color(255, 255, 255));
        jDealerStatus.setText("jLabel9");
        jDealerStatus.setBounds(410, 179, 210, 60);
        jDesktopPane1.add(jDealerStatus, javax.swing.JLayeredPane.DEFAULT_LAYER);

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

    private void dealBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealBtnActionPerformed
        // TODO add your handling code here:
        /*game g = view.loadStringCard(); // calling deal method
        ArrayList<Card> playerC = g.getRounds().get(g.sizeOfCurrentRound).getPlayerHand().getCards(); // players hand
        ArrayList<Card> dealerC = g.getRounds().get(g.sizeOfCurrentRound).getDealerHand().getCards(); // dealers hand
        //setting the right labels
        String menu= "xxx2.png"; 
        String card1 = playerC.get(0).getImage();
        String card2 = playerC.get(1).getImage();
        String card3 = dealerC.get(0).getImage();
        backCard = card3; // saving the back card of dealer
        String card4 = dealerC.get(1).getImage();
        ImageIcon x = new ImageIcon(getClass().getResource(menu));
        ImageIcon cardIcon1 = new ImageIcon(getClass().getResource(card1));
        ImageIcon cardIcon2 = new ImageIcon(getClass().getResource(card2));
        ImageIcon cardIcon3 = new ImageIcon(getClass().getResource(card4));
        
        ImageIcon cardIcon4 = new ImageIcon(getClass().getResource("hiddenCard.jpg"));
        
        jLabel2.setIcon(cardIcon3);
        jLabel1.add(jLabel2);
        jLabel3.setIcon(cardIcon4);
        jLabel1.add(jLabel3);
        jLabel4.setIcon(cardIcon1);
        jLabel1.add(jLabel4);
        jLabel5.setIcon(cardIcon2);
        jLabel1.add(jLabel5);
        dealBtn.setVisible(false);
        jLabel1.setIcon(x);
        hitBtn.setVisible(true);
        standBtn.setVisible(true);
        jLabel1.add(hitBtn);
        jLabel1.add(standBtn);
                
        String playerAmount =Integer.toString(view.getPlayerHand());
        JPlayer.setText("Player-"+playerAmount);
        jLabel1.add(JPlayer);
        JPlayer.setVisible(true);*/
        //SIWAR
        //runAnimation();
        dealBtn.setText("");
        hitBtn.setText("");
        System.err.println("FUCKKKKKKKKKKKKKKKKKKKKKK");
        
        game Game= view.loadStringCard(); // calling deal method
        Game.getRounds().get(Game.sizeOfCurrentRound).getDealerHand().getCards().get(0).getImage();
        this.cardAfterDeal = true;
        settingStringsOfArr("playersHand");
        settingStringsOfArr("dealersHand");
        String menu= "xxx2.png"; 
        
        ImageIcon x = new ImageIcon(getClass().getResource(menu));
        
        dealBtn.setVisible(false);
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
            System.err.println("win");
            jplayerStatus.setText("Win!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
        }
         else
         {
         hitBtn.setVisible(true);
         jLabel1.add(hitBtn);
         }


    }//GEN-LAST:event_dealBtnActionPerformed

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
        /*// TODO add your handling code here:
        //System.err.println("in the next button");
        String s = view.hitButton();
        ImageIcon nextCard; 
        System.err.println("what is: "+s);
        nextCard = new ImageIcon(getClass().getResource(s));
        JLabel c = new JLabel(nextCard, (int) LEFT_ALIGNMENT);
        //c.setIcon(nextCard);
        //c.pa
        jLabel1.add(c);
        c.setVisible(true);
        if (view.checkWin()== -1){
            jplayerStatus.setText("Bust!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
        }
        if (view.checkWin()== 1){
            jplayerStatus.setText("Win!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
        }*/
        //SIWAR
         // HIT FUNCTION
        String s = view.hitButton(); // getting next card
        System.err.println("what is the card after hit button: "+s);
        settingStringsOfArr("playersHand");//setting the card's labels
        
        if (view.checkWin()== -1){
            jplayerStatus.setText("Bust!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
            standBtn.setVisible(false);
            updatedPlayerCardsInHit();
            updatedDelearCardsInHit();  
            return;
        }
        if (view.checkWin()== 1){
            jplayerStatus.setText("Win!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            hitBtn.setVisible(false);
            standBtn.setVisible(false);
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
       /* ImageIcon cardIcon4 = new ImageIcon(getClass().getResource(backCard));
        jLabel3.setIcon(cardIcon4);
        jLabel1.add(jLabel3);
        updateSumOfCardForDealer();
        
        
        ArrayList<String> arr = this.view.standButton();
        if (arr.isEmpty())
            System.err.println("NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        for (String s: arr){
            System.err.println("The cards is: "+ s);
            ImageIcon nextCard= new ImageIcon(getClass().getResource(s));
            JLabel c = new JLabel(nextCard);
            jLabel1.add(c);
            c.setVisible(true);
        }
        if (view.checkWin() == 1){
            System.err.println("Player wins");
            jplayerStatus.setText("Win!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            standBtn.setVisible(false);
        }
        if (view.checkWin() == -1){
            System.err.println("Dealer wins");
            jDealerStatus.setText("Win!");
            jLabel1.add(jDealerStatus);
            jDealerStatus.setVisible(true);
            standBtn.setVisible(false);
        }*/
        //SIWAR 
        ArrayList<String> arr = this.view.standButton();
        if (arr.isEmpty()){
            System.err.println("NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
        }
        
        for (String s: arr){
            System.err.println("Cards After Stand: "+s);
        }
        settingStringsOfArr("dealersHand");
        if (view.checkWin() == 1){
            System.err.println("Player wins");
            jplayerStatus.setText("Win!");
            jLabel1.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            standBtn.setVisible(false);
            hitBtn.setVisible(false);
        }
        if (view.checkWin() == -1){
            System.err.println("Dealer wins");
            jDealerStatus.setText("Win!");
            jLabel1.add(jDealerStatus);
            jDealerStatus.setVisible(true);
            standBtn.setVisible(false);
            hitBtn.setVisible(false);
        }
        
        
        //LEE
        updateSumOfCardForDealer();
            
        
    }//GEN-LAST:event_standBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDealer;
    private javax.swing.JLabel JPlayer;
    private javax.swing.JButton dealBtn;
    private javax.swing.JButton hitBtn;
    private javax.swing.JLabel jDealerStatus;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jplayerStatus;
    private javax.swing.JButton standBtn;
    // End of variables declaration//GEN-END:variables
}
