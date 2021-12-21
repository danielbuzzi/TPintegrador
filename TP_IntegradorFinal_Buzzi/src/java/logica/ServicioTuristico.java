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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
public class ServicioTuristico implements Serializable {
    public ServicioTuristico()
    {
    }

    public ServicioTuristico(long codigo_servicio, String nombre, String descripcion_breve, String destino_servicio, double costo_servicio, Date fecha_servicio, boolean habilitado, List<PaqueteTuristico> listaPaquete, List<Venta> listaVentas) {
        this.codigo_servicio = codigo_servicio;
        this.nombre = nombre;
        this.descripcion_breve = descripcion_breve;
        this.destino_servicio = destino_servicio;
        this.costo_servicio = costo_servicio;
        this.fecha_servicio = fecha_servicio;
        this.habilitado = habilitado;
        this.listaPaquete = listaPaquete;
        this.listaVentas = listaVentas;
    }


   

    public long getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(long codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion_breve() {
        return descripcion_breve;
    }

    public void setDescripcion_breve(String descripcion_breve) {
        this.descripcion_breve = descripcion_breve;
    }

    public String getDestino_servicio() {
        return destino_servicio;
    }

    public void setDestino_servicio(String destino_servicio) {
        this.destino_servicio = destino_servicio;
    }

    public Date getFecha_servicio() {
        return fecha_servicio;
    }

    public void setFecha_servicio(Date fecha_servicio) {
        this.fecha_servicio = fecha_servicio;
    }

    public double getCosto_servicio() {
        return costo_servicio;
    }

    public void setCosto_servicio(double costo_servicio) {
        this.costo_servicio = costo_servicio;
    }

    public List<PaqueteTuristico> getListaPaquete() {
        return listaPaquete;
    }

    public void setListaPaquete(List<PaqueteTuristico> listaPaquete) {
        this.listaPaquete = listaPaquete;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long codigo_servicio;
    @Basic
    String nombre;
    String descripcion_breve;
    String destino_servicio;
    double costo_servicio;
    @Temporal(TemporalType.DATE)
    Date fecha_servicio;
    boolean habilitado;
    
    @ManyToMany
    private List<PaqueteTuristico> listaPaquete;
    @OneToMany
    private List<Venta> listaVentas;

    
    /**
     * @return the listaVentas
     */
    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    /**
     * @param listaVentas the listaVentas to set
     */
    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

}
