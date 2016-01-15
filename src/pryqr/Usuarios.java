/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pryqr;

import Modelos.ItemSeleccionado;
import db.mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pryqr.NuevoQr.Mostrar_Visualizador;

/**
 *
 * @author Jess
 */
public class Usuarios extends javax.swing.JFrame {
    DefaultTableModel model;
    Connection conn;
    Statement sent;
    ItemSeleccionado is=new ItemSeleccionado();
    String id = "", rol = "", estado = "";
    Boolean comboBuscar=false;
    Integer buscar = 0;

    
    public Usuarios() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        conn = mysql.getConnect();
        LlenarTablaUsuarios();
        jtUsuarios.requestFocus();
        String Ruta=getClass().getResource("/images/plus.png").getPath();
        Mostrar_Visualizador(btnActualizar, Ruta);
        String Ruta1=getClass().getResource("/images/actualizar.png").getPath();
        Mostrar_Visualizador(btnActualizar, Ruta1);
        String Ruta2=getClass().getResource("/images/eliminar.jpg").getPath();
        Mostrar_Visualizador(btnEliminar, Ruta2);
        String Ruta3=getClass().getResource("/images/search.png").getPath();
        Mostrar_Visualizador(btnBuscarUsuarios, Ruta3);
        jcbBuscarPor.setEnabled(false);
        txtBuscarPor.setEnabled(false);
        chbActivo.setEnabled(false);
        chbInactivo.setEnabled(false);

        
    }
    
    void LlenarTablaUsuarios(){
        try{
        //Muestra los usuarios existentes en la base de datos
        String titulos[] = {"IDUSUARIO", "TIPO DE USUARIO","NOMBRE","APELLIDO","CEDULA","CORREO DEL USUARIO","ESTADO DE USUARIO"};
        //String SQL ="SELECT * FROM ingresos where CodigoParaiso Like '%"+txtBuscar.getText().toString().trim()+"%'AND ORDER BY Movimiento,Id,Fecha ASC"; 
        String SQLTU ="SELECT * FROM usuarios ORDER BY IDUSUARIO ASC"; 
        model = new DefaultTableModel(null, titulos);
        sent = conn.createStatement();
        ResultSet rs = sent.executeQuery(SQLTU);
        String[]fila=new String[7];
        while(rs.next()){
            fila[0] = rs.getString("IDUSUARIO");
            fila[1] = rs.getString("TIPOUSUARIO");
            fila[2] = rs.getString("NOMBRESUSUARIO");
            fila[3] = rs.getString("APELLIDOSUSUARIO");
            fila[4] = rs.getString("CEDULAUSUARIO");
            fila[5] = rs.getString("CORREOUSUARIO");
            fila[6] = rs.getString("ESTADOUSUARIO");
            model.addRow(fila);
        }
        rs.close();
        jtUsuarios.setModel(model);
        }catch(Exception e){

        }
    }

    void SeleccionarItemTablaU(java.awt.event.MouseEvent evt){
        DefaultTableModel modelo=(DefaultTableModel) jtUsuarios.getModel();
        id=String.valueOf(modelo.getValueAt(jtUsuarios.getSelectedRow(),0));
        rol=String.valueOf(modelo.getValueAt(jtUsuarios.getSelectedRow(),1));
        estado=String.valueOf(modelo.getValueAt(jtUsuarios.getSelectedRow(),6));
        lblNuevo.setText(id);
    }

    void BuscarPorNombreUsuario (){
        
        try{
         String titulos[] = {"IDUSUARIO", "TIPO DE USUARIO","NOMBRE","APELLIDO","CEDULA","CORREO DEL USUARIO","ESTADO DE USUARIO"};
         
    //Consulta para la fecha de inicio a fecha de final
    String SQL = "SELECT *FROM usuarios WHERE NOMBRESUSUARIO Like '%"+txtBuscarPor.getText().toString().trim()+"%'ORDER BY NOMBRESUSUARIO ASC";

    model= new DefaultTableModel(null, titulos);
    sent = conn.createStatement();
    ResultSet rs = sent.executeQuery(SQL);
    String[]fila=new String[7];
   while(rs.next()){
        fila[0] = rs.getString("IDUSUARIO");
        fila[1] = rs.getString("TIPOUSUARIO");
        fila[2] = rs.getString("NOMBRESUSUARIO");
        fila[3] = rs.getString("APELLIDOSUSUARIO");
        fila[4] = rs.getString("CEDULAUSUARIO");
        fila[5] = rs.getString("CORREOUSUARIO");
        fila[6] = rs.getString("ESTADOUSUARIO");
        model.addRow(fila);
   }
    jtUsuarios.setModel(model);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error de Consulta..... :(");
    }
    }
    
    void BuscarPorApellidoUsuario (){
        
        try{
         String titulos[] = {"IDUSUARIO", "TIPO DE USUARIO","NOMBRE","APELLIDO","CEDULA","CORREO DEL USUARIO","ESTADO DE USUARIO"};
         
    //Consulta para la fecha de inicio a fecha de final
    String SQL = "SELECT *FROM usuarios WHERE APELLIDOSUSUARIO Like '%"+txtBuscarPor.getText().toString().trim()+"%'ORDER BY NOMBRESUSUARIO ASC";

    model= new DefaultTableModel(null, titulos);
    sent = conn.createStatement();
    ResultSet rs = sent.executeQuery(SQL);
    String[]fila=new String[7];
   while(rs.next()){
        fila[0] = rs.getString("IDUSUARIO");
        fila[1] = rs.getString("TIPOUSUARIO");
        fila[2] = rs.getString("NOMBRESUSUARIO");
        fila[3] = rs.getString("APELLIDOSUSUARIO");
        fila[4] = rs.getString("CEDULAUSUARIO");
        fila[5] = rs.getString("CORREOUSUARIO");
        fila[6] = rs.getString("ESTADOUSUARIO");
        model.addRow(fila);
   }
    jtUsuarios.setModel(model);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error de Consulta..... :(");
    }
    }
    
    void BuscarPorTipoUsuario (){
        
        try{
         String titulos[] = {"IDUSUARIO", "TIPO DE USUARIO","NOMBRE","APELLIDO","CEDULA","CORREO DEL USUARIO","ESTADO DE USUARIO"};
         
    //Consulta para la fecha de inicio a fecha de final
    String SQL = "SELECT *FROM usuarios WHERE TIPOUSUARIO Like '%"+txtBuscarPor.getText().toString().trim()+"%'ORDER BY NOMBRESUSUARIO ASC";

    model= new DefaultTableModel(null, titulos);
    sent = conn.createStatement();
    ResultSet rs = sent.executeQuery(SQL);
    String[]fila=new String[7];
   while(rs.next()){
        fila[0] = rs.getString("IDUSUARIO");
        fila[1] = rs.getString("TIPOUSUARIO");
        fila[2] = rs.getString("NOMBRESUSUARIO");
        fila[3] = rs.getString("APELLIDOSUSUARIO");
        fila[4] = rs.getString("CEDULAUSUARIO");
        fila[5] = rs.getString("CORREOUSUARIO");
        fila[6] = rs.getString("ESTADOUSUARIO");
        model.addRow(fila);
   }
    jtUsuarios.setModel(model);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error de Consulta..... :(");
    }
    }
    
    void BuscarPorCedula (){
        
        try{
         String titulos[] = {"IDUSUARIO", "TIPO DE USUARIO","NOMBRE","APELLIDO","CEDULA","CORREO DEL USUARIO","ESTADO DE USUARIO"};
         
    //Consulta para la fecha de inicio a fecha de final
    String SQL = "SELECT *FROM usuarios WHERE CEDULAUSUARIO Like '%"+txtBuscarPor.getText().toString().trim()+"%'ORDER BY NOMBRESUSUARIO ASC";

    model= new DefaultTableModel(null, titulos);
    sent = conn.createStatement();
    ResultSet rs = sent.executeQuery(SQL);
    String[]fila=new String[7];
   while(rs.next()){
        fila[0] = rs.getString("IDUSUARIO");
        fila[1] = rs.getString("TIPOUSUARIO");
        fila[2] = rs.getString("NOMBRESUSUARIO");
        fila[3] = rs.getString("APELLIDOSUSUARIO");
        fila[4] = rs.getString("CEDULAUSUARIO");
        fila[5] = rs.getString("CORREOUSUARIO");
        fila[6] = rs.getString("ESTADOUSUARIO");
        model.addRow(fila);
        
   }
    jtUsuarios.setModel(model);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error de Consulta..... :(");
    }
    }
    
    void BuscarPorEstadoUsuario (){
        
        try{
         String titulos[] = {"IDUSUARIO", "TIPO DE USUARIO","NOMBRE","APELLIDO","CEDULA","CORREO DEL USUARIO","ESTADO DE USUARIO"};
         
    //Consulta para la fecha de inicio a fecha de final
    String SQL = "SELECT *FROM usuarios WHERE ESTADOUSUARIO = 1 ORDER BY NOMBRESUSUARIO ASC";

    model= new DefaultTableModel(null, titulos);
    sent = conn.createStatement();
    ResultSet rs = sent.executeQuery(SQL);
    String[]fila=new String[7];
   while(rs.next()){
        fila[0] = rs.getString("IDUSUARIO");
        fila[1] = rs.getString("TIPOUSUARIO");
        fila[2] = rs.getString("NOMBRESUSUARIO");
        fila[3] = rs.getString("APELLIDOSUSUARIO");
        fila[4] = rs.getString("CEDULAUSUARIO");
        fila[5] = rs.getString("CORREOUSUARIO");
        fila[6] = rs.getString("ESTADOUSUARIO");
        model.addRow(fila);
   }
    jtUsuarios.setModel(model);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbAcercade = new javax.swing.JButton();
        jbContactanos = new javax.swing.JButton();
        jlMuseo = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnContenidos = new javax.swing.JButton();
        jlUsuarios = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jcbBuscarPor = new javax.swing.JComboBox<>();
        txtBuscarPor = new javax.swing.JTextField();
        btnNuevoUsuario1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JLabel();
        btnBuscarUsuarios = new javax.swing.JLabel();
        lblNuevo = new javax.swing.JLabel();
        chbActivo = new javax.swing.JCheckBox();
        chbInactivo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1414, 631));

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
                .addContainerGap(550, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlTerminosyCondiciones)
                        .addComponent(jlPoliticasdePrivacidad))
                    .addComponent(jlJJ2016))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(2004, 664));
        jPanel1.setMinimumSize(new java.awt.Dimension(2004, 664));

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
                .addGap(81, 81, 81)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jlUsuarios.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jlUsuarios.setText("Usuarios");

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuarios);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jcbBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione una opcion--", "Cedula de Usuario", "Nombre de Usuario", "Apellido de Usuario", "Tipo de Usuario", "Estado de Usuario" }));
        jcbBuscarPor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbBuscarPorMouseClicked(evt);
            }
        });
        jcbBuscarPor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbBuscarPorItemStateChanged(evt);
            }
        });

        txtBuscarPor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarPorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarPorKeyTyped(evt);
            }
        });

        btnNuevoUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.jpg"))); // NOI18N
        btnNuevoUsuario1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoUsuario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoUsuario1MouseClicked(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.jpg"))); // NOI18N
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setMaximumSize(new java.awt.Dimension(84, 81));
        btnEliminar.setMinimumSize(new java.awt.Dimension(84, 81));
        btnEliminar.setPreferredSize(new java.awt.Dimension(84, 81));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar.png"))); // NOI18N
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.setMaximumSize(new java.awt.Dimension(84, 81));
        btnActualizar.setMinimumSize(new java.awt.Dimension(84, 81));
        btnActualizar.setPreferredSize(new java.awt.Dimension(84, 81));
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
        });

        btnBuscarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarUsuariosMouseClicked(evt);
            }
        });

        lblNuevo.setText("Nuevo");

        chbActivo.setText("Activo");
        chbActivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbActivoItemStateChanged(evt);
            }
        });

        chbInactivo.setText("Inactivo");
        chbInactivo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chbInactivoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblNuevo))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnNuevoUsuario1)
                        .addGap(29, 29, 29)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jcbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chbActivo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chbInactivo)))))
                .addContainerGap(305, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbActivo)
                            .addComponent(chbInactivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNuevoUsuario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1156, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(260, 260, 260)
                .addComponent(jlUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlUsuarios)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void btnContenidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContenidosActionPerformed
        Contenidos fr=new Contenidos();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContenidosActionPerformed

    private void jlMuseoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMuseoMouseClicked
        Principal fr=new Principal();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_jlMuseoMouseClicked

    private void jlPoliticasdePrivacidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlPoliticasdePrivacidadMouseClicked
        PoliticasdePrivacidad pp=new PoliticasdePrivacidad();
        pp.setVisible(true);
    }//GEN-LAST:event_jlPoliticasdePrivacidadMouseClicked

    private void jlTerminosyCondicionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlTerminosyCondicionesMouseClicked
        TerminosyCondiciones tc1=new TerminosyCondiciones();
        tc1.setVisible(true);
    }//GEN-LAST:event_jlTerminosyCondicionesMouseClicked

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        SeleccionarItemTablaU(evt);
    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void btnNuevoUsuario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoUsuario1MouseClicked
        is.setAccionBoton("Guardar");
        NuevoUsuario frnu=new NuevoUsuario();
        frnu.show();
    }//GEN-LAST:event_btnNuevoUsuario1MouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
        if(!id.isEmpty()){
            is.setAccionBoton("Actualizar ");
            is.setIdUsuario(id);
            is.setRol(rol);
            is.setEstado(estado);
            NuevoUsuario frnu=new NuevoUsuario();
            frnu.show();
        }else JOptionPane.showMessageDialog(this, "No ha seleccionado un registro a modificar");
    }//GEN-LAST:event_btnActualizarMouseClicked

       
    
    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnBuscarUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarUsuariosMouseClicked
        // TODO add your handling code here:
        jcbBuscarPor.setEnabled(true);
        txtBuscarPor.setEnabled(true);
    }//GEN-LAST:event_btnBuscarUsuariosMouseClicked

    private void jcbBuscarPorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBuscarPorItemStateChanged
        // TODO add your handling code here:
            buscar = jcbBuscarPor.getSelectedIndex();
            chbActivo.setEnabled(true);
            chbInactivo.setEnabled(true);
            txtBuscarPor.setText("");
            txtBuscarPor.requestFocus();
            LlenarTablaUsuarios();
            
    }//GEN-LAST:event_jcbBuscarPorItemStateChanged

    private void txtBuscarPorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorKeyPressed
        // TODO add your handling code here:
        switch (buscar) {
            case 1:
                BuscarPorCedula();
            break;
            case 2:
                BuscarPorNombreUsuario();
            break;
            case 3:
                BuscarPorApellidoUsuario();
            break;
            case 4:
                BuscarPorTipoUsuario();
            break;
            case 5:
                BuscarPorEstadoUsuario();
            break;
            default:
                JOptionPane.showMessageDialog(this,"Debe seleccionar un tipo de usuario");
            break;
        }
    }//GEN-LAST:event_txtBuscarPorKeyPressed

    private void jcbBuscarPorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbBuscarPorMouseClicked
        // TODO add your handling code here:
        txtBuscarPor.setVisible(true);
    }//GEN-LAST:event_jcbBuscarPorMouseClicked

    private void txtBuscarPorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorKeyTyped
        // TODO add your handling code here:
        if(buscar==1){
             char car=evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
        int limite  = 10;
        if (txtBuscarPor.getText().length()== limite)              evt.consume();        
   
        }
    }//GEN-LAST:event_txtBuscarPorKeyTyped

    private void chbActivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbActivoItemStateChanged
        // TODO add your handling code here:
        chbInactivo.setSelected(false);
    }//GEN-LAST:event_chbActivoItemStateChanged

    private void chbInactivoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chbInactivoItemStateChanged
        // TODO add your handling code here:
        chbActivo.setSelected(false);
    }//GEN-LAST:event_chbInactivoItemStateChanged

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
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel btnBuscarUsuarios;
    private javax.swing.JButton btnContenidos;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnNuevoUsuario1;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JCheckBox chbActivo;
    private javax.swing.JCheckBox chbInactivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAcercade;
    private javax.swing.JButton jbContactanos;
    private javax.swing.JComboBox<String> jcbBuscarPor;
    private javax.swing.JLabel jlJJ2016;
    private javax.swing.JLabel jlMuseo;
    private javax.swing.JLabel jlPoliticasdePrivacidad;
    private javax.swing.JLabel jlTerminosyCondiciones;
    private javax.swing.JLabel jlUsuarios;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JLabel lblNuevo;
    private javax.swing.JTextField txtBuscarPor;
    // End of variables declaration//GEN-END:variables
}
