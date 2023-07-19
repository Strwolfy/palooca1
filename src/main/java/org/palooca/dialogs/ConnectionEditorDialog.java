/*
 * ConnectionEditorDialog.java
 *
 * Palo Open Office Calc AddIn
 * Copyright (C) 2008 PalOOCa Team,  Tensegrity Software GmbH, 2009

 * The software is licensed under an Open-Source License (GPL).
 * If you want to redistribute the software you must observe the regulations of
 * the GPL . If you want to redistribute the software without the
 * restrictions of the GPL, you have to contact Tensegrity Software GmbH
 * (Tensegrity) for written consent to do so.
 * Tensegrity may offer commercial licenses for redistribution (Dual Licensing)
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Created on 30. August 2007, 16:51
 */

package org.palooca.dialogs;

import com.sun.star.uno.XComponentContext;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.palooca.PalOOCaManager;
import org.palooca.network.ConnectionHandler;
import org.palooca.network.ConnectionInfo;

/**
 *
 * @author Andreas Schneider
 */
public class ConnectionEditorDialog extends javax.swing.JDialog {
    
    private int modalResult = JOptionPane.CANCEL_OPTION;
    private final ResourceBundle resourceBundle;
    private final XComponentContext context;
    
    public int getModalResult() {
        return modalResult;
    }
    
    /** Creates new form ConnectionEditorDialog */
    public ConnectionEditorDialog(java.awt.Dialog parent, boolean modal,
            XComponentContext context) {
        super(parent, modal);
        this.context = context;
        this.resourceBundle = PalOOCaManager.getInstance(context).getResourceBundle("org/palooca/dialogs/PalOOCaDialogs");
        Thread thread = Thread.currentThread();
        ClassLoader old = thread.getContextClassLoader();
        thread.setContextClassLoader(this.getClass().getClassLoader());
        try {
          // do call that depends on context ClassLoader
           initComponents();
        } finally {
          thread.setContextClassLoader(old);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOK = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextPane();
        jButtonTest = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        comboDatabaseType = new javax.swing.JComboBox();
        chkAutoLogin = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ResourceBundle bundle = ResourceBundle.getBundle("org/palooca/dialogs/PalOOCaDialogs"); // NOI18N
        setTitle(bundle.getString("EditConnectionInfo")); // NOI18N
        setResizable(false);

        btnOK.setText(bundle.getString("OK")); // NOI18N
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setText(bundle.getString("Cancel")); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txtInfo.setBackground(javax.swing.UIManager.getDefaults().getColor("info"));
        txtInfo.setEditable(false);
        jScrollPane1.setViewportView(txtInfo);

        jButtonTest.setText("Test");
        jButtonTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        comboDatabaseType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Palo", "XMLA" }));

        chkAutoLogin.setText(bundle.getString("AutoLogIn")); // NOI18N

        jLabel6.setText(bundle.getString("DatabaseType")); // NOI18N

        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
        });

        jLabel2.setText(bundle.getString("Host")); // NOI18N

        jLabel1.setText(bundle.getString("Name")); // NOI18N

        jLabel5.setText(bundle.getString("Password")); // NOI18N

        txtPort.setText("7777");
        txtPort.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPortFocusGained(evt);
            }
        });

        jLabel3.setText(bundle.getString("Port")); // NOI18N

        txtHost.setActionCommand("<Not Set>");
        txtHost.setPreferredSize(null);
        txtHost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHostFocusGained(evt);
            }
        });

        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameFocusGained(evt);
            }
        });

        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });

        jLabel4.setText(bundle.getString("Username")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(jLabel3)
                            .add(jLabel4)
                            .add(jLabel5)
                            .add(jLabel6))
                        .add(29, 29, 29)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtPassword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .add(txtUsername, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .add(txtHost, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, txtName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .add(txtPort, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                            .add(chkAutoLogin)
                            .add(comboDatabaseType, 0, 295, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(comboDatabaseType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(txtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(txtPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(chkAutoLogin)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(31, 31, 31)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnCancel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .add(btnOK, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .add(jButtonTest, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .add(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(btnOK)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnCancel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonTest))
                    .add(layout.createSequentialGroup()
                        .add(21, 21, 21)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        txtUsernameFocusGained(evt);
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        txtInfo.setText(resourceBundle.getString("Username_Password_Description"));
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtPortFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPortFocusGained
        txtInfo.setText(resourceBundle.getString("Port_Description"));
    }//GEN-LAST:event_txtPortFocusGained

    private void txtHostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHostFocusGained
        txtInfo.setText(resourceBundle.getString("Host_Description"));
    }//GEN-LAST:event_txtHostFocusGained

    private void txtNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusGained
        txtInfo.setText(resourceBundle.getString("Name_Description"));
    }//GEN-LAST:event_txtNameFocusGained

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        modalResult = JOptionPane.CANCEL_OPTION;
        setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (txtName.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, resourceBundle.getString("Invalid_Name_Text"), resourceBundle.getString("Invalid_Name_Caption"), JOptionPane.WARNING_MESSAGE);
            return;
        }
        
//        try {
//            int port = Integer.parseInt(txtPort.getText());
//            if (port > 0 && port < 65536) {
                modalResult = JOptionPane.OK_OPTION;
                setVisible(false);
//            } else {
//                JOptionPane.showMessageDialog(this, resourceBundle.getString("Invalid_Port_Range_Text"), resourceBundle.getString("Invalid_Port_Caption"), JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, resourceBundle.getString("Invalid_Port_Number_Text"), resourceBundle.getString("Invalid_Port_Caption"), JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        int conType = (comboDatabaseType.getSelectedIndex() == 0 ? ConnectionInfo.TYPE_HTTP : ConnectionInfo.TYPE_XMLA);
        ConnectionInfo info = new ConnectionInfo(context, null, txtName.getText(), txtHost.getText(), txtPort.getText(), txtUsername.getText(), String.valueOf(txtPassword.getPassword()), conType, false);
        ResourceBundle bundle = PalOOCaManager.getInstance(context).getResourceBundle("org/palooca/PalOOCaCore");
        if (info.connect()) {
            info.getConnection().close();
            JOptionPane.showMessageDialog(this,bundle.getString("Connection_OK_Text"),bundle.getString("Connection_OK_Caption"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,String.format(bundle.getString("Connection_Failed_Text"), txtHost.getText(), txtPort.getText()),bundle.getString("Connection_Failed_Caption"), JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnTestActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    public javax.swing.JCheckBox chkAutoLogin;
    public javax.swing.JComboBox comboDatabaseType;
    private javax.swing.JButton jButtonTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtHost;
    private javax.swing.JTextPane txtInfo;
    public javax.swing.JTextField txtName;
    public javax.swing.JPasswordField txtPassword;
    public javax.swing.JTextField txtPort;
    public javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    
}