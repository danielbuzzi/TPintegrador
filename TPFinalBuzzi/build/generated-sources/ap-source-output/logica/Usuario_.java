package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-12-20T21:28:47")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Long> codigo_usuario;
    public static volatile SingularAttribute<Usuario, Boolean> habilitado;
    public static volatile SingularAttribute<Usuario, String> nombre_usuario;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}