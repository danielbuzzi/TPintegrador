/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;
import logica.Usuario;
import logica.Venta;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author daniel
 */
public class ControladoraPersistencia {

    ClienteJpaController clienteJPA = new ClienteJpaController();
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();
    VentaJpaController ventaJPA = new VentaJpaController();
    ServicioTuristicoJpaController servicioJPA = new ServicioTuristicoJpaController();
    PaqueteTuristicoJpaController paqueteJPA = new PaqueteTuristicoJpaController();

    //Controladora para el cliente
    
    public void crearCliente(Cliente cli) {
        clienteJPA.create(cli);

    }

    public List<Cliente> traerClientes() {

        return clienteJPA.findClienteEntities();
    }

    public void borrarCliente(long id) {
        try {
            clienteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Cliente buscarCliente(long id) {
        return clienteJPA.findCliente(id);
    }

    public void modificarCliente(Cliente cli) {
        try {
            clienteJPA.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //Controladora para el empleado
    
    public void crearEmpleado(Empleado emp, Usuario usu) {
        usuarioJPA.create(usu);
        empleadoJPA.create(emp);

    }

    public List<Empleado> traerEmpleados() {

        return empleadoJPA.findEmpleadoEntities();
    }

    public void borrarEmpleado(long id) {
        try {
            empleadoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(long id) {
        return empleadoJPA.findEmpleado(id);
    }

    public void modificarEmpleado(Empleado emp, Usuario usu) {
        try {
            empleadoJPA.edit(emp);
            usuarioJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //Controladora para el ussuario
    
    public Usuario buscarUsuario(long id) {
        return usuarioJPA.findUsuario(id);
    }

    public List<Usuario> traerUsuarios() {

        return usuarioJPA.findUsuarioEntities();
    }

    public void modificarUsuario(Usuario usu) {
        try {
            usuarioJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    //Controladora para la venta
    
    public void crearVenta(Venta cli) {
        ventaJPA.create(cli);

    }

    public List<Venta> traerVentas() {

        return ventaJPA.findVentaEntities();
    }

    public void borrarVenta(long id) {
        try {
            ventaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Venta buscarVenta(long id) {
        return ventaJPA.findVenta(id);
    }

    public void modificarVenta(Venta cli) {
        try {
            ventaJPA.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Controladora para el servicio turístico
    
    public void crearServicio(ServicioTuristico serv) {
        servicioJPA.create(serv);

    }

    public List<ServicioTuristico> traerServicios() {

        return servicioJPA.findServicioTuristicoEntities();
    }

    public void borrarServicio(long id) {
        try {
            servicioJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ServicioTuristico buscarServicio(long id) {
        return servicioJPA.findServicioTuristico(id);
    }

    public void modificarServicio(ServicioTuristico serv) {
        try {
            servicioJPA.edit(serv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Controladora para el paquete turístico
    
    
     public void crearPaquete(PaqueteTuristico serv) {
        paqueteJPA.create(serv);

    }
    
 


    public List<PaqueteTuristico> traerPaquetes() {

        return paqueteJPA.findPaqueteTuristicoEntities();
    }

    public void borrarPaquete(long id) {
        try {
            paqueteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PaqueteTuristico buscarPaquete(long id) {
        return paqueteJPA.findPaqueteTuristico(id);
    }

    public void modificarPaquete(PaqueteTuristico serv) {
        try {
            paqueteJPA.edit(serv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
