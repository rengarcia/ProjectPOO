package ec.edu.espe.schweitzer_revision.view;

import ec.edu.espe.schweitzer_revision.model.Maintenance;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhony Naranjo
 */
public class FRMUpdateMaintenance extends javax.swing.JFrame {
   private static final Logger LOG = Logger.getLogger(FRMSchweitzerSystem.class.getName());

    /**
     * Creates new form FRMUpdateMaintenance
     */
    public FRMUpdateMaintenance() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/ec/edu/espe/schweitzer_revision/view/icono.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jButtonUpdateMaintenance = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jDateChooser = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToggleButton1.setText("Atrás");
        jToggleButton1.setToolTipText("Regresar al menu");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });

        jLabel4.setText("Fecha de completacion (dd/mm/aa) : ");

        jLabel5.setText("Nueva Descripción : ");

        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jTextAreaDescription.setToolTipText("Describe lo que realizaste en el mantenimiento realizado actualmente");
        jTextAreaDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextAreaDescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaDescription);

        jButtonUpdateMaintenance.setText("Actualizar Mantenimiento");
        jButtonUpdateMaintenance.setToolTipText("Actualizar estado del mantenimiento");
        jButtonUpdateMaintenance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateMaintenanceMouseClicked(evt);
            }
        });

        jLabel6.setText("Ingresa ID del mantenimiento : ");

        txtId.setToolTipText("Ingresa el ID del mantenimiento que deseas cambiar el estado");
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        jDateChooser.setDateFormatString("ddMMyy");
        jDateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonUpdateMaintenance)
                        .addGap(69, 69, 69)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtId)
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jButtonUpdateMaintenance))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUpdateMaintenanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMaintenanceMouseClicked
        String tempOderId = txtId.getText();
        String descriptionUpdate = jTextAreaDescription.getText();
        String formato = jDateChooser.getDateFormatString();
        Date date = jDateChooser.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        String completionDateUpdate = String.valueOf(dateFormat.format(date));
        String clientOrderFilePath = "Files\\ClientOrder.txt" ;
        Maintenance maintenance = new Maintenance();
        try {
            maintenance.updateOrder(clientOrderFilePath, tempOderId, descriptionUpdate, completionDateUpdate);
            JOptionPane.showMessageDialog(this,"Se Actualizo con los nuevos datos","Mantenimiento Actualizado", WIDTH);
            txtId.setText("");
            jTextAreaDescription.setText("");
                       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FRMUpdateMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FRMUpdateMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonUpdateMaintenanceMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
       FRMTechnician technician = new FRMTechnician();
       technician.setVisible(true);
       this.setVisible(false);
       
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
       char validate=evt.getKeyChar();
   if(validate >=48 && validate<=57 || validate==8){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros");
    LOG.warning("Values entered incorrect");  
    }
    
    
    if (txtId.getText().length()== 5) {

         evt.consume(); 
    } 
    }//GEN-LAST:event_txtIdKeyTyped

    private void jDateChooserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserKeyTyped

    private void jTextAreaDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaDescriptionKeyTyped
      char validate=evt.getKeyChar();

   if(validate >=65 && validate<=90 || validate==8 || validate ==32
           || validate >=97 && validate<=122 ){
     
    }
    else{
        getToolkit().beep();
            evt.consume();
      JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
    LOG.warning("Values entered incorrect");  
    }
        
    }//GEN-LAST:event_jTextAreaDescriptionKeyTyped

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
            java.util.logging.Logger.getLogger(FRMUpdateMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMUpdateMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMUpdateMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMUpdateMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMUpdateMaintenance().setVisible(true);
            }
        });
    }



  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUpdateMaintenance;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
