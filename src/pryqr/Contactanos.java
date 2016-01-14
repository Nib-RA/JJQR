/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pryqr;

import static pryqr.NuevoQr.Mostrar_Visualizador;

/**
 *
 * @author toshiba
 */
public class Contactanos extends javax.swing.JFrame {

    /**
     * Creates new form AcercaDe
     */
    public Contactanos() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        String Ruta=getClass().getResource("/images/nosotras.png").getPath();
        Mostrar_Visualizador(lblImgJJ, Ruta);
        jbContactanos.requestFocus();
       
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbAcercade = new javax.swing.JButton();
        jbContactanos = new javax.swing.JButton();
        jlMuseo = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnContenidos = new javax.swing.JButton();
        jPanelJess = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanelJoss = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblImgJJ = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlJJ2016 = new javax.swing.JLabel();
        jlPoliticasdePrivacidad = new javax.swing.JLabel();
        jlTerminosyCondiciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(155, 80, 80));

        jPanel4.setBackground(new java.awt.Color(155, 80, 80));
        jPanel4.setMinimumSize(new java.awt.Dimension(400, 100));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jbAcercade.setBackground(new java.awt.Color(92, 29, 29));
        jbAcercade.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jbAcercade.setText("Acerca de ");
        jbAcercade.setPreferredSize(new java.awt.Dimension(200, 23));
        jbAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAcercadeActionPerformed(evt);
            }
        });

        jbContactanos.setBackground(new java.awt.Color(92, 29, 29));
        jbContactanos.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jbContactanos.setText("Contáctanos");
        jbContactanos.setMaximumSize(new java.awt.Dimension(183, 27));
        jbContactanos.setMinimumSize(new java.awt.Dimension(183, 27));
        jbContactanos.setPreferredSize(new java.awt.Dimension(200, 23));
        jbContactanos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbContactanosActionPerformed(evt);
            }
        });

        jlMuseo.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jlMuseo.setText("Museo \"Jorge Gallegos Cruz\"");
        jlMuseo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMuseoMouseClicked(evt);
            }
        });

        btnUsuarios.setBackground(new java.awt.Color(92, 29, 29));
        btnUsuarios.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setMaximumSize(new java.awt.Dimension(183, 27));
        btnUsuarios.setMinimumSize(new java.awt.Dimension(183, 27));
        btnUsuarios.setPreferredSize(new java.awt.Dimension(200, 23));
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnContenidos.setBackground(new java.awt.Color(92, 29, 29));
        btnContenidos.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        btnContenidos.setText("Galería");
        btnContenidos.setMaximumSize(new java.awt.Dimension(183, 27));
        btnContenidos.setMinimumSize(new java.awt.Dimension(183, 27));
        btnContenidos.setPreferredSize(new java.awt.Dimension(200, 23));
        btnContenidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContenidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbAcercade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbContactanos, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContenidos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlMuseo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbAcercade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbContactanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnContenidos, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addComponent(jlMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelJess.setForeground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setText("Joss");

        jLabel5.setText("joselin@hotmail.com");

        javax.swing.GroupLayout jPanelJessLayout = new javax.swing.GroupLayout(jPanelJess);
        jPanelJess.setLayout(jPanelJessLayout);
        jPanelJessLayout.setHorizontalGroup(
            jPanelJessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJessLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelJessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanelJessLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        jPanelJessLayout.setVerticalGroup(
            jPanelJessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJessLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanelJessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(53, 53, 53)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelJoss.setForeground(new java.awt.Color(204, 204, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setText("Jess");

        javax.swing.GroupLayout jPanelJossLayout = new javax.swing.GroupLayout(jPanelJoss);
        jPanelJoss.setLayout(jPanelJossLayout);
        jPanelJossLayout.setHorizontalGroup(
            jPanelJossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJossLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(42, 42, 42)
                .addComponent(jLabel4)
                .addContainerGap(234, Short.MAX_VALUE))
        );
        jPanelJossLayout.setVerticalGroup(
            jPanelJossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelJossLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanelJossLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblImgJJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nosotras.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 289, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanelJess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblImgJJ, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanelJoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImgJJ, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelJoss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelJess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(317, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jlJJ2016.setForeground(new java.awt.Color(255, 255, 255));
        jlJJ2016.setText("JJ 2016 Reservados  todos  los  derechos . ");

        jlPoliticasdePrivacidad.setForeground(new java.awt.Color(153, 204, 255));
        jlPoliticasdePrivacidad.setText("|  Políticas de Privacidad");
        jlPoliticasdePrivacidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlPoliticasdePrivacidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlPoliticasdePrivacidadMouseClicked(evt);
            }
        });

        jlTerminosyCondiciones.setForeground(new java.awt.Color(255, 51, 0));
        jlTerminosyCondiciones.setText("Terminos y Condiciones");
        jlTerminosyCondiciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlTerminosyCondiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlTerminosyCondicionesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jlJJ2016)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlTerminosyCondiciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlPoliticasdePrivacidad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlTerminosyCondiciones)
                        .addComponent(jlPoliticasdePrivacidad))
                    .addComponent(jlJJ2016))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(466, 466, 466))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlPoliticasdePrivacidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPoliticasdePrivacidadMouseClicked
        // TODO add your handling code here:
        PoliticasdePrivacidad pp=new PoliticasdePrivacidad();
        pp.setVisible(true);
    }//GEN-LAST:event_jlPoliticasdePrivacidadMouseClicked

    private void jlTerminosyCondicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTerminosyCondicionesMouseClicked
        // TODO add your handling code here:
        TerminosyCondiciones tc1=new TerminosyCondiciones();
        tc1.setVisible(true);
    }//GEN-LAST:event_jlTerminosyCondicionesMouseClicked

    private void btnContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContenidosActionPerformed
        // TODO add your handling code here:
        Contenidos fr=new Contenidos();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContenidosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        // TODO add your handling code here:
        Usuarios fru=new Usuarios();
        fru.show();
        dispose();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void jlMuseoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMuseoMouseClicked
        // TODO add your handling code here:
        Principal fr=new Principal();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jlMuseoMouseClicked

    private void jbContactanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbContactanosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbContactanosActionPerformed

    private void jbAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcercadeActionPerformed
        // TODO add your handling code here:
        AcercaDe fra=new AcercaDe();
        fra.show();
        dispose();
    }//GEN-LAST:event_jbAcercadeActionPerformed

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
            java.util.logging.Logger.getLogger(Contactanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contactanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contactanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contactanos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contactanos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContenidos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelJess;
    private javax.swing.JPanel jPanelJoss;
    private javax.swing.JButton jbAcercade;
    private javax.swing.JButton jbContactanos;
    private javax.swing.JLabel jlJJ2016;
    private javax.swing.JLabel jlMuseo;
    private javax.swing.JLabel jlPoliticasdePrivacidad;
    private javax.swing.JLabel jlTerminosyCondiciones;
    private javax.swing.JLabel lblImgJJ;
    // End of variables declaration//GEN-END:variables
}
