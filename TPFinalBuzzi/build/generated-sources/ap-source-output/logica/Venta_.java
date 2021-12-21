package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cliente;
import logica.Empleado;
import logica.PaqueteTuristico;
import logica.ServicioTuristico;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-20T21:28:47")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Long> num_venta;
    public static volatile SingularAttribute<Venta, Empleado> unEmpleado;
    public static volatile SingularAttribute<Venta, String> medio_pago;
    public static volatile SingularAttribute<Venta, PaqueteTuristico> unPaquete;
    public static volatile SingularAttribute<Venta, ServicioTuristico> unServicio;
    public static volatile SingularAttribute<Venta, Date> fecha_venta;
    public static volatile SingularAttribute<Venta, Boolean> habilitado;
    public static volatile SingularAttribute<Venta, Cliente> unCliente;

}