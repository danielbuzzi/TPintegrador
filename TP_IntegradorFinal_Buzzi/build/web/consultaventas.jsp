<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Venta"%>
<%@page import="logica.Usuario"%>
<%@page import="logica.Empleado"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Agencia Viaje S.A.</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://cdn.tiny.cloud/1/no-api-key/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>



    </head>
    <body>
        <% HttpSession misession = request.getSession();
            String usu = (String) misession.getAttribute("usuario");
            if (usu == null) {

                response.sendRedirect("index.jsp");

            } else {
        %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <header>
                        <div id="cabecera">
                            <div align="right">  

                                <% usu = (String) misession.getAttribute("usuario");
                                    if (usu != null) {%>
                                <h7>Bienvenido:</h7>

                                <h7 class="bg-success"><%=request.getSession().getAttribute("nombreEmpleado")%></h7>



                                <form  action="Sv_Logout" method="post"> 
                                    <button class="btn btn-md btn-success" type="submit">Logout</button>
                                </form>

                                <%} else { %>
                                <h7 class="bg-warning">Debe ingresar datos para iniciar sesión</h7>
                                    <%}%>
                            </div>
                        </div>   
                    </header>       

                    <nav class="navbar navbar-expand-sm navbar-light bg-light navbar-responsive"  id="mainNav">
                        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                                data-target="#navbarResponsive">
                            Menu <i class="fa fa-bars"></i>
                        </button>
                        <div id="navbarResponsive" class="navbar-collapse collapse">
                            <if class="navbar-nav ml-auto text-uppercase">


                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Empleados
                                        </a>
                                        <div class="dropdown-menu">


                                            <a class="dropdown-item bg-light" href="altaempleado.jsp">Alta de empleados</a>
                                            <form action="Sv_Consulta_Empleado" method="get"> 
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Empleado">Ver empleados</a> 

                                            </form>


                                        </div>
                                    </div>
                                </li>

                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Clientes
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altacliente.jsp">Alta de clientes</a>
                                            <form action="Sv_Consulta_Cliente" method="get">   

                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Cliente">Ver clientes</a> 

                                            </form>



                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Servicios turísticos
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altaservicioturistico.jsp">Alta de Servicios Turísticos</a>
                                            <form action="Sv_Consulta_Servicio" method="get">   
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Servicio">Ver servicios turísticos</a> 

                                            </form>


                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Paquetes turísticos
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altapaquete.jsp">Alta de Paquetes Turísticos</a>
                                            <form action="Sv_Consulta_Paquete" method="get">  
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Paquete">Ver paquetes</a> 

                                            </form>


                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="dropdown">
                                        <a type="button" class="nav-link dropdown-toggle" data-toggle="dropdown">
                                            Ventas
                                        </a>
                                        <div class="dropdown-menu">



                                            <a class="dropdown-item bg-light" href="altaventas.jsp">Alta de Ventas</a>
                                            <form action="Sv_Consulta_Ventas" method="get">   
                                                <a class="submit dropdown-item bg-light" href="Sv_Consulta_Ventas">Ver ventas</a> 

                                            </form>

                                        </div>
                                    </div>
                                </li>


                        </div>

                    </nav>  

                    <p></p>
                    <div class="card shadow-lg">
                        <div class="card-header">
                            <h7>Listados de ventas</h7>

                        </div>
                        <div class="card-body">


                            <p></p>
                            <p></p>
                            <div class="row">   

                                <div class="col-md-12">

                                    <p></p>
                                    <p></p>

                                    <div class="table-wrapper-scroll-y my-custom-scrollbar2">
                                        <table class="table table-striped ">
                                            <thead>
                                            <th class="text-center">Fecha</th>
                                            <th class="text-center">Vendedor</th>
                                            <th class="text-center">Cliente</th>
                                            <th class="text-center">Servicio/Paquete</th>
                                            <th class="text-center">Destino</th>
                                            <th class="text-center">Costo</th>

                                            <th class="text-right">Acciones</th>
                                            </thead>
                                            <tbody>



                                                <%  SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                                                    List<Venta> listaVentas2 = (List) misession.getAttribute("listaVentas");

                                                    for (Venta ven : listaVentas2) {
                                                        if (ven.isHabilitado()) {

                                                            String fechaVenta = formato.format(ven.getFecha_venta());%>

                                                <tr  class="text-center">
                                                    <td class="text-center"><%= fechaVenta%></td>
                                                    <td  class="text-center"><%= ven.getUnEmpleado().getApellido() + "," + ven.getUnEmpleado().getApellido()%></td>
                                                    <td  class="text-center"><%= ven.getUnCliente().getApellido() + "," + ven.getUnCliente().getNombre()%></td>

                                                    <% if (ven.getUnPaquete() != null) {%>
                                                        <td  class="text-center"><%= ven.getUnPaquete().getCodigo_paquete()%></td>
                                                        <td  class="text-center">--------</td>
                                                        <td  class="text-center"><%= ven.getUnPaquete().getCosto_paquete()%></td>

                                                    <%}else{%>
                                                    <%if (ven.getUnServicio() != null) {%> 
                                                        <td  class="text-center"><%= ven.getUnServicio().getNombre()%></td> 
                                                        <td class="text-center"><%= ven.getUnServicio().getDestino_servicio()%></td>
                                                        <td  class="text-center"><%= ven.getUnServicio().getCosto_servicio()%></td> 

                                                    <%}}%>

                                                    <%long id = ven.getNum_venta();%>

                                                    <td  class="text-left">
                                                        <form name="borrarVenta" action="SV_Eliminar_Venta" method="post"> 

                                                            <input type="hidden" name="id" value="<%=id%>">
                                                            <button type="submit" class="btn btn-danger btn-xs">Eliminar</button>

                                                        </form>    
                                                    </td>
                                                    <td class="text-left">
                                                        <form name="modificarVenta" action="SV_Modificar_Venta" method="post"> 
                                                            <input type="hidden" name="id"  value="<%=id%>">
                                                            <button type="submit" class="btn btn-warning btn-xs">Modificar</button>

                                                        </form>    
                                                    </td>

                                                </tr>
                                                <%}
                                                    }%>
                                            </tbody>
                                        </table>
                                    </div>

                                </div>

                                <footer class="fixed-bottom">

                                    <h6 class="bg-light" align="center">Agencia Viaje S.A. -Derechos Reservados ® 2021  - by Daniel Buzzi</h6> 

                                </footer>
                            </div>
                        </div>
                    </div>

                    <!--<script src="js/jquery.min.js"></script>
                    <script src="js/bootstrap.min.js"></script>
                    <script src="js/scripts.js"></script>-->

                </div>
            </div>
        </div>
        <%}%>
    </body>
</html> 
