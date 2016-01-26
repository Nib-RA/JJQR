/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pryqr;

import Modelos.ItemSeleccionado;
import Modelos.UsuarioIngresado;
import db.mysql;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import static pryqr.NuevoQr.Mostrar_Visualizador;

/**
 *
 * @author Jess
 */
public class Contenidos extends javax.swing.JFrame {
    DefaultTableModel model;
    Connection conn;
    Statement sent;
    ItemSeleccionado isC=new ItemSeleccionado();
    String idC = "";
    
    
    
    public Contenidos() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        lblUsuarioyRol.setText("Bienvenid@ " + UsuarioIngresado.parametroU+" tu rol es de " + UsuarioIngresado.parametroR);
        conn = mysql.getConnect();
        LlenarTablaCategorias();
        btnGaleria.requestFocus();
        String Ruta=getClass().getResource("/images/Mas.png").getPath();
        Mostrar_Visualizador(btnNuevaCategoria, Ruta);
        String Ruta1=getClass().getResource("/images/actualizar.png").getPath();
        Mostrar_Visualizador(btnActualizarCategoria, Ruta1);
        String Ruta2=getClass().getResource("/images/Eliminar.png").getPath();
        Mostrar_Visualizador(btnEliminarCategoria, Ruta2);
        String Ruta3=getClass().getResource("/images/search.png").getPath();
        Mostrar_Visualizador(btnBuscarCategoria, Ruta3);
        txtBuscarContenidos.setEnabled(false);
        //Negacion de Privilegio de creacion de Usuarios a secretaria
        if(UsuarioIngresado.parametroR.equals("Secretario/a")){
        btnUsuarios.setContentAreaFilled (false);
        btnUsuarios.setEnabled(false);
        btnUsuarios.setForeground(Color.BLACK);
         }
        //Negaccion de privilegios de Crear modificar y borrar categorias a inspector y recepcionista
        if(UsuarioIngresado.parametroR.equals("Consultor/a")){
        btnNuevaCategoria.setEnabled (false);
        btnNuevaCategoria.setEnabled(false);
        btnNuevaCategoria.setBackground(Color.red);
        //btnActualizarCategoria.setContentAreaFilled(false);
        UIManager.put("btnActualizarCategoria.disabledBackground", Color.YELLOW);
        btnNuevaCategoria.setEnabled(false);
        btnEliminarCategoria.setEnabled(false);
        btnUsuarios.setContentAreaFilled (false);
        btnUsuarios.setEnabled(false);
        btnUsuarios.setForeground(Color.BLACK);
    }
    }
    
    
    
    void SeleccionarItemTablaC(java.awt.event.MouseEvent evt){
        DefaultTableModel modelo=(DefaultTableModel) jtCategorias.getModel();
        idC=String.valueOf(modelo.getValueAt(jtCategorias.getSelectedRow(),0));
        
    }
    
    
    void LlenarTablaCategorias(){
    try{
    String titulos[] = {"Id","Nombre","Descripcion"};
    String SQLTC ="SELECT * FROM categorias ORDER BY NOMBRECATEGORIA ASC"; 
    model = new DefaultTableModel(null, titulos);
    sent = conn.createStatement();
    ResultSet rs = sent.executeQuery(SQLTC);
    
    String[]fila=new String[3];
    while(rs.next()){
        fila[0] = rs.getString("IDCATEGORIA");
        fila[1] = rs.getString("NOMBRECATEGORIA");
        fila[2] = rs.getString("DESCRIPCIONCATEGORIA");
       model.addRow(fila);
        
    }
    jtCategorias.setModel(model);
    }catch(Exception e){
        
    }
    
}
    
    void EliminarCategoria(){
    JOptionPane.showMessageDialog(null, "La categoría sera eliminada");
        int fila = jtCategorias.getSelectedRow();
        try {
            String SQL = "DELETE FROM categorias WHERE IDCATEGORIA=" + jtCategorias.getValueAt(fila, 0);
            sent = conn.createStatement();
            int n = sent.executeUpdate(SQL);
            if (n > 0){
                JOptionPane.showMessageDialog(null, "Categoria eliminada correctamente ");
                LlenarTablaCategorias();
            }
            else                JOptionPane.showMessageDialog(null, "Categoria no eliminado ");
            }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: Debe Seleccionar un registro " );
            }
        }
    
    void BuscarPorNombreCategoria (){
        
        try{
         String titulos[] = {"IDCATEGORIA", "NOMBRECATEGORIA","DESCRIPCIONCATEGORIA"};
         
    //Consulta para la fecha de inicio a fecha de final
    String SQL = "SELECT *FROM categorias WHERE NOMBRECATEGORIA Like '%"+txtBuscarContenidos.getText().toString().trim()+"%'ORDER BY NOMBRECATEGORIA ASC";

    model= new DefaultTableModel(null, titulos);
    sent = conn.createStatement();
    ResultSet rs = sent.executeQuery(SQL);
    String[]fila=new String[3];
   while(rs.next()){
        fila[0] = rs.getString("IDCATEGORIA");
        fila[1] = rs.getString("NOMBRECATEGORIA");
        fila[2] = rs.getString("DESCRIPCIONCATEGORIA");
        model.addRow(fila);
        
   }
    jtCategorias.setModel(model);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error de Consulta..... :(");
    }
  }
          
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jlJJ2016 = new javax.swing.JLabel();
        jlPoliticasdePrivacidad = new javax.swing.JLabel();
        jlTerminosyCondiciones = new javax.swing.JLabel();
        lblUsuarioyRol = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbAcercade = new javax.swing.JButton();
        jbContactanos = new javax.swing.JButton();
        jlMuseo = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnGaleria = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jlCrearArticulo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlCrearCategoria = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jlNuevaCategoria = new javax.swing.JLabel();
        jlCategorias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCategorias = new javax.swing.JTable();
        btnNuevaCategoria = new javax.swing.JLabel();
        btnEliminarCategoria = new javax.swing.JLabel();
        btnBuscarCategoria = new javax.swing.JLabel();
        txtBuscarContenidos = new javax.swing.JTextField();
        btnActualizarCategoria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

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

        lblUsuarioyRol.setForeground(new java.awt.Color(255, 0, 0));
        lblUsuarioyRol.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jlJJ2016)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlTerminosyCondiciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlPoliticasdePrivacidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuarioyRol, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTerminosyCondiciones)
                    .addComponent(jlPoliticasdePrivacidad)
                    .addComponent(lblUsuarioyRol, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlJJ2016))
                .addGap(18, 18, 18))
        );

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
        jlMuseo.setText("Museo \"ISIDRO AYORA\"");
        jlMuseo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        btnGaleria.setBackground(new java.awt.Color(92, 29, 29));
        btnGaleria.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        btnGaleria.setText("Galería");
        btnGaleria.setMaximumSize(new java.awt.Dimension(183, 27));
        btnGaleria.setMinimumSize(new java.awt.Dimension(183, 27));
        btnGaleria.setPreferredSize(new java.awt.Dimension(200, 23));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jbAcercade, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbContactanos, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlMuseo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbAcercade, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbContactanos, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnGaleria, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlMuseo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(139, 93, 93));

        jlCrearArticulo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlCrearArticulo.setText("           Crear Articulo");
        jlCrearArticulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlCrearArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCrearArticuloMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlCrearArticulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlCrearArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(139, 93, 93));

        jlCrearCategoria.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jlCrearCategoria.setText("           Crear Categoria");
        jlCrearCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCrearCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlCrearCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jlNuevaCategoria.setForeground(new java.awt.Color(255, 255, 255));
        jlNuevaCategoria.setText("Nuevo");

        jlCategorias.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jlCategorias.setText("Categorias");

        jtCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCategorias);

        btnNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mas.png"))); // NOI18N
        btnNuevaCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaCategoria.setMaximumSize(new java.awt.Dimension(84, 81));
        btnNuevaCategoria.setMinimumSize(new java.awt.Dimension(84, 81));
        btnNuevaCategoria.setPreferredSize(new java.awt.Dimension(84, 81));
        btnNuevaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaCategoriaMouseClicked(evt);
            }
        });

        btnEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Eliminar.png"))); // NOI18N
        btnEliminarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCategoria.setMaximumSize(new java.awt.Dimension(84, 81));
        btnEliminarCategoria.setMinimumSize(new java.awt.Dimension(84, 81));
        btnEliminarCategoria.setPreferredSize(new java.awt.Dimension(84, 81));
        btnEliminarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarCategoriaMouseClicked(evt);
            }
        });

        btnBuscarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnBuscarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCategoria.setMaximumSize(new java.awt.Dimension(84, 81));
        btnBuscarCategoria.setMinimumSize(new java.awt.Dimension(84, 81));
        btnBuscarCategoria.setPreferredSize(new java.awt.Dimension(84, 81));
        btnBuscarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarCategoriaMouseClicked(evt);
            }
        });

        txtBuscarContenidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarContenidosKeyPressed(evt);
            }
        });

        btnActualizarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnActualizarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizarCategoria.setMaximumSize(new java.awt.Dimension(84, 81));
        btnActualizarCategoria.setMinimumSize(new java.awt.Dimension(84, 81));
        btnActualizarCategoria.setPreferredSize(new java.awt.Dimension(84, 81));
        btnActualizarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarCategoriaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnActualizarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarContenidos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(jlCategorias))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlNuevaCategoria)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(txtBuscarContenidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnActualizarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(312, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jlNuevaCategoria)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1390, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jlMuseoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMuseoMouseClicked
        // TODO add your handling code here:
        Principal fr=new Principal();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jlMuseoMouseClicked

    private void jlCrearArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCrearArticuloMouseClicked
        ContenidosArticulos ca = new ContenidosArticulos();
        ca.setVisible(true);
        dispose();
    }//GEN-LAST:event_jlCrearArticuloMouseClicked

    private void jlPoliticasdePrivacidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPoliticasdePrivacidadMouseClicked
        PoliticasdePrivacidad pp=new PoliticasdePrivacidad();
        pp.setVisible(true);
    }//GEN-LAST:event_jlPoliticasdePrivacidadMouseClicked

    private void jlTerminosyCondicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTerminosyCondicionesMouseClicked
        TerminosyCondiciones tc1=new TerminosyCondiciones();
        tc1.setVisible(true);
    }//GEN-LAST:event_jlTerminosyCondicionesMouseClicked

    private void btnNuevaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaMouseClicked
         isC.setAccionBoton("Guardar");
        NuevasCategorias frnu=new NuevasCategorias();
        frnu.show();
    }//GEN-LAST:event_btnNuevaCategoriaMouseClicked

    private void btnEliminarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaMouseClicked
        // TODO add your handling code here:
        EliminarCategoria();
    }//GEN-LAST:event_btnEliminarCategoriaMouseClicked

    private void btnBuscarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaMouseClicked
        // TODO add your handling code here:
        txtBuscarContenidos.setEnabled(true);
    }//GEN-LAST:event_btnBuscarCategoriaMouseClicked

    private void txtBuscarContenidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarContenidosKeyPressed
        // TODO add your handling code here:
        BuscarPorNombreCategoria();
    }//GEN-LAST:event_txtBuscarContenidosKeyPressed

    private void jtCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtCategoriasMouseClicked
        // TODO add your handling code here:
        SeleccionarItemTablaC(evt);
    }//GEN-LAST:event_jtCategoriasMouseClicked

    private void btnActualizarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarCategoriaMouseClicked
        // TODO add your handling code here:
        if(!idC.isEmpty()){
            isC.setAccionBoton("Actualizar");
            isC.setIdCategoria(idC);
            NuevasCategorias frnu=new NuevasCategorias();
            frnu.show();
        }else JOptionPane.showMessageDialog(this, "No ha seleccionado una categoria a modificar");
    }//GEN-LAST:event_btnActualizarCategoriaMouseClicked

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
            java.util.logging.Logger.getLogger(Contenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contenidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contenidos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizarCategoria;
    private javax.swing.JLabel btnBuscarCategoria;
    private javax.swing.JLabel btnEliminarCategoria;
    private javax.swing.JButton btnGaleria;
    private javax.swing.JLabel btnNuevaCategoria;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAcercade;
    private javax.swing.JButton jbContactanos;
    private javax.swing.JLabel jlCategorias;
    private javax.swing.JLabel jlCrearArticulo;
    private javax.swing.JLabel jlCrearCategoria;
    private javax.swing.JLabel jlJJ2016;
    private javax.swing.JLabel jlMuseo;
    private javax.swing.JLabel jlNuevaCategoria;
    private javax.swing.JLabel jlPoliticasdePrivacidad;
    private javax.swing.JLabel jlTerminosyCondiciones;
    private javax.swing.JTable jtCategorias;
    private javax.swing.JLabel lblUsuarioyRol;
    private javax.swing.JTextField txtBuscarContenidos;
    // End of variables declaration//GEN-END:variables
}
