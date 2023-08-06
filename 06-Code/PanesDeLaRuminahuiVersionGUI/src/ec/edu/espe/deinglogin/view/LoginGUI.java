package ec.edu.espe.deinglogin.view;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import ec.edu.espe.deinglogin.controller.MongoConnect;
import ec.edu.espe.deinglogin.model.UserAndPassword;
import ec.edu.espe.utils.ValidationUtil;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class LoginGUI extends javax.swing.JFrame {

    private boolean userValid = false;
    private boolean passwordValid = false;

    /**
     * Creates new form Login
     */
    public LoginGUI() {
        initComponents();
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
        txUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        nameOfProyect = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnExitProgram = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        btnEnter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txUser.setText("Usuario");

        txtUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });

        txPassword.setText("Contraseña");

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txUser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addGap(192, 192, 192))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txUser))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        nameOfProyect.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameOfProyect.setText("Panes De La Ruminahui");

        btnExitProgram.setText("Salir");
        btnExitProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitProgramActionPerformed(evt);
            }
        });

        btnSignIn.setText("Registrar");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        btnEnter.setText("Entrar");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExitProgram)
                .addGap(84, 84, 84)
                .addComponent(btnSignIn)
                .addGap(77, 77, 77)
                .addComponent(btnEnter)
                .addGap(83, 83, 83))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignIn)
                    .addComponent(btnExitProgram)
                    .addComponent(btnEnter))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nameOfProyect, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameOfProyect, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void createDocument() {

        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("PanesDeLaRuminahui");
            MongoCollection<Document> collection = database.getCollection("login");

            String user = txtUser.getText();
            String pasword = txtPassword.getText();

            String encrypted = "";
            int move = 1;

            for (int i = 0; i < pasword.length(); i++) {

                int codeRename = pasword.codePointAt(i);

                char letterMove = (char) (codeRename + move);

                encrypted = encrypted + letterMove;
            }

            Document doc1 = new Document("User", user).append("Pasword", encrypted);

            collection.insertOne(doc1);
        }
    }

    private void emptyFiled() {

        txtUser.setText("");
        txtPassword.setText("");

    }

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed

    }//GEN-LAST:event_txtUserActionPerformed

    private void btnExitProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitProgramActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitProgramActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        String username = txtUser.getText();
        String password = txtPassword.getText();
        
        MongoConnect mongoConnect = new MongoConnect();
        
        if( mongoConnect.loginConnect(username, password) ){
            
            txtUser.setText("");
            txtPassword.setText("");
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnEnterActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed

        signInAction();

        emptyFiled();
    }//GEN-LAST:event_btnSignInActionPerformed

    private void signInAction() throws HeadlessException {
        UserAndPassword userAndPassword;
        ValidationUtil validationUtil = new ValidationUtil();
        
        String user;
        String pasword;
        
        boolean validate;
        if(validationUtil.ValidateLetterStringWithSpaces(txtUser.getText())){
            validate = true;
            user = txtUser.getText();
        } else {
            validate = false;
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras Para El Usuario");
        }
        
        user = txtUser.getText();
        pasword = txtPassword.getText();
        userAndPassword = new UserAndPassword(user, pasword);
        
        int option = JOptionPane.showConfirmDialog(this, "Registrar:  \n");
        
        if (option == 0) {
            JOptionPane.showMessageDialog(rootPane, "Registrado con exito");
            createDocument();
            emptyFiled();
        }
    }

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private UserAndPassword readData() {

        UserAndPassword userAndPassword;

        String user;
        String pasword;
        user = txtUser.getText();
        pasword = txtPassword.getText();
        userAndPassword = new UserAndPassword(user, pasword);

        return userAndPassword;
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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnExitProgram;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nameOfProyect;
    private javax.swing.JLabel txPassword;
    private javax.swing.JLabel txUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}