package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.ServicioTuristico;
import logica.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-20T21:28:47")
@StaticMetamodel(PaqueteTuristico.class)
public class PaqueteTuristico_ { 

    public static volatile SingularAttribute<PaqueteTuristico, Double> costo_paquete;
    public static volatile SingularAttribute<PaqueteTuristico, Long> codigo_paquete;
    public static volatile SingularAttribute<PaqueteTuristico, Boolean> habilitado;
    public static volatile ListAttribute<PaqueteTuristico, Venta> listaVentas;
    public static volatile ListAttribute<PaqueteTuristico, ServicioTuristico> listaServicio;

}