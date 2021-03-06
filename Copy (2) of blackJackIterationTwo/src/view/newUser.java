/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author Lee
 */
public class newUser extends javax.swing.JFrame {


	private static final long serialVersionUID = 5601289102658046667L;

    private ViewLogic view;
    
    public newUser(ViewLogic v) {
        initComponents();
        view=v;
        settingTranspert(registerBtn);
        firstNameTxt.setOpaque(false);
        lastNameTxt.setOpaque(false);
        userNameTxt.setOpaque(false);
        passWordTxt.setOpaque(false);
        this.setResizable(false);
        
    }
    
    private void settingTranspert(JButton button){
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        firstNameTxt = new javax.swing.JTextField();
        lastNameTxt = new javax.swing.JTextField();
        userNameTxt = new javax.swing.JTextField();
        passWordTxt = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstNameTxt.setForeground(new java.awt.Color(255, 255, 255));
        firstNameTxt.setBounds(20, 140, 240, 30);
        jDesktopPane1.add(firstNameTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lastNameTxt.setForeground(new java.awt.Color(255, 255, 255));
        lastNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTxtActionPerformed(evt);
            }
        });
        lastNameTxt.setBounds(20, 180, 240, 30);
        jDesktopPane1.add(lastNameTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        userNameTxt.setForeground(new java.awt.Color(255, 255, 255));
        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });
        userNameTxt.setBounds(20, 270, 240, 30);
        jDesktopPane1.add(userNameTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        passWordTxt.setForeground(new java.awt.Color(255, 255, 255));
        passWordTxt.setBounds(20, 350, 240, 30);
        jDesktopPane1.add(passWordTxt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        registerBtn.setBounds(20, 390, 240, 40);
        jDesktopPane1.add(registerBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        mainLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/registerpic.png"))); // NOI18N
        mainLabel.setText("jLabel6");
        mainLabel.setBounds(0, 0, 280, 450);
        jDesktopPane1.add(mainLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTxtActionPerformed

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed

        if (userNameTxt.getText().equals("") || passWordTxt.getText().equals("") || firstNameTxt.getText().equals("") || lastNameTxt.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please fill in all the fields! ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if (view.addNewUser(userNameTxt.getText(),passWordTxt.getText(),firstNameTxt.getText(),lastNameTxt.getText()))
            {
                view.executeSysExit();
                JOptionPane.showMessageDialog(this, "Information saved :)","Message",JOptionPane.INFORMATION_MESSAGE);
                //System.exit(0);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Registration was faild! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_registerBtnActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField firstNameTxt;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JTextField lastNameTxt;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JTextField passWordTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
