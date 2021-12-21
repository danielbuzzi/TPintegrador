/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long codigo_empleado;
    @Basic
    String nombre;
    String apellido;
    String direccion;
    String dni;
    String nacionalidad;
    String celular;
    String email;
    String cargo;
    double sueldo;
    @Temporal(TemporalType.DATE)
    Date fecha_nac;
    boolean habilitado;
    @OneToOne
    Usuario unUsuario;
    @OneToMany
    List<Venta> listaVentas;

    public long getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(long codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    
    public Empleado() {
    }

    public Empleado(long codigo_empleado, String nombre, String apellido, String direccion, String dni, String nacionalidad, String celular, String email, String cargo, double sueldo, Date fecha_nac, boolean habilitado, Usuario unUsuario, List<Venta> listaVentas) {
        this.codigo_empleado = codigo_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.nacionalidad = nacionalidad;
        this.celular = celular;
        this.email = email;
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.fecha_nac = fecha_nac;
        this.habilitado = habilitado;
        this.unUsuario = unUsuario;
        this.listaVentas = listaVentas;
    }


}
