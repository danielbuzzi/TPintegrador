/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author daniel
 */
public class ControladoraLogica {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //Controladora para el cliente
    public void crearCliente(String nombre, String apellido, String direccion,
            String dni, Date fechanac, String nacionalidad, String celular, String email) {

        //asigno valores al empleado
        Cliente cli = new Cliente();
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setDireccion(direccion);
        cli.setDni(dni);
        cli.setFecha_nac(fechanac);
        cli.setNacionalidad(nacionalidad);
        cli.setCelular(celular);
        cli.setEmail(email);
        cli.setHabilitado(true);

        controlPersis.crearCliente(cli);

    }

    public List<Cliente> traerBusquedaClientes(String consultas) {
        List<Cliente> listaClientes = controlPersis.traerClientes();
        List<Cliente> listaBusqueda = new ArrayList<>();

        if (listaClientes != null) {
            if (!consultas.isEmpty()) {
                for (Cliente cli : listaClientes) {
                    if (cli.apellido.startsWith(consultas) || cli.dni.startsWith(consultas)) {

                        listaBusqueda.add(cli);
                    }
                }
                return listaBusqueda;
            }

        }
        return listaClientes;
    }

    public List<Cliente> traerClientes() {

        return controlPersis.traerClientes();

    }

    public void borrarCliente(long id) {
        Cliente cli=buscarCliente(id);
        cli.setHabilitado(false);
        controlPersis.modificarCliente(cli);

    }

    public Cliente buscarCliente(long id) {
        return controlPersis.buscarCliente(id);
    }

    public void modificarCliente(Cliente cli) {
        controlPersis.modificarCliente(cli);

    }

    //Controladora para el empleado
    public void crearEmppleado(String nombre, String apellido, String direccion,
            String dni, Date fechanac, String nacionalidad, String celular, String email, String cargo, double sueldo,
            String nombreUsuario, String contrasenia) {

        Usuario usuario = new Usuario();

        //asigno valores al usuario
        usuario.setNombre_usuario(nombreUsuario);
        usuario.setContraseña(contrasenia);
        usuario.setHabilitado(true);

        //asigno valores al empleado
        Empleado emp = new Empleado();
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setDireccion(direccion);
        emp.setDni(dni);
        emp.setFecha_nac(fechanac);
        emp.setNacionalidad(nacionalidad);
        emp.setCelular(celular);
        emp.setEmail(email);
        emp.setCargo(cargo);
        emp.setSueldo(sueldo);
        emp.setHabilitado(true);
        emp.setUnUsuario(usuario);

        controlPersis.crearEmpleado(emp, usuario);

    }

    public List<Empleado> traerBusquedaEmpleados(String consultas) {
        List<Empleado> listaEmpleados = controlPersis.traerEmpleados();
        List<Empleado> listaBusquedaEmp = new ArrayList<>();

        if (listaEmpleados != null) {
            if (consultas.equals("")) {
                return listaEmpleados;
            } else {
                for (Empleado emp : listaEmpleados) {
                    if (emp.apellido.startsWith(consultas) || emp.dni.startsWith(consultas)
                            || emp.cargo.startsWith(consultas)) {

                        listaBusquedaEmp.add(emp);
                    }
                }

            }

        }
        return listaBusquedaEmp;
    }

    public List<Empleado> traerEmpleados() {

        return controlPersis.traerEmpleados();

    }

    public void borrarEmpleado(long id) {
        Empleado emp=buscarEmpleado(id);
        emp.setHabilitado(false);
        Usuario usu=buscarUsuario(emp.unUsuario.getCodigo_usuario());
        usu.setHabilitado(false);
        controlPersis.modificarEmpleado(emp, usu);

    }

    public Empleado buscarEmpleado(long id) {
        return controlPersis.buscarEmpleado(id);
    }

    public void modificarEmpleado(Empleado emp, Usuario usu) {

        controlPersis.modificarEmpleado(emp, usu);

    }

    public String buscarNombreEmpleado(String usuario) {
        List<Empleado> listaEmpleados = controlPersis.traerEmpleados();
        String nombre = "No especificado";
        for (Empleado emp : listaEmpleados) {
            if (emp.getUnUsuario().nombre_usuario.equals(usuario)) {
                nombre = emp.getApellido() + ", " + emp.getNombre();
            }
        }
        return nombre;
    }

    public Long buscarIdEmpleado(String usuario) {
        List<Empleado> listaEmpleados = controlPersis.traerEmpleados();
        Long id = 1L;
        for (Empleado emp : listaEmpleados) {
            if (emp.getUnUsuario().nombre_usuario.equals(usuario)) {
                id = emp.getCodigo_empleado();
            }
        }
        return id;

    }

    //Controladora para el usuario
    public boolean verificarUsuario(String usuario, String contrasenia) {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        if (listaUsuarios != null) {
            for (Usuario usu : listaUsuarios) {
                if ((usu.getNombre_usuario().equals(usuario)) && (usu.getContraseña().equals(contrasenia))
                        && (usu.isHabilitado())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Usuario buscarUsuario(Long id) {
        return controlPersis.buscarUsuario(id);
    }

    public void modificarUsuario(Usuario usu) {
        controlPersis.modificarUsuario(usu);

    }

    public List<Usuario> traerUsuarios() {

        return controlPersis.traerUsuarios();

    }

    //Controladora para la venta
    public void crearVenta(String mediopago, Date fecha_venta, String idpaquete, String idservicio, long idempleado, long idcli) {

        //asigno valores al empleado
        Venta cli = new Venta();
        cli.setMedio_pago(mediopago);
        cli.setHabilitado(true);
        cli.setFecha_venta(fecha_venta);
        cli.setUnCliente(controlPersis.buscarCliente(idcli));

        cli.setUnEmpleado(controlPersis.buscarEmpleado(idempleado));
        try {
            cli.setUnServicio(controlPersis.buscarServicio(Long.parseLong(idservicio)));
        } catch (Exception e) {

        }

        try {
            cli.setUnPaquete(controlPersis.buscarPaquete(Long.parseLong(idpaquete)));
        } catch (Exception e) {

        }

        controlPersis.crearVenta(cli);

    }

    public List<Venta> traerBusquedaVEntas(String consultas) {
        List<Venta> listaVentas = controlPersis.traerVentas();
        List<Venta> listaBusqueda = new ArrayList<>();
        if (listaVentas != null) {
            if (consultas.equals("")) {
                return listaVentas;
            } else {
                for (Venta cli : listaVentas) {
    

                    listaBusqueda.add(cli);
                }
            }

        }

        return listaBusqueda;
    }

    public List<Venta> traerVentas() {

        return controlPersis.traerVentas();

    }

    public void borrarVenta(long id) {
        Venta ven = buscarVenta(id);
        ven.setHabilitado(false);
        controlPersis.modificarVenta(ven);

    }

    public Venta buscarVenta(long id) {
        return controlPersis.buscarVenta(id);
    }

    public void modificarVenta(Long id, String idservicio, String mediopago, String idpaquete, Date fechaventa, Long idcliente, Long idempleado) {
        Venta vent = buscarVenta(id);
        vent.setFecha_venta(fechaventa);
        vent.setMedio_pago(mediopago);
        vent.setHabilitado(true);
        vent.setUnCliente(controlPersis.buscarCliente(idcliente));
        vent.setUnEmpleado(controlPersis.buscarEmpleado(idempleado));

        try {
            vent.setUnServicio(controlPersis.buscarServicio(Long.parseLong(idservicio)));
        } catch (Exception e) {
               
        }

        try {
            vent.setUnPaquete(controlPersis.buscarPaquete(Long.parseLong(idpaquete)));
        } catch (Exception e) {

        }

        controlPersis.modificarVenta(vent);

    }

    //Controladora para servicio
    public void crearServicio(String nombre, String descripcion_breve, String destino_servicio,
            double costo_servicio, Date fecha_servicio) {

        ServicioTuristico serv = new ServicioTuristico();
        serv.setNombre(nombre);
        serv.setDescripcion_breve(descripcion_breve);
        serv.setDestino_servicio(destino_servicio);
        serv.setCosto_servicio(costo_servicio);
        serv.setFecha_servicio(fecha_servicio);
        serv.setHabilitado(true);

        controlPersis.crearServicio(serv);

    }

    public List<ServicioTuristico> traerServicios() {

        return controlPersis.traerServicios();

    }

    public void borrarServicio(long id) {
        
        ServicioTuristico ser = buscarServicio(id);
        ser.setHabilitado(false);
        controlPersis.modificarServicio(ser);

    }

    public ServicioTuristico buscarServicio(long id) {
        return controlPersis.buscarServicio(id);
    }

    public void modificarServicio(ServicioTuristico serv) {
        try {
            controlPersis.modificarServicio(serv);
        } catch (Exception e) {

        }

    }

    //Controladora para paquete
    public void crearPaquete(Double total, String[] costo, String[] ids, String[] destino, String[] descripcionbreve, String[] nombre,
            String[] fecha) {

        PaqueteTuristico serv = new PaqueteTuristico();
        List<ServicioTuristico> listaServicios = new ArrayList<>();

        //Asigno el costo al paquete calculando el 10 por
        //ciento de descuento
        serv.setCosto_paquete(total * 0.90);

        for (int i = 0; i < ids.length; i++) {
         
            ServicioTuristico s = new ServicioTuristico();
            s.setCodigo_servicio(Long.parseLong(ids[i]));
            s.setCosto_servicio((Double.parseDouble(costo[i])));
            s.setDescripcion_breve(descripcionbreve[i]);
            s.setDestino_servicio(destino[i]);
            s.setNombre(nombre[i]);
            s.setHabilitado(true);
            listaServicios.add(s);
        }
        serv.setListaServicio(listaServicios);
        serv.setHabilitado(true);
        controlPersis.crearPaquete(serv);

    }

    public List<PaqueteTuristico> traerPaquetes() {

        return controlPersis.traerPaquetes();

    }

    public void borrarPaquete(long id) {
        PaqueteTuristico paq = buscarPaquete(id);
        paq.setHabilitado(false);
        controlPersis.modificarPaquete(paq);

    }

    public PaqueteTuristico buscarPaquete(long id) {
        return controlPersis.buscarPaquete(id);
    }

    public void modificarPaquete(Long id, Double total, String[] costo, String[] ids, String[] nombre,
            String[] destino, String[] fecha, String[] descripcionbreve) {
        PaqueteTuristico paquete = buscarPaquete(id);
        List<ServicioTuristico> listaServicios = new ArrayList<>();

        //Calculamos el costo del paquete (se aplica el descueto de 10%)
        paquete.setCosto_paquete(total * 0.90);

        for (int i = 0; i < ids.length; i++) {
           
            ServicioTuristico s = new ServicioTuristico();
            s.setCodigo_servicio(Long.parseLong(ids[i]));
            s.setCosto_servicio((Double.parseDouble(costo[i])));
            s.setDescripcion_breve(descripcionbreve[i]);
            s.setDestino_servicio(destino[i]);
            s.setNombre(nombre[i]);
            s.setHabilitado(true);
            listaServicios.add(s);
        }
        paquete.setListaServicio(listaServicios);
        paquete.setHabilitado(true);

        controlPersis.modificarPaquete(paquete);

    }

}
