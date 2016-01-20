/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author toshiba
 */
public class ItemSeleccionado {
    public static String idUsuario;
    public static String rol;
    public static Boolean estado;
    public static String accionBoton;
    public static String idCategoria;

    
    public String getIdUsuario(){
        return idUsuario;
    }
    
     public void setIdUsuario(String idUsuario){
        this.idUsuario=idUsuario;
    }
     
    public String getAccionBoton(){
        return accionBoton;
    }
    
     public void setAccionBoton(String accionBoton){
        this.accionBoton=accionBoton;
    }
     
    public String getRol(){
        return rol;
    }
    
     public void setRol(String rol){
        this.rol=rol;
    }
     
    public Boolean getEstado(){
        return estado;
    }
    
     public void setEstado(String estado){
        if(estado.contains("Activo")) this.estado = true;
        else this.estado = false;
    }
     
     public String getIdCategoria(){
        return idCategoria;
    }
    
     public void setIdCategoria(String idCategoria){
        this.idCategoria=idCategoria;
    }
}
