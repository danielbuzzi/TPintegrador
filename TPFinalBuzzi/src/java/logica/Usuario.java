/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author daniel
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long codigo_usuario;
    @Basic
    String nombre_usuario;
    String contraseña;
    boolean habilitado;
    
    public Usuario()
    {
    }

    public Usuario(long codigo_usuario, String nombre_usuario, String contraseña, boolean habilitado) {
        this.codigo_usuario = codigo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.habilitado = habilitado;
    }


    public long getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(long codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }
   

    
}
