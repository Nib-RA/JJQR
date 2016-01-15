/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pryqr;

import Modelos.ValoresConstantes;
import db.ConexionBase;
import db.mysql;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.Image;
import java.io.File;
import javax.swing.JLabel;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Familia
 */
public class NuevoQr extends javax.swing.JFrame {
    Connection conn;
    Statement sent;
    File fichero;
    String[] imagen = {"", "", ""}, tempImagen = {"", "", ""}, tempNombreArchivo = {"", "", ""};
    
    public NuevoQr() {
        initComponents();
        this.setLocationRelativeTo(null);
        conn = mysql.getConnect();
        String SQLC="SELECT IDCATEGORIA,NOMBRECATEGORIA,DESCRIPCIONCATEGORIA FROM categorias";
        //DefaultComboBoxModel mdl1= new DefaultComboBoxModel(ConexionBase.leerDatosVector1(SQLC));
        DefaultComboBoxModel mdlC= new DefaultComboBoxModel(ConexionBase.leerDatosVector1(SQLC));
        this.jcbCategoriasQR.setModel(mdlC);
        //Redimencionar una imagen a un label
        String Ruta=getClass().getResource("/images/plus.png").getPath();
        Mostrar_Visualizador(btnImagen1, Ruta);
        Mostrar_Visualizador(btnImagen2, Ruta);
        Mostrar_Visualizador(btnImagen3, Ruta);
    }
    
    Boolean CopiaArchivos(String home, String destiny, String nombre, Integer indice){
        File origen = new File(home);
        File destino = new File(destiny);
        try {
            //Localisa la carpeta de origen y ubica la carpeta d destino
            File rutaPrincipalImagenes = new File(imagen[indice]);
            if(!rutaPrincipalImagenes.exists()) rutaPrincipalImagenes.mkdir();
            FileUtils.moveFileToDirectory(origen, destino, false);
            File nombreOriginal = new File(destiny + "\\" + tempNombreArchivo[indice]);
            File nombreModificado = new File(destiny + "\\" + nombre);
            Boolean cambioNombre = nombreOriginal.renameTo(nombreModificado);
            if(!cambioNombre){
                JOptionPane.showMessageDialog(this, "El renombrado no se pudo realizar");
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    
    void GuardarQr(){
        if (txtNombreQr.getText().trim().isEmpty() || txtAreaDescripcionNuevoQr.getText().trim().isEmpty())
            JOptionPane.showMessageDialog(null, "Ingrese Los Campos Obligatorios");
        else{  
            try {
                //Ingreso en nuevo usuario
                if(!tempImagen[0].isEmpty()){
                    File imagen1 = new File(imagen[0]);
                    if(!imagen1.exists()) imagen1.mkdir();
                    imagen[0] += "\\Imagenes";
                    if(CopiaArchivos(tempImagen[0], imagen[0], "Imagen1.jpg", 0)) imagen[0] += "\\Imagen1.jpg";
                    else return;
                    if(!tempImagen[1].isEmpty()){
                        if(CopiaArchivos(tempImagen[1], imagen[1], "Imagen2.jpg", 1)) imagen[1] += "\\Imagen2.jpg";
                        else return;
                    } else imagen[1] = "";
                    if(!tempImagen[2].isEmpty()){
                        if(CopiaArchivos(tempImagen[2], imagen[2], "Imagen3.jpg", 2)) imagen[2] += "\\Imagen3.jpg";
                        else return;
                    } else imagen[2] = "";
                    String SQLA = "INSERT INTO articulos(NOMBREARTICULO,DESCRIPCIONARTICULO,IMAGENUNOARTICULO,IMAGENDOSARTICULO,"
                            + "IMAGENTRESARTICULO,SONIDOARTICULO,VIDEOARTICULO,CODIGOQRARTICULO,IMAGENQRARTICULO)"
                                  + " VALUES(?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = conn.prepareStatement(SQLA);
                    ps.setString(1, txtNombreQr.getText().toString());
                    ps.setString(2, txtAreaDescripcionNuevoQr.getText().toString());
                    ps.setString(3, imagen[0]);
                    ps.setString(4, imagen[1]);
                    ps.setString(5, imagen[2]);
                    ps.setString(6, "sonido");
                    ps.setString(7, "video");
                    ps.setString(8, "Codigo");
                    ps.setString(9, "ImagenQr");
                    int n = ps.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Nuevo Qr creado Correctamente");
                        dispose();
                        ContenidosArticulos frca=new ContenidosArticulos();
                        frca.show();
                    }
                } else JOptionPane.showMessageDialog(this, "Debe por lo menos agregar una imagen al reconocimiento QR");
            }catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error: " + e.getMessage());
            //System.out.println();
            }
        }
    }

    public static void Mostrar_Visualizador(javax.swing.JLabel Pantalla,String Ruta_Destino) 
    {
        try
        {
        java.awt.Image Capturar_Img_Solo_Lectura = javax.imageio.ImageIO.read(new java.io.File(Ruta_Destino));
        java.awt.Image Obtener_Imagen = Capturar_Img_Solo_Lectura.getScaledInstance(Pantalla.getWidth(),Pantalla.getHeight(), java.awt.Image.SCALE_SMOOTH);
        javax.swing.Icon iconoEscalado = new javax.swing.ImageIcon(Obtener_Imagen);
        Pantalla.setIcon(iconoEscalado);
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    void CargarImagen(JLabel label, Integer identificador){
        int resultado;
        // ventana = new CargarFoto();
        JFileChooser jfchCargarfoto= new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "jpg");
        jfchCargarfoto.setFileFilter(filtro);
        resultado= jfchCargarfoto.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = jfchCargarfoto.getSelectedFile();
            try{
                tempImagen[identificador] = fichero.getPath();
                tempNombreArchivo[identificador] = fichero.getName();
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().
                getScaledInstance(label.getWidth(), label.getHeight(), 
                Image.SCALE_DEFAULT));
                label.setText(null);
                label.setIcon( icono );
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
            }
        } 
    }
    
    void CargarVideo(JLabel label){
        int resultado;
        // ventana = new CargarFoto();
        JFileChooser jfchCargarVideo= new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("MP4", "mp4");
        jfchCargarVideo.setFileFilter(filtro);
        resultado= jfchCargarVideo.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = jfchCargarVideo.getSelectedFile();
            try{

            }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, 
                    "Error abriendo la imagen "+ ex);
            }
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlCategoriaQr = new javax.swing.JLabel();
        jlGenerarQr = new javax.swing.JLabel();
        jcbCategoriasQR = new javax.swing.JComboBox();
        jlNombreQr = new javax.swing.JLabel();
        txtNombreQr = new javax.swing.JTextField();
        jlImagen1 = new javax.swing.JLabel();
        jlImagen2 = new javax.swing.JLabel();
        jlImagen3 = new javax.swing.JLabel();
        jlVideoQr = new javax.swing.JLabel();
        btnVideoQr = new javax.swing.JLabel();
        jlAudioQr = new javax.swing.JLabel();
        btnAudioQr = new javax.swing.JLabel();
        jlNombreQr6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescripcionNuevoQr = new javax.swing.JTextArea();
        btnCancelarNuevoQr = new javax.swing.JButton();
        btnGenerarNuevoQr = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnImagen1 = new javax.swing.JLabel();
        btnImagen3 = new javax.swing.JLabel();
        btnImagen2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(2, 32, 62));

        jlCategoriaQr.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlCategoriaQr.setForeground(new java.awt.Color(0, 153, 204));
        jlCategoriaQr.setText("Categoria");

        jlGenerarQr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlGenerarQr.setForeground(new java.awt.Color(0, 153, 204));
        jlGenerarQr.setText("Generacion de Qr");

        jlNombreQr.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlNombreQr.setForeground(new java.awt.Color(0, 153, 204));
        jlNombreQr.setText("Nombre del Articulo");

        jlImagen1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlImagen1.setForeground(new java.awt.Color(0, 153, 204));
        jlImagen1.setText("Imagen 1");

        jlImagen2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlImagen2.setForeground(new java.awt.Color(0, 153, 204));
        jlImagen2.setText("Imagen 2");

        jlImagen3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlImagen3.setForeground(new java.awt.Color(0, 153, 204));
        jlImagen3.setText("Imagen 3");

        jlVideoQr.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlVideoQr.setForeground(new java.awt.Color(0, 153, 204));
        jlVideoQr.setText("Video");

        btnVideoQr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/video.png"))); // NOI18N
        btnVideoQr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVideoQr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVideoQrMouseClicked(evt);
            }
        });

        jlAudioQr.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlAudioQr.setForeground(new java.awt.Color(0, 153, 204));
        jlAudioQr.setText("Audio");

        btnAudioQr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/audio.png"))); // NOI18N
        btnAudioQr.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAudioQr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAudioQrMouseClicked(evt);
            }
        });

        jlNombreQr6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlNombreQr6.setForeground(new java.awt.Color(0, 153, 204));
        jlNombreQr6.setText("Descripcion");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        txtAreaDescripcionNuevoQr.setColumns(10);
        txtAreaDescripcionNuevoQr.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescripcionNuevoQr);

        btnCancelarNuevoQr.setBackground(new java.awt.Color(153, 255, 255));
        btnCancelarNuevoQr.setText("Cancelar");
        btnCancelarNuevoQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarNuevoQrActionPerformed(evt);
            }
        });

        btnGenerarNuevoQr.setBackground(new java.awt.Color(153, 255, 255));
        btnGenerarNuevoQr.setText("Generar");
        btnGenerarNuevoQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarNuevoQrActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnImagen1.setForeground(new java.awt.Color(255, 255, 51));
        btnImagen1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImagen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagen1MouseClicked(evt);
            }
        });

        btnImagen3.setForeground(new java.awt.Color(255, 255, 51));
        btnImagen3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImagen3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagen3MouseClicked(evt);
            }
        });

        btnImagen2.setForeground(new java.awt.Color(255, 255, 51));
        btnImagen2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImagen2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnImagen2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 414, Short.MAX_VALUE)
                .addComponent(jlGenerarQr)
                .addGap(255, 255, 255)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarNuevoQr, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlImagen1)
                                .addGap(89, 89, 89)
                                .addComponent(jlImagen2)
                                .addGap(61, 61, 61)
                                .addComponent(jlImagen3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlNombreQr, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlCategoriaQr)
                                    .addComponent(btnImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbCategoriasQR, 0, 207, Short.MAX_VALUE)
                                    .addComponent(txtNombreQr)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlNombreQr6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlVideoQr)
                                    .addComponent(btnVideoQr))
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAudioQr)
                                    .addComponent(jlAudioQr))))
                        .addGap(81, 81, 81)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(224, 224, 224)
                    .addComponent(btnGenerarNuevoQr, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(518, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlGenerarQr)))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlCategoriaQr)
                            .addComponent(jcbCategoriasQR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlNombreQr)
                            .addComponent(txtNombreQr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlImagen1)
                            .addComponent(jlImagen2)
                            .addComponent(jlImagen3))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVideoQr, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAudioQr, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jlNombreQr6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlAudioQr)
                                    .addComponent(jlVideoQr))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnCancelarNuevoQr)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(458, Short.MAX_VALUE)
                    .addComponent(btnGenerarNuevoQr)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarNuevoQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarNuevoQrActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarNuevoQrActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnGenerarNuevoQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarNuevoQrActionPerformed
        GuardarQr();
    }//GEN-LAST:event_btnGenerarNuevoQrActionPerformed

    private void btnImagen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagen1MouseClicked
        CargarImagen(btnImagen1, 0);
        imagen[0] = ValoresConstantes.directorioPrincipal + "\\" + txtNombreQr.getText().toString();
    }//GEN-LAST:event_btnImagen1MouseClicked

    private void btnImagen2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagen2MouseClicked
        CargarImagen(btnImagen2, 1);
        imagen[1] = ValoresConstantes.directorioPrincipal + "\\" + txtNombreQr.getText().toString() + "\\Imagenes";
    }//GEN-LAST:event_btnImagen2MouseClicked

    private void btnImagen3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnImagen3MouseClicked
        CargarImagen(btnImagen3, 2);
        imagen[2] = ValoresConstantes.directorioPrincipal + "\\" + txtNombreQr.getText().toString() + "\\Imagenes";
    }//GEN-LAST:event_btnImagen3MouseClicked

    private void btnVideoQrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVideoQrMouseClicked
        // TODO add your handling code here:
        CargarVideo(btnVideoQr);
       
    }//GEN-LAST:event_btnVideoQrMouseClicked

    private void btnAudioQrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAudioQrMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAudioQrMouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(NuevoQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NuevoQr().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAudioQr;
    private javax.swing.JButton btnCancelarNuevoQr;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnGenerarNuevoQr;
    private javax.swing.JLabel btnImagen1;
    private javax.swing.JLabel btnImagen2;
    private javax.swing.JLabel btnImagen3;
    private javax.swing.JLabel btnVideoQr;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbCategoriasQR;
    private javax.swing.JLabel jlAudioQr;
    private javax.swing.JLabel jlCategoriaQr;
    private javax.swing.JLabel jlGenerarQr;
    private javax.swing.JLabel jlImagen1;
    private javax.swing.JLabel jlImagen2;
    private javax.swing.JLabel jlImagen3;
    private javax.swing.JLabel jlNombreQr;
    private javax.swing.JLabel jlNombreQr6;
    private javax.swing.JLabel jlVideoQr;
    private javax.swing.JTextArea txtAreaDescripcionNuevoQr;
    private javax.swing.JTextField txtNombreQr;
    // End of variables declaration//GEN-END:variables
}
