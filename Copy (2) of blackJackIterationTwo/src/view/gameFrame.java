/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

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
    
    /*
     * Serlizabele number
     */
	private static final long serialVersionUID = -6580542711963684128L;
       //Basic variables for this class 
        private ViewLogic view;
        private  Player p;
        private game g = null;
        public ArrayList<JLabel> playersHand = new ArrayList<>() ;
        public ArrayList<JLabel> dealersHand = new ArrayList<>() ;
        // helping flags
        private int flagForNewRound = 0; 
        private int cardAfterDeal = 0;
        public int tellHimToStop = 0;
        public int flagNotShuffle = 0;
        public int hitFlg = 0;
        // ALL NEEDED TIMERS IN SYSTEM
        Timer timer; // timer for pressing on deal and sliding cards
        Timer timerForLoading;
        Timer timerHelp; // timer for help button 
        Timer timerForStopHelp; // timer for pressing ok on help button 
        
        // all labels and buttons needed for system
        JToggleButton b = new JToggleButton("Start/Stop");// creating the sliding functionality
        String dealClearMenuSrc= "hpfixed1.jpg"; 
        ImageIcon dealClearImgIcon = new ImageIcon(getClass().getResource(dealClearMenuSrc));
        JLabel loadingAnimation= new JLabel();
        ImageIcon load = new ImageIcon(getClass().getResource("laoding.gif"));
        JLabel help = new  JLabel();
        ImageIcon c = new ImageIcon(getClass().getResource("helpBord.jpg"));
        // using two different labels for different purposes 
        final JLabel animationforHelp = new JLabel(c); // for pressing on help 
        final JLabel animationForStopHelp = new JLabel(c); // for different positions in pressing ok on help
        private int numberOfRound;
        
        
	/**
     * Creates new form gameFrame
     */     
        public gameFrame(ViewLogic v,Player player) {
        // initlizing method
        
        initComponents();      
        view = v;
        setP(player);
        settingTranspert(helpBtn);
        settingTranspert(stopBtn);
        settingTranspert(homeBtn);
        stopBtn.setVisible(false);
        runAnimationForHelp();
        dealBtn.setVisible(false);
        settingTranspert(dealBtn);
        this.setResizable(false);
        dealNewGBtn.setVisible(false);
        playersHand = new ArrayList<>() ;
        dealersHand = new ArrayList<>() ;
        numberOfRound = 0;
         
         settingTranspert(hitBtn);
         settingTranspert(standBtn);
         settingTranspert(clearBtn);
         clearBtn.setVisible(false);
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
           
    }
       
      /**
     * C'sr for the game frame with the same game
     */  
      public gameFrame(ViewLogic v, game gi) {
        // initlizing method
        initComponents();
        view = v;
        g=gi;
        
        settingTranspert(helpBtn);
        settingTranspert(stopBtn);
        settingTranspert(homeBtn);
        stopBtn.setVisible(false);
        runAnimationForHelp();
        dealNewGBtn.setVisible(false);
         this.setResizable(false);
         dealBtn.setVisible(false);
         settingTranspert(dealBtn);
         numberOfRound = 0;
         
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

    }
    
     /**
      * function for setting button as transparent for JToggleButton
      * @param button 
      */ 
     private void settingTranspert(JToggleButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);      
    }
     
     /**
      * function that create the animation for the help option
      */
     private void runAnimationForHelp(){
      
        Runnable r = new Runnable() {
            
            @Override
            public void run() {
                 // creating the label and giving him the first index in label
                animationforHelp.setBounds(380, -430, c.getIconWidth(),c.getIconHeight());
                animationforHelp.setVisible(true);
                homeLabel.add(animationforHelp, BorderLayout.CENTER);// adding the first label to the center

                ActionListener animate = new ActionListener() { 
                
                    private int index = 0;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                       
                        if (index<25) {
                        index++;
                        
                        animationforHelp.setIcon(c);
                        animationforHelp.setBounds(380, -250+(index*10), c.getIconWidth(),c.getIconHeight());
                        animationforHelp.setVisible(true);//////////////////////////////
                        homeLabel.add(animationforHelp, 10,0);
                        }else {
                            timerHelp.stop();
                            stopBtn.setVisible(true);
                            animationforHelp.setVisible(false);
                            runAnimationStopHelp();
                        }}};
                timerHelp = new Timer(20,animate);
                ActionListener startStop = new ActionListener() { // creating the action listener

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (helpBtn.isSelected()) { // if the button is selected
                            timerHelp.start();
         
                        } else {
                            timerHelp.stop();
                        }
                    }
                };
                helpBtn.addActionListener(startStop); // adding for the button b the action listener
                homeLabel.add(helpBtn,BorderLayout.PAGE_END);
            }};
        r.run();
    }
       /**
      * function that stop the animation for the help option
      */ 
      private void runAnimationStopHelp(){
      
        Runnable r = new Runnable() {
            @Override
            public void run() {
                 // creating the label and giving him the first index in label
                animationForStopHelp.setBounds(380, -10, c.getIconWidth(),c.getIconHeight());
                animationForStopHelp.setVisible(true);
                homeLabel.add(animationForStopHelp, BorderLayout.CENTER);// adding the first label to the center
                homeLabel.add(animationForStopHelp, 10,0);
                

                ActionListener animate = new ActionListener() { 
                
                    private int index = 1;

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                       
                        if (index<26) {
                        index++;
                        
                        animationForStopHelp.setIcon(c);
                        animationForStopHelp.setBounds(380, -(10*index), c.getIconWidth(),c.getIconHeight());
                        animationForStopHelp.setVisible(true);//////////////////////////////
                        }else {
                            timerForStopHelp.stop();
                            animationforHelp.setBounds(280, -250+5, c.getIconWidth(),c.getIconHeight());
                            animationforHelp.setVisible(false);
                            homeLabel.add(animationforHelp);
                            stopBtn.setVisible(false);
                            runAnimationForHelp();
                        }   
                    }
                };
               timerForStopHelp = new Timer(20,animate);
                ActionListener startStop = new ActionListener() { // creating the action listener

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (stopBtn.isSelected()) { // if the button is selected
                            timerForStopHelp.start();
         
                        } 
                    }
                };
                stopBtn.addActionListener(startStop); // adding for the button b the action listener
                stopBtn.setBounds(578, 225, 95,100);
                stopBtn.setVisible(true);
                homeLabel.add(stopBtn,BorderLayout.PAGE_END);
            }
        };
        r.run();
    }

    
    /**
     * function that run the animation for the card
     */
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
                        
                       if (flagForNewRound ==1){ // oppening new round
                        
                        animation.setIcon(im);
                        animation.setBounds(800, 120, im.getIconWidth(), im.getIconHeight());
                        animation.setVisible(true);
                        homeLabel.add(animation, BorderLayout.CENTER);// adding the first label to the center
                        tellHimToStop = 0;
                        flagForNewRound = 0;
                       }
                        if (index<20) {
                        index++;
                        
                        if (whichWay == 0){
                        animation.setIcon(im);
                        animation.setBounds(800-index*10, 120+ index*10,  im.getIconWidth(), im.getIconHeight());
                        animation.setVisible(true);//////////////////////////////
                        }
                        else {
                        animation.setIcon(im);
                        animation.setBounds(800-index*10, 120, im.getIconWidth(), im.getIconHeight());
                        animation.setVisible(true);//////////////////////////////
                        }
                        } else {
                            tellHimToStop ++;
                            
                            if (tellHimToStop==1){
                                if (g==null){
                                g = view.loadStringCard(); // calling deal method
                                numberOfRound++;
                                updateTheMainButtons();
                                }
                                else {
                                    view.nextRound();
                                     clearBtn.setVisible(false);
                                     numberOfRound++;
                                   updateTheMainButtons();
                                }
                               
                                setFirstCardsPlayer(0);
                                animation.setVisible(false);
                                try {
                                    makeSound("Sounds/cardPlace2.wav");
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                timer.stop();
                                index=0;
                                
                            }
                            if (tellHimToStop==2){
                                setFirstCardsPlayer(1);
                                animation.setVisible(false);
                                try {
                                    makeSound("Sounds/cardPlace2.wav");
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                timer.stop();
                                whichWay=1;
                                index=0;
                                
                            }
                            if (tellHimToStop==3){
                                setFirstCardsDealer(0);
                                animation.setVisible(false);
                                try {
                                    makeSound("Sounds/cardPlace2.wav");
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                timer.stop();
                                index=0;
                                
                            }
                            if (tellHimToStop==4){
                                setFirstCardsDealer(1);
                                animation.setVisible(false);
                                try {
                                    makeSound("Sounds/cardPlace2.wav");
                                } catch (LineUnavailableException ex) {
                                    Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                timer.stop();
                                settingsAfterDeal();
                                timer.removeActionListener(this);
                                whichWay =0; 
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
       /**
      * function for setting button as transparent for JButton
      * @param button 
      */ 
    private void settingTranspert(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);      
    }
   /**
    *  setting the first Card for player
    * @param i 
    */
    private void setFirstCardsPlayer(int i){ 
        
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
   /**
    * setting the first Card for dealer
    * @param num 
    */
     private void setFirstCardsDealer(int num){ 
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
                        homeLabel.add(this.playersHand.get(i));
                        i--;
                    }
                    break;
                case "dealersHand":
                    sources = view.getDealerSHand();
                     j=0;
                     
                    while (j< sources.size()){
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
        helpBtn = new javax.swing.JToggleButton();
        homeBtn = new javax.swing.JButton();
        dealNewGBtn = new javax.swing.JButton();
        dealBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JToggleButton();
        newGameBtn = new javax.swing.JButton();
        goToStartScreenBtn = new javax.swing.JButton();
        newHelpBtn = new javax.swing.JButton();
        num = new javax.swing.JLabel();
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

        helpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBtnActionPerformed(evt);
            }
        });
        helpBtn.setBounds(130, 90, 50, 50);
        jDesktopPane1.add(helpBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        homeBtn.setBounds(73, 90, 50, 50);
        jDesktopPane1.add(homeBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        dealNewGBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealNewGBtnActionPerformed(evt);
            }
        });
        dealNewGBtn.setBounds(630, 470, 70, 40);
        jDesktopPane1.add(dealNewGBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        dealBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealBtnActionPerformed(evt);
            }
        });
        dealBtn.setBounds(620, 470, 70, 50);
        jDesktopPane1.add(dealBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });
        stopBtn.setBounds(570, 210, 90, 40);
        jDesktopPane1.add(stopBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        newGameBtn.setBackground(new java.awt.Color(102, 102, 102));
        newGameBtn.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        newGameBtn.setText("NEW GAME");
        newGameBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameBtnActionPerformed(evt);
            }
        });
        newGameBtn.setBounds(100, 0, 100, 30);
        jDesktopPane1.add(newGameBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        goToStartScreenBtn.setBackground(new java.awt.Color(102, 102, 102));
        goToStartScreenBtn.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        goToStartScreenBtn.setText("HOME");
        goToStartScreenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToStartScreenBtnActionPerformed(evt);
            }
        });
        goToStartScreenBtn.setBounds(0, 0, 100, 30);
        jDesktopPane1.add(goToStartScreenBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        newHelpBtn.setBackground(new java.awt.Color(102, 102, 102));
        newHelpBtn.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        newHelpBtn.setText("HELP");
        newHelpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newHelpBtnActionPerformed(evt);
            }
        });
        newHelpBtn.setBounds(200, 0, 100, 30);
        jDesktopPane1.add(newHelpBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        num.setForeground(new java.awt.Color(255, 255, 255));
        num.setBounds(310, 4, 170, 30);
        jDesktopPane1.add(num, javax.swing.JLayeredPane.DEFAULT_LAYER);

        homeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/hpfixed1.jpg"))); // NOI18N
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

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setText("jTextField1");
        jTextField1.setBounds(30, 220, 82, 23);
        jDesktopPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setText("jTextField2");
        jTextField2.setBounds(50, 450, 82, 23);
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

    /**
     * updates the label for - sum of the cards of player. after hit function.
     */
    private void updatedPlayerCardsInHit()
    {
       String playerAmount =Integer.toString(view.getPlayerHand());
        JPlayer.setText("Player-"+playerAmount);
        homeLabel.add(JPlayer);
        JPlayer.setVisible(true);     
    }
    /**
     * updates the label for - sum of the cards of dealer.after hit function.
     */
    private void updatedDelearCardsInHit()
    {
        String delearAmount =Integer.toString(view.getDealerHand());
        JDealer.setText("Delear-"+delearAmount);
        homeLabel.add(JDealer);
        JDealer.setVisible(true); 
    }
    /**
     * get string of sound source and play the sound.
     * @param mySound 
     */
    private void makeSound(String mySound) throws LineUnavailableException
    {
        try {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(ViewLogic.class.getResource(mySound));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
                        } catch (UnsupportedAudioFileException | IOException e) {
		}
        /*
        try
        {
        InputStream input = getClass().getResourceAsStream(mySound);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(input);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);  
        clip.start();
          } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
          }
          * */
    }
    /**
     * the setting after hit button.
     * @param evt 
     */
    private void hitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitBtnActionPerformed
        // TODO add your handling code here:    
        view.hitButton(); // getting next card
            try {
                makeSound("Sounds/cardPlace2.wav");
            } catch (LineUnavailableException ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        settingStringsOfArr("playersHand");//setting the card's labels
        
        if (view.checkWin()== -1){ 
            try {
                makeSound("Sounds/lost.wav");
            } catch (LineUnavailableException ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
             ImageIcon test1 = new ImageIcon(getClass().getResource("bustedGif.gif"));
             view.setStatus(false);
             jplayerStatus.setBounds(670, 250,test1.getIconWidth(), test1.getIconHeight());
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
            helpBtn.setVisible(true);
            homeLabel.add(clearBtn);
            return;
            
        }
        if (view.checkWin()== 1){
            try {             
                makeSound("Sounds/Ta Da1.wav");
            } catch (LineUnavailableException ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        }
        
        updatedPlayerCardsInHit();
        updatedDelearCardsInHit(); 
        
        
           
    }//GEN-LAST:event_hitBtnActionPerformed

    /**
     * updates the label for - sum of the cards of dealer. after deal function.
     */
    private void updateSumOfCardForDealer()
    { 
        String delearAmount =Integer.toString(view.getDealerHandAgterStand());
        JDealer.setText("Delear-"+delearAmount);
        homeLabel.add(JDealer);
        JDealer.setVisible(true);
    }
    /**
     *  the setting after stand button.
     * @param evt 
     */
    private void standBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standBtnActionPerformed
        // TODO add your handling code here:
         this.view.standButton();
        settingStringsOfArr("dealersHand");
        if (view.checkWin() == 1){
             try {
                 makeSound("Sounds/Ta Da1.wav");
             } catch (LineUnavailableException ex) {
                 Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
             }
            ImageIcon test = new ImageIcon(getClass().getResource("win5.gif"));
            view.setStatus(true);
            jplayerStatus.setIcon(test);
            homeLabel.add(jplayerStatus);
            jplayerStatus.setVisible(true);
            standBtn.setVisible(false);
            hitBtn.setVisible(false);
            homeLabel.setIcon(dealClearImgIcon);
            settingTranspert(clearBtn);
            clearBtn.setVisible(true);
            homeLabel.add(clearBtn);
        }
        if (view.checkWin() == -1){
             try {
                 makeSound("Sounds/lost.wav");
             } catch (LineUnavailableException ex) {
                 Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
             }
            ImageIcon test1 = new ImageIcon(getClass().getResource("lostGif.gif"));
            view.setStatus(false);
             jplayerStatus.setBounds(670, 250,test1.getIconWidth(), test1.getIconHeight());
             jplayerStatus.setIcon(test1);
            homeLabel.add(jplayerStatus);
            jplayerStatus.setVisible(true);
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
/**
 * Clear function - this function clears all settings in home label
 * Shows the score for the round
 * @param evt
 */
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        
        jDesktopPane1.removeAll();
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        
        jDesktopPane1.add(homeLabel);
        homeLabel.removeAll();
        homeLabel.setIcon(dealClearImgIcon);
        homeLabel.setVisible(true);
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        homeLabel.add(jTextField1);
        homeLabel.add(jTextField2);
        homeBtn.setVisible(true);
        homeLabel.add(homeBtn);
        
        
        
        JLabel reviewLabel = new JLabel("Total Score:");
        reviewLabel.setBounds(520, 100, 200, 200);
        reviewLabel.setForeground(Color.YELLOW);
        reviewLabel.setVisible(true);
        Font f = new Font("Serif", Font.BOLD, 24);
        reviewLabel.setFont(f);
        int i = view.calculateScoreForGame();
        
        String score = i+"";
        JLabel scoreForRound = new JLabel(score);
        scoreForRound.setBounds(670, 100, 200, 200);
        scoreForRound.setForeground(Color.YELLOW);
        scoreForRound.setFont(f);
        scoreForRound.setVisible(true);
        
        
        JLabel newRecord = new JLabel();
        newRecord.setOpaque(false);
        if (view.checkNewRecord()){
           ImageIcon good = new ImageIcon(getClass().getResource("nrr.png"));
            newRecord.setIcon(good);
            newRecord.setBounds(390, 300, good.getIconWidth(), good.getIconHeight());
            homeLabel.add(newRecord);
            newRecord.setVisible(true);
        }
        
        
        homeLabel.add(reviewLabel);
        homeLabel.add(scoreForRound);
        settingTranspert(dealBtn);
        dealBtn.setVisible(true);
        helpBtn.setVisible(true);
        homeLabel.add(dealBtn); 
        homeLabel.add(helpBtn);
        updateTheMainButtons();
        
    }//GEN-LAST:event_clearBtnActionPerformed
/**
 * this function updates the main buttons and labels above all different levels in the game 
 */
    private void updateTheMainButtons()
    {
       goToStartScreenBtn.setVisible(true);
       newGameBtn.setVisible(true);
       newHelpBtn.setVisible(true);
       homeLabel.add(goToStartScreenBtn);
       homeLabel.add(newGameBtn);
       homeLabel.add(newHelpBtn);
       num.setText("ROUND: "+numberOfRound);
       num.setVisible(true);
       homeLabel.add(num);
    }
    
    /**
     * deal button for starting new round 
     * @param evt 
     */
    private void dealBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealBtnActionPerformed

        jDesktopPane1.removeAll();
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        
        jDesktopPane1.add(homeLabel);
        homeLabel.removeAll();
        homeLabel.setIcon(dealClearImgIcon);
        homeLabel.setVisible(true);
        openNewRoundFunc();
    }//GEN-LAST:event_dealBtnActionPerformed

    /**
     * runs the animation for deal by clicking the deal button
     * @param evt 
     */
    private void dealNewGBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dealNewGBtnActionPerformed
        // TODO add your handling code here:
     
        flagForNewRound =1; 
        //runAnimation(); // run animation for slidding cards for player and dealer
        dealNewGBtn.setVisible(false);
        
    }//GEN-LAST:event_dealNewGBtnActionPerformed
/**
 * help button for game instructions
 * works in timer for sliding the help window
 * @param evt 
 */
    private void helpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBtnActionPerformed
        // TODO add your handling code here:
        timerHelp.start();
    }//GEN-LAST:event_helpBtnActionPerformed
/**
 * ok button on the help bord - this button slides back the help label 
 * works with timer
 * @param evt 
 */
    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stopBtnActionPerformed
/**
 * home Button - for exiting the user account 
 * goes back to the opening page
 * @param evt 
 */
    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        new MainFrameDESK(view).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    /**
     * new Game - this button sets the counters for score to zero 
     * Create a new game for the same user
     * @param evt 
     */
    private void newGameBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameBtnActionPerformed
        // TODO add your handling code here:
        view.executeSysExit(); // getting all data from the saving file
    //    view.loadStringCard(); // calling start game function
        g = view.restartGame(g);
        numberOfRound=0;
        
        // removing all settings from the home label
        jDesktopPane1.removeAll();
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        jDesktopPane1.add(homeLabel);
        homeLabel.removeAll();
        
        homeLabel.setIcon(new ImageIcon(getClass().getResource("hpfixed1.jpg")));
        homeBtn.setVisible(true);
        homeLabel.add(homeBtn);
        settingTranspert(dealBtn);
        dealBtn.setVisible(true);
        homeLabel.setVisible(true);
        homeLabel.add(dealBtn);
        num.setText("");
        num.setVisible(false);
        
        settingTranspert(helpBtn);
        settingTranspert(stopBtn);
        updateTheMainButtons();
        num.setVisible(false);
        runAnimationForHelp();
        
    }//GEN-LAST:event_newGameBtnActionPerformed
/**
 * home Btn- this button sends user to the opening page
 * allows the user to switch user or register
 * @param evt 
 */
    private void goToStartScreenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToStartScreenBtnActionPerformed
        // TODO add your handling code here:
        new MainFrameDESK(view).setVisible(true); // calling open page constructor
        this.dispose(); // closing this window
    }//GEN-LAST:event_goToStartScreenBtnActionPerformed

    /**
     * Help button - calls help timer and slides the help bord
     * @param evt 
     */
    private void newHelpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newHelpBtnActionPerformed
        // TODO add your handling code here:
        timerHelp.start();
    }//GEN-LAST:event_newHelpBtnActionPerformed

    /**
     * opening a new round after loading
     */
    private void openNewRoundFunc(){ 
        //claenimg the current settings.
       /* jDesktopPane1.removeAll();
        jDesktopPane1.revalidate();
        jDesktopPane1.repaint();
        
        jDesktopPane1.add(homeLabel);
        homeLabel.removeAll();*/
        homeLabel.setIcon(new ImageIcon(getClass().getResource("hpfixed1.jpg")));
        homeBtn.setVisible(true);
        homeLabel.add(homeBtn);
        settingTranspert(dealNewGBtn);
        dealNewGBtn.setVisible(true);
         
        homeLabel.setVisible(true);
        homeLabel.add(dealNewGBtn);
        
        settingTranspert(helpBtn);
        settingTranspert(stopBtn);
        stopBtn.setVisible(false);
        runAnimationForHelp();
        updateTheMainButtons();
       
    }
    
    
    
    private void settingsAfterDeal(){
        String menu= "hpfixed2.jpg"; 
        ImageIcon x = new ImageIcon(getClass().getResource(menu));
 
        homeLabel.setIcon(x);
        hitBtn.setVisible(true);
        standBtn.setVisible(true);
        homeLabel.add(hitBtn);
        homeLabel.add(standBtn);
        homeBtn.setVisible(true);
        homeLabel.add(homeBtn);

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
                makeSound("Sounds/Ta Da1.wav");
            } catch (LineUnavailableException ex) {
                Logger.getLogger(gameFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        }
         else
         {
         hitBtn.setVisible(true);
         homeLabel.add(hitBtn);
         }
    }
    public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}
	/**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDealer;
    private javax.swing.JLabel JPlayer;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton dealBtn;
    private javax.swing.JButton dealNewGBtn;
    private javax.swing.JButton goToStartScreenBtn;
    private javax.swing.JToggleButton helpBtn;
    private javax.swing.JButton hitBtn;
    private javax.swing.JButton homeBtn;
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
    private javax.swing.JButton newGameBtn;
    private javax.swing.JButton newHelpBtn;
    private javax.swing.JLabel num;
    private javax.swing.JButton standBtn;
    private javax.swing.JToggleButton stopBtn;
    // End of variables declaration//GEN-END:variables
}
