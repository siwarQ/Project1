/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Card;
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
        private String backCard;
        
        
	/**
     * Creates new form gameFrame
     */
    public gameFrame(ViewLogic v) {
        // initlizing method
        initComponents();
        view = v;
        backCard = null;
        //setting label design
         this.setResizable(false);
         
        
         jButton1.setOpaque(false);
         jButton1.setContentAreaFilled(false);
         jButton1.setBorderPainted(false);
        //jButton1.setBackground(Color.GREEN.darker());
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        JPlayer = new javax.swing.JLabel();
        JDealer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(82, 0, 0));
        jButton1.setForeground(new java.awt.Color(137, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(620, 460, 70, 30);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
        jLabel1.setBounds(0, -50, 1220, 630);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel5.setBounds(554, 270, 90, 130);
        jDesktopPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(620, 473, 73, 70);
        jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("jLabel6");
        jLabel6.setBounds(150, 320, 120, 150);
        jDesktopPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(533, 473, 80, 70);
        jDesktopPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("jLabel7");
        jLabel7.setBounds(330, 320, 120, 150);
        jDesktopPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JPlayer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JPlayer.setForeground(new java.awt.Color(255, 255, 255));
        JPlayer.setText("jLabel8");
        JPlayer.setBounds(720, 180, 140, 110);
        jDesktopPane1.add(JPlayer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        JDealer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        JDealer.setForeground(new java.awt.Color(255, 255, 255));
        JDealer.setText("jLabel9");
        JDealer.setBounds(680, 120, 180, 90);
        jDesktopPane1.add(JDealer, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1213, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.err.println("FUCKKKKKKKKKKKKKKKKKKKKKK");
        game g = view.loadStringCard(); // calling deal method
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
        jButton1.setVisible(false);
        jLabel1.setIcon(x);
        jButton2.setVisible(true);
        jButton4.setVisible(true);
        jLabel1.add(jButton2);
        jLabel1.add(jButton4);
                
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
            jButton2.setVisible(false);
        }
         else
         {
         jButton2.setVisible(true);
         jLabel1.add(jButton2);
         }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
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
       /* if (jLabel6!= null){
        jLabel6.setIcon(nextCard);
        jLabel1.add(jLabel6);
        }
        else{
            jLabel7.setIcon(nextCard);
            jLabel1.add(jLabel7);
        }*/
        if (view.checkWin()== -1){
            System.err.println("lost");
            jButton2.setVisible(false);
        }
        if (view.checkWin()== 1){
            System.err.println("win");
            jButton2.setVisible(false);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ImageIcon cardIcon4 = new ImageIcon(getClass().getResource(backCard));
        jLabel3.setIcon(cardIcon4);
        jLabel1.add(jLabel3);
        
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
            jButton4.setVisible(false);
        }
        if (view.checkWin() == -1){
            System.err.println("Dealer wins");
            jButton4.setVisible(false);
        }
        
            
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDealer;
    private javax.swing.JLabel JPlayer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
