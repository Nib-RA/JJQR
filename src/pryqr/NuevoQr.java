/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pryqr;

import Modelos.GeneradorQR;
import Modelos.ItemSeleccionado;
import Modelos.Validate;
import Modelos.ValoresConstantes;
import db.Categorias;
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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Date;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author Familia
 */
public class NuevoQr extends javax.swing.JFrame {
    Connection conn;
    Statement sent;
    File fichero;
    int numeroAleatorioTitulo = 0, desde = 10000, hasta = 99999, idCategoria = 0, id = 0;
    BufferedImage bufferedImage;
    DefaultComboBoxModel mdlC;
    Vector<Categorias> categorias;
    String audio = "", tempAudio = "", video = "", tempVideo = "", imagenQR = "", codigoImagenQR = "", fechaActual = "", accion = "", categoria = "";
    String[] imagen = {"", "", ""}, tempImagen = {"", "", ""}, tempNombreArchivo = {"", "", ""}, tempNombreMultimedia = {"", ""}, tempRutaActual = {"", "", "", "", "", ""};
    
    public NuevoQr() {
        initComponents();
        jcbCategoriasQR.setFocusable(true);
        Random rnd = new Random();
        Date fecha = new Date();
        numeroAleatorioTitulo = rnd.nextInt(hasta-desde+1)+desde;
        DateFormat formatoFechaHora = new SimpleDateFormat("ddMMyyyyHHmmss");
        fechaActual = formatoFechaHora.format(fecha);
        this.setLocationRelativeTo(null);
        conn = mysql.getConnect();
        String SQLC="SELECT IDCATEGORIA,NOMBRECATEGORIA,DESCRIPCIONCATEGORIA FROM categorias";
        mdlC= new DefaultComboBoxModel(ConexionBase.leerDatosVector1(SQLC));
        categorias = ConexionBase.leerDatosVector1(SQLC);
        this.jcbCategoriasQR.setModel(mdlC);
        //Redimencionar una imagen a un label
        String Ruta = getClass().getResource("/images/plus.png").getPath();
        Mostrar_Visualizador(btnImagen1, Ruta);
        Mostrar_Visualizador(btnImagen2, Ruta);
        Mostrar_Visualizador(btnImagen3, Ruta);
        Ruta=getClass().getResource("/images/wait.png").getPath();
        Mostrar_Visualizador(lblImagenQR, Ruta);
        lblIdQR.setVisible(false);
        accion=ItemSeleccionado.accionBoton;
        btnGenerarNuevoQr.setText(accion);
        try{
            //Muestra los usuarios existentes en la base de datos
            if(accion.contains("Actualizar")){
                txtNombreQr.setEnabled(false);
                jlGenerarQr.setText(accion + " datos del QR");
                lblIdQR.setText("ID del Usuario: \t\t" + ItemSeleccionado.idArticulo);
                lblIdQR.setVisible(true);
                int idCat = 0;
                for (int i = 0; i < categorias.size(); i++) {
                    String tempCategoria = categorias.get(i).getNombreCategoria();
                    if(tempCategoria.contains(ItemSeleccionado.idCategoria)) idCat = i;
                }
                jcbCategoriasQR.setSelectedIndex(idCat);
                String SQLTU ="SELECT * FROM articulos WHERE IDARTICULO = " + ItemSeleccionado.idArticulo; 
                sent = conn.createStatement();
                ResultSet rs = sent.executeQuery(SQLTU);
                rs.next();
                txtNombreQr.setText(rs.getString("NOMBREARTICULO"));
                txtAreaDescripcionNuevoQr.setText(rs.getString("DESCRIPCIONARTICULO"));
                tempRutaActual[0] = rs.getString("IMAGENUNOARTICULO");
                tempRutaActual[1] = rs.getString("IMAGENDOSARTICULO");
                tempRutaActual[2] = rs.getString("IMAGENTRESARTICULO");
                tempRutaActual[3] = rs.getString("SONIDOARTICULO");
                tempRutaActual[4] = rs.getString("VIDEOARTICULO");
                tempRutaActual[5] = rs.getString("IMAGENQRARTICULO");
                rs.close();
                Mostrar_Visualizador(btnImagen1, tempRutaActual[0]);
                if(!tempRutaActual[1].isEmpty()) Mostrar_Visualizador(btnImagen2, tempRutaActual[1]);
                if(!tempRutaActual[2].isEmpty()) Mostrar_Visualizador(btnImagen3, tempRutaActual[2]);
                if(!tempRutaActual[3].isEmpty()) jlAudioQr.setText("Audio.mp3");
                if(!tempRutaActual[4].isEmpty()) jlVideoQr.setText("Video.mp4");
                Mostrar_Visualizador(lblImagenQR, tempRutaActual[5]);
            }
        }
        catch(Exception e){
        }
    }
    
    Boolean CopiaArchivos(String home, String destiny, String[] multimedia, String nombre, Integer indice){
        File origen = new File(home);
        File destino = new File(destiny);
        try {
            //Localisa la carpeta de origen y ubica la carpeta d destino
            File rutaPrincipalImagenes = new File(multimedia[indice]);
            if(!rutaPrincipalImagenes.exists()) rutaPrincipalImagenes.mkdir();
            FileUtils.copyFileToDirectory(origen, destino, false);
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
    
    Boolean CopiaArchivos(String home, String destiny, String nombre, Integer indice){
        File origen = new File(home);
        File destino = new File(destiny);
        try {
            //Localisa la carpeta de origen y ubica la carpeta d destino
            File rutaPrincipalMultimedia = new File(destiny);
            if(!rutaPrincipalMultimedia.exists()) rutaPrincipalMultimedia.mkdir();
            FileUtils.copyFileToDirectory(origen, destino, false);
            File nombreOriginal = new File(destiny + "\\" + tempNombreMultimedia[indice]);
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
                if(idCategoria == 0){
                    JOptionPane.showMessageDialog(this, "Debe de seleccionar una categoría");
                    return;
                }
                //Ingreso en nuevo usuario
                if(!tempImagen[0].isEmpty()){
                    File imagen1 = new File(imagen[0]);
                    if(!imagen1.exists()) imagen1.mkdir();
                    imagen[0] += "\\Imagenes";
                    if(CopiaArchivos(tempImagen[0], imagen[0], imagen, "Imagen1.jpg", 0)) imagen[0] += "\\Imagen1.jpg";
                    else return;
                    if(!tempImagen[1].isEmpty()){
                        if(CopiaArchivos(tempImagen[1], imagen[1], imagen, "Imagen2.jpg", 1)) imagen[1] += "\\Imagen2.jpg";
                        else return;
                    } else imagen[1] = "";
                    if(!tempImagen[2].isEmpty()){
                        if(CopiaArchivos(tempImagen[2], imagen[2], imagen, "Imagen3.jpg", 2)) imagen[2] += "\\Imagen3.jpg";
                        else return;
                    } else imagen[2] = "";
                    if(!tempAudio.isEmpty()){
                        if(CopiaArchivos(tempAudio, audio, "Audio.mp3", 0)) audio += "\\Audio.mp3";
                        else return;
                    } else imagen[2] = "";
                    if(!tempVideo.isEmpty()){
                        if(CopiaArchivos(tempVideo, video, "Video.mp4", 1)) video += "\\Video.mp4";
                        else return;
                    } else imagen[2] = "";
                    File guardarQR = new File(imagenQR);
                    try {
                        ImageIO.write(bufferedImage, "png", guardarQR);
                    } catch (Exception e) {
                    }
                    String SQLA = "INSERT INTO articulos(IDCATEGORIA,NOMBREARTICULO,DESCRIPCIONARTICULO,IMAGENUNOARTICULO,IMAGENDOSARTICULO,"
                            + "IMAGENTRESARTICULO,SONIDOARTICULO,VIDEOARTICULO,CODIGOQRARTICULO,IMAGENQRARTICULO)"
                                  + " VALUES(?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement ps = conn.prepareStatement(SQLA);
                    ps.setInt(1, idCategoria);
                    ps.setString(2, txtNombreQr.getText().toString());
                    ps.setString(3, txtAreaDescripcionNuevoQr.getText().toString());
                    ps.setString(4, imagen[0]);
                    ps.setString(5, imagen[1]);
                    ps.setString(6, imagen[2]);
                    ps.setString(7, audio);
                    ps.setString(8, video);
                    ps.setString(9, codigoImagenQR);
                    ps.setString(10, imagenQR);
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

    public static void Mostrar_Visualizador(JLabel Pantalla, String RutaDestino){
        try
        {
            Image capturarImgSoloLectura = ImageIO.read(new File(RutaDestino));
            Image obtenerImagen = capturarImgSoloLectura.getScaledInstance(Pantalla.getWidth(),Pantalla.getHeight(), Image.SCALE_SMOOTH);
            Icon iconoEscalado = new ImageIcon(obtenerImagen);
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
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
                label.setText(null);
                label.setIcon(icono);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen" + ex);
            }
        } 
    }
    
    void CargarVideo(JLabel label, Integer identificador){
        int resultado;
        // ventana = new CargarFoto();
        JFileChooser jfchCargarVideo= new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("MP4", "mp4");
        jfchCargarVideo.setFileFilter(filtro);
        resultado= jfchCargarVideo.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = jfchCargarVideo.getSelectedFile();
            try{
                tempVideo = fichero.getPath();
                tempNombreMultimedia[identificador] = fichero.getName();
                label.setText(tempNombreMultimedia[identificador]);
                if(label.getText().length() > 10) label.setText(tempNombreMultimedia[identificador].substring(0, 10) + "...mp4");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen" + ex);
            }
        } 
    }
    
    void CargarAudio(JLabel label, Integer identificador){
        int resultado;
        // ventana = new CargarFoto();
        JFileChooser jfchCargarVideo= new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("MP3", "mp3");
        jfchCargarVideo.setFileFilter(filtro);
        resultado= jfchCargarVideo.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado){
            fichero = jfchCargarVideo.getSelectedFile();
            try{
                tempAudio = fichero.getPath();
                tempNombreMultimedia[identificador] = fichero.getName();
                label.setText(tempNombreMultimedia[identificador]);
                if(label.getText().length() > 10) label.setText(tempNombreMultimedia[identificador].substring(0, 10) + "...mp3");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen" + ex);
            }
        } 
    }
    
    public void setImagenQR(BufferedImage bufferedImage){
        if(bufferedImage != null){
            this.bufferedImage = bufferedImage;
            ImageIcon icon = new ImageIcon(bufferedImage);
            lblImagenQR.setIcon(icon);
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
        btnCerrar = new javax.swing.JButton();
        btnImagen1 = new javax.swing.JLabel();
        btnImagen3 = new javax.swing.JLabel();
        btnImagen2 = new javax.swing.JLabel();
        lblImagenQR = new javax.swing.JLabel();
        lblIdQR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(2, 32, 62));

        jlCategoriaQr.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlCategoriaQr.setForeground(new java.awt.Color(0, 153, 204));
        jlCategoriaQr.setText("Categoria");

        jlGenerarQr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlGenerarQr.setForeground(new java.awt.Color(0, 153, 204));
        jlGenerarQr.setText("Generacion de Qr");

        jcbCategoriasQR.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCategoriasQRItemStateChanged(evt);
            }
        });

        jlNombreQr.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlNombreQr.setForeground(new java.awt.Color(0, 153, 204));
        jlNombreQr.setText("Nombre del Articulo");

        txtNombreQr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreQrKeyReleased(evt);
            }
        });

        jlImagen1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jlImagen1.setForeground(new java.awt.Color(0, 153, 204));
        jlImagen1.setText("Imagen 1*");

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

        txtAreaDescripcionNuevoQr.setLineWrap(true);
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

        lblImagenQR.setBackground(new java.awt.Color(255, 255, 255));

        lblIdQR.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblIdQR.setForeground(new java.awt.Color(0, 153, 204));
        lblIdQR.setText("Categoria");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdQR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagenQR, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlGenerarQr)
                                .addGap(255, 255, 255)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(224, 224, 224)
                    .addComponent(btnGenerarNuevoQr, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(518, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jlGenerarQr)))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdQR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImagenQR, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
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
        CargarVideo(jlVideoQr, 1);
        video = ValoresConstantes.directorioPrincipal + "\\" + txtNombreQr.getText().toString() + "\\Multimedia";
    }//GEN-LAST:event_btnVideoQrMouseClicked

    private void btnAudioQrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAudioQrMouseClicked
        CargarAudio(jlAudioQr, 0);
        audio = ValoresConstantes.directorioPrincipal + "\\" + txtNombreQr.getText().toString() + "\\Multimedia";
    }//GEN-LAST:event_btnAudioQrMouseClicked

    private void txtNombreQrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreQrKeyReleased
        if(txtNombreQr.getText().length() != 0){
            GeneradorQR gQR = new GeneradorQR();
            codigoImagenQR = txtNombreQr.getText() + "-" + fechaActual + "/" + numeroAleatorioTitulo;
            imagenQR = ValoresConstantes.directorioPrincipal + "\\" + txtNombreQr.getText().toString() + "\\QR.png";
            setImagenQR(gQR.CrearQR(codigoImagenQR, 300));
        } else lblImagenQR.setIcon(null);
    }//GEN-LAST:event_txtNombreQrKeyReleased

    private void jcbCategoriasQRItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCategoriasQRItemStateChanged
        idCategoria = categorias.get(jcbCategoriasQR.getSelectedIndex()).getIdCategoria();
    }//GEN-LAST:event_jcbCategoriasQRItemStateChanged

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
    private javax.swing.JLabel lblIdQR;
    private javax.swing.JLabel lblImagenQR;
    private javax.swing.JTextArea txtAreaDescripcionNuevoQr;
    private javax.swing.JTextField txtNombreQr;
    // End of variables declaration//GEN-END:variables
}
