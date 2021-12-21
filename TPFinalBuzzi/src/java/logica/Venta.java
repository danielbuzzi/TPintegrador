/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author daniel
 */
@Entity
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    long num_venta;
    @Basic

    String medio_pago;
    @ManyToOne
    Cliente unCliente;
    @ManyToOne
    Empleado unEmpleado;
    @ManyToOne
    ServicioTuristico unServicio;
    @ManyToOne
    PaqueteTuristico unPaquete;
    
    @Temporal(TemporalType.DATE)
    Date fecha_venta;
    boolean habilitado;

    public Venta() {
    }



    public long getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(long num_venta) {
        this.num_venta = num_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public Empleado getUnEmpleado() {
        return unEmpleado;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }

    public ServicioTuristico getUnServicio() {
        return unServicio;
    }

    public void setUnServicio(ServicioTuristico unServicio) {
        this.unServicio = unServicio;
    }

    public PaqueteTuristico getUnPaquete() {
        return unPaquete;
    }

    public void setUnPaquete(PaqueteTuristico unPaquete) {
        this.unPaquete = unPaquete;
    }

    public Venta(long num_venta, String medio_pago, Cliente unCliente, Empleado unEmpleado, ServicioTuristico unServicio, PaqueteTuristico unPaquete, Date fecha_venta, boolean habilitado) {
        this.num_venta = num_venta;
        this.medio_pago = medio_pago;
        this.unCliente = unCliente;
        this.unEmpleado = unEmpleado;
        this.unServicio = unServicio;
        this.unPaquete = unPaquete;
        this.fecha_venta = fecha_venta;
        this.habilitado = habilitado;
    }

    


    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

   

}
