package pryqr;

import Modelos.UsuarioIngresado;
import Modelos.ValoresConstantes;
import java.sql.Connection;
import db.mysql;
import java.awt.Color;
import java.io.File;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Principal extends javax.swing.JFrame {
    static Connection con;
    static Statement sent;
    
    
    public Principal() {
        initComponents();
        File folderPrincipal = new File(ValoresConstantes.directorioPrincipal);
        if(!folderPrincipal.exists()) folderPrincipal.mkdir();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        if(con == null) con = mysql.getConnect();
        jlMuseo.requestFocus();
        jlGaleria.setVisible(false);
        lblUsuarioyRol.setText("Bienvenid@ " + UsuarioIngresado.parametroU+" tu rol es de " + UsuarioIngresado.parametroR);
        //Negacion de Privilegio de creacion de Usuarios a secretaria
        if(UsuarioIngresado.parametroR.equals("Secretario/a")){
        btnUsuarios.setContentAreaFilled (false);
        btnUsuarios.setEnabled(false);
        btnUsuarios.setForeground(Color.BLACK);
    }
        if(UsuarioIngresado.parametroR.equals("Inspector/a") || UsuarioIngresado.parametroR.equals("Recepcionista")){
        //btnActualizarCategoria.setContentAreaFilled(false);
        UIManager.put("btnActualizarCategoria.disabledBackground", Color.YELLOW);
        btnUsuarios.setContentAreaFilled (false);
        btnUsuarios.setEnabled(false);
        btnUsuarios.setForeground(Color.BLACK);
    }
         
     }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPantalla = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbAcercade = new javax.swing.JButton();
        jbContactanos = new javax.swing.JButton();
        jlMuseo = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnContenidos = new javax.swing.JButton();
        jlGaleria = new javax.swing.JLabel();
        imgMuseo1 = new javax.swing.JLabel();
        imgMuseo2 = new javax.swing.JLabel();
        imgMuseo3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlGaleria1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlJJ2016 = new javax.swing.JLabel();
        jlTerminosyCondiciones = new javax.swing.JLabel();
        jlPoliticasdePrivacidad = new javax.swing.JLabel();
        lblUsuarioyRol = new javax.swing.JLabel();
        lblCerrarSesion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1401, 858));
        setMinimumSize(new java.awt.Dimension(1401, 858));

        PanelPantalla.setBackground(new java.awt.Color(255, 255, 255));

        panelMenu.setBackground(new java.awt.Color(155, 80, 80));

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
        jlMuseo.setText("Museo \"ISIDRO AYORA\"");
        jlMuseo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jbAcercade, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbContactanos, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnContenidos, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlMuseo, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbAcercade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnContenidos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbContactanos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jlMuseo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jlGaleria.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jlGaleria.setText("Galería del Museo de la Escuela Isidro Ayora");

        imgMuseo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/museo2.jpg"))); // NOI18N

        imgMuseo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/museo1.jpg"))); // NOI18N

        imgMuseo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/museo3.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel2.setText("Museo, que lleva el nombre de \"Jorgue Gallegos Cruz\", honrando asi la  memoria del amigo,  compañero y director,  que se debe al aporte de los");

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel3.setText("maestros que lo integran. Cuenta con las siguientes secciones: Zoología, Botánica, Numismática, Arqueología, Mineralogía, Folklore, Maquetas ");

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel4.setText("Tecnológias relacionadas con la ciencia y la industria de la provincia.");

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel5.setText("El Compromiso de los Profesores de la Escuela Isidro Ayora y el Acto de inauguración se lo fijó para el 15 de mayo de 1963, coincidiendo con el día");

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 0, 18)); // NOI18N
        jLabel6.setText("de San Isidro, la constancia de este importante aconteciimiento quedó grabado para siempre.");

        jlGaleria1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        jlGaleria1.setForeground(new java.awt.Color(51, 0, 0));
        jlGaleria1.setText("MUSEO \"ISIDRO AYORA\"");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jlJJ2016.setForeground(new java.awt.Color(255, 255, 255));
        jlJJ2016.setText("JJ 2016 Reservados  todos  los  derechos . ");

        jlTerminosyCondiciones.setForeground(new java.awt.Color(255, 51, 0));
        jlTerminosyCondiciones.setText("Terminos y Condiciones");
        jlTerminosyCondiciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlTerminosyCondiciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlTerminosyCondicionesMouseClicked(evt);
            }
        });

        jlPoliticasdePrivacidad.setForeground(new java.awt.Color(153, 204, 255));
        jlPoliticasdePrivacidad.setText("|  Políticas de Privacidad");
        jlPoliticasdePrivacidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlPoliticasdePrivacidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlPoliticasdePrivacidadMouseClicked(evt);
            }
        });

        lblUsuarioyRol.setForeground(new java.awt.Color(255, 0, 0));
        lblUsuarioyRol.setText("jLabel1");

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
                .addGap(171, 171, 171)
                .addComponent(lblUsuarioyRol, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlJJ2016)
                            .addComponent(jlTerminosyCondiciones)
                            .addComponent(jlPoliticasdePrivacidad))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblUsuarioyRol, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        lblCerrarSesion.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        lblCerrarSesion.setForeground(new java.awt.Color(153, 0, 0));
        lblCerrarSesion.setText("[Cerrar Sesión]");
        lblCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarSesionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelPantallaLayout = new javax.swing.GroupLayout(PanelPantalla);
        PanelPantalla.setLayout(PanelPantallaLayout);
        PanelPantallaLayout.setHorizontalGroup(
            PanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelPantallaLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(PanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPantallaLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(PanelPantallaLayout.createSequentialGroup()
                        .addComponent(imgMuseo1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(imgMuseo2)
                        .addGap(136, 136, 136)
                        .addComponent(imgMuseo3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(196, 196, 196))
                    .addGroup(PanelPantallaLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))
                    .addGroup(PanelPantallaLayout.createSequentialGroup()
                        .addGroup(PanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPantallaLayout.createSequentialGroup()
                                .addGap(471, 471, 471)
                                .addComponent(jlGaleria)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelPantallaLayout.createSequentialGroup()
                        .addComponent(jlGaleria1)
                        .addGap(302, 302, 302)
                        .addComponent(lblCerrarSesion)
                        .addGap(156, 156, 156))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPantallaLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelPantallaLayout.setVerticalGroup(
            PanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPantallaLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPantallaLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jlGaleria1))
                    .addGroup(PanelPantallaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblCerrarSesion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jlGaleria)
                .addGap(18, 18, 18)
                .addGroup(PanelPantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgMuseo1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgMuseo3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgMuseo2))
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, 1401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbContactanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbContactanosActionPerformed
        Contactanos frcont=new Contactanos();
        frcont.show();
        dispose();
    }//GEN-LAST:event_jbContactanosActionPerformed

    private void jbAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcercadeActionPerformed
        AcercaDe frad=new AcercaDe();
        frad.show();
        dispose();
    }//GEN-LAST:event_jbAcercadeActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        Usuarios fr=new Usuarios();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContenidosActionPerformed
        Contenidos fr=new Contenidos();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContenidosActionPerformed

    private void jlTerminosyCondicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTerminosyCondicionesMouseClicked
        TerminosyCondiciones tc1=new TerminosyCondiciones();
        tc1.setVisible(true);
    }//GEN-LAST:event_jlTerminosyCondicionesMouseClicked

    private void jlPoliticasdePrivacidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPoliticasdePrivacidadMouseClicked
        PoliticasdePrivacidad pp=new PoliticasdePrivacidad();
        pp.setVisible(true);
    }//GEN-LAST:event_jlPoliticasdePrivacidadMouseClicked

    private void lblCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarSesionMouseClicked
        Object [] opciones={"Aceptar","Cancelar"};
        int eleccion=JOptionPane.showOptionDialog(null,"Está seguro que desea cerrar sesión","Mensaje de Confirmación",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
        if(eleccion==JOptionPane.YES_OPTION)
        {   
        Login frlog=new Login();
        frlog.show();
        dispose();
        }
    }//GEN-LAST:event_lblCerrarSesionMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPantalla;
    private javax.swing.JButton btnContenidos;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel imgMuseo1;
    private javax.swing.JLabel imgMuseo2;
    private javax.swing.JLabel imgMuseo3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbAcercade;
    private javax.swing.JButton jbContactanos;
    private javax.swing.JLabel jlGaleria;
    private javax.swing.JLabel jlGaleria1;
    private javax.swing.JLabel jlJJ2016;
    private javax.swing.JLabel jlMuseo;
    private javax.swing.JLabel jlPoliticasdePrivacidad;
    private javax.swing.JLabel jlTerminosyCondiciones;
    private javax.swing.JLabel lblCerrarSesion;
    private javax.swing.JLabel lblUsuarioyRol;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
