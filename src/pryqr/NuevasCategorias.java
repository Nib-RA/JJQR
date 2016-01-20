/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pryqr;

import Modelos.ItemSeleccionado;
import db.mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class NuevasCategorias extends javax.swing.JFrame {
Connection conn;
Statement sent;
String accion;
    
    /**
     * Creates new form NuevasCategorias
     */
    public NuevasCategorias() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtNombreCategoria.requestFocus();
        conn = mysql.getConnect();

        accion=ItemSeleccionado.accionBoton;
        btnAceptar.setText(accion);
        try{
            //Muestra los usuarios existentes en la base de datos
            if(accion.contains("Actualizar")){
                String SQLTC ="SELECT * FROM categorias WHERE IDCATEGORIA = " + ItemSeleccionado.idCategoria; 
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(SQLTC);
                rs.next();
                txtNombreCategoria.setText(rs.getString("NOMBRECATEGORIA"));
                txtDescripcionCategoria.setText(rs.getString("DESCRIPCIONCATEGORIA"));
                rs.close();
            }
        }
        catch(Exception e){

        }
    }
    

    void GuardarCategoria(){
        try {
            //Ingreso en nuevo usuario
            if(btnAceptar.getText().contains("Guardar")){
                    if (txtNombreCategoria.getText().trim().isEmpty() || txtDescripcionCategoria.getText().trim().isEmpty() )                     JOptionPane.showMessageDialog(null, "Ingrese Los Campos Obligatorios");
                    else{        
                        try {
                        String SQL = "INSERT INTO categorias(NOMBRECATEGORIA,DESCRIPCIONCATEGORIA)"
                                + " VALUES(?,?)";
                        PreparedStatement ps = conn.prepareStatement(SQL);
                        ps.setString(1, txtNombreCategoria.getText());
                        ps.setString(2, txtDescripcionCategoria.getText());
                        int n = ps.executeUpdate();
                        if (n > 0) {
                                JOptionPane.showMessageDialog(null, "Categoria creada Correctamente");
                                dispose();
                            } 
                      } catch (SQLException e) {
                      JOptionPane.showConfirmDialog(null, "Error: " + e.getMessage());
                      System.out.println();
                      }
                       } 
                    }
                    else{
                        String SQL = "UPDATE categorias SET NOMBRECATEGORIA = ?, DESCRIPCIONCATEGORIA = ? WHERE IDCATEGORIA = " + ItemSeleccionado.idCategoria;
                        PreparedStatement ps = conn.prepareStatement(SQL);
                        ps.setString(1, txtNombreCategoria.getText());
                        ps.setString(2, txtDescripcionCategoria.getText());
                        int n = ps.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Categoria actualizada Correctamente");
                            dispose();
                            Usuarios fru=new Usuarios();
                            fru.show();
                        }
                    }
                } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: " + e.getMessage());
            //System.out.println();
        }
    }
         
       /*void Guardar(){
           if (txtNombreCategoria.getText().trim().isEmpty() || txtDescripcionCategoria.getText().trim().isEmpty() )                     JOptionPane.showMessageDialog(null, "Ingrese Los Campos Obligatorios");
           else{        
                  try {
               
                            String SQL = "INSERT INTO categorias(NOMBRECATEGORIA,DESCRIPCIONCATEGORIA)"
                                    + " VALUES(?,?)";
                            PreparedStatement ps = conn.prepareStatement(SQL);
                            ps.setString(1, txtNombreCategoria.getText());
                            ps.setString(2, txtDescripcionCategoria.getText());
                            int n = ps.executeUpdate();
                            if (n > 0) {
                                JOptionPane.showMessageDialog(null, "Categoria creada Correctamente");
                                dispose();
                            }
                            //else       JOptionPane.showMessageDialog(null, "Escoja una fecha");
                      } catch (SQLException e) {
                      JOptionPane.showConfirmDialog(null, "Error: " + e.getMessage());
                      System.out.println();
                      }
        }
      }*/
                
       
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlNuevaCategoria = new javax.swing.JLabel();
        jlNombreCategoria = new javax.swing.JLabel();
        jlDescripcionCategoria = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionCategoria = new javax.swing.JTextArea();
        txtNombreCategoria = new javax.swing.JTextField();
        jlCamposObligatorios = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        txtCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(2, 32, 62));

        jlNuevaCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlNuevaCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jlNuevaCategoria.setText("Nueva Categoria");

        jlNombreCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlNombreCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jlNombreCategoria.setText("Nombre");

        jlDescripcionCategoria.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlDescripcionCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jlDescripcionCategoria.setText("Descripcion");

        txtDescripcionCategoria.setColumns(20);
        txtDescripcionCategoria.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionCategoria);

        jlCamposObligatorios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlCamposObligatorios.setForeground(new java.awt.Color(204, 51, 0));
        jlCamposObligatorios.setText("Todos los campos son obligatorios ... !");

        btnCancelar.setBackground(new java.awt.Color(153, 204, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(153, 204, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        txtCerrar.setBackground(new java.awt.Color(2, 32, 62));
        txtCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        txtCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNuevaCategoria)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNombreCategoria)
                        .addGap(25, 25, 25))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDescripcionCategoria)
                    .addComponent(jlNombreCategoria)
                    .addComponent(jScrollPane2))
                .addContainerGap(25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jlCamposObligatorios)
                .addContainerGap(101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addComponent(txtCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(242, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlNuevaCategoria)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombreCategoria)
                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jlDescripcionCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlCamposObligatorios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(461, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_txtCerrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        GuardarCategoria();
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevasCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevasCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevasCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevasCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NuevasCategorias().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlCamposObligatorios;
    private javax.swing.JLabel jlDescripcionCategoria;
    private javax.swing.JLabel jlNombreCategoria;
    private javax.swing.JLabel jlNuevaCategoria;
    private javax.swing.JButton txtCerrar;
    private javax.swing.JTextArea txtDescripcionCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
