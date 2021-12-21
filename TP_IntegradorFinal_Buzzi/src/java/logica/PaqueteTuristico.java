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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author daniel
 */
@Entity
public class PaqueteTuristico implements Serializable{

    public PaqueteTuristico() {
    }

    public PaqueteTuristico(long codigo_paquete, double costo_paquete, boolean habilitado, List<ServicioTuristico> listaServicio, List<Venta> listaVentas) {
        this.codigo_paquete = codigo_paquete;
        this.costo_paquete = costo_paquete;
        this.habilitado = habilitado;
        this.listaServicio = listaServicio;
        this.listaVentas = listaVentas;
    }





    public long getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(long codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

    public double getCosto_paquete() {
        return costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public List<ServicioTuristico> getListaServicio() {
        return listaServicio;
    }

    public void setListaServicio(List<ServicioTuristico> listaServicio) {
        this.listaServicio = listaServicio;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long codigo_paquete;
    @Basic
    double costo_paquete;
    boolean habilitado;
    @ManyToMany
    List<ServicioTuristico> listaServicio;
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
